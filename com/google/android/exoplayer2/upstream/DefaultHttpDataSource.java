package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Predicate;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

public class DefaultHttpDataSource extends BaseDataSource implements HttpDataSource {
    private static final Pattern CONTENT_RANGE_HEADER = null;
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8000;
    public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8000;
    private static final int HTTP_STATUS_PERMANENT_REDIRECT = 308;
    private static final int HTTP_STATUS_TEMPORARY_REDIRECT = 307;
    private static final long MAX_BYTES_TO_DRAIN = 0x800L;
    private static final int MAX_REDIRECTS = 20;
    private static final String TAG = "DefaultHttpDataSource";
    private final boolean allowCrossProtocolRedirects;
    private long bytesRead;
    private long bytesSkipped;
    private long bytesToRead;
    private long bytesToSkip;
    private final int connectTimeoutMillis;
    private HttpURLConnection connection;
    private Predicate contentTypePredicate;
    private DataSpec dataSpec;
    private final RequestProperties defaultRequestProperties;
    private InputStream inputStream;
    private boolean opened;
    private final int readTimeoutMillis;
    private final RequestProperties requestProperties;
    private int responseCode;
    private static final AtomicReference skipBufferReference;
    private final String userAgent;

    static {
        DefaultHttpDataSource.CONTENT_RANGE_HEADER = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
        DefaultHttpDataSource.skipBufferReference = new AtomicReference();
    }

    public DefaultHttpDataSource(String s) {
        this(s, 8000, 8000);
    }

    public DefaultHttpDataSource(String s, int v, int v1) {
        this(s, v, v1, false, null);
    }

    public DefaultHttpDataSource(String s, int v, int v1, boolean z, RequestProperties httpDataSource$RequestProperties0) {
        super(true);
        this.userAgent = Assertions.checkNotEmpty(s);
        this.requestProperties = new RequestProperties();
        this.connectTimeoutMillis = v;
        this.readTimeoutMillis = v1;
        this.allowCrossProtocolRedirects = z;
        this.defaultRequestProperties = httpDataSource$RequestProperties0;
    }

    @Deprecated
    public DefaultHttpDataSource(String s, Predicate predicate0) {
        this(s, predicate0, 8000, 8000);
    }

    @Deprecated
    public DefaultHttpDataSource(String s, Predicate predicate0, int v, int v1) {
        this(s, predicate0, v, v1, false, null);
    }

    @Deprecated
    public DefaultHttpDataSource(String s, Predicate predicate0, int v, int v1, boolean z, RequestProperties httpDataSource$RequestProperties0) {
        super(true);
        this.userAgent = Assertions.checkNotEmpty(s);
        this.contentTypePredicate = predicate0;
        this.requestProperties = new RequestProperties();
        this.connectTimeoutMillis = v;
        this.readTimeoutMillis = v1;
        this.allowCrossProtocolRedirects = z;
        this.defaultRequestProperties = httpDataSource$RequestProperties0;
    }

    public final long bytesRead() {
        return this.bytesRead;
    }

    public final long bytesRemaining() {
        return this.bytesToRead == -1L ? -1L : this.bytesToRead - this.bytesRead;
    }

    public final long bytesSkipped() {
        return this.bytesSkipped;
    }

    @Override  // com.google.android.exoplayer2.upstream.HttpDataSource
    public void clearAllRequestProperties() {
        this.requestProperties.clear();
    }

    @Override  // com.google.android.exoplayer2.upstream.HttpDataSource
    public void clearRequestProperty(String s) {
        Assertions.checkNotNull(s);
        this.requestProperties.remove(s);
    }

