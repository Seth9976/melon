package androidx.media3.exoplayer.source;

import B3.o;
import I6.V;
import I6.p0;
import Nf.p;
import Q.C;
import R6.c;
import android.content.Context;
import android.net.Uri;
import androidx.media3.common.b;
import androidx.media3.datasource.DefaultDataSource.Factory;
import androidx.media3.session.H0;
import b3.A;
import b3.B;
import b3.D;
import b3.E;
import b3.G;
import b3.H;
import b3.n;
import b3.s;
import b3.t;
import b3.v;
import b3.w;
import e3.x;
import g3.e;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import k3.m;
import s3.Q;
import s3.a;
import s3.d0;
import s3.g;
import s3.y;

public final class DefaultMediaSourceFactory implements y {
    public final C a;
    public final DefaultDataSource.Factory b;
    public c c;
    public final long d;
    public final long e;
    public final long f;
    public final float g;
    public final float h;
    public boolean i;

    public DefaultMediaSourceFactory(Context context0) {
        this(new DefaultDataSource.Factory(context0), new o());
    }

    public DefaultMediaSourceFactory(Context context0, o o0) {
        this(new DefaultDataSource.Factory(context0), o0);
    }

    public DefaultMediaSourceFactory(DefaultDataSource.Factory defaultDataSource$Factory0, o o0) {
        this.b = defaultDataSource$Factory0;
        c c0 = new c(9);
        this.c = c0;
        C c1 = new C(o0, c0);
        this.a = c1;
        if(defaultDataSource$Factory0 != ((DefaultDataSource.Factory)c1.e)) {
            c1.e = defaultDataSource$Factory0;
            ((HashMap)c1.c).clear();
            ((HashMap)c1.d).clear();
        }
        this.d = 0x8000000000000001L;
        this.e = 0x8000000000000001L;
        this.f = 0x8000000000000001L;
        this.g = -3.402823E+38f;
        this.h = -3.402823E+38f;
        this.i = true;
    }

    @Override  // s3.y
    public final void a(boolean z) {
        this.i = z;
        this.a.a = z;
        synchronized(((o)this.a.b)) {
            ((o)this.a.b).b = z;
        }
        for(Object object0: ((HashMap)this.a.d).values()) {
            ((y)object0).a(z);
        }
    }

    @Override  // s3.y
    public final void b(c c0) {
        this.c = c0;
        this.a.f = c0;
        synchronized(((o)this.a.b)) {
            ((o)this.a.b).c = c0;
        }
        for(Object object0: ((HashMap)this.a.d).values()) {
            ((y)object0).b(c0);
        }
    }

