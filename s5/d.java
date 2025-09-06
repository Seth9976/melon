package s5;

import Tf.v;
import ie.j;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.q;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import x5.n;

public final class d {
    public final Request a;
    public final b b;
    public final Date c;
    public final String d;
    public final Date e;
    public final String f;
    public final Date g;
    public final long h;
    public final long i;
    public final String j;
    public final int k;

    public d(Request request0, b b0) {
        int v3;
        this.a = request0;
        this.b = b0;
        this.k = -1;
        if(b0 != null) {
            this.h = b0.c;
            this.i = b0.d;
            Headers headers0 = b0.f;
            int v = headers0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                String s = headers0.name(v1);
                if(v.j0(s, "Date", true)) {
                    this.c = headers0.getDate("Date");
                    this.d = headers0.value(v1);
                }
                else if(v.j0(s, "Expires", true)) {
                    this.g = headers0.getDate("Expires");
                }
                else if(v.j0(s, "Last-Modified", true)) {
                    this.e = headers0.getDate("Last-Modified");
                    this.f = headers0.value(v1);
                }
                else if(v.j0(s, "ETag", true)) {
                    this.j = headers0.value(v1);
                }
                else if(v.j0(s, "Age", true)) {
                    Long long0 = v.u0(headers0.value(v1));
                    if(long0 == null) {
                        v3 = -1;
                    }
                    else {
                        long v2 = (long)long0;
                        if(v2 > 0x7FFFFFFFL) {
                            v3 = 0x7FFFFFFF;
                        }
                        else if(v2 < 0L) {
                            v3 = 0;
                        }
                        else {
                            v3 = (int)v2;
                        }
                    }
                    this.k = v3;
                }
            }
        }
    }

    public final e a() {
        CacheControl cacheControl3;
        long v6;
        long v2;
        long v1;
        Request request0 = this.a;
        b b0 = this.b;
        if(b0 == null) {
            return new e(request0, null);
        }
        Object object0 = b0.a;
        if(request0.isHttps() && !b0.e) {
            return new e(request0, null);
        }
        CacheControl cacheControl0 = (CacheControl)((j)object0).getValue();
        if(!request0.cacheControl().noStore() && !((CacheControl)((j)object0).getValue()).noStore() && !q.b(b0.f.get("Vary"), "*")) {
            CacheControl cacheControl1 = request0.cacheControl();
            if(!cacheControl1.noCache() && request0.header("If-Modified-Since") == null && request0.header("If-None-Match") == null) {
                long v = this.i;
                Date date0 = this.c;
                v1 = date0 == null ? 0L : Math.max(0L, v - date0.getTime());
                v2 = 0L;
                int v3 = this.k;
                if(v3 != -1) {
                    v1 = Math.max(v1, TimeUnit.SECONDS.toMillis(((long)v3)));
                }
                long v4 = this.h;
                long v5 = v1 + (v - v4) + (((Number)n.a.invoke()).longValue() - v);
                CacheControl cacheControl2 = (CacheControl)((j)object0).getValue();
                Date date1 = this.e;
                if(cacheControl2.maxAgeSeconds() == -1) {
                    Date date2 = this.g;
                    if(date2 != null) {
                        if(date0 != null) {
                            v = date0.getTime();
                        }
                        v6 = date2.getTime() - v;
                        if(v6 <= 0L) {
                            v6 = 0L;
                        }
                    }
                    else if(date1 == null || request0.url().query() != null) {
                        v6 = 0L;
                    }
                    else {
                        if(date0 != null) {
                            v4 = date0.getTime();
                        }
                        long v7 = v4 - date1.getTime();
                        v6 = v7 > 0L ? v7 / 10L : 0L;
                    }
                }
                else {
                    v6 = TimeUnit.SECONDS.toMillis(((long)cacheControl2.maxAgeSeconds()));
                }
                if(cacheControl1.maxAgeSeconds() != -1) {
                    v6 = Math.min(v6, TimeUnit.SECONDS.toMillis(((long)cacheControl1.maxAgeSeconds())));
                }
                long v8 = cacheControl1.minFreshSeconds() == -1 ? 0L : TimeUnit.SECONDS.toMillis(((long)cacheControl1.minFreshSeconds()));
                if(cacheControl0.mustRevalidate() || cacheControl1.maxStaleSeconds() == -1) {
                    cacheControl3 = cacheControl0;
                }
                else {
                    cacheControl3 = cacheControl0;
                    v2 = TimeUnit.SECONDS.toMillis(((long)cacheControl1.maxStaleSeconds()));
                }
                if(!cacheControl3.noCache() && v5 + v8 < v6 + v2) {
                    return new e(null, b0);
                }
                String s = this.j;
                if(s != null) {
                    return new e(request0.newBuilder().addHeader("If-None-Match", s).build(), b0);
                }
                if(date1 != null) {
                    q.d(this.f);
                    return new e(request0.newBuilder().addHeader("If-Modified-Since", this.f).build(), b0);
                }
                if(date0 != null) {
                    q.d(this.d);
                    return new e(request0.newBuilder().addHeader("If-Modified-Since", this.d).build(), b0);
                }
                return new e(request0, null);
            }
            return new e(request0, null);
        }
        return new e(request0, null);
    }
}

