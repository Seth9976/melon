package bd;

import Cc.N1;
import Cc.O2;
import Cc.c1;
import Cc.e0;
import Cc.m3;
import Lc.c;
import M.p0;
import P0.h;
import P0.j;
import Q.O;
import T.e;
import U4.x;
import U8.F;
import Vb.i;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.J;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.iloen.melon.net.v5x.response.FlexibleRes.BadgeType;
import com.iloen.melon.utils.time.TimeUtils;
import h7.u0;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import r0.g;
import r0.n;
import r0.q;
import we.a;
import y0.M;
import y0.s;

public abstract class y {
    public static final void a(long v, SimpleDateFormat simpleDateFormat0, float f, long v1, a a0, l l0, int v2) {
        p p0;
        ((p)l0).c0(0x89480401);
        int v3 = (v2 & 6) == 0 ? (((p)l0).f(v) ? 4 : 2) | v2 : v2;
        if((v2 & 0xC00) == 0) {
            v3 |= (((p)l0).f(v1) ? 0x800 : 0x400);
        }
        if((v2 & 0x6000) == 0) {
            v3 |= (((p)l0).i(a0) ? 0x4000 : 0x2000);
        }
        int v4 = 0;
        if(((p)l0).Q(v3 & 1, (v3 & 0x2403) != 0x2402)) {
            ((p)l0).V();
            if((v2 & 1) != 0 && !((p)l0).B()) {
                ((p)l0).T();
            }
            ((p)l0).q();
            b0 b00 = ((p)l0).N();
            V v5 = k.a;
            if((v3 & 14) == 4 || b00 == v5) {
                i i0 = new i(10);
                b00 = w.s(TimeUtils.INSTANCE.getRemainedTimeTextOrDefault(v, System.currentTimeMillis(), i0));
                ((p)l0).l0(b00);
            }
            N1.b(((String)b00.getValue()), null, v1, 15.0f, null, null, 0L, null, 0.0f, 2, false, 2, 0, null, null, ((p)l0), v3 >> 3 & 0x380 | 0xC00, 0xC30, 0x1D7F2);
            p0 = (p)l0;
            Long long0 = v;
            if((v3 & 0xE000) == 0x4000) {
                v4 = 1;
            }
            boolean z = p0.g(b00);
            bd.w w0 = p0.N();
            if((((v3 & 14) == 4 ? 1 : 0) | v4 | z) != 0 || w0 == v5) {
                bd.w w1 = new bd.w(v, a0, b00, null);
                p0.l0(w1);
                w0 = w1;
            }
            J.d(p0, long0, w0);
        }
        else {
            p0 = (p)l0;
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new u(v, simpleDateFormat0, f, v1, a0, v2);
        }
    }

