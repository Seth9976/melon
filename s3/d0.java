package s3;

import I6.V;
import Nf.p;
import android.net.Uri;
import androidx.media3.common.b;
import androidx.media3.datasource.DefaultDataSource.Factory;
import b3.A;
import b3.B;
import b3.D;
import b3.E;
import b3.G;
import b3.H;
import b3.n;
import b3.t;
import b3.v;
import b3.w;
import b3.y;
import g3.e;
import g3.j;
import g3.x;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import w3.d;

public final class d0 extends a {
    public final j h;
    public final e i;
    public final b j;
    public final long k;
    public final p l;
    public final boolean m;
    public final Z n;
    public final E o;
    public x p;

    public d0(D d0, DefaultDataSource.Factory defaultDataSource$Factory0, p p0) {
        this.i = defaultDataSource$Factory0;
        this.k = 0x8000000000000001L;
        this.l = p0;
        boolean z = true;
        this.m = true;
        t t0 = new t();
        F4.a a0 = new F4.a();
        List list0 = Collections.EMPTY_LIST;
        b3.x x0 = new b3.x();
        B b0 = B.d;
        Uri uri0 = Uri.EMPTY;
        String s = d0.a.toString();
        s.getClass();
        V v0 = V.p(V.t(d0));
        if(((Uri)a0.e) != null && ((UUID)a0.d) == null) {
            z = false;
        }
        e3.b.j(z);
        String s1 = null;
        A a1 = uri0 == null ? null : new A(uri0, null, (((UUID)a0.d) == null ? null : new w(a0)), null, list0, null, v0, 0x8000000000000001L);
        E e0 = new E(s, new v(t0), a1, new y(x0), G.K, b0);  // 初始化器: Lb3/u;-><init>(Lb3/t;)V
        this.o = e0;
        n n0 = new n();
        n0.m = H.l((d0.b == null ? "text/x-unknown" : d0.b));
        n0.d = d0.c;
        n0.e = d0.d;
        n0.f = d0.e;
        n0.b = d0.f;
        String s2 = d0.g;
        if(s2 != null) {
            s1 = s2;
        }
        n0.a = s1;
        this.j = new b(n0);
        Map map0 = Collections.EMPTY_MAP;
        e3.b.l(d0.a, "The uri must be set.");
        this.h = new j(d0.a, 1, null, map0, 0L, -1L, null, 1);
        this.n = new Z(0x8000000000000001L, 0x8000000000000001L, 0x8000000000000001L, 0x8000000000000001L, 0L, 0L, true, false, false, null, e0, null);
    }

    @Override  // s3.a
    public final s3.x b(z z0, d d0, long v) {
        x x0 = this.p;
        B7.b b0 = new B7.b(0, ((CopyOnWriteArrayList)this.c.c), z0);
        return new c0(this.h, this.i, x0, this.j, this.k, this.l, b0, this.m);
    }

    @Override  // s3.a
    public final E h() {
        return this.o;
    }

    @Override  // s3.a
    public final void j() {
    }

    @Override  // s3.a
    public final void l(x x0) {
        this.p = x0;
        this.m(this.n);
    }

    @Override  // s3.a
    public final void n(s3.x x0) {
        ((c0)x0).i.c(null);
    }

    @Override  // s3.a
    public final void p() {
    }
}

