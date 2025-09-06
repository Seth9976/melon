package U8;

import Ac.X;
import Ac.m2;
import Cc.M0;
import Cc.N1;
import Cc.O0;
import Cc.c1;
import Cc.e0;
import Cc.p1;
import Cc.u1;
import De.I;
import H0.b;
import M.c;
import M.g;
import M.j0;
import M.p0;
import N0.M;
import O.F;
import P0.h;
import P0.i;
import P0.j;
import Rc.w;
import T.e;
import Tf.v;
import U4.x;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.d;
import androidx.compose.foundation.y;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import java.util.List;
import r0.q;
import we.a;
import we.k;
import we.n;
import y0.E;
import y0.s;

public abstract class p {
    public static final float a;
    public static final float b;

    static {
        p.a = 40.0f;
        p.b = 22.0f;
    }

    public static final void a(List list0, boolean z, n n0, a a0, l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(-30184036);
        int v1 = (((androidx.compose.runtime.p)l0).i(list0) ? 4 : 2) | v | (((androidx.compose.runtime.p)l0).h(z) ? 0x20 : 16) | (((androidx.compose.runtime.p)l0).i(n0) ? 0x100 : 0x80) | (((androidx.compose.runtime.p)l0).i(a0) ? 0x800 : 0x400);
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 0x493) != 1170)) {
            c.a(d.f(d.h(r0.n.a, 212.0f), 1.0f), null, false, m0.c.e(0xC8E7FFF2, ((androidx.compose.runtime.p)l0), new Dc.a(list0, z, n0, a0)), ((androidx.compose.runtime.p)l0), 0xC06, 6);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new w(list0, z, n0, a0, v);
        }
    }

    public static final void b(q q0, boolean z, k k0, int v, int v1, l l0, int v2) {
        int v7;
        int v6;
        kotlin.jvm.internal.q.g(q0, "modifier");
        kotlin.jvm.internal.q.g(k0, "onCheckedChange");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x28F3B7BF);
        int v3 = (v2 & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v2 : v2;
        if((v2 & 0x30) == 0) {
            v3 |= (p0.h(z) ? 0x20 : 16);
        }
        if((v2 & 0x180) == 0) {
            v3 |= (p0.i(k0) ? 0x100 : 0x80);
        }
        if(p0.Q((v3 | 0x6C00) & 1, ((v3 | 0x6C00) & 9363) != 9362)) {
            C0.c c0 = I.Q((z ? 0x7F080167 : 0x7F080165), p0, 0);  // drawable:btn_common_radio_on
            long v4 = e0.T(p0, 0x7F060154);  // color:gray200s_support_high_contrast
            q q1 = r0.a.a(q0, new M0(k0, z, 2));
            M m0 = M.p.d(r0.d.e, false);
            int v5 = p0.P;
            i0 i00 = p0.m();
            q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, j.f);
            androidx.compose.runtime.w.x(p0, i00, j.e);
            h h0 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h0);
            }
            androidx.compose.runtime.w.x(p0, q2, j.d);
            androidx.compose.foundation.q.c(c0, null, null, null, null, 0.0f, (z ? null : new y0.k(v4, 5)), p0, 0x30, 60);
            p0.p(true);
            v6 = 0x7F080165;  // drawable:btn_common_radio_off
            v7 = 0x7F080167;  // drawable:btn_common_radio_on
        }
        else {
            p0.T();
            v7 = v;
            v6 = v1;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U8.n(q0, z, k0, v7, v6, v2);
        }
    }

    public static final void c(q q0, boolean z, k k0, int v, int v1, l l0, int v2) {
        int v6;
        int v5;
        kotlin.jvm.internal.q.g(q0, "modifier");
        kotlin.jvm.internal.q.g(k0, "onCheckedChange");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(1581641308);
        int v3 = v2 | (p0.h(z) ? 0x20 : 16) | (p0.i(k0) ? 0x100 : 0x80) | 0x6C00;
        if(p0.Q(v3 & 1, (v3 & 9363) != 9362)) {
            C0.c c0 = I.Q((z ? 0x7F08027D : 0x7F08027C), p0, 0);  // drawable:btn_toggle_24_on
            q q1 = r0.a.a(q0, new M0(k0, z, 3));
            M m0 = M.p.d(r0.d.e, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, j.f);
            androidx.compose.runtime.w.x(p0, i00, j.e);
            h h0 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            androidx.compose.runtime.w.x(p0, q2, j.d);
            androidx.compose.foundation.q.c(c0, null, d.h(d.q(r0.n.a, 56.0f), 24.0f), null, N0.j.c, 0.0f, null, p0, 25008, 104);
            p0.p(true);
            v5 = 0x7F08027D;  // drawable:btn_toggle_24_on
            v6 = 0x7F08027C;  // drawable:btn_toggle_24_off
        }
        else {
            p0.T();
            v5 = v;
            v6 = v1;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new p1(q0, z, k0, v5, v6, v2, 1);
        }
    }

    public static final void d(String s, boolean z, a a0, l l0, int v) {
        q q1;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x20E9D389);
        int v1 = v | (p0.g(s) ? 4 : 2) | (p0.h(z) ? 0x20 : 16) | (p0.i(a0) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            p0.a0(-1916588005);
            r0.n n0 = r0.n.a;
            q q0 = d.h(n0, 30.0f);
            if(z) {
                p0.a0(0xA50AF2DF);
                q1 = androidx.compose.foundation.q.f(q0, e0.T(p0, 0x7F06017F), e.a(50));  // color:green502s_support_high_contrast
            }
            else {
                p0.a0(0xA50E8AF1);
                y y0 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F060152), 0.5f);  // color:gray200a
                T.d d0 = e.a(50);
                q1 = androidx.compose.foundation.q.j(q0, y0.a, y0.b, d0);
            }
            p0.p(false);
            p0.p(false);
            q q2 = r0.a.a(q1, new Lc.c(8, a0));
            M m0 = M.p.d(r0.d.e, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, j.f);
            androidx.compose.runtime.w.x(p0, i00, j.e);
            h h0 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q3, j.d);
            N1.b(s, androidx.compose.foundation.layout.a.l(n0, 15.0f, 0.0f, 2), e0.T(p0, (z ? 0x7F0604A1 : 0x7F060163)), 13.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, v1 & 14 | 0x30C30, 0, 0x1FFD0);  // color:white000e
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new m(s, z, a0, v, 0);
        }
    }

    public static final void e(List list0, int v, k k0, l l0, int v1) {
        ((androidx.compose.runtime.p)l0).c0(0xE9CFABA0);
        int v2 = v1 | (((androidx.compose.runtime.p)l0).i(list0) ? 4 : 2) | (((androidx.compose.runtime.p)l0).e(v) ? 0x20 : 16) | (((androidx.compose.runtime.p)l0).i(k0) ? 0x100 : 0x80);
        boolean z = true;
        if(((androidx.compose.runtime.p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            b0 b00 = ((androidx.compose.runtime.p)l0).N();
            V v3 = androidx.compose.runtime.k.a;
            if(b00 == v3) {
                b00 = x.d(v, ((androidx.compose.runtime.p)l0));
            }
            F f0 = O.I.a(0, 0, 3, ((androidx.compose.runtime.p)l0));
            Integer integer0 = v;
            o o0 = ((androidx.compose.runtime.p)l0).N();
            if((v2 & 0x70) == 0x20 || o0 == v3) {
                o0 = new o(b00, v, null);
                ((androidx.compose.runtime.p)l0).l0(o0);
            }
            J.d(((androidx.compose.runtime.p)l0), integer0, o0);
            g g0 = M.j.h(8.0f);
            j0 j00 = androidx.compose.foundation.layout.a.a(20.0f, 0.0f, 2);
            r0.h h0 = r0.d.k;
            q q0 = d.h(r0.n.a, 56.0f);
            boolean z1 = ((androidx.compose.runtime.p)l0).i(list0);
            if((v2 & 0x380) != 0x100) {
                z = false;
            }
            m2 m20 = ((androidx.compose.runtime.p)l0).N();
            if(z1 || z || m20 == v3) {
                m20 = new m2(list0, b00, k0, 15);
                ((androidx.compose.runtime.p)l0).l0(m20);
            }
            c1.q(q0, f0, j00, g0, h0, null, false, m20, ((androidx.compose.runtime.p)l0), 0x36186, 200);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new O0(list0, v, k0, v1, 2);
        }
    }

    public static final void f(String s, boolean z, U8.h h0, boolean z1, a a0, l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x8829AF08);
        int v1 = v | (p0.g(s) ? 4 : 2) | (p0.h(z) ? 0x20 : 16) | (p0.i(h0) ? 0x100 : 0x80) | (p0.h(z1) ? 0x800 : 0x400) | (p0.i(a0) ? 0x4000 : 0x2000);
        if(p0.Q(v1 & 1, (v1 & 9363) != 9362)) {
            r0.n n0 = r0.n.a;
            q q0 = r0.a.a(d.h(n0, 48.0f), new X(h0, 19));
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, j.f);
            androidx.compose.runtime.w.x(p0, i00, j.e);
            h h1 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h1);
            }
            androidx.compose.runtime.w.x(p0, q1, j.d);
            c.d(p0, d.q(n0, 20.0f));
            q q2 = d.h(d.q(n0, 18.0f), 18.0f);
            Mc.q q3 = p0.N();
            if((v1 & 0x380) == 0x100 || q3 == androidx.compose.runtime.k.a) {
                q3 = new Mc.q(h0, 20);
                p0.l0(q3);
            }
            p.b(q2, z, q3, 0, 0, p0, v1 & 0x70 | 6);
            c.d(p0, d.q(n0, 14.0f));
            long v3 = e0.T(p0, (z ? 0x7F06017C : 0x7F060169));  // color:green500s_support_high_contrast
            N1.b(s, new LayoutWeightElement(1.0f, true), v3, 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v1 & 14 | 0xC00, 0xC30, 0x1D7F0);
            if(z1) {
                p0.a0(0xDC6E36E6);
                c.d(p0, d.q(n0, 14.0f));
                C0.c c0 = I.Q(0x7F080131, p0, 6);  // drawable:btn_common_delete_26_g
                y0.k k0 = new y0.k(e0.T(p0, 0x7F060154), 5);  // color:gray200s_support_high_contrast
                androidx.compose.foundation.q.c(c0, "", r0.a.a(n0, new Lc.c(9, a0)), null, null, 0.0f, k0, p0, 0, 56);
                x.z(n0, 14.0f, p0, false);
            }
            else {
                p0.a0(-596210666);
                c.d(p0, d.q(n0, 20.0f));
                p0.p(false);
            }
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Mc.i(s, z, h0, z1, a0, v);
        }
    }

    public static final void g(boolean z, String s, String s1, a a0, l l0, int v) {
        r0.n n1;
        q q1;
        kotlin.jvm.internal.q.g(s, "title");
        kotlin.jvm.internal.q.g(s1, "desc");
        kotlin.jvm.internal.q.g(a0, "onClick");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(197502210);
        int v1 = v | (p0.h(z) ? 4 : 2) | (p0.g(s) ? 0x20 : 16) | (p0.g(s1) ? 0x100 : 0x80) | (p0.i(a0) ? 0x4000 : 0x2000);
        if(p0.Q(v1 & 1, (v1 & 0x2093) != 0x2092)) {
            r0.n n0 = r0.n.a;
            q q0 = d.t(d.f(n0, 1.0f), 3);
            if(z) {
                p0.a0(0x30F0935A);
                q1 = androidx.compose.foundation.q.j(n0, 1.0f, new E(e.k.A(new s[]{new s(e0.T(p0, 0x7F060177)), new s(e0.T(p0, 0x7F06017C))}), null, 0L, 0x7F8000007F800000L), e.b(8.0f));  // color:green450s
                p0.p(false);
            }
            else {
                p0.a0(0x30F0C58A);
                p0.p(false);
                q1 = n0;
            }
            q q2 = androidx.compose.foundation.q.f(r0.a.a(q0.then(q1), new Lc.c(10, a0)), e0.T(p0, 0x7F06013E), e.b(8.0f));  // color:gray000s
            p0 p00 = M.n0.a(M.j.a, r0.d.j, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            androidx.compose.runtime.w.x(p0, p00, h0);
            h h1 = j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = j.d;
            androidx.compose.runtime.w.x(p0, q3, h3);
            c.d(p0, d.q(n0, 20.0f));
            q q4 = d.n(n0, 18.0f);
            q q5 = b.r(r0.d.k, q4);
            u1 u10 = p0.N();
            if((v1 & 0xE000) == 0x4000 || u10 == androidx.compose.runtime.k.a) {
                u10 = new u1(6, a0);
                p0.l0(u10);
            }
            p.b(q5, z, u10, 0, 0, p0, v1 << 3 & 0x70);
            c.d(p0, d.q(n0, 16.0f));
            q q6 = d.t(new LayoutWeightElement(1.0f, true), 3);
            M.y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
            i0 i01 = p0.m();
            q q7 = r0.a.d(p0, q6);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q7, h3);
            c.d(p0, d.h(n0, 24.0f));
            N1.b(s, null, e0.T(p0, (z ? 0x7F06017C : 0x7F06016D)), 16.0f, e1.y.h, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, p0, v1 >> 3 & 14 | 0x30C00, 0xC00, 0x1DFD2);  // color:green500s_support_high_contrast
            if(s1.length() > 0) {
                p0.a0(0xBFF14420);
                c.d(p0, d.h(n0, 8.0f));
                q q8 = d.f(n0, 1.0f);
                n1 = n0;
                N1.b(v.p0(s1, " ", " "), q8, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, null, 18.0f, 2, false, 2, 0, null, null, p0, 0xC30, 0xC36, 0x1D3F0);  // color:gray600s_support_high_contrast
            }
            else {
                n1 = n0;
                p0.a0(0xBDCFEEC6);
            }
            p0.p(false);
            A7.d.v(n1, 22.0f, p0, true);
            x.z(n1, 20.0f, p0, true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new w(z, s, s1, a0, v);
        }
    }
}

