package com.iloen.melon.player.playlist.drawernew;

import Cc.N1;
import Cc.U;
import Cc.e0;
import Cc.y1;
import De.I;
import Ib.b;
import M.c;
import M.j;
import M.n0;
import M.p0;
import N0.M;
import P0.h;
import P0.i;
import U4.x;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.iloen.melon.custom.l1;
import com.iloen.melon.player.playlist.common.PlaylistCommonHeaderComposableKt;
import e1.F;
import kotlin.Metadata;
import oc.c0;
import p8.e;
import r0.d;
import r0.g;
import r0.n;
import r0.q;
import we.a;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerSongFragmentKt {
    public static final void a(String s, boolean z, b b0, boolean z1, c0 c00, a a0, a a1, a a2, a a3, l l0, int v, int v1) {
        V v7;
        n n1;
        a a5;
        a a4;
        g g0 = d.m;
        p p0 = (p)l0;
        p0.c0(60088841);
        int v2 = (v & 6) == 0 ? (p0.g(s) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.h(z) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.e(b0.ordinal()) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v2 |= (p0.h(z1) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v2 |= (p0.e(c00.ordinal()) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v) == 0) {
            v2 |= (p0.i(a0) ? 0x20000 : 0x10000);
        }
        if((v1 & 0x40) != 0) {
            v2 |= 0x180000;
            a4 = a1;
        }
        else if((0x180000 & v) == 0) {
            a4 = a1;
            v2 |= (p0.i(a4) ? 0x100000 : 0x80000);
        }
        else {
            a4 = a1;
        }
        if((0xC00000 & v) == 0) {
            v2 |= (p0.i(a2) ? 0x800000 : 0x400000);
        }
        if((0x6000000 & v) == 0) {
            v2 |= (p0.i(a3) ? 0x4000000 : 0x2000000);
        }
        if(p0.Q(v2 & 1, (v2 & 0x2492493) != 0x2492492)) {
            V v3 = k.a;
            if((v1 & 0x40) == 0) {
                a5 = a4;
            }
            else {
                e e0 = p0.N();
                if(e0 == v3) {
                    e0 = new e(24);
                    p0.l0(e0);
                }
                a5 = e0;
            }
            c0.a.getClass();
            boolean z2 = F.u(c00);
            n n0 = n.a;
            q q0 = androidx.compose.foundation.layout.d.h(n0, 42.0f);
            p0 p00 = n0.a(j.a, d.k, p0, 0x30);
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
            w.x(p0, p00, h0);
            h h1 = P0.j.e;
            w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            h h3 = P0.j.d;
            w.x(p0, q1, h3);
            M m0 = M.p.d(d.a, false);
            int v5 = p0.P;
            i0 i01 = p0.m();
            q q2 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            w.x(p0, q2, h3);
            String s1 = c00.name();
            if(kotlin.jvm.internal.q.b(s1, "SECTION_STEP1")) {
                p0.a0(0x9D709B73);
                q q3 = r0.a.a(androidx.compose.foundation.layout.d.v(androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.v(n0, g0, 2), 20.0f, 0.0f, 20.0f, 0.0f, 10), 2), g0, 2), new DrawerSongFragmentKt.PlaylistFunctionHeader.lambda.12.lambda.9..inlined.noRippleClickable-YQRRFTQ.default.1(true, null, 0, a3));
                long v6 = e0.T(p0, 0x7F0604A1);  // color:white000e
                N1.b(H0.e.Y(p0, 0x7F130A3E), q3, v6, 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFF8);  // string:smartplaylist_section_start_description "구간선택 첫 번째 곡을 선택하세요."
                p0.p(false);
                a4 = a5;
                n1 = n0;
                v7 = v3;
            }
            else if(kotlin.jvm.internal.q.b(s1, "SECTION_STEP2")) {
                p0.a0(0x9D7C1475);
                q q4 = r0.a.a(androidx.compose.foundation.layout.d.v(androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.v(n0, g0, 2), 20.0f, 0.0f, 20.0f, 0.0f, 10), 2), g0, 2), new DrawerSongFragmentKt.PlaylistFunctionHeader.lambda.12.lambda.9..inlined.noRippleClickable-YQRRFTQ.default.2(true, null, 0, a3));
                long v8 = e0.T(p0, 0x7F0604A1);  // color:white000e
                N1.b(H0.e.Y(p0, 0x7F130A3D), q4, v8, 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFF8);  // string:smartplaylist_section_end_description "구간선택 마지막 곡을 선택하세요."
                p0.p(false);
                a4 = a5;
                n1 = n0;
                v7 = v3;
            }
            else {
                p0.a0(-1652106875);
                n1 = n0;
                q q5 = androidx.compose.foundation.layout.a.n(n1, 0.0f, 14.0f, 0.0f, 10.0f, 5);
                com.iloen.melon.player.playlist.drawernew.n n2 = p0.N();
                if((v2 & 0x70000) == 0x20000 || n2 == v3) {
                    n2 = new com.iloen.melon.player.playlist.drawernew.n(0, a0);
                    p0.l0(n2);
                }
                a4 = a5;
                v7 = v3;
                PlaylistCommonHeaderComposableKt.AllSelectButton(q5, z, s, null, n2, p0, v2 << 6 & 0x380 | (v2 & 0x70 | 6), 8);
                p0.p(false);
            }
            p0.p(true);
            l1.x(1.0f, true, p0);
            if(z2 || z) {
                p0.a0(0xFA37F81E);
                PlaylistCommonHeaderComposableKt.SectionSelectButton(c00, a2, a3, p0, v2 >> 12 & 14 | v2 >> 18 & 0x70 | v2 >> 18 & 0x380);
            }
            else if(z1) {
                p0.a0(-96724110);
                q q6 = androidx.compose.foundation.layout.a.n(n1, 0.0f, 14.0f, 0.0f, 10.0f, 5);
                com.iloen.melon.player.playlist.drawernew.n n3 = p0.N();
                if((v2 & 0x380000) == 0x100000 || n3 == v7) {
                    n3 = new com.iloen.melon.player.playlist.drawernew.n(1, a4);
                    p0.l0(n3);
                }
                PlaylistCommonHeaderComposableKt.OfflineButton(q6, b0, n3, p0, v2 >> 3 & 0x70 | 6, 0);
            }
            else {
                p0.a0(-131440235);
            }
            p0.p(false);
            x.z(n1, 20.0f, p0, true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new y1(s, z, b0, z1, c00, a0, a4, a2, a3, v, v1);
        }
    }

    public static final void b(String s, a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(-430578387);
        int v1 = (v & 6) == 0 ? v | (p0.g(s) ? 4 : 2) : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(a0) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            DrawerSongFragmentKt.PlaylistInfoHeader..inlined.noRippleClickable-YQRRFTQ.default.1 drawerSongFragmentKt$PlaylistInfoHeader$$inlined$noRippleClickable-YQRRFTQ$default$10 = new DrawerSongFragmentKt.PlaylistInfoHeader..inlined.noRippleClickable-YQRRFTQ.default.1(true, null, 0, a0);
            n n0 = n.a;
            q q0 = androidx.compose.foundation.layout.a.k(androidx.compose.foundation.layout.d.f(r0.a.a(n0, drawerSongFragmentKt$PlaylistInfoHeader$$inlined$noRippleClickable-YQRRFTQ$default$10), 1.0f), 20.0f, 15.0f);
            p0 p00 = n0.a(j.a, d.k, p0, 0x30);
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
            w.x(p0, p00, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, P0.j.d);
            long v3 = e0.T(p0, 0x7F0604A1);  // color:white000e
            N1.b(s, new LayoutWeightElement(1.0f, false), v3, 18.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v1 & 14 | 0xC00, 0xC30, 0x1D7F0);
            c.d(p0, androidx.compose.foundation.layout.d.q(n0, 4.0f));
            androidx.compose.foundation.q.c(I.Q(0x7F080185, p0, 6), null, androidx.compose.foundation.layout.d.n(n0, 20.0f), null, null, 0.0f, null, p0, 0x1B0, 120);  // drawable:btn_cpplaylist_title_open
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U(s, a0, v, 13);
        }
    }
}

