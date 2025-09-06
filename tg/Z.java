package tg;

import U4.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import jeb.synthetic.TWR;
import okhttp3.Call.Factory;
import okhttp3.Call;
import okhttp3.HttpUrl.Builder;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.Timeout;

public final class z implements d {
    public final P a;
    public final Object b;
    public final Object[] c;
    public final Factory d;
    public final m e;
    public volatile boolean f;
    public Call g;
    public Throwable h;
    public boolean i;

    public z(P p0, Object object0, Object[] arr_object, Factory call$Factory0, m m0) {
        this.a = p0;
        this.b = object0;
        this.c = arr_object;
        this.d = call$Factory0;
        this.e = m0;
    }

    public final Call a() {
        HttpUrl httpUrl0;
        P p0 = this.a;
        b0[] arr_b0 = p0.k;
        Object[] arr_object = this.c;
        int v = arr_object.length;
        if(v == arr_b0.length) {
            N n0 = new N(p0.d, p0.c, p0.e, p0.f, p0.g, p0.h, p0.i, p0.j);
            if(p0.l) {
                --v;
            }
            ArrayList arrayList0 = new ArrayList(v);
            for(int v1 = 0; v1 < v; ++v1) {
                arrayList0.add(arr_object[v1]);
                arr_b0[v1].a(n0, arr_object[v1]);
            }
            Builder httpUrl$Builder0 = n0.d;
            if(httpUrl$Builder0 == null) {
                HttpUrl httpUrl1 = n0.b;
                httpUrl0 = httpUrl1.resolve(n0.c);
                if(httpUrl0 == null) {
                    throw new IllegalArgumentException("Malformed URL. Base: " + httpUrl1 + ", Relative: " + n0.c);
                }
            }
            else {
                httpUrl0 = httpUrl$Builder0.build();
            }
            RequestBody requestBody0 = n0.k;
            if(requestBody0 == null) {
                okhttp3.FormBody.Builder formBody$Builder0 = n0.j;
                if(formBody$Builder0 == null) {
                    okhttp3.MultipartBody.Builder multipartBody$Builder0 = n0.i;
                    if(multipartBody$Builder0 != null) {
                        requestBody0 = multipartBody$Builder0.build();
                    }
                    else if(n0.h) {
                        requestBody0 = RequestBody.create(null, new byte[0]);
                    }
                }
                else {
                    requestBody0 = formBody$Builder0.build();
                }
            }
            MediaType mediaType0 = n0.g;
            okhttp3.Headers.Builder headers$Builder0 = n0.f;
            if(mediaType0 != null) {
                if(requestBody0 == null) {
                    headers$Builder0.add("Content-Type", mediaType0.toString());
                }
                else {
                    requestBody0 = new M(requestBody0, mediaType0);
                }
            }
            okhttp3.Request.Builder request$Builder0 = n0.e.url(httpUrl0).headers(headers$Builder0.build()).method(n0.a, requestBody0);
            u u0 = new u(p0.a, this.b, p0.b, arrayList0);
            Request request0 = request$Builder0.tag(u.class, u0).build();
            Call call0 = this.d.newCall(request0);
            if(call0 == null) {
                throw new NullPointerException("Call.Factory returned null.");
            }
            return call0;
        }
        StringBuilder stringBuilder0 = x.n(v, "Argument count (", ") doesn\'t match expected count (");
        throw new IllegalArgumentException(x.g(arr_b0.length, ")", stringBuilder0));
    }

    public final Call b() {
        Call call0 = this.g;
        if(call0 != null) {
            return call0;
        }
        Throwable throwable0 = this.h;
        if(throwable0 != null) {
            if(throwable0 instanceof IOException) {
                throw (IOException)throwable0;
            }
            if(throwable0 instanceof RuntimeException) {
                throw (RuntimeException)throwable0;
            }
            throw (Error)throwable0;
        }
        try {
            Call call1 = this.a();
            this.g = call1;
            return call1;
        }
        catch(RuntimeException | Error | IOException runtimeException0) {
            b0.r(runtimeException0);
            this.h = runtimeException0;
            throw runtimeException0;
        }
    }