    @Override  // s3.y
    public final a c(E e0) {
        m m0;
        y y0;
        int v;
        e0.b.getClass();
        String s = e0.b.a.getScheme();
        if(s != null && s.equals("ssai")) {
            throw null;
        }
        if(Objects.equals(e0.b.b, "application/x-image-uri")) {
            throw null;
        }
        Uri uri0 = e0.b.a;
        String s1 = e0.b.b;
        if(s1 == null) {
            v = x.F(uri0);
        }
        else {
            switch(s1) {
                case "application/dash+xml": {
                    v = 0;
                    break;
                }
                case "application/vnd.ms-sstr+xml": {
                    v = 1;
                    break;
                }
                case "application/x-mpegURL": {
                    v = 2;
                    break;
                }
                case "application/x-rtsp": {
                    v = 3;
                    break;
                }
                default: {
                    v = 4;
                }
            }
        }
        if(e0.b.h != 0x8000000000000001L) {
            synchronized(((o)this.a.b)) {
                ((o)this.a.b).d = 1;
            }
        }
        try {
            C c0 = this.a;
            HashMap hashMap0 = (HashMap)c0.d;
            y0 = (y)hashMap0.get(v);
            if(y0 == null) {
                y0 = (y)c0.b(v).get();
                y0.b(((c)c0.f));
                y0.a(c0.a);
                hashMap0.put(v, y0);
            }
        }
        catch(ClassNotFoundException classNotFoundException0) {
            throw new IllegalStateException(classNotFoundException0);
        }
        b3.x x0 = e0.c.a();
        b3.y y1 = e0.c;
        if(y1.a == 0x8000000000000001L) {
            x0.a = this.d;
        }
        if(y1.d == -3.402823E+38f) {
            x0.d = this.g;
        }
        if(y1.e == -3.402823E+38f) {
            x0.e = this.h;
        }
        if(y1.b == 0x8000000000000001L) {
            x0.b = this.e;
        }
        if(y1.c == 0x8000000000000001L) {
            x0.c = this.f;
        }
        b3.y y2 = new b3.y(x0);
        if(!y2.equals(e0.c)) {
            s s2 = e0.a();
            s2.l = y2.a();
            e0 = s2.a();
        }
        a a0 = y0.c(e0);
        V v1 = e0.b.g;
        if(!v1.isEmpty()) {
            a[] arr_a = new a[v1.size() + 1];
            arr_a[0] = a0;
            for(int v2 = 0; v2 < v1.size(); ++v2) {
                if(this.i) {
                    n n0 = new n();
                    n0.m = H.l(((D)v1.get(v2)).b);
                    n0.d = ((D)v1.get(v2)).c;
                    n0.e = ((D)v1.get(v2)).d;
                    n0.f = ((D)v1.get(v2)).e;
                    n0.b = ((D)v1.get(v2)).f;
                    n0.a = ((D)v1.get(v2)).g;
                    H0 h00 = new H0(26, this, new b(n0));
                    DefaultDataSource.Factory defaultDataSource$Factory0 = this.b;
                    j3.n n1 = new j3.n(h00, 8);
                    Object object0 = new Object();
                    p p0 = new p(-1);
                    String s3 = ((D)v1.get(v2)).a.toString();
                    t t0 = new t();
                    F4.a a1 = new F4.a();
                    List list0 = Collections.EMPTY_LIST;
                    b3.x x1 = new b3.x();
                    Uri uri1 = s3 == null ? null : Uri.parse(s3);
                    e3.b.j(((Uri)a1.e) == null || ((UUID)a1.d) != null);
                    A a2 = uri1 == null ? null : new A(uri1, null, (((UUID)a1.d) == null ? null : new w(a1)), null, list0, null, p0.e, 0x8000000000000001L);
                    E e1 = new E("", new v(t0), a2, new b3.y(x1), G.K, B.d);  // 初始化器: Lb3/u;-><init>(Lb3/t;)V
                    a2.getClass();
                    e1.b.getClass();
                    w w0 = e1.b.c;
                    if(w0 == null) {
                        m0 = k3.o.a;
                    }
                    else {
                        synchronized(object0) {
                            m0 = w0.equals(null) ? null : y8.s.d(w0);
                            m0.getClass();
                        }
                    }
                    arr_a[v2 + 1] = new Q(e1, defaultDataSource$Factory0, n1, m0, p0, 0x100000, true);
                }
                else {
                    this.b.getClass();
                    p p1 = new p(-1);
                    arr_a[v2 + 1] = new d0(((D)v1.get(v2)), this.b, p1);
                }
            }
            a0 = new s3.H(arr_a);
        }
        a a3 = a0;
        v v4 = e0.e;
        long v5 = v4.b;
        if(v5 != 0L || v4.d != 0x8000000000000000L || v4.f) {
            a3 = new g(a3, v5, v4.d, !v4.g, v4.e, v4.f);
        }
        e0.b.getClass();
        if(e0.b.d == null) {
            return a3;
        }
        e3.b.D("DMediaSourceFactory", "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
        return a3;
    }

    public static y d(Class class0, e e0) {
        try {
            return (y)class0.getConstructor(e.class).newInstance(e0);
        }
        catch(Exception exception0) {
            throw new IllegalStateException(exception0);
        }
    }
}