    public static final void b(String s, long v, String s1, String s2, BadgeType flexibleRes$BadgeType0, String s3, List list0, long v1, long v2, long v3, long v4, long v5, boolean z, a a0, a a1, l l0, int v6) {
        wc.u u1;
        b b1;
        P0.i i2;
        V v21;
        h h6;
        h h5;
        h h4;
        p p0 = (p)l0;
        p0.c0(-52209253);
        int v7 = p0.g(s) ? 4 : 2;
        int v8 = 0x20;
        int v9 = p0.f(v) ? 0x20 : 16;
        int v10 = 0x80;
        int v11 = p0.g(s1) ? 0x100 : 0x80;
        int v12 = 0x400;
        int v13 = p0.g(s2) ? 0x800 : 0x400;
        int v14 = 0x2000;
        int v15 = (p0.e((flexibleRes$BadgeType0 == null ? -1 : flexibleRes$BadgeType0.ordinal())) ? 0x4000 : 0x2000) | (v6 | v7 | v9 | v11 | v13) | (p0.g(s3) ? 0x20000 : 0x10000) | (p0.i(list0) ? 0x100000 : 0x80000) | (p0.f(v1) ? 0x800000 : 0x400000) | (p0.f(v2) ? 0x4000000 : 0x2000000) | (p0.f(v3) ? 0x20000000 : 0x10000000);
        int v16 = p0.f(v4) ? 4 : 2;
        if(!p0.f(v5)) {
            v8 = 16;
        }
        if(p0.h(z)) {
            v10 = 0x100;
        }
        if(p0.i(a0)) {
            v12 = 0x800;
        }
        if(p0.i(a1)) {
            v14 = 0x4000;
        }
        int v17 = v16 | v8 | v10 | v12 | v14;
        if(p0.Q(v15 & 1, (v15 & 306783379) != 306783378 || (v17 & 9363) != 9362)) {
            p0.V();
            if((v6 & 1) != 0 && !p0.B()) {
                p0.T();
            }
            p0.q();
            b0 b00 = p0.N();
            V v18 = k.a;
            if(b00 == v18) {
                b00 = w.s(Boolean.valueOf(v != 0L && v <= System.currentTimeMillis()));
                p0.l0(b00);
            }
            n n0 = n.a;
            q q0 = androidx.compose.foundation.q.f(e0.L(n0, 0x7F0604AE), v1, M.a);  // color:white120e
            wc.u u0 = M.a;
            q q1 = r0.a.a(d.h(d.f(q0, 1.0f), 200.0f), new c(20, a0));
            Bc.d d0 = p0.N();
            if((v17 & 0xE000) == 0x4000 || d0 == v18) {
                d0 = new Bc.d(18, a1);
                p0.l0(d0);
            }
            q q2 = m3.b(q1, d0);
            r0.i i0 = r0.d.a;
            N0.M m0 = M.p.d(i0, false);
            int v19 = p0.P;
            i0 i00 = p0.m();
            q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            P0.i i1 = j.b;
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v19)) {
                A7.d.q(v19, p0, v19, h2);
            }
            h h3 = j.d;
            w.x(p0, q3, h3);
            b b0 = (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
            if(list0.isEmpty()) {
                h4 = h1;
                h5 = h2;
                i2 = i1;
                h6 = h0;
                v21 = v18;
                b1 = b0;
                p0.a0(0xAB16C601);
            }
            else {
                p0.a0(-1421009413);
                q q4 = androidx.compose.foundation.layout.a.m(b0.a(n0, r0.d.g), 20.0f, 20.0f, 20.0f, 16.0f);
                N0.M m1 = M.p.d(i0, false);
                int v20 = p0.P;
                i0 i01 = p0.m();
                q q5 = r0.a.d(p0, q4);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m1, h0);
                w.x(p0, i01, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v20)) {
                    A7.d.q(v20, p0, v20, h2);
                }
                w.x(p0, q5, h3);
                h4 = h1;
                h5 = h2;
                h6 = h0;
                v21 = v18;
                i2 = i1;
                b1 = b0;
                y.c(list0, v5, p0, v15 >> 18 & 14 | v17 & 0x70, 0);
                q q6 = androidx.compose.foundation.q.e(d.h(d.f(n0, 1.0f), 24.0f), wc.u.f(e.k.A(new s[]{new s(v1), new s(s.f)}), 0.0f, 0.0f, 14), null, 6);
                N0.M m2 = M.p.d(i0, false);
                int v22 = p0.P;
                i0 i02 = p0.m();
                q q7 = r0.a.d(p0, q6);
                p0.e0();
                if(p0.O) {
                    p0.l(i2);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m2, h6);
                w.x(p0, i02, h4);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v22)) {
                    A7.d.q(v22, p0, v22, h5);
                }
                w.x(p0, q7, h3);
                p0.p(true);
                p0.p(true);
            }
            p0.p(false);
            if(z) {
                p0.a0(0xAB58AC0F);
                c1.n(androidx.compose.foundation.layout.a.g(d.n(b1.a(n0, r0.d.c), 190.0f), 28.0f, -28.0f), 0x7F080661, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FFC);  // drawable:img_musicwave_pattern
            }
            else {
                p0.a0(0xAB16C601);
            }
            p0.p(false);
            q q8 = androidx.compose.foundation.layout.a.n(d.c, 20.0f, 20.0f, 20.0f, 0.0f, 8);
            M.d d1 = M.j.c;
            g g0 = r0.d.m;
            M.y y0 = M.w.a(d1, g0, p0, 0);
            int v23 = p0.P;
            i0 i03 = p0.m();
            q q9 = r0.a.d(p0, q8);
            p0.e0();
            if(p0.O) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h6);
            w.x(p0, i03, h4);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v23)) {
                A7.d.q(v23, p0, v23, h5);
            }
            w.x(p0, q9, h3);
            q q10 = d.f(n0, 1.0f);
            M.b b2 = M.j.a;
            p0 p00 = M.n0.a(b2, r0.d.j, p0, 0);
            int v24 = p0.P;
            i0 i04 = p0.m();
            q q11 = r0.a.d(p0, q10);
            p0.e0();
            if(p0.O) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h6);
            w.x(p0, i04, h4);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v24)) {
                A7.d.q(v24, p0, v24, h5);
            }
            w.x(p0, q11, h3);
            LayoutWeightElement layoutWeightElement0 = new LayoutWeightElement(1.0f, true);
            M.y y1 = M.w.a(d1, g0, p0, 0);
            int v25 = p0.P;
            i0 i05 = p0.m();
            q q12 = r0.a.d(p0, layoutWeightElement0);
            p0.e0();
            if(p0.O) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            w.x(p0, y1, h6);
            w.x(p0, i05, h4);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v25)) {
                A7.d.q(v25, p0, v25, h5);
            }
            w.x(p0, q12, h3);
            if(flexibleRes$BadgeType0 == BadgeType.EVENT) {
                p0.a0(0xBEE3F7A0);
                c1.n(d.o(n0, 44.0f, 18.0f), 0x7F0800B3, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 54, 0, 0x7FFC);  // drawable:badge_musicwave_event_18
                p0.p(false);
                u1 = u0;
            }
            else if(((Boolean)b00.getValue()).booleanValue()) {
                p0.a0(-1092093622);
                c1.n(d.o(n0, 40.0f, 18.0f), 0x7F0805AC, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 54, 0, 0x7FFC);  // drawable:ic_player_live
                p0.p(false);
                u1 = u0;
            }
            else {
                if(v > System.currentTimeMillis()) {
                    p0.a0(-1091784118);
                    p0 p01 = M.n0.a(b2, r0.d.k, p0, 0x30);
                    int v26 = p0.P;
                    i0 i06 = p0.m();
                    q q13 = r0.a.d(p0, n0);
                    p0.e0();
                    if(p0.O) {
                        p0.l(i2);
                    }
                    else {
                        p0.o0();
                    }
                    w.x(p0, p01, h6);
                    w.x(p0, i06, h4);
                    if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v26)) {
                        A7.d.q(v26, p0, v26, h5);
                    }
                    w.x(p0, q13, h3);
                    c1.n(d.n(n0, 14.0f), 0x7F0805E9, null, null, false, 0, null, null, null, 0.0f, new y0.k(v2, 5), 0, 0, false, false, p0, 54, 0, 0x7BFC);  // drawable:ic_time_14
                    M.c.d(p0, d.q(n0, 6.0f));
                    SimpleDateFormat simpleDateFormat0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                    F f0 = p0.N();
                    if(f0 == v21) {
                        f0 = new F(b00, 3);
                        p0.l0(f0);
                    }
                    u1 = u0;
                    y.a(v, simpleDateFormat0, 15.0f, v2, f0, p0, v15 >> 3 & 14 | 0x6180 | v15 >> 15 & 0x1C00);
                    p0.p(true);
                }
                else {
                    u1 = u0;
                    p0.a0(0xBE992F11);
                }
                p0.p(false);
            }
            if(s1.length() > 0) {
                p0.a0(-1090670257);
                N1.b(s1, x.s(n0, 6.0f, p0, n0, 1.0f), v3, 20.0f, e1.y.i, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v15 >> 6 & 14 | 0x30C30 | v15 >> 21 & 0x380, 0xC30, 0x1D7D0);
            }
            else {
                p0.a0(0xBE992F11);
            }
            p0.p(false);
            if(s2.length() > 0) {
                p0.a0(0xBF06374C);
                N1.b(s2, x.s(n0, 3.0f, p0, n0, 1.0f), v3, 20.0f, e1.y.i, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v15 >> 9 & 14 | 0x30C30 | v15 >> 21 & 0x380, 0xC30, 0x1D7D0);
            }
            else {
                p0.a0(0xBE992F11);
            }
            p0.p(false);
            M.c.d(p0, d.h(n0, 5.0f));
            N1.b(s3, null, v4, 13.0f, null, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, p0, v15 >> 15 & 14 | 0xC00 | v17 << 6 & 0x380, 0xC00, 0x1DFF2);
            p0.p(true);
            M.c.d(p0, d.q(n0, 20.0f));
            q q14 = d5.n.o(d.n(n0, 92.0f), e.a);
            androidx.compose.foundation.y y2 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F06014A), 0.5f);  // color:gray100a
            c1.n(androidx.compose.foundation.q.f(androidx.compose.foundation.q.j(q14, y2.a, y2.b, e.a), e0.T(p0, 0x7F060145), u1), s, null, N0.j.b, false, 0x7F080799, null, null, null, 0.0f, null, 0, 0, false, false, p0, v15 << 3 & 0x70 | 0x30C00, 0, 0x7FD4);  // color:gray050s
            p0.p(true);
            M.c.d(p0, d.h(n0, 22.0f));
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new t(s, v, s1, s2, flexibleRes$BadgeType0, s3, list0, v1, v2, v3, v4, v5, z, a0, a1, v6);
        }
    }

    public static final void c(List list0, long v, l l0, int v1, int v2) {
        long v7;
        int v5;
        long v4;
        p p0 = (p)l0;
        p0.c0(0x4834E487);
        int v3 = (v1 & 6) == 0 ? v1 | (p0.i(list0) ? 4 : 2) : v1;
        if((v1 & 0x30) == 0) {
            if((v2 & 2) == 0) {
                v4 = v;
                v5 = p0.f(v4) ? 0x20 : 16;
            }
            else {
                v4 = v;
                v5 = 16;
            }
            v3 |= v5;
        }
        else {
            v4 = v;
        }
        if(p0.Q(v3 & 1, (v3 & 19) != 18)) {
            p0.V();
            if((v1 & 1) != 0 && !p0.B()) {
                p0.T();
            }
            else if((v2 & 2) != 0) {
                v4 = e0.T(p0, 0x7F0604A1);  // color:white000e
            }
            p0.q();
            i i0 = p0.N();
            V v6 = k.a;
            if(i0 == v6) {
                i0 = new i(11);
                p0.l0(i0);
            }
            Q.e e0 = O.b(i0, p0, 0x180, 3);
            a0 a00 = p0.N();
            if(a00 == v6) {
                a00 = w.p(0);
                p0.l0(a00);
            }
            u0.f(e0, d.h(n.a, 56.0f), null, new Q.l(24.0f), 6.0f, null, null, false, null, null, null, m0.c.e(0x997F4A36, p0, new v(v4, list0)), p0, 0x6030030);
            Integer integer0 = ((K0)a00).m();
            boolean z = p0.g(e0);
            bd.x x0 = p0.N();
            if(z || x0 == v6) {
                x0 = new bd.x(e0, a00, null);
                p0.l0(x0);
            }
            J.d(p0, integer0, x0);
        }
        else {
            p0.T();
        }
        v7 = v4;
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new O2(list0, v1, v2, v7, 1);
        }
    }
}

