package i.n.i.b.a.s.e;

import Nf.p;
import android.net.Uri;
import com.iloen.melon.fragments.radio.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class j2 extends a6 {
    public final K2 B;
    public c D;
    public g0 E;
    public final Map G;
    public final Md I;
    public final Gd M;
    public final long N;
    public final E4 S;
    public final re g;
    public final d h;
    public final Map i;
    public final d3 j;
    public final E4 k;
    public final C2 l;
    public final p m;
    public final int n;
    public final W8 o;
    public final long r;
    public final e w;

    static {
        pa.a("goog.exo.hls");
    }

    public j2(e e0, d3 d30, re re0, E4 e40, C2 c20, p p0, W8 w80, long v, int v1, Map map0, Md md0, Gd gd0, int v2, long v3, E4 e41) {
        e0.b.getClass();
        this.h = e0.b;
        this.w = e0;
        this.D = e0.c;
        this.i = e0.b.b;
        this.j = d30;
        this.g = re0;
        this.k = e40;
        this.l = c20;
        this.m = p0;
        this.o = w80;
        this.r = v;
        this.n = v1;
        this.B = this.k(null);
        this.G = map0;
        this.I = md0;
        this.M = gd0;
        M7.u(v2 == -1 || v2 > 0);
        this.N = v3;
        this.S = e41;
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final e a() {
        return this.w;
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final v0 b(e2 e20, L3 l30, long v) {
        K2 k20 = this.k(e20);
        X1 x10 = new X1(this.d.c, 0, e20);
        return new r1(this.g, this.o, this.j, this.E, this.l, x10, this.m, k20, l30, this.k, this.n, this.i, this.G, this.I, this.M, this.S);
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final void d(g0 g00) {
        this.E = g00;
        this.l.b();
        K2 k20 = this.k(null);
        Uri uri0 = this.h.a;
        W8 w80 = this.o;
        cd cd0 = w80.d;
        Gd gd0 = w80.i;
        w80.l = L7.j(null);
        w80.j = k20;
        w80.m = this;
        boolean z = true;
        if(w80.b != null) {
            if(w80.k != null) {
                z = false;
            }
            M7.J(z);
            w80.k = new sa("DefaultHlsPlaylistTracker:MasterPlaylist", gd0);
            ld ld0 = new ld(new jd(w80.b), new W2(((Uri)w80.b.e)), 4, cd0.a());
            w80.k.e(ld0, w80, 0);
            return;
        }
        gd0.getClass();
        Map map0 = w80.a;
        D0 d00 = w80.c.a();
        if(uri0 == null) {
            throw new IllegalStateException("The uri must be set.");
        }
        ld ld1 = new ld(d00, new W2(uri0, 1, null, map0, 0L, -1L, null, 1, 0x8000000000000001L, 0x8000000000000001L, 0x8000000000000001L), 4, cd0.a());
        if(w80.h != null) {
            ld1.i = new a(w80, 20);
        }
        if(w80.k != null) {
            z = false;
        }
        M7.J(z);
        sa sa0 = new sa("DefaultHlsPlaylistTracker:MasterPlaylist", gd0);
        w80.k = sa0;
        long v = sa0.e(ld1, w80, w80.e.a(ld1.c));
        k20.q(new Sd(ld1.b, v), ld1.c);
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final void e(v0 v00) {
        ((r1)v00).b.g.remove(((r1)v00));
        D3[] arr_d3 = ((r1)v00).E;
        for(int v = 0; v < arr_d3.length; ++v) {
            D3 d30 = arr_d3[v];
            if(d30.b0) {
                B3[] arr_b3 = d30.N;
                for(int v1 = 0; v1 < arr_b3.length; ++v1) {
                    B3 b30 = arr_b3[v1];
                    b30.v();
                    b1 b10 = b30.i;
                    if(b10 != null) {
                        b10.a(b30.e);
                        b30.i = null;
                        b30.h = null;
                    }
                }
            }
            d30.i.h(d30);
            d30.w.removeCallbacksAndMessages(null);
            d30.f0 = true;
            d30.B.clear();
        }
        ((r1)v00).w = null;
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final void l() {
        W8 w80 = this.o;
        sa sa0 = w80.k;
        if(sa0 != null) {
            sa0.b();
        }
        Uri uri0 = w80.o;
        if(uri0 != null) {
            V8 v80 = (V8)w80.f.get(uri0);
            v80.b.b();
            IOException iOException0 = v80.j;
            if(iOException0 != null) {
                throw iOException0;
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final void s() {
        W8 w80 = this.o;
        w80.o = null;
        w80.r = null;
        w80.n = null;
        w80.B = 0x8000000000000001L;
        w80.k.h(null);
        w80.k = null;
        HashMap hashMap0 = w80.f;
        for(Object object0: hashMap0.values()) {
            ((V8)object0).b.h(null);
        }
        w80.l.removeCallbacksAndMessages(null);
        w80.l = null;
        hashMap0.clear();
        this.l.a();
    }
}

