package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map.Entry;
import java.util.Map;

public class HttpUrlFetcher implements DataFetcher {
    static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
        @Override  // com.bumptech.glide.load.data.HttpUrlFetcher$HttpUrlConnectionFactory
        public HttpURLConnection build(URL uRL0) {
            return (HttpURLConnection)uRL0.openConnection();
        }
    }

    interface HttpUrlConnectionFactory {
        HttpURLConnection build(URL arg1);
    }

    static final HttpUrlConnectionFactory DEFAULT_CONNECTION_FACTORY = null;
    static final int INVALID_STATUS_CODE = -1;
    private static final int MAXIMUM_REDIRECTS = 5;
    static final String REDIRECT_HEADER_FIELD = "Location";
    private static final String TAG = "HttpUrlFetcher";
    private final HttpUrlConnectionFactory connectionFactory;
    private final GlideUrl glideUrl;
    private volatile boolean isCancelled;
    private InputStream stream;
    private final int timeout;
    private HttpURLConnection urlConnection;

    static {
        HttpUrlFetcher.DEFAULT_CONNECTION_FACTORY = new DefaultHttpUrlConnectionFactory();
    }

    public HttpUrlFetcher(GlideUrl glideUrl0, int v) {
        this(glideUrl0, v, HttpUrlFetcher.DEFAULT_CONNECTION_FACTORY);
    }

    public HttpUrlFetcher(GlideUrl glideUrl0, int v, HttpUrlConnectionFactory httpUrlFetcher$HttpUrlConnectionFactory0) {
        this.glideUrl = glideUrl0;
        this.timeout = v;
        this.connectionFactory = httpUrlFetcher$HttpUrlConnectionFactory0;
    }

    private HttpURLConnection buildAndConfigureConnection(URL uRL0, Map map0) {
        HttpURLConnection httpURLConnection0;
        try {
            httpURLConnection0 = this.connectionFactory.build(uRL0);
        }
        catch(IOException iOException0) {
            throw new HttpException("URL.openConnection threw", 0, iOException0);
        }
        for(Object object0: map0.entrySet()) {
            httpURLConnection0.addRequestProperty(((String)((Map.Entry)object0).getKey()), ((String)((Map.Entry)object0).getValue()));
        }
        httpURLConnection0.setConnectTimeout(this.timeout);
        httpURLConnection0.setReadTimeout(this.timeout);
        httpURLConnection0.setUseCaches(false);
        httpURLConnection0.setDoInput(true);
        httpURLConnection0.setInstanceFollowRedirects(false);
        return httpURLConnection0;
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        this.isCancelled = true;
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        InputStream inputStream0 = this.stream;
        if(inputStream0 != null) {
            try {
                inputStream0.close();
            }
            catch(IOException unused_ex) {
            }
        }
        HttpURLConnection httpURLConnection0 = this.urlConnection;
        if(httpURLConnection0 != null) {
            httpURLConnection0.disconnect();
        }
        this.urlConnection = null;
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher
    public Class getDataClass() {
        return InputStream.class;
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    private static int getHttpStatusCodeOrInvalid(HttpURLConnection httpURLConnection0) {
        try {
            return httpURLConnection0.getResponseCode();
        }
        catch(IOException iOException0) {
            if(Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to get a response code", iOException0);
            }
            return -1;
        }
    }

    private InputStream getStreamForSuccessfulRequest(HttpURLConnection httpURLConnection0) {
        try {
            if(TextUtils.isEmpty(httpURLConnection0.getContentEncoding())) {
                int v = httpURLConnection0.getContentLength();
                this.stream = ContentLengthInputStream.obtain(httpURLConnection0.getInputStream(), ((long)v));
                return this.stream;
            }
            if(Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection0.getContentEncoding());
            }
            this.stream = httpURLConnection0.getInputStream();
            return this.stream;
        }
        catch(IOException iOException0) {
        }
        throw new HttpException("Failed to obtain InputStream", HttpUrlFetcher.getHttpStatusCodeOrInvalid(httpURLConnection0), iOException0);
    }

    private static boolean isHttpOk(int v) {
        return v / 100 == 2;
    }

    private static boolean isHttpRedirect(int v) {
        return v / 100 == 3;
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher
    public void loadData(Priority priority0, DataCallback dataFetcher$DataCallback0) {
        long v = LogTime.getLogTime();
        try {
            try {
                dataFetcher$DataCallback0.onDataReady(this.loadDataWithRedirects(this.glideUrl.toURL(), 0, null, this.glideUrl.getHeaders()));
                goto label_14;
            }
            catch(IOException iOException0) {
            }
            if(Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to load data for url", iOException0);
            }
            dataFetcher$DataCallback0.onLoadFailed(iOException0);
        }
        catch(Throwable throwable0) {
            goto label_11;
        }
        if(Log.isLoggable("HttpUrlFetcher", 2)) {
            Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + LogTime.getElapsedMillis(v));
            return;
        label_11:
            if(Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + LogTime.getElapsedMillis(v));
            }
            throw throwable0;
        label_14:
            if(Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + LogTime.getElapsedMillis(v));
            }
        }
    }

    private InputStream loadDataWithRedirects(URL uRL0, int v, URL uRL1, Map map0) {
        URL uRL2;
        if(v < 5) {
            if(uRL1 != null) {
                try {
                    if(uRL0.toURI().equals(uRL1.toURI())) {
                        throw new HttpException("In re-direct loop", -1);
                    }
                }
                catch(URISyntaxException unused_ex) {
                }
            }
            HttpURLConnection httpURLConnection0 = this.buildAndConfigureConnection(uRL0, map0);
            this.urlConnection = httpURLConnection0;
            try {
                httpURLConnection0.connect();
                this.stream = this.urlConnection.getInputStream();
            }
            catch(IOException iOException0) {
                throw new HttpException("Failed to connect or obtain data", HttpUrlFetcher.getHttpStatusCodeOrInvalid(this.urlConnection), iOException0);
            }
            if(this.isCancelled) {
                return null;
            }
            int v1 = HttpUrlFetcher.getHttpStatusCodeOrInvalid(this.urlConnection);
            if(HttpUrlFetcher.isHttpOk(v1)) {
                return this.getStreamForSuccessfulRequest(this.urlConnection);
            }
            if(HttpUrlFetcher.isHttpRedirect(v1)) {
                String s = this.urlConnection.getHeaderField("Location");
                if(TextUtils.isEmpty(s)) {
                    throw new HttpException("Received empty or null redirect url", v1);
                }
                try {
                    uRL2 = new URL(uRL0, s);
                }
                catch(MalformedURLException malformedURLException0) {
                    throw new HttpException("Bad redirect url: " + s, v1, malformedURLException0);
                }
                this.cleanup();
                return this.loadDataWithRedirects(uRL2, v + 1, uRL0, map0);
            }
            if(v1 == -1) {
                throw new HttpException(-1);
            }
            try {
                throw new HttpException(this.urlConnection.getResponseMessage(), v1);
            }
            catch(IOException iOException1) {
                throw new HttpException("Failed to get a response message", v1, iOException1);
            }
        }
        throw new HttpException("Too many (> 5) redirects!", -1);
    }
}