    @Override  // com.google.android.exoplayer2.upstream.HttpDataSource, com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        try {
            if(this.inputStream != null) {
                DefaultHttpDataSource.maybeTerminateInputStream(this.connection, this.bytesRemaining());
                try {
                    this.inputStream.close();
                }
                catch(IOException iOException0) {
                    throw new HttpDataSourceException(iOException0, this.dataSpec, 3);
                }
            }
        }
        finally {
            this.inputStream = null;
            this.closeConnectionQuietly();
            if(this.opened) {
                this.opened = false;
                this.transferEnded();
            }
        }
    }

    private void closeConnectionQuietly() {
        HttpURLConnection httpURLConnection0 = this.connection;
        if(httpURLConnection0 != null) {
            try {
                httpURLConnection0.disconnect();
            }
            catch(Exception exception0) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", exception0);
            }
            this.connection = null;
        }
    }

    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    private static long getContentLength(HttpURLConnection httpURLConnection0) {
        long v;
        String s = httpURLConnection0.getHeaderField("Content-Length");
        if(TextUtils.isEmpty(s)) {
            v = -1L;
        }
        else {
            try {
                v = Long.parseLong(s);
            }
            catch(NumberFormatException unused_ex) {
                Log.e("DefaultHttpDataSource", "Unexpected Content-Length [" + s + "]");
                v = -1L;
            }
        }
        String s1 = httpURLConnection0.getHeaderField("Content-Range");
        if(!TextUtils.isEmpty(s1)) {
            Matcher matcher0 = DefaultHttpDataSource.CONTENT_RANGE_HEADER.matcher(s1);
            if(matcher0.find()) {
                try {
                    long v1 = Long.parseLong(matcher0.group(2)) - Long.parseLong(matcher0.group(1)) + 1L;
                    if(v < 0L) {
                        return v1;
                    }
                    if(v != v1) {
                        Log.w("DefaultHttpDataSource", "Inconsistent headers [" + s + "] [" + s1 + "]");
                        return Math.max(v, v1);
                    }
                }
                catch(NumberFormatException unused_ex) {
                    Log.e("DefaultHttpDataSource", "Unexpected Content-Range [" + s1 + "]");
                }
            }
        }
        return v;
    }

    @Override  // com.google.android.exoplayer2.upstream.HttpDataSource
    public int getResponseCode() {
        if(this.connection != null) {
            return this.responseCode <= 0 ? -1 : this.responseCode;
        }
        return -1;
    }

    @Override  // com.google.android.exoplayer2.upstream.HttpDataSource, com.google.android.exoplayer2.upstream.DataSource
    public Map getResponseHeaders() {
        return this.connection == null ? Collections.EMPTY_MAP : this.connection.getHeaderFields();
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.connection == null ? null : Uri.parse(this.connection.getURL().toString());
    }

    private static URL handleRedirect(URL uRL0, String s) {
        if(s == null) {
            throw new ProtocolException("Null location redirect");
        }
        URL uRL1 = new URL(uRL0, s);
        String s1 = uRL1.getProtocol();
        if(!"https".equals(s1) && !"http".equals(s1)) {
            String s2 = String.valueOf(s1);
            throw new ProtocolException((s2.length() == 0 ? new String("Unsupported protocol redirect: ") : "Unsupported protocol redirect: " + s2));
        }
        return uRL1;
    }

    private static boolean isCompressed(HttpURLConnection httpURLConnection0) {
        return "gzip".equalsIgnoreCase(httpURLConnection0.getHeaderField("Content-Encoding"));
    }

    private HttpURLConnection makeConnection(DataSpec dataSpec0) {
        URL uRL1;
        URL uRL0 = new URL(dataSpec0.uri.toString());
        int v = dataSpec0.httpMethod;
        byte[] arr_b = dataSpec0.httpBody;
        long v1 = dataSpec0.position;
        long v2 = dataSpec0.length;
        boolean z = dataSpec0.isFlagSet(1);
        if(!this.allowCrossProtocolRedirects) {
            return this.makeConnection(uRL0, v, arr_b, v1, v2, z, true, dataSpec0.httpRequestHeaders);
        }
        int v3 = 0;
        while(v3 <= 20) {
            HttpURLConnection httpURLConnection0 = this.makeConnection(uRL0, v, arr_b, v1, v2, z, false, dataSpec0.httpRequestHeaders);
            int v4 = v;
            int v5 = httpURLConnection0.getResponseCode();
            String s = httpURLConnection0.getHeaderField("Location");
            if((v4 == 1 || v4 == 3) && (v5 == 300 || v5 == 301 || (v5 == 302 || v5 == 303 || v5 == 307 || v5 == 308))) {
                httpURLConnection0.disconnect();
                uRL1 = DefaultHttpDataSource.handleRedirect(uRL0, s);
            }
            else {
                if(v4 == 2 && (v5 == 300 || v5 == 301 || v5 == 302 || v5 == 303)) {
                    httpURLConnection0.disconnect();
                    uRL1 = DefaultHttpDataSource.handleRedirect(uRL0, s);
                    arr_b = null;
                    v4 = 1;
                    goto label_24;
                }
                return httpURLConnection0;
            }
        label_24:
            ++v3;
            uRL0 = uRL1;
            v = v4;
        }
        throw new NoRouteToHostException("Too many redirects: " + (v3 + 1));
    }

    private HttpURLConnection makeConnection(URL uRL0, int v, byte[] arr_b, long v1, long v2, boolean z, boolean z1, Map map0) {
        HttpURLConnection httpURLConnection0 = this.openConnection(uRL0);
        httpURLConnection0.setConnectTimeout(this.connectTimeoutMillis);
        httpURLConnection0.setReadTimeout(this.readTimeoutMillis);
        HashMap hashMap0 = new HashMap();
        RequestProperties httpDataSource$RequestProperties0 = this.defaultRequestProperties;
        if(httpDataSource$RequestProperties0 != null) {
            hashMap0.putAll(httpDataSource$RequestProperties0.getSnapshot());
        }
        hashMap0.putAll(this.requestProperties.getSnapshot());
        hashMap0.putAll(map0);
        for(Object object0: hashMap0.entrySet()) {
            httpURLConnection0.setRequestProperty(((String)((Map.Entry)object0).getKey()), ((String)((Map.Entry)object0).getValue()));
        }
        if(Long.compare(v1, 0L) != 0 || v2 != -1L) {
            httpURLConnection0.setRequestProperty("Range", (v2 == -1L ? "bytes=" + v1 + "-" : "bytes=" + v1 + "-" + (v1 + v2 - 1L)));
        }
        httpURLConnection0.setRequestProperty("User-Agent", this.userAgent);
        httpURLConnection0.setRequestProperty("Accept-Encoding", (z ? "gzip" : "identity"));
        httpURLConnection0.setInstanceFollowRedirects(z1);
        httpURLConnection0.setDoOutput(arr_b != null);
        httpURLConnection0.setRequestMethod(DataSpec.getStringForHttpMethod(v));
        if(arr_b != null) {
            httpURLConnection0.setFixedLengthStreamingMode(arr_b.length);
            httpURLConnection0.connect();
            OutputStream outputStream0 = httpURLConnection0.getOutputStream();
            outputStream0.write(arr_b);
            outputStream0.close();
            return httpURLConnection0;
        }
        httpURLConnection0.connect();
        return httpURLConnection0;
    }

    private static void maybeTerminateInputStream(HttpURLConnection httpURLConnection0, long v) {
        if(Util.SDK_INT == 19 || Util.SDK_INT == 20) {
            try {
                InputStream inputStream0 = httpURLConnection0.getInputStream();
                if(v == -1L) {
                    if(inputStream0.read() != -1) {
                        goto label_6;
                    }
                }
                else if(v > 0x800L) {
                label_6:
                    String s = inputStream0.getClass().getName();
                    if("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(s) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(s)) {
                        Method method0 = inputStream0.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", null);
                        method0.setAccessible(true);
                        method0.invoke(inputStream0, null);
                    }
                }
            }
            catch(Exception unused_ex) {
            }
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.HttpDataSource, com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec0) {
        String s;
        HttpURLConnection httpURLConnection0;
        this.dataSpec = dataSpec0;
        long v = 0L;
        this.bytesRead = 0L;
        this.bytesSkipped = 0L;
        this.transferInitializing(dataSpec0);
        try {
            httpURLConnection0 = this.makeConnection(dataSpec0);
            this.connection = httpURLConnection0;
        }
        catch(IOException iOException0) {
            throw new HttpDataSourceException("Unable to connect", iOException0, dataSpec0, 1);
        }
        try {
            this.responseCode = httpURLConnection0.getResponseCode();
            s = this.connection.getResponseMessage();
        }
        catch(IOException iOException1) {
            this.closeConnectionQuietly();
            throw new HttpDataSourceException("Unable to connect", iOException1, dataSpec0, 1);
        }
        if(this.responseCode >= 200 && this.responseCode <= 299) {
            String s1 = this.connection.getContentType();
            if(this.contentTypePredicate != null && !this.contentTypePredicate.evaluate(s1)) {
                this.closeConnectionQuietly();
                throw new InvalidContentTypeException(s1, dataSpec0);
            }
            if(this.responseCode == 200) {
                long v1 = dataSpec0.position;
                if(v1 != 0L) {
                    v = v1;
                }
            }
            this.bytesToSkip = v;
            boolean z = DefaultHttpDataSource.isCompressed(this.connection);
            if(z) {
                this.bytesToRead = dataSpec0.length;
            }
            else {
                long v2 = dataSpec0.length;
                long v3 = -1L;
                if(v2 == -1L) {
                    long v4 = DefaultHttpDataSource.getContentLength(this.connection);
                    if(v4 != -1L) {
                        v3 = v4 - this.bytesToSkip;
                    }
                    this.bytesToRead = v3;
                }
                else {
                    this.bytesToRead = v2;
                }
            }
            try {
                this.inputStream = this.connection.getInputStream();
                if(z) {
                    this.inputStream = new GZIPInputStream(this.inputStream);
                }
            }
            catch(IOException iOException2) {
                this.closeConnectionQuietly();
                throw new HttpDataSourceException(iOException2, dataSpec0, 1);
            }
            this.opened = true;
            this.transferStarted(dataSpec0);
            return this.bytesToRead;
        }
        Map map0 = this.connection.getHeaderFields();
        this.closeConnectionQuietly();
        InvalidResponseCodeException httpDataSource$InvalidResponseCodeException0 = new InvalidResponseCodeException(this.responseCode, s, map0, dataSpec0);
        if(this.responseCode == 0x1A0) {
            httpDataSource$InvalidResponseCodeException0.initCause(new DataSourceException(0));
        }
        throw httpDataSource$InvalidResponseCodeException0;
    }

    public HttpURLConnection openConnection(URL uRL0) {
        return (HttpURLConnection)uRL0.openConnection();
    }

    @Override  // com.google.android.exoplayer2.upstream.HttpDataSource, com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] arr_b, int v, int v1) {
        try {
            this.skipInternal();
            return this.readInternal(arr_b, v, v1);
        }
        catch(IOException iOException0) {
            throw new HttpDataSourceException(iOException0, this.dataSpec, 2);
        }
    }

    private int readInternal(byte[] arr_b, int v, int v1) {
        if(v1 == 0) {
            return 0;
        }
        long v2 = this.bytesToRead;
        if(Long.compare(v2, -1L) != 0) {
            long v3 = v2 - this.bytesRead;
            if(v3 == 0L) {
                return -1;
            }
            v1 = (int)Math.min(v1, v3);
        }
        int v4 = this.inputStream.read(arr_b, v, v1);
        if(v4 == -1) {
            if(this.bytesToRead != -1L) {
                throw new EOFException();
            }
            return -1;
        }
        this.bytesRead += (long)v4;
        this.bytesTransferred(v4);
        return v4;
    }

    public void setContentTypePredicate(Predicate predicate0) {
        this.contentTypePredicate = predicate0;
    }

    @Override  // com.google.android.exoplayer2.upstream.HttpDataSource
    public void setRequestProperty(String s, String s1) {
        Assertions.checkNotNull(s);
        Assertions.checkNotNull(s1);
        this.requestProperties.set(s, s1);
    }

    private void skipInternal() {
        if(this.bytesSkipped == this.bytesToSkip) {
            return;
        }
        byte[] arr_b = (byte[])DefaultHttpDataSource.skipBufferReference.getAndSet(null);
        if(arr_b == null) {
            arr_b = new byte[0x1000];
        }
        while(true) {
            long v = this.bytesSkipped;
            long v1 = this.bytesToSkip;
            if(v == v1) {
                DefaultHttpDataSource.skipBufferReference.set(arr_b);
                return;
            }
            int v2 = this.inputStream.read(arr_b, 0, ((int)Math.min(v1 - v, arr_b.length)));
            if(Thread.currentThread().isInterrupted()) {
                throw new InterruptedIOException();
            }
            if(v2 == -1) {
                break;
            }
            this.bytesSkipped += (long)v2;
            this.bytesTransferred(v2);
        }
        throw new EOFException();
    }
}

