package P0;

import N0.L;
import N0.a0;
import N0.o;
import Q0.u;
import g0.e;
import java.util.List;
import kotlin.jvm.internal.q;
import r0.p;
import r1.b;
import r1.j;
import r1.l;
import we.k;

public final class Z extends a0 implements L, a, b0 {
    public Object B;
    public boolean D;
    public boolean E;
    public boolean G;
    public boolean I;
    public boolean M;
    public final J N;
    public final e S;
    public boolean T;
    public boolean V;
    public long W;
    public final Y X;
    public final Y Y;
    public float Z;
    public boolean b0;
    public k c0;
    public long d0;
    public float e0;
    public final M f;
    public final Y f0;
    public boolean g;
    public boolean g0;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public G l;
    public boolean m;
    public long n;
    public k o;
    public float r;
    public boolean w;

    public Z(M m0) {
        this.f = m0;
        this.h = 0x7FFFFFFF;
        this.i = 0x7FFFFFFF;
        this.l = G.c;
        this.n = 0L;
        this.w = true;
        this.N = new J(this, 0);
        this.S = new e(new Z[16]);
        this.T = true;
        this.W = b.b(0, 0, 15);
        this.X = new Y(this, 1);
        this.Y = new Y(this, 0);
        this.d0 = 0L;
        this.f0 = new Y(this, 2);
    }

    public final void A0(long v, float f, k k0) {
        M m0 = this.f;
        I i0 = m0.a;
        if(m0.a.l0) {
            M0.a.a("place is called on a deactivated node");
        }
        m0.d = E.c;
        int v1 = !this.k;
        this.n = v;
        this.r = f;
        this.o = k0;
        this.k = true;
        this.b0 = false;
        u u0 = (u)P0.L.a(i0);
        u0.getRectManager().f(i0, v, ((boolean)v1));
        if(this.I || !this.D) {
            this.N.g = false;
            m0.d(false);
            this.c0 = k0;
            this.d0 = v;
            this.e0 = f;
            t0 t00 = u0.getSnapshotObserver();
            t00.a(i0, t00.f, this.f0);
        }
        else {
            j0 j00 = m0.a();
            j00.h1(j.c(v, j00.e), f, k0);
            this.z0();
        }
        m0.d = E.e;
    }

    public final boolean B0(long v) {
        M m0 = this.f;
        I i0 = m0.a;
        if(m0.a.l0) {
            M0.a.a("measure is called on a deactivated node");
        }
        r0 r00 = P0.L.a(i0);
        I i1 = i0.u();
        boolean z = true;
        i0.Z = i0.Z || i1 != null && i1.Z;
        if(!i0.r() && r1.a.b(this.d, v)) {
            ((u)r00).l(i0, false);
            i0.Y();
            return false;
        }
        this.N.f = false;
        e e0 = i0.y();
        Object[] arr_object = e0.a;
        int v1 = e0.c;
        for(int v2 = 0; v2 < v1; ++v2) {
            ((I)arr_object[v2]).c0.p.N.c = false;
        }
        this.j = true;
        long v3 = m0.a().c;
        this.t0(v);
        E e1 = E.e;
        if(m0.d != e1) {
            M0.a.b("layout state is not idle before measure starts");
        }
        this.W = v;
        m0.d = E.a;
        this.G = false;
        t0 t00 = ((u)P0.L.a(i0)).getSnapshotObserver();
        t00.a(i0, t00.c, this.X);
        if(m0.d == E.a) {
            this.I = true;
            this.M = true;
            m0.d = e1;
        }
        if(l.b(m0.a().c, v3) && m0.a().a == this.a && m0.a().b == this.b) {
            z = false;
        }
        int v4 = m0.a().a;
        this.s0(((long)m0.a().b) & 0xFFFFFFFFL | ((long)v4) << 0x20);
        return z;
    }

    @Override  // N0.p
    public final int C(int v) {
        M m0 = this.f;
        if(f.q(m0.a)) {
            V v1 = m0.q;
            q.d(v1);
            return v1.C(v);
        }
        this.y0();
        return m0.a().C(v);
    }

