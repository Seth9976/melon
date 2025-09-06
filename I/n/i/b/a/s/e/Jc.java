package i.n.i.b.a.s.e;

import Nf.p;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.SparseArray;
import b3.x;
import com.iloen.melon.custom.S0;
import com.iloen.melon.fragments.radio.a;
import h9.d;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import o9.b;

public final class jc extends a6 {
    public final Object B;
    public final SparseArray D;
    public final ec E;
    public final ec G;
    public final fc I;
    public final Lb M;
    public final Md N;
    public final long S;
    public final Gd T;
    public D0 V;
    public sa W;
    public g0 X;
    public Oa Y;
    public Handler Z;
    public c b0;
    public Uri c0;
    public final Uri d0;
    public final Map e0;
    public d f0;
    public final e g;
    public p1 g0;
    public final boolean h;
    public boolean h0;
    public final b i;
    public long i0;
    public final d3 j;
    public long j0;
    public final E4 k;
    public long k0;
    public final C2 l;
    public int l0;
    public final p m;
    public long m0;
    public final long n;
    public int n0;
    public final K2 o;
    public final kd r;
    public final fc w;

    static {
        pa.a("goog.exo.dash");
    }

    public jc(e e0, d d0, b b0, kd kd0, d3 d30, E4 e40, C2 c20, p p0, long v, Md md0, long v1, Gd gd0) {
        this.g = e0;
        this.b0 = e0.c;
        e0.b.getClass();
        this.c0 = e0.b.a;
        this.d0 = e0.b.a;
        this.g0 = null;
        this.e0 = e0.b.b;
        this.f0 = d0;
        this.i = b0;
        this.r = kd0;
        this.j = d30;
        this.l = c20;
        this.m = p0;
        this.n = v;
        this.k = e40;
        this.N = md0;
        this.S = v1;
        this.T = gd0;
        this.h = false;
        this.o = this.k(null);
        this.B = new Object();
        this.D = new SparseArray();
        this.I = new fc(this, 1);
        this.m0 = 0x8000000000000001L;
        this.k0 = 0x8000000000000001L;
        this.w = new fc(this, 2);
        this.M = new fc(this, 3);
        this.E = new ec(this, 0);
        this.G = new ec(this, 1);
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final e a() {
        return this.g;
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final v0 b(e2 e20, L3 l30, long v) {
        int v1 = ((int)(((Integer)e20.a))) - this.n0;
        g4 g40 = this.g0.a(v1);
        K2 k20 = new K2(this.c.c, 0, e20, g40.b);
        X1 x10 = new X1(this.d.c, 0, e20);
        int v2 = this.n0 + v1;
        v0 v00 = new Gb(v2, this.g0, v1, this.j, this.X, this.l, x10, this.m, k20, this.k0, this.M, l30, this.k, this.I, this.e0, this.N, this.T);
        this.D.put(v2, v00);
        return v00;
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final void d(g0 g00) {
        this.X = g00;
        this.l.b();
        if(this.h) {
            this.w(false);
            return;
        }
        this.V = this.i.a();
        this.W = new sa("DashMediaSource", this.T);
        this.Z = L7.j(null);
        this.z();
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final void e(v0 v00) {
        ((Gb)v00).l.i = true;
        ((Gb)v00).l.d.removeCallbacksAndMessages(null);
        Q4[] arr_q4 = ((Gb)v00).E;
        for(int v = 0; v < arr_q4.length; ++v) {
            arr_q4[v].g(((Gb)v00));
        }
        ((Gb)v00).D = null;
        this.D.remove(((Gb)v00).a);
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final void l() {
        this.M.b();
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final void s() {
        this.h0 = false;
        this.V = null;
        sa sa0 = this.W;
        if(sa0 != null) {
            sa0.h(null);
            this.W = null;
        }
        this.i0 = 0L;
        this.j0 = 0L;
        this.g0 = this.h ? this.g0 : null;
        this.c0 = this.d0;
        this.Y = null;
        Handler handler0 = this.Z;
        if(handler0 != null) {
            handler0.removeCallbacksAndMessages(null);
            this.Z = null;
        }
        this.k0 = 0x8000000000000001L;
        this.l0 = 0;
        this.m0 = 0x8000000000000001L;
        this.n0 = 0;
        this.D.clear();
        this.l.a();
    }

    public final void t(d5.c c0, kd kd0) {
        D0 d00 = this.V;
        Uri uri0 = Uri.parse(((String)c0.c));
        Map map0 = Collections.EMPTY_MAP;
        if(uri0 == null) {
            throw new IllegalStateException("The uri must be set.");
        }
        this.u(new ld(d00, new W2(uri0, 1, null, map0, 0L, -1L, null, 1, 0x8000000000000001L, 0x8000000000000001L, 0x8000000000000001L), 5, kd0), new fc(this, 4), 1);
    }

    public final void u(ld ld0, db db0, int v) {
        long v1 = this.W.e(ld0, db0, v);
        Sd sd0 = new Sd(ld0.b, v1);
        this.o.q(sd0, ld0.c);
    }

    public static boolean v(g4 g40) {
        List list0 = g40.c;
        for(int v = 0; v < list0.size(); ++v) {
            switch(((x0)list0.get(v)).b) {
                case 1: 
                case 2: {
                    return true;
                }
            }
        }
        return false;
    }

    public final void w(boolean z) {
        long v47;
        long v46;
        float f4;
        float f2;
        long v38;
        int v31;
        long v34;
        int v24;
        long v20;
        long v19;
        long v15;
        int v = 0;
        while(true) {
            SparseArray sparseArray0 = this.D;
            if(v >= sparseArray0.size()) {
                break;
            }
            int v1 = sparseArray0.keyAt(v);
            if(v1 >= this.n0) {
                Gb gb0 = (Gb)sparseArray0.valueAt(v);
                p1 p10 = this.g0;
                int v2 = v1 - this.n0;
                gb0.M = p10;
                gb0.N = v2;
                c0 c00 = gb0.l;
                c00.h = false;
                c00.f = p10;
                Iterator iterator0 = c00.e.entrySet().iterator();
                while(iterator0.hasNext()) {
                    Object object0 = iterator0.next();
                    if(((long)(((Long)((Map.Entry)object0).getKey()))) < c00.f.h) {
                        iterator0.remove();
                    }
                }
                Q4[] arr_q4 = gb0.E;
                if(arr_q4 != null) {
                    int v3 = arr_q4.length;
                    int v4 = 0;
                    while(v4 < v3) {
                        qe qe0 = (qe)arr_q4[v4].e;
                        try {
                            qe0.m = p10;
                            qe0.n = v2;
                            long v5 = p10.d(v2);
                            ArrayList arrayList0 = qe0.c();
                        label_30:
                            for(int v6 = 0; v6 < qe0.k.length; ++v6) {
                                z5 z50 = (z5)arrayList0.get(qe0.l.c[v6]);
                                pe[] arr_pe = qe0.k;
                                arr_pe[v6] = arr_pe[v6].a(v5, z50);
                            }
                        }
                        catch(F6 f60) {
                            qe0.p = f60;
                            if(true) {
                                goto label_39;
                            }
                            goto label_30;
                        }
                    label_39:
                        ++v4;
                    }
                    gb0.D.b(gb0);
                }
                gb0.S = p10.a(v2).d;
                z[] arr_z = gb0.G;
                for(int v7 = 0; v7 < arr_z.length; ++v7) {
                    z z1 = arr_z[v7];
                    for(Object object1: gb0.S) {
                        y3 y30 = (y3)object1;
                        if(y30.a().equals(z1.e.a())) {
                            z1.a(y30, p10.d && v2 == p10.m.size() - 1);
                            break;
                        }
                        if(false) {
                            break;
                        }
                    }
                }
            }
            ++v;
        }
        g4 g40 = this.g0.a(0);
        int v8 = this.g0.m.size();
        g4 g41 = this.g0.a(v8 - 1);
        long v9 = this.g0.d(v8 - 1);
        long v10 = b4.a(L7.h(this.k0));
        long v11 = this.g0.d(0);
        List list0 = g40.c;
        long v12 = b4.a(g40.b);
        boolean z2 = jc.v(g40);
        long v13 = v12;
        for(int v14 = 0; true; ++v14) {
            if(v14 >= list0.size()) {
                v15 = v13;
                break;
            }
            x0 x00 = (x0)list0.get(v14);
            List list1 = x00.c;
            if((!z2 || x00.b != 3) && !list1.isEmpty()) {
                Wc wc0 = ((z5)list1.get(0)).f();
                if(wc0 == null || wc0.g(v11, v10) == 0L) {
                    v15 = v12;
                    break;
                }
                v13 = Math.max(v13, wc0.a(wc0.h(v11, v10)) + v12);
            }
        }
        List list2 = g41.c;
        long v16 = b4.a(g41.b);
        boolean z3 = jc.v(g41);
        long v17 = 0x7FFFFFFFFFFFFFFFL;
        int v18 = 0;
        while(true) {
            if(v18 >= list2.size()) {
                v20 = v17;
                break;
            }
            x0 x01 = (x0)list2.get(v18);
            List list3 = x01.c;
            if(z3) {
                v19 = v16;
                if(x01.b != 3) {
                    goto label_96;
                }
            }
            else {
                v19 = v16;
            label_96:
                if(!list3.isEmpty()) {
                    Wc wc1 = ((z5)list3.get(0)).f();
                    if(wc1 == null) {
                        v20 = v19 + v9;
                        break;
                    }
                    long v21 = wc1.g(v9, v10);
                    if(v21 == 0L) {
                        v20 = v19;
                        break;
                    }
                    long v22 = wc1.h(v9, v10) + v21 - 1L;
                    long v23 = wc1.a(v22);
                    v17 = Math.min(v17, wc1.c(v22, v9) + (v23 + v19));
                }
            }
            ++v18;
            v16 = v19;
        }
        if(this.g0.d) {
            v24 = 1;
            int v25 = 0;
            while(true) {
                if(v25 >= list2.size()) {
                    goto label_122;
                }
                Wc wc2 = ((z5)((x0)list2.get(v25)).c.get(0)).f();
                if(wc2 == null || wc2.a()) {
                    break;
                }
                ++v25;
            }
        }
        v24 = 0;
    label_122:
        if(v24 != 0) {
            long v26 = this.g0.f;
            if(v26 != 0x8000000000000001L) {
                v15 = Math.max(v15, v20 - b4.a(v26));
            }
        }
        long v27 = v20 - v15;
        p1 p11 = this.g0;
        Gd gd0 = this.T;
        if(p11.d) {
            M7.J(p11.a != 0x8000000000000001L);
            long v28 = v10 - b4.a(this.g0.a) - v15;
            c c0 = this.g.c;
            long v29 = c0.c;
            if(v29 == 0x8000000000000001L) {
                x x0 = this.g0.j;
                if(x0 == null) {
                    v29 = b4.b(v28);
                }
                else {
                    v29 = x0.c;
                    if(v29 == 0x8000000000000001L) {
                        v29 = b4.b(v28);
                    }
                }
            }
            long v30 = c0.b;
            if(v30 == 0x8000000000000001L) {
                x x1 = this.g0.j;
                if(x1 == null) {
                label_150:
                    long v32 = b4.b(v28 - v27);
                    if(v32 < 0L && v29 > 0L) {
                        v32 = 0L;
                    }
                    v31 = v24;
                    long v33 = this.g0.c;
                    if(v33 == 0x8000000000000001L) {
                        v34 = v32;
                    }
                    else {
                        v30 = Math.min(v32 + v33, v29);
                        goto label_161;
                    }
                }
                else {
                    v30 = x1.b;
                    if(v30 != 0x8000000000000001L) {
                        v31 = v24;
                        goto label_161;
                    }
                    goto label_150;
                }
            }
            else {
                v31 = v24;
            label_161:
                v34 = v30;
            }
            long v35 = this.b0.a;
            if(v35 == 0x8000000000000001L) {
                p1 p12 = this.g0;
                x x2 = p12.j;
                if(x2 == null) {
                label_171:
                    v35 = p12.g;
                    if(v35 == 0x8000000000000001L) {
                        v35 = this.n;
                    }
                }
                else {
                    long v36 = x2.a;
                    if(v36 != 0x8000000000000001L) {
                        v35 = v36;
                        goto label_174;
                    }
                    goto label_171;
                }
            }
        label_174:
            if(v35 < v34) {
                v35 = v34;
            }
            long v37 = v35;
            if(Long.compare(v35, v29) > 0) {
                v38 = v29;
                v37 = L7.A(b4.b(v28 - Math.min(5000000L, v27 / 2L)), v34, v38);
            }
            else {
                v38 = v29;
            }
            float f = c0.d;
            float f1 = -3.402823E+38f;
            if(f == -3.402823E+38f) {
                x x3 = this.g0.j;
                f2 = x3 == null ? -3.402823E+38f : x3.d;
            }
            else {
                f2 = f;
            }
            float f3 = c0.e;
            if(f3 == -3.402823E+38f) {
                x x4 = this.g0.j;
                if(x4 != null) {
                    f1 = x4.e;
                }
                f4 = f1;
            }
            else {
                f4 = f3;
            }
            this.b0 = new c(v37, v34, v38, f2, f4);
            long v39 = this.g0.a;
            long v40 = b4.b(v15);
            long v41 = v28 - b4.a(this.b0.a);
            long v42 = Math.min(5000000L, v27 / 2L);
            long v43 = this.S;
            if(v43 != 0x8000000000000001L) {
                v41 = v27 - b4.a(v43);
            }
            if(v41 >= v42) {
                v42 = v41;
            }
            long v44 = gd0.B;
            if(v44 != 0x8000000000000001L) {
                gd0.B = 0x8000000000000001L;
                v42 = v27 - this.b0.a >= 0L ? v27 - this.b0.a : 0L;
                if(v44 <= v42) {
                    v42 = v44;
                }
            }
            long v45 = b4.b(v27 - v42);
            this.o.l(v45);
            v46 = v42;
            v47 = v39 + v40;
        }
        else {
            v31 = v24;
            long v48 = gd0.B;
            if(v48 == 0x8000000000000001L) {
                v46 = 0L;
            }
            else {
                gd0.B = 0x8000000000000001L;
                v46 = v48 > v27 ? v27 : v48;
            }
            v47 = 0x8000000000000001L;
        }
        this.c(new gc(this.g0.a, v47, this.k0, this.n0, v15 - b4.a(g40.b), v27, v46, this.g0, this.g, (this.g0.d ? this.b0 : null)));
        if(!this.h) {
            ec ec0 = this.G;
            this.Z.removeCallbacks(ec0);
            if(v31 != 0) {
                Handler handler0 = this.Z;
                p1 p13 = this.g0;
                long v49 = L7.h(this.k0);
                int v50 = p13.m.size();
                g4 g42 = p13.a(v50 - 1);
                List list4 = g42.c;
                long v51 = b4.a(g42.b);
                long v52 = p13.d(v50 - 1);
                long v53 = b4.a(v49);
                long v54 = b4.a(p13.a);
                long v55 = 5000000L;
                for(int v56 = 0; v56 < list4.size(); ++v56) {
                    List list5 = ((x0)list4.get(v56)).c;
                    if(!list5.isEmpty()) {
                        Wc wc3 = ((z5)list5.get(0)).f();
                        if(wc3 != null) {
                            long v57 = wc3.j(v52, v53) + (v54 + v51) - v53;
                            if(v57 < v55 - 100000L || v57 > v55 && v57 < v55 + 100000L) {
                                v55 = v57;
                            }
                        }
                    }
                }
                RoundingMode roundingMode0 = RoundingMode.CEILING;
                roundingMode0.getClass();
                long v58 = v55 / 1000L;
                long v59 = v55 - 1000L * v58;
                int v60 = Long.compare(v59, 0L);
                if(v60 != 0) {
                    int v61 = ((int)((v55 ^ 1000L) >> 0x3F)) | 1;
                    switch(sc.a[roundingMode0.ordinal()]) {
                        case 1: {
                            if(v60 != 0) {
                                throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
                            }
                            break;
                        }
                        case 2: {
                            break;
                        }
                        case 3: {
                            if(v61 < 0) {
                                v58 += (long)v61;
                                break;
                            }
                            break;
                        }
                        case 4: {
                            v58 += (long)v61;
                            break;
                        }
                        case 5: {
                            if(v61 > 0) {
                                v58 += (long)v61;
                                break;
                            }
                            break;
                        }
                        case 6: 
                        case 7: 
                        case 8: {
                            long v62 = Math.abs(v59);
                            int v63 = Long.compare(v62 - (1000L - v62), 0L);
                            if(v63 != 0 && v63 > 0) {
                                v58 += (long)v61;
                            }
                            break;
                        }
                        default: {
                            throw new AssertionError();
                        }
                    }
                }
                handler0.postDelayed(ec0, v58);
            }
            if(this.h0) {
                this.z();
                return;
            }
            if(z) {
                p1 p14 = this.g0;
                if(p14.d) {
                    long v64 = p14.e;
                    if(v64 != 0x8000000000000001L) {
                        long v65 = Math.max(0L, this.i0 + (v64 == 0L ? 5000L : v64) - SystemClock.elapsedRealtime());
                        this.Z.postDelayed(this.E, v65);
                    }
                }
            }
        }
    }

    public final void x(ld ld0, long v, long v1) {
        Sd sd0 = new Sd(ld0.b, ld0.d.c, ld0.d.d, v, v1, ld0.d.b);
        this.m.getClass();
        this.o.f(sd0, ld0.c);
    }

    public final void y() {
        sa sa0 = this.W;
        fc fc0 = new fc(this, 0);
        synchronized(Ja.f) {
        }
        if(Ja.g) {
            fc0.a();
            return;
        }
        if(sa0 == null) {
            Gd.h0.b();
            sa0 = new sa("SntpClient", Gd.h0);
        }
        sa0.e(new E4(8), new S0(fc0, 22), 1);
    }

    public final void z() {
        Uri uri0;
        boolean z = true;
        this.Z.removeCallbacks(this.E);
        if(this.W.l()) {
            return;
        }
        if(this.W.m()) {
            this.h0 = true;
            return;
        }
        synchronized(this.B) {
            if(this.f0 == null || ((Uri)this.f0.e).equals(this.c0)) {
                z = false;
            }
        }
        if(!z) {
            d d0 = this.f0;
            if(d0 != null) {
                this.h0 = false;
                this.u(new ld(new jd(d0), new W2(this.c0), 4, this.r), this.w, 0);
                return;
            }
        }
        synchronized(this.B) {
            uri0 = this.c0;
        }
        boolean z1 = this.T.D;
        Map map0 = this.e0 == null ? Collections.EMPTY_MAP : this.e0;
        if(uri0 == null) {
            throw new IllegalStateException("The uri must be set.");
        }
        W2 w20 = new W2(uri0, 1, null, map0, 0L, -1L, null, ((int)z1), 0x8000000000000001L, 0x8000000000000001L, 0x8000000000000001L);
        this.h0 = false;
        ld ld0 = new ld(this.V, w20, 4, this.r);
        if(this.N != null) {
            ld0.i = new a(this, 26);
        }
        int v1 = this.m.a(4);
        this.u(ld0, this.w, v1);
    }
}

