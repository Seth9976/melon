package rd;

import Ac.g1;
import Ac.h1;
import Ac.i1;
import Bd.F;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import De.I;
import E9.h;
import F.S;
import F.X;
import F.Y;
import G.C;
import G.f;
import H0.e;
import M.p0;
import M.q0;
import M.y;
import N0.M;
import N0.g0;
import N0.j;
import Q0.k0;
import android.content.Context;
import android.content.res.Configuration;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimationKt;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec.Asset;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import com.iloen.melon.custom.l1;
import com.iloen.melon.utils.system.ScreenUtils;
import com.melon.ui.playerdjmalrang.DjMalrangPlayerViewCalculator;
import ed.D;
import ie.H;
import java.util.Arrays;
import pc.b;
import r0.q;
import r1.c;
import we.a;
import we.k;
import we.n;
import x1.m;

public abstract class x {
    public static final void a(q q0, l l0, int v) {
        ((p)l0).c0(1439414410);
        int v1 = (((p)l0).g(q0) ? 4 : 2) | v;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            c1.n(d.n(q0, h.t(((p)l0), 0x7F070409)), 0x7F080222, e.Y(((p)l0), 0x7F130B13), j.f, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((p)l0), 0x6C30, 0, 0x7FE0);  // dimen:player_bottom_default_button_size
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Bd.h(q0, v, 7);
        }
    }

    public static final void b(boolean z, a a0, a a1, n n0, a a2, n n1, a a3, a a4, boolean z1, a a5, String s, a a6, a a7, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(-1200150016);
        int v1 = 0x80;
        int v2 = v | (p0.h(z) ? 4 : 2) | (p0.i(a0) ? 0x20 : 16) | (p0.i(a1) ? 0x100 : 0x80) | (p0.i(n0) ? 0x800 : 0x400) | (p0.i(a2) ? 0x4000 : 0x2000) | (p0.i(n1) ? 0x20000 : 0x10000) | (p0.i(a3) ? 0x100000 : 0x80000) | (p0.i(a4) ? 0x800000 : 0x400000) | (p0.h(z1) ? 0x4000000 : 0x2000000) | (p0.i(a5) ? 0x20000000 : 0x10000000);
        int v3 = p0.g(s) ? 4 : 2;
        int v4 = p0.i(a6) ? 0x20 : 16;
        if(p0.i(a7)) {
            v1 = 0x100;
        }
        int v5 = v3 | v4 | v1;
        if(!p0.Q(v2 & 1, (v2 & 306783379) != 306783378 || (v5 & 0x93) != 0x92)) {
            p0.T();
        }
        else if(((Configuration)p0.k(AndroidCompositionLocals_androidKt.a)).orientation == 2) {
            p0.a0(1934340488);
            x.f(a1, n0, z, a0, a2, n1, a3, a4, z1, a5, s, a6, a7, p0, v2 >> 6 & 0x7E | v2 << 6 & 0x380 | v2 << 6 & 0x1C00 | v2 & 0xE000 | v2 & 0x70000 | v2 & 0x380000 | v2 & 0x1C00000 | v2 & 0xE000000 | v2 & 0x70000000, v5 & 0x3FE);
            p0.p(false);
        }
        else {
            p0.a0(0x73560809);
            x.h(a1, n0, z, a0, a2, n1, a3, a4, z1, a5, s, a6, a7, p0, v2 >> 6 & 0x7E | v2 << 6 & 0x380 | v2 << 6 & 0x1C00 | v2 & 0xE000 | v2 & 0x70000 | v2 & 0x380000 | v2 & 0x1C00000 | v2 & 0xE000000 | v2 & 0x70000000, v5 & 0x3FE);
            p0.p(false);
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new rd.e(z, a0, a1, n0, a2, n1, a3, a4, z1, a5, s, a6, a7, v);
        }
    }

    public static final void c(b b0, String s, a a0, long v, n n0, String s1, String s2, a a1, a a2, a a3, String s3, String s4, String s5, String s6, a a4, a a5, a a6, boolean z, int v1, a a7, a a8, d9.h h0, boolean z1, boolean z2, boolean z3, k k0, long v2, long v3, Long long0, long v4, long v5, k k1, k k2, k k3, k k4, a a9, a a10, boolean z4, a a11, a a12, n n1, a a13, n n2, a a14, a a15, boolean z5, a a16, String s7, a a17, a a18, boolean z6, l l0, int v6) {
        M m2;
        b0 b03;
        m m1;
        x1.j j1;
        Context context1;
        X x1;
        kotlin.jvm.internal.q.g(h0, "lyricViewModel");
        p p0 = (p)l0;
        p0.c0(0xFCC85E8B);
        int v7 = p0.e((b0 == null ? -1 : b0.ordinal())) ? 4 : 2;
        int v8 = p0.g(s) ? 0x20 : 16;
        int v9 = p0.i(a0) ? 0x100 : 0x80;
        int v10 = 0x800;
        int v11 = p0.f(v) ? 0x800 : 0x400;
        int v12 = 0x10000;
        int v13 = p0.g(s1) ? 0x20000 : 0x10000;
        int v14 = 0x80000;
        int v15 = p0.g(s2) ? 0x100000 : 0x80000;
        int v16 = 0x400000;
        int v17 = p0.i(a1) ? 0x800000 : 0x400000;
        int v18 = 0x2000000;
        int v19 = p0.i(a2) ? 0x4000000 : 0x2000000;
        int v20 = 0x10000000;
        int v21 = p0.i(a3) ? 0x20000000 : 0x10000000;
        int v22 = p0.g(s3) ? 4 : 2;
        int v23 = p0.g(s4) ? 0x20 : 16;
        int v24 = p0.g(s5) ? 0x100 : 0x80;
        int v25 = p0.g(s6) ? 0x800 : 0x400;
        int v26 = 0x2000;
        int v27 = p0.i(a4) ? 0x4000 : 0x2000;
        int v28 = p0.i(a5) ? 0x20000 : 0x10000;
        int v29 = p0.i(a6) ? 0x100000 : 0x80000;
        int v30 = p0.h(z) ? 0x800000 : 0x400000;
        int v31 = p0.e(v1) ? 0x4000000 : 0x2000000;
        int v32 = p0.i(a7) ? 0x20000000 : 0x10000000;
        int v33 = p0.i(a8) ? 4 : 2;
        int v34 = p0.i(h0) ? 0x20 : 16;
        int v35 = p0.h(z1) ? 0x100 : 0x80;
        int v36 = p0.h(z2) ? 0x800 : 0x400;
        int v37 = p0.h(z3) ? 0x4000 : 0x2000;
        int v38 = p0.i(k0) ? 0x800000 : 0x400000;
        int v39 = v6 | v7 | v8 | v9 | v11 | v13 | v15 | v17 | v19 | v21;
        int v40 = p0.f(v2) ? 0x4000000 : 0x2000000;
        int v41 = p0.f(v3) ? 0x20000000 : 0x10000000;
        int v42 = p0.g(long0) ? 4 : 2;
        int v43 = p0.f(v4) ? 0x20 : 16;
        int v44 = p0.f(v5) ? 0x100 : 0x80;
        int v45 = p0.i(k2) ? 0x4000 : 0x2000;
        int v46 = p0.i(k3) ? 0x20000 : 0x10000;
        int v47 = p0.i(k4) ? 0x100000 : 0x80000;
        int v48 = p0.i(a9) ? 0x800000 : 0x400000;
        int v49 = p0.i(a10) ? 0x4000000 : 0x2000000;
        int v50 = p0.h(z4) ? 0x20000000 : 0x10000000;
        int v51 = p0.i(a11) ? 4 : 2;
        int v52 = p0.i(a12) ? 0x20 : 16;
        int v53 = p0.i(n1) ? 0x100 : 0x80;
        if(!p0.i(a13)) {
            v10 = 0x400;
        }
        if(p0.i(n2)) {
            v26 = 0x4000;
        }
        if(p0.i(a14)) {
            v12 = 0x20000;
        }
        if(p0.i(a15)) {
            v14 = 0x100000;
        }
        if(p0.h(z5)) {
            v16 = 0x800000;
        }
        if(p0.i(a16)) {
            v18 = 0x4000000;
        }
        if(p0.g(s7)) {
            v20 = 0x20000000;
        }
        if(p0.Q(v39 & 1, (v39 & 306783379) != 306783378 || ((v22 | v23 | v24 | v25 | v27 | v28 | v29 | v30 | v31 | v32) & 306783379) != 306783378 || ((0x1B0000 | v33 | v34 | v35 | v36 | v37 | v38 | v40 | v41) & 306783379) != 306783378 || ((0xC00 | v42 | v43 | v44 | v45 | v46 | v47 | v48 | v49 | v50) & 306783379) != 306783378 || ((v51 | v52 | v53 | v10 | v26 | v12 | v14 | v16 | v18 | v20) & 306783379) != 306783378 || (((p0.i(a17) ? 4 : 2) | (p0.i(a18) ? 0x20 : 16) | (p0.h(z6) ? 0x100 : 0x80)) & 0x93) != 0x92)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            boolean z7 = p0.g(context0);
            DjMalrangPlayerViewCalculator djMalrangPlayerViewCalculator0 = p0.N();
            V v54 = androidx.compose.runtime.k.a;
            if(z7 || djMalrangPlayerViewCalculator0 == v54) {
                djMalrangPlayerViewCalculator0 = new DjMalrangPlayerViewCalculator(context0);
                p0.l0(djMalrangPlayerViewCalculator0);
            }
            a0 a00 = p0.N();
            if(a00 == v54) {
                a00 = w.p(ScreenUtils.getStatusBarHeight(context0));
                p0.l0(a00);
            }
            a0 a01 = p0.N();
            if(a01 == v54) {
                a01 = w.p(-1);
                p0.l0(a01);
            }
            b0 b00 = p0.N();
            if(b00 == v54) {
                b00 = w.s(Boolean.TRUE);
                p0.l0(b00);
            }
            X x0 = p0.N();
            if(x0 == v54) {
                x0 = S.b(f.r(0xAF, 0, C.d, 2), 2);
                p0.l0(x0);
            }
            Y y0 = p0.N();
            if(y0 == v54) {
                x1 = x0;
                y0 = S.c(f.r(75, 0, C.d, 2), 2);
                p0.l0(y0);
            }
            else {
                x1 = x0;
            }
            FillElement fillElement0 = d.c;
            boolean z8 = p0.i(context0);
            boolean z9 = p0.i(djMalrangPlayerViewCalculator0);
            F f0 = p0.N();
            if(z8 || z9 || f0 == v54) {
                f0 = new F(a00, context0, a01, djMalrangPlayerViewCalculator0, 19);
                context1 = context0;
                p0.l0(f0);
            }
            else {
                context1 = context0;
            }
            q q0 = androidx.compose.ui.layout.a.f(fillElement0, f0);
            p0.a0(-1003410150);
            p0.a0(212064437);
            p0.p(false);
            c c0 = (c)p0.k(k0.h);
            x1.q q1 = p0.N();
            if(q1 == v54) {
                q1 = l1.w(c0, p0);
            }
            x1.j j0 = p0.N();
            if(j0 == v54) {
                j0 = l1.u(p0);
            }
            b0 b01 = p0.N();
            if(b01 == v54) {
                b01 = w.s(Boolean.FALSE);
                p0.l0(b01);
            }
            m m0 = p0.N();
            if(m0 == v54) {
                m0 = l1.v(j0, p0);
            }
            b0 b02 = p0.N();
            if(b02 == v54) {
                b02 = w.r(H.a, V.c);
                p0.l0(b02);
            }
            boolean z10 = p0.i(q1);
            boolean z11 = p0.e(0x101);
            g1 g10 = p0.N();
            if(z10 || z11 || g10 == v54) {
                j1 = j0;
                g10 = new g1(b02, q1, m0, 10, b01);
                m1 = m0;
                b03 = b01;
                p0.l0(g10);
            }
            else {
                j1 = j0;
                m1 = m0;
                b03 = b01;
            }
            h1 h10 = p0.N();
            if(h10 == v54) {
                m2 = g10;
                h10 = new h1(b03, m1, 10);
                p0.l0(h10);
            }
            else {
                m2 = g10;
            }
            boolean z12 = p0.i(q1);
            i1 i10 = p0.N();
            if(z12 || i10 == v54) {
                i10 = new i1(q1, 10);
                p0.l0(i10);
            }
            g0.a(X0.n.c(q0, false, i10), m0.c.e(1200550679, p0, new i(b02, j1, h10, a00, z6, z3, long0, b00, v2, v3, a2, a3, x1, y0, s, a0, v, n0, s1, s2, a1, a01, b0, s3, s4, s5, s6, a4, a5, a6, z1, h0, k0, a8, z, v1, a7, v4, v5, z2, context1, k1, k2, k3, k4, a9, a10, z4, a11, a12, n1, a13, n2, a14, a15, z5, a16, s7, a17, a18)), m2, p0, 0x30);
            p0.p(false);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new rd.d(b0, s, a0, v, n0, s1, s2, a1, a2, a3, s3, s4, s5, s6, a4, a5, a6, z, v1, a7, a8, h0, z1, z2, z3, k0, v2, v3, long0, v4, v5, k1, k2, k3, k4, a9, a10, z4, a11, a12, n1, a13, n2, a14, a15, z5, a16, s7, a17, a18, z6, v6);
        }
    }

    public static final void d(q q0, l l0, int v) {
        q q5;
        p p0 = (p)l0;
        p0.c0(1368923053);
        if(p0.Q((v | 6) & 1, ((v | 6) & 3) != 2)) {
            r0.n n0 = r0.n.a;
            q q1 = d.h(d.v(n0, null, 3), 27.0f);
            p0 p00 = M.n0.a(M.j.a, r0.d.j, p0, 0);
            int v1 = p0.P;
            i0 i00 = p0.m();
            q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, P0.j.f);
            w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v1)) {
                A7.d.q(v1, p0, v1, h0);
            }
            w.x(p0, q2, P0.j.d);
            LottieCompositionResult lottieCompositionResult0 = RememberLottieCompositionKt.rememberLottieComposition(Asset.box-impl("animation/ic_malang_basic_motion.json"), null, null, null, null, null, p0, 6, 62);
            q q3 = d.n(n0, 27.0f);
            q q4 = H0.b.r(r0.d.k, q3);
            LottieAnimationKt.LottieAnimation(((LottieComposition)lottieCompositionResult0.getValue()), q4, false, false, null, 0.0f, 0x7FFFFFFF, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, p0, 0x180000, 0, 0, 0x3FFFBC);
            M.c.d(p0, d.q(n0, 4.0f));
            c1.n(d.o(n0, 83.0f, 27.0f), 0x7F0804AE, e.Y(p0, 0x7F130327), null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x6036, 0, 0x7FE8);  // drawable:ic_malang_logo_aos
            M.c.d(p0, d.q(n0, 1.0f));
            c1.n(d.o(androidx.compose.foundation.layout.a.n(n0, 0.0f, 5.0f, 0.0f, 0.0f, 13), 23.0f, 12.0f), 0x7F0803B5, e.Y(p0, 0x7F130ADB), null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 54, 0, 0x7FF8);  // drawable:ic_beta
            p0.p(true);
            q5 = n0;
        }
        else {
            p0.T();
            q5 = q0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Bd.h(q5, v, 5);
        }
    }

    public static final void e(q q0, l l0, int v) {
        ((p)l0).c0(0xF56BCE5E);
        int v1 = (((p)l0).g(q0) ? 4 : 2) | v;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            c1.n(d.n(q0, h.t(((p)l0), 0x7F070409)), 0x7F080249, e.Y(((p)l0), 0x7F130B15), j.f, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((p)l0), 0x6C30, 0, 0x7FE0);  // dimen:player_bottom_default_button_size
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Bd.h(q0, v, 6);
        }
    }

    public static final void f(a a0, n n0, boolean z, a a1, a a2, n n1, a a3, a a4, boolean z1, a a5, String s, a a6, a a7, l l0, int v, int v1) {
        b0 b02;
        m m1;
        x1.j j1;
        p p0 = (p)l0;
        p0.c0(400182079);
        int v2 = (v & 6) == 0 ? (p0.i(a0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.i(n0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.h(z) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v2 |= (p0.i(a1) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v2 |= (p0.i(a2) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v) == 0) {
            v2 |= (p0.i(n1) ? 0x20000 : 0x10000);
        }
        if((v & 0x180000) == 0) {
            v2 |= (p0.i(a3) ? 0x100000 : 0x80000);
        }
        if((v & 0xC00000) == 0) {
            v2 |= (p0.i(a4) ? 0x800000 : 0x400000);
        }
        if((v & 0x6000000) == 0) {
            v2 |= (p0.h(z1) ? 0x4000000 : 0x2000000);
        }
        if((v & 0x30000000) == 0) {
            v2 |= (p0.i(a5) ? 0x20000000 : 0x10000000);
        }
        int v3 = (v1 & 6) == 0 ? v1 | (p0.g(s) ? 4 : 2) : v1;
        if((v1 & 0x30) == 0) {
            v3 |= (p0.i(a6) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v3 |= (p0.i(a7) ? 0x100 : 0x80);
        }
        if(p0.Q(v2 & 1, (v2 & 306783379) != 306783378 || (v3 & 0x93) != 0x92)) {
            q q0 = androidx.compose.foundation.layout.a.n(d.h(d.f(r0.n.a, 1.0f), h.t(p0, 0x7F070408)), 14.0f, 0.0f, 14.0f, 17.0f, 2);  // dimen:player_bottom_controller_height
            p0.a0(-1003410150);
            p0.a0(212064437);
            p0.p(false);
            c c0 = (c)p0.k(k0.h);
            x1.q q1 = p0.N();
            V v4 = androidx.compose.runtime.k.a;
            if(q1 == v4) {
                q1 = l1.w(c0, p0);
            }
            x1.j j0 = p0.N();
            if(j0 == v4) {
                j0 = l1.u(p0);
            }
            b0 b00 = p0.N();
            if(b00 == v4) {
                b00 = w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            m m0 = p0.N();
            if(m0 == v4) {
                m0 = l1.v(j0, p0);
            }
            b0 b01 = p0.N();
            if(b01 == v4) {
                j1 = j0;
                b01 = w.r(H.a, V.c);
                p0.l0(b01);
            }
            else {
                j1 = j0;
            }
            boolean z2 = p0.i(q1);
            boolean z3 = p0.e(0x101);
            g1 g10 = p0.N();
            if(z2 || z3 || g10 == v4) {
                g10 = new g1(b01, q1, m0, 11, b00);
                m1 = m0;
                b02 = b00;
                p0.l0(g10);
            }
            else {
                m1 = m0;
                b02 = b00;
            }
            h1 h10 = p0.N();
            if(h10 == v4) {
                h10 = new h1(b02, m1, 11);
                p0.l0(h10);
            }
            boolean z4 = p0.i(q1);
            i1 i10 = p0.N();
            if(z4 || i10 == v4) {
                i10 = new i1(q1, 11);
                p0.l0(i10);
            }
            g0.a(X0.n.c(q0, false, i10), m0.c.e(1200550679, p0, new r(b01, j1, h10, s, a6, a3, a0, n0, z, a1, a2, n1, a4, z1, a5, a7)), g10, p0, 0x30);
            p0.p(false);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new rd.c(a0, n0, z, a1, a2, n1, a3, a4, z1, a5, s, a6, a7, v, v1, 1);
        }
    }

    public static final void g(q q0, boolean z, int v, l l0, int v1) {
        p p0 = (p)l0;
        p0.c0(0xA78163C9);
        int v2 = (v1 & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.h(z) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.e(v) ? 0x100 : 0x80);
        }
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            String s = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if((v2 & 0x380) == 0x100 || s == v3) {
                s = v <= -1 ? "" : Cb.k.b(context0, String.valueOf(v));
                p0.l0(s);
            }
            boolean z1 = p0.g(s);
            String s1 = p0.N();
            if((v2 & 0x70) == 0x20 || z1 || s1 == v3) {
                kotlin.jvm.internal.q.f("좋아요, %1$s명", "getString(...)");
                s1 = String.format("좋아요, %1$s명", Arrays.copyOf(new Object[]{s}, 1));
                p0.l0(s1);
            }
            q q1 = X0.n.c(androidx.compose.foundation.q.p(q0), false, S.a.f);
            boolean z2 = p0.g(s1);
            com.iloen.melon.playback.playlist.db.d d0 = p0.N();
            if(z2 || d0 == v3) {
                d0 = new com.iloen.melon.playback.playlist.db.d(s1, 21);
                p0.l0(d0);
            }
            q q2 = X0.n.b(q1, d0);
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, P0.j.f);
            w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            w.x(p0, q3, P0.j.d);
            q q4 = d.n(r0.n.a, 25.0f);
            androidx.compose.foundation.q.c(I.Q((z ? 0x7F08014B : 0x7F080148), p0, 0), null, q4, null, null, 0.0f, new y0.k(e0.T(p0, (z ? 0x7F06017A : 0x7F0604A1)), 5), p0, 0x1B0, 56);  // drawable:btn_common_like_22_on
            N1.b(s, null, A7.d.g(r0.n.a, 3.0f, p0, 0x7F0604A1, p0), 14.0f, null, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, p0, 0xC00, 0xC00, 0x1DFF2);  // color:white000e
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new rd.h(q0, z, v, v1, 0);
        }
    }

    public static final void h(a a0, n n0, boolean z, a a1, a a2, n n1, a a3, a a4, boolean z1, a a5, String s, a a6, a a7, l l0, int v, int v1) {
        b0 b02;
        m m1;
        x1.j j1;
        p p0 = (p)l0;
        p0.c0(-361989701);
        int v2 = (v & 6) == 0 ? (p0.i(a0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.i(n0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.h(z) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v2 |= (p0.i(a1) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v2 |= (p0.i(a2) ? 0x4000 : 0x2000);
        }
        if((v & 0x30000) == 0) {
            v2 |= (p0.i(n1) ? 0x20000 : 0x10000);
        }
        if((v & 0x180000) == 0) {
            v2 |= (p0.i(a3) ? 0x100000 : 0x80000);
        }
        if((v & 0xC00000) == 0) {
            v2 |= (p0.i(a4) ? 0x800000 : 0x400000);
        }
        if((v & 0x6000000) == 0) {
            v2 |= (p0.h(z1) ? 0x4000000 : 0x2000000);
        }
        if((v & 0x30000000) == 0) {
            v2 |= (p0.i(a5) ? 0x20000000 : 0x10000000);
        }
        int v3 = (v1 & 6) == 0 ? v1 | (p0.g(s) ? 4 : 2) : v1;
        if((v1 & 0x30) == 0) {
            v3 |= (p0.i(a6) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v3 |= (p0.i(a7) ? 0x100 : 0x80);
        }
        if(p0.Q(v2 & 1, (v2 & 306783379) != 306783378 || (v3 & 0x93) != 0x92)) {
            r0.n n2 = r0.n.a;
            q q0 = androidx.compose.foundation.layout.a.l(d.h(d.f(n2, 1.0f), h.t(p0, 0x7F070408)), 14.0f, 0.0f, 2);  // dimen:player_bottom_controller_height
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            P0.h h0 = P0.j.f;
            w.x(p0, y0, h0);
            P0.h h1 = P0.j.e;
            w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            P0.h h3 = P0.j.d;
            w.x(p0, q1, h3);
            q q2 = d.h(d.f(n2, 1.0f), 60.0f);
            p0.a0(-1003410150);
            p0.a0(212064437);
            p0.p(false);
            c c0 = (c)p0.k(k0.h);
            x1.q q3 = p0.N();
            V v5 = androidx.compose.runtime.k.a;
            if(q3 == v5) {
                q3 = l1.w(c0, p0);
            }
            x1.j j0 = p0.N();
            if(j0 == v5) {
                j0 = l1.u(p0);
            }
            b0 b00 = p0.N();
            if(b00 == v5) {
                b00 = w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            m m0 = p0.N();
            if(m0 == v5) {
                m0 = l1.v(j0, p0);
            }
            b0 b01 = p0.N();
            if(b01 == v5) {
                j1 = j0;
                b01 = w.r(H.a, V.c);
                p0.l0(b01);
            }
            else {
                j1 = j0;
            }
            boolean z2 = p0.i(q3);
            boolean z3 = p0.e(0x101);
            g1 g10 = p0.N();
            if(z2 || z3 || g10 == v5) {
                g10 = new g1(b01, q3, m0, 12, b00);
                m1 = m0;
                b02 = b00;
                p0.l0(g10);
            }
            else {
                m1 = m0;
                b02 = b00;
            }
            h1 h10 = p0.N();
            if(h10 == v5) {
                h10 = new h1(b02, m1, 12);
                p0.l0(h10);
            }
            boolean z4 = p0.i(q3);
            i1 i10 = p0.N();
            if(z4 || i10 == v5) {
                i10 = new i1(q3, 12);
                p0.l0(i10);
            }
            g0.a(X0.n.c(q2, false, i10), m0.c.e(1200550679, p0, new v(b01, j1, h10, a3, a0, n0, z, a1, a2, n1, a4)), g10, p0, 0x30);
            p0.p(false);
            q q4 = d.h(d.f(n2, 1.0f), 60.0f);
            M.b b0 = M.j.a;
            p0 p00 = M.n0.a(b0, r0.d.k, p0, 0x30);
            int v6 = p0.P;
            i0 i01 = p0.m();
            q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            w.x(p0, q5, h3);
            e1.x.f(null, z1, a5, p0, v2 >> 21 & 0x3F0, 1);
            q q6 = q0.a(n2, 1.0f);
            M m2 = M.p.d(r0.d.a, false);
            int v7 = p0.P;
            i0 i02 = p0.m();
            q q7 = r0.a.d(p0, q6);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m2, h0);
            w.x(p0, i02, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h2);
            }
            w.x(p0, q7, h3);
            if(s == null) {
                p0.a0(-127842201);
                e1.x.c((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n2, r0.d.e), a6, p0, v3 & 0x70);
            }
            else {
                p0.a0(0xF85988E3);
                q q8 = d.f(n2, 1.0f);
                p0 p01 = M.n0.a(b0, r0.d.j, p0, 0);
                int v8 = p0.P;
                i0 i03 = p0.m();
                q q9 = r0.a.d(p0, q8);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                w.x(p0, p01, h0);
                w.x(p0, i03, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v8)) {
                    A7.d.q(v8, p0, v8, h2);
                }
                w.x(p0, q9, h3);
                M.c.d(p0, d.q(n2, 20.0f));
                e1.x.d(q0.a(n2, 1.0f), s, a6, p0, v3 << 3 & 0x3F0);
                M.c.d(p0, d.q(n2, 20.0f));
                p0.p(true);
            }
            p0.p(false);
            p0.p(true);
            e1.x.u(a7, null, p0, v3 >> 3 & 0x70, 1);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new rd.c(a0, n0, z, a1, a2, n1, a3, a4, z1, a5, s, a6, a7, v, v1, 0);
        }
    }

    public static final void i(q q0, String s, String s1, boolean z, int v, a a0, a a1, l l0, int v1) {
        p p0 = (p)l0;
        p0.c0(0x9E0CEBB1);
        int v2 = v1 | (p0.g(q0) ? 4 : 2) | (p0.g(s) ? 0x20 : 16) | (p0.g(s1) ? 0x100 : 0x80) | (p0.h(z) ? 0x800 : 0x400) | (p0.e(v) ? 0x4000 : 0x2000) | (p0.i(a0) ? 0x20000 : 0x10000) | (p0.i(a1) ? 0x100000 : 0x80000);
        if(p0.Q(v2 & 1, (0x92493 & v2) != 0x92492)) {
            q q1 = androidx.compose.foundation.layout.a.l(d.h(d.f(q0, 1.0f), 39.0f), 24.0f, 0.0f, 2);
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, P0.j.f);
            w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q2, P0.j.d);
            x.j(new LayoutWeightElement(1.0f, true), s, s1, a0, p0, v2 >> 6 & 0x1C00 | v2 & 0x3F0);
            M.c.d(p0, d.q(r0.n.a, 8.0f));
            Cc.a0 a00 = new Cc.a0(0, 0, null, a1, true);
            x.g(r0.a.a(r0.n.a, a00), z, v, p0, v2 >> 6 & 0x3F0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new ed.n(q0, s, s1, z, v, a0, a1, v1);
        }
    }

    public static final void j(q q0, String s, String s1, a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0xE0AFBD30);
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
            M m0 = M.p.d(r0.d.a, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            P0.h h0 = P0.j.f;
            w.x(p0, m0, h0);
            P0.h h1 = P0.j.e;
            w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            P0.h h3 = P0.j.d;
            w.x(p0, q1, h3);
            r0.n n0 = r0.n.a;
            q q2 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.d);
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
            i0 i01 = p0.m();
            q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            w.x(p0, q3, h3);
            N1.b(s, null, e0.T(p0, 0x7F0604A1), 16.0f, e1.y.i, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v1 >> 3 & 14 | 0x30C00, 0xC30, 120786);  // color:white000e
            M.c.d(p0, d.h(n0, 1.0f));
            N1.b(s1, r0.a.a(n0, new Cc.a0(0, 0, null, a0, true)), e0.T(p0, 0x7F0604A1), 14.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v1 >> 6 & 14 | 0xC00, 0xC30, 0x1D7F0);  // color:white000e
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new qd.n(v, 1, s, s1, q0, a0);
        }
    }

    public static final void k(String s, a a0, boolean z, long v, n n0, String s1, String s2, a a1, l l0, int v1) {
        P0.h h5;
        rd.w w0;
        Boolean boolean1;
        M.b b1;
        V v5;
        p p0 = (p)l0;
        p0.c0(-1070717576);
        int v2 = v1 | (p0.g(s) ? 4 : 2) | (p0.i(a0) ? 0x20 : 16) | (p0.h(z) ? 0x100 : 0x80) | (p0.f(v) ? 0x800 : 0x400) | (p0.i(n0) ? 0x4000 : 0x2000) | (p0.g(s1) ? 0x20000 : 0x10000) | (p0.g(s2) ? 0x100000 : 0x80000) | (p0.i(a1) ? 0x800000 : 0x400000);
        if(p0.Q(v2 & 1, (0x492493 & v2) != 4793490)) {
            r0.n n1 = r0.n.a;
            q q0 = d.h(d.f(n1, 1.0f), h.t(p0, 0x7F070417));  // dimen:player_top_info_container_height
            r0.h h0 = r0.d.j;
            p0 p00 = M.n0.a(M.j.a, h0, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            M.b b0 = M.j.a;
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, P0.j.f);
            P0.h h1 = P0.j.e;
            w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            P0.h h3 = P0.j.f;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            P0.h h4 = P0.j.d;
            w.x(p0, q1, h4);
            b0 b00 = p0.N();
            V v4 = androidx.compose.runtime.k.a;
            if(b00 == v4) {
                b00 = w.s(Boolean.valueOf(z));
                p0.l0(b00);
            }
            Boolean boolean0 = Boolean.valueOf(z);
            Object object0 = p0.N();
            if((((v2 & 0x1C00) == 0x800 ? 1 : 0) | ((v2 & 0x380) == 0x100 ? 1 : 0)) != 0 || object0 == v4) {
                v5 = v4;
                b1 = b0;
                h5 = h3;
                boolean1 = boolean0;
                w0 = new rd.w(z, v, b00, null);
                p0.l0(w0);
            }
            else {
                v5 = v4;
                b1 = b0;
                boolean1 = boolean0;
                w0 = object0;
                h5 = h3;
            }
            J.d(p0, boolean1, w0);
            q q2 = H0.b.r(h0, d.u(n1, 3));
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
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
            w.x(p0, y0, h5);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            w.x(p0, q3, h4);
            M.c.d(p0, d.h(n1, 9.0f));
            q q4 = d.u(n1, 3);
            rd.f f0 = p0.N();
            if((v2 & 0xE000) == 0x4000 || f0 == v5) {
                f0 = new rd.f(n0, 0);
                p0.l0(f0);
            }
            q q5 = androidx.compose.ui.layout.a.d(q4, f0);
            p0 p01 = M.n0.a(b1, h0, p0, 0);
            int v7 = p0.P;
            i0 i02 = p0.m();
            q q6 = r0.a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p01, h5);
            w.x(p0, i02, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h2);
            }
            w.x(p0, q6, h4);
            if(((Boolean)b00.getValue()).booleanValue()) {
                p0.a0(0x99C60557);
                e1.x.r(r0.a.a(n1, new D(23, a0)), s, p0, 0, v2 << 3 & 0x70);
                U4.x.z(n1, 10.0f, p0, false);
            }
            else {
                p0.a0(0x98106148);
                p0.p(false);
            }
            p0.p(true);
            p0.p(true);
            q q7 = H0.b.r(h0, q0.a(n1, 1.0f));
            ld.j j0 = p0.N();
            if(j0 == v5) {
                j0 = new ld.j(25);
                p0.l0(j0);
            }
            e1.x.s(X0.n.c(q7, false, j0), s1, s2, a1, p0, v2 >> 12 & 0x1FF0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new g(s, a0, z, v, n0, s1, s2, a1, v1);
        }
    }
}

