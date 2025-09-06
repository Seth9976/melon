package Vc;

import Ac.i2;
import Bd.e;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import Cc.m3;
import Cc.t0;
import F.S;
import F.X;
import F.Y;
import G.f;
import M.n0;
import M.p0;
import M.y;
import N0.M;
import N0.j;
import P0.h;
import P0.r;
import Q0.k0;
import U4.x;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.airbnb.lottie.compose.AnimateLottieCompositionAsStateKt;
import com.airbnb.lottie.compose.LottieAnimationKt;
import com.airbnb.lottie.compose.LottieAnimationState;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec.RawRes;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import com.iloen.melon.custom.l1;
import com.melon.playlist.mixup.DjMalrangInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import je.w;
import kotlinx.coroutines.flow.StateFlow;
import pc.b;
import r0.n;
import r0.q;
import r1.c;
import wc.u;
import we.a;

public abstract class i {
    public static final void a(DjMalrangInfo djMalrangInfo0, List list0, b b0, boolean z, boolean z1, a a0, a a1, a a2, l l0, int v) {
        g g0;
        int v8;
        w w0;
        u u1;
        b0 b011;
        b0 b010;
        b0 b09;
        b0 b08;
        b0 b07;
        b0 b06;
        b0 b05;
        N0.i i0 = j.b;
        p p0 = (p)l0;
        p0.c0(0x25AF4FE5);
        int v1 = v | (p0.g(djMalrangInfo0) ? 4 : 2) | (p0.i(list0) ? 0x20 : 16) | (p0.e((b0 == null ? -1 : b0.ordinal())) ? 0x100 : 0x80) | (p0.h(z) ? 0x800 : 0x400) | (p0.h(z1) ? 0x4000 : 0x2000) | (p0.i(a0) ? 0x20000 : 0x10000) | (p0.i(a1) ? 0x100000 : 0x80000) | (p0.i(a2) ? 0x800000 : 0x400000);
        if(p0.Q(v1 & 1, (0x492493 & v1) != 4793490)) {
            c c0 = (c)p0.k(k0.h);
            p0.p p1 = p0.N();
            V v2 = k.a;
            if(p1 == v2) {
                p1 = new p0.p();
                p0.l0(p1);
            }
            b0 b00 = p0.N();
            if(b00 == v2) {
                b00 = androidx.compose.runtime.w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            b0 b01 = p0.N();
            if(b01 == v2) {
                b01 = androidx.compose.runtime.w.s(Boolean.FALSE);
                p0.l0(b01);
            }
            b0 b02 = p0.N();
            if(b02 == v2) {
                b02 = androidx.compose.runtime.w.s("");
                p0.l0(b02);
            }
            b0 b03 = p0.N();
            if(b03 == v2) {
                b03 = androidx.compose.runtime.w.s("");
                p0.l0(b03);
            }
            b0 b04 = p0.N();
            if(b04 == v2) {
                b04 = androidx.compose.runtime.w.s("");
                p0.l0(b04);
            }
            if(djMalrangInfo0 == null) {
                b09 = b04;
                b05 = b00;
                b011 = b02;
                b06 = b01;
                b010 = b03;
                v8 = 0;
                p0.a0(0x6B65B0BD);
                p0.p(false);
            }
            else {
                p0.a0(0x6C527311);
                FillElement fillElement0 = d.c;
                b05 = b00;
                Bc.d d0 = p0.N();
                if((v1 & 0x1C00000) == 0x800000 || d0 == v2) {
                    d0 = new Bc.d(11, a2);
                    p0.l0(d0);
                }
                q q0 = m3.b(fillElement0, d0);
                r0.i i1 = r0.d.a;
                b06 = b01;
                M m0 = M.p.d(i1, false);
                int v3 = p0.P;
                i0 i00 = p0.m();
                q q1 = r0.a.d(p0, q0);
                P0.k.y.getClass();
                P0.i i2 = P0.j.b;
                p0.e0();
                if(p0.O) {
                    p0.l(i2);
                }
                else {
                    p0.o0();
                }
                h h0 = P0.j.f;
                androidx.compose.runtime.w.x(p0, m0, h0);
                h h1 = P0.j.e;
                androidx.compose.runtime.w.x(p0, i00, h1);
                h h2 = P0.j.g;
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                    A7.d.q(v3, p0, v3, h2);
                }
                h h3 = P0.j.d;
                androidx.compose.runtime.w.x(p0, q1, h3);
                c1.n(fillElement0, (b0 == null ? null : x1.a.A(b0)), null, i0, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x6C06, 0, 0x7FE4);
                u u0 = y0.M.a;
                if(z1) {
                    p0.a0(0xF09D3C7);
                    b07 = b03;
                    b08 = b04;
                    M.c.d(p0, androidx.compose.foundation.q.f(fillElement0, e0.T(p0, 0x7F060181), u0));  // color:hc_gray001e
                }
                else {
                    b07 = b03;
                    b08 = b04;
                    p0.a0(0xE1A7D9C);
                }
                p0.p(false);
                y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
                int v4 = p0.P;
                i0 i01 = p0.m();
                q q2 = r0.a.d(p0, fillElement0);
                p0.e0();
                if(p0.O) {
                    p0.l(i2);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, y0, h0);
                androidx.compose.runtime.w.x(p0, i01, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                    A7.d.q(v4, p0, v4, h2);
                }
                androidx.compose.runtime.w.x(p0, q2, h3);
                i.d(true, p0, 6);
                q q3 = androidx.compose.foundation.layout.a.n(d.f(n.a, 1.0f), 20.0f, 0.0f, 20.0f, 0.0f, 10);
                n n0 = n.a;
                q q4 = x.r(1.0f, q3, true);
                y y1 = M.w.a(M.j.e, r0.d.n, p0, 54);
                int v5 = p0.P;
                i0 i02 = p0.m();
                q q5 = r0.a.d(p0, q4);
                p0.e0();
                if(p0.O) {
                    p0.l(i2);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, y1, h0);
                androidx.compose.runtime.w.x(p0, i02, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                    A7.d.q(v5, p0, v5, h2);
                }
                androidx.compose.runtime.w.x(p0, q5, h3);
                boolean z2 = ((Boolean)b05.getValue()).booleanValue() || z;
                boolean z3 = p0.g(c0);
                Vc.c c1 = p0.N();
                if(z3 || c1 == v2) {
                    c1 = new Vc.c(c0, 0);
                    p0.l0(c1);
                }
                X x0 = S.h(c1);
                Ma.k k0 = p0.N();
                if(k0 == v2) {
                    k0 = new Ma.k(21);
                    p0.l0(k0);
                }
                X x1 = x0.a(S.b(f.o(k0), 2));
                Y y2 = Y.b;
                androidx.compose.animation.b.d(z2, null, x1, y2, null, m0.c.e(0xBF8AC9CA, p0, new e(p1, 12)), p0, 0x30000, 18);
                q q6 = d.h(n0, 26.0f);
                M m1 = M.p.d(i1, false);
                int v6 = p0.P;
                i0 i03 = p0.m();
                q q7 = r0.a.d(p0, q6);
                p0.e0();
                if(p0.O) {
                    p0.l(i2);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, m1, h0);
                androidx.compose.runtime.w.x(p0, i03, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                    A7.d.q(v6, p0, v6, h2);
                }
                androidx.compose.runtime.w.x(p0, q7, h3);
                q q8 = d.h(n0, 20.0f);
                boolean z4 = ((Boolean)b06.getValue()).booleanValue() || z;
                boolean z5 = p0.g(c0);
                Vc.c c2 = p0.N();
                if(z5 || c2 == v2) {
                    c2 = new Vc.c(c0, 1);
                    p0.l0(c2);
                }
                X x2 = S.h(c2);
                Ma.k k1 = p0.N();
                if(k1 == v2) {
                    k1 = new Ma.k(22);
                    p0.l0(k1);
                }
                b09 = b08;
                b010 = b07;
                b011 = b02;
                androidx.compose.animation.b.d(z4, q8, x2.a(S.b(f.o(k1), 2)), y2, null, m0.c.e(0xED36EF50, p0, new i2(b09, b010, b011, 3)), p0, 0x30030, 16);
                p0.p(true);
                p0.p(true);
                if(list0 == null) {
                    p0.a0(0xD7FB497);
                    p0.p(false);
                    u1 = u0;
                    w0 = null;
                }
                else {
                    p0.a0(0xD7FB498);
                    ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
                    for(Object object0: list0) {
                        arrayList0.add(new Ec.a(((String)object0), androidx.compose.foundation.q.f(e0.L(d.n(n0, 82.0f), 0x7F0604AE), e0.T(p0, 0x7F060144), u0), 0x7F08078C, 4));  // color:white120e
                    }
                    u1 = u0;
                    p0.p(false);
                    w0 = arrayList0;
                }
                if(w0 == null) {
                    w0 = w.a;
                }
                com.google.firebase.b.a(null, w0, 0L, 0.0f, 11.0f, p0, 0x30000, 29);
                M.c.d(p0, d.h(n0, 16.0f));
                q q9 = r0.a.a(d.h(d.f(androidx.compose.foundation.q.f(e0.L(androidx.compose.foundation.layout.a.l(n0, 15.0f, 0.0f, 2), 0x7F0604AE), e0.T(p0, 0x7F0604A1), u1), 1.0f), 44.0f), new Lc.c(11, a0));  // color:white120e
                p0 p00 = n0.a(M.j.e, r0.d.k, p0, 54);
                int v7 = p0.P;
                i0 i04 = p0.m();
                q q10 = r0.a.d(p0, q9);
                P0.k.y.getClass();
                P0.i i3 = P0.j.b;
                p0.e0();
                if(p0.O) {
                    p0.l(i3);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, p00, P0.j.f);
                androidx.compose.runtime.w.x(p0, i04, P0.j.e);
                h h4 = P0.j.g;
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v7)) {
                    A7.d.q(v7, p0, v7, h4);
                }
                androidx.compose.runtime.w.x(p0, q10, P0.j.d);
                c1.n(d.o(n0, 25.0f, 15.0f), 0x7F080156, null, i0, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0xC36, 0, 0x7FF4);  // drawable:btn_common_mixup_24
                N1.b(l1.s(n0, 6.0f, p0, 0x7F13032F, p0), null, e0.T(p0, 0x7F06002F), 15.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD2);  // string:dj_malrang_play_button_text_2 "다른 추천 듣기"
                l1.y(p0, true, n0, 15.0f, p0);
                v8 = 0;
                A7.d.s(p0, true, true, false);
            }
            if((v1 & 0x380000) == 0x100000) {
                v8 = 1;
            }
            Object object1 = p0.N();
            if((((v1 & 0x1C00) == 0x800 ? 1 : 0) | ((v1 & 14) == 4 ? 1 : 0) | v8) != 0 || object1 == v2) {
                g0 = new g(b06, b05, p1, z, djMalrangInfo0, b011, b010, b09, a1, null);
                p0.l0(g0);
            }
            else {
                g0 = object1;
            }
            J.d(p0, djMalrangInfo0, g0);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Vc.e(djMalrangInfo0, list0, b0, z, z1, a0, a1, a2, v);
        }
    }

    public static final void b(Vc.j j0, StateFlow stateFlow0, StateFlow stateFlow1, StateFlow stateFlow2, StateFlow stateFlow3, l l0, int v) {
        kotlin.jvm.internal.q.g(j0, "uiState");
        kotlin.jvm.internal.q.g(stateFlow0, "mixUpInfoFlow");
        kotlin.jvm.internal.q.g(stateFlow1, "isDjMalrangModeFlow");
        kotlin.jvm.internal.q.g(stateFlow2, "albumImageUrlsFlow");
        kotlin.jvm.internal.q.g(stateFlow3, "isDjMalrangAnimationFlow");
        p p0 = (p)l0;
        p0.c0(230800723);
        int v1 = v | (p0.i(j0) ? 4 : 2) | (p0.i(stateFlow0) ? 0x20 : 16) | (p0.i(stateFlow1) ? 0x100 : 0x80) | (p0.i(stateFlow2) ? 0x800 : 0x400) | (p0.i(stateFlow3) ? 0x4000 : 0x2000);
        if(p0.Q(v1 & 1, (v1 & 9363) != 9362)) {
            List list0 = (List)B.a.r(stateFlow2, p0, v1 >> 9 & 14).getValue();
            pc.c c0 = (pc.c)B.a.r(stateFlow0, p0, v1 >> 3 & 14).getValue();
            boolean z = ((Boolean)B.a.r(stateFlow1, p0, v1 >> 6 & 14).getValue()).booleanValue();
            boolean z1 = ((Boolean)B.a.r(stateFlow3, p0, v1 >> 12 & 14).getValue()).booleanValue();
            q q0 = r0.a.a(e0.M(androidx.compose.foundation.layout.a.l(d.f(d.h(n.a, 320.0f), 1.0f), 20.0f, 0.0f, 2), 0x7F06048A, 8.0f), new Ac.X(j0, 20));  // color:transparent
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
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
            androidx.compose.runtime.w.x(p0, y0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            V v3 = k.a;
            if(!z || !(c0 instanceof DjMalrangInfo)) {
                p0.a0(752301654);
                String s = j0.b;
                String s1 = j0.c;
                List list1 = j0.e;
                b b1 = j0.d;
                String s2 = j0.a;
                boolean z8 = j0.g;
                boolean z9 = p0.i(j0);
                Vc.d d1 = p0.N();
                if(z9 || d1 == v3) {
                    d1 = new Vc.d(j0, 1);
                    p0.l0(d1);
                }
                boolean z10 = p0.i(j0);
                Vc.d d2 = p0.N();
                if(z10 || d2 == v3) {
                    d2 = new Vc.d(j0, 2);
                    p0.l0(d2);
                }
                boolean z11 = p0.i(j0);
                Vc.d d3 = p0.N();
                if(z11 || d3 == v3) {
                    d3 = new Vc.d(j0, 3);
                    p0.l0(d3);
                }
                i.c(s2, s, s1, list1, b1, z1, z8, d1, d2, d3, p0, 0);
            }
            else {
                p0.a0(751495809);
                b b0 = ((DjMalrangInfo)c0).i;
                boolean z2 = j0.g;
                boolean z3 = p0.i(j0);
                boolean z4 = p0.i(c0);
                Vc.a a0 = p0.N();
                if(z3 || z4 || a0 == v3) {
                    a0 = new Vc.a(j0, ((DjMalrangInfo)c0), 0);
                    p0.l0(a0);
                }
                boolean z5 = p0.i(j0);
                Vc.d d0 = p0.N();
                if(z5 || d0 == v3) {
                    d0 = new Vc.d(j0, 0);
                    p0.l0(d0);
                }
                boolean z6 = p0.i(j0);
                boolean z7 = p0.i(c0);
                Vc.a a1 = p0.N();
                if(z6 || z7 || a1 == v3) {
                    a1 = new Vc.a(j0, ((DjMalrangInfo)c0), 1);
                    p0.l0(a1);
                }
                i.a(((DjMalrangInfo)c0), list0, b0, z1, z2, a0, d0, a1, p0, 0);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new t0(j0, stateFlow0, stateFlow1, stateFlow2, stateFlow3, v, 2);
        }
    }

    public static final void c(String s, String s1, String s2, List list0, b b0, boolean z, boolean z1, a a0, a a1, a a2, l l0, int v) {
        int v17;
        p p3;
        u u4;
        Ec.a a5;
        V v14;
        u u3;
        Ec.a a3;
        w w0;
        u u2;
        V v12;
        V v10;
        h h4;
        FillElement fillElement1;
        N0.i i0 = j.b;
        r0.i i1 = r0.d.a;
        ((p)l0).c0(0xEED32FB0);
        int v1 = v | (((p)l0).g(s) ? 4 : 2) | (((p)l0).g(s1) ? 0x20 : 16) | (((p)l0).g(s2) ? 0x100 : 0x80) | (((p)l0).i(list0) ? 0x800 : 0x400) | (((p)l0).e((b0 == null ? -1 : b0.ordinal())) ? 0x4000 : 0x2000) | (((p)l0).h(z) ? 0x20000 : 0x10000) | (((p)l0).h(z1) ? 0x100000 : 0x80000) | (((p)l0).i(a0) ? 0x800000 : 0x400000) | (((p)l0).i(a1) ? 0x4000000 : 0x2000000) | (((p)l0).i(a2) ? 0x20000000 : 0x10000000);
        if(((p)l0).Q(v1 & 1, (v1 & 306783379) != 306783378)) {
            ((p)l0).V();
            if((v & 1) != 0 && !((p)l0).B()) {
                ((p)l0).T();
            }
            ((p)l0).q();
            LottieCompositionResult lottieCompositionResult0 = RememberLottieCompositionKt.rememberLottieComposition(RawRes.box-impl(0x7F120011), null, null, null, null, null, ((p)l0), 6, 62);  // raw:ic_malang_start_motion_1
            LottieCompositionResult lottieCompositionResult1 = RememberLottieCompositionKt.rememberLottieComposition(RawRes.box-impl(0x7F120012), null, null, null, null, null, ((p)l0), 6, 62);  // raw:ic_malang_start_motion_2
            LottieAnimationState lottieAnimationState0 = AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState(lottieCompositionResult0.getValue(), false, false, false, null, 0.0f, 0, null, false, false, ((p)l0), 0, 0x3FE);
            p p0 = (p)l0;
            c c0 = (c)p0.k(k0.h);
            p0.p p1 = p0.N();
            V v2 = k.a;
            if(p1 == v2) {
                p1 = new p0.p();
                p0.l0(p1);
            }
            p0.p p2 = p0.N();
            if(p2 == v2) {
                p2 = new p0.p();
                p0.l0(p2);
            }
            FillElement fillElement0 = d.c;
            Bc.d d0 = p0.N();
            if((v1 & 0x70000000) == 0x20000000 || d0 == v2) {
                d0 = new Bc.d(12, a2);
                p0.l0(d0);
            }
            q q0 = m3.b(fillElement0, d0);
            M m0 = M.p.d(i1, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i2 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, m0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O) {
                fillElement1 = fillElement0;
                A7.d.q(v3, p0, v3, h2);
            }
            else {
                fillElement1 = fillElement0;
                if(!kotlin.jvm.internal.q.b(p0.N(), v3)) {
                    A7.d.q(v3, p0, v3, h2);
                }
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            c1.n(fillElement1, (b0 == null ? null : x1.a.A(b0)), null, i0, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x6C06, 0, 0x7FE4);
            u u0 = y0.M.a;
            if(z1) {
                p0.a0(697002619);
                h4 = h3;
                M.c.d(p0, androidx.compose.foundation.q.f(fillElement1, e0.T(p0, 0x7F060181), u0));  // color:hc_gray001e
            }
            else {
                h4 = h3;
                p0.a0(0x29168438);
            }
            p0.p(false);
            n n0 = n.a;
            q q2 = d.f(n0, 1.0f);
            r0.g g0 = r0.d.n;
            y y0 = M.w.a(M.j.c, g0, p0, 0x30);
            int v4 = p0.P;
            i0 i01 = p0.m();
            q q3 = r0.a.d(p0, q2);
            p0.e0();
            u u1 = u0;
            if(p0.O) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h4);
            q q4 = d.f(n0, 1.0f);
            M m1 = M.p.d(i1, false);
            int v5 = p0.P;
            i0 i02 = p0.m();
            q q5 = r0.a.d(p0, q4);
            p0.e0();
            V v6 = v2;
            if(p0.O) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m1, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            androidx.compose.runtime.w.x(p0, q5, h4);
            i.d(false, p0, 6);
            p0.p(true);
            q q6 = x.r(1.0f, androidx.compose.foundation.layout.a.n(d.f(n0, 1.0f), 20.0f, 88.0f, 20.0f, 0.0f, 8), true);
            y y1 = M.w.a(M.j.d, g0, p0, 54);
            int v7 = p0.P;
            i0 i03 = p0.m();
            q q7 = r0.a.d(p0, q6);
            p0.e0();
            if(p0.O) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y1, h0);
            androidx.compose.runtime.w.x(p0, i03, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h2);
            }
            androidx.compose.runtime.w.x(p0, q7, h4);
            p0.a0(0xE370D0BF);
            ListIterator listIterator0 = p1.listIterator();
            int v8 = 0;
            while(((r)listIterator0).hasNext()) {
                Object object0 = ((r)listIterator0).next();
                if(v8 >= 0) {
                    q q8 = d.h(n0, 21.0f);
                    M m2 = M.p.d(i1, false);
                    int v9 = p0.P;
                    i0 i04 = p0.m();
                    q q9 = r0.a.d(p0, q8);
                    P0.k.y.getClass();
                    P0.i i3 = P0.j.b;
                    p0.e0();
                    if(p0.O) {
                        p0.l(i3);
                    }
                    else {
                        p0.o0();
                    }
                    androidx.compose.runtime.w.x(p0, m2, P0.j.f);
                    androidx.compose.runtime.w.x(p0, i04, P0.j.e);
                    h h5 = P0.j.g;
                    if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v9)) {
                        A7.d.q(v9, p0, v9, h5);
                    }
                    androidx.compose.runtime.w.x(p0, q9, P0.j.d);
                    Boolean boolean0 = v8 < 0 || v8 >= p2.size() ? Boolean.FALSE : p2.get(v8);
                    boolean z2 = boolean0.booleanValue() && ((double)lottieAnimationState0.getProgress()) > 0.3 || z;
                    boolean z3 = p0.g(c0);
                    Vc.c c1 = p0.N();
                    if(z3) {
                        v10 = v6;
                        c1 = new Vc.c(c0, 2);
                        p0.l0(c1);
                    }
                    else {
                        v10 = v6;
                        if(c1 == v10) {
                            c1 = new Vc.c(c0, 2);
                            p0.l0(c1);
                        }
                    }
                    X x0 = S.h(c1);
                    Ma.k k0 = p0.N();
                    if(k0 == v10) {
                        k0 = new Ma.k(23);
                        p0.l0(k0);
                    }
                    X x1 = x0.a(S.b(f.o(k0), 2));
                    Ma.k k1 = p0.N();
                    if(k1 == v10) {
                        k1 = new Ma.k(20);
                        p0.l0(k1);
                    }
                    androidx.compose.animation.b.d(z2, null, x1, S.c(f.o(k1), 2), null, m0.c.e(-358357062, p0, new e(((String)object0), 11)), p0, 0x30C00, 18);
                    p0.p(true);
                    M.c.d(p0, d.h(n0, 4.0f));
                    v6 = v10;
                    ++v8;
                    continue;
                }
                e.k.O();
                throw null;
            }
            V v11 = v6;
            p0.p(false);
            p0.p(true);
            M.c.d(p0, d.h(n0, 25.0f));
            if(list0 == null) {
                p0.a0(0x530FFAB9);
                p0.p(false);
                v12 = v11;
                u2 = u1;
                w0 = null;
            }
            else {
                p0.a0(0x530FFABA);
                ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
                int v13 = 0;
                for(Object object1: list0) {
                    if(v13 >= 0) {
                        switch(v13 % 3) {
                            case 0: {
                                u4 = u1;
                                p0.a0(0x50DEDD8C);
                                v14 = v11;
                                a5 = new Ec.a(((String)object1), androidx.compose.foundation.q.f(e0.L(d.n(n0, 50.0f), 0x7F0604AE), e0.T(p0, 0x7F060144), u4), 0x7F08078C, 4);  // color:white120e
                                p0.p(false);
                                break;
                            }
                            case 1: {
                                u4 = u1;
                                p0.a0(0x50E57769);
                                q q11 = d.n(n0, 50.0f);
                                kotlin.jvm.internal.q.g(q11, "<this>");
                                Ec.a a6 = new Ec.a(((String)object1), androidx.compose.foundation.q.f(r0.a.a(q11, new Cc.S(0x7F0604AE, 1)), e0.T(p0, 0x7F060144), u4), 0x7F08079D, 4);  // color:white120e
                                p0.p(false);
                                v14 = v11;
                                a5 = a6;
                                break;
                            }
                            default: {
                                p0.a0(0x50EC5E88);
                                if(((String)object1) == null || ((String)object1).length() == 0) {
                                    p0.a0(0x50ED1ED4);
                                    q q10 = d.n(n0, 50.0f);
                                    kotlin.jvm.internal.q.g(q10, "<this>");
                                    u3 = u1;
                                    Ec.a a4 = new Ec.a(((String)object1), androidx.compose.foundation.q.f(r0.a.a(q10, new Cc.S(0x7F0604AE, 1)), e0.T(p0, 0x7F060144), u3), 0x7F08078C, 4);  // color:white120e
                                    p0.p(false);
                                    a3 = a4;
                                }
                                else {
                                    p0.a0(0x50F509B2);
                                    p0.p(false);
                                    a3 = new Ec.a(((String)object1), d.n(n0, 50.0f), 0, 12);
                                    u3 = u1;
                                }
                                p0.p(false);
                                v14 = v11;
                                a5 = a3;
                                u4 = u3;
                            }
                        }
                        arrayList0.add(a5);
                        u1 = u4;
                        ++v13;
                        v11 = v14;
                        continue;
                    }
                    e.k.O();
                    throw null;
                }
                v12 = v11;
                u2 = u1;
                p0.p(false);
                w0 = arrayList0;
            }
            if(w0 == null) {
                w0 = w.a;
            }
            com.google.firebase.b.a(null, w0, 0L, 0.0f, 0.0f, p0, 0, 61);
            M.c.d(p0, d.h(n0, 16.0f));
            q q12 = r0.a.a(d.h(d.f(androidx.compose.foundation.q.f(e0.L(androidx.compose.foundation.layout.a.l(n0, 15.0f, 0.0f, 2), 0x7F0604AE), e0.T(p0, 0x7F0604A1), u2), 1.0f), 44.0f), new Lc.c(12, a0));  // color:white120e
            p0 p00 = n0.a(M.j.e, r0.d.k, p0, 54);
            int v15 = p0.P;
            i0 i05 = p0.m();
            q q13 = r0.a.d(p0, q12);
            P0.k.y.getClass();
            P0.i i4 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i4);
            }
            else {
                p0.o0();
            }
            h h6 = P0.j.f;
            androidx.compose.runtime.w.x(p0, p00, h6);
            h h7 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i05, h7);
            h h8 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v15)) {
                A7.d.q(v15, p0, v15, h8);
            }
            h h9 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q13, h9);
            c1.n(d.o(n0, 25.0f, 15.0f), 0x7F080156, null, i0, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0xC36, 0, 0x7FF4);  // drawable:btn_common_mixup_24
            p3 = p0;
            N1.b(s2, null, A7.d.g(n0, 6.0f, p3, 0x7F06002F, p3), 15.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p3, v1 >> 6 & 14 | 0x30C00, 0, 0x1FFD2);  // color:black
            l1.y(p3, true, n0, 15.0f, p3);
            p3.p(true);
            q q14 = d.n(n0, 182.0f);
            r0.i i5 = r0.d.b;
            androidx.compose.foundation.layout.b b1 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
            q q15 = b1.a(q14, i5);
            M m3 = M.p.d(i1, false);
            int v16 = p3.P;
            i0 i06 = p3.m();
            q q16 = r0.a.d(p3, q15);
            p3.e0();
            if(p3.O) {
                p3.l(i4);
            }
            else {
                p3.o0();
            }
            androidx.compose.runtime.w.x(p3, m3, h6);
            androidx.compose.runtime.w.x(p3, i06, h7);
            if(p3.O || !kotlin.jvm.internal.q.b(p3.N(), v16)) {
                A7.d.q(v16, p3, v16, h8);
            }
            androidx.compose.runtime.w.x(p3, q16, h9);
            q q17 = e2.a.r(d.n(n0, 182.0f), (lottieAnimationState0.getProgress() == 1.0f ? 0.0f : 1.0f));
            LottieAnimationKt.LottieAnimation(lottieCompositionResult0.getValue(), q17, !z, false, null, 0.0f, 0, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, p3, 0, 0, 0, 0x3FFFF8);
            if(lottieAnimationState0.getProgress() != 1.0f && !z) {
                v17 = 0;
                p3.a0(0xA865461E);
            }
            else {
                p3.a0(0xA931F26A);
                q q18 = b1.a(d.n(n0, 182.0f), i5);
                LottieAnimationKt.LottieAnimation(lottieCompositionResult1.getValue(), q18, false, false, null, 0.0f, 0x7FFFFFFF, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, p3, 0x180000, 0, 0, 0x3FFFBC);
                v17 = 0;
            }
            p3.p(false);
            p3.p(true);
            p3.p(true);
            if((v1 & 0xE000000) == 0x4000000) {
                v17 = 1;
            }
            Vc.h h10 = p3.N();
            if((((v1 & 0x70000) == 0x20000 ? 1 : 0) | ((v1 & 14) == 4 ? 1 : 0) | ((v1 & 0x70) == 0x20 ? 1 : 0) | v17) != 0 || h10 == v12) {
                Vc.h h11 = new Vc.h(p1, p2, z, s, s1, a1, null);
                p3.l0(h11);
                h10 = h11;
            }
            J.d(p3, s1, h10);
        }
        else {
            p3 = (p)l0;
            p3.T();
        }
        androidx.compose.runtime.n0 n00 = p3.t();
        if(n00 != null) {
            n00.d = new Vc.b(s, s1, s2, list0, b0, z, z1, a0, a1, a2, v);
        }
    }

    public static final void d(boolean z, l l0, int v) {
        n n1;
        P0.i i1;
        h h8;
        h h7;
        h h6;
        h h5;
        M.b b1;
        p p0 = (p)l0;
        p0.c0(0x9160B8FD);
        if(p0.Q(v & 1, (v & 3) != 2)) {
            LottieCompositionResult lottieCompositionResult0 = RememberLottieCompositionKt.rememberLottieComposition(RawRes.box-impl(0x7F12000F), null, null, null, null, null, p0, 6, 62);  // raw:ic_malang_basic_motion
            q q0 = androidx.compose.foundation.layout.a.n(n.a, ((float)(z ? 10 : 15)), 8.0f, 0.0f, 0.0f, 12);
            n n0 = n.a;
            q q1 = d.h(q0, 24.0f);
            M.b b0 = M.j.a;
            p0 p00 = n0.a(b0, r0.d.j, p0, 0x30);
            int v1 = p0.P;
            i0 i00 = p0.m();
            q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            r0.h h0 = r0.d.j;
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h1 = P0.j.f;
            androidx.compose.runtime.w.x(p0, p00, h1);
            h h2 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h2);
            h h3 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v1)) {
                A7.d.q(v1, p0, v1, h3);
            }
            h h4 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q2, h4);
            if(z) {
                p0.a0(1175579047);
                q q3 = d.n(n0, 24.0f);
                b1 = b0;
                h5 = h3;
                h6 = h1;
                h7 = h2;
                h8 = h4;
                i1 = i0;
                LottieAnimationKt.LottieAnimation(lottieCompositionResult0.getValue(), q3, false, false, null, 0.0f, 0x7FFFFFFF, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, p0, 0x180030, 0, 0, 0x3FFFBC);
                n1 = n0;
                x.z(n1, 2.0f, p0, false);
            }
            else {
                n1 = n0;
                i1 = i0;
                b1 = b0;
                h6 = h1;
                h7 = h2;
                h8 = h4;
                h5 = h3;
                p0.a0(1150780969);
                p0.p(false);
            }
            q q4 = androidx.compose.foundation.layout.a.n(n1, (z ? 1.0f : 0.0f), 0.0f, 0.0f, 0.0f, 14);
            p0 p01 = n0.a(b1, h0, p0, 0x30);
            int v2 = p0.P;
            i0 i01 = p0.m();
            q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p01, h6);
            androidx.compose.runtime.w.x(p0, i01, h7);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h5);
            }
            androidx.compose.runtime.w.x(p0, q5, h8);
            c1.n(androidx.compose.foundation.layout.a.n(d.h(n1, 22.0f), 0.0f, 3.0f, 0.0f, 0.0f, 13), 0x7F0804AF, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 54, 0, 0x7FFC);  // drawable:ic_malang_logo_text
            M.c.d(p0, d.q(n1, 1.0f));
            c1.n(androidx.compose.foundation.layout.a.n(n1, 0.0f, 6.0f, 0.0f, 0.0f, 13), 0x7F0803B5, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 54, 0, 0x7FFC);  // drawable:ic_beta
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Vc.f(z, v);
        }
    }
}