    @Override  // P0.a
    public final v I() {
        return (v)this.f.a.b0.c;
    }

    @Override  // N0.p
    public final int L(int v) {
        M m0 = this.f;
        if(f.q(m0.a)) {
            V v1 = m0.q;
            q.d(v1);
            return v1.L(v);
        }
        this.y0();
        return m0.a().L(v);
    }

    @Override  // N0.p
    public final int N(int v) {
        M m0 = this.f;
        if(f.q(m0.a)) {
            V v1 = m0.q;
            q.d(v1);
            return v1.N(v);
        }
        this.y0();
        return m0.a().N(v);
    }

    @Override  // N0.L
    public final a0 O(long v) {
        G g1;
        M m0 = this.f;
        I i0 = m0.a;
        G g0 = G.c;
        if(i0.X == g0) {
            i0.f();
        }
        if(f.q(m0.a)) {
            V v1 = m0.q;
            q.d(v1);
            v1.j = g0;
            v1.O(v);
        }
        I i1 = m0.a;
        I i2 = i1.u();
        if(i2 == null) {
            this.l = g0;
        }
        else {
            M m1 = i2.c0;
            if(this.l != g0 && !i1.Z) {
                M0.a.b("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
            }
            switch(m1.d.ordinal()) {
                case 0: {
                    g1 = G.a;
                    break;
                }
                case 2: {
                    g1 = G.b;
                    break;
                }
                default: {
                    throw new IllegalStateException("Measurable could be only measured from the parent\'s measure or layout block. Parents state is " + m1.d);
                }
            }
            this.l = g1;
        }
        this.B0(v);
        return this;
    }

    @Override  // P0.a
    public final J a() {
        return this.N;
    }

    @Override  // N0.p
    public final int d(int v) {
        M m0 = this.f;
        if(f.q(m0.a)) {
            V v1 = m0.q;
            q.d(v1);
            return v1.d(v);
        }
        this.y0();
        return m0.a().d(v);
    }

    @Override  // P0.a
    public final a g() {
        I i0 = this.f.a.u();
        if(i0 != null) {
            M m0 = i0.c0;
            if(m0 != null) {
                return m0.p;
            }
        }
        return null;
    }

    @Override  // P0.a
    public final void h0(B0.b b0) {
        e e0 = this.f.a.y();
        Object[] arr_object = e0.a;
        int v = e0.c;
        for(int v1 = 0; v1 < v; ++v1) {
            b0.invoke(((I)arr_object[v1]).c0.p);
        }
    }

    @Override  // P0.a
    public final void l0() {
        I.W(this.f.a, false, 7);
    }

    @Override  // N0.a0
    public final int n0(o o0) {
        M m0 = this.f;
        I i0 = m0.a.u();
        E e0 = null;
        J j0 = this.N;
        if((i0 == null ? null : i0.c0.d) == E.a) {
            j0.c = true;
        }
        else {
            I i1 = m0.a.u();
            if(i1 != null) {
                e0 = i1.c0.d;
            }
            if(e0 == E.c) {
                j0.d = true;
            }
        }
        this.m = true;
        int v = m0.a().n0(o0);
        this.m = false;
        return v;
    }

    @Override  // N0.a0
    public final int o0() {
        return this.f.a().o0();
    }

    @Override  // N0.a0
    public final int p0() {
        return this.f.a().p0();
    }

    @Override  // N0.a0, N0.p
    public final Object q() {
        return this.B;
    }

    @Override  // P0.b0
    public final void r(boolean z) {
        M m0 = this.f;
        if(z != m0.a().f) {
            m0.a().f = z;
            this.g0 = true;
        }
    }

    @Override  // N0.a0
    public final void r0(long v, float f, k k0) {
        N0.Z z2;
        boolean z1;
        boolean z;
        this.E = true;
        M m0 = this.f;
        if(!j.a(v, this.n) || this.g0) {
            if(m0.k || m0.j || this.g0) {
                this.I = true;
                this.g0 = false;
            }
            this.x0();
        }
        V v1 = m0.q;
        I i0 = m0.a;
        if(v1 == null) {
            z1 = false;
        }
        else {
            M m1 = v1.f;
            if(f.q(m1.a)) {
                z = true;
            }
            else {
                if(v1.w == S.c && !m1.b) {
                    m1.c = true;
                }
                z = m1.c;
            }
            z1 = z;
        }
        if(z1) {
            j0 j00 = m0.a().n;
            if(j00 == null) {
                z2 = ((u)P0.L.a(i0)).getPlacementScope();
            }
            else {
                z2 = j00.i;
                if(z2 == null) {
                    z2 = ((u)P0.L.a(i0)).getPlacementScope();
                }
            }
            V v2 = m0.q;
            q.d(v2);
            I i1 = i0.u();
            if(i1 != null) {
                i1.c0.h = 0;
            }
            v2.i = 0x7FFFFFFF;
            N0.Z.e(z2, v2, ((int)(v >> 0x20)), ((int)(0xFFFFFFFFL & v)));
        }
        if(m0.q != null && !m0.q.l) {
            M0.a.b("Error: Placement happened before lookahead.");
        }
        this.A0(v, f, k0);
    }

    @Override  // P0.a
    public final void requestLayout() {
        this.f.a.V(false);
    }

    @Override  // P0.a
    public final void s() {
        this.V = true;
        J j0 = this.N;
        j0.h();
        M m0 = this.f;
        if(this.I) {
            e e0 = m0.a.y();
            Object[] arr_object = e0.a;
            int v = e0.c;
            for(int v1 = 0; v1 < v; ++v1) {
                I i0 = (I)arr_object[v1];
                if(i0.r() && i0.c0.p.l == G.a && I.P(i0)) {
                    I.W(m0.a, false, 7);
                }
            }
        }
        if(this.M || !this.m && !this.I().h && this.I) {
            this.I = false;
            E e1 = m0.d;
            m0.d = E.c;
            m0.e(false);
            t0 t00 = ((u)P0.L.a(m0.a)).getSnapshotObserver();
            t00.a(m0.a, t00.e, this.Y);
            m0.d = e1;
            if(this.I().h && m0.j) {
                this.requestLayout();
            }
            this.M = false;
        }
        if(j0.d) {
            j0.e = true;
        }
        if(j0.b && j0.e()) {
            j0.g();
        }
        this.V = false;
    }

    public final List u0() {
        M m0 = this.f;
        m0.a.e0();
        e e0 = this.S;
        if(!this.T) {
            return e0.f();
        }
        I i0 = m0.a;
        e e1 = i0.y();
        Object[] arr_object = e1.a;
        int v = e1.c;
        for(int v1 = 0; v1 < v; ++v1) {
            I i1 = (I)arr_object[v1];
            if(e0.c <= v1) {
                e0.b(i1.c0.p);
            }
            else {
                Object[] arr_object1 = e0.a;
                Object object0 = arr_object1[v1];
                arr_object1[v1] = i1.c0.p;
            }
        }
        e0.l(((g0.b)i0.o()).a.c, e0.c);
        this.T = false;
        return e0.f();
    }

    public final void v0() {
        boolean z = this.D;
        this.D = true;
        I i0 = this.f.a;
        d0 d00 = i0.b0;
        if(!z) {
            ((v)d00.c).e1();
            if(i0.r()) {
                I.W(i0, true, 6);
            }
            else if(i0.c0.e) {
                I.U(i0, true, 6);
            }
        }
        j0 j00 = (j0)d00.d;
        j0 j01 = ((v)d00.c).m;
        while(!q.b(j00, j01) && j00 != null) {
            if(j00.Z) {
                j00.Y0();
            }
            j00 = j00.m;
        }
        e e0 = i0.y();
        Object[] arr_object = e0.a;
        int v = e0.c;
        for(int v1 = 0; v1 < v; ++v1) {
            I i1 = (I)arr_object[v1];
            if(i1.v() != 0x7FFFFFFF) {
                i1.c0.p.v0();
                I.X(i1);
            }
        }
    }

    public final void w0() {
        if(this.D) {
            this.D = false;
            M m0 = this.f;
            j0 j00 = (j0)m0.a.b0.d;
            j0 j01 = ((v)m0.a.b0.c).m;
            while(!q.b(j00, j01) && j00 != null) {
                p p0 = j00.T0(false);
                if(p0 == null || (p0.getNode().getAggregateChildKindSet$ui_release() & 0x100000) == 0) {
                label_40:
                    if(j00.b0 != null) {
                        j00.n1(null, false);
                        j00.l.V(false);
                    }
                }
                else {
                    p p1 = j00.R0().getParent$ui_release();
                    if(p1 == null) {
                        goto label_40;
                    }
                    else {
                        p p2 = j00.T0(false);
                        while(true) {
                            if(p2 == null || (p2.getAggregateChildKindSet$ui_release() & 0x100000) == 0) {
                                goto label_40;
                            }
                            if((p2.getKindSet$ui_release() & 0x100000) != 0) {
                                p p3 = p2;
                                e e0 = null;
                                while(p3 != null) {
                                    if((p3.getKindSet$ui_release() & 0x100000) != 0 && p3 instanceof n) {
                                        p p4 = ((n)p3).b;
                                        int v1 = 0;
                                        while(p4 != null) {
                                            if((p4.getKindSet$ui_release() & 0x100000) != 0) {
                                                ++v1;
                                                if(v1 == 1) {
                                                    p3 = p4;
                                                }
                                                else {
                                                    if(e0 == null) {
                                                        e0 = new e(new p[16]);
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
                                            p3 = f.f(e0);
                                        }
                                    }
                                    else {
                                        p3 = f.f(e0);
                                    }
                                }
                            }
                            if(p2 != p1) {
                                p2 = p2.getChild$ui_release();
                                continue;
                            }
                            goto label_40;
                        }
                    }
                }
                j00 = j00.m;
            }
            e e1 = m0.a.y();
            Object[] arr_object = e1.a;
            int v2 = e1.c;
            for(int v = 0; v < v2; ++v) {
                ((I)arr_object[v]).c0.p.w0();
            }
        }
    }

    public final void x0() {
        M m0 = this.f;
        if(m0.l > 0) {
            e e0 = m0.a.y();
            Object[] arr_object = e0.a;
            int v = e0.c;
            for(int v1 = 0; v1 < v; ++v1) {
                I i0 = (I)arr_object[v1];
                Z z0 = i0.c0.p;
                if((i0.c0.j || i0.c0.k) && !z0.I) {
                    i0.V(false);
                }
                z0.x0();
            }
        }
    }

    @Override  // P0.a
    public final boolean y() {
        return this.D;
    }

    public final void y0() {
        G g0;
        I.W(this.f.a, false, 7);
        I i0 = this.f.a;
        I i1 = i0.u();
        if(i1 != null && i0.X == G.c) {
            switch(i1.c0.d.ordinal()) {
                case 0: {
                    g0 = G.a;
                    break;
                }
                case 2: {
                    g0 = G.b;
                    break;
                }
                default: {
                    g0 = i1.X;
                }
            }
            i0.X = g0;
        }
    }

    public final void z0() {
        this.b0 = true;
        I i0 = this.f.a.u();
        float f = this.I().N;
        I i1 = this.f.a;
        j0 j00 = (j0)i1.b0.d;
        v v0 = (v)i1.b0.c;
        while(j00 != v0) {
            q.e(j00, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            f += ((B)j00).N;
            j00 = j00.m;
        }
        if(f != this.Z) {
            this.Z = f;
            if(i0 != null) {
                i0.N();
            }
            if(i0 != null) {
                i0.B();
            }
        }
        if(this.D) {
            ((v)i1.b0.c).e1();
        }
        else {
            if(i0 != null) {
                i0.B();
            }
            this.v0();
            if(this.g && i0 != null) {
                i0.V(false);
            }
        }
        if(i0 == null) {
            this.i = 0;
        }
        else {
            M m0 = i0.c0;
            if(!this.g && m0.d == E.c) {
                if(this.i != 0x7FFFFFFF) {
                    M0.a.b("Place was called on a node which was placed already");
                }
                int v1 = m0.i;
                this.i = v1;
                m0.i = v1 + 1;
            }
        }
        this.s();
    }
}

