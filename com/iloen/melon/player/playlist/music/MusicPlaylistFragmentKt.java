package com.iloen.melon.player.playlist.music;

import Cc.N1;
import Cc.e0;
import H0.e;
import M.c;
import M.j;
import M.w;
import M.y;
import P0.h;
import P0.i;
import P0.k;
import androidx.compose.foundation.Q0;
import androidx.compose.foundation.layout.d;
import androidx.compose.foundation.q;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import com.iloen.melon.player.playlist.common.PlaylistCommonEmptyComposablesKt;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import r0.n;
import we.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A!\u0010\u0003\u001A\u00020\u00012\u0010\b\u0002\u0010\u0002\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/Function0;", "Lie/H;", "onClickMelonChartButton", "MusicPlaylistEmptyView", "(Lwe/a;Landroidx/compose/runtime/l;II)V", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class MusicPlaylistFragmentKt {
    public static final void MusicPlaylistEmptyView(@Nullable a a0, @Nullable l l0, int v, int v1) {
        a a1;
        int v2;
        p p0 = (p)l0;
        p0.c0(42876043);
        if((v1 & 1) == 0) {
            v2 = (v & 6) == 0 ? v | (p0.i(a0) ? 4 : 2) : v;
        }
        else {
            v2 = v | 6;
        }
        if(p0.Q(v2 & 1, (v2 & 3) != 2)) {
            Q0 q00 = q.t(p0);
            n n0 = n.a;
            r0.q q0 = q.x(d.c(d.f(n0, 1.0f), 1.0f), q00, false, 14);
            y y0 = w.a(j.c, r0.d.n, p0, 0x30);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = P0.j.b;
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            c.d(p0, d.h(n0, 143.0f));
            a1 = (v1 & 1) == 0 ? a0 : null;
            N1.b(e.Y(p0, 0x7F130793), null, e0.T(p0, 0x7F0604B7), 15.0f, null, null, 0L, new l1.k(3), 22.0f, 0, false, 0, 0, null, null, p0, 0xC00, 6, 0x1F9F2);  // string:normal_playlist_empty_playlist_desc "곡 목록이 없어요.\n멜론의 인기곡으로 재생을 시작해 보세요."
            c.d(p0, d.h(n0, 20.0f));
            String s = e.Y(p0, 0x7F13082D);  // string:playlist_empty_playlist_melon_chart_btn "멜론차트 바로가기"
            com.iloen.melon.player.playlist.music.p p1 = p0.N();
            if((v2 & 14) == 4 || p1 == androidx.compose.runtime.k.a) {
                p1 = new com.iloen.melon.player.playlist.music.p(0, a1);
                p0.l0(p1);
            }
            PlaylistCommonEmptyComposablesKt.EmptyPlaylistCommonButton-PEIptTM(s, 0L, 0L, 0.0f, p1, p0, 0, 14);
            A7.d.v(n0, 40.0f, p0, true);
        }
        else {
            p0.T();
            a1 = a0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.music.q(v, v1, a1);
        }
    }
}

