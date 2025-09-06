package g3;

import I6.u0;
import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.zip.GZIPInputStream;
import k8.Y;

public final class n extends b {
    public final int e;
    public final int f;
    public final String g;
    public final x9.b h;
    public final x9.b i;
    public j j;
    public HttpURLConnection k;
    public InputStream l;
    public boolean m;
    public int n;
    public long o;
    public long r;

    public n(String s, int v, int v1, x9.b b0) {
        super(true);
        this.g = s;
        this.e = v;
        this.f = v1;
        this.h = b0;
        this.i = new x9.b(8);
    }

    @Override  // g3.f
    public final void close() {
        try {
            InputStream inputStream0 = this.l;
            if(inputStream0 != null) {
                try {
                    inputStream0.close();
                }
                catch(IOException iOException0) {
                    throw new r(2000, 3, iOException0);
                }
            }
        }
        finally {
            this.l = null;
            this.e();
            if(this.m) {
                this.m = false;
                this.b();
            }
            this.k = null;
            this.j = null;
        }
    }

    public final void e() {
        HttpURLConnection httpURLConnection0 = this.k;
        if(httpURLConnection0 != null) {
            try {
                httpURLConnection0.disconnect();
            }
            catch(Exception exception0) {
                e3.b.q("DefaultHttpDataSource", "Unexpected error while disconnecting", exception0);
            }
        }
    }

