package P0;

import B0.e;
import B2.p;
import J0.i;
import N0.L;
import N0.N;
import N0.o;
import N0.v;
import Q0.u;
import androidx.collection.F;
import androidx.collection.G;
import e1.b;
import e1.n;
import java.util.Map.Entry;
import java.util.Map;
import k8.Y;
import p0.h;
import r1.c;
import r1.j;
import r1.m;
import we.k;
import x0.a;
import y0.B;
import y0.M;
import y0.U;
import y0.q;

public abstract class j0 extends P implements L, v, s0 {
    public c B;
    public m D;
    public float E;
    public N G;
    public F I;
    public long M;
    public float N;
    public a S;
    public x T;
    public e V;
    public q W;
    public p X;
    public final g0 Y;
    public boolean Z;
    public q0 b0;
    public static final y0.N c0;
    public static final x d0;
    public static final float[] e0;
    public static final d f0;
    public static final d g0;
    public final I l;
    public j0 m;
    public j0 n;
    public boolean o;
    public boolean r;
    public k w;

    static {
        y0.N n0 = new y0.N();  // 初始化器: Ljava/lang/Object;-><init>()V
        n0.b = 1.0f;
        n0.c = 1.0f;
        n0.d = 1.0f;
        n0.h = B.a;
        n0.i = B.a;
        n0.m = 8.0f;
        n0.n = U.b;
        n0.o = M.a;
        n0.w = 0;
        n0.B = 0x7FC000007FC00000L;
        n0.D = df.v.c();
        n0.E = m.a;
        j0.c0 = n0;
        j0.d0 = new x();
        j0.e0 = y0.F.a();
        j0.f0 = new d(1);
        j0.g0 = new d(2);
    }

    public j0(I i0) {
        this.l = i0;
        this.B = i0.S;
        this.D = i0.T;
        this.E = 0.8f;
        this.M = 0L;
        this.Y = new g0(this, 1);
    }

