package com.iloen.melon.player.playlist.music;

import Cc.N1;
import Cc.e0;
import H0.e;
import M.c;
import M.j;
import M.n0;
import M.p0;
import M.w;
import M.y;
import N0.M;
import P0.h;
import P0.i;
import P0.k;
import androidx.compose.foundation.Q0;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.iloen.melon.custom.l1;
import com.iloen.melon.player.playlist.common.PlaylistCommonEmptyComposablesKt;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import r0.n;
import r0.q;
import we.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A3\u0010\u0004\u001A\u00020\u00012\u0010\b\u0002\u0010\u0002\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00002\u0010\b\u0002\u0010\u0003\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/Function0;", "Lie/H;", "onClickMelonChartButton", "onClickGetFromNp", "SmartPlaylistEmptyView", "(Lwe/a;Lwe/a;Landroidx/compose/runtime/l;II)V", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class SmartPlaylistFragmentKt {
    public static final void SmartPlaylistEmptyView(@Nullable a a0, @Nullable a a1, @Nullable l l0, int v, int v1) {
        a a7;
        a a6;
        a a5;
        h h4;
        i i1;
        a a4;
        a a2;
        int v2;
        p p0 = (p)l0;
        p0.c0(0xEF8A973F);
        if((v1 & 1) != 0) {
            v2 = v | 6;
            a2 = a0;
        }
        else if((v & 6) == 0) {
            a2 = a0;
            v2 = v | (p0.i(a2) ? 4 : 2);
        }
        else {
            a2 = a0;
            v2 = v;
        }
        if((v1 & 2) != 0) {
            v2 |= 0x30;
        }
        else if((v & 0x30) == 0) {
            v2 |= (p0.i(a1) ? 0x20 : 16);
        }
        a a3 = null;
        if(p0.Q(v2 & 1, (v2 & 19) != 18)) {
            if((v1 & 1) != 0) {
                a2 = null;
            }
            if((v1 & 2) == 0) {
                a3 = a1;
            }
            n n0 = n.a;
            q q0 = d.c(d.f(n0, 1.0f), 1.0f);
            M.d d0 = j.c;
            y y0 = w.a(d0, r0.d.m, p0, 0);
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
            androidx.compose.runtime.w.x(p0, y0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            LayoutWeightElement layoutWeightElement0 = new LayoutWeightElement(1.0f, true);
            M m0 = M.p.d(r0.d.a, false);
            int v4 = p0.P;
            i0 i01 = p0.m();
            q q2 = r0.a.d(p0, layoutWeightElement0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q2, h3);
            Q0 q00 = androidx.compose.foundation.q.t(p0);
            q q3 = androidx.compose.foundation.q.x(d.c(d.f(n0, 1.0f), 1.0f), q00, false, 14);
            y y1 = w.a(d0, r0.d.n, p0, 0x30);
            int v5 = p0.P;
            i0 i02 = p0.m();
            q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y1, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            androidx.compose.runtime.w.x(p0, q4, h3);
            c.d(p0, d.h(n0, 142.0f));
            N1.b(e.Y(p0, 0x7F130A1A), null, e0.T(p0, 0x7F0604A1), 24.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD2);  // string:smart_playlist_empty_playlist_title "스마트 재생목록 ON"
            c.d(p0, d.h(n0, 16.0f));
            N1.b(e.Y(p0, 0x7F130A19), null, e0.T(p0, 0x7F0604B7), 15.0f, null, null, 0L, new l1.k(3), 22.0f, 0, false, 0, 0, null, null, p0, 0xC00, 6, 0x1F9F2);  // string:smart_playlist_empty_playlist_description "서버에 저장되는 재생목록입니다.\n멜론의 인기곡으로 재생을 
                                                                                                                                                                  // 시작해 보세요."
            c.d(p0, d.h(n0, 20.0f));
            String s = e.Y(p0, 0x7F13082D);  // string:playlist_empty_playlist_melon_chart_btn "멜론차트 바로가기"
            com.iloen.melon.player.playlist.music.p p1 = p0.N();
            V v6 = androidx.compose.runtime.k.a;
            if((v2 & 14) == 4 || p1 == v6) {
                a4 = a2;
                p1 = new com.iloen.melon.player.playlist.music.p(1, a4);
                p0.l0(p1);
            }
            else {
                a4 = a2;
            }
            PlaylistCommonEmptyComposablesKt.EmptyPlaylistCommonButton-PEIptTM(s, 0L, 0L, 0.0f, p1, p0, 0, 14);
            p0.p(true);
            p0.p(true);
            q q5 = androidx.compose.foundation.layout.a.n(d.t(d.f(n0, 1.0f), 3), 20.0f, 0.0f, 20.0f, 0.0f, 10);
            T.d d1 = T.e.b(4.0f);
            q q6 = androidx.compose.foundation.q.f(q5, e0.T(p0, 0x7F060144), d1);  // color:gray050e
            M m1 = M.p.d(r0.d.d, false);
            int v7 = p0.P;
            i0 i03 = p0.m();
            q q7 = r0.a.d(p0, q6);
            p0.e0();
            if(p0.O) {
                i1 = i0;
                p0.l(i1);
            }
            else {
                i1 = i0;
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m1, h0);
            androidx.compose.runtime.w.x(p0, i03, h1);
            if(!p0.O && kotlin.jvm.internal.q.b(p0.N(), v7)) {
                h4 = h2;
            }
            else {
                h4 = h2;
                A7.d.q(v7, p0, v7, h4);
            }
            androidx.compose.runtime.w.x(p0, q7, h3);
            q q8 = androidx.compose.foundation.layout.a.j(n0, 16.0f);
            p0 p00 = n0.a(j.a, r0.d.k, p0, 0x30);
            int v8 = p0.P;
            i0 i04 = p0.m();
            q q9 = r0.a.d(p0, q8);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h0);
            androidx.compose.runtime.w.x(p0, i04, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v8)) {
                A7.d.q(v8, p0, v8, h4);
            }
            androidx.compose.runtime.w.x(p0, q9, h3);
            LayoutWeightElement layoutWeightElement1 = new LayoutWeightElement(1.0f, true);
            N1.b(e.Y(p0, 0x7F130A1C), layoutWeightElement1, e0.T(p0, 0x7F0604A1), 15.0f, null, null, 0L, null, 18.0f, 0, false, 0, 0, null, null, p0, 0xC00, 6, 0x1FBF0);  // string:smart_playlist_empty_take_description "기존 재생목록에 담겨있던 곡을 동일하게 가져올 수 있어요."
            String s1 = l1.s(n0, 12.0f, p0, 0x7F130A1B, p0);  // string:smart_playlist_empty_take_btn "가져오기"
            com.iloen.melon.player.playlist.music.p p2 = p0.N();
            if((v2 & 0x70) == 0x20 || p2 == v6) {
                a5 = a3;
                p2 = new com.iloen.melon.player.playlist.music.p(2, a5);
                p0.l0(p2);
            }
            else {
                a5 = a3;
            }
            PlaylistCommonEmptyComposablesKt.EmptyPlaylistCommonButton-PEIptTM(s1, 0L, 0L, 0.0f, p2, p0, 0, 14);
            p0.p(true);
            p0.p(true);
            c.d(p0, d.h(n0, 24.0f));
            p0.p(true);
            a6 = a5;
            a7 = a4;
        }
        else {
            p0.T();
            a7 = a2;
            a6 = a1;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new s(a7, a6, v, v1, 0);
        }
    }
}