    public final Q c(Response response0) {
        Q q0;
        ResponseBody responseBody0 = response0.body();
        Response response1 = response0.newBuilder().body(new y(responseBody0.contentType(), responseBody0.contentLength())).build();
        int v = response1.code();
        if(v >= 200 && v < 300) {
            if(v != 204 && v != 205) {
                tg.x x0 = new tg.x(responseBody0);
                try {
                    return Q.b(this.e.l(x0), response1);
                }
                catch(RuntimeException runtimeException0) {
                    IOException iOException0 = x0.c;
                    if(iOException0 == null) {
                        throw runtimeException0;
                    }
                    throw iOException0;
                }
            }
            responseBody0.close();
            return Q.b(null, response1);
        }
        try {
            Buffer buffer0 = new Buffer();
            responseBody0.source().readAll(buffer0);
            ResponseBody responseBody1 = ResponseBody.create(responseBody0.contentType(), responseBody0.contentLength(), buffer0);
            Objects.requireNonNull(responseBody1, "body == null");
            if(response1.isSuccessful()) {
                throw new IllegalArgumentException("rawResponse should not be successful response");
            }
            q0 = new Q(response1, null, responseBody1);
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(responseBody0, throwable0);
            throw throwable0;
        }
        responseBody0.close();
        return q0;
    }

    @Override  // tg.d
    public final void cancel() {
        Call call0;
        this.f = true;
        synchronized(this) {
            call0 = this.g;
        }
        if(call0 != null) {
            call0.cancel();
        }
    }

    @Override
    public final Object clone() {
        return new z(this.a, this.b, this.c, this.d, this.e);
    }

    @Override  // tg.d
    public final d clone() {
        return new z(this.a, this.b, this.c, this.d, this.e);
    }

    @Override  // tg.d
    public final void enqueue(g g0) {
        synchronized(this) {
            if(!this.i) {
                this.i = true;
                Call call0 = this.g;
                Throwable throwable0 = this.h;
                if(call0 == null && throwable0 == null) {
                    try {
                        Call call1 = this.a();
                        this.g = call1;
                        call0 = call1;
                    }
                    catch(Throwable throwable0) {
                        b0.r(throwable0);
                        this.h = throwable0;
                    }
                }
                if(throwable0 != null) {
                    g0.onFailure(this, throwable0);
                    return;
                }
                if(this.f) {
                    call0.cancel();
                }
                call0.enqueue(new ea.d(this, g0));
                return;
            }
        }
        throw new IllegalStateException("Already executed.");
    }

    @Override  // tg.d
    public final Q execute() {
        synchronized(this) {
            if(!this.i) {
                this.i = true;
                Call call0 = this.b();
                if(this.f) {
                    call0.cancel();
                }
                return this.c(call0.execute());
            }
        }
        throw new IllegalStateException("Already executed.");
    }

    @Override  // tg.d
    public final boolean isCanceled() {
        boolean z = true;
        if(this.f) {
            return true;
        }
        synchronized(this) {
            if(this.g == null || !this.g.isCanceled()) {
                z = false;
            }
            return z;
        }
    }

    @Override  // tg.d
    public final boolean isExecuted() {
        synchronized(this) {
        }
        return this.i;
    }

    @Override  // tg.d
    public final Request request() {
        synchronized(this) {
            try {
                return this.b().request();
            }
            catch(IOException iOException0) {
                throw new RuntimeException("Unable to create request.", iOException0);
            }
        }
    }

    @Override  // tg.d
    public final Timeout timeout() {
        synchronized(this) {
            try {
                return this.b().timeout();
            }
            catch(IOException iOException0) {
                throw new RuntimeException("Unable to create call.", iOException0);
            }
        }
    }
}

