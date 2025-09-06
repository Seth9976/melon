package b0;

import A0.i;
import G.C;
import G.H;
import G.I;
import G.L;
import G.M;
import G.N;
import G.O;
import G.z0;
import Q0.k0;
import X0.n;
import Z.B;
import androidx.compose.foundation.layout.a;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.V;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import e1.m;
import r0.q;
import r1.c;
import x0.e;

public abstract class w {
    public static final float a;
    public static final float b;
    public static final G.w c;

    static {
        w.a = 10.0f;
        a.l(n.c(androidx.compose.ui.layout.a.b(r0.n.a, v.f), true, f.h), 0.0f, 10.0f, 1);
        w.b = e0.f.c - e0.f.b * 2.0f;
        new G.w(0.2f, 0.0f, 0.8f, 1.0f);
        new G.w(0.4f, 0.0f, 1.0f, 1.0f);
        new G.w(0.0f, 0.0f, 0.65f, 1.0f);
        new G.w(0.1f, 0.0f, 0.45f, 1.0f);
        w.c = new G.w(0.4f, 0.0f, 0.2f, 1.0f);
    }

    public static final void a(we.a a0, q q0, long v, float f, long v1, int v2, float f1, l l0, int v3) {
        float f2;
        int v5;
        float f4;
        float f3;
        int v6;
        p p0 = (p)l0;
        p0.c0(0x94C736F5);
        int v4 = v3 | (p0.i(a0) ? 4 : 2) | (p0.f(v) ? 0x100 : 0x80) | (p0.f(v1) ? 0x4000 : 0x2000) | 0x1B0000;
        if((0x92493 & v4) != 0x92492 || !p0.D()) {
            p0.V();
            if((v3 & 1) == 0 || p0.B()) {
                f3 = b0.q.c;
                v6 = b0.q.a;
            }
            else {
                p0.T();
                v6 = v2;
                f3 = f1;
            }
            p0.q();
            u u0 = p0.N();
            V v7 = k.a;
            if((v4 & 14) == 4 || u0 == v7) {
                u0 = new u(0, a0);
                p0.l0(u0);
            }
            i i0 = new i(v6, 0, ((c)p0.k(k0.h)).Y(f), 0.0f, 26);
            boolean z = p0.g(u0);
            Y.V v8 = p0.N();
            if(z || v8 == v7) {
                v8 = new Y.V(1, u0);
                p0.l0(v8);
            }
            q q1 = d.n(n.c(q0, true, v8), w.b);
            boolean z1 = p0.g(u0);
            boolean z2 = (v4 & 0xE000 ^ 0x6000) > 0x4000 && p0.f(v1) || (v4 & 0x6000) == 0x4000;
            boolean z3 = p0.i(i0);
            int v9 = ((v4 & 0x380 ^ 0x180) <= 0x100 || !p0.f(v)) && (v4 & 0x180) != 0x100 ? 0 : 1;
            r r0 = p0.N();
            if((z2 | z1 | z3 | v9) != 0 || r0 == v7) {
                f4 = f3;
                r0 = new r(u0, v6, f4, f, v1, i0, v);
                p0.l0(r0);
            }
            else {
                f4 = f3;
            }
            androidx.compose.foundation.q.b(q1, r0, p0, 0);
            f2 = f4;
            v5 = v6;
        }
        else {
            p0.T();
            v5 = v2;
            f2 = f1;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new s(a0, q0, v, f, v1, v5, f2, v3);
        }
    }

    public static final void b(q q0, long v, float f, long v1, int v2, l l0, int v3) {
        p p0;
        int v6;
        long v5;
        t t0;
        long v11;
        int v9;
        long v8;
        int v7;
        ((p)l0).c0(0xF917F061);
        int v4 = v3 | (((p)l0).f(v) ? 0x20 : 16) | 0x6400;
        if((v4 & 9363) != 9362 || !((p)l0).D()) {
            ((p)l0).V();
            if((v3 & 1) == 0 || ((p)l0).B()) {
                v8 = y0.s.f;
                v7 = v4 & 0xFFFFE3FF;
                v9 = b0.q.b;
            }
            else {
                ((p)l0).T();
                v7 = v4 & 0xFFFFE3FF;
                v8 = v1;
                v9 = v2;
            }
            ((p)l0).q();
            i i0 = new i(v9, 0, ((c)((p)l0).k(k0.h)).Y(f), 0.0f, 26);
            L l1 = G.f.p(null, ((p)l0), 1);
            H h0 = G.f.n(G.f.r(6660, 0, C.d, 2), null, 0L, 6);
            I i1 = G.f.i(l1, 0, 5, z0.b, h0, null, ((p)l0), 33208, 16);
            I i2 = G.f.f(l1, 0.0f, 286.0f, G.f.n(G.f.r(0x534, 0, C.d, 2), null, 0L, 6), null, ((p)l0), 4536, 8);
            N n0 = new N();
            n0.a = 0x534;
            M m0 = n0.a(0.0f, 0);
            m0.b = w.c;
            n0.a(290.0f, 666);
            I i3 = G.f.f(l1, 0.0f, 290.0f, G.f.n(new O(n0), null, 0L, 6), null, ((p)l0), 4536, 8);
            N n1 = new N();
            n1.a = 0x534;
            M m1 = n1.a(0.0f, 666);
            m1.b = w.c;
            n1.a(290.0f, n1.a);
            I i4 = G.f.f(l1, 0.0f, 290.0f, G.f.n(new O(n1), null, 0L, 6), null, ((p)l0), 4536, 8);
            p0 = (p)l0;
            int v10 = 1;
            q q1 = d.n(n.c(q0, true, androidx.compose.foundation.u.k), w.b);
            boolean z = p0.f(v8);
            boolean z1 = p0.i(i0);
            boolean z2 = p0.g(i1);
            boolean z3 = p0.g(i3);
            boolean z4 = p0.g(i4);
            boolean z5 = p0.g(i2);
            if(((v7 & 0x70 ^ 0x30) <= 0x20 || !p0.f(v)) && (v7 & 0x30) != 0x20) {
                v10 = 0;
            }
            Object object0 = p0.N();
            if((z | z1 | z2 | z3 | z4 | z5 | v10) == 0 && object0 != k.a) {
                t0 = object0;
                v11 = v8;
            }
            else {
                v11 = v8;
                t0 = new t(v11, i0, i1, i3, i4, i2, f, v);
                p0.l0(t0);
            }
            androidx.compose.foundation.q.b(q1, t0, p0, 0);
            v5 = v11;
            v6 = v9;
        }
        else {
            ((p)l0).T();
            v5 = v1;
            v6 = v2;
            p0 = (p)l0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new B(q0, v, f, v5, v6, v3);
        }
    }

    public static final void c(A0.f f0, float f1, float f2, long v, i i0) {
        float f3 = i0.b / 2.0f;
        float f4 = e.d(f0.c()) - 2.0f * f3;
        A0.f.Z(f0, v, f1, f2, false, df.v.h(f3, f3), m.i(f4, f4), 0.0f, i0, 0x340);
    }
}

