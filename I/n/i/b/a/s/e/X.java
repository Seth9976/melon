package i.n.i.b.a.s.e;

import android.util.Pair;

public final class x extends S8 {
    public boolean B;
    public final a6 j;
    public final boolean k;
    public final h l;
    public final g m;
    public v n;
    public oe o;
    public boolean r;
    public boolean w;

    public x(a6 a60, boolean z) {
        boolean z1;
        this.j = a60;
        if(z) {
            a60.getClass();
            z1 = true;
        }
        else {
            z1 = false;
        }
        this.k = z1;
        this.l = new h();
        this.m = new g();
        a60.getClass();
        this.n = new v(new w(a60.a()), h.r, v.e);
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final e a() {
        return this.j.a();
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final v0 b(e2 e20, L3 l30, long v) {
        return this.x(e20, l30, v);
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final void d(g0 g00) {
        this.i = g00;
        this.h = L7.j(null);
        if(!this.k) {
            this.r = true;
            this.u(null, this.j);
        }
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final void e(v0 v00) {
        if(((oe)v00).e != null) {
            a6 a60 = ((oe)v00).d;
            a60.getClass();
            a60.e(((oe)v00).e);
        }
        if(v00 == this.o) {
            this.o = null;
        }
    }

    @Override  // i.n.i.b.a.s.e.S8
    public final void l() {
    }

    @Override  // i.n.i.b.a.s.e.S8
    public final void s() {
        this.w = false;
        this.r = false;
        super.s();
    }

    @Override  // i.n.i.b.a.s.e.S8
    public final e2 t(Object object0, e2 e20) {
        Void void0 = (Void)object0;
        Object object1 = e20.a;
        Object object2 = this.n.d;
        if(object2 != null && object2.equals(object1)) {
            object1 = v.e;
        }
        return e20.b(object1);
    }

    @Override  // i.n.i.b.a.s.e.S8
    public final void v(Object object0, a6 a60, i i0) {
        long v2;
        e2 e20;
        Void void0 = (Void)object0;
        if(this.w) {
            this.n = new v(i0, this.n.c, this.n.d);
            oe oe0 = this.o;
            if(oe0 != null) {
                this.w(oe0.g);
            }
            e20 = null;
        }
        else {
            boolean z = i0.p();
            Object object1 = v.e;
            if(z) {
                this.n = this.B ? new v(i0, this.n.c, this.n.d) : new v(i0, h.r, object1);
                e20 = null;
            }
            else {
                h h0 = this.l;
                i0.k(0, h0);
                long v = h0.m;
                Object object2 = h0.a;
                oe oe1 = this.o;
                if(oe1 == null) {
                    v2 = v;
                }
                else {
                    this.n.i(oe1.a.a, this.m);
                    long v1 = this.m.e + oe1.b;
                    this.n.j(0, h0, 0L);
                    v2 = v1 == h0.m ? v : v1;
                }
                Pair pair0 = i0.f(this.l, this.m, 0, v2);
                Object object3 = pair0.first;
                long v3 = (long)(((Long)pair0.second));
                this.n = this.B ? new v(i0, this.n.c, this.n.d) : new v(i0, object2, object3);
                oe oe2 = this.o;
                if(oe2 == null) {
                    e20 = null;
                }
                else {
                    this.w(v3);
                    Object object4 = this.n.d == null || !oe2.a.a.equals(object1) ? oe2.a.a : this.n.d;
                    e20 = oe2.a.b(object4);
                }
            }
        }
        this.B = true;
        this.w = true;
        this.c(this.n);
        if(e20 != null) {
            oe oe3 = this.o;
            oe3.getClass();
            oe3.d(e20);
        }
    }

    public final void w(long v) {
        oe oe0 = this.o;
        int v1 = this.n.d(oe0.a.a);
        if(v1 == -1) {
            return;
        }
        this.n.h(v1, this.m, false);
        long v2 = this.m.d;
        if(v2 != 0x8000000000000001L && v >= v2) {
            v = Math.max(0L, v2 - 1L);
        }
        oe0.g = v;
    }

    public final oe x(e2 e20, L3 l30, long v) {
        oe oe0 = new oe(e20, l30, v);
        M7.J(oe0.d == null);
        a6 a60 = this.j;
        oe0.d = a60;
        if(this.w) {
            oe0.d(e20.b((this.n.d == null || !e20.a.equals(v.e) ? e20.a : this.n.d)));
            return oe0;
        }
        this.o = oe0;
        if(!this.r) {
            this.r = true;
            this.u(null, a60);
        }
        return oe0;
    }
}

