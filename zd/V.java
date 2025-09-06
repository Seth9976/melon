package zd;

import Ac.Z3;
import Bd.F;
import Cc.M0;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import Cc.u1;
import M.c;
import M.g;
import M.j0;
import M.j;
import M.n0;
import M.p0;
import M.q0;
import M.y;
import P0.h;
import P0.i;
import T.e;
import U4.x;
import androidx.compose.foundation.layout.a;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.iloen.melon.custom.l1;
import com.melon.ui.K4;
import ie.H;
import java.util.List;
import r0.d;
import r0.n;
import r0.q;
import wc.u;
import we.k;
import y0.M;

public abstract class v {
    public static final void a(m m0, K4 k40, k k0, l l0, int v) {
        h h17;
        i i5;
        h h16;
        u u2;
        h h15;
        h h14;
        h h13;
        r0.h h12;
        y0.k k2;
        i i4;
        h h11;
        h h10;
        i i3;
        r0.h h9;
        i i2;
        h h8;
        u u1;
        h h7;
        n n1;
        h h6;
        h h5;
        r0.i i0 = d.e;
        p p0 = (p)l0;
        p0.c0(0xCC9172BA);
        int v1 = v | (p0.i(m0) ? 4 : 2) | (p0.g(k40) ? 0x20 : 16) | (p0.i(k0) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            q q0 = a.n(n.a, 0.0f, 10.0f, 0.0f, 10.0f, 5);
            n n0 = n.a;
            q q1 = androidx.compose.foundation.layout.d.f(q0, 1.0f);
            g g0 = j.h(12.0f);
            r0.h h0 = d.j;
            p0 p00 = n0.a(g0, h0, p0, 6);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h1 = P0.j.f;
            w.x(p0, p00, h1);
            h h2 = P0.j.e;
            w.x(p0, i00, h2);
            h h3 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h3);
            }
            h h4 = P0.j.d;
            w.x(p0, q2, h4);
            u u0 = M.a;
            if(m0.x()) {
                p0.a0(871290167);
                q q3 = r0.a.a(a.l(androidx.compose.foundation.q.f(d5.n.o(q0.a(androidx.compose.foundation.layout.d.h(n0, 48.0f), 1.0f), e.b(4.0f)), e0.T(p0, 0x7F060145), u0), 3.0f, 0.0f, 2), new zd.u(m0, k0, 0));  // color:gray050s
                N0.M m1 = M.p.d(i0, false);
                int v3 = p0.P;
                i0 i01 = p0.m();
                q q4 = r0.a.d(p0, q3);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m1, h1);
                w.x(p0, i01, h2);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                    A7.d.q(v3, p0, v3, h3);
                }
                w.x(p0, q4, h4);
                p0 p01 = n0.a(j.a, h0, p0, 0);
                int v4 = p0.P;
                i0 i02 = p0.m();
                q q5 = r0.a.d(p0, n0);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, p01, h1);
                w.x(p0, i02, h2);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                    A7.d.q(v4, p0, v4, h3);
                }
                w.x(p0, q5, h4);
                y0.k k1 = new y0.k(e0.T(p0, 0x7F060165), 5);  // color:gray800s
                h5 = h4;
                h6 = h1;
                n1 = n0;
                h7 = h3;
                u1 = u0;
                h8 = h2;
                i2 = i1;
                h9 = h0;
                c1.n(androidx.compose.foundation.layout.d.n(n0, 16.0f), 0x7F0804CE, null, null, false, 0, null, null, null, 0.0f, k1, 0, 0, false, false, p0, 54, 0, 0x7BFC);  // drawable:ic_more_btn_add_16
                N1.b(l1.s(n1, 8.0f, p0, 0x7F130283, p0), null, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // string:ctx_menu_put "담기"
                A7.d.s(p0, true, true, false);
            }
            else {
                h5 = h4;
                h6 = h1;
                n1 = n0;
                h7 = h3;
                u1 = u0;
                h8 = h2;
                i2 = i1;
                h9 = h0;
                p0.a0(0x31F1CB44);
                p0.p(false);
            }
            if(m0.m()) {
                p0.a0(0x3406644A);
                q q6 = r0.a.a(a.l(androidx.compose.foundation.q.f(d5.n.o(e0.Q(q0.a(androidx.compose.foundation.layout.d.h(n1, 48.0f), 1.0f), m0.j()), e.b(4.0f)), e0.T(p0, 0x7F060145), u1), 3.0f, 0.0f, 2), new M0(k0, m0.j()));  // color:gray050s
                N0.M m2 = M.p.d(i0, false);
                int v5 = p0.P;
                i0 i03 = p0.m();
                q q7 = r0.a.d(p0, q6);
                p0.e0();
                if(p0.O) {
                    i3 = i2;
                    p0.l(i3);
                }
                else {
                    i3 = i2;
                    p0.o0();
                }
                w.x(p0, m2, h6);
                w.x(p0, i03, h8);
                if(!p0.O && kotlin.jvm.internal.q.b(p0.N(), v5)) {
                    h10 = h7;
                }
                else {
                    h10 = h7;
                    A7.d.q(v5, p0, v5, h10);
                }
                w.x(p0, q7, h5);
                p0 p02 = n0.a(j.a, h9, p0, 0);
                int v6 = p0.P;
                i0 i04 = p0.m();
                q q8 = r0.a.d(p0, n1);
                p0.e0();
                if(p0.O) {
                    p0.l(i3);
                }
                else {
                    p0.o0();
                }
                w.x(p0, p02, h6);
                w.x(p0, i04, h8);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                    A7.d.q(v6, p0, v6, h10);
                }
                w.x(p0, q8, h5);
                boolean z = k40 instanceof N ? ((N)k40).a : false;
                int v7 = m0.d(z);
                if(z) {
                    h11 = h10;
                    i4 = i3;
                    p0.a0(-1322870141);
                    p0.p(false);
                    k2 = null;
                }
                else {
                    p0.a0(0x163B0764);
                    h11 = h10;
                    i4 = i3;
                    k2 = new y0.k(e0.T(p0, 0x7F060165), 5);  // color:gray800s
                    p0.p(false);
                }
                h12 = h9;
                h13 = h6;
                h14 = h5;
                h15 = h11;
                u2 = u1;
                h16 = h8;
                c1.n(androidx.compose.foundation.layout.d.n(n1, 16.0f), v7, null, null, false, 0, null, null, null, 0.0f, k2, 0, 0, false, false, p0, 6, 0, 0x7BFC);
                c.d(p0, androidx.compose.foundation.layout.d.q(n1, 8.0f));
                N1.b(H0.e.Y(p0, m0.e()), null, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // color:gray900s
                A7.d.s(p0, true, true, false);
            }
            else {
                h12 = h9;
                i4 = i2;
                h13 = h6;
                h16 = h8;
                h15 = h7;
                h14 = h5;
                u2 = u1;
                p0.a0(0x31F1CB44);
                p0.p(false);
            }
            if(m0.n()) {
                p0.a0(0x341FA826);
                q q9 = r0.a.a(a.l(androidx.compose.foundation.q.f(d5.n.o(e0.Q(q0.a(androidx.compose.foundation.layout.d.h(n1, 48.0f), 1.0f), m0.l()), e.b(4.0f)), e0.T(p0, 0x7F060145), u2), 3.0f, 0.0f, 2), new zd.u(m0, k0, 1));  // color:gray050s
                N0.M m3 = M.p.d(i0, false);
                int v8 = p0.P;
                i0 i05 = p0.m();
                q q10 = r0.a.d(p0, q9);
                p0.e0();
                if(p0.O) {
                    i5 = i4;
                    p0.l(i5);
                }
                else {
                    i5 = i4;
                    p0.o0();
                }
                w.x(p0, m3, h13);
                w.x(p0, i05, h16);
                if(!p0.O && kotlin.jvm.internal.q.b(p0.N(), v8)) {
                    h17 = h15;
                }
                else {
                    h17 = h15;
                    A7.d.q(v8, p0, v8, h17);
                }
                w.x(p0, q10, h14);
                p0 p03 = n0.a(j.a, h12, p0, 0);
                int v9 = p0.P;
                i0 i06 = p0.m();
                q q11 = r0.a.d(p0, n1);
                p0.e0();
                if(p0.O) {
                    p0.l(i5);
                }
                else {
                    p0.o0();
                }
                w.x(p0, p03, h13);
                w.x(p0, i06, h16);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v9)) {
                    A7.d.q(v9, p0, v9, h17);
                }
                w.x(p0, q11, h14);
                y0.k k3 = new y0.k(e0.T(p0, 0x7F060165), 5);  // color:gray800s
                c1.n(androidx.compose.foundation.layout.d.n(n1, 16.0f), 0x7F0804D1, null, null, false, 0, null, null, null, 0.0f, k3, 0, 0, false, false, p0, 54, 0, 0x7BFC);  // drawable:ic_more_btn_share_16
                N1.b(l1.s(n1, 8.0f, p0, 0x7F13028A, p0), null, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // string:ctx_menu_share "공유하기"
                A7.d.s(p0, true, true, false);
            }
            else {
                p0.a0(0x31F1CB44);
                p0.p(false);
            }
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new yc.e(m0, k40, k0, v);
        }
    }

    public static final void b(Q q0, O o0, K4 k40, k k0, k k1, int v, we.a a0, l l0, int v1) {
        p p0 = (p)l0;
        p0.c0(0x2429110B);
        int v2 = v1 | (p0.i(q0) ? 4 : 2) | (p0.i(o0) ? 0x20 : 16) | (p0.g(k40) ? 0x100 : 0x80) | (p0.i(k0) ? 0x800 : 0x400) | (p0.i(k1) ? 0x4000 : 0x2000) | (p0.e(v) ? 0x20000 : 0x10000) | (p0.i(a0) ? 0x100000 : 0x80000);
        if(p0.Q(v2 & 1, (0x92493 & v2) != 0x92492)) {
            b0 b00 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if(b00 == v3) {
                b00 = w.s(0);
                p0.l0(b00);
            }
            b0 b01 = p0.N();
            if(b01 == v3) {
                b01 = w.s(q0);
                p0.l0(b01);
            }
            if(((Q)b01.getValue()).g() != q0.g()) {
                b00.setValue(0);
                b01.setValue(q0);
            }
            u1 u10 = p0.N();
            if((0x380000 & v2) == 0x100000 || u10 == v3) {
                u10 = new u1(21, a0);
                p0.l0(u10);
            }
            J.b(H.a, u10, p0);
            n n0 = n.a;
            q q1 = androidx.compose.ui.input.nestedscroll.a.a(androidx.compose.foundation.layout.d.f(n0, 1.0f), Q0.N.u(p0), null);
            Z3 z30 = p0.N();
            if((0xE000 & v2) == 0x4000 || z30 == v3) {
                z30 = new Z3(k1, b00, 5);
                p0.l0(z30);
            }
            q q2 = androidx.compose.ui.layout.a.f(q1, z30);
            y y0 = M.w.a(j.e, d.n, p0, 54);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            w.x(p0, q3, P0.j.d);
            List list0 = o0.a;
            q q4 = androidx.compose.foundation.layout.d.f(n0, 1.0f);
            j0 j00 = a.a(20.0f, 0.0f, 2);
            boolean z = p0.i(q0);
            boolean z1 = p0.i(list0);
            F f0 = p0.N();
            if((((v2 & 0x380) == 0x100 ? 1 : 0) | (z | (v2 & 0x1C00) == 0x800 | z1)) != 0 || f0 == v3) {
                F f1 = new F(list0, q0, k0, k40, 27);
                p0.l0(f1);
                f0 = f1;
            }
            c1.o(q4, null, j00, false, null, null, null, false, f0, p0, 390, 0xFA);
            if(v == 0 || ((Number)b00.getValue()).intValue() <= v) {
                p0.a0(2062265121);
            }
            else {
                p0.a0(0x7CDE8BFC);
                c.d(p0, androidx.compose.foundation.q.x(x.r(1.0f, androidx.compose.foundation.layout.d.f(n0, 1.0f), true), androidx.compose.foundation.q.t(p0), false, 14));
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Cc.n0(q0, o0, k40, k0, k1, v, a0, v1);
        }
    }
}

