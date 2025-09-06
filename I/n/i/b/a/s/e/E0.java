package i.n.i.b.a.s.e;

import Nf.p;
import com.iloen.melon.custom.S0;
import java.util.ArrayList;
import java.util.Map;

public final class e0 implements a8, v0 {
    public final d3 a;
    public final g0 b;
    public final Lb c;
    public final C2 d;
    public final X1 e;
    public final p f;
    public final K2 g;
    public final L3 h;
    public final wc i;
    public final E4 j;
    public final Map k;
    public final Md l;
    public final Gd m;
    public u0 n;
    public u1 o;
    public Q4[] r;
    public S0 w;

    public e0(u1 u10, d3 d30, g0 g00, E4 e40, C2 c20, X1 x10, p p0, K2 k20, Lb lb0, L3 l30, Map map0, Md md0, Gd gd0) {
        this.o = u10;
        this.a = d30;
        this.b = g00;
        this.c = lb0;
        this.d = c20;
        this.e = x10;
        this.f = p0;
        this.g = k20;
        this.h = l30;
        this.j = e40;
        this.k = map0;
        this.l = md0;
        this.m = gd0;
        vc[] arr_vc = new vc[u10.f.length];
        for(int v = 0; true; ++v) {
            t1[] arr_t1 = u10.f;
            if(v >= arr_t1.length) {
                break;
            }
            u[] arr_u = arr_t1[v].j;
            u[] arr_u1 = new u[arr_u.length];
            for(int v1 = 0; v1 < arr_u.length; ++v1) {
                u u0 = arr_u[v1];
                Class class0 = c20.a(u0);
                ob ob0 = u0.a();
                ob0.D = class0;
                arr_u1[v1] = new u(ob0);
            }
            arr_vc[v] = new vc(arr_u1);
        }
        this.i = new wc(arr_vc);
        Q4[] arr_q4 = new Q4[0];
        this.r = arr_q4;
        e40.getClass();
        this.w = new S0(arr_q4, 27);
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long a(long v, Xb xb0) {
        Q4[] arr_q4 = this.r;
        for(int v1 = 0; v1 < arr_q4.length; ++v1) {
            Q4 q40 = arr_q4[v1];
            if(q40.a == 2) {
                return q40.e.a(v, xb0);
            }
        }
        return v;
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final boolean a() {
        return this.w.a();
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final boolean a(long v) {
        return this.w.a(v);
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long b(long v) {
        Q4[] arr_q4 = this.r;
        for(int v1 = 0; v1 < arr_q4.length; ++v1) {
            arr_q4[v1].i(v);
        }
        return v;
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final void b(long v) {
        this.w.b(v);
    }

    @Override  // i.n.i.b.a.s.e.a8
    public final void b(b8 b80) {
        this.n.b(this);
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final long c() {
        return this.w.c();
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long e() {
        return 0L;
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final long f() {
        return this.w.f();
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long g() {
        return 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final wc h() {
        return this.i;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final void k() {
        this.c.b();
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long l() {
        return 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final void l(u0 u00, long v) {
        this.n = u00;
        u00.c(this);
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long m() {
        return 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final boolean m(q2[] arr_q2, boolean[] arr_z, B7[] arr_b7) {
        for(int v = 0; v < arr_q2.length; ++v) {
            B7 b70 = arr_b7[v];
            q2 q20 = arr_q2[v];
            if(b70 != null && q20 != null && arr_z[v]) {
                b70.c(q20);
            }
        }
        return true;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long v(q2[] arr_q2, boolean[] arr_z, B7[] arr_b7, boolean[] arr_z1, long v) {
        int v4;
        ArrayList arrayList0 = new ArrayList();
        for(int v1 = 0; v1 < arr_q2.length; v1 = v4 + 1) {
            B7 b70 = arr_b7[v1];
            if(b70 != null) {
                q2 q20 = arr_q2[v1];
                if(q20 == null || !arr_z[v1]) {
                    ((Q4)b70).g(null);
                    arr_b7[v1] = null;
                }
                else {
                    ((Wd)((Q4)b70).e).i = q20;
                    arrayList0.add(((Q4)b70));
                }
            }
            if(arr_b7[v1] == null) {
                q2 q21 = arr_q2[v1];
                if(q21 != null) {
                    int v2 = this.i.a(q21.a);
                    u1 u10 = this.o;
                    int v3 = u10.f[v2].a;
                    D0 d00 = this.a.a.a();
                    g0 g00 = this.b;
                    if(g00 != null) {
                        d00.l(g00);
                    }
                    Wd wd0 = new Wd(this.c, u10, v2, q21, d00, v3, this.k, this.l);
                    v4 = v1;
                    Q4 q40 = new Q4(this.o.f[v2].a, null, null, wd0, this, this.h, v, this.d, this.e, this.f, this.g, this.l, this.m);
                    arrayList0.add(q40);
                    arr_b7[v4] = q40;
                    arr_z1[v4] = true;
                }
            }
            else {
                v4 = v1;
            }
        }
        Q4[] arr_q4 = new Q4[arrayList0.size()];
        this.r = arr_q4;
        arrayList0.toArray(arr_q4);
        Q4[] arr_q41 = this.r;
        this.j.getClass();
        this.w = new S0(arr_q41, 27);
        return v;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final void w(long v, boolean z) {
        Q4[] arr_q4 = this.r;
        for(int v1 = 0; v1 < arr_q4.length; ++v1) {
            arr_q4[v1].w(v, z);
        }
    }
}