    public final HttpURLConnection f(URL uRL0, int v, byte[] arr_b, long v1, long v2, boolean z, boolean z1, Map map0) {
        String s2;
        String s;
        HttpURLConnection httpURLConnection0 = (HttpURLConnection)uRL0.openConnection();
        httpURLConnection0.setConnectTimeout(this.e);
        httpURLConnection0.setReadTimeout(this.f);
        HashMap hashMap0 = new HashMap();
        x9.b b0 = this.h;
        if(b0 != null) {
            hashMap0.putAll(b0.s());
        }
        hashMap0.putAll(this.i.s());
        hashMap0.putAll(map0);
        for(Object object0: hashMap0.entrySet()) {
            httpURLConnection0.setRequestProperty(((String)((Map.Entry)object0).getKey()), ((String)((Map.Entry)object0).getValue()));
        }
        if(Long.compare(v1, 0L) != 0 || v2 != -1L) {
            StringBuilder stringBuilder0 = Y.o(v1, "bytes=", "-");
            if(v2 != -1L) {
                stringBuilder0.append(v1 + v2 - 1L);
            }
            s = stringBuilder0.toString();
        }
        else {
            s = null;
        }
        if(s != null) {
            httpURLConnection0.setRequestProperty("Range", s);
        }
        String s1 = this.g;
        if(s1 != null) {
            httpURLConnection0.setRequestProperty("User-Agent", s1);
        }
        httpURLConnection0.setRequestProperty("Accept-Encoding", (z ? "gzip" : "identity"));
        httpURLConnection0.setInstanceFollowRedirects(z1);
        httpURLConnection0.setDoOutput(arr_b != null);
        switch(v) {
            case 1: {
                s2 = "GET";
                break;
            }
            case 2: {
                s2 = "POST";
                break;
            }
            case 3: {
                s2 = "HEAD";
                break;
            }
            default: {
                throw new IllegalStateException();
            }
        }
        httpURLConnection0.setRequestMethod(s2);
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

    public final void g(long v) {
        if(v != 0L) {
            while(v > 0L) {
                int v1 = this.l.read(new byte[0x1000], 0, ((int)Math.min(v, 0x1000L)));
                if(Thread.currentThread().isInterrupted()) {
                    throw new r(2000, 1, new InterruptedIOException());
                }
                if(v1 == -1) {
                    throw new r();
                }
                v -= (long)v1;
                this.a(v1);
            }
        }
    }

    @Override  // g3.f
    public final Map getResponseHeaders() {
        HttpURLConnection httpURLConnection0 = this.k;
        return httpURLConnection0 == null ? u0.g : new m(httpURLConnection0.getHeaderFields());
    }

    @Override  // g3.f
    public final Uri getUri() {
        HttpURLConnection httpURLConnection0 = this.k;
        if(httpURLConnection0 != null) {
            return Uri.parse(httpURLConnection0.getURL().toString());
        }
        return this.j == null ? null : this.j.a;
    }

    @Override  // g3.f
    public final long p(j j0) {
        long v5;
        long v2;
        long v1;
        long v;
        HttpURLConnection httpURLConnection0;
        this.j = j0;
        this.r = 0L;
        this.o = 0L;
        this.c();
        try {
            httpURLConnection0 = this.f(new URL(j0.a.toString()), j0.b, j0.c, j0.e, j0.f, (j0.h & 1) == 1, true, j0.d);
            v = j0.e;
            v1 = j0.f;
            this.k = httpURLConnection0;
            this.n = httpURLConnection0.getResponseCode();
            httpURLConnection0.getResponseMessage();
        }
        catch(IOException iOException0) {
            this.e();
            throw r.a(1, iOException0);
        }
        if(this.n >= 200 && this.n <= 299) {
            httpURLConnection0.getContentType();
            if(this.n != 200 || v == 0L) {
                v = 0L;
            }
            boolean z = "gzip".equalsIgnoreCase(httpURLConnection0.getHeaderField("Content-Encoding"));
            if(z) {
                this.o = v1;
            }
            else if(v1 != -1L) {
                this.o = v1;
            }
            else {
                String s = httpURLConnection0.getHeaderField("Content-Length");
                String s1 = httpURLConnection0.getHeaderField("Content-Range");
                if(TextUtils.isEmpty(s)) {
                    v2 = -1L;
                }
                else {
                    try {
                        v2 = Long.parseLong(s);
                    }
                    catch(NumberFormatException unused_ex) {
                        e3.b.p("HttpUtil", "Unexpected Content-Length [" + s + "]");
                        v2 = -1L;
                    }
                }
                if(!TextUtils.isEmpty(s1)) {
                    Matcher matcher0 = u.a.matcher(s1);
                    if(matcher0.matches()) {
                        try {
                            String s2 = matcher0.group(2);
                            s2.getClass();
                            long v3 = Long.parseLong(s2);
                            String s3 = matcher0.group(1);
                            s3.getClass();
                            long v4 = v3 - Long.parseLong(s3) + 1L;
                            if(v2 < 0L) {
                                v2 = v4;
                            }
                            else if(v2 != v4) {
                                e3.b.D("HttpUtil", "Inconsistent headers [" + s + "] [" + s1 + "]");
                                v2 = Math.max(v2, v4);
                            }
                        }
                        catch(NumberFormatException unused_ex) {
                            e3.b.p("HttpUtil", "Unexpected Content-Range [" + s1 + "]");
                        }
                    }
                }
                this.o = v2 == -1L ? -1L : v2 - v;
            }
            try {
                this.l = httpURLConnection0.getInputStream();
                if(z) {
                    this.l = new GZIPInputStream(this.l);
                }
            }
            catch(IOException iOException1) {
                this.e();
                throw new r(2000, 1, iOException1);
            }
            this.m = true;
            this.d(j0);
            try {
                this.g(v);
                return this.o;
            }
            catch(IOException iOException2) {
                this.e();
                throw iOException2 instanceof r ? ((r)iOException2) : new r(2000, 1, iOException2);
            }
        }
        Map map0 = httpURLConnection0.getHeaderFields();
        if(this.n == 0x1A0) {
            String s4 = httpURLConnection0.getHeaderField("Content-Range");
            if(TextUtils.isEmpty(s4)) {
                v5 = -1L;
            }
            else {
                Matcher matcher1 = u.b.matcher(s4);
                if(matcher1.matches()) {
                    String s5 = matcher1.group(1);
                    s5.getClass();
                    v5 = Long.parseLong(s5);
                }
                else {
                    v5 = -1L;
                }
            }
            if(v == v5) {
                this.m = true;
                this.d(j0);
                return v1 == -1L ? 0L : v1;
            }
        }
        InputStream inputStream0 = httpURLConnection0.getErrorStream();
        if(inputStream0 != null) {
            try {
                J6.b.b(inputStream0);
            }
            catch(IOException unused_ex) {
            }
        }
        this.e();
        g g0 = this.n == 0x1A0 ? new g(2008) : null;
        throw new t(this.n, g0, map0);
    }

    @Override  // b3.j
    public final int read(byte[] arr_b, int v, int v1) {
        if(v1 == 0) {
            return 0;
        }
        try {
            long v2 = this.o;
            if(Long.compare(v2, -1L) != 0) {
                long v3 = v2 - this.r;
                if(v3 == 0L) {
                    return -1;
                }
                v1 = (int)Math.min(v1, v3);
            }
            int v4 = this.l.read(arr_b, v, v1);
            if(v4 == -1) {
                return -1;
            }
            this.r += (long)v4;
            this.a(v4);
            return v4;
        }
        catch(IOException iOException0) {
            throw r.a(2, iOException0);
        }
    }
}

