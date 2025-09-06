package ud;

import Ac.R0;
import Ac.Y1;
import Ac.g1;
import Ac.h1;
import Ac.i1;
import Cc.K0;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import Cc.w0;
import Cc.x0;
import H0.e;
import M.B0;
import M.p0;
import M.y;
import M.z;
import N0.M;
import N0.g0;
import P0.h;
import P0.i;
import Q0.k0;
import U4.x;
import U8.F;
import android.content.Context;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.runtime.I0;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.Z;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import b0.N;
import com.iloen.melon.custom.l1;
import com.iloen.melon.player.playlist.common.f;
import com.iloen.melon.utils.StringUtils;
import ed.D;
import ie.H;
import jd.Z0;
import r0.d;
import r0.n;
import r0.q;
import r1.c;
import rd.v;
import sd.g;
import we.a;
import x1.j;
import x1.m;

public abstract class u {
    public static final void a(a a0, l l0, int v) {
        ((p)l0).c0(0xE0388A54);
        int v1 = (v & 6) == 0 ? (((p)l0).i(a0) ? 4 : 2) | v : v;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            D d0 = new D(28, a0);
            c1.n(r0.a.a(n.a, d0), 0x7F0800F7, e.Y(((p)l0), 0x7F1301BB), null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((p)l0), 0x30, 0, 0x7FF8);  // drawable:btn_audio_player_down
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new x0(v, 7, a0);
        }
    }

    public static final void b(q q0, boolean z, a a0, we.n n0, a a1, a a2, a a3, a a4, we.n n1, l l0, int v) {
        b0 b02;
        m m1;
        j j1;
        p p0 = (p)l0;
        p0.c0(-1574001761);
        int v1 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.h(z) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (p0.i(a0) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v1 |= (p0.i(n0) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v1 |= (p0.i(a1) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v) == 0) {
            v1 |= (p0.i(a2) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v) == 0) {
            v1 |= (p0.i(a3) ? 0x100000 : 0x80000);
        }
        if((0xC00000 & v) == 0) {
            v1 |= (p0.i(a4) ? 0x800000 : 0x400000);
        }
        if((0x6000000 & v) == 0) {
            v1 |= (p0.i(n1) ? 0x4000000 : 0x2000000);
        }
        if(p0.Q(v1 & 1, (0x2492493 & v1) != 0x2492492)) {
            p0.a0(-1003410150);
            p0.a0(212064437);
            p0.p(false);
            c c0 = (c)p0.k(k0.h);
            x1.q q1 = p0.N();
            V v2 = k.a;
            if(q1 == v2) {
                q1 = l1.w(c0, p0);
            }
            j j0 = p0.N();
            if(j0 == v2) {
                j0 = l1.u(p0);
            }
            b0 b00 = p0.N();
            if(b00 == v2) {
                b00 = w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            m m0 = p0.N();
            if(m0 == v2) {
                m0 = l1.v(j0, p0);
            }
            b0 b01 = p0.N();
            if(b01 == v2) {
                b01 = w.r(H.a, V.c);
                p0.l0(b01);
            }
            boolean z1 = p0.i(q1);
            boolean z2 = p0.e(0x101);
            g1 g10 = p0.N();
            if(z1 || z2 || g10 == v2) {
                g10 = new g1(b01, q1, m0, 19, b00);
                b02 = b00;
                j1 = j0;
                m1 = m0;
                p0.l0(g10);
            }
            else {
                j1 = j0;
                m1 = m0;
                b02 = b00;
            }
            h1 h10 = p0.N();
            if(h10 == v2) {
                h10 = new h1(b02, m1, 19);
                p0.l0(h10);
            }
            boolean z3 = p0.i(q1);
            i1 i10 = p0.N();
            if(z3 || i10 == v2) {
                i10 = new i1(q1, 19);
                p0.l0(i10);
            }
            g0.a(X0.n.c(q0, false, i10), m0.c.e(1200550679, p0, new v(b01, j1, h10, a0, n0, z, a4, n1, a1, a2, a3)), g10, p0, 0x30);
            p0.p(false);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new ud.k(q0, z, a0, n0, a1, a2, a3, a4, n1, v);
        }
    }

    public static final void c(a a0, l l0, int v) {
        ((p)l0).c0(0x7A4970FB);
        int v1 = (v & 6) == 0 ? (((p)l0).i(a0) ? 4 : 2) | v : v;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            s s0 = new s(2, a0);
            c1.n(r0.a.a(n.a, s0), 0x7F0800FA, e.Y(((p)l0), 0x7F130266), null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((p)l0), 0x30, 0, 0x7FF8);  // drawable:btn_audio_player_more
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new x0(v, 8, a0);
        }
    }

    public static final void d(q q0, a a0, l l0, int v) {
        ((p)l0).c0(-190964345);
        int v1 = (v & 6) == 0 ? (((p)l0).g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((p)l0).i(a0) ? 0x20 : 16);
        }
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            String s = e.Y(((p)l0), 0x7F13104A);  // string:title_playlist "플레이리스트"
            c1.n(r0.a.a(q0, new s(3, a0)), 0x7F0800FB, s, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((p)l0), 0x30, 0, 0x7FF8);  // drawable:btn_audio_player_playlist
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new qd.j(q0, a0, v, 2);
        }
    }

    public static final void e(q q0, long v, long v1, K.l l0, we.k k0, l l1, int v2) {
        String s1;
        h h5;
        h h4;
        i i1;
        p p0 = (p)l1;
        p0.c0(-1154163805);
        int v3 = (v2 & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v2 : v2;
        if((v2 & 0x30) == 0) {
            v3 |= (p0.f(v) ? 0x20 : 16);
        }
        if((v2 & 0x180) == 0) {
            v3 |= (p0.f(v1) ? 0x100 : 0x80);
        }
        if((v2 & 0xC00) == 0) {
            v3 |= (p0.g(l0) ? 0x800 : 0x400);
        }
        if((v2 & 0x6000) == 0) {
            v3 |= (p0.i(k0) ? 0x4000 : 0x2000);
        }
        if(p0.Q(v3 & 1, (v3 & 9363) != 9362)) {
            y y0 = M.w.a(M.j.d, d.m, p0, 6);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            w.x(p0, y0, h0);
            h h1 = P0.j.e;
            w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            h h3 = P0.j.d;
            w.x(p0, q1, h3);
            b0 b00 = x1.a.n(l0, p0, v3 >> 9 & 14);
            float f = ((float)v) / ((float)v1);
            Z z0 = p0.N();
            V v5 = k.a;
            if(z0 == v5) {
                z0 = w.o(f);
                p0.l0(z0);
            }
            n n0 = n.a;
            q q2 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 24.0f);
            M m0 = M.p.d(d.a, false);
            int v6 = p0.P;
            i0 i01 = p0.m();
            q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            w.x(p0, q3, h3);
            String s = e.Y(p0, 0x7F130C3F);  // string:talkback_seekbar_tracklocation "트랙위치,"
            float f1 = ((Boolean)b00.getValue()).booleanValue() ? ((I0)z0).m() : f;
            q q4 = androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n0, 1.0f), 3), 8.0f, 0.0f, 2);
            boolean z1 = p0.g(s);
            g g0 = p0.N();
            if(z1 || g0 == v5) {
                g0 = new g(s, 4);
                p0.l0(g0);
            }
            q q5 = X0.n.c(q4, false, g0);
            ud.l l2 = p0.N();
            if(l2 == v5) {
                l2 = new ud.l(z0, 0);
                p0.l0(l2);
            }
            ud.m m1 = p0.N();
            if((((v3 & 0x380) == 0x100 ? 1 : 0) | ((v3 & 0xE000) == 0x4000 ? 1 : 0)) != 0 || m1 == v5) {
                i1 = i0;
                h4 = h1;
                h5 = h2;
                m1 = new ud.m(v1, k0, z0);
                p0.l0(m1);
            }
            else {
                i1 = i0;
                h4 = h1;
                h5 = h2;
            }
            N.a(f1, l2, q5, false, m1, null, l0, m0.c.e(-940674725, p0, new Bd.e(b00, 25)), ud.a.a, null, p0, 0x380000 & v3 << 9 | 0x36000030);
            p0.p(true);
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            long v7 = ((Boolean)b00.getValue()).booleanValue() ? ((long)(((I0)z0).m() * ((float)v1))) : v;
            if(((int)v7) == 0) {
                s1 = l1.h(p0, -83000082, 0x7F130847, p0, false);  // string:playtime_0 "0:00"
            }
            else {
                p0.a0(0xFB0E81E5);
                p0.p(false);
                s1 = StringUtils.INSTANCE.formatPlayerTime(v7);
            }
            String s2 = StringUtils.INSTANCE.formatPlayerDurationTime(v1);
            int v8 = ((Boolean)b00.getValue()).booleanValue() ? 22 : 11;
            q q6 = androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n0, 1.0f), 3), 20.0f, 0.0f, 2);
            boolean z2 = p0.i(context0);
            boolean z3 = p0.f(v7);
            ud.n n1 = p0.N();
            if((z2 | (v3 & 0x380) == 0x100 | z3) != 0 || n1 == v5) {
                ud.n n2 = new ud.n(context0, v1, v7);
                p0.l0(n2);
                n1 = n2;
            }
            q q7 = X0.n.b(q6, n1);
            p0 p00 = M.n0.a(M.j.g, d.j, p0, 6);
            int v9 = p0.P;
            i0 i02 = p0.m();
            q q8 = r0.a.d(p0, q7);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i02, h4);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v9)) {
                A7.d.q(v9, p0, v9, h5);
            }
            w.x(p0, q8, h3);
            N1.b(s1, null, e0.T(p0, 0x7F0604A0), ((float)v8), null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFF2);  // color:white
            N1.b(s2, null, e0.T(p0, 0x7F0604C0), ((float)v8), null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFF2);  // color:white_60
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new o(q0, v, v1, l0, k0, v2);
        }
    }

    public static final void f(q q0, String s, boolean z, String s1, String s2, d9.h h0, l l0, int v) {
        b0 b02;
        t t0;
        p p0 = (p)l0;
        p0.c0(0xE574C087);
        int v1 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.g(s) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (p0.h(z) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v1 |= (p0.g(s1) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v1 |= (p0.g(s2) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v) == 0) {
            v1 |= (p0.i(h0) ? 0x20000 : 0x10000);
        }
        if(p0.Q(v1 & 1, (74899 & v1) != 74898)) {
            b0 b00 = p0.N();
            V v2 = k.a;
            if(b00 == v2) {
                b00 = w.s(Boolean.TRUE);
                p0.l0(b00);
            }
            b0 b01 = p0.N();
            if(b01 == v2) {
                b01 = w.s(Boolean.FALSE);
                p0.l0(b01);
            }
            Object object0 = p0.N();
            if((((v1 & 0x70) == 0x20 ? 1 : 0) | ((v1 & 0x380) == 0x100 ? 1 : 0)) != 0 || object0 == v2) {
                b02 = b01;
                t0 = new t(s, z, b00, b02, null);
                p0.l0(t0);
            }
            else {
                t0 = object0;
                b02 = b01;
            }
            J.d(p0, s, t0);
            M m0 = M.p.d(d.a, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h1 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h1);
            }
            w.x(p0, q1, P0.j.d);
            if(((Boolean)b02.getValue()).booleanValue()) {
                p0.a0(0x9D158896);
                FillElement fillElement0 = androidx.compose.foundation.layout.d.c;
                F f1 = p0.N();
                if(f1 == v2) {
                    f1 = new F(b02, 12);
                    p0.l0(f1);
                }
                ud.a.e(fillElement0, h0, f1, p0, v1 >> 12 & 0x70 | 390);
            }
            else {
                p0.a0(0x9D100255);
                q q2 = (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(androidx.compose.foundation.layout.d.c, d.d);
                F f0 = p0.N();
                if(f0 == v2) {
                    f0 = new F(b02, 11);
                    p0.l0(f0);
                }
                u.l(q2, s1, s2, f0, p0, v1 >> 6 & 0x70 | 0xC00 | v1 >> 6 & 0x380);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new ed.n(q0, s, z, s1, s2, h0, v);
        }
    }

    public static final void g(b0 b00, boolean z) {
        b00.setValue(Boolean.valueOf(z));
    }

    public static final void h(boolean z, a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(1087285801);
        int v1 = (v & 6) == 0 ? (p0.h(z) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(a0) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            n n0 = n.a;
            q q0 = r0.a.a(androidx.compose.foundation.layout.d.n(n0, 40.0f), new s(4, a0));
            M m0 = M.p.d(d.a, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, P0.j.d);
            String s = e.Y(p0, 0x7F130212);  // string:comments "댓글"
            c1.n(androidx.compose.foundation.layout.d.c, 0x7F0800F6, s, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 54, 0, 0x7FF8);  // drawable:btn_audio_player_comment
            if(z) {
                p0.a0(0xCDE052E9);
                q q2 = androidx.compose.foundation.layout.d.u(n0, 3);
                c1.n((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q2, d.c), 0x7F080307, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x1B0, 0, 0x7FF8);  // drawable:comment_new
            }
            else {
                p0.a0(0xCCCF1613);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new f(z, a0, v, 2);
        }
    }

    public static final void i(boolean z, we.k k0, l l0, int v) {
        ((p)l0).c0(-1775155580);
        int v1 = (v & 6) == 0 ? (((p)l0).h(z) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((p)l0).i(k0) ? 0x20 : 16);
        }
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            n n0 = n.a;
            if(z) {
                ((p)l0).a0(0x103F1BCB);
                String s = e.Y(((p)l0), 0x7F130B5C);  // string:talkback_like_off "좋아요 취소"
                c1.n(r0.a.a(androidx.compose.foundation.layout.d.n(n0, 40.0f), new Z0(13, k0)), 0x7F0800F9, s, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((p)l0), 0x30, 0, 0x7FF8);  // drawable:btn_audio_player_heart_on
            }
            else {
                ((p)l0).a0(0x1044548C);
                String s1 = e.Y(((p)l0), 0x7F130B5F);  // string:talkback_like_on "좋아요"
                c1.n(r0.a.a(androidx.compose.foundation.layout.d.n(n0, 40.0f), new Z0(14, k0)), 0x7F0800F8, s1, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((p)l0), 0x30, 0, 0x7FF8);  // drawable:btn_audio_player_heart_off
            }
            ((p)l0).p(false);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new K0(z, k0, v, 4);
        }
    }

    public static final void j(int v, l l0, String s, q q0) {
        p p0 = (p)l0;
        p0.c0(1382311021);
        int v1 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.g(s) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            M m0 = M.p.d(d.a, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, P0.j.d);
            FillElement fillElement0 = androidx.compose.foundation.layout.d.c;
            long v3 = e0.T(p0, 0x7F060161);  // color:gray601s
            wc.u u0 = y0.M.a;
            M.p.a(androidx.compose.foundation.q.f(fillElement0, v3, u0), p0, 0);
            sd.j j0 = p0.N();
            V v4 = k.a;
            if(j0 == v4) {
                j0 = new sd.j(6);
                p0.l0(j0);
            }
            g g0 = p0.N();
            if((v1 & 0x70) == 0x20 || g0 == v4) {
                g0 = new g(s, 5);
                p0.l0(g0);
            }
            androidx.compose.ui.viewinterop.a.a(j0, fillElement0, g0, p0, 54, 0);
            M.p.a(androidx.compose.foundation.q.f(fillElement0, e0.T(p0, 0x7F06003C), u0), p0, 0);  // color:black_40
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new w0(q0, s, v, 8);
        }
    }

    public static final void k(String s, String s1, String s2, String s3, boolean z, String s4, String s5, d9.h h0, long v, long v1, boolean z1, boolean z2, boolean z3, boolean z4, a a0, a a1, a a2, we.k k0, a a3, a a4, we.k k1, a a5, we.n n0, a a6, a a7, a a8, a a9, we.n n1, l l0, int v2) {
        r0.g g1;
        p p0 = (p)l0;
        p0.c0(0xCCC04264);
        int v3 = 16;
        int v4 = 0x80;
        int v5 = 0x400;
        int v6 = 0x2000;
        int v7 = 0x10000;
        int v8 = 0x80000;
        int v9 = 0x400000;
        int v10 = 0x2000000;
        int v11 = 0x10000000;
        int v12 = v2 | (p0.g(s) ? 4 : 2) | (p0.g(s1) ? 0x20 : 16) | (p0.g(s2) ? 0x100 : 0x80) | (p0.g(s3) ? 0x800 : 0x400) | (p0.h(z) ? 0x4000 : 0x2000) | (p0.g(s4) ? 0x20000 : 0x10000) | (p0.g(s5) ? 0x100000 : 0x80000) | (p0.i(h0) ? 0x800000 : 0x400000) | (p0.f(v) ? 0x4000000 : 0x2000000) | (p0.f(v1) ? 0x20000000 : 0x10000000);
        int v13 = p0.h(z1) ? 4 : 2;
        int v14 = p0.h(z2) ? 0x20 : 16;
        int v15 = p0.h(z3) ? 0x100 : 0x80;
        int v16 = p0.h(z4) ? 0x800 : 0x400;
        int v17 = p0.i(a0) ? 0x4000 : 0x2000;
        int v18 = p0.i(a1) ? 0x20000 : 0x10000;
        int v19 = p0.i(a2) ? 0x100000 : 0x80000;
        int v20 = p0.i(k0) ? 0x800000 : 0x400000;
        if(p0.i(a3)) {
            v10 = 0x4000000;
        }
        if(p0.i(a4)) {
            v11 = 0x20000000;
        }
        int v21 = p0.i(k1) ? 4 : 2;
        if(p0.i(a5)) {
            v3 = 0x20;
        }
        if(p0.i(n0)) {
            v4 = 0x100;
        }
        if(p0.i(a6)) {
            v5 = 0x800;
        }
        if(p0.i(a7)) {
            v6 = 0x4000;
        }
        if(p0.i(a8)) {
            v7 = 0x20000;
        }
        if(p0.i(a9)) {
            v8 = 0x100000;
        }
        if(p0.i(n1)) {
            v9 = 0x800000;
        }
        int v22 = v21 | v3 | v4 | v5 | v6 | v7 | v8 | v9;
        int v23 = v13 | v14 | v15 | v16 | v17 | v18 | v19 | v20 | v10 | v11;
        if(p0.Q(v12 & 1, (v12 & 306783379) != 306783378 || (v23 & 306783379) != 306783378 || (v22 & 0x492493) != 4793490)) {
            b0 b00 = p0.N();
            V v24 = k.a;
            if(b00 == v24) {
                b00 = w.s(new x0.e(0L));
                p0.l0(b00);
            }
            w0.p p1 = p0.N();
            if(p1 == v24) {
                p1 = new w0.p();
                p0.l0(p1);
            }
            FillElement fillElement0 = androidx.compose.foundation.layout.d.c;
            R0 r00 = p0.N();
            if(r00 == v24) {
                r00 = new R0(b00, 25);
                p0.l0(r00);
            }
            q q0 = androidx.compose.foundation.q.q(androidx.compose.ui.focus.a.a(androidx.compose.ui.layout.a.f(fillElement0, r00), p1), true, null);
            r0.i i0 = d.a;
            M m0 = M.p.d(i0, false);
            int v25 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
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
            w.x(p0, m0, h1);
            h h2 = P0.j.e;
            w.x(p0, i00, h2);
            h h3 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v25)) {
                A7.d.q(v25, p0, v25, h3);
            }
            h h4 = P0.j.d;
            w.x(p0, q1, h4);
            int v26 = v12 << 3 & 0x70;
            u.j(v26 | 6, p0, s, fillElement0);
            q q2 = r0.a.a(fillElement0, new B0(3, 1));
            M.d d0 = M.j.c;
            r0.g g0 = d.m;
            y y0 = M.w.a(d0, g0, p0, 0);
            int v27 = p0.P;
            i0 i01 = p0.m();
            q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h1);
            w.x(p0, i01, h2);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v27)) {
                A7.d.q(v27, p0, v27, h3);
            }
            w.x(p0, q3, h4);
            n n2 = n.a;
            q q4 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n2, 1.0f), 56.0f);
            r0.h h5 = d.k;
            p0 p00 = M.n0.a(M.j.b, h5, p0, 54);
            int v28 = w.j(p0);
            i0 i02 = p0.y();
            q q5 = r0.a.d(p0, q4);
            i i2 = P0.j.a();
            p0.e0();
            if(p0.C()) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            h h6 = A7.d.h(p0, p00, p0, i02);
            if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v28)) {
                A7.d.q(v28, p0, v28, h6);
            }
            w.x(p0, q5, P0.j.d());
            u.c(a0, p0, v23 >> 12 & 14);
            u.a(a1, p0, v23 >> 15 & 14);
            M.c.d(p0, androidx.compose.foundation.layout.d.q(n2, 6.0f));
            p0.r();
            q q6 = z.a(androidx.compose.foundation.layout.d.g(n2), 1.0f);
            y y1 = M.w.a(d0, g0, p0, 0);
            int v29 = w.j(p0);
            i0 i03 = p0.y();
            q q7 = r0.a.d(p0, q6);
            i i3 = P0.j.a();
            p0.e0();
            if(p0.C()) {
                p0.l(i3);
            }
            else {
                p0.o0();
            }
            w.x(p0, y1, P0.j.c());
            w.x(p0, i03, P0.j.e());
            h h7 = P0.j.b();
            if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v29)) {
                A7.d.q(v29, p0, v29, h7);
            }
            w.x(p0, q7, P0.j.d());
            if(z4) {
                p0.a0(1385016652);
            }
            else {
                p0.a0(0x52EFEDCD);
                M.c.d(p0, z.a(n2, 747.0f));
            }
            p0.s();
            q q8 = z.a(androidx.compose.foundation.layout.d.g(n2), 5739.0f);
            M m1 = M.p.d(i0, false);
            int v30 = w.j(p0);
            i0 i04 = p0.y();
            q q9 = r0.a.d(p0, q8);
            i i4 = P0.j.a();
            p0.e0();
            if(p0.C()) {
                p0.l(i4);
            }
            else {
                p0.o0();
            }
            w.x(p0, m1, P0.j.c());
            w.x(p0, i04, P0.j.e());
            h h8 = P0.j.b();
            if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v30)) {
                A7.d.q(v30, p0, v30, h8);
            }
            w.x(p0, q9, P0.j.d());
            q q10 = androidx.compose.foundation.layout.d.e(n2);
            y y2 = M.w.a(d0, g0, p0, 0);
            int v31 = w.j(p0);
            i0 i05 = p0.y();
            q q11 = r0.a.d(p0, q10);
            i i5 = P0.j.a();
            p0.e0();
            if(p0.C()) {
                p0.l(i5);
            }
            else {
                p0.o0();
            }
            w.x(p0, y2, P0.j.c());
            w.x(p0, i05, P0.j.e());
            h h9 = P0.j.b();
            if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v31)) {
                A7.d.q(v31, p0, v31, h9);
            }
            w.x(p0, q11, P0.j.d());
            u.m(v26, p0, s, z.a(androidx.compose.foundation.layout.d.e(n2), 1.0f));
            M.c.d(p0, androidx.compose.foundation.layout.d.h(n2, 26.0f));
            u.n(s1, s2, a2, p0, v23 >> 12 & 0x380 | v12 >> 3 & 0x7E);
            p0.r();
            p0.r();
            if(z4) {
                p0.a0(1385016652);
            }
            else {
                p0.a0(0x52FF5576);
                q q12 = z.a(androidx.compose.foundation.layout.d.g(n2), 1229.0f);
                p0 p01 = M.n0.a(M.j.a(), h5, p0, 54);
                int v32 = w.j(p0);
                i0 i06 = p0.y();
                q q13 = r0.a.d(p0, q12);
                i i6 = P0.j.a();
                p0.e0();
                if(p0.C()) {
                    p0.l(i6);
                }
                else {
                    p0.o0();
                }
                h h10 = A7.d.h(p0, p01, p0, i06);
                if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v32)) {
                    A7.d.q(v32, p0, v32, h10);
                }
                w.x(p0, q13, P0.j.d());
                u.i(z1, k0, p0, v23 & 14 | v23 >> 18 & 0x70);
                M.c.d(p0, androidx.compose.foundation.layout.d.q(n2, 18.0f));
                u.h(z2, a3, p0, v23 >> 3 & 14 | v23 >> 21 & 0x70);
                p0.r();
            }
            p0.s();
            if(!z4 || Float.compare(((c)p0.k(k0.c())).S(Float.intBitsToFloat(((int)(((x0.e)b00.getValue()).a & 0xFFFFFFFFL)))), 350.0f) >= 0) {
                p0.a0(0x530BB220);
                q q14 = androidx.compose.foundation.layout.a.n(z.a(androidx.compose.foundation.layout.d.g(n2), 1213.0f), 20.0f, 0.0f, 8.0f, 0.0f, 10);
                M m2 = M.p.d(i0, false);
                int v33 = w.j(p0);
                i0 i07 = p0.y();
                q q15 = r0.a.d(p0, q14);
                i i7 = P0.j.a();
                p0.e0();
                if(p0.C()) {
                    p0.l(i7);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m2, P0.j.c());
                w.x(p0, i07, P0.j.e());
                h h11 = P0.j.b();
                if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v33)) {
                    A7.d.q(v33, p0, v33, h11);
                }
                w.x(p0, q15, P0.j.d());
                q q16 = androidx.compose.foundation.layout.d.n(n2, 50.0f);
                u.d((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q16, d.i), a4, p0, v23 >> 24 & 0x70);
                q q17 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.g(n2), 50.0f);
                g1 = g0;
                u.f(androidx.compose.foundation.layout.a.n((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q17, d.g), 0.0f, 0.0f, 65.0f, 0.0f, 11), s3, z, s4, s5, h0, p0, v12 >> 6 & 0x7FFF0);
                p0.r();
                p0.s();
            }
            else {
                p0.a0(1385016652);
                p0.s();
                g1 = g0;
            }
            M.c.d(p0, z.a(n2, 62.0f));
            M.c.d(p0, z.a(n2, 1011.0f));
            u.b(androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.g(n2), 55.0f), 15.0f, 0.0f, 2), z3, a5, n0, a6, a7, a8, a9, n1, p0, v23 >> 3 & 0x70 | 6 | v22 << 3 & 0x380 | v22 << 3 & 0x1C00 | 0xE000 & v22 << 3 | 0x70000 & v22 << 3 | 0x380000 & v22 << 3 | 0x1C00000 & v22 << 3 | v22 << 3 & 0xE000000);
            M.c.d(p0, androidx.compose.foundation.layout.d.h(n2, 20.0f));
            p0.r();
            p0.r();
            if(z4) {
                p0.a0(777006296);
            }
            else {
                p0.a0(0x2EF0B69C);
                K.m m3 = p0.N();
                if(m3 == v24) {
                    m3 = new K.m();
                    p0.l0(m3);
                }
                if(((Boolean)x1.a.n(m3, p0, 6).getValue()).booleanValue()) {
                    p0.a0(0x2EF3FCB3);
                    M.p.a(androidx.compose.foundation.q.e(androidx.compose.foundation.layout.d.e(n2), wc.u.f(e.k.A(new y0.s[]{y0.s.a(e0.T(p0, 0x7F06003B)), y0.s.a(e0.T(p0, 0x7F060040))}), 0.0f, 0.0f, 14), null, 6), p0, 0);  // color:black_35
                }
                else {
                    p0.a0(777006296);
                }
                p0.s();
                q q18 = r0.a.a(androidx.compose.foundation.layout.d.e(n2), new B0(3, 1));
                y y3 = M.w.a(d0, g1, p0, 0);
                int v34 = w.j(p0);
                i0 i08 = p0.y();
                q q19 = r0.a.d(p0, q18);
                i i8 = P0.j.a();
                p0.e0();
                if(p0.C()) {
                    p0.l(i8);
                }
                else {
                    p0.o0();
                }
                w.x(p0, y3, P0.j.c());
                w.x(p0, i08, P0.j.e());
                h h12 = P0.j.b();
                if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v34)) {
                    A7.d.q(v34, p0, v34, h12);
                }
                w.x(p0, q19, P0.j.d());
                M.c.d(p0, androidx.compose.foundation.layout.d.h(n2, 56.0f));
                q q20 = z.a(androidx.compose.foundation.layout.d.g(n2), 1.0f);
                y y4 = M.w.a(d0, g1, p0, 0);
                int v35 = w.j(p0);
                i0 i09 = p0.y();
                q q21 = r0.a.d(p0, q20);
                i i9 = P0.j.a();
                p0.e0();
                if(p0.C()) {
                    p0.l(i9);
                }
                else {
                    p0.o0();
                }
                w.x(p0, y4, P0.j.c());
                w.x(p0, i09, P0.j.e());
                h h13 = P0.j.b();
                if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v35)) {
                    A7.d.q(v35, p0, v35, h13);
                }
                w.x(p0, q21, P0.j.d());
                M.c.d(p0, z.a(n2, 747.0f));
                M.c.d(p0, z.a(n2, 5739.0f));
                M.c.d(p0, z.a(n2, 1229.0f));
                M.c.d(p0, z.a(n2, 1213.0f));
                M.c.d(p0, z.a(n2, 62.0f));
                q q22 = z.a(androidx.compose.foundation.layout.d.g(n2), 1011.0f);
                boolean z5 = false;
                M m4 = M.p.d(i0, false);
                int v36 = w.j(p0);
                i0 i010 = p0.y();
                q q23 = r0.a.d(p0, q22);
                i i10 = P0.j.a();
                p0.e0();
                if(p0.C()) {
                    p0.l(i10);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m4, P0.j.c());
                w.x(p0, i010, P0.j.e());
                h h14 = P0.j.b();
                if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v36)) {
                    A7.d.q(v36, p0, v36, h14);
                }
                w.x(p0, q23, P0.j.d());
                q q24 = androidx.compose.foundation.layout.d.e(n2);
                if((v22 & 14) == 4) {
                    z5 = true;
                }
                Y1 y10 = p0.N();
                if(z5 || y10 == v24) {
                    y10 = new Y1(10, k1);
                    p0.l0(y10);
                }
                u.e(q24, v, v1, m3, y10, p0, v12 >> 21 & 0x70 | 0xC06 | v12 >> 21 & 0x380);
                p0.r();
                p0.r();
                M.c.d(p0, androidx.compose.foundation.layout.d.h(n2, 55.0f));
                M.c.d(p0, androidx.compose.foundation.layout.d.h(n2, 20.0f));
                p0.r();
            }
            p0.s();
            p0.r();
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.f(new ud.p(s, s1, s2, s3, z, s4, s5, h0, v, v1, z1, z2, z3, z4, a0, a1, a2, k0, a3, a4, k1, a5, n0, a6, a7, a8, a9, n1, v2));
        }
    }

    public static final void l(q q0, String s, String s1, a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0xD49CD41E);
        int v1 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.g(s) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (p0.g(s1) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v1 |= (p0.i(a0) ? 0x800 : 0x400);
        }
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            q q1 = r0.a.a(q0, new s(5, a0));
            y y0 = M.w.a(M.j.e, d.n, p0, 54);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q2 = r0.a.d(p0, q1);
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q2, P0.j.d);
            N1.b(s, androidx.compose.foundation.q.h(androidx.compose.foundation.layout.d.f(n.a, 1.0f), 0, 0, null, 0.0f, 62), e0.T(p0, 0x7F0604C2), 14.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v1 >> 3 & 14 | 0xC30, 0xC30, 0x1D7F0);  // color:white_90
            N1.b(s1, androidx.compose.foundation.q.h(x.s(n.a, 6.0f, p0, n.a, 1.0f), 0, 0, null, 0.0f, 62), e0.T(p0, 0x7F0604C1), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v1 >> 6 & 14 | 0xC30, 0xC30, 0x1D7F0);  // color:white_70
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new qd.n(v, 2, s, s1, q0, a0);
        }
    }

    public static final void m(int v, l l0, String s, q q0) {
        p p0 = (p)l0;
        p0.c0(2000863772);
        int v1 = (v & 6) == 0 ? v | (p0.g(q0) ? 4 : 2) : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.g(s) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            b0 b00 = p0.N();
            V v2 = k.a;
            if(b00 == v2) {
                b00 = w.s(new r1.l(0L));
                p0.l0(b00);
            }
            int v3 = ((int)(((r1.l)b00.getValue()).a >> 0x20)) >= ((int)(((r1.l)b00.getValue()).a & 0xFFFFFFFFL)) ? 0 : 1;
            q q1 = androidx.compose.foundation.layout.a.l(q0, 61.0f, 0.0f, 2);
            R0 r00 = p0.N();
            if(r00 == v2) {
                r00 = new R0(b00, 26);
                p0.l0(r00);
            }
            q q2 = androidx.compose.ui.layout.a.f(q1, r00);
            M m0 = M.p.d(d.a, false);
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
            w.x(p0, m0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            w.x(p0, q3, P0.j.d);
            if(r1.l.b(((r1.l)b00.getValue()).a, 0L)) {
                p0.a0(0x98F86C80);
            }
            else {
                p0.a0(-1709890829);
                q q4 = androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.a.d(1.0f, androidx.compose.foundation.layout.d.c, ((boolean)(v3 ^ 1))), T.e.b(8.0f)), e0.T(p0, 0x7F060161), y0.M.a);  // color:gray601s
                c1.n(androidx.compose.foundation.q.i(0.5f, e0.T(p0, 0x7F06014A), q4, T.e.b(8.0f)), s, null, N0.j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, v1 & 0x70 | 0xD80, 0, 0x7FF0);  // color:gray100a
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new w0(q0, s, v, 7);
        }
    }

    public static final void n(String s, String s1, a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(210917769);
        int v1 = (v & 6) == 0 ? (p0.g(s) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.g(s1) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (p0.i(a0) ? 0x100 : 0x80);
        }
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            n n0 = n.a;
            q q0 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 51.0f), 36.0f, 0.0f, 36.0f, 0.0f, 10);
            y y0 = M.w.a(M.j.e, d.n, p0, 54);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, P0.j.d);
            N1.b(s, androidx.compose.foundation.q.h(androidx.compose.foundation.layout.d.s(n0, 0.0f, 0.0f, 3), 0, 0, null, 0.0f, 62), e0.T(p0, 0x7F0604C2), 18.0f, null, null, 0L, new l1.k(3), 0.0f, 2, false, 1, 0, null, null, p0, v1 & 14 | 0xC30, 0xC30, 0x1D5F0);  // color:white_90
            M.c.d(p0, androidx.compose.foundation.layout.d.h(n0, 14.0f));
            N1.b(s1, r0.a.a(androidx.compose.foundation.q.h(androidx.compose.foundation.layout.d.s(n0, 0.0f, 0.0f, 3), 0, 0, null, 0.0f, 62), new s(6, a0)), e0.T(p0, 0x7F0604C1), 15.0f, null, null, 0L, new l1.k(3), 0.0f, 2, false, 1, 0, null, null, p0, v1 >> 3 & 14 | 0xC00, 0xC30, 0x1D5F0);  // color:white_70
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Ac.e(s, s1, a0, v, 19);
        }
    }
}

