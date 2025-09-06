package i.n.i.b.a.s.e;

import android.net.Uri;
import d5.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import okhttp3.Call.Factory;
import okhttp3.HttpUrl;
import okhttp3.Request.Builder;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class ge extends Kb implements j8 {
    public final Factory e;
    public final e f;
    public final String g;
    public final e h;
    public W2 i;
    public Response j;
    public InputStream k;
    public boolean l;
    public long m;
    public long n;

    static {
        pa.a("goog.exo.okhttp");
    }

    public ge(Factory call$Factory0, String s, e e0) {
        super(true);
        call$Factory0.getClass();
        this.e = call$Factory0;
        this.g = s;
        this.h = e0;
        this.f = new e(11);
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final long b(W2 w20) {
        byte[] arr_b1;
        ResponseBody responseBody0;
        Response response0;
        this.i = w20;
        this.n = 0L;
        this.m = 0L;
        this.c(w20);
        long v = w20.f;
        int v1 = w20.c;
        long v2 = w20.g;
        HttpUrl httpUrl0 = HttpUrl.parse(w20.b.toString());
        if(httpUrl0 == null) {
            throw new g8("Malformed URL", w20);
        }
        Builder request$Builder0 = new Builder().url(httpUrl0);
        HashMap hashMap0 = new HashMap();
        e e0 = this.h;
        if(e0 != null) {
            hashMap0.putAll(e0.g());
        }
        hashMap0.putAll(this.f.g());
        hashMap0.putAll(w20.e);
        for(Object object0: hashMap0.entrySet()) {
            request$Builder0.header(((String)((Map.Entry)object0).getKey()), ((String)((Map.Entry)object0).getValue()));
        }
        String s = a9.b(v, v2);
        if(s != null) {
            request$Builder0.addHeader("Range", s);
        }
        String s1 = this.g;
        if(s1 != null) {
            request$Builder0.addHeader("User-Agent", s1);
        }
        if((w20.i & 1) != 1) {
            request$Builder0.addHeader("Accept-Encoding", "identity");
        }
        byte[] arr_b = w20.d;
        RequestBody requestBody0 = null;
        if(arr_b != null) {
            requestBody0 = RequestBody.create(null, arr_b);
        }
        else if(v1 == 2) {
            requestBody0 = RequestBody.create(null, L7.g);
        }
        request$Builder0.method(W2.c(v1), requestBody0);
        Request request0 = request$Builder0.build();
        try {
            response0 = this.e.newCall(request0).execute();
            this.j = response0;
            responseBody0 = response0.body();
            responseBody0.getClass();
            this.k = responseBody0.byteStream();
        }
        catch(IOException iOException0) {
            String s2 = iOException0.getMessage();
            if(!(s2 == null || !M7.j(s2).matches("cleartext communication.*not permitted.*"))) {
                throw new e8(iOException0, w20);
            }
            throw new g8("Unable to connect", iOException0, w20);
        }
        int v3 = response0.code();
        long v4 = -1L;
        if(!response0.isSuccessful()) {
            if(v3 == 0x1A0 && v == a9.a(response0.headers().get("Content-Range"))) {
                this.l = true;
                this.d(w20);
                return v2 == -1L ? 0L : v2;
            }
            try {
                InputStream inputStream0 = this.k;
                inputStream0.getClass();
                arr_b1 = L7.r(inputStream0);
            }
            catch(IOException unused_ex) {
                arr_b1 = L7.g;
            }
            Map map0 = response0.headers().toMultimap();
            this.i();
            i8 i80 = new i8(v3, map0, w20, arr_b1);
            if(v3 == 0x1A0) {
                i80.initCause(new y1());  // 初始化器: Ljava/io/IOException;-><init>()V
            }
            throw i80;
        }
        boolean z = responseBody0.contentType() == null;
        if(v3 != 200 || v == 0L) {
            v = 0L;
        }
        if(v2 == -1L) {
            long v5 = responseBody0.contentLength();
            if(v5 != -1L) {
                v4 = v5 - v;
            }
            this.m = v4;
        }
        else {
            this.m = v2;
        }
        this.l = true;
        this.d(w20);
        if(v == 0L) {
            goto label_89;
        }
        else {
            try {
                while(v > 0L) {
                    int v6 = this.k.read(new byte[0x1000], 0, ((int)Math.min(v, 0x1000L)));
                    if(Thread.currentThread().isInterrupted()) {
                        throw new InterruptedIOException();
                    }
                    if(v6 == -1) {
                        throw new y1();  // 初始化器: Ljava/io/IOException;-><init>()V
                    }
                    v -= (long)v6;
                    this.g(v6);
                }
            label_89:
                return this.m;
            }
            catch(IOException iOException1) {
            }
        }
        this.i();
        throw new g8(iOException1, w20);
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final Uri c() {
        return this.j == null ? null : Uri.parse(this.j.request().url().toString());
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final void close() {
        if(this.l) {
            this.l = false;
            this.h();
            this.i();
        }
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final Map e() {
        return this.j == null ? Collections.EMPTY_MAP : this.j.headers().toMultimap();
    }

    public final void i() {
        Response response0 = this.j;
        if(response0 != null) {
            ResponseBody responseBody0 = response0.body();
            responseBody0.getClass();
            responseBody0.close();
            this.j = null;
        }
        this.k = null;
    }

    @Override  // i.n.i.b.a.s.e.xe
    public final int o(byte[] arr_b, int v, int v1) {
        if(v1 == 0) {
            return 0;
        }
        try {
            long v2 = this.m;
            if(Long.compare(v2, -1L) != 0) {
                long v3 = v2 - this.n;
                if(v3 == 0L) {
                    return -1;
                }
                v1 = (int)Math.min(v1, v3);
            }
            int v4 = this.k.read(arr_b, v, v1);
            if(v4 == -1) {
                return -1;
            }
            this.n += (long)v4;
            this.g(v4);
            return v4;
        }
        catch(IOException iOException0) {
            W2 w20 = this.i;
            w20.getClass();
            throw new g8(iOException0, w20);
        }
    }
}

