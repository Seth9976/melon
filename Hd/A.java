package hd;

import A8.H;
import A8.L;
import Ac.e;
import Ac.r;
import Bc.i;
import Cc.C1;
import Cc.I2;
import Cc.N1;
import Cc.P;
import Cc.c1;
import Cc.e0;
import Cc.r0;
import Cc.t;
import Cc.y1;
import De.I;
import Kd.g;
import L5.c;
import M.j;
import M.p0;
import M.w;
import M.y;
import N0.M;
import P0.h;
import U4.x;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ComposeView;
import com.iloen.melon.utils.system.ScreenUtils;
import ed.D;
import ed.s;
import gd.R7;
import kotlin.jvm.internal.q;
import m0.b;
import r0.n;

public abstract class a {
    public static final b a;
    public static final int b;
    public static final int c;
    public static final int d;
    public static final int e;

    static {
        a.a = new b(-1648270382, new P(26), false);
    }

    public static final we.a a(Context context0, b b0, l l0) {
        q.g(context0, "context");
        ComposeView composeView0 = ((p)l0).N();
        V v0 = k.a;
        if(composeView0 == v0) {
            composeView0 = new ComposeView(context0, null, 6, 0);
            ((p)l0).l0(composeView0);
        }
        boolean z = ((p)l0).i(composeView0);
        R7 r70 = ((p)l0).N();
        if(z || r70 == v0) {
            r70 = new R7(6, composeView0, b0);
            ((p)l0).l0(r70);
        }
        androidx.compose.ui.viewinterop.a.a(r70, null, null, ((p)l0), 0, 6);
        boolean z1 = ((p)l0).i(composeView0);
        U u0 = ((p)l0).N();
        if(z1 || u0 == v0) {
            u0 = new U(composeView0);
            ((p)l0).l0(u0);
        }
        return u0;
    }

    public static final void b(i i0, we.a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(-1338120109);
        int v1 = v | (p0.i(i0) ? 4 : 2) | (p0.i(a0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            n n0 = n.a;
            r0.q q0 = r0.a.a(d.c(d.q(n0, 125.0f), 1.0f), new D(6, a0));
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q2 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q2, h3);
            r0.q q3 = e0.K(d.h(d.q(n0, 125.0f), 70.0f));
            r0.b.c(q3, i0.b, 70.0f, null, 0L, null, false, false, p0, 0x6000180, 0xF8);
            r0.q q4 = d.h(d.q(n0, 125.0f), 43.0f);
            r0.q q5 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q4, r0.d.g);
            androidx.compose.foundation.q.c(c.a(d5.w.B(context0, 0x7F080894), p0), null, q5, null, null, 0.0f, null, p0, 0x30, 120);  // drawable:shape_gradient_transparent_gray600e_angle90_bottom_round4
            r0.q q6 = androidx.compose.foundation.layout.a.n((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.g), 5.0f, 0.0f, 0.0f, 4.0f, 6);
            String s = Cb.k.f(i0.G);
            long v4 = e0.T(p0, 0x7F0604A1);  // color:white000e
            androidx.compose.foundation.layout.b b0 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
            N1.b(s, q6, v4, 12.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);
            if(i0.n) {
                p0.a0(1905605652);
                r0.q q7 = androidx.compose.foundation.layout.a.n(b0.a(n0, r0.d.c), 0.0f, 7.0f, 7.0f, 0.0f, 9);
                androidx.compose.foundation.q.c(I.Q(0x7F0803D4, p0, 6), null, q7, null, N0.j.g, 0.0f, null, p0, 0x6030, 104);  // drawable:ic_common_19_2
            }
            else {
                p0.a0(1899000947);
            }
            p0.p(false);
            p0.p(true);
            r0.q q8 = d.q(androidx.compose.foundation.layout.a.n(n0, 0.0f, 8.0f, 0.0f, 0.0f, 13), 125.0f);
            long v5 = e0.T(p0, 0x7F06016D);  // color:gray900s
            N1.b(i0.a, q8, v5, 15.0f, null, null, 0L, null, 0.0f, 2, false, 3, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);
            r0.q q9 = d.q(androidx.compose.foundation.layout.a.n(n0, 0.0f, 3.0f, 0.0f, 0.0f, 13), 125.0f);
            long v6 = e0.T(p0, 0x7F060160);  // color:gray600s_support_high_contrast
            N1.b(i0.m, q9, v6, 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new g0(i0, a0, v, 2);
        }
    }

