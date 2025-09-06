package sd;

import Ac.g1;
import Ac.h1;
import Ac.i1;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import Cc.t0;
import Cc.x0;
import H0.e;
import M.p0;
import N0.M;
import N0.g0;
import P0.h;
import P0.i;
import P0.j;
import Q0.k0;
import Vc.N;
import android.content.Context;
import android.graphics.Color;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.iloen.melon.custom.l1;
import com.iloen.melon.utils.TalkbackUtilKt;
import e.k;
import ed.D;
import ie.H;
import java.util.List;
import ob.A;
import r0.n;
import r0.q;
import r1.c;
import we.a;
import x1.m;
import y0.Q;

public abstract class o {
    public static final List a;

    static {
        o.a = k.A(new String[]{"#283DC0", "#6635CB", "#2D63CB", "#007586", "#0D7134", "#608000", "#967100", "#B64945"});
    }

    public static final void a(a a0, l l0, int v) {
        ((p)l0).c0(0xBD5044A2);
        int v1 = (v & 6) == 0 ? (((p)l0).i(a0) ? 4 : 2) | v : v;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            c1.D(d.c(d.v(n.a, null, 3), 1.0f), 0.0f, a0, b.d, ((p)l0), v1 << 6 & 0x380 | 0xC06);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new x0(v, 6, a0);
        }
    }

    public static final void b(q q0, boolean z, String s, String s1, boolean z1, a a0, String s2, l l0, int v, int v1) {
        boolean z7;
        boolean z3;
        kotlin.jvm.internal.q.g(s, "title1");
        kotlin.jvm.internal.q.g(s1, "title2");
        p p0 = (p)l0;
        p0.c0(0x5CF8FC84);
        int v2 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.h(z) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.g(s) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v2 |= (p0.g(s1) ? 0x800 : 0x400);
        }
        if((v1 & 16) != 0) {
            v2 |= 0x6000;
        }
        else if((v & 0x6000) == 0) {
            v2 |= (p0.h(z1) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v) == 0) {
            v2 |= (p0.i(a0) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v) == 0) {
            v2 |= (p0.g(s2) ? 0x100000 : 0x80000);
        }
        if(p0.Q(v2 & 1, (0x92493 & v2) != 0x92492)) {
            boolean z2 = (v1 & 16) == 0 ? z1 : false;
            V v3 = androidx.compose.runtime.k.a;
            if(z) {
                p0.a0(0x52D5DA36);
                q q1 = r0.a.a(d.c(q0, 1.0f), new N(e.Y(p0, 0x7F130B3B), a0, 2));  // string:talkback_go_to_full_player "전체플레이어로 이동"
                g g0 = p0.N();
                if((v2 & 0x380000) == 0x100000 || g0 == v3) {
                    g0 = new g(s2, 2);
                    p0.l0(g0);
                }
                q q2 = X0.n.c(q1, true, g0);
                M m0 = M.p.d(r0.d.a, false);
                int v4 = p0.P;
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
                w.x(p0, m0, j.f);
                w.x(p0, i00, j.e);
                h h0 = j.g;
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                    A7.d.q(v4, p0, v4, h0);
                }
                w.x(p0, q3, j.d);
                sd.j j0 = p0.N();
                if(j0 == v3) {
                    j0 = new sd.j(0);
                    p0.l0(j0);
                }
                q q4 = X0.n.b(n.a, j0);
                N1.b(s, (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q4, r0.d.d), e0.T(p0, 0x7F060160), 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v2 >> 6 & 14 | 0xC00, 0xC30, 0x1D7F0);  // color:gray600s_support_high_contrast
                p0.p(true);
                p0.p(false);
                z3 = z2;
            }
            else {
                p0.a0(1390640906);
                q q5 = r0.a.a(d.c(q0, 1.0f), new N(e.Y(p0, 0x7F130B3B), a0, 3));  // string:talkback_go_to_full_player "전체플레이어로 이동"
                com.iloen.melon.playback.playlist.db.d d0 = p0.N();
                if((v2 & 0x380000) == 0x100000 || d0 == v3) {
                    d0 = new com.iloen.melon.playback.playlist.db.d(s2, 26);
                    p0.l0(d0);
                }
                q q6 = X0.n.c(q5, true, d0);
                p0.a0(-1003410150);
                p0.a0(212064437);
                p0.p(false);
                c c0 = (c)p0.k(k0.h);
                x1.q q7 = p0.N();
                if(q7 == v3) {
                    q7 = l1.w(c0, p0);
                }
                x1.j j1 = p0.N();
                if(j1 == v3) {
                    j1 = l1.u(p0);
                }
                b0 b00 = p0.N();
                if(b00 == v3) {
                    b00 = w.s(Boolean.FALSE);
                    p0.l0(b00);
                }
                m m1 = p0.N();
                if(m1 == v3) {
                    m1 = l1.v(j1, p0);
                }
                b0 b01 = p0.N();
                if(b01 == v3) {
                    b01 = w.r(H.a, V.c);
                    p0.l0(b01);
                }
                boolean z4 = p0.i(q7);
                boolean z5 = p0.e(0x101);
                g1 g10 = p0.N();
                if(z4 || z5 || g10 == v3) {
                    g10 = new g1(b01, q7, m1, 14, b00);
                    p0.l0(g10);
                }
                h1 h10 = p0.N();
                if(h10 == v3) {
                    h10 = new h1(b00, m1, 14);
                    p0.l0(h10);
                }
                boolean z6 = p0.i(q7);
                i1 i10 = p0.N();
                if(z6 || i10 == v3) {
                    i10 = new i1(q7, 14);
                    p0.l0(i10);
                }
                z3 = z2;
                g0.a(X0.n.c(q6, false, i10), m0.c.e(1200550679, p0, new sd.k(b01, j1, h10, z3, s, s1)), g10, p0, 0x30);
                p0.p(false);
                p0.p(false);
            }
            z7 = z3;
        }
        else {
            p0.T();
            z7 = z1;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new sd.d(q0, z, s, s1, z7, a0, s2, v, v1);
        }
    }

    public static final void c(P p0, l l0, int v) {
        kotlin.jvm.internal.q.g(p0, "viewModel");
        x x0 = p0.t;
        sd.c c0 = p0.q;
        x x1 = p0.p;
        x x2 = p0.r;
        x x3 = p0.m;
        p p1 = (p)l0;
        p1.c0(0xBFF5E000);
        int v1 = (p1.i(p0) ? 4 : 2) | v;
        if(p1.Q(v1 & 1, (v1 & 3) != 2)) {
            b0 b00 = B.a.r(p0.i, p1, 0);
            b0 b01 = B.a.r(p0.j, p1, 0);
            p0 p00 = M.n0.a(M.j.a, r0.d.j, p1, 0);
            int v2 = p1.P;
            i0 i00 = p1.m();
            q q0 = r0.a.d(p1, n.a);
            P0.k.y.getClass();
            i i0 = j.b;
            p1.e0();
            if(p1.O) {
                p1.l(i0);
            }
            else {
                p1.o0();
            }
            w.x(p1, p00, j.f);
            w.x(p1, i00, j.e);
            h h0 = j.g;
            if(p1.O || !kotlin.jvm.internal.q.b(p1.N(), v2)) {
                A7.d.q(v2, p1, v2, h0);
            }
            w.x(p1, q0, j.d);
            sd.w w0 = (sd.w)b00.getValue();
            if(w0 instanceof s) {
                p1.a0(622476009);
                o.d(((s)w0), ((A)b01.getValue()).a, ((A)b01.getValue()).b, x3, x2, p0.n, p0.o, x1, c0, p0.s, p1, 0);
            }
            else if(w0 instanceof v) {
                p1.a0(0x25269D63);
                o.k(((v)w0), ((A)b01.getValue()).a, ((A)b01.getValue()).b, x3, x2, x1, c0, x0, p1, 0);
            }
            else if(w0 instanceof u) {
                p1.a0(0x2530B397);
                o.e(((u)w0), ((A)b01.getValue()).a, ((A)b01.getValue()).b, x3, x2, x0, p1, 0);
            }
            else {
                p1.a0(0x2537D3FD);
            }
            p1.p(false);
            p1.p(true);
        }
        else {
            p1.T();
        }
        n0 n00 = p1.t();
        if(n00 != null) {
            n00.d = new sd.c(p0, v);
        }
    }

    public static final void d(s s0, long v, long v1, a a0, a a1, a a2, we.n n0, a a3, we.n n1, a a4, l l0, int v2) {
        String s1;
        p p0 = (p)l0;
        p0.c0(0xB071FCE9);
        int v3 = v2 | (p0.g(s0) ? 4 : 2) | (p0.f(v) ? 0x20 : 16) | (p0.f(v1) ? 0x100 : 0x80) | (p0.i(a0) ? 0x800 : 0x400) | (p0.i(a1) ? 0x4000 : 0x2000) | (p0.i(a2) ? 0x20000 : 0x10000) | (p0.i(n0) ? 0x100000 : 0x80000) | (p0.i(a3) ? 0x800000 : 0x400000) | (p0.i(n1) ? 0x4000000 : 0x2000000) | (p0.i(a4) ? 0x20000000 : 0x10000000);
        if(p0.Q(v3 & 1, (v3 & 306783379) != 306783378)) {
            n n2 = n.a;
            q q0 = androidx.compose.foundation.q.f(d.h(d.f(n2, 1.0f), E9.h.t(p0, 0x7F070055)), e0.T(p0, 0x7F0604AA), y0.M.a);  // dimen:bottom_container_height
            M m0 = M.p.d(r0.d.a, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            r0.i i0 = r0.d.a;
            i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            w.x(p0, m0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            h h3 = j.d;
            w.x(p0, q1, h3);
            q q2 = androidx.compose.foundation.layout.a.n(d.c, 0.0f, 2.0f, 0.0f, 0.0f, 13);
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v5 = p0.P;
            i0 i01 = p0.m();
            q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            w.x(p0, q3, h3);
            M.c.d(p0, d.q(n2, 20.0f));
            o.b(new LayoutWeightElement(1.0f, true), s0.a, s0.b, s0.c, s0.f, a0, s0.d, p0, v3 << 6 & 0x70000, 0);
            M.c.d(p0, d.t(d.q(n2, 10.0f), 3));
            o.j(!s0.a, 0L, a2, n0, p0, v3 >> 9 & 0x1F80);
            o.h(!s0.a, s0.e, a1, p0, v3 >> 6 & 0x380);
            o.g(!s0.a, 0L, a3, n1, p0, v3 >> 15 & 0x1F80);
            o.i(a4, p0, v3 >> 27 & 14);
            p0.p(true);
            if(s0.a) {
                s1 = l1.h(p0, 0x13A27AB0, 0x7F130C3E, p0, false);  // string:talkback_seekbar_track_invalid "트랙위치 없음"
            }
            else {
                p0.a0(0x13A0013F);
                s1 = TalkbackUtilKt.getPlayProgressTalkbackInfo(((Context)p0.k(AndroidCompositionLocals_androidKt.b)), v1, v);
                p0.p(false);
            }
            q q4 = d.h(d.f(n2, 1.0f), 10.0f);
            boolean z = p0.g(s1);
            com.iloen.melon.playback.playlist.db.d d0 = p0.N();
            if(z || d0 == androidx.compose.runtime.k.a) {
                d0 = new com.iloen.melon.playback.playlist.db.d(s1, 29);
                p0.l0(d0);
            }
            q q5 = X0.n.c(q4, true, d0);
            M m1 = M.p.d(i0, false);
            int v6 = p0.P;
            i0 i02 = p0.m();
            q q6 = r0.a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, m1, h0);
            w.x(p0, i02, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            w.x(p0, q6, h3);
            c1.F(d.h(d.f(n2, 1.0f), E9.h.t(p0, 0x7F070316)), v1, v, 0L, 0L, p0, v3 >> 3 & 0x70 | v3 << 3 & 0x380, 24);  // dimen:mini_player_progress_height
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new f(s0, v, v1, a0, a1, a2, n0, a3, n1, a4, v2);
        }
    }

    public static final void e(u u0, long v, long v1, a a0, a a1, a a2, l l0, int v2) {
        String s;
        long v7;
        long v6;
        r0.i i2;
        p p0 = (p)l0;
        p0.c0(2091274680);
        int v3 = v2 | (p0.g(u0) ? 4 : 2) | (p0.f(v) ? 0x20 : 16) | (p0.f(v1) ? 0x100 : 0x80) | (p0.i(a0) ? 0x800 : 0x400) | (p0.i(a1) ? 0x4000 : 0x2000) | (p0.i(a2) ? 0x20000 : 0x10000);
        if(p0.Q(v3 & 1, (v3 & 74899) != 74898)) {
            n n0 = n.a;
            q q0 = androidx.compose.foundation.q.f(d.h(d.f(n0, 1.0f), E9.h.t(p0, 0x7F070055)), e0.T(p0, 0x7F0604AA), y0.M.a);  // dimen:bottom_container_height
            r0.i i0 = r0.d.a;
            M m0 = M.p.d(i0, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            w.x(p0, m0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O) {
                i2 = i0;
                A7.d.q(v4, p0, v4, h2);
            }
            else {
                i2 = i0;
                if(!kotlin.jvm.internal.q.b(p0.N(), v4)) {
                    A7.d.q(v4, p0, v4, h2);
                }
            }
            h h3 = j.d;
            w.x(p0, q1, h3);
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v5 = p0.P;
            i0 i01 = p0.m();
            q q2 = r0.a.d(p0, d.c);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            w.x(p0, q2, h3);
            q q3 = r0.a.a(n0, new N(l1.s(n0, 20.0f, p0, 0x7F130B3B, p0), a0, 4));  // string:talkback_go_to_full_player "전체플레이어로 이동"
            boolean z = u0.a;
            T.d d0 = Tf.v.j0(u0.c, "circle", true) ? T.e.a : T.e.b(4.0f);
            o.f(q3, u0.b, u0.d, u0.e, d0, p0, 0);
            M.c.d(p0, d.q(n0, 10.0f));
            o.b(new LayoutWeightElement(1.0f, true), u0.a, u0.f, u0.g, false, a0, u0.h, p0, v3 << 6 & 0x70000, 16);
            M.c.d(p0, d.t(d.q(n0, 10.0f), 3));
            o.h(!z, u0.i, a1, p0, v3 >> 6 & 0x380);
            o.a(a2, p0, v3 >> 15 & 14);
            p0.p(true);
            if(u0.i) {
                v6 = v;
                v7 = v1;
            }
            else {
                v7 = 0x7FFFFFFFFFFFFFFFL;
                v6 = 0L;
            }
            if(z) {
                s = l1.h(p0, 0x964BBF41, 0x7F130C3E, p0, false);  // string:talkback_seekbar_track_invalid "트랙위치 없음"
            }
            else {
                p0.a0(0x9648FE7D);
                s = TalkbackUtilKt.getPlayProgressTalkbackInfo(((Context)p0.k(AndroidCompositionLocals_androidKt.b)), v7, v6);
                p0.p(false);
            }
            q q4 = d.h(d.f(n0, 1.0f), 10.0f);
            boolean z1 = p0.g(s);
            g g0 = p0.N();
            if(z1 || g0 == androidx.compose.runtime.k.a) {
                g0 = new g(s, 1);
                p0.l0(g0);
            }
            q q5 = X0.n.c(q4, true, g0);
            M m1 = M.p.d(i2, false);
            int v8 = p0.P;
            i0 i02 = p0.m();
            q q6 = r0.a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, m1, h0);
            w.x(p0, i02, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v8)) {
                A7.d.q(v8, p0, v8, h2);
            }
            w.x(p0, q6, h3);
            c1.F(d.h(d.f(n0, 1.0f), E9.h.t(p0, 0x7F070316)), v7, v6, 0L, 0L, p0, 0, 24);  // dimen:mini_player_progress_height
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new sd.i(u0, v, v1, a0, a1, a2, v2);
        }
    }

    public static final void f(q q0, String s, String s1, String s2, Q q1, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x8EC000AF);
        int v1 = v | (p0.g(q0) ? 4 : 2) | (p0.g(s) ? 0x20 : 16) | (p0.g(s1) ? 0x100 : 0x80) | (p0.g(s2) ? 0x800 : 0x400) | (p0.g(q1) ? 0x4000 : 0x2000);
        if(p0.Q(v1 & 1, (v1 & 9363) != 9362)) {
            p0.V();
            if((v & 1) != 0 && !p0.B()) {
                p0.T();
            }
            p0.q();
            boolean z = p0.g(s + "-" + s1 + "-" + s2);
            String s3 = p0.N();
            if(z || s3 == androidx.compose.runtime.k.a) {
                s3 = (String)je.p.B0(o.a, Ae.f.a);
                p0.l0(s3);
            }
            r0.i i0 = r0.d.a;
            M m0 = M.p.d(i0, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q2 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            w.x(p0, m0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = j.d;
            w.x(p0, q2, h3);
            n n0 = n.a;
            q q3 = d.n(n0, 35.0f);
            M m1 = M.p.d(i0, false);
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
            w.x(p0, m1, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            w.x(p0, q4, h3);
            q q5 = androidx.compose.foundation.q.f(d5.n.o(d.n(n0, 30.0f), q1), y0.M.c(Color.parseColor(s3)), y0.M.a);
            M.p.a((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q5, r0.d.i), p0, 0);
            q q6 = androidx.compose.foundation.q.f(d5.n.o(d.n(n0, 30.0f), q1), e0.T(p0, 0x7F060145), y0.M.a);  // color:gray050s
            c1.n(androidx.compose.foundation.q.i(0.5f, e0.T(p0, 0x7F06014A), q6, q1), s, null, N0.j.b, true, 0x7F080796, null, null, null, 0.0f, null, 0, 0, false, false, p0, v1 & 0x70 | 0x36C00, 0, 0x7FC4);  // color:gray100a
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new t0(q0, s, s1, s2, q1, v);
        }
    }

    public static final void g(boolean z, long v, a a0, we.n n0, l l0, int v1) {
        long v5;
        p p0 = (p)l0;
        p0.c0(0x507E1965);
        int v2 = (v1 & 6) == 0 ? (p0.h(z) ? 4 : 2) | v1 : v1;
        int v3 = (v1 & 0x180) == 0 ? v2 | 0x30 | (p0.i(a0) ? 0x100 : 0x80) : v2 | 0x30;
        if((v1 & 0xC00) == 0) {
            v3 |= (p0.i(n0) ? 0x800 : 0x400);
        }
        if(p0.Q(v3 & 1, (v3 & 0x493) != 1170)) {
            String s = e.Y(p0, 0x7F130BD0);  // string:talkback_player_next "다음곡"
            n n1 = n.a;
            if(z) {
                p0.a0(0x252296D);
                c1.K(d.c(d.q(n1, 40.0f), 1.0f), a0, n0, 0xFAL, 0.0f, s, e.Y(p0, 0x7F130BC1), e.Y(p0, 0x7F130BC9), b.b, p0, v3 >> 3 & 0x380 | (v3 >> 3 & 0x70 | 0x6000006) | v3 << 6 & 0x1C00, 16);  // string:talkback_player_change_to_next "다음곡으로 변경"
            }
            else {
                p0.a0(39750507);
                q q0 = r0.a.a(d.c(d.q(n1, 40.0f), 1.0f), new D(24, a0));
                boolean z1 = p0.g(s);
                com.iloen.melon.playback.playlist.db.d d0 = p0.N();
                if(z1 || d0 == androidx.compose.runtime.k.a) {
                    d0 = new com.iloen.melon.playback.playlist.db.d(s, 28);
                    p0.l0(d0);
                }
                q q1 = X0.n.c(q0, true, d0);
                M m0 = M.p.d(r0.d.a, false);
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
                w.x(p0, m0, j.f);
                w.x(p0, i00, j.e);
                h h0 = j.g;
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                    A7.d.q(v4, p0, v4, h0);
                }
                w.x(p0, q2, j.d);
                q q3 = d.n(n1, 28.0f);
                c1.n((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q3, r0.d.e), 0x7F080216, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 25008, 0, 0x7FE8);  // drawable:btn_miniplayer_next
                p0.p(true);
            }
            p0.p(false);
            v5 = 0xFAL;
        }
        else {
            p0.T();
            v5 = v;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new sd.e(z, v5, a0, n0, v1, 1);
        }
    }

    public static final void h(boolean z, boolean z1, a a0, l l0, int v) {
        int v3;
        int v2;
        p p0 = (p)l0;
        p0.c0(0xE05E3684);
        int v1 = (v & 6) == 0 ? (p0.h(z) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.h(z1) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (p0.i(a0) ? 0x100 : 0x80);
        }
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            if(z1) {
                v2 = -206657717;
                v3 = 0x7F1307DE;  // string:pause "일시정지"
            }
            else {
                v2 = -206601204;
                v3 = 0x7F130808;  // string:play "재생"
            }
            String s = l1.h(p0, v2, v3, p0, false);
            n n0 = n.a;
            q q0 = r0.a.a(r0.a.a(d.c(d.q(n0, 40.0f), 1.0f), new Cd.e(z, a0, 2)), new D(25, a0));
            boolean z2 = p0.g(s);
            Ld.x x0 = p0.N();
            if((v1 & 14) == 4 || z2 || x0 == androidx.compose.runtime.k.a) {
                x0 = new Ld.x(z, s);
                p0.l0(x0);
            }
            q q1 = X0.n.c(q0, false, x0);
            M m0 = M.p.d(r0.d.a, false);
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
            w.x(p0, m0, j.f);
            w.x(p0, i00, j.e);
            h h0 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            w.x(p0, q2, j.d);
            q q3 = d.n(n0, 28.0f);
            c1.n((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q3, r0.d.e), ((int)(z1 ? 0x7F080217 : 0x7F080218)), null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x6180, 0, 0x7FE8);  // drawable:btn_miniplayer_pause
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new qd.b(z, z1, a0, v);
        }
    }

    public static final void i(a a0, l l0, int v) {
        ((p)l0).c0(0x3A11D018);
        int v1 = (v & 6) == 0 ? (((p)l0).i(a0) ? 4 : 2) | v : v;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            c1.D(d.c(d.v(n.a, null, 3), 1.0f), 0.0f, a0, b.c, ((p)l0), v1 << 6 & 0x380 | 0xC06);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new x0(v, 5, a0);
        }
    }

    public static final void j(boolean z, long v, a a0, we.n n0, l l0, int v1) {
        long v5;
        p p0 = (p)l0;
        p0.c0(0x20627A25);
        int v2 = (v1 & 6) == 0 ? (p0.h(z) ? 4 : 2) | v1 : v1;
        int v3 = (v1 & 0x180) == 0 ? v2 | 0x30 | (p0.i(a0) ? 0x100 : 0x80) : v2 | 0x30;
        if((v1 & 0xC00) == 0) {
            v3 |= (p0.i(n0) ? 0x800 : 0x400);
        }
        if(p0.Q(v3 & 1, (v3 & 0x493) != 1170)) {
            String s = e.Y(p0, 0x7F130BD4);  // string:talkback_player_prev "이전곡"
            n n1 = n.a;
            if(z) {
                p0.a0(0xA3E90FF3);
                c1.K(d.c(d.q(n1, 40.0f), 1.0f), a0, n0, 0xFAL, 0.0f, s, e.Y(p0, 0x7F130BC2), e.Y(p0, 0x7F130BD8), b.a, p0, v3 >> 3 & 0x380 | (v3 >> 3 & 0x70 | 0x6000006) | v3 << 6 & 0x1C00, 16);  // string:talkback_player_change_to_prev "이전곡으로 변경"
            }
            else {
                p0.a0(0xA3F55B6B);
                q q0 = r0.a.a(d.c(d.q(n1, 40.0f), 1.0f), new D(26, a0));
                boolean z1 = p0.g(s);
                com.iloen.melon.playback.playlist.db.d d0 = p0.N();
                if(z1 || d0 == androidx.compose.runtime.k.a) {
                    d0 = new com.iloen.melon.playback.playlist.db.d(s, 27);
                    p0.l0(d0);
                }
                q q1 = X0.n.c(q0, true, d0);
                M m0 = M.p.d(r0.d.a, false);
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
                w.x(p0, m0, j.f);
                w.x(p0, i00, j.e);
                h h0 = j.g;
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                    A7.d.q(v4, p0, v4, h0);
                }
                w.x(p0, q2, j.d);
                q q3 = d.n(n1, 28.0f);
                c1.n((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q3, r0.d.e), 0x7F080215, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 25008, 0, 0x7FE8);  // drawable:btn_miniplayer_back
                p0.p(true);
            }
            p0.p(false);
            v5 = 0xFAL;
        }
        else {
            p0.T();
            v5 = v;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new sd.e(z, v5, a0, n0, v1, 0);
        }
    }

    public static final void k(v v0, long v1, long v2, a a0, a a1, a a2, we.n n0, a a3, l l0, int v3) {
        String s;
        r0.i i2;
        p p0 = (p)l0;
        p0.c0(0x449F7AE6);
        int v4 = v3 | (p0.g(v0) ? 4 : 2) | (p0.f(v1) ? 0x20 : 16) | (p0.f(v2) ? 0x100 : 0x80) | (p0.i(a0) ? 0x800 : 0x400) | (p0.i(a1) ? 0x4000 : 0x2000) | (p0.i(a2) ? 0x20000 : 0x10000) | (p0.i(n0) ? 0x100000 : 0x80000) | (p0.i(a3) ? 0x800000 : 0x400000);
        if(p0.Q(v4 & 1, (0x492493 & v4) != 4793490)) {
            n n1 = n.a;
            q q0 = androidx.compose.foundation.q.f(d.h(d.f(n1, 1.0f), E9.h.t(p0, 0x7F070055)), e0.T(p0, 0x7F0604AA), y0.M.a);  // dimen:bottom_container_height
            r0.i i0 = r0.d.a;
            M m0 = M.p.d(i0, false);
            int v5 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            w.x(p0, m0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O) {
                i2 = i0;
                A7.d.q(v5, p0, v5, h2);
            }
            else {
                i2 = i0;
                if(!kotlin.jvm.internal.q.b(p0.N(), v5)) {
                    A7.d.q(v5, p0, v5, h2);
                }
            }
            h h3 = j.d;
            w.x(p0, q1, h3);
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v6 = p0.P;
            i0 i01 = p0.m();
            q q2 = r0.a.d(p0, d.c);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            w.x(p0, q2, h3);
            M.c.d(p0, d.q(n1, 21.0f));
            o.b(new LayoutWeightElement(1.0f, true), v0.a, v0.b, v0.c, false, a0, v0.d, p0, v4 << 6 & 0x70000, 16);
            M.c.d(p0, d.t(d.q(n1, 10.0f), 3));
            o.h(!v0.a, v0.e, a1, p0, v4 >> 6 & 0x380);
            o.g(!v0.a, 0L, a2, n0, p0, v4 >> 9 & 0x1F80);
            o.a(a3, p0, v4 >> 21 & 14);
            p0.p(true);
            if(v0.a) {
                s = l1.h(p0, 0xB94C8353, 0x7F130C3E, p0, false);  // string:talkback_seekbar_track_invalid "트랙위치 없음"
            }
            else {
                p0.a0(0xB94A0DA3);
                s = TalkbackUtilKt.getPlayProgressTalkbackInfo(((Context)p0.k(AndroidCompositionLocals_androidKt.b)), v2, v1);
                p0.p(false);
            }
            q q3 = d.h(d.f(n1, 1.0f), 10.0f);
            boolean z = p0.g(s);
            g g0 = p0.N();
            if(z || g0 == androidx.compose.runtime.k.a) {
                g0 = new g(s, 0);
                p0.l0(g0);
            }
            q q4 = X0.n.c(q3, true, g0);
            M m1 = M.p.d(i2, false);
            int v7 = p0.P;
            i0 i02 = p0.m();
            q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, m1, h0);
            w.x(p0, i02, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h2);
            }
            w.x(p0, q5, h3);
            c1.F(d.h(d.f(n1, 1.0f), E9.h.t(p0, 0x7F070316)), v2, v1, 0L, 0L, p0, v4 >> 3 & 0x70 | v4 << 3 & 0x380, 24);  // dimen:mini_player_progress_height
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new sd.h(v0, v1, v2, a0, a1, a2, n0, a3, v3);
        }
    }
}

