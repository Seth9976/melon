package i.n.i.b.a.s.e;

import Nf.p;
import com.iloen.melon.fragments.radio.a;

public final class d6 extends a6 {
    public boolean B;
    public g0 D;
    public final e g;
    public final d h;
    public final C0 i;
    public final a j;
    public final C2 k;
    public final p l;
    public final int m;
    public final Gd n;
    public boolean o;
    public long r;
    public boolean w;

    public d6(e e0, C0 c00, a a0, C2 c20, p p0, int v, Gd gd0) {
        e0.b.getClass();
        this.h = e0.b;
        this.g = e0;
        this.i = c00;
        this.j = a0;
        this.k = c20;
        this.l = p0;
        this.m = v;
        this.o = true;
        this.r = 0x8000000000000001L;
        this.n = gd0;
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final e a() {
        return this.g;
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final v0 b(e2 e20, L3 l30, long v) {
        D0 d00 = this.i.a();
        g0 g00 = this.D;
        if(g00 != null) {
            d00.l(g00);
        }
        sa sa0 = new sa(((Y6)this.j.b));
        X1 x10 = new X1(this.d.c, 0, e20);
        K2 k20 = this.k(e20);
        return new v5(this.h.a, d00, sa0, this.k, x10, this.l, k20, this, l30, this.m, this.n);
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final void d(g0 g00) {
        this.D = g00;
        this.k.b();
        this.u();
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final void e(v0 v00) {
        if(((v5)v00).G) {
            e7[] arr_e7 = ((v5)v00).B;
            for(int v = 0; v < arr_e7.length; ++v) {
                e7 e70 = arr_e7[v];
                e70.v();
                b1 b10 = e70.i;
                if(b10 != null) {
                    b10.a(e70.e);
                    e70.i = null;
                    e70.h = null;
                }
            }
        }
        ((v5)v00).j.h(((v5)v00));
        ((v5)v00).o.removeCallbacksAndMessages(null);
        ((v5)v00).r = null;
        ((v5)v00).g0 = true;
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final void l() {
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final void s() {
        this.k.a();
    }

    public final void t(long v, boolean z, boolean z1) {
        if(v == 0x8000000000000001L) {
            v = this.r;
        }
        if(!this.o && this.r == v && this.w == z && this.B == z1) {
            return;
        }
        this.r = v;
        this.w = z;
        this.B = z1;
        this.o = false;
        this.u();
    }

    public final void u() {
        Gd gd0 = this.n;
        long v = gd0.B;
        if(v == 0x8000000000000001L) {
            v = 0L;
        }
        else {
            long v1 = this.r;
            if(v1 != 0x8000000000000001L && v > v1) {
                v = v1;
            }
            gd0.B = 0x8000000000000001L;
        }
        N9 n90 = new N9(this.r, this.r, 0L, v, this.w, false, this.B, null, this.g);
        if(this.o) {
            n90 = new b6(n90);  // 初始化器: Li/n/i/b/a/s/e/Vc;-><init>(Li/n/i/b/a/s/e/i;)V
        }
        this.c(n90);
    }
}

