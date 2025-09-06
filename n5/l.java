package n5;

import Ac.G;
import Tf.v;
import android.os.Looper;
import android.os.NetworkOnMainThreadException;
import android.webkit.MimeTypeMap;
import com.iloen.melon.custom.h0;
import d5.n;
import e1.u;
import hg.c;
import i.n.i.b.a.s.e.M3;
import ie.j;
import java.io.IOException;
import java.util.Map.Entry;
import k5.B;
import k5.p;
import kb.D;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuationImpl;
import l5.h;
import ne.a;
import okhttp3.CacheControl.Builder;
import okhttp3.CacheControl;
import okhttp3.Call.Factory;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import s5.b;
import s5.d;
import s5.e;
import t5.o;

public final class l implements g {
    public final String a;
    public final o b;
    public final Object c;
    public final Object d;
    public final boolean e;
    public static final CacheControl f;
    public static final CacheControl g;

    static {
        l.f = new Builder().noCache().noStore().build();
        l.g = new Builder().noCache().onlyIfCached().build();
    }

    public l(String s, o o0, j j0, j j1, boolean z) {
        this.a = s;
        this.b = o0;
        this.c = j0;
        this.d = j1;
        this.e = z;
    }

    @Override  // n5.g
    public final Object a(Continuation continuation0) {
        l l1;
        Response response1;
        Object object2;
        ResponseBody responseBody0;
        Response response0;
        c c3;
        l l0;
        e e1;
        e e0;
        c c1;
        k k0;
        if(continuation0 instanceof k) {
            k0 = (k)continuation0;
            int v = k0.G;
            if((v & 0x80000000) == 0) {
                k0 = new k(this, ((oe.c)continuation0));
            }
            else {
                k0.G = v ^ 0x80000000;
            }
        }
        else {
            k0 = new k(this, ((oe.c)continuation0));
        }
        Object object0 = k0.D;
        a a0 = a.a;
        MediaType mediaType0 = null;
        switch(k0.G) {
            case 0: {
                n.D(object0);
                o o0 = this.b;
                String s = this.a;
                if(o0.n.a) {
                    l5.a a1 = (l5.a)((j)this.d).getValue();
                    if(a1 == null) {
                        c1 = null;
                    }
                    else {
                        String s1 = ByteString.Companion.encodeUtf8((o0.i == null ? s : o0.i)).sha256().hex();
                        l5.c c0 = ((h)a1).b.h(s1);
                        c1 = c0 == null ? null : new c(c0, 1);
                    }
                }
                else {
                    c1 = null;
                }
                try {
                    if(c1 == null) {
                        e0 = new d(this.e(), null).a();
                    }
                    else {
                        FileSystem fileSystem0 = this.c();
                        l5.c c2 = (l5.c)c1.b;
                        if(c2.b) {
                            throw new IllegalStateException("snapshot is closed");
                        }
                        Long long0 = fileSystem0.metadata(((Path)c2.a.c.get(0))).getSize();
                        if(long0 != null && ((long)long0) == 0L) {
                            return new m(this.g(c1), l.d(s, null), k5.g.c);
                        }
                        if(!this.e) {
                            p p0 = this.g(c1);
                            b b0 = this.f(c1);
                            if(b0 != null) {
                                mediaType0 = (MediaType)((j)b0.b).getValue();
                            }
                            return new m(p0, l.d(s, mediaType0), k5.g.c);
                        }
                        e0 = new d(this.e(), this.f(c1)).a();
                        b b1 = e0.b;
                        if(e0.a == null && b1 != null) {
                            return new m(this.g(c1), l.d(s, ((MediaType)((j)b1.b).getValue())), k5.g.c);
                        }
                    }
                    q.d(e0.a);
                    k0.r = this;
                    k0.w = c1;
                    k0.B = e0;
                    k0.G = 1;
                    Object object1 = this.b(e0.a, k0);
                    if(object1 == a0) {
                        return a0;
                    }
                    e1 = e0;
                    object0 = object1;
                    l0 = this;
                    goto label_69;
                }
                catch(Exception exception0) {
                    goto label_117;
                }
            }
            case 1: {
                e e2 = (e)k0.B;
                c3 = k0.w;
                l0 = k0.r;
                try {
                    n.D(object0);
                    e1 = e2;
                    c1 = c3;
                }
                catch(Exception exception0) {
                    goto label_118;
                }
                try {
                label_69:
                    response0 = (Response)object0;
                    responseBody0 = response0.body();
                    if(responseBody0 == null) {
                        throw new IllegalStateException("response body == null");
                    }
                }
                catch(Exception exception0) {
                    goto label_117;
                }
                try {
                    c1 = l0.h(c1, e1.a, response0, e1.b);
                    String s2 = l0.a;
                    if(c1 != null) {
                        p p1 = l0.g(c1);
                        b b2 = l0.f(c1);
                        if(b2 != null) {
                            mediaType0 = (MediaType)((j)b2.b).getValue();
                        }
                        return new m(p1, l.d(s2, mediaType0), k5.g.d);
                    }
                    if(responseBody0.source().request(1L)) {
                        return new m(new B(responseBody0.source(), new h0(l0.b.a, 3), null), l.d(s2, responseBody0.contentType()), (response0.networkResponse() == null ? k5.g.c : k5.g.d));
                    }
                    x5.g.a(response0);
                    Request request0 = l0.e();
                    k0.r = l0;
                    k0.w = null;
                    k0.B = response0;
                    k0.G = 2;
                    object2 = l0.b(request0, k0);
                    if(object2 == a0) {
                        return a0;
                    }
                    response1 = response0;
                    object0 = object2;
                    l1 = l0;
                    response0 = (Response)object0;
                    goto label_104;
                }
                catch(Exception exception1) {
                    goto label_112;
                }
                try {
                    return a0;
                }
                catch(Exception exception0) {
                    goto label_117;
                }
                response1 = response0;
                object0 = object2;
                l1 = l0;
                response0 = (Response)object0;
                goto label_104;
            }
            case 2: {
                response1 = (Response)k0.B;
                c1 = k0.w;
                l1 = k0.r;
                try {
                    n.D(object0);
                    response0 = (Response)object0;
                    goto label_104;
                }
                catch(Exception exception2) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        goto label_114;
        try {
        label_104:
            ResponseBody responseBody1 = response0.body();
            if(responseBody1 == null) {
                throw new IllegalStateException("response body == null");
            }
            l1.getClass();
            B b3 = new B(responseBody1.source(), new h0(l1.b.a, 3), null);
            MediaType mediaType1 = responseBody1.contentType();
            return new m(b3, l.d(l1.a, mediaType1), (response0.networkResponse() == null ? k5.g.c : k5.g.d));
        }
        catch(Exception exception1) {
        label_112:
            response1 = response0;
            exception2 = exception1;
        }
        try {
        label_114:
            x5.g.a(response1);
            throw exception2;
        }
        catch(Exception exception0) {
        label_117:
            c3 = c1;
        }
    label_118:
        if(c3 != null) {
            x5.g.a(c3);
        }
        throw exception0;
    }

    public final Object b(Request request0, oe.c c0) {
        Response response0;
        n5.j j0;
        if(c0 instanceof n5.j) {
            j0 = (n5.j)c0;
            int v = j0.B;
            if((v & 0x80000000) == 0) {
                j0 = new n5.j(this, c0);
            }
            else {
                j0.B = v ^ 0x80000000;
            }
        }
        else {
            j0 = new n5.j(this, c0);
        }
        Object object0 = j0.r;
        a a0 = a.a;
        switch(j0.B) {
            case 0: {
                n.D(object0);
                boolean z = q.b(Looper.myLooper(), Looper.getMainLooper());
                Object object1 = this.c;
                if(z) {
                    if(this.b.o.a) {
                        throw new NetworkOnMainThreadException();
                    }
                    response0 = ((Factory)((j)object1).getValue()).newCall(request0).execute();
                    break;
                }
                else {
                    Call call0 = ((Factory)((j)object1).getValue()).newCall(request0);
                    j0.B = 1;
                    CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(j0), 1);
                    cancellableContinuationImpl0.initCancellability();
                    G g0 = new G(11, call0, cancellableContinuationImpl0);
                    call0.enqueue(g0);
                    cancellableContinuationImpl0.invokeOnCancellation(g0);
                    object0 = cancellableContinuationImpl0.getResult();
                    if(object0 == a0) {
                        return a0;
                    }
                    response0 = (Response)object0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                response0 = (Response)object0;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!response0.isSuccessful() && response0.code() != 304) {
            ResponseBody responseBody0 = response0.body();
            if(responseBody0 != null) {
                x5.g.a(responseBody0);
            }
            throw new M3("HTTP " + response0.code() + ": " + response0.message());  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
        }
        return response0;
    }

    public final FileSystem c() {
        Object object0 = ((j)this.d).getValue();
        q.d(object0);
        return ((h)(((l5.a)object0))).a;
    }

    public static String d(String s, MediaType mediaType0) {
        String s1 = mediaType0 == null ? null : mediaType0.toString();
        if(s1 == null || v.r0(s1, "text/plain", false)) {
            String s2 = x5.g.b(MimeTypeMap.getSingleton(), s);
            if(s2 != null) {
                return s2;
            }
        }
        return s1 == null ? null : Tf.o.a1(s1, ';');
    }

    public final Request e() {
        okhttp3.Request.Builder request$Builder0 = new okhttp3.Request.Builder().url(this.a);
        o o0 = this.b;
        okhttp3.Request.Builder request$Builder1 = request$Builder0.headers(o0.j);
        for(Object object0: o0.k.a.entrySet()) {
            Object object1 = ((Map.Entry)object0).getKey();
            q.e(object1, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
            request$Builder1.tag(((Class)object1), ((Map.Entry)object0).getValue());
        }
        t5.b b0 = o0.n;
        boolean z = b0.a;
        boolean z1 = o0.o.a;
        if(!z1 && z) {
            request$Builder1.cacheControl(CacheControl.FORCE_CACHE);
            return request$Builder1.build();
        }
        if(z1 && !z) {
            if(b0.b) {
                request$Builder1.cacheControl(CacheControl.FORCE_NETWORK);
                return request$Builder1.build();
            }
            request$Builder1.cacheControl(l.f);
            return request$Builder1.build();
        }
        if(!z1 && !z) {
            request$Builder1.cacheControl(l.g);
        }
        return request$Builder1.build();
    }

    public final b f(c c0) {
        Throwable throwable2;
        b b0;
        try {
            FileSystem fileSystem0 = this.c();
            l5.c c1 = (l5.c)c0.b;
            if(c1.b) {
                throw new IllegalStateException("snapshot is closed");
            }
            BufferedSource bufferedSource0 = Okio.buffer(fileSystem0.source(((Path)c1.a.c.get(0))));
            try {
                b0 = new b(bufferedSource0);
            }
            catch(Throwable throwable0) {
                if(bufferedSource0 != null) {
                    try {
                        bufferedSource0.close();
                    }
                    catch(Throwable throwable1) {
                        e2.a.q(throwable0, throwable1);
                    }
                }
                throwable2 = throwable0;
                b0 = null;
                goto label_20;
            }
            try {
                bufferedSource0.close();
                throwable2 = null;
            }
            catch(Throwable throwable2) {
            }
        label_20:
            if(throwable2 != null) {
                throw throwable2;
            }
            return b0;
        }
        catch(IOException unused_ex) {
            return null;
        }
    }

    public final p g(c c0) {
        l5.c c1 = (l5.c)c0.b;
        if(c1.b) {
            throw new IllegalStateException("snapshot is closed");
        }
        return new p(((Path)c1.a.c.get(1)), this.c(), (this.b.i == null ? this.a : this.b.i), c0);
    }

    public final c h(c c0, Request request0, Response response0, b b0) {
        A3.c c1;
        BufferedSink bufferedSink2;
        Throwable throwable5;
        BufferedSink bufferedSink1;
        BufferedSink bufferedSink0;
        Response response1;
        D d0;
        Throwable throwable0 = null;
        if(this.b.n.b && (!this.e || !request0.cacheControl().noStore() && !response0.cacheControl().noStore() && !q.b(response0.headers().get("Vary"), "*"))) {
            if(c0 == null) {
                l5.a a0 = (l5.a)((j)this.d).getValue();
                if(a0 == null) {
                    d0 = null;
                }
                else {
                    String s = ByteString.Companion.encodeUtf8((this.b.i == null ? this.a : this.b.i)).sha256().hex();
                    A3.c c2 = ((h)a0).b.g(s);
                    d0 = c2 == null ? null : new D(c2, 8);
                }
            }
            else {
                synchronized(((l5.c)c0.b).c) {
                    ((l5.c)c0.b).close();
                    c1 = ((l5.c)c0.b).c.g(((l5.c)c0.b).a.a);
                }
                d0 = c1 == null ? null : new D(c1, 8);
            }
            if(d0 != null) {
                try {
                    if(response0.code() != 304 || b0 == null) {
                        bufferedSink1 = Okio.buffer(this.c().sink(((A3.c)d0.b).g(0), false));
                        goto label_47;
                    }
                    else {
                        response1 = response0.newBuilder().headers(s5.c.a(b0.f, response0.headers())).build();
                        bufferedSink0 = Okio.buffer(this.c().sink(((A3.c)d0.b).g(0), false));
                        goto label_30;
                    }
                    return d0.f();
                }
                catch(Exception exception0) {
                    goto label_87;
                }
                finally {
                    x5.g.a(response0);
                }
                try {
                label_30:
                    new b(response1).a(bufferedSink0);
                }
                catch(Throwable throwable1) {
                    throwable0 = throwable1;
                    if(bufferedSink0 != null) {
                        try {
                            bufferedSink0.close();
                        }
                        catch(Throwable throwable2) {
                            try {
                                e2.a.q(throwable0, throwable2);
                            }
                            catch(Exception exception0) {
                                goto label_87;
                            }
                        }
                    }
                    goto label_43;
                }
                try {
                    bufferedSink0.close();
                }
                catch(Throwable throwable0) {
                }
                try {
                label_43:
                    if(throwable0 != null) {
                        throw throwable0;
                    }
                    return d0.f();
                }
                catch(Exception exception0) {
                    goto label_87;
                }
                try {
                label_47:
                    new b(response0).a(bufferedSink1);
                }
                catch(Throwable throwable3) {
                    if(bufferedSink1 != null) {
                        try {
                            bufferedSink1.close();
                        }
                        catch(Throwable throwable4) {
                            try {
                                e2.a.q(throwable3, throwable4);
                                throwable5 = throwable3;
                                goto label_61;
                            }
                            catch(Exception exception0) {
                                goto label_87;
                            }
                        }
                    }
                    throwable5 = throwable3;
                    goto label_61;
                }
                try {
                    bufferedSink1.close();
                    throwable5 = null;
                }
                catch(Throwable throwable5) {
                }
                try {
                label_61:
                    if(throwable5 != null) {
                        throw throwable5;
                    }
                    bufferedSink2 = Okio.buffer(this.c().sink(((A3.c)d0.b).g(1), false));
                }
                catch(Exception exception0) {
                    goto label_87;
                }
                try {
                    ResponseBody responseBody0 = response0.body();
                    q.d(responseBody0);
                    responseBody0.source().readAll(bufferedSink2);
                }
                catch(Throwable throwable6) {
                    throwable0 = throwable6;
                    if(bufferedSink2 != null) {
                        try {
                            bufferedSink2.close();
                        }
                        catch(Throwable throwable7) {
                            try {
                                e2.a.q(throwable0, throwable7);
                            }
                            catch(Exception exception0) {
                                goto label_87;
                            }
                        }
                    }
                    goto label_81;
                }
                if(bufferedSink2 != null) {
                    try {
                        bufferedSink2.close();
                    }
                    catch(Throwable throwable0) {
                    }
                }
                try {
                label_81:
                    if(throwable0 != null) {
                        throw throwable0;
                    }
                    return d0.f();
                }
                catch(Exception exception0) {
                }
                try {
                label_87:
                    ((A3.c)d0.b).c(false);
                }
                catch(Exception unused_ex) {
                }
                throw exception0;
            }
        }
        else if(c0 != null) {
            x5.g.a(c0);
        }
        return null;
    }
}

