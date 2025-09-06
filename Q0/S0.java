package Q0;

import B0.b;
import B0.e;
import B0.g;
import P0.q0;
import android.os.Build.VERSION;
import android.view.ViewParent;
import df.v;
import k8.Y;
import r1.c;
import r1.j;
import r1.l;
import r1.m;
import we.a;
import we.n;
import y0.F;
import y0.G;
import y0.H;
import y0.I;
import y0.M;
import y0.N;
import y0.U;
import y0.q;
import y0.s;
import y0.z;

public final class s0 implements q0 {
    public boolean B;
    public boolean D;
    public boolean E;
    public final b G;
    public e a;
    public final z b;
    public final u c;
    public n d;
    public a e;
    public long f;
    public boolean g;
    public final float[] h;
    public float[] i;
    public boolean j;
    public c k;
    public m l;
    public final A0.b m;
    public int n;
    public long o;
    public M r;
    public boolean w;

    public s0(e e0, z z0, u u0, n n0, a a0) {
        this.a = e0;
        this.b = z0;
        this.c = u0;
        this.d = n0;
        this.e = a0;
        this.f = 0x7FFFFFFF7FFFFFFFL;
        this.h = F.a();
        this.k = v.c();
        this.l = m.a;
        this.m = new A0.b();
        this.o = U.b;
        this.D = true;
        this.G = new b(this, 19);
    }

    @Override  // P0.q0
    public final void a(float[] arr_f) {
        F.e(arr_f, this.m());
    }

    @Override  // P0.q0
    public final void b(q q0, e e0) {
        this.k();
        this.E = this.a.a.K() > 0.0f;
        this.m.b.t(q0);
        this.m.b.b = e0;
        y5.a.z(this.m, this.a);
    }

    @Override  // P0.q0
    public final long c(long v, boolean z) {
        float[] arr_f;
        if(z) {
            arr_f = this.l();
            if(arr_f == null) {
                return 0x7F8000007F800000L;
            }
        }
        else {
            arr_f = this.m();
        }
        return this.D ? v : F.b(v, arr_f);
    }

    @Override  // P0.q0
    public final void d(long v) {
        if(!l.b(v, this.f)) {
            this.f = v;
            if(!this.j && !this.g) {
                u u0 = this.c;
                u0.invalidate();
                if(!this.j) {
                    this.j = true;
                    u0.w(this, true);
                }
            }
        }
    }

    @Override  // P0.q0
    public final void destroy() {
        this.d = null;
        this.e = null;
        this.g = true;
        u u0 = this.c;
        if(this.j) {
            this.j = false;
            u0.w(this, false);
        }
        z z0 = this.b;
        if(z0 != null) {
            z0.b(this.a);
            u0.F(this);
        }
    }

