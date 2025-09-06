package i.n.i.b.a.s.e;

import Nf.p;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.facebook.appevents.c;
import com.iloen.melon.fragments.radio.a;
import h9.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import o9.b;

public final class z0 extends a6 implements db {
    public final K2 B;
    public final kd D;
    public final ArrayList E;
    public final Gd G;
    public final Md I;
    public D0 M;
    public sa N;
    public Lb S;
    public g0 T;
    public long V;
    public u1 W;
    public Handler X;
    public final boolean g;
    public final Uri h;
    public final e i;
    public final Map j;
    public d k;
    public final b l;
    public final d3 m;
    public final E4 n;
    public final C2 o;
    public final p r;
    public final long w;

    static {
        pa.a("goog.exo.smoothstreaming");
    }

    public z0(e e0, d d0, b b0, kd kd0, d3 d30, E4 e40, C2 c20, p p0, long v, Md md0, Gd gd0) {
        this.i = e0;
        i.n.i.b.a.s.e.d d1 = e0.b;
        d1.getClass();
        Uri uri0 = d1.a;
        this.W = null;
        if(uri0.equals(Uri.EMPTY)) {
            uri0 = null;
        }
        else {
            String s = uri0.getPath();
            if(s != null) {
                String s1 = M7.j(s);
                Matcher matcher0 = L7.j.matcher(s1);
                if(matcher0.matches() && matcher0.group(1) == null) {
                    uri0 = Uri.withAppendedPath(uri0, "Manifest");
                }
            }
        }
        this.h = uri0;
        this.k = d0;
        this.j = d1.b;
        this.l = b0;
        this.D = kd0;
        this.m = d30;
        this.n = e40;
        this.o = c20;
        this.r = p0;
        this.w = v;
        this.B = this.k(null);
        this.g = false;
        this.I = md0;
        this.G = gd0;
        this.E = new ArrayList();
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final e a() {
        return this.i;
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final v0 b(e2 e20, L3 l30, long v) {
        K2 k20 = this.k(e20);
        X1 x10 = new X1(this.d.c, 0, e20);
        v0 v00 = new e0(this.W, this.m, this.T, this.n, this.o, x10, this.r, k20, this.S, l30, this.j, this.I, this.G);
        this.E.add(v00);
        return v00;
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final void d(g0 g00) {
        this.T = g00;
        this.o.b();
        if(this.g) {
            this.S = new E4(16);
            this.t();
            return;
        }
        this.M = this.l.a();
        sa sa0 = new sa("SsMediaSource", this.G);
        this.N = sa0;
        this.S = sa0;
        this.X = L7.j(null);
        this.u();
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final void e(v0 v00) {
        Q4[] arr_q4 = ((e0)v00).r;
        for(int v = 0; v < arr_q4.length; ++v) {
            arr_q4[v].g(null);
        }
        ((e0)v00).n = null;
        this.E.remove(v00);
    }

    @Override  // i.n.i.b.a.s.e.db
    public final Jd f(gb gb0, long v, long v1, IOException iOException0, int v2) {
        ye ye0 = ((ld)gb0).d;
        Sd sd0 = new Sd(((ld)gb0).b, ye0.c, ye0.d, v, v1, ye0.b);
        Ca ca0 = new Ca(v2, iOException0);
        long v3 = this.r.c(ca0);
        Jd jd0 = v3 == 0x8000000000000001L ? sa.h : new Jd(0, v3);
        boolean z = jd0.b();
        this.B.i(sd0, ((ld)gb0).c, iOException0, !z);
        if(this.I != null) {
            M7.f(((ld)gb0).b.b, ye0.c, ye0.d, ((ld)gb0).h);
        }
        this.k = null;
        return jd0;
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final void l() {
        this.S.b();
    }

    @Override  // i.n.i.b.a.s.e.db
    public final void o(gb gb0, long v, long v1) {
        Sd sd0 = new Sd(((ld)gb0).b, ((ld)gb0).d.c, ((ld)gb0).d.d, v, v1, ((ld)gb0).d.b);
        this.r.getClass();
        this.B.n(sd0, ((ld)gb0).c);
        this.W = (u1)((ld)gb0).f;
        this.V = v - v1;
        d d0 = this.k;
        if(d0 != null) {
            this.V = d0.b - d0.c;
        }
        if(this.I != null) {
            M7.f(((ld)gb0).b.b, ((ld)gb0).d.c, ((ld)gb0).d.d, ((ld)gb0).h);
        }
        this.k = null;
        this.t();
        if(!this.W.d) {
            return;
        }
        long v2 = Math.max(0L, this.V + 5000L - SystemClock.elapsedRealtime());
        this.X.postDelayed(new c(this, 27), v2);
    }

    @Override  // i.n.i.b.a.s.e.db
    public final void r(gb gb0, long v, long v1, boolean z) {
        Sd sd0 = new Sd(((ld)gb0).b, ((ld)gb0).d.c, ((ld)gb0).d.d, v, v1, ((ld)gb0).d.b);
        this.r.getClass();
        this.B.f(sd0, ((ld)gb0).c);
        this.k = null;
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final void s() {
        this.W = this.g ? this.W : null;
        this.M = null;
        this.V = 0L;
        sa sa0 = this.N;
        if(sa0 != null) {
            sa0.h(null);
            this.N = null;
        }
        Handler handler0 = this.X;
        if(handler0 != null) {
            handler0.removeCallbacksAndMessages(null);
            this.X = null;
        }
        this.o.a();
    }

    public final void t() {
        long v16;
        long v15;
        N9 n90;
        t1[] arr_t11;
        for(int v = 0; true; ++v) {
            ArrayList arrayList0 = this.E;
            if(v >= arrayList0.size()) {
                break;
            }
            e0 e00 = (e0)arrayList0.get(v);
            u1 u10 = this.W;
            e00.o = u10;
            Q4[] arr_q4 = e00.r;
            for(int v1 = 0; v1 < arr_q4.length; ++v1) {
                Wd wd0 = (Wd)arr_q4[v1].e;
                t1 t10 = wd0.j.f[wd0.b];
                int v2 = t10.k;
                long[] arr_v = t10.o;
                t1 t11 = u10.f[wd0.b];
                if(v2 == 0 || t11.k == 0) {
                    wd0.k += v2;
                }
                else {
                    long v3 = arr_v[v2 - 1];
                    long v4 = t10.a(v2 - 1);
                    long v5 = t11.o[0];
                    if(v4 + v3 <= v5) {
                        wd0.k += v2;
                    }
                    else {
                        int v6 = wd0.k;
                        wd0.k = L7.y(arr_v, v5, true) + v6;
                    }
                }
                wd0.j = u10;
            }
            e00.n.b(e00);
        }
        t1[] arr_t1 = this.W.f;
        int v7 = arr_t1.length;
        long v8 = 0x8000000000000000L;
        int v9 = 0;
        long v10 = 0x7FFFFFFFFFFFFFFFL;
        while(v9 < v7) {
            t1 t12 = arr_t1[v9];
            long[] arr_v1 = t12.o;
            if(t12.k > 0) {
                arr_t11 = arr_t1;
                v10 = Math.min(v10, arr_v1[0]);
                v8 = Math.max(v8, t12.a(t12.k - 1) + arr_v1[t12.k - 1]);
            }
            else {
                arr_t11 = arr_t1;
            }
            ++v9;
            arr_t1 = arr_t11;
        }
        if(Long.compare(v10, 0x7FFFFFFFFFFFFFFFL) == 0) {
            n90 = new N9((this.W.d ? 0x8000000000000001L : 0L), 0L, 0L, 0L, true, this.W.d, this.W.d, this.W, this.i);
        }
        else {
            u1 u11 = this.W;
            if(u11.d) {
                long v11 = u11.h;
                if(v11 != 0x8000000000000001L && v11 > 0L) {
                    v10 = Math.max(v10, v8 - v11);
                }
                this.B.l(this.w);
                long v12 = v8 - v10;
                n90 = new N9(0x8000000000000001L, v12, v10, (v12 - b4.a(this.w) >= 5000000L ? v12 - b4.a(this.w) : Math.min(5000000L, v12 / 2L)), true, true, true, this.W, this.i);
            }
            else {
                long v13 = u11.g == 0x8000000000000001L ? v8 - v10 : u11.g;
                Gd gd0 = this.G;
                long v14 = gd0.B;
                if(v14 == 0x8000000000000001L) {
                    v16 = 0L;
                    v15 = v10;
                }
                else {
                    gd0.B = 0x8000000000000001L;
                    if(v14 > v13) {
                        v15 = v10;
                        v16 = v13;
                    }
                    else {
                        v16 = v14;
                        v15 = v10;
                    }
                }
                n90 = new N9(0x8000000000000001L, 0x8000000000000001L, v15 + v13, v13, v15, v16, true, false, this.W, this.i, null);
            }
        }
        this.c(n90);
    }

    public final void u() {
        if(this.N.l()) {
            return;
        }
        d d0 = this.k;
        K2 k20 = this.B;
        kd kd0 = this.D;
        Uri uri0 = this.h;
        if(d0 != null) {
            ld ld0 = new ld(new jd(d0), new W2(uri0), 4, kd0);
            long v = this.N.e(ld0, this, 0);
            k20.q(new Sd(ld0.b, v), ld0.c);
            return;
        }
        boolean z = this.G.D;
        if(uri0 == null) {
            throw new IllegalStateException("The uri must be set.");
        }
        W2 w20 = new W2(uri0, 1, null, this.j, 0L, -1L, null, ((int)z), 0x8000000000000001L, 0x8000000000000001L, 0x8000000000000001L);
        ld ld1 = new ld(this.M, w20, 4, kd0);
        if(this.I != null) {
            ld1.i = new a(this, 12);
        }
        long v1 = this.N.e(ld1, this, this.r.a(ld1.c));
        k20.q(new Sd(ld1.b, v1), ld1.c);
    }
}

