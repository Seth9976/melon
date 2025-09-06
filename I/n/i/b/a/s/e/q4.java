package i.n.i.b.a.s.e;

import Gf.l;
import Nf.p;
import android.os.Looper;
import android.util.Log;
import androidx.media3.exoplayer.j0;
import com.iloen.melon.utils.a;
import d5.v;
import ea.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jeb.synthetic.FIN;

public final class Q4 implements B7, b8, db, hb {
    public u B;
    public P4 D;
    public long E;
    public long G;
    public int I;
    public w0 M;
    public boolean N;
    public final int[] S;
    public final int a;
    public final int[] b;
    public final u[] c;
    public final boolean[] d;
    public final w5 e;
    public final Object f;
    public final K2 g;
    public final p h;
    public final sa i;
    public final l j;
    public final ArrayList k;
    public final List l;
    public final e7 m;
    public final e7[] n;
    public final v o;
    public final Md r;
    public w3 w;

    public Q4(int v, int[] arr_v, u[] arr_u, w5 w50, a8 a80, L3 l30, long v1, C2 c20, X1 x10, p p0, K2 k20, Md md0, Gd gd0) {
        this.a = v;
        if(arr_v == null) {
            arr_v = new int[0];
        }
        this.b = arr_v;
        if(arr_u == null) {
            arr_u = new u[0];
        }
        this.c = arr_u;
        this.e = w50;
        this.f = a80;
        this.g = k20;
        this.h = p0;
        this.r = md0;
        this.i = new sa("ChunkSampleStream", gd0);
        this.j = new l();
        ArrayList arrayList0 = new ArrayList();
        this.k = arrayList0;
        this.l = Collections.unmodifiableList(arrayList0);
        this.n = new e7[arr_v.length];
        this.d = new boolean[arr_v.length];
        int v3 = arr_v.length + 1;
        int[] arr_v1 = new int[v3];
        e7[] arr_e7 = new e7[v3];
        Looper looper0 = Looper.myLooper();
        looper0.getClass();
        c20.getClass();
        e7 e70 = new e7(l30, looper0, c20, x10);
        this.m = e70;
        arr_v1[0] = v;
        arr_e7[0] = e70;
        for(int v2 = 0; v2 < arr_v.length; ++v2) {
            e7 e71 = new e7(l30, null, null, null);
            this.n[v2] = e71;
            arr_e7[v2 + 1] = e71;
            arr_v1[v2 + 1] = this.b[v2];
        }
        int[] arr_v2 = new int[v3];
        this.S = arr_v2;
        Arrays.fill(arr_v2, -1);
        this.o = new v(arr_v1, arr_e7);
        this.E = v1;
        this.G = v1;
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final boolean a() {
        return this.i.m();
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final boolean a(long v) {
        long v6;
        long v2;
        List list0;
        if(!this.N) {
            sa sa0 = this.i;
            if(!sa0.m() && !sa0.l()) {
                boolean z = this.q();
                if(z) {
                    list0 = Collections.EMPTY_LIST;
                    v2 = this.E;
                }
                else {
                    v2 = this.p().h;
                    list0 = this.l;
                }
                this.e.k(v, v2, list0, this.j);
                boolean z1 = this.j.b;
                w3 w30 = (w3)this.j.c;
                this.j.c = null;
                this.j.b = false;
                if(z1) {
                    this.E = 0x8000000000000001L;
                    this.N = true;
                    return true;
                }
                if(w30 != null) {
                    this.w = w30;
                    v v3 = this.o;
                    if(w30 instanceof w0) {
                        if(z) {
                            long v4 = this.E;
                            if(((w0)w30).g != v4) {
                                this.m.u = v4;
                                e7[] arr_e7 = this.n;
                                for(int v5 = 0; v5 < arr_e7.length; ++v5) {
                                    arr_e7[v5].u = this.E;
                                }
                            }
                            this.E = 0x8000000000000001L;
                        }
                        ((w0)w30).o = v3;
                        e7[] arr_e71 = (e7[])v3.b;
                        int[] arr_v = new int[arr_e71.length];
                        for(int v1 = 0; v1 < arr_e71.length; ++v1) {
                            e7 e70 = arr_e71[v1];
                            arr_v[v1] = e70.r + e70.q;
                        }
                        ((w0)w30).r = arr_v;
                        this.k.add(((w0)w30));
                        v6 = ((w0)w30).l;
                    }
                    else {
                        if(w30 instanceof f7) {
                            ((f7)w30).m = v3;
                        }
                        v6 = -1L;
                    }
                    long v7 = sa0.e(w30, this, this.h.a(w30.c));
                    Sd sd0 = new Sd(w30.b, v7);
                    this.g.r(sd0, w30.c, this.a, w30.d, w30.e, w30.f, v6, w30.g, w30.h);
                    return true;
                }
            }
        }
        return false;
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final int b(b b0, I8 i80, int v) {
        if(!this.q()) {
            e7 e70 = this.m;
            if(this.M == null || this.M.d(0) > e70.C()) {
                this.s();
                return e70.i(b0, i80, v, this.N);
            }
        }
        return -3;
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final void b() {
        this.i.b();
        this.m.E();
        if(!this.i.m()) {
            this.e.b();
        }
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final void b(long v) {
        sa sa0 = this.i;
        if(!sa0.l() && !this.q()) {
            w5 w50 = this.e;
            ArrayList arrayList0 = this.k;
            if(sa0.m()) {
                w3 w30 = this.w;
                w30.getClass();
                if(!(w30 instanceof w0) || !this.j(arrayList0.size() - 1)) {
                    w50.a();
                }
            }
            else {
                int v1 = w50.j(v, this.l);
                if(v1 < arrayList0.size()) {
                    M7.J(!sa0.m());
                    int v2 = arrayList0.size();
                    while(true) {
                        if(v1 >= v2) {
                            v1 = -1;
                            break;
                        }
                        if(!this.j(v1)) {
                            break;
                        }
                        ++v1;
                    }
                    if(v1 != -1) {
                        long v3 = this.p().h;
                        w0 w00 = this.h(v1);
                        if(arrayList0.isEmpty()) {
                            this.E = this.G;
                        }
                        this.N = false;
                        this.g.b(this.a, w00.l, w00.g, v3);
                    }
                }
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final int c(long v) {
        if(this.q()) {
            return 0;
        }
        e7 e70 = this.m;
        int v1 = e70.h(v, this.N);
        w0 w00 = this.M;
        if(w00 != null) {
            v1 = Math.min(v1, w00.d(0) - e70.C());
        }
        e70.A(v1);
        this.s();
        return v1;
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final long c() {
        if(this.N) {
            return 0x8000000000000000L;
        }
        if(this.q()) {
            return this.E;
        }
        long v = this.G;
        w0 w00 = this.p();
        if(!w00.c()) {
            w00 = this.k.size() <= 1 ? null : ((w0)a.i(2, this.k));
        }
        if(w00 != null) {
            v = Math.max(v, w00.h);
        }
        return Math.max(v, this.m.z());
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final void c(q2 q20) {
        this.e.l(q20);
        ArrayList arrayList0 = this.k;
        if(!arrayList0.isEmpty()) {
            long v = ((w0)arrayList0.get(0)).g;
            long v1 = this.p().h;
            w0 w00 = null;
            long v2;
            for(v2 = this.p().g; !arrayList0.isEmpty(); v2 = v3) {
                w0 w01 = this.p();
                long v3 = w01.g;
                if(v3 - v <= 10000000L) {
                    break;
                }
                arrayList0.remove(arrayList0.size() - 1);
                w00 = w01;
            }
            if(w00 != null) {
                sa sa0 = this.i;
                if(sa0.m()) {
                    for(int v4 = 0; true; ++v4) {
                        int[] arr_v = this.S;
                        if(v4 >= arr_v.length) {
                            break;
                        }
                        arr_v[v4] = w00.d(v4);
                    }
                    sa0.f();
                }
                else {
                    int v5 = w00.d(0);
                    this.m.s(v5);
                }
                this.N = false;
                this.g.b(this.a, w00.l, v2, v1);
            }
        }
    }

    public final int d(int v, int v1) {
        ArrayList arrayList0;
        while(true) {
            ++v1;
            arrayList0 = this.k;
            if(v1 >= arrayList0.size()) {
                break;
            }
            if(((w0)arrayList0.get(v1)).d(0) > v) {
                return v1 - 1;
            }
        }
        return arrayList0.size() - 1;
    }

    // 去混淆评级： 低(20)
    @Override  // i.n.i.b.a.s.e.B7
    public final boolean d() {
        return !this.q() && this.m.l(this.N);
    }

    public static long e(e7 e70) {
        long v = e70.z();
        long v1 = e70.B();
        if(v1 == 0x8000000000000000L) {
            v1 = e70.y();
        }
        return v == 0x8000000000000000L || v1 == 0x8000000000000000L ? 0L : (v - v1) / 1000L;
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final long f() {
        if(this.q()) {
            return this.E;
        }
        return this.N ? 0x8000000000000000L : this.p().h;
    }

    @Override  // i.n.i.b.a.s.e.db
    public final Jd f(gb gb0, long v, long v1, IOException iOException0, int v2) {
        Jd jd4;
        boolean z1;
        Jd jd2;
        long v6;
        Jd jd0 = sa.g;
        ye ye0 = ((w3)gb0).i;
        long v3 = ye0.b;
        ArrayList arrayList0 = this.k;
        int v4 = arrayList0.size();
        Jd jd1 = sa.h;
        boolean z = Long.compare(v3, 0L) == 0 || !(((w3)gb0) instanceof w0) || !this.j(v4 - 1);
        long v5 = ((w3)gb0) instanceof w0 ? ((C7)(((w3)gb0))).l : -1L;
        Sd sd0 = new Sd(((w3)gb0).b, ye0.c, ye0.d, v, v1, v3);
        b4.b(((w3)gb0).g);
        b4.b(((w3)gb0).h);
        Ca ca0 = new Ca(v2, iOException0);
        p p0 = this.h;
        if(z) {
            p0.getClass();
            v6 = p.b(ca0);
        }
        else {
            v6 = 0x8000000000000001L;
        }
        if(!this.e.i(((w3)gb0), z, iOException0, v6)) {
            z1 = false;
            jd2 = null;
        }
        else if(z) {
            if(((w3)gb0) instanceof w0) {
                M7.J(this.h(v4 - 1) == ((w3)gb0));
                if(arrayList0.isEmpty()) {
                    this.E = this.G;
                }
            }
            jd2 = jd0;
            z1 = true;
        }
        else {
            Log.w("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
            z1 = false;
            jd2 = null;
        }
        e7 e70 = this.m;
        Jd jd3 = Jd.c;
        if(this.r != null) {
            M7.f(((w3)gb0).k.b, ye0.c, ye0.d, ye0.e);
            Q4.e(e70);
            if(z1 && jd3.a == 3) {
                jd3 = new Jd(2, jd3.b);
            }
            if(jd3.a == 3 && !(((w3)gb0) instanceof w0)) {
                jd3 = new Jd(2, jd3.b);
            }
        }
        int v7 = jd3.a;
        if(!z1 && v7 == 3) {
            if(this.j(v4 - 1)) {
                this.E = ((w0)arrayList0.remove(arrayList0.size() - 1)).g;
                e70.v();
                e7[] arr_e7 = this.n;
                for(int v8 = 0; v8 < arr_e7.length; ++v8) {
                    arr_e7[v8].q(false);
                }
            }
            else {
                w0 w00 = this.h(v4 - 1);
                M7.J(w00 == ((w3)gb0));
                if(arrayList0.isEmpty()) {
                    this.E = w00.g;
                }
            }
        }
        if(jd2 == null) {
            long v9 = p0.c(ca0);
            jd2 = v9 == 0x8000000000000001L ? jd1 : new Jd(0, v9);
            if(v7 == 3) {
                jd4 = jd0;
            }
            else {
                switch(v7) {
                    case 1: {
                        jd4 = jd1;
                        break;
                    }
                    case 2: {
                        long v10 = jd3.b;
                        if(v10 != -1L) {
                            v9 = v10;
                        }
                        jd4 = new Jd(1, v9);
                        break;
                    }
                    default: {
                        jd4 = jd2;
                    }
                }
            }
        }
        else {
            jd4 = jd2;
        }
        boolean z2 = jd4.b();
        this.g.h(sd0, ((w3)gb0).c, this.a, ((w3)gb0).d, ((w3)gb0).e, ((w3)gb0).f, v5, ((w3)gb0).g, ((w3)gb0).h, iOException0, !z2);
        if(!z2) {
            this.w = null;
            p0.getClass();
            ((a8)this.f).b(this);
        }
        return jd4;
    }

    public final void g(Gb gb0) {
        this.D = gb0;
        e7 e70 = this.m;
        e70.v();
        b1 b10 = e70.i;
        if(b10 != null) {
            b10.a(e70.e);
            e70.i = null;
            e70.h = null;
        }
        e7[] arr_e7 = this.n;
        for(int v = 0; v < arr_e7.length; ++v) {
            e7 e71 = arr_e7[v];
            e71.v();
            b1 b11 = e71.i;
            if(b11 != null) {
                b11.a(e71.e);
                e71.i = null;
                e71.h = null;
            }
        }
        this.i.h(this);
    }

    public final w0 h(int v) {
        w0 w00 = (w0)this.k.get(v);
        L7.n(this.k, v, this.k.size());
        this.I = Math.max(this.I, this.k.size());
        int v1 = 0;
        int v2 = w00.d(0);
        this.m.s(v2);
        while(true) {
            e7[] arr_e7 = this.n;
            if(v1 >= arr_e7.length) {
                break;
            }
            e7 e70 = arr_e7[v1];
            ++v1;
            e70.s(w00.d(v1));
        }
        return w00;
    }

    public final void i(long v) {
        boolean z;
        w0 w00;
        this.G = v;
        if(this.q()) {
            this.E = v;
            return;
        }
        int v1 = 0;
        int v2 = 0;
        while(true) {
            if(v2 < this.k.size()) {
                w00 = (w0)this.k.get(v2);
                int v3 = Long.compare(w00.g, v);
                if(v3 == 0 && w00.m == 0x8000000000000001L) {
                    break;
                }
                if(v3 <= 0) {
                    ++v2;
                    continue;
                }
            }
            w00 = null;
            break;
        }
        if(w00 == null) {
            boolean z1 = v < this.f();
            z = this.m.r(v, z1);
        }
        else {
            e7 e70 = this.m;
            int v4 = w00.d(0);
            __monitor_enter(e70);
            int v5 = FIN.finallyOpen$NT();
            __monitor_enter(e70);
            try {
                e70.t = 0;
                e70.a.f = (j0)e70.a.e;
            }
            catch(Throwable throwable0) {
                __monitor_exit(e70);
                FIN.finallyExec$NT(v5);
                throw throwable0;
            }
            __monitor_exit(e70);
            int v6 = e70.r;
            if(v4 < v6 || v4 > e70.q + v6) {
                FIN.finallyExec$NT(v5);
                z = false;
            }
            else {
                e70.u = 0x8000000000000000L;
                e70.t = v4 - v6;
                FIN.finallyCodeBegin$NT(v5);
                __monitor_exit(e70);
                FIN.finallyCodeEnd$NT(v5);
                z = true;
            }
        }
        if(z) {
            this.I = this.d(this.m.C(), 0);
            e7[] arr_e7 = this.n;
            while(v1 < arr_e7.length) {
                arr_e7[v1].r(v, true);
                ++v1;
            }
            return;
        }
        this.E = v;
        this.N = false;
        this.k.clear();
        this.I = 0;
        if(this.i.m()) {
            Arrays.fill(this.S, -1);
            this.m.v();
            e7[] arr_e71 = this.n;
            while(v1 < arr_e71.length) {
                arr_e71[v1].v();
                ++v1;
            }
            this.i.f();
            return;
        }
        this.i.d = null;
        this.m.q(false);
        e7[] arr_e72 = this.n;
        for(int v7 = 0; v7 < arr_e72.length; ++v7) {
            arr_e72[v7].q(false);
        }
        Arrays.fill(this.S, -1);
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final int j() {
        return this.k.isEmpty() ? -1 : ((w0)a.i(1, this.k)).d.h;
    }

    public final boolean j(int v) {
        w0 w00 = (w0)this.k.get(v);
        int v1 = w00.d(0);
        if(this.m.C() > v1) {
            return true;
        }
        int v2 = 0;
        while(true) {
            e7[] arr_e7 = this.n;
            if(v2 >= arr_e7.length) {
                break;
            }
            int v3 = arr_e7[v2].C();
            ++v2;
            if(v3 > w00.d(v2)) {
                return true;
            }
        }
        return false;
    }

    @Override  // i.n.i.b.a.s.e.hb
    public final void n() {
        e7 e70 = this.m;
        e70.q(true);
        b1 b10 = e70.i;
        if(b10 != null) {
            b10.a(e70.e);
            e70.i = null;
            e70.h = null;
        }
        e7[] arr_e7 = this.n;
        for(int v = 0; v < arr_e7.length; ++v) {
            e7 e71 = arr_e7[v];
            e71.q(true);
            b1 b11 = e71.i;
            if(b11 != null) {
                b11.a(e71.e);
                e71.i = null;
                e71.h = null;
            }
        }
        this.e.g();
        P4 p40 = this.D;
        if(p40 != null) {
            synchronized(((Gb)p40)) {
                b0 b00 = (b0)((Gb)p40).m.remove(this);
                if(b00 != null) {
                    e7 e72 = b00.a;
                    e72.q(true);
                    b1 b12 = e72.i;
                    if(b12 != null) {
                        b12.a(e72.e);
                        e72.i = null;
                        e72.h = null;
                    }
                }
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.db
    public final void o(gb gb0, long v, long v1) {
        this.w = null;
        this.e.h(((w3)gb0));
        ye ye0 = ((w3)gb0).i;
        Sd sd0 = new Sd(((w3)gb0).b, ye0.c, ye0.d, v, v1, ye0.b);
        this.h.getClass();
        this.g.o(sd0, ((w3)gb0).c, this.a, ((w3)gb0).d, ((w3)gb0).e, ((w3)gb0).f, (((w3)gb0) instanceof w0 ? ((C7)(((w3)gb0))).l : -1L), ((w3)gb0).g, ((w3)gb0).h);
        ((a8)this.f).b(this);
        if(this.r != null) {
            M7.f(((w3)gb0).k.b, ye0.c, ye0.d, ye0.e);
            Q4.e(this.m);
        }
    }

    public final w0 p() {
        return (w0)a.i(1, this.k);
    }

    public final boolean q() {
        return this.E != 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.db
    public final void r(gb gb0, long v, long v1, boolean z) {
        this.w = null;
        this.M = null;
        ye ye0 = ((w3)gb0).i;
        Sd sd0 = new Sd(((w3)gb0).b, ye0.c, ye0.d, v, v1, ye0.b);
        this.h.getClass();
        this.g.g(sd0, ((w3)gb0).c, this.a, ((w3)gb0).d, ((w3)gb0).e, ((w3)gb0).f, (((w3)gb0) instanceof w0 ? ((C7)(((w3)gb0))).l : -1L), ((w3)gb0).g, ((w3)gb0).h);
        e7 e70 = this.m;
        int[] arr_v = this.S;
        if(!z) {
            int v2 = 0;
            int v3 = arr_v[0];
            e7[] arr_e7 = this.n;
            if(v3 != -1) {
                e70.s(v3);
                while(v2 < arr_e7.length) {
                    e7 e71 = arr_e7[v2];
                    ++v2;
                    e71.s(arr_v[v2]);
                }
            }
            else if(this.q()) {
                e70.q(false);
                for(int v4 = 0; v4 < arr_e7.length; ++v4) {
                    arr_e7[v4].q(false);
                }
                Arrays.fill(arr_v, -1);
            }
            else if(((w3)gb0) instanceof w0) {
                this.h(this.k.size() - 1);
                if(this.k.isEmpty()) {
                    this.E = this.G;
                }
            }
            ((a8)this.f).b(this);
        }
        Arrays.fill(arr_v, -1);
        if(this.r != null) {
            M7.f(((w3)gb0).k.b, ye0.c, ye0.d, ye0.e);
            Q4.e(e70);
        }
    }

    public final void s() {
        int v = this.d(this.m.C(), this.I - 1);
        int v1;
        while((v1 = this.I) <= v) {
            this.I = v1 + 1;
            w0 w00 = (w0)this.k.get(v1);
            u u0 = w00.d;
            if(!u0.equals(this.B)) {
                this.g.c(this.a, u0, w00.e, w00.f, w00.l, w00.g);
            }
            this.B = u0;
        }
    }

    public final void w(long v, boolean z) {
        if(!this.q()) {
            e7 e70 = this.m;
            int v1 = e70.r;
            e70.p(v, z, true);
            int v2 = e70.r;
            if(v2 > v1) {
                long v3 = e70.y();
                for(int v4 = 0; true; ++v4) {
                    e7[] arr_e7 = this.n;
                    if(v4 >= arr_e7.length) {
                        break;
                    }
                    arr_e7[v4].p(v3, z, this.d[v4]);
                }
            }
            int v5 = Math.min(this.d(v2, 0), this.I);
            if(v5 > 0) {
                L7.n(this.k, 0, v5);
                this.I -= v5;
            }
        }
    }
}