    @Override  // P0.q0
    public final void e(N n0) {
        int v = n0.a | this.n;
        this.l = n0.E;
        this.k = n0.D;
        if((v & 0x1000) != 0) {
            this.o = n0.n;
        }
        if((v & 1) != 0) {
            float f = n0.b;
            g g0 = this.a.a;
            if(g0.C() != f) {
                g0.e(f);
            }
        }
        if((v & 2) != 0) {
            float f1 = n0.c;
            g g1 = this.a.a;
            if(g1.L() != f1) {
                g1.k(f1);
            }
        }
        if((v & 4) != 0) {
            float f2 = n0.d;
            g g2 = this.a.a;
            if(g2.a() != f2) {
                g2.l(f2);
            }
        }
        if((v & 8) != 0) {
            float f3 = n0.e;
            g g3 = this.a.a;
            if(g3.H() != f3) {
                g3.m(f3);
            }
        }
        if((v & 16) != 0) {
            float f4 = n0.f;
            g g4 = this.a.a;
            if(g4.G() != f4) {
                g4.b(f4);
            }
        }
        boolean z = true;
        if((v & 0x20) != 0) {
            e e0 = this.a;
            float f5 = n0.g;
            g g5 = e0.a;
            if(g5.K() != f5) {
                g5.D(f5);
                e0.g = true;
                e0.a();
            }
            if(n0.g > 0.0f && !this.E) {
                a a0 = this.e;
                if(a0 != null) {
                    a0.invoke();
                }
            }
        }
        if((v & 0x40) != 0) {
            long v1 = n0.h;
            g g6 = this.a.a;
            if(!s.d(v1, g6.u())) {
                g6.w(v1);
            }
        }
        if((v & 0x80) != 0) {
            long v2 = n0.i;
            g g7 = this.a.a;
            if(!s.d(v2, g7.v())) {
                g7.z(v2);
            }
        }
        if((v & 0x400) != 0) {
            float f6 = n0.l;
            g g8 = this.a.a;
            if(g8.t() != f6) {
                g8.j(f6);
            }
        }
        if((v & 0x100) != 0) {
            float f7 = n0.j;
            g g9 = this.a.a;
            if(g9.I() != f7) {
                g9.g(f7);
            }
        }
        if((v & 0x200) != 0) {
            float f8 = n0.k;
            g g10 = this.a.a;
            if(g10.s() != f8) {
                g10.h(f8);
            }
        }
        if((v & 0x800) != 0) {
            float f9 = n0.m;
            g g11 = this.a.a;
            if(g11.x() != f9) {
                g11.f(f9);
            }
        }
        if((v & 0x1000) != 0) {
            if(U.a(this.o, U.b)) {
                e e1 = this.a;
                if(!x0.b.b(e1.v, 0x7FC000007FC00000L)) {
                    e1.v = 0x7FC000007FC00000L;
                    e1.a.F(0x7FC000007FC00000L);
                }
            }
            else {
                e e2 = this.a;
                long v3 = ((long)Float.floatToRawIntBits(U.c(this.o) * ((float)(((int)(this.f & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(U.b(this.o) * ((float)(((int)(this.f >> 0x20)))))) << 0x20;
                if(!x0.b.b(e2.v, v3)) {
                    e2.v = v3;
                    e2.a.F(v3);
                }
            }
        }
        if((v & 0x4000) != 0) {
            e e3 = this.a;
            boolean z1 = n0.r;
            if(e3.w != z1) {
                e3.w = z1;
                e3.g = true;
                e3.a();
            }
        }
        if((0x20000 & v) != 0) {
            y0.n n1 = n0.G;
            g g12 = this.a.a;
            if(!kotlin.jvm.internal.q.b(g12.o(), n1)) {
                g12.i(n1);
            }
        }
        if((0x8000 & v) != 0) {
            int v4 = 2;
            e e4 = this.a;
            int v5 = n0.w;
            if(v5 == 0) {
                v4 = 0;
            }
            else if(v5 == 1) {
                v4 = 1;
            }
            else if(v5 != 2) {
                throw new IllegalStateException("Not supported composition strategy");
            }
            g g13 = e4.a;
            if(g13.p() != v4) {
                g13.J(v4);
            }
        }
        if((v & 0x1F1B) != 0) {
            this.w = true;
            this.B = true;
        }
        if(kotlin.jvm.internal.q.b(this.r, n0.I)) {
            z = false;
        }
        else {
            M m0 = n0.I;
            this.r = m0;
            if(m0 != null) {
                e e5 = this.a;
                if(m0 instanceof H) {
                    e5.h(((long)Float.floatToRawIntBits(((H)m0).e.a)) << 0x20 | ((long)Float.floatToRawIntBits(((H)m0).e.b)) & 0xFFFFFFFFL, ((long)Float.floatToRawIntBits(((H)m0).e.c - ((H)m0).e.a)) << 0x20 | ((long)Float.floatToRawIntBits(((H)m0).e.d - ((H)m0).e.b)) & 0xFFFFFFFFL, 0.0f);
                }
                else if(m0 instanceof G) {
                    e5.k = null;
                    e5.i = 0x7FC000007FC00000L;
                    e5.h = 0L;
                    e5.j = 0.0f;
                    e5.g = true;
                    e5.n = false;
                    e5.l = ((G)m0).e;
                    e5.a();
                }
                else if(m0 instanceof I) {
                    y0.g g14 = ((I)m0).f;
                    if(g14 == null) {
                        e5.h(((long)Float.floatToRawIntBits(((I)m0).e.a)) << 0x20 | ((long)Float.floatToRawIntBits(((I)m0).e.b)) & 0xFFFFFFFFL, ((long)Float.floatToRawIntBits(((I)m0).e.b())) << 0x20 | ((long)Float.floatToRawIntBits(((I)m0).e.a())) & 0xFFFFFFFFL, Float.intBitsToFloat(((int)(((I)m0).e.h >> 0x20))));
                    }
                    else {
                        e5.k = null;
                        e5.i = 0x7FC000007FC00000L;
                        e5.h = 0L;
                        e5.j = 0.0f;
                        e5.g = true;
                        e5.n = false;
                        e5.l = g14;
                        e5.a();
                    }
                }
                if(m0 instanceof G && Build.VERSION.SDK_INT < 33) {
                    a a1 = this.e;
                    if(a1 != null) {
                        a1.invoke();
                    }
                }
            }
        }
        this.n = n0.a;
        if(v != 0 || z) {
            u u0 = this.c;
            ViewParent viewParent0 = u0.getParent();
            if(viewParent0 != null) {
                viewParent0.onDescendantInvalidated(u0, u0);
            }
        }
    }

    @Override  // P0.q0
    public final void f(n n0, a a0) {
        z z0 = this.b;
        if(z0 == null) {
            throw Y.d("currently reuse is only supported when we manage the layer lifecycle");
        }
        if(!this.a.s) {
            M0.a.a("layer should have been released before reuse");
        }
        this.a = z0.a();
        this.g = false;
        this.d = n0;
        this.e = a0;
        this.w = false;
        this.B = false;
        this.D = true;
        F.d(this.h);
        float[] arr_f = this.i;
        if(arr_f != null) {
            F.d(arr_f);
        }
        this.o = U.b;
        this.E = false;
        this.f = 0x7FFFFFFF7FFFFFFFL;
        this.r = null;
        this.n = 0;
    }

    @Override  // P0.q0
    public final void g(x0.a a0, boolean z) {
        float[] arr_f = z ? this.l() : this.m();
        if(!this.D) {
            if(arr_f == null) {
                a0.a = 0.0f;
                a0.b = 0.0f;
                a0.c = 0.0f;
                a0.d = 0.0f;
                return;
            }
            F.c(arr_f, a0);
        }
    }

    @Override  // P0.q0
    public final float[] getUnderlyingMatrix-sQKQjiQ() {
        return this.m();
    }

    // 去混淆评级： 低(20)
    @Override  // P0.q0
    public final boolean h(long v) {
        return this.a.w ? Q0.N.q(this.a.e(), Float.intBitsToFloat(((int)(v >> 0x20))), Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)))) : true;
    }

    @Override  // P0.q0
    public final void i(float[] arr_f) {
        float[] arr_f1 = this.l();
        if(arr_f1 != null) {
            F.e(arr_f, arr_f1);
        }
    }

    @Override  // P0.q0
    public final void invalidate() {
        if(!this.j && !this.g) {
            u u0 = this.c;
            u0.invalidate();
            if(!this.j) {
                this.j = true;
                u0.w(this, true);
            }
        }
    }

    @Override  // P0.q0
    public final void j(long v) {
        e e0 = this.a;
        if(!j.a(e0.t, v)) {
            e0.t = v;
            e0.a.r(((int)(v >> 0x20)), ((int)(v & 0xFFFFFFFFL)), e0.u);
        }
        u u0 = this.c;
        ViewParent viewParent0 = u0.getParent();
        if(viewParent0 != null) {
            viewParent0.onDescendantInvalidated(u0, u0);
        }
    }

    @Override  // P0.q0
    public final void k() {
        if(this.j) {
            if(!U.a(this.o, U.b) && !l.b(this.a.u, this.f)) {
                e e0 = this.a;
                long v = ((long)Float.floatToRawIntBits(U.c(this.o) * ((float)(((int)(this.f & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(U.b(this.o) * ((float)(((int)(this.f >> 0x20)))))) << 0x20;
                if(!x0.b.b(e0.v, v)) {
                    e0.v = v;
                    e0.a.F(v);
                }
            }
            this.a.g(this.k, this.l, this.f, this.G);
            if(this.j) {
                this.j = false;
                this.c.w(this, false);
            }
        }
    }

    public final float[] l() {
        float[] arr_f = this.i;
        if(arr_f == null) {
            arr_f = F.a();
            this.i = arr_f;
        }
        if(!this.B) {
            return Float.isNaN(arr_f[0]) ? null : arr_f;
        }
        this.B = false;
        float[] arr_f1 = this.m();
        if(this.D) {
            return arr_f1;
        }
        if(Q0.N.n(arr_f1, arr_f)) {
            return arr_f;
        }
        arr_f[0] = NaNf;
        return null;
    }

    public final float[] m() {
        float[] arr_f = this.h;
        if(this.w) {
            long v = this.a.v;
            g g0 = this.a.a;
            if((0x7FFFFFFF7FFFFFFFL & v) == 0x7FC000007FC00000L) {
                v = e1.m.r(e1.n.E(this.f));
            }
            float f = Float.intBitsToFloat(((int)(v >> 0x20)));
            float f1 = Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)));
            float f2 = g0.H();
            float f3 = g0.G();
            float f4 = g0.I();
            float f5 = g0.s();
            float f6 = g0.t();
            float f7 = g0.C();
            float f8 = g0.L();
            float f9 = (float)Math.sin(((double)f4) * 0.017453);
            float f10 = (float)Math.cos(((double)f4) * 0.017453);
            float f11 = 1.0f * f10 + f3 * f9;
            float f12 = (float)Math.sin(((double)f5) * 0.017453);
            float f13 = (float)Math.cos(((double)f5) * 0.017453);
            float f14 = f9 * f12;
            float f15 = f9 * f13;
            float f16 = (float)Math.sin(((double)f6) * 0.017453);
            float f17 = (float)Math.cos(((double)f6) * 0.017453);
            float f18 = (f14 * f16 + f13 * f17) * f7;
            float f19 = f16 * f10 * f7;
            float f20 = (f16 * f15 + f17 * -f12) * f7;
            float f21 = (f17 * f14 + -f16 * f13) * f8;
            float f22 = f10 * f17 * f8;
            float f23 = (f17 * f15 + -f16 * -f12) * f8;
            if(arr_f.length >= 16) {
                arr_f[0] = f18;
                arr_f[1] = f19;
                arr_f[2] = f20;
                arr_f[3] = 0.0f;
                arr_f[4] = f21;
                arr_f[5] = f22;
                arr_f[6] = f23;
                arr_f[7] = 0.0f;
                arr_f[8] = f10 * f12 * 1.0f;
                arr_f[9] = -f9 * 1.0f;
                arr_f[10] = f10 * f13 * 1.0f;
                arr_f[11] = 0.0f;
                arr_f[12] = f18 * -f - f1 * f21 + (f11 * f12 + f2 * f13) + f;
                arr_f[13] = f19 * -f - f1 * f22 + (f3 * f10 - 1.0f * f9) + f1;
                arr_f[14] = -f * f20 - f1 * f23 + (f11 * f13 + -f2 * f12);
                arr_f[15] = 1.0f;
            }
            this.w = false;
            this.D = M.p(arr_f);
        }
        return arr_f;
    }
}