    public static final void c(i i0, we.a a0, l l0, int v) {
        h h5;
        P0.i i2;
        r0 r01;
        Context context1;
        p p0 = (p)l0;
        p0.c0(0xD205AFFB);
        int v1 = v | (p0.i(i0) ? 4 : 2) | (p0.i(a0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            n n0 = n.a;
            r0.q q0 = r0.a.a(d.h(d.f(n0, 1.0f), 60.0f), new D(7, a0));
            boolean z = p0.i(context0);
            boolean z1 = p0.i(i0);
            R7 r70 = p0.N();
            V v2 = k.a;
            if(z || z1 || r70 == v2) {
                r70 = new R7(8, context0, i0);
                p0.l0(r70);
            }
            r0.q q1 = X0.n.c(q0, true, r70);
            r0.h h0 = r0.d.k;
            M.b b0 = j.a;
            p0 p00 = M.n0.a(b0, h0, p0, 0x30);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            P0.i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h1 = P0.j.f;
            androidx.compose.runtime.w.x(p0, p00, h1);
            h h2 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h2);
            h h3 = P0.j.g;
            if(p0.O) {
                context1 = context0;
                A7.d.q(v3, p0, v3, h3);
            }
            else {
                context1 = context0;
                if(!q.b(p0.N(), v3)) {
                    A7.d.q(v3, p0, v3, h3);
                }
            }
            h h4 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q2, h4);
            M m0 = M.p.d(r0.d.a, false);
            int v4 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h1);
            androidx.compose.runtime.w.x(p0, i01, h2);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h3);
            }
            androidx.compose.runtime.w.x(p0, q3, h4);
            r0 r00 = r0.b;
            r0.q q4 = e0.K(d.h(d.q(n0, 78.0f), 44.0f));
            s s0 = p0.N();
            if(s0 == v2) {
                r01 = r00;
                s0 = new s(28);
                p0.l0(s0);
            }
            else {
                r01 = r00;
            }
            r01.c(X0.n.b(q4, s0), i0.b, 44.0f, null, 0L, null, false, false, p0, 0x6000180, 0xF8);
            r0.q q5 = d.h(d.q(n0, 78.0f), 27.0f);
            r0.q q6 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q5, r0.d.g);
            androidx.compose.foundation.q.c(c.a(d5.w.B(context1, 0x7F080894), p0), null, q6, null, null, 0.0f, null, p0, 0x30, 120);  // drawable:shape_gradient_transparent_gray600e_angle90_bottom_round4
            r0.q q7 = androidx.compose.foundation.layout.a.n((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.g), 5.0f, 0.0f, 0.0f, 4.0f, 6);
            s s1 = p0.N();
            if(s1 == v2) {
                s1 = new s(29);
                p0.l0(s1);
            }
            r0.q q8 = X0.n.b(q7, s1);
            N1.b(Cb.k.f(i0.G), q8, e0.T(p0, 0x7F0604A1), 12.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);  // color:white000e
            p0.p(true);
            r0.q q9 = d.t(d.f(androidx.compose.foundation.layout.a.n(n0, 10.0f, 0.0f, 0.0f, 0.0f, 14), 1.0f), 3);
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v5 = p0.P;
            i0 i02 = p0.m();
            r0.q q10 = r0.a.d(p0, q9);
            p0.e0();
            if(p0.O) {
                i2 = i1;
                p0.l(i2);
            }
            else {
                i2 = i1;
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h1);
            androidx.compose.runtime.w.x(p0, i02, h2);
            if(!p0.O && q.b(p0.N(), v5)) {
                h5 = h3;
            }
            else {
                h5 = h3;
                A7.d.q(v5, p0, v5, h5);
            }
            androidx.compose.runtime.w.x(p0, q10, h4);
            p0 p01 = M.n0.a(b0, h0, p0, 0x30);
            int v6 = p0.P;
            i0 i03 = p0.m();
            r0.q q11 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p01, h1);
            androidx.compose.runtime.w.x(p0, i03, h2);
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h5);
            }
            androidx.compose.runtime.w.x(p0, q11, h4);
            c1.b(i0.n, false, false, false, false, false, p0, 0, 0x3FE);
            r0.q q12 = d.t(d.f(n0, 1.0f), 3);
            h0 h00 = p0.N();
            if(h00 == v2) {
                h00 = new h0(0);
                p0.l0(h00);
            }
            r0.q q13 = X0.n.b(q12, h00);
            long v7 = e0.T(p0, 0x7F06016D);  // color:gray900s
            N1.b(i0.a, q13, v7, 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);
            p0.p(true);
            r0.q q14 = d.t(d.f(androidx.compose.foundation.layout.a.n(n0, 0.0f, 2.0f, 0.0f, 0.0f, 13), 1.0f), 3);
            h0 h01 = p0.N();
            if(h01 == v2) {
                h01 = new h0(1);
                p0.l0(h01);
            }
            r0.q q15 = X0.n.b(q14, h01);
            long v8 = e0.T(p0, 0x7F060160);  // color:gray600s_support_high_contrast
            N1.b(i0.m, q15, v8, 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new g0(i0, a0, v, 1);
        }
    }

    public static final void d(i i0, we.a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x32F45A9B);
        int v1 = v | (p0.i(i0) ? 4 : 2) | (p0.i(a0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            n n0 = n.a;
            r0.q q0 = r0.a.a(d.f(n0, 1.0f), new D(8, a0));
            y y0 = w.a(j.c, r0.d.n, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q2 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q2, h3);
            r0.q q3 = e0.K(d.h(d.q(n0, 224.0f), 125.0f));
            r0.b.c(q3, i0.b, 125.0f, null, 0L, null, false, false, p0, 0x6000180, 0xF8);
            r0.q q4 = d.h(d.q(n0, 224.0f), 77.0f);
            r0.q q5 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q4, r0.d.g);
            androidx.compose.foundation.q.c(c.a(d5.w.B(context0, 0x7F080894), p0), null, q5, null, null, 0.0f, null, p0, 0x30, 120);  // drawable:shape_gradient_transparent_gray600e_angle90_bottom_round4
            r0.q q6 = androidx.compose.foundation.layout.a.n((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.g), 10.0f, 0.0f, 0.0f, 8.0f, 6);
            String s = Cb.k.f(i0.G);
            long v4 = e0.T(p0, 0x7F0604A1);  // color:white000e
            androidx.compose.foundation.layout.b b0 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
            N1.b(s, q6, v4, 12.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);
            if(i0.n) {
                p0.a0(0xD11EFE4);
                r0.q q7 = androidx.compose.foundation.layout.a.n(b0.a(n0, r0.d.c), 0.0f, 7.0f, 7.0f, 0.0f, 9);
                androidx.compose.foundation.q.c(I.Q(0x7F0803D4, p0, 6), null, q7, null, N0.j.g, 0.0f, null, p0, 0x6030, 104);  // drawable:ic_common_19_2
            }
            else {
                p0.a0(210089475);
            }
            p0.p(false);
            p0.p(true);
            r0.q q8 = d.q(androidx.compose.foundation.layout.a.n(n0, 0.0f, 8.0f, 0.0f, 0.0f, 13), 224.0f);
            long v5 = e0.T(p0, 0x7F06016D);  // color:gray900s
            l1.k k0 = new l1.k(3);
            N1.b(i0.a, q8, v5, 15.0f, null, null, 0L, k0, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D5F0);
            r0.q q9 = d.q(androidx.compose.foundation.layout.a.n(n0, 0.0f, 3.0f, 0.0f, 0.0f, 13), 224.0f);
            long v6 = e0.T(p0, 0x7F060160);  // color:gray600s_support_high_contrast
            l1.k k1 = new l1.k(3);
            N1.b(i0.m, q9, v6, 13.0f, null, null, 0L, k1, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D5F0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new g0(i0, a0, v, 0);
        }
    }

    public static final void e(r0.q q0, g g0, String s, String s1, String s2, boolean z, we.a a0, we.a a1, l l0, int v, int v1) {
        boolean z6;
        String s9;
        String s8;
        String s7;
        n n2;
        String s6;
        int v13;
        String s5;
        q.g(q0, "modifier");
        p p0 = (p)l0;
        p0.c0(0x9C1FB909);
        int v2 = ((v & 6) == 0 ? v | (p0.g(q0) ? 4 : 2) : v) | (p0.i(g0) ? 0x20 : 16) | (p0.g(s) ? 0x100 : 0x80);
        int v3 = (v1 & 8) == 0 ? v2 | (p0.g(s1) ? 0x800 : 0x400) : v2 | 0xC00;
        int v4 = (v1 & 16) == 0 ? v3 | (p0.g(s2) ? 0x4000 : 0x2000) : v3 | 0x6000;
        int v5 = (v1 & 0x20) == 0 ? v4 | (p0.h(z) ? 0x20000 : 0x10000) : v4 | 0x30000;
        int v6 = p0.i(a0) ? 0x100000 : 0x80000;
        int v7 = (p0.i(a1) ? 0x800000 : 0x400000) | (v5 | v6);
        if(p0.Q(v7 & 1, (0x492493 & v7) != 4793490)) {
            String s3 = (v1 & 8) == 0 ? s1 : "";
            String s4 = (v1 & 16) == 0 ? s2 : "";
            boolean z1 = (v1 & 0x20) == 0 ? z : false;
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            boolean z2 = g0.i;
            r0.q q1 = z2 ? q0 : e2.a.r(q0, 0.3f);
            boolean z3 = p0.i(context0);
            boolean z4 = p0.i(g0);
            t t0 = p0.N();
            V v8 = k.a;
            if(((v7 & 0x380) == 0x100 | z3 | z4) != 0 || t0 == v8) {
                t0 = new t(context0, s, g0, 1);
                p0.l0(t0);
            }
            r0.q q2 = X0.n.c(q1, true, t0);
            M.b b0 = j.a;
            p0 p00 = M.n0.a(b0, r0.d.j, p0, 0);
            int v9 = p0.P;
            i0 i00 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, p00, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v9)) {
                A7.d.q(v9, p0, v9, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q3, h3);
            r0.q q4 = d.c(n.a, 1.0f);
            n n0 = n.a;
            r0.q q5 = x.r(1.0f, q4, true);
            p0 p01 = M.n0.a(b0, r0.d.k, p0, 0x30);
            int v10 = p0.P;
            i0 i01 = p0.m();
            r0.q q6 = r0.a.d(p0, q5);
            p0.e0();
            r0.h h4 = r0.d.k;
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p01, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v10)) {
                A7.d.q(v10, p0, v10, h2);
            }
            androidx.compose.runtime.w.x(p0, q6, h3);
            r0.q q7 = androidx.compose.foundation.layout.a.n(n0, 10.0f, 0.0f, 0.0f, 0.0f, 14);
            boolean z5 = p0.i(context0);
            Cc.n n1 = p0.N();
            if(z5 || n1 == v8) {
                n1 = new Cc.n(context0, 12);
                p0.l0(n1);
            }
            c1.R(X0.n.c(q7, false, n1), g0, 0L, false, a0, p0, v7 & 0x70 | 0xE000 & v7 >> 6, 12);
            M.c.d(p0, d.c(d.q(n0, 5.0f), 1.0f));
            if(s.length() > 0) {
                p0.a0(0x9C9B1739);
                r0.q q8 = d.t(d.q(n0, 30.0f), 3);
                y y0 = w.a(j.c, r0.d.m, p0, 0);
                int v11 = p0.P;
                i0 i02 = p0.m();
                r0.q q9 = r0.a.d(p0, q8);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, y0, h0);
                androidx.compose.runtime.w.x(p0, i02, h1);
                if(p0.O || !q.b(p0.N(), v11)) {
                    A7.d.q(v11, p0, v11, h2);
                }
                androidx.compose.runtime.w.x(p0, q9, h3);
                r0.q q10 = d.t(d.f(n0, 1.0f), 3);
                h0 h00 = p0.N();
                if(h00 == v8) {
                    h00 = new h0(2);
                    p0.l0(h00);
                }
                N1.b(s, X0.n.b(q10, h00), e0.T(p0, (z1 ? 0x7F0604A1 : 0x7F06016D)), 17.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, v7 >> 6 & 14 | 0xC00, 0, 0x1FDF0);  // color:white000e
                if(s3.length() > 0) {
                    p0.a0(0x1E87C6DF);
                    M.c.d(p0, d.h(n0, 3.0f));
                    r0.q q11 = d.t(d.v(n0, null, 3), 3);
                    r0.q q12 = H0.b.q(r0.d.n, q11);
                    p0 p02 = M.n0.a(b0, h4, p0, 0x30);
                    int v12 = p0.P;
                    i0 i03 = p0.m();
                    r0.q q13 = r0.a.d(p0, q12);
                    p0.e0();
                    if(p0.O) {
                        p0.l(i0);
                    }
                    else {
                        p0.o0();
                    }
                    androidx.compose.runtime.w.x(p0, p02, h0);
                    androidx.compose.runtime.w.x(p0, i03, h1);
                    if(p0.O || !q.b(p0.N(), v12)) {
                        A7.d.q(v12, p0, v12, h2);
                    }
                    androidx.compose.runtime.w.x(p0, q13, h3);
                    switch(s3.hashCode()) {
                        case 0xA9B: {
                            s5 = s3;
                            v13 = s5.equals("UP") ? 0x7F0803DD : 0;  // drawable:ic_common_arrow_up_01
                            break;
                        }
                        case 0x12D80: {
                            s5 = s3;
                            v13 = s5.equals("NEW") ? 0x7F080402 : 0;  // drawable:ic_common_new_01
                            break;
                        }
                        case 0x201CA2: {
                            s5 = s3;
                            v13 = s5.equals("DOWN") ? 0x7F0803D8 : 0;  // drawable:ic_common_arrow_down_01
                            break;
                        }
                        case 2402104: {
                            s5 = s3;
                            v13 = s5.equals("NONE") ? 0x7F0803D9 : 0;  // drawable:ic_common_arrow_equal
                            break;
                        }
                        default: {
                            s5 = s3;
                            v13 = 0;
                        }
                    }
                    M.c.d(p0, d.q(n0, 2.0f));
                    s6 = s5;
                    androidx.compose.foundation.q.c(I.Q(v13, p0, 0), null, null, null, null, 0.0f, null, p0, 0x30, 0x7C);
                    if(s6.equals("UP") || s6.equals("DOWN")) {
                        p0.a0(1050109244);
                        M.c.d(p0, d.q(n0, 2.0f));
                        int v14 = s6.equals("UP") ? 0x7F060447 : 0x7F060046;  // color:pink600s
                        r0.q q14 = d.t(d.v(n0, null, 3), 3);
                        h0 h01 = p0.N();
                        if(h01 == v8) {
                            h01 = new h0(3);
                            p0.l0(h01);
                        }
                        n2 = n0;
                        N1.b(s4, X0.n.b(q14, h01), e0.T(p0, v14), 12.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, v7 >> 12 & 14 | 0xC00, 0, 0x1FDF0);
                        s7 = s4;
                        p0.p(false);
                    }
                    else {
                        p0.a0(1045111889);
                        p0.p(false);
                        n2 = n0;
                        s7 = s4;
                    }
                    p0.p(true);
                }
                else {
                    s7 = s4;
                    s6 = s3;
                    n2 = n0;
                    p0.a0(508397938);
                }
                p0.p(false);
                p0.p(true);
            }
            else {
                n2 = n0;
                s6 = s3;
                s7 = s4;
                p0.a0(0x9C6B7781);
            }
            p0.p(false);
            M.c.d(p0, d.c(d.q(n2, 5.0f), 1.0f));
            c1.S(d.t(d.f(n2, 1.0f), 3), g0, e0.T(p0, (z1 ? 0x7F0604A1 : 0x7F06016D)), e0.T(p0, (z1 ? 0x7F0604A1 : 0x7F060160)), false, false, false, p0, v7 & 0x70 | 6, 0, 0x1FF0);  // color:white000e
            p0.p(true);
            c1.Q(z2, false, e0.T(p0, (z1 ? 0x7F0604A1 : 0x7F06016D)), a1, null, p0, v7 >> 12 & 0x1C00 | 0x30, 16);  // color:white000e
            p0.p(true);
            s8 = s6;
            s9 = s7;
            z6 = z1;
        }
        else {
            p0.T();
            s8 = s1;
            s9 = s2;
            z6 = z;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new C1(q0, g0, s, s8, s9, z6, a0, a1, v, v1);
        }
    }

    public static final void f(L l0, we.k k0, we.a a0, l l1, int v) {
        q.g(k0, "userEvent");
        ((p)l1).c0(0xC2F03B4);
        int v1 = (v & 6) == 0 ? (((p)l1).g(l0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((p)l1).i(k0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (((p)l1).i(a0) ? 0x100 : 0x80);
        }
        if(((p)l1).Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            if(a0 == null) {
                ((p)l1).a0(0xD2F724AE);
            }
            else {
                ((p)l1).a0(0xD322B9C6);
                int v2 = ScreenUtils.INSTANCE.isHighContrastMode() ? 0x7F08018E : 0x7F08018D;  // drawable:btn_dna_download_dim
                r0.q q0 = r0.a.a(androidx.compose.foundation.layout.a.h(d.h(d.q(n.a, 34.0f), 34.0f), 0.0f, 10.0f, 1), new r(13, a0, l0, k0));
                androidx.compose.foundation.q.c(I.Q(v2, ((p)l1), 0), null, q0, null, null, 0.0f, null, ((p)l1), 0x30, 120);
            }
            ((p)l1).p(false);
        }
        else {
            ((p)l1).T();
        }
        n0 n00 = ((p)l1).t();
        if(n00 != null) {
            n00.d = new e(l0, k0, a0, v);
        }
    }

    public static final void g(r0.q q0, String s, N0.k k0, boolean z, l l0, int v, int v1) {
        boolean z5;
        int v5;
        b0 b02;
        V v4;
        Context context1;
        r0.i i0 = r0.d.e;
        q.g(q0, "modifier");
        p p0 = (p)l0;
        p0.c0(0x6DDCAC0C);
        int v2 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.g(s) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.g(k0) ? 0x100 : 0x80);
        }
        if((v1 & 8) != 0) {
            v2 |= 0xC00;
        }
        else if((v & 0xC00) == 0) {
            v2 |= (p0.h(z) ? 0x800 : 0x400);
        }
        if(p0.Q(v2 & 1, (v2 & 0x493) != 1170)) {
            boolean z1 = (v1 & 8) == 0 ? z : true;
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            b0 b00 = p0.N();
            V v3 = k.a;
            if((v2 & 0x70) == 0x20 || b00 == v3) {
                b00 = androidx.compose.runtime.w.s(null);
                p0.l0(b00);
            }
            b0 b01 = p0.N();
            if(b01 == v3) {
                b01 = androidx.compose.runtime.w.s(null);
                p0.l0(b01);
            }
            if(((y0.e)b00.getValue()) == null) {
                v4 = v3;
                if(((Drawable)b01.getValue()) == null) {
                    b02 = b00;
                    v5 = v2 & 0x70;
                    p0.a0(-1025226377);
                    M m0 = M.p.d(r0.d.a, false);
                    int v6 = p0.P;
                    i0 i00 = p0.m();
                    r0.q q1 = r0.a.d(p0, q0);
                    P0.k.y.getClass();
                    P0.i i1 = P0.j.b;
                    p0.e0();
                    if(p0.O) {
                        p0.l(i1);
                    }
                    else {
                        p0.o0();
                    }
                    androidx.compose.runtime.w.x(p0, m0, P0.j.f);
                    androidx.compose.runtime.w.x(p0, i00, P0.j.e);
                    h h0 = P0.j.g;
                    if(p0.O || !q.b(p0.N(), v6)) {
                        A7.d.q(v6, p0, v6, h0);
                    }
                    androidx.compose.runtime.w.x(p0, q1, P0.j.d);
                    if(z1) {
                        p0.a0(0xD7629FE3);
                        r0.q q2 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n.a, i0);
                        androidx.compose.foundation.q.c(I.Q(0x7F08078D, p0, 6), null, q2, null, null, 0.0f, null, p0, 0x30, 120);  // drawable:noimage_logo_small
                    }
                    else {
                        p0.a0(0xD6EBEB0C);
                    }
                    p0.p(false);
                    p0.p(true);
                }
                else {
                    p0.a0(0xC2E1FE0A);
                    b02 = b00;
                    v5 = v2 & 0x70;
                    c1.n(q0, ((Drawable)b01.getValue()), null, k0, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, v2 << 3 & 0x1C00 | v2 & 14, 0, 0x7FF4);
                }
                p0.p(false);
                context1 = context0;
            }
            else {
                p0.a0(-1025581854);
                y0.e e0 = (y0.e)b00.getValue();
                q.d(e0);
                boolean z2 = p0.g(e0);
                C0.a a0 = p0.N();
                if(z2 || a0 == v3) {
                    a0 = com.google.firebase.b.b(e0, 1);
                    p0.l0(a0);
                }
                context1 = context0;
                v4 = v3;
                androidx.compose.foundation.q.c(a0, null, q0, i0, k0, 1.0f, null, p0, (v2 << 6 & 0xE000 | (v2 << 6 & 0x380 | 0x30)) & 0x3FFFF0, 0);
                p0.p(false);
                b02 = b00;
                v5 = v2 & 0x70;
            }
            boolean z3 = p0.i(context1);
            boolean z4 = p0.g(b02);
            W w0 = p0.N();
            if((z3 | v5 == 0x20 | z4) != 0 || w0 == v4) {
                W w1 = new W(context1, s, b02, b01, null);
                p0.l0(w1);
                w0 = w1;
            }
            J.d(p0, s, w0);
            z5 = z1;
        }
        else {
            p0.T();
            z5 = z;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Cc.q(q0, s, k0, z5, v, v1);
        }
    }

    public static final void h(L l0, H h0, String s, String s1, y0.s s2, boolean z, boolean z1, we.k k0, we.a a0, l l1, int v, int v1) {
        boolean z6;
        y0.s s5;
        boolean z5;
        boolean z4;
        n n1;
        h h8;
        h h7;
        P0.i i1;
        int v4;
        h h6;
        h h5;
        y0.s s4;
        q.g(s, "title");
        q.g(k0, "userEvent");
        p p0 = (p)l1;
        p0.c0(-1260148454);
        int v2 = (v & 6) == 0 ? (p0.g(l0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.g(h0) ? 0x20 : 16);
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
            v2 |= (p0.g(s2) ? 0x4000 : 0x2000);
        }
        if((v1 & 0x20) != 0) {
            v2 |= 0x30000;
        }
        else if((0x30000 & v) == 0) {
            v2 |= (p0.h(z) ? 0x20000 : 0x10000);
        }
        if((v1 & 0x40) != 0) {
            v2 |= 0x180000;
        }
        else if((0x180000 & v) == 0) {
            v2 |= (p0.h(z1) ? 0x100000 : 0x80000);
        }
        if((v & 0xC00000) == 0) {
            v2 |= (p0.i(k0) ? 0x800000 : 0x400000);
        }
        if((v & 0x6000000) == 0) {
            v2 |= (p0.i(a0) ? 0x4000000 : 0x2000000);
        }
        if(p0.Q(v2 & 1, (v2 & 0x2492493) != 0x2492492)) {
            y0.s s3 = (v1 & 16) == 0 ? s2 : null;
            boolean z2 = (v1 & 0x20) == 0 ? z : true;
            boolean z3 = (v1 & 0x40) == 0 ? z1 : true;
            n n0 = n.a;
            r0.q q0 = d5.n.o(d.h(d.q(n0, 300.0f), 375.0f), T.e.b(4.0f));
            M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h1 = P0.j.f;
            androidx.compose.runtime.w.x(p0, m0, h1);
            h h2 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h2);
            h h3 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h3);
            }
            h h4 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h4);
            if(Cb.i.l(s1)) {
                p0.a0(1695710824);
                s4 = s3;
                h5 = h3;
                h6 = h4;
                v4 = z2 ? 0x7F06016A : 0x7F0604A1;  // color:gray900e
                i1 = i0;
                h7 = h1;
                h8 = h2;
                n1 = n0;
                c1.n(d.c, s1, null, N0.j.c, Cb.i.l(s1), 0, null, null, null, 0.0f, null, 0, 0, false, z3, p0, v2 >> 6 & 0x70 | 0xC06, v2 >> 6 & 0xE000, 0x3FE4);
                z4 = z3;
            }
            else {
                h6 = h4;
                s4 = s3;
                v4 = z2 ? 0x7F06016A : 0x7F0604A1;  // color:gray900e
                h7 = h1;
                h8 = h2;
                h5 = h3;
                i1 = i0;
                z4 = z3;
                n1 = n0;
                p0.a0(0x64C50EA2);
            }
            p0.p(false);
            if(Cb.i.l(s4)) {
                p0.a0(1696020638);
                q.d(s4);
                M.p.a(androidx.compose.foundation.q.f(d.c, s4.a, y0.M.a), p0, 0);
            }
            else {
                p0.a0(0x64C50EA2);
            }
            p0.p(false);
            r0.q q2 = d.t(d.f(n1, 1.0f), 3);
            p0 p00 = M.n0.a(j.a, r0.d.j, p0, 0);
            int v5 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h7);
            androidx.compose.runtime.w.x(p0, i01, h8);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h5);
            }
            androidx.compose.runtime.w.x(p0, q3, h6);
            M.c.d(p0, d.q(n1, 20.0f));
            N1.b(s, x.r(1.0f, androidx.compose.foundation.layout.a.n(n1, 0.0f, 26.0f, 0.0f, 0.0f, 13), true), e0.T(p0, v4), 15.0f, e1.y.i, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v2 >> 6 & 14 | 0x30C00, 0xC30, 0x1D7D0);
            M.c.d(p0, d.q(n1, 10.0f));
            a.f(l0, k0, a0, p0, v2 & 14 | v2 >> 18 & 0x70 | v2 >> 18 & 0x380);
            M.c.d(p0, d.q(n1, 8.0f));
            a.i(l0, h0, k0, a0, p0, v2 >> 15 & 0x1C00 | (v2 & 0x7E | v2 >> 15 & 0x380));
            M.c.d(p0, d.q(n1, 10.0f));
            p0.p(true);
            p0.p(true);
            z5 = z4;
            s5 = s4;
            z6 = z2;
        }
        else {
            p0.T();
            s5 = s2;
            z6 = z;
            z5 = z1;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new y1(l0, h0, s, s1, s5, z6, z5, k0, a0, v, v1);
        }
    }

    public static final void i(L l0, H h0, we.k k0, we.a a0, l l1, int v) {
        q.g(k0, "userEvent");
        ((p)l1).c0(0x2373A1F6);
        int v1 = (v & 6) == 0 ? (((p)l1).g(l0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((p)l1).g(h0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (((p)l1).i(k0) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v1 |= (((p)l1).i(a0) ? 0x800 : 0x400);
        }
        if(((p)l1).Q(v1 & 1, (v1 & 0x493) != 1170)) {
            if(a0 == null) {
                ((p)l1).a0(0x8D17140C);
            }
            else {
                ((p)l1).a0(0x8D4FC712);
                int v2 = ScreenUtils.INSTANCE.isHighContrastMode() ? 0x7F080192 : 0x7F080191;  // drawable:btn_dna_share_dim
                r0.q q0 = r0.a.a(androidx.compose.foundation.layout.a.h(d.h(d.q(n.a, 34.0f), 34.0f), 0.0f, 10.0f, 1), new hd.y(k0, a0, l0, h0));
                androidx.compose.foundation.q.c(I.Q(v2, ((p)l1), 0), null, q0, null, null, 0.0f, null, ((p)l1), 0x30, 120);
            }
            ((p)l1).p(false);
        }
        else {
            ((p)l1).T();
        }
        n0 n00 = ((p)l1).t();
        if(n00 != null) {
            n00.d = new I2(l0, h0, k0, a0, v, 3);
        }
    }
}

