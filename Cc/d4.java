package Cc;

import H0.e;
import L5.c;
import Ld.K;
import M.b;
import M.j;
import M.n0;
import M.p0;
import N0.M;
import P0.h;
import P0.i;
import P0.k;
import U4.x;
import android.content.Context;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.d;
import androidx.compose.foundation.y;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimationKt;
import com.melon.net.res.VoiceAlarm.Track;
import java.util.Arrays;
import r0.n;
import r0.q;
import we.a;

public abstract class d4 {
    public static final void a(boolean z, float f, a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(-509682978);
        int v1 = (v & 6) == 0 ? (p0.h(z) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.d(f) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (p0.i(a0) ? 0x100 : 0x80);
        }
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            n n0 = n.a;
            q q0 = d.c(n0, 1.0f);
            p0 p00 = n0.a(j.a, r0.d.k, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            w.x(p0, p00, h0);
            h h1 = P0.j.e;
            w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            w.x(p0, q1, h3);
            q q2 = d.n(n0, 30.0f);
            M m0 = M.p.d(r0.d.e, false);
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
            w.x(p0, m0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            w.x(p0, q3, h3);
            if(z) {
                p0.a0(-366680868);
                FillElement fillElement0 = d.c;
                long v4 = e0.T(p0, 0x7F06017C);  // color:green500s_support_high_contrast
                long v5 = e0.T(p0, 0x7F06014B);  // color:gray100s_support_high_contrast
                a4 a40 = p0.N();
                if((v1 & 0x70) == 0x20 || a40 == androidx.compose.runtime.k.a) {
                    a40 = new a4(f);
                    p0.l0(a40);
                }
                b0.w.a(a40, fillElement0, v4, 2.0f, v5, 0, 0.0f, p0, 0xC30);
                q q4 = r0.a.a(d.u(androidx.compose.foundation.layout.a.j(n0, 6.0f), 3), new u3(9, a0));
                androidx.compose.foundation.q.c(c.a(d5.w.B(context0, 0x7F080217), p0), e.Y(p0, 0x7F130BB4), q4, null, N0.j.c, 0.0f, null, p0, 0x6000, 104);  // drawable:btn_miniplayer_pause
            }
            else {
                p0.a0(-365783170);
                q q5 = r0.a.a(d.u(n0, 3), new u3(10, a0));
                androidx.compose.foundation.q.c(c.a(d5.w.B(context0, 0x7F080161), p0), e.Y(p0, 0x7F130BB4), q5, null, null, 0.0f, null, p0, 0, 120);  // drawable:btn_common_play_02_tint
            }
            p0.p(false);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new b4(z, f, a0, v);
        }
    }

    public static final void b(a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0xEC576314);
        int v1 = (v & 6) == 0 ? (p0.i(a0) ? 4 : 2) | v : v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            n n0 = n.a;
            q q0 = d.c(androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 14.0f, 0.0f, 11), 1.0f);
            p0 p00 = n0.a(j.a, r0.d.k, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, P0.j.d);
            q q2 = d.q(androidx.compose.foundation.layout.a.n(n0, 8.0f, 0.0f, 0.0f, 0.0f, 14), 47.0f);
            y y0 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F060152), 0.5f);  // color:gray200a
            T.d d0 = T.e.b(20.0f);
            q q3 = r0.a.a(androidx.compose.foundation.q.j(q2, y0.a, y0.b, d0), new u3(11, a0));
            kotlin.jvm.internal.q.f("선택", "getString(...)");
            N1.b("선택", q3, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, new l1.k(3), 25.0f, 0, false, 0, 0, null, null, p0, 0xC00, 6, 0x1F9F0);  // color:gray600s_support_high_contrast
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new x0(v, 2, a0);
        }
    }

    public static final void c(q q0, Track voiceAlarm$Track0, long v, long v1, l l0, int v2) {
        long v9;
        long v5;
        int v4;
        kotlin.jvm.internal.q.g(voiceAlarm$Track0, "item");
        p p0 = (p)l0;
        p0.c0(-608731966);
        int v3 = v2 | (p0.g(voiceAlarm$Track0) ? 0x20 : 16) | (p0.f(v) ? 0x100 : 0x80) | 0x400;
        if(p0.Q(v3 & 1, (v3 & 0x493) != 1170)) {
            p0.V();
            if((v2 & 1) == 0 || p0.B()) {
                v4 = v3 & 0xFFFFE3FF;
                v5 = e0.T(p0, 0x7F060160);  // color:gray600s_support_high_contrast
            }
            else {
                p0.T();
                v4 = v3 & 0xFFFFE3FF;
                v5 = v1;
            }
            p0.q();
            M.y y0 = M.w.a(j.c, r0.d.m, p0, 0);
            int v6 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            k.y.getClass();
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            h h3 = P0.j.d;
            w.x(p0, q1, h3);
            p0 p00 = n0.a(j.a, r0.d.k, p0, 0x30);
            int v7 = p0.P;
            i0 i01 = p0.m();
            n n0 = n.a;
            q q2 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h2);
            }
            w.x(p0, q2, h3);
            q q3 = d.t(d.f(n0, 1.0f), 3);
            K1 k10 = p0.N();
            V v8 = androidx.compose.runtime.k.a;
            if(k10 == v8) {
                k10 = new K1(6);
                p0.l0(k10);
            }
            N1.b(voiceAlarm$Track0.getTrackName(), X0.n.b(q3, k10), v, 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v4 & 0x380 | 0xC00, 0xC30, 0x1D7F0);
            p0.p(true);
            q q4 = d.t(d.f(androidx.compose.foundation.layout.a.n(n0, 0.0f, 4.0f, 0.0f, 0.0f, 13), 1.0f), 2);
            K1 k11 = p0.N();
            if(k11 == v8) {
                k11 = new K1(7);
                p0.l0(k11);
            }
            v9 = v5;
            N1.b(voiceAlarm$Track0.getPlayTime(), X0.n.b(q4, k11), v9, 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);
            p0.p(true);
        }
        else {
            p0.T();
            v9 = v1;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new c4(q0, voiceAlarm$Track0, v, v9, v2, 0);
        }
    }

    public static final void d(K k0, a a0, a a1, int v, LottieComposition lottieComposition0, float f, l l0, int v1) {
        int v6;
        int v5;
        n n1;
        kotlin.jvm.internal.q.g(k0, "item");
        boolean z = k0.b;
        p p0 = (p)l0;
        p0.c0(0x3827F3EB);
        int v2 = (v1 & 6) == 0 ? (p0.i(k0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.i(a0) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.i(a1) ? 0x100 : 0x80);
        }
        if((v1 & 0xC00) == 0) {
            v2 |= (p0.e(v) ? 0x800 : 0x400);
        }
        if((v1 & 0x6000) == 0) {
            v2 |= (p0.i(lottieComposition0) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v1) == 0) {
            v2 |= (p0.d(f) ? 0x20000 : 0x10000);
        }
        if(p0.Q(v2 & 1, (74899 & v2) != 74898)) {
            n n0 = n.a;
            q q0 = r0.a.a(d.h(d.f(n0, 1.0f), 60.0f), new Cc.w(3));
            b b0 = j.a;
            p0 p00 = n0.a(b0, r0.d.j, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            w.x(p0, p00, h0);
            h h1 = P0.j.e;
            w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = P0.j.d;
            w.x(p0, q1, h3);
            q q2 = x.r(1.0f, androidx.compose.foundation.layout.a.n(d.c(n0, 1.0f), 20.0f, 0.0f, 0.0f, 0.0f, 14), true);
            p0 p01 = n0.a(b0, r0.d.k, p0, 0x30);
            int v4 = p0.P;
            i0 i01 = p0.m();
            q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p01, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            w.x(p0, q3, h3);
            if(z) {
                p0.a0(0xDDAFD04E);
                n1 = n0;
                LottieAnimationKt.LottieAnimation(lottieComposition0, f, d.n(n0, 28.0f), false, false, false, false, null, false, null, null, null, false, false, null, p0, v2 >> 12 & 14 | 0x180 | v2 >> 12 & 0x70, 0, 0x7FF8);
            }
            else {
                p0.a0(0xDDB35FA8);
                q q4 = d.q(n0, 28.0f);
                n1 = n0;
                N1.b(String.format("%02d", Arrays.copyOf(new Object[]{((int)(v + 1))}, 1)), q4, e0.T(p0, 0x7F060159), 14.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FDF0);  // color:gray400s_support_high_contrast
            }
            p0.p(false);
            if(z) {
                v5 = 0x282F45B3;
                v6 = 0x7F06017C;  // color:green500s_support_high_contrast
            }
            else {
                v5 = 0x282F4E5C;
                v6 = 0x7F06016D;  // color:gray900s
            }
            long v7 = A7.d.f(p0, v5, v6, p0, false);
            d4.c(d.t(d.f(androidx.compose.foundation.layout.a.n(n1, 10.0f, 0.0f, 0.0f, 0.0f, 14), 1.0f), 3), k0.a.asDomain(), v7, 0L, p0, 6);
            p0.p(true);
            M.c.d(p0, d.q(n1, 2.0f));
            d4.a(z, ((float)k0.c) / 1000.0f, a0, p0, v2 << 3 & 0x380);
            d4.b(a1, p0, v2 >> 6 & 14);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new S2(k0, a0, a1, v, lottieComposition0, f, v1);
        }
    }
}

