package W;

import De.w;
import F.d;
import P0.n;
import P0.z0;
import U.E;
import U.f0;
import X0.a;
import X0.k;
import X0.l;
import X0.s;
import X0.u;
import Y.Q;
import a1.T;
import a1.g;
import a1.t;
import f1.C;
import f1.D;
import f1.j;
import f1.p;
import f1.x;
import ie.H;
import java.util.List;
import s0.m;

public final class i extends n implements z0 {
    public D c;
    public x d;
    public f0 e;
    public boolean f;
    public boolean g;
    public p h;
    public Q i;
    public j j;
    public w0.p k;

    @Override  // P0.z0
    public final void l(X0.x x0) {
        boolean z = this.g;
        g g0 = this.d.a;
        w[] arr_w = u.a;
        w w0 = arr_w[16];
        s.B.a(x0, g0);
        g g1 = this.c.a;
        w w1 = arr_w[17];
        s.C.a(x0, g1);
        long v = this.d.b;
        w w2 = arr_w[18];
        T t0 = new T(v);
        s.D.a(x0, t0);
        w w3 = arr_w[8];
        s.q.a(x0, m.a);
        a a0 = new a(null, new h(this, 0));
        ((l)x0).g(k.g, a0);
        if(!this.f) {
            u.c(x0);
        }
        if(z) {
            ((l)x0).g(s.H, H.a);
        }
        boolean z1 = this.f;
        w w4 = arr_w[24];
        s.K.a(x0, Boolean.valueOf(z1));
        u.d(x0, new h(this, 1));
        if(z1) {
            a a1 = new a(null, new h(this, 2));
            ((l)x0).g(k.j, a1);
            a a2 = new a(null, new h(this, x0));
            ((l)x0).g(k.n, a2);
        }
        a a3 = new a(null, new d(this, 6));
        ((l)x0).g(k.i, a3);
        int v1 = this.j.e;
        W.g g2 = new W.g(this, 3);
        f1.i i0 = new f1.i(v1);
        ((l)x0).g(s.E, i0);
        a a4 = new a(null, g2);
        ((l)x0).g(k.o, a4);
        a a5 = new a(null, new W.g(this, 4));
        ((l)x0).g(k.b, a5);
        a a6 = new a(null, new W.g(this, 5));
        ((l)x0).g(k.c, a6);
        if(!T.b(this.d.b) && !z) {
            a a7 = new a(null, new W.g(this, 6));
            ((l)x0).g(k.p, a7);
            if(this.f) {
                a a8 = new a(null, new W.g(this, 1));
                ((l)x0).g(k.q, a8);
            }
        }
        if(this.f) {
            a a9 = new a(null, new W.g(this, 2));
            ((l)x0).g(k.r, a9);
        }
    }

    @Override  // P0.z0
    public final boolean l0() {
        return true;
    }

    public static final void p0(i i0, f0 f00, String s, boolean z) {
        if(z) {
            C c0 = f00.e;
            E e0 = f00.v;
            H h0 = null;
            if(c0 != null) {
                List list0 = e.k.A(new f1.g[]{new f1.d(), new f1.a(s, 1)});  // 初始化器: Ljava/lang/Object;-><init>()V
                x x0 = f00.d.f(list0);
                c0.a(null, x0);
                e0.invoke(x0);
                h0 = H.a;
            }
            if(h0 == null) {
                int v = s.length();
                e0.invoke(new x(s, t.b(v, v), 4));
            }
        }
    }
}

