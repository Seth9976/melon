package i.n.i.b.a.s.e;

import Nf.p;
import R8.v;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.firebase.messaging.u;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class v5 implements U5, d7, db, hb, v0 {
    public e7[] B;
    public u5[] D;
    public boolean E;
    public boolean G;
    public boolean I;
    public u M;
    public sd N;
    public long S;
    public boolean T;
    public int V;
    public boolean W;
    public boolean X;
    public int Y;
    public long Z;
    public final Uri a;
    public final D0 b;
    public long b0;
    public final C2 c;
    public long c0;
    public final p d;
    public boolean d0;
    public final K2 e;
    public int e0;
    public final X1 f;
    public boolean f0;
    public final d6 g;
    public boolean g0;
    public final L3 h;
    public static final Map h0;
    public final long i;
    public static final i.n.i.b.a.s.e.u i0;
    public final sa j;
    public final sa k;
    public final v l;
    public final r5 m;
    public final r5 n;
    public final Handler o;
    public u0 r;
    public m9 w;

    static {
        HashMap hashMap0 = new HashMap();
        hashMap0.put("Icy-MetaData", "1");
        v5.h0 = Collections.unmodifiableMap(hashMap0);
        ob ob0 = new ob();
        ob0.a = "icy";
        ob0.k = "application/x-icy";
        v5.i0 = new i.n.i.b.a.s.e.u(ob0);
    }

    public v5(Uri uri0, D0 d00, sa sa0, C2 c20, X1 x10, p p0, K2 k20, d6 d60, L3 l30, int v, Gd gd0) {
        this.a = uri0;
        this.b = d00;
        this.c = c20;
        this.f = x10;
        this.d = p0;
        this.e = k20;
        this.g = d60;
        this.h = l30;
        this.i = (long)v;
        this.j = new sa("ProgressiveMediaPeriod", gd0);
        this.k = sa0;
        this.l = new v();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.m = new r5(this, 0);
        this.n = new r5(this, 1);
        this.o = L7.j(null);
        this.D = new u5[0];
        this.B = new e7[0];
        this.c0 = 0x8000000000000001L;
        this.Z = -1L;
        this.S = 0x8000000000000001L;
        this.V = 1;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long a(long v, Xb xb0) {
        this.j();
        if(!this.N.b()) {
            return 0L;
        }
        rd rd0 = this.N.b(v);
        return xb0.a(v, rd0.a.a, rd0.b.a);
    }

    // 去混淆评级： 低(20)
    @Override  // i.n.i.b.a.s.e.b8
    public final boolean a() {
        return this.j.m() && this.l.a;
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final boolean a(long v) {
        if(!this.f0) {
            sa sa0 = this.j;
            if(!sa0.l() && !this.d0 && (!this.G || this.Y != 0)) {
                boolean z = this.l.d();
                if(!sa0.m()) {
                    this.x();
                    return true;
                }
                return z;
            }
        }
        return false;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long b(long v) {
        this.j();
        boolean[] arr_z = (boolean[])this.M.b;
        if(!this.N.b()) {
            v = 0L;
        }
        this.X = false;
        this.b0 = v;
        if(this.s()) {
            this.c0 = v;
            return v;
        }
        if(this.V != 7) {
            int v2 = 0;
            while(v2 < this.B.length) {
                if(!this.B[v2].r(v, false) && (arr_z[v2] || !this.I)) {
                    goto label_17;
                }
                ++v2;
            }
            return v;
        }
    label_17:
        this.d0 = false;
        this.c0 = v;
        this.f0 = false;
        sa sa0 = this.j;
        if(sa0.m()) {
            e7[] arr_e7 = this.B;
            for(int v1 = 0; v1 < arr_e7.length; ++v1) {
                arr_e7[v1].v();
            }
            sa0.f();
            return v;
        }
        sa0.d = null;
        e7[] arr_e71 = this.B;
        for(int v3 = 0; v3 < arr_e71.length; ++v3) {
            arr_e71[v3].q(false);
        }
        return v;
    }

    public final e7 b(u5 u50) {
        int v = this.B.length;
        for(int v1 = 0; v1 < v; ++v1) {
            if(u50.equals(this.D[v1])) {
                return this.B[v1];
            }
        }
        Looper looper0 = this.o.getLooper();
        looper0.getClass();
        this.c.getClass();
        e7 e70 = new e7(this.h, looper0, this.c, this.f);
        e70.g = this;
        u5[] arr_u5 = (u5[])Arrays.copyOf(this.D, v + 1);
        arr_u5[v] = u50;
        this.D = arr_u5;
        e7[] arr_e7 = (e7[])Arrays.copyOf(this.B, v + 1);
        arr_e7[v] = e70;
        this.B = arr_e7;
        return e70;
    }

    @Override  // i.n.i.b.a.s.e.U5
    public final void b() {
        this.E = true;
        this.o.post(this.m);
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final void b(long v) {
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final long c() {
        long v1;
        this.j();
        boolean[] arr_z = (boolean[])this.M.b;
        if(this.f0) {
            return 0x8000000000000000L;
        }
        if(this.s()) {
            return this.c0;
        }
        if(this.I) {
            v1 = 0x7FFFFFFFFFFFFFFFL;
            for(int v = 0; v < this.B.length; ++v) {
                if(arr_z[v] && !this.B[v].x) {
                    v1 = Math.min(v1, this.B[v].z());
                }
            }
        }
        else {
            v1 = 0x7FFFFFFFFFFFFFFFL;
        }
        if(v1 == 0x7FFFFFFFFFFFFFFFL) {
            v1 = this.q();
        }
        return v1 == 0x8000000000000000L ? this.b0 : v1;
    }

    public final void c(int v) {
        this.j();
        u u0 = this.M;
        boolean[] arr_z = (boolean[])u0.d;
        if(!arr_z[v]) {
            i.n.i.b.a.s.e.u u1 = ((wc)u0.a).b[v].b[0];
            int v1 = mb.g(u1.l);
            this.e.c(v1, u1, 0, null, -1L, this.b0);
            arr_z[v] = true;
        }
    }

    @Override  // i.n.i.b.a.s.e.d7
    public final void d() {
        this.o.post(this.m);
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long e() {
        return 0L;
    }

    public final void e(int v) {
        this.j();
        if(this.d0 && ((boolean[])this.M.b)[v] && !this.B[v].l(false)) {
            this.c0 = 0L;
            this.d0 = false;
            this.X = true;
            this.b0 = 0L;
            this.e0 = 0;
            e7[] arr_e7 = this.B;
            for(int v1 = 0; v1 < arr_e7.length; ++v1) {
                arr_e7[v1].q(false);
            }
            u0 u00 = this.r;
            u00.getClass();
            u00.b(this);
        }
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final long f() {
        return this.Y == 0 ? 0x8000000000000000L : this.c();
    }

    @Override  // i.n.i.b.a.s.e.db
    public final Jd f(gb gb0, long v, long v1, IOException iOException0, int v2) {
        Jd jd0;
        if(this.Z == -1L) {
            this.Z = ((s5)gb0).k;
        }
        Sd sd0 = new Sd(((s5)gb0).j, ((s5)gb0).b.c, ((s5)gb0).b.d, v, v1, ((s5)gb0).b.b);
        b4.b(((s5)gb0).i);
        b4.b(this.S);
        Ca ca0 = new Ca(v2, iOException0);
        long v3 = this.d.c(ca0);
        if(Long.compare(v3, 0x8000000000000001L) == 0) {
            jd0 = sa.h;
        }
        else {
            int v4 = this.p();
            int v5 = v4 <= this.e0 ? 0 : 1;
            if(this.Z != -1L || this.N != null && this.N.d() != 0x8000000000000001L) {
                this.e0 = v4;
                jd0 = new Jd(v5, v3);
            }
            else if(this.G && !this.y()) {
                this.d0 = true;
                jd0 = sa.g;
            }
            else {
                this.X = this.G;
                this.b0 = 0L;
                this.e0 = 0;
                e7[] arr_e7 = this.B;
                for(int v6 = 0; v6 < arr_e7.length; ++v6) {
                    arr_e7[v6].q(false);
                }
                ((s5)gb0).f.a = 0L;
                ((s5)gb0).i = 0L;
                ((s5)gb0).h = true;
                ((s5)gb0).m = false;
                jd0 = new Jd(v5, v3);
            }
        }
        boolean z = jd0.b();
        this.e.h(sd0, 1, -1, null, 0, null, -1L, ((s5)gb0).i, this.S, iOException0, !z);
        return jd0;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long g() {
        return 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final wc h() {
        this.j();
        return (wc)this.M.a;
    }

    @Override  // i.n.i.b.a.s.e.U5
    public final ie i(int v, int v1) {
        return this.b(new u5(v, false));
    }

    public final void j() {
        M7.J(this.G);
        this.M.getClass();
        this.N.getClass();
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final void k() {
        int v = this.d.a(this.V);
        sa sa0 = this.j;
        IOException iOException0 = (IOException)sa0.d;
        if(iOException0 != null) {
            throw iOException0;
        }
        eb eb0 = (eb)sa0.c;
        if(eb0 != null) {
            if(v == 0x80000000) {
                v = eb0.b;
            }
            IOException iOException1 = eb0.d;
            if(iOException1 != null && eb0.e > v) {
                throw iOException1;
            }
        }
        if(this.f0 && !this.G) {
            throw new H4("Loading finished before preparation is complete.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long l() {
        return 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final void l(u0 u00, long v) {
        this.r = u00;
        this.l.d();
        this.x();
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long m() {
        if(this.X && (this.f0 || this.p() > this.e0)) {
            this.X = false;
            return this.b0;
        }
        return 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final boolean m(q2[] arr_q2, boolean[] arr_z, B7[] arr_b7) {
        return false;
    }

    @Override  // i.n.i.b.a.s.e.hb
    public final void n() {
        e7[] arr_e7 = this.B;
        for(int v = 0; v < arr_e7.length; ++v) {
            e7 e70 = arr_e7[v];
            e70.q(true);
            b1 b10 = e70.i;
            if(b10 != null) {
                b10.a(e70.e);
                e70.i = null;
                e70.h = null;
            }
        }
        sa sa0 = this.k;
        if(((q4)sa0.b) != null) {
            sa0.b = null;
        }
        sa0.d = null;
    }

    @Override  // i.n.i.b.a.s.e.db
    public final void o(gb gb0, long v, long v1) {
        if(this.S == 0x8000000000000001L) {
            sd sd0 = this.N;
            if(sd0 != null) {
                boolean z = sd0.b();
                long v2 = this.q();
                long v3 = v2 == 0x8000000000000000L ? 0L : v2 + 10000L;
                this.S = v3;
                this.g.t(v3, z, this.T);
            }
        }
        Sd sd1 = new Sd(((s5)gb0).j, ((s5)gb0).b.c, ((s5)gb0).b.d, v, v1, ((s5)gb0).b.b);
        this.d.getClass();
        this.e.o(sd1, 1, -1, null, 0, null, -1L, ((s5)gb0).i, this.S);
        if(this.Z == -1L) {
            this.Z = ((s5)gb0).k;
        }
        this.f0 = true;
        u0 u00 = this.r;
        u00.getClass();
        u00.b(this);
    }

    public final int p() {
        e7[] arr_e7 = this.B;
        int v1 = 0;
        for(int v = 0; v < arr_e7.length; ++v) {
            e7 e70 = arr_e7[v];
            v1 += e70.r + e70.q;
        }
        return v1;
    }

    public final long q() {
        e7[] arr_e7 = this.B;
        long v = 0x8000000000000000L;
        for(int v1 = 0; v1 < arr_e7.length; ++v1) {
            v = Math.max(v, arr_e7[v1].z());
        }
        return v;
    }

    @Override  // i.n.i.b.a.s.e.db
    public final void r(gb gb0, long v, long v1, boolean z) {
        Sd sd0 = new Sd(((s5)gb0).j, ((s5)gb0).b.c, ((s5)gb0).b.d, v, v1, ((s5)gb0).b.b);
        this.d.getClass();
        this.e.g(sd0, 1, -1, null, 0, null, -1L, ((s5)gb0).i, this.S);
        if(!z) {
            if(this.Z == -1L) {
                this.Z = ((s5)gb0).k;
            }
            e7[] arr_e7 = this.B;
            for(int v2 = 0; v2 < arr_e7.length; ++v2) {
                arr_e7[v2].q(false);
            }
            if(this.Y > 0) {
                u0 u00 = this.r;
                u00.getClass();
                u00.b(this);
            }
        }
    }

    public final boolean s() {
        return this.c0 != 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.U5
    public final void t(sd sd0) {
        P3 p30 = new P3(2, this, sd0);
        this.o.post(p30);
    }

    public final void u() {
        x8 x81;
        if(!this.g0 && !this.G && this.E && this.N != null) {
            e7[] arr_e7 = this.B;
            for(int v = 0; true; ++v) {
                if(v >= arr_e7.length) {
                    this.l.c();
                    int v1 = this.B.length;
                    vc[] arr_vc = new vc[v1];
                    boolean[] arr_z = new boolean[v1];
                    for(int v2 = 0; v2 < v1; ++v2) {
                        i.n.i.b.a.s.e.u u0 = this.B[v2].D();
                        u0.getClass();
                        boolean z = mb.h(u0.l);
                        boolean z1 = z || mb.j(u0.l);
                        arr_z[v2] = z1;
                        this.I |= z1;
                        m9 m90 = this.w;
                        if(m90 != null) {
                            int v3 = m90.a;
                            if(z || this.D[v2].b) {
                                x8 x80 = u0.j;
                                if(x80 == null) {
                                    x81 = new x8(new b[]{m90});
                                }
                                else {
                                    Object[] arr_object = Arrays.copyOf(x80.a, x80.a.length + 1);
                                    System.arraycopy(new b[]{m90}, 0, arr_object, x80.a.length, 1);
                                    x81 = new x8(((b[])arr_object));
                                }
                                ob ob0 = u0.a();
                                ob0.i = x81;
                                u0 = new i.n.i.b.a.s.e.u(ob0);
                            }
                            if(z && u0.f == -1 && u0.g == -1 && v3 != -1) {
                                ob ob1 = u0.a();
                                ob1.f = v3;
                                u0 = new i.n.i.b.a.s.e.u(ob1);
                            }
                        }
                        Class class0 = this.c.a(u0);
                        ob ob2 = u0.a();
                        ob2.D = class0;
                        arr_vc[v2] = new vc(new i.n.i.b.a.s.e.u[]{new i.n.i.b.a.s.e.u(ob2)});
                    }
                    wc wc0 = new wc(arr_vc);
                    u u1 = new u();  // 初始化器: Ljava/lang/Object;-><init>()V
                    u1.a = wc0;
                    u1.b = arr_z;
                    u1.c = new boolean[wc0.a];
                    u1.d = new boolean[wc0.a];
                    this.M = u1;
                    this.G = true;
                    u0 u00 = this.r;
                    u00.getClass();
                    u00.c(this);
                    break;
                }
                if(arr_e7[v].D() == null) {
                    break;
                }
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long v(q2[] arr_q2, boolean[] arr_z, B7[] arr_b7, boolean[] arr_z1, long v) {
        boolean z;
        this.j();
        u u0 = this.M;
        wc wc0 = (wc)u0.a;
        boolean[] arr_z2 = (boolean[])u0.c;
        int v1 = this.Y;
        int v2 = 0;
        for(int v3 = 0; v3 < arr_q2.length; ++v3) {
            B7 b70 = arr_b7[v3];
            if(b70 != null && (arr_q2[v3] == null || !arr_z[v3])) {
                M7.J(arr_z2[((t5)b70).a]);
                --this.Y;
                arr_z2[((t5)b70).a] = false;
                arr_b7[v3] = null;
            }
        }
        if(!this.W) {
            z = v != 0L;
        }
        else if(v1 == 0) {
            z = true;
        }
        else {
            z = false;
        }
        for(int v4 = 0; v4 < arr_q2.length; ++v4) {
            if(arr_b7[v4] == null) {
                q2 q20 = arr_q2[v4];
                if(q20 != null) {
                    M7.J(q20.c.length == 1);
                    M7.J(q20.c[0] == 0);
                    int v5 = wc0.a(q20.a);
                    M7.J(!arr_z2[v5]);
                    ++this.Y;
                    arr_z2[v5] = true;
                    arr_b7[v4] = new t5(this, v5);
                    arr_z1[v4] = true;
                    if(!z) {
                        e7 e70 = this.B[v5];
                        z = !e70.r(v, true) && e70.C() != 0;
                    }
                }
            }
        }
        if(this.Y == 0) {
            this.d0 = false;
            this.X = false;
            sa sa0 = this.j;
            if(sa0.m()) {
                e7[] arr_e7 = this.B;
                while(v2 < arr_e7.length) {
                    arr_e7[v2].v();
                    ++v2;
                }
                sa0.f();
            }
            else {
                e7[] arr_e71 = this.B;
                for(int v6 = 0; v6 < arr_e71.length; ++v6) {
                    arr_e71[v6].q(false);
                }
            }
        }
        else if(z) {
            v = this.b(v);
            while(v2 < arr_b7.length) {
                if(arr_b7[v2] != null) {
                    arr_z1[v2] = true;
                }
                ++v2;
            }
        }
        this.W = true;
        return v;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final void w(long v, boolean z) {
        this.j();
        if(!this.s()) {
            boolean[] arr_z = (boolean[])this.M.c;
            for(int v1 = 0; v1 < this.B.length; ++v1) {
                this.B[v1].p(v, z, arr_z[v1]);
            }
        }
    }

    public final void x() {
        s5 s50 = new s5(this, this.a, this.b, this.k, this, this.l);
        if(this.G) {
            M7.J(this.s());
            if(Long.compare(this.S, 0x8000000000000001L) != 0 && this.c0 > this.S) {
                this.f0 = true;
                this.c0 = 0x8000000000000001L;
                return;
            }
            sd sd0 = this.N;
            sd0.getClass();
            s50.f.a = sd0.b(this.c0).a.b;
            s50.i = this.c0;
            s50.h = true;
            s50.m = false;
            e7[] arr_e7 = this.B;
            for(int v = 0; v < arr_e7.length; ++v) {
                arr_e7[v].u = this.c0;
            }
            this.c0 = 0x8000000000000001L;
        }
        this.e0 = this.p();
        int v1 = this.d.a(this.V);
        long v2 = this.j.e(s50, this, v1);
        Sd sd1 = new Sd(s50.j, v2);
        this.e.r(sd1, 1, -1, null, 0, null, -1L, s50.i, this.S);
    }

    // 去混淆评级： 低(20)
    public final boolean y() {
        return this.X || this.s();
    }
}