    @Override  // N0.v
    public final long A(long v) {
        if(!this.h()) {
            M0.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        long v1 = ((u)P0.L.a(this.l)).H(v);
        return this.a1(N0.g0.g(this), v1);
    }

    @Override  // P0.P
    public final N A0() {
        N n0 = this.G;
        if(n0 == null) {
            throw new IllegalStateException("Asking for measurement result of unmeasured layout modifier");
        }
        return n0;
    }

    @Override  // P0.P
    public final P B0() {
        return this.n;
    }

    @Override  // P0.P
    public final long C0() {
        return this.M;
    }

    @Override  // N0.v
    public final long D(long v) {
        long v1 = this.j0(v);
        u u0 = (u)P0.L.a(this.l);
        u0.D();
        return y0.F.b(v1, u0.p0);
    }

    @Override  // P0.P
    public final void E0() {
        this.r0(this.M, this.N, this.w);
    }

    public final void F0(j0 j00, a a0, boolean z) {
        if(j00 != this) {
            j0 j01 = this.n;
            if(j01 != null) {
                j01.F0(j00, a0, z);
            }
            float f = (float)(((int)(this.M >> 0x20)));
            a0.a -= f;
            a0.c -= f;
            float f1 = (float)(((int)(this.M & 0xFFFFFFFFL)));
            a0.b -= f1;
            a0.d -= f1;
            q0 q00 = this.b0;
            if(q00 != null) {
                q00.g(a0, true);
                if(this.r && z) {
                    a0.a(0.0f, 0.0f, ((float)(((int)(this.c >> 0x20)))), ((float)(((int)(this.c & 0xFFFFFFFFL)))));
                }
            }
        }
    }

    // 去混淆评级： 低(20)
    @Override  // P0.s0
    public final boolean G() {
        return this.b0 != null && !this.o && this.l.H();
    }

    public final long G0(j0 j00, long v) {
        if(j00 == this) {
            return v;
        }
        j0 j01 = this.n;
        return j01 == null || kotlin.jvm.internal.q.b(j00, j01) ? this.N0(v) : this.N0(j01.G0(j00, v));
    }

    public final long H0(long v) {
        float f = Math.max(0.0f, (Float.intBitsToFloat(((int)(v >> 0x20))) - ((float)this.p0())) / 2.0f);
        return ((long)Float.floatToRawIntBits(Math.max(0.0f, (Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) - ((float)this.o0())) / 2.0f))) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(f)) << 0x20;
    }

    public final float I0(long v, long v1) {
        if(Float.compare(this.p0(), Float.intBitsToFloat(((int)(v1 >> 0x20)))) >= 0 && ((float)this.o0()) >= Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL)))) {
            return Infinityf;
        }
        long v2 = this.H0(v1);
        float f = Float.intBitsToFloat(((int)(v2 >> 0x20)));
        float f1 = Float.intBitsToFloat(((int)(v2 & 0xFFFFFFFFL)));
        float f2 = Float.intBitsToFloat(((int)(v >> 0x20)));
        float f3 = Math.max(0.0f, (f2 < 0.0f ? -f2 : f2 - ((float)this.p0())));
        float f4 = Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)));
        long v3 = ((long)Float.floatToRawIntBits(Math.max(0.0f, (f4 < 0.0f ? -f4 : f4 - ((float)this.o0()))))) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(f3)) << 0x20;
        if((f > 0.0f || f1 > 0.0f) && Float.intBitsToFloat(((int)(v3 >> 0x20))) <= f && Float.intBitsToFloat(((int)(v3 & 0xFFFFFFFFL))) <= f1) {
            float f5 = Float.intBitsToFloat(((int)(v3 >> 0x20)));
            float f6 = Float.intBitsToFloat(((int)(v3 & 0xFFFFFFFFL)));
            return f6 * f6 + f5 * f5;
        }
        return Infinityf;
    }

    public final void J0(q q0, e e0) {
        q0 q00 = this.b0;
        if(q00 != null) {
            q00.b(q0, e0);
            return;
        }
        float f = (float)(((int)(this.M >> 0x20)));
        float f1 = (float)(((int)(this.M & 0xFFFFFFFFL)));
        q0.i(f, f1);
        this.K0(q0, e0);
        q0.i(-f, -f1);
    }

    @Override  // N0.v
    public final void K(float[] arr_f) {
        r0 r00 = P0.L.a(this.l);
        j0 j00 = j0.k1(N0.g0.g(this));
        this.m1(j00, arr_f);
        if(r00 instanceof i) {
            ((u)(((i)r00))).s(arr_f);
            return;
        }
        if(!j00.h()) {
            M0.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        long v = j00.j0(0L);
        long v1 = ((u)P0.L.a(j00.l)).t(v);
        if((0x7FFFFFFF7FFFFFFFL & v1) != 0x7FC000007FC00000L) {
            y0.F.f(arr_f, Float.intBitsToFloat(((int)(v1 >> 0x20))), Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL))));
        }
    }

    public final void K0(q q0, e e0) {
        r0.p p0 = this.S0(4);
        if(p0 == null) {
            this.g1(q0, e0);
            return;
        }
        this.l.getClass();
        K k0 = ((u)P0.L.a(this.l)).getSharedDrawScope();
        long v = n.E(this.c);
        k0.getClass();
        g0.e e1 = null;
        while(p0 != null) {
            if(p0 instanceof P0.p) {
                k0.d(q0, v, this, ((P0.p)p0), e0);
            }
            else if((p0.getKindSet$ui_release() & 4) != 0 && p0 instanceof P0.n) {
                r0.p p1 = ((P0.n)p0).b;
                int v1 = 0;
                while(p1 != null) {
                    if((p1.getKindSet$ui_release() & 4) != 0) {
                        ++v1;
                        if(v1 == 1) {
                            p0 = p1;
                        }
                        else {
                            if(e1 == null) {
                                e1 = new g0.e(new r0.p[16]);
                            }
                            if(p0 != null) {
                                e1.b(p0);
                                p0 = null;
                            }
                            e1.b(p1);
                        }
                    }
                    p1 = p1.getChild$ui_release();
                }
                if(v1 != 1) {
                    goto label_31;
                }
                continue;
            }
        label_31:
            p0 = f.f(e1);
        }
    }

    public abstract void L0();

    public final j0 M0(j0 j00) {
        I i0 = j00.l;
        I i1 = this.l;
        if(i0 == i1) {
            r0.p p0 = j00.R0();
            r0.p p1 = this.R0();
            if(!p1.getNode().isAttached()) {
                M0.a.b("visitLocalAncestors called on an unattached node");
            }
            for(r0.p p2 = p1.getNode().getParent$ui_release(); p2 != null; p2 = p2.getParent$ui_release()) {
                if((p2.getKindSet$ui_release() & 2) != 0 && p2 == p0) {
                    return j00;
                }
            }
            return this;
        }
        while(i0.r > i1.r) {
            i0 = i0.u();
            kotlin.jvm.internal.q.d(i0);
        }
        I i2 = i1;
        while(i2.r > i0.r) {
            i2 = i2.u();
            kotlin.jvm.internal.q.d(i2);
        }
        while(i0 != i2) {
            i0 = i0.u();
            i2 = i2.u();
            if(i0 == null || i2 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
            if(false) {
                break;
            }
        }
        if(i2 == i1) {
            return this;
        }
        return i0 == j00.l ? j00 : ((P0.v)i0.b0.c);
    }

    public final long N0(long v) {
        long v1 = ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) - ((float)(((int)(this.M & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v >> 0x20))) - ((float)(((int)(this.M >> 0x20)))))) << 0x20;
        return this.b0 == null ? v1 : this.b0.c(v1, true);
    }

    public final we.n O0() {
        we.n n0 = this.X;
        if(n0 == null) {
            p p0 = new p(11, this, new g0(this, 0));
            this.X = p0;
            return p0;
        }
        return n0;
    }

    public abstract Q P0();

    public final long Q0() {
        return this.B.i0(this.l.V.d());
    }

    public abstract r0.p R0();

    public final r0.p S0(int v) {
        r0.p p1;
        r0.p p0 = this.R0();
        if(k0.h(v)) {
            p1 = this.T0(true);
        label_7:
            while(p1 != null && (p1.getAggregateChildKindSet$ui_release() & v) != 0) {
                if((p1.getKindSet$ui_release() & v) != 0) {
                    return p1;
                }
                if(p1 == p0) {
                    break;
                }
                p1 = p1.getChild$ui_release();
            }
        }
        else {
            p0 = p0.getParent$ui_release();
            if(p0 != null) {
                p1 = this.T0(false);
                goto label_7;
            }
        }
        return null;
    }

    public final r0.p T0(boolean z) {
        d0 d00 = this.l.b0;
        if(((j0)d00.d) == this) {
            return (r0.p)d00.f;
        }
        if(z) {
            j0 j00 = this.n;
            if(j00 != null) {
                r0.p p0 = j00.R0();
                return p0 == null ? null : p0.getChild$ui_release();
            }
            return null;
        }
        return this.n == null ? null : this.n.R0();
    }

    public final void U0(r0.p p0, d d0, long v, t t0, int v1, boolean z) {
        if(p0 == null) {
            this.X0(d0, v, t0, v1, z);
            return;
        }
        int v2 = t0.c;
        t0.d(v2 + 1, t0.a.b);
        ++t0.c;
        t0.a.a(p0);
        t0.b.a(f.a(-1.0f, z, false));
        this.U0(f.e(p0, d0.c()), d0, v, t0, v1, z);
        t0.c = v2;
    }

    public final void V0(r0.p p0, d d0, long v, t t0, int v1, boolean z, float f) {
        if(p0 == null) {
            this.X0(d0, v, t0, v1, z);
            return;
        }
        int v2 = t0.c;
        t0.d(v2 + 1, t0.a.b);
        ++t0.c;
        t0.a.a(p0);
        t0.b.a(f.a(f, z, false));
        this.f1(f.e(p0, d0.c()), d0, v, t0, v1, z, f, true);
        t0.c = v2;
    }

    @Override  // r1.c
    public final float W() {
        return this.l.S.W();
    }

    public final void W0(d d0, long v, t t0, int v1, boolean z) {
        r0.p p0 = this.S0(d0.c());
        if(!this.p1(v)) {
            if(v1 == 1) {
                float f = this.I0(v, this.Q0());
                if((Float.floatToRawIntBits(f) & 0x7FFFFFFF) < 0x7F800000 && (t0.c == e.k.s(t0) || f.h(t0.b(), f.a(f, false, false)) > 0)) {
                    this.V0(p0, d0, v, t0, 1, false, f);
                }
            }
            return;
        }
        if(p0 == null) {
            this.X0(d0, v, t0, v1, z);
            return;
        }
        float f1 = Float.intBitsToFloat(((int)(v >> 0x20)));
        float f2 = Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)));
        if(f1 >= 0.0f && f2 >= 0.0f && f1 < ((float)this.p0()) && f2 < ((float)this.o0())) {
            this.U0(p0, d0, v, t0, v1, z);
            return;
        }
        float f3 = v1 == 1 ? this.I0(v, this.Q0()) : Infinityf;
        this.f1(p0, d0, v, t0, v1, z, f3, (Float.floatToRawIntBits(f3) & 0x7FFFFFFF) < 0x7F800000 && (t0.c == e.k.s(t0) || f.h(t0.b(), f.a(f3, z, false)) > 0));
    }

    @Override  // N0.v
    public final v X() {
        if(!this.h()) {
            M0.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        this.c1();
        return ((j0)this.l.b0.d).n;
    }

    public void X0(d d0, long v, t t0, int v1, boolean z) {
        j0 j00 = this.m;
        if(j00 != null) {
            j00.W0(d0, j00.N0(v), t0, v1, z);
        }
    }

    public final void Y0() {
        q0 q00 = this.b0;
        if(q00 != null) {
            q00.invalidate();
            return;
        }
        j0 j00 = this.n;
        if(j00 != null) {
            j00.Y0();
        }
    }

    public final boolean Z0() {
        if(this.b0 != null && this.E <= 0.0f) {
            return true;
        }
        return this.n == null ? false : this.n.Z0();
    }

    public final long a1(v v0, long v1) {
        if(v0 instanceof N0.K) {
            ((N0.K)v0).a.l.c1();
            return ((N0.K)v0).b(this, v1 ^ 0x8000000080000000L) ^ 0x8000000080000000L;
        }
        j0 j00 = j0.k1(v0);
        j00.c1();
        j0 j01 = this.M0(j00);
        while(j00 != j01) {
            q0 q00 = j00.b0;
            if(q00 != null) {
                v1 = q00.c(v1, false);
            }
            v1 = b.G(v1, j00.M);
            j00 = j00.n;
            kotlin.jvm.internal.q.d(j00);
        }
        return this.G0(j01, v1);
    }

    @Override  // r1.c
    public final float b() {
        return this.l.S.b();
    }

    @Override  // N0.v
    public final long b0(v v0, long v1) {
        return this.a1(v0, v1);
    }

    public final void b1() {
        if(this.b0 == null && this.w != null) {
            q0 q00 = r0.a(P0.L.a(this.l), this.O0(), this.Y, false, 8);
            q00.d(this.c);
            q00.j(this.M);
            q00.invalidate();
            this.b0 = q00;
        }
    }

    public final void c1() {
        P0.M m0 = this.l.c0;
        E e0 = m0.a.c0.d;
        if(e0 == E.c || e0 == E.d) {
            if(m0.p.V) {
                m0.e(true);
            }
            else {
                m0.d(true);
            }
        }
        if(e0 == E.d) {
            if(m0.q != null && m0.q.G) {
                m0.g(true);
                return;
            }
            m0.f(true);
        }
    }

    public final void d1() {
        r0.p p0 = this.T0(true);
        if(p0 != null && (p0.getNode().getAggregateChildKindSet$ui_release() & 0x80) != 0) {
            h h0 = p0.q.d();
            k k0 = h0 == null ? null : h0.e();
            h h1 = p0.q.e(h0);
            try {
                r0.p p1 = this.R0();
                r0.p p2 = this.T0(true);
                while(p2 != null && (p2.getAggregateChildKindSet$ui_release() & 0x80) != 0) {
                    if((p2.getKindSet$ui_release() & 0x80) != 0) {
                        r0.p p3 = p2;
                        g0.e e0 = null;
                        while(p3 != null) {
                            if(p3 instanceof y) {
                                ((y)p3).h(this.c);
                            }
                            else if((p3.getKindSet$ui_release() & 0x80) != 0 && p3 instanceof P0.n) {
                                r0.p p4 = ((P0.n)p3).b;
                                int v1 = 0;
                                while(p4 != null) {
                                    if((p4.getKindSet$ui_release() & 0x80) != 0) {
                                        ++v1;
                                        if(v1 == 1) {
                                            p3 = p4;
                                        }
                                        else {
                                            if(e0 == null) {
                                                e0 = new g0.e(new r0.p[16]);
                                            }
                                            if(p3 != null) {
                                                e0.b(p3);
                                                p3 = null;
                                            }
                                            e0.b(p4);
                                        }
                                    }
                                    p4 = p4.getChild$ui_release();
                                }
                                if(v1 != 1) {
                                    goto label_34;
                                }
                                continue;
                            }
                        label_34:
                            p3 = f.f(e0);
                        }
                    }
                    if(p2 == p1) {
                        break;
                    }
                    p2 = p2.getChild$ui_release();
                }
            }
            finally {
                p0.q.g(h0, h1, k0);
            }
        }
    }

    public final void e1() {
        r0.p p0 = this.R0();
        r0.p p1 = this.T0(true);
        while(p1 != null && (p1.getAggregateChildKindSet$ui_release() & 0x80) != 0) {
            if((p1.getKindSet$ui_release() & 0x80) != 0) {
                r0.p p2 = p1;
                g0.e e0 = null;
                while(p2 != null) {
                    if(p2 instanceof y) {
                        ((y)p2).g(this);
                    }
                    else if((p2.getKindSet$ui_release() & 0x80) != 0 && p2 instanceof P0.n) {
                        r0.p p3 = ((P0.n)p2).b;
                        int v = 0;
                        while(p3 != null) {
                            if((p3.getKindSet$ui_release() & 0x80) != 0) {
                                ++v;
                                if(v == 1) {
                                    p2 = p3;
                                }
                                else {
                                    if(e0 == null) {
                                        e0 = new g0.e(new r0.p[16]);
                                    }
                                    if(p2 != null) {
                                        e0.b(p2);
                                        p2 = null;
                                    }
                                    e0.b(p3);
                                }
                            }
                            p3 = p3.getChild$ui_release();
                        }
                        if(v != 1) {
                            goto label_28;
                        }
                        continue;
                    }
                label_28:
                    p2 = f.f(e0);
                }
            }
            if(p1 == p0) {
                break;
            }
            p1 = p1.getChild$ui_release();
        }
    }

    @Override  // N0.v
    public final x0.c f(v v0, boolean z) {
        if(!this.h()) {
            M0.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        if(!v0.h()) {
            M0.a.b(("LayoutCoordinates " + v0 + " is not attached!"));
        }
        j0 j00 = j0.k1(v0);
        j00.c1();
        j0 j01 = this.M0(j00);
        a a0 = this.S;
        if(a0 == null) {
            a0 = new a();
            this.S = a0;
        }
        a0.a = 0.0f;
        a0.b = 0.0f;
        a0.c = (float)(((int)(v0.l() >> 0x20)));
        a0.d = (float)(((int)(v0.l() & 0xFFFFFFFFL)));
        while(j00 != j01) {
            j00.i1(a0, z, false);
            if(a0.b()) {
                return x0.c.e;
            }
            j00 = j00.n;
            kotlin.jvm.internal.q.d(j00);
        }
        this.F0(j01, a0, z);
        return new x0.c(a0.a, a0.b, a0.c, a0.d);
    }

    public final void f1(r0.p p0, d d0, long v, t t0, int v1, boolean z, float f, boolean z1) {
        if(p0 == null) {
            this.X0(d0, v, t0, v1, z);
            return;
        }
        if(v1 == 3 || v1 == 4) {
            r0.p p1 = p0;
            g0.e e0 = null;
            while(p1 != null) {
                if(p1 instanceof w0) {
                    long v2 = ((w0)p1).C();
                    int v3 = Long.compare(0x8000000000000000L & v2, 0L);
                    if(Float.intBitsToFloat(((int)(v >> 0x20))) < ((float)(-(v3 == 0 || this.l.T == m.a ? ((int)v2) & 0x7FFF : ((int)(v2 >> 30)) & 0x7FFF))) || (Float.intBitsToFloat(((int)(v >> 0x20))) >= ((float)(this.p0() + (v3 == 0 || this.l.T == m.a ? ((int)(v2 >> 30)) & 0x7FFF : ((int)v2) & 0x7FFF))) || Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) < ((float)(-(((int)(v2 >> 15)) & 0x7FFF))) || Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) >= ((float)((((int)(v2 >> 45)) & 0x7FFF) + this.o0())))) {
                        break;
                    }
                    h0 h00 = new h0(this, p0, d0, v, t0, v1, z, f, z1);
                    androidx.collection.B b0 = t0.b;
                    G g0 = t0.a;
                    if(t0.c == e.k.s(t0)) {
                        int v4 = t0.c;
                        t0.d(v4 + 1, g0.b);
                        ++t0.c;
                        g0.a(p0);
                        b0.a(f.a(0.0f, z, true));
                        h00.invoke();
                        t0.c = v4;
                        return;
                    }
                    long v5 = t0.b();
                    int v6 = t0.c;
                    if(f.n(v5)) {
                        int v7 = e.k.s(t0);
                        t0.c = v7;
                        t0.d(v7 + 1, g0.b);
                        ++t0.c;
                        g0.a(p0);
                        b0.a(f.a(0.0f, z, true));
                        h00.invoke();
                        t0.c = v7;
                        if(f.l(t0.b()) < 0.0f) {
                            t0.d(v6 + 1, t0.c + 1);
                        }
                        t0.c = v6;
                        return;
                    }
                    if(f.l(v5) > 0.0f) {
                        int v8 = t0.c;
                        t0.d(v8 + 1, g0.b);
                        ++t0.c;
                        g0.a(p0);
                        b0.a(f.a(0.0f, z, true));
                        h00.invoke();
                        t0.c = v8;
                    }
                    return;
                }
                if((p1.getKindSet$ui_release() & 16) != 0 && p1 instanceof P0.n) {
                    r0.p p2 = ((P0.n)p1).b;
                    int v9 = 0;
                    while(p2 != null) {
                        if((p2.getKindSet$ui_release() & 16) != 0) {
                            ++v9;
                            if(v9 == 1) {
                                p1 = p2;
                            }
                            else {
                                if(e0 == null) {
                                    e0 = new g0.e(new r0.p[16]);
                                }
                                if(p1 != null) {
                                    e0.b(p1);
                                    p1 = null;
                                }
                                e0.b(p2);
                            }
                        }
                        p2 = p2.getChild$ui_release();
                    }
                    if(v9 != 1) {
                        p1 = f.f(e0);
                    }
                }
                else {
                    p1 = f.f(e0);
                }
            }
        }
        if(z1) {
            this.V0(p0, d0, v, t0, v1, z, f);
            return;
        }
        if(d0.a == 1) {
            g0.e e1 = null;
            r0.p p3 = p0;
            while(p3 != null) {
                if(p3 instanceof w0) {
                    ((w0)p3).q();
                }
                else if((p3.getKindSet$ui_release() & 16) != 0 && p3 instanceof P0.n) {
                    r0.p p4 = ((P0.n)p3).b;
                    int v10 = 0;
                    while(p4 != null) {
                        if((p4.getKindSet$ui_release() & 16) != 0) {
                            ++v10;
                            if(v10 == 1) {
                                p3 = p4;
                            }
                            else {
                                if(e1 == null) {
                                    e1 = new g0.e(new r0.p[16]);
                                }
                                if(p3 != null) {
                                    e1.b(p3);
                                    p3 = null;
                                }
                                e1.b(p4);
                            }
                        }
                        p4 = p4.getChild$ui_release();
                    }
                    if(v10 != 1) {
                        goto label_95;
                    }
                    continue;
                }
            label_95:
                p3 = f.f(e1);
            }
        }
        this.f1(f.e(p0, d0.c()), d0, v, t0, v1, z, f, false);
    }

    public abstract void g1(q arg1, e arg2);

    @Override  // N0.q
    public final m getLayoutDirection() {
        return this.l.T;
    }

    @Override  // N0.v
    public final boolean h() {
        return this.R0().isAttached();
    }

    public final void h1(long v, float f, k k0) {
        this.n1(k0, false);
        if(!j.a(this.M, v)) {
            this.M = v;
            I i0 = this.l;
            i0.c0.p.x0();
            q0 q00 = this.b0;
            if(q00 == null) {
                j0 j00 = this.n;
                if(j00 != null) {
                    j00.Y0();
                }
            }
            else {
                q00.j(v);
            }
            P.D0(this);
            r0 r00 = i0.n;
            if(r00 != null) {
                ((u)r00).z(i0);
            }
        }
        this.N = f;
        if(!this.h) {
            this.v0(new v0(this.A0(), this));
        }
    }

    public final void i1(a a0, boolean z, boolean z1) {
        q0 q00 = this.b0;
        if(q00 != null) {
            if(this.r) {
                if(z1) {
                    long v = this.Q0();
                    float f = Float.intBitsToFloat(((int)(v >> 0x20)));
                    float f1 = Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)));
                    a0.a(-(f / 2.0f), -(f1 / 2.0f), ((float)(((int)(this.c >> 0x20)))) + f / 2.0f, ((float)(((int)(this.c & 0xFFFFFFFFL)))) + f1 / 2.0f);
                }
                else if(z) {
                    a0.a(0.0f, 0.0f, ((float)(((int)(this.c >> 0x20)))), ((float)(((int)(this.c & 0xFFFFFFFFL)))));
                }
                if(a0.b()) {
                    return;
                }
            }
            q00.g(a0, false);
        }
        float f2 = (float)(((int)(this.M >> 0x20)));
        a0.a += f2;
        a0.c += f2;
        float f3 = (float)(((int)(this.M & 0xFFFFFFFFL)));
        a0.b += f3;
        a0.d += f3;
    }

    @Override  // N0.v
    public final long j0(long v) {
        if(!this.h()) {
            M0.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        this.c1();
        for(j0 j00 = this; j00 != null; j00 = j00.n) {
            q0 q00 = j00.b0;
            if(q00 != null) {
                v = q00.c(v, false);
            }
            v = b.G(v, j00.M);
        }
        return v;
    }

    public final void j1(N n0) {
        N n1 = this.G;
        if(n0 != n1) {
            this.G = n0;
            I i0 = this.l;
            if(n1 == null || n0.getWidth() != n1.getWidth() || n0.getHeight() != n1.getHeight()) {
                int v = n0.getWidth();
                int v1 = n0.getHeight();
                q0 q00 = this.b0;
                if(q00 != null) {
                    q00.d(((long)v) << 0x20 | ((long)v1) & 0xFFFFFFFFL);
                }
                else if(i0.I()) {
                    j0 j00 = this.n;
                    if(j00 != null) {
                        j00.Y0();
                    }
                }
                this.s0(((long)v1) & 0xFFFFFFFFL | ((long)v) << 0x20);
                if(this.w != null) {
                    this.o1(false);
                }
                r0.p p0 = this.R0().getParent$ui_release();
                if(p0 == null) {
                label_52:
                    r0 r00 = i0.n;
                    if(r00 != null) {
                        ((u)r00).z(i0);
                    }
                }
                else {
                    r0.p p1 = this.T0(false);
                    while(true) {
                        if(p1 == null || (p1.getAggregateChildKindSet$ui_release() & 4) == 0) {
                            goto label_52;
                        }
                        if((p1.getKindSet$ui_release() & 4) != 0) {
                            r0.p p2 = p1;
                            g0.e e0 = null;
                            while(p2 != null) {
                                if(p2 instanceof P0.p) {
                                    ((P0.p)p2).onMeasureResultChanged();
                                }
                                else if((p2.getKindSet$ui_release() & 4) != 0 && p2 instanceof P0.n) {
                                    r0.p p3 = ((P0.n)p2).b;
                                    int v2 = 0;
                                    while(p3 != null) {
                                        if((p3.getKindSet$ui_release() & 4) != 0) {
                                            ++v2;
                                            if(v2 == 1) {
                                                p2 = p3;
                                            }
                                            else {
                                                if(e0 == null) {
                                                    e0 = new g0.e(new r0.p[16]);
                                                }
                                                if(p2 != null) {
                                                    e0.b(p2);
                                                    p2 = null;
                                                }
                                                e0.b(p3);
                                            }
                                        }
                                        p3 = p3.getChild$ui_release();
                                    }
                                    if(v2 != 1) {
                                        goto label_47;
                                    }
                                    continue;
                                }
                            label_47:
                                p2 = f.f(e0);
                            }
                        }
                        if(p1 != p0) {
                            p1 = p1.getChild$ui_release();
                            continue;
                        }
                        goto label_52;
                    }
                }
            }
            if(this.I != null && this.I.e != 0 || !n0.a().isEmpty()) {
                F f0 = this.I;
                Map map0 = n0.a();
                if(f0 == null || f0.e != map0.size()) {
                label_83:
                    i0.c0.p.N.f();
                    F f1 = this.I;
                    if(f1 == null) {
                        f1 = new F();
                        this.I = f1;
                    }
                    f1.a();
                    for(Object object1: n0.a().entrySet()) {
                        Object object2 = ((Map.Entry)object1).getKey();
                        f1.g(((Number)((Map.Entry)object1).getValue()).intValue(), object2);
                    }
                }
                else {
                    Object[] arr_object = f0.b;
                    int[] arr_v = f0.c;
                    long[] arr_v1 = f0.a;
                    int v3 = arr_v1.length - 2;
                    if(v3 >= 0) {
                        int v4 = 0;
                        while(true) {
                            long v5 = arr_v1[v4];
                            if((~v5 << 7 & v5 & 0x8080808080808080L) == 0x8080808080808080L) {
                                goto label_80;
                            }
                            int v6 = 8 - (~(v4 - v3) >>> 0x1F);
                            int v7 = 0;
                            while(v7 < v6) {
                                if((0xFFL & v5) < 0x80L) {
                                    int v8 = (v4 << 3) + v7;
                                    Object object0 = arr_object[v8];
                                    int v9 = arr_v[v8];
                                    Integer integer0 = (Integer)map0.get(((o)object0));
                                    if(integer0 != null && ((int)integer0) == v9) {
                                        goto label_76;
                                    }
                                    goto label_83;
                                }
                            label_76:
                                v5 >>= 8;
                                ++v7;
                            }
                            if(v6 == 8) {
                            label_80:
                                if(v4 != v3) {
                                    ++v4;
                                    continue;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    public static j0 k1(v v0) {
        N0.K k0 = v0 instanceof N0.K ? ((N0.K)v0) : null;
        if(k0 != null) {
            j0 j00 = k0.a.l;
            if(j00 != null) {
                return j00;
            }
        }
        kotlin.jvm.internal.q.e(v0, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        return (j0)v0;
    }

    @Override  // N0.v
    public final long l() {
        return this.c;
    }

    public final void l1(j0 j00, float[] arr_f) {
        if(!kotlin.jvm.internal.q.b(j00, this)) {
            j0 j01 = this.n;
            kotlin.jvm.internal.q.d(j01);
            j01.l1(j00, arr_f);
            if(!j.a(this.M, 0L)) {
                y0.F.d(j0.e0);
                y0.F.f(j0.e0, -((float)(((int)(this.M >> 0x20)))), -((float)(((int)(this.M & 0xFFFFFFFFL)))));
                y0.F.e(arr_f, j0.e0);
            }
            q0 q00 = this.b0;
            if(q00 != null) {
                q00.i(arr_f);
            }
        }
    }

    @Override  // N0.v
    public final void m0(v v0, float[] arr_f) {
        j0 j00 = j0.k1(v0);
        j00.c1();
        j0 j01 = this.M0(j00);
        y0.F.d(arr_f);
        j00.m1(j01, arr_f);
        this.l1(j01, arr_f);
    }

    public final void m1(j0 j00, float[] arr_f) {
        while(!this.equals(j00)) {
            q0 q00 = this.b0;
            if(q00 != null) {
                q00.a(arr_f);
            }
            long v = this.M;
            if(!j.a(v, 0L)) {
                y0.F.d(j0.e0);
                y0.F.f(j0.e0, ((float)(((int)(v >> 0x20)))), ((float)(((int)(v & 0xFFFFFFFFL)))));
                y0.F.e(arr_f, j0.e0);
            }
            this = this.n;
            kotlin.jvm.internal.q.d(this);
        }
    }

    public final void n1(k k0, boolean z) {
        I i0 = this.l;
        boolean z1 = z || this.w != k0 || !kotlin.jvm.internal.q.b(this.B, i0.S) || this.D != i0.T;
        this.B = i0.S;
        this.D = i0.T;
        g0 g00 = this.Y;
        if(i0.H() && k0 != null) {
            this.w = k0;
            if(this.b0 == null) {
                q0 q00 = r0.a(P0.L.a(i0), this.O0(), g00, i0.g, 4);
                q00.d(this.c);
                q00.j(this.M);
                this.b0 = q00;
                this.o1(true);
                i0.f0 = true;
                g00.invoke();
                return;
            }
            if(z1 && this.o1(true)) {
                ((u)P0.L.a(i0)).getRectManager().e(i0);
            }
            return;
        }
        this.w = null;
        q0 q01 = this.b0;
        if(q01 != null) {
            q01.destroy();
            i0.f0 = true;
            g00.invoke();
            if(this.h() && i0.I()) {
                r0 r00 = i0.n;
                if(r00 != null) {
                    ((u)r00).z(i0);
                }
            }
        }
        this.b0 = null;
        this.Z = false;
    }

    @Override  // N0.v
    public final long o(long v) {
        if(!this.h()) {
            M0.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        v v1 = N0.g0.g(this);
        u u0 = (u)P0.L.a(this.l);
        u0.D();
        return this.a1(v1, x0.b.f(y0.F.b(v, u0.q0), v1.j0(0L)));
    }

    public final boolean o1(boolean z) {
        q0 q00 = this.b0;
        int v = 0;
        if(q00 != null) {
            k k0 = this.w;
            if(k0 == null) {
                throw Y.d("updateLayerParameters requires a non-null layerBlock");
            }
            y0.N n0 = j0.c0;
            n0.r(1.0f);
            n0.s(1.0f);
            n0.a(1.0f);
            n0.G(0.0f);
            n0.I(0.0f);
            n0.y(0.0f);
            n0.d(B.a);
            n0.C(B.a);
            n0.l(0.0f);
            n0.o(0.0f);
            n0.q(0.0f);
            if(n0.m != 8.0f) {
                n0.a |= 0x800;
                n0.m = 8.0f;
            }
            n0.D(U.b);
            n0.A(M.a);
            n0.f(false);
            n0.h(null);
            n0.g(0);
            n0.I = null;
            n0.a = 0;
            I i0 = this.l;
            n0.D = i0.S;
            n0.E = i0.T;
            n0.B = n.E(this.c);
            t0 t00 = ((u)P0.L.a(i0)).getSnapshotObserver();
            B2.o o0 = new B2.o(k0, 17);
            t00.a(this, P0.e.j, o0);
            x x0 = this.T;
            if(x0 == null) {
                x0 = new x();
                this.T = x0;
            }
            j0.d0.getClass();
            j0.d0.a = x0.a;
            j0.d0.b = x0.b;
            j0.d0.c = x0.c;
            j0.d0.d = x0.d;
            j0.d0.e = x0.e;
            j0.d0.f = x0.f;
            j0.d0.g = x0.g;
            j0.d0.h = x0.h;
            j0.d0.i = x0.i;
            x0.a = n0.b;
            x0.b = n0.c;
            x0.c = n0.e;
            x0.d = n0.f;
            x0.e = n0.j;
            x0.f = n0.k;
            x0.g = n0.l;
            x0.h = n0.m;
            x0.i = n0.n;
            q00.e(n0);
            boolean z1 = this.r;
            this.r = n0.r;
            this.E = n0.d;
            if(j0.d0.a == x0.a && j0.d0.b == x0.b && j0.d0.c == x0.c && j0.d0.d == x0.d && j0.d0.e == x0.e && j0.d0.f == x0.f && j0.d0.g == x0.g && j0.d0.h == x0.h && U.a(j0.d0.i, x0.i)) {
                v = 1;
            }
            if(z && (v == 0 || z1 != this.r)) {
                r0 r00 = i0.n;
                if(r00 != null) {
                    ((u)r00).z(i0);
                }
            }
            return v ^ 1;
        }
        if(this.w == null) {
            return false;
        }
        M0.a.b("null layer with a non-null layerBlock");
        return false;
    }

    // 去混淆评级： 低(40)
    public final boolean p1(long v) {
        return this.b0 == null || !this.r || this.b0.h(v);
    }

    @Override  // N0.a0, N0.p
    public final Object q() {
        I i0 = this.l;
        if(i0.b0.e(0x40)) {
            this.R0();
            r0.p p0 = (A0)i0.b0.e;
            Object object0 = null;
            while(p0 != null) {
                if((p0.getKindSet$ui_release() & 0x40) != 0) {
                    r0.p p1 = p0;
                    g0.e e0 = null;
                    while(p1 != null) {
                        if(p1 instanceof u0) {
                            object0 = ((u0)p1).b0(i0.S, object0);
                        }
                        else if((p1.getKindSet$ui_release() & 0x40) != 0 && p1 instanceof P0.n) {
                            r0.p p2 = ((P0.n)p1).b;
                            int v = 0;
                            while(p2 != null) {
                                if((p2.getKindSet$ui_release() & 0x40) != 0) {
                                    ++v;
                                    if(v == 1) {
                                        p1 = p2;
                                    }
                                    else {
                                        if(e0 == null) {
                                            e0 = new g0.e(new r0.p[16]);
                                        }
                                        if(p1 != null) {
                                            e0.b(p1);
                                            p1 = null;
                                        }
                                        e0.b(p2);
                                    }
                                }
                                p2 = p2.getChild$ui_release();
                            }
                            if(v != 1) {
                                goto label_31;
                            }
                            continue;
                        }
                    label_31:
                        p1 = f.f(e0);
                    }
                }
                p0 = p0.getParent$ui_release();
            }
            return object0;
        }
        return null;
    }

    @Override  // P0.P
    public final P w0() {
        return this.m;
    }

    @Override  // P0.P
    public final v x0() {
        return this;
    }

    @Override  // P0.P
    public final boolean y0() {
        return this.G != null;
    }

    @Override  // P0.P
    public final I z0() {
        return this.l;
    }
}

