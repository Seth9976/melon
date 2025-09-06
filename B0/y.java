package b0;

import G.z0;
import K.m;
import M.i0;
import Z.N;
import a0.f;
import androidx.compose.runtime.J;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.m0;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import e0.d;
import r0.n;
import r0.q;
import we.a;
import we.o;
import y0.Q;
import y0.s;

public abstract class y {
    public static final f a;

    static {
        y.a = new f(0.16f, 0.1f, 0.08f, 0.1f);
    }

    public static final void a(a a0, q q0, boolean z, Q q1, b0.a a1, e e0, i0 i00, o o0, l l0, int v) {
        i0 i01;
        e e1;
        b0.a a2;
        Q q3;
        boolean z1;
        q q2;
        G.e e5;
        boolean z5;
        long v5;
        float f;
        boolean z3;
        e e3;
        long v4;
        Q q7;
        i0 i02;
        e e2;
        b0.a a3;
        Q q5;
        boolean z2;
        q q4;
        b0.a a5;
        p p0 = (p)l0;
        p0.c0(0x26C01063);
        if(((v | (p0.i(a0) ? 4 : 2) | 0x6D925B0) & 306783379) != 306783378 || !p0.D()) {
            p0.V();
            if((v & 1) == 0 || p0.B()) {
                Q q6 = D.a(p0, d.b);
                h h0 = (h)p0.k(j.a);
                b0.a a4 = h0.K;
                if(a4 == null) {
                    a5 = new b0.a(j.a(h0, 26), j.a(h0, d.h), s.c(j.a(h0, d.c), 0.12f), s.c(j.a(h0, d.e), 0.38f));
                    h0.K = a5;
                }
                else {
                    a5 = a4;
                }
                e2 = new e(d.a, d.i, d.f, d.g, d.d);
                i02 = b.a;
                z2 = true;
                a3 = a5;
                q5 = q6;
                q4 = n.a;
            }
            else {
                p0.T();
                q4 = q0;
                z2 = z;
                q5 = q1;
                a3 = a1;
                e2 = e0;
                i02 = i00;
            }
            p0.q();
            p0.a0(0xF1BEC271);
            m m0 = p0.N();
            V v1 = k.a;
            if(m0 == v1) {
                m0 = androidx.appcompat.app.o.d(p0);
            }
            p0.p(false);
            long v2 = z2 ? a3.a : a3.c;
            long v3 = z2 ? a3.b : a3.d;
            p0.a0(-239150048);
            G.p p1 = null;
            if(e2 == null) {
                q7 = q5;
                v4 = v3;
                e3 = null;
                z3 = z2;
            }
            else {
                p0.p p2 = p0.N();
                if(p2 == v1) {
                    p2 = new p0.p();
                    p0.l0(p2);
                }
                boolean z4 = p0.g(m0);
                c c0 = p0.N();
                if(z4 || c0 == v1) {
                    c0 = new c(m0, p2, null);
                    p0.l0(c0);
                }
                J.d(p0, m0, c0);
                K.k k0 = (K.k)je.p.t0(p2);
                if(!z2) {
                    f = e2.e;
                }
                else if(k0 instanceof K.o) {
                    f = e2.b;
                }
                else if(k0 instanceof K.h) {
                    f = e2.d;
                }
                else {
                    f = k0 instanceof K.f ? e2.c : e2.a;
                }
                G.e e4 = p0.N();
                if(e4 == v1) {
                    v5 = v3;
                    z5 = z2;
                    e4 = new G.e(new r1.f(f), z0.c, null, 12);
                    p0.l0(e4);
                }
                else {
                    v5 = v3;
                    z5 = z2;
                }
                r1.f f1 = new r1.f(f);
                boolean z6 = p0.i(e4);
                boolean z7 = p0.d(f);
                boolean z8 = p0.g(e2);
                boolean z9 = p0.i(k0);
                b0.d d0 = p0.N();
                if((z6 | z7 | z8 | z9) != 0 || d0 == v1) {
                    z3 = z5;
                    q7 = q5;
                    e5 = e4;
                    v4 = v5;
                    b0.d d1 = new b0.d(e5, f, z3, e2, k0, null);
                    e3 = e2;
                    p0.l0(d1);
                    d0 = d1;
                }
                else {
                    z3 = z5;
                    q7 = q5;
                    e5 = e4;
                    v4 = v5;
                    e3 = e2;
                }
                J.d(p0, f1, d0);
                p1 = e5.c;
            }
            p0.p(false);
            float f2 = p1 == null ? 0.0f : ((r1.f)((O0)p1.b).getValue()).a;
            q q8 = X0.n.c(q4, false, b0.f.g);
            m0.b b0 = m0.c.e(0x3902DB2E, p0, new U.b(v4, i02, o0));
            float f3 = ((r1.f)p0.k(S.a)).a + 0.0f;
            s s0 = new s(v4);
            m0 m00 = b0.k.a.a(s0);
            r1.f f4 = new r1.f(f3);
            z1 = z3;
            w.b(new m0[]{m00, S.a.a(f4)}, m0.c.e(1279702876, p0, new N(q8, q7, v2, f3, m0, z3, a0, f2, b0)), p0, 56);
            q3 = q7;
            a2 = a3;
            i01 = i02;
            e1 = e3;
            q2 = q4;
        }
        else {
            p0.T();
            q2 = q0;
            z1 = z;
            q3 = q1;
            a2 = a1;
            e1 = e0;
            i01 = i00;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new g(a0, q2, z1, q3, a2, e1, i01, o0, v);
        }
    }

    public static final void b(q q0, float f, long v, l l0, int v1) {
        q q1;
        q q2;
        ((p)l0).c0(0x47A9D25);
        int v2 = v1 | 6 | (((p)l0).f(v) ? 0x100 : 0x80);
        if((v2 & 0x93) != 0x92 || !((p)l0).D()) {
            ((p)l0).V();
            if((v1 & 1) == 0 || ((p)l0).B()) {
                q2 = n.a;
            }
            else {
                ((p)l0).T();
                q2 = q0;
            }
            ((p)l0).q();
            q q3 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(q2, 1.0f), f);
            boolean z = (v2 & 0x380 ^ 0x180) > 0x100 && ((p)l0).f(v) || (v2 & 0x180) == 0x100;
            b0.m m0 = ((p)l0).N();
            if(z || m0 == k.a) {
                m0 = new b0.m(v, f);
                ((p)l0).l0(m0);
            }
            androidx.compose.foundation.q.b(q3, m0, ((p)l0), 0);
            q1 = q2;
        }
        else {
            ((p)l0).T();
            q1 = q0;
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new b0.n(q1, f, v, v1);
        }
    }
}

