package com.iloen.melon.player.playlist.music;

import Cc.c1;
import Ib.b;
import M.j;
import M.w;
import M.y;
import P0.h;
import P0.i;
import P0.k;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.iloen.melon.player.playlist.music.composables.MusicPlaylistHeaderKt;
import com.iloen.melon.player.playlist.music.composables.MusicSongListKt;
import com.iloen.melon.utils.StringUtils;
import com.melon.ui.K4;
import ie.H;
import java.util.Collection;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.StateFlow;
import oc.c0;
import r0.d;
import va.e;
import we.n;

public final class a implements n {
    public final int a;
    public final MusicPlaylistBaseFragment b;

    public a(MusicPlaylistBaseFragment musicPlaylistBaseFragment0, int v) {
        this.a = v;
        this.b = musicPlaylistBaseFragment0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v2;
        H h0 = H.a;
        MusicPlaylistBaseFragment musicPlaylistBaseFragment0 = this.b;
        switch(this.a) {
            case 0: {
                int v = (int)(((Integer)object1));
                p p0 = (p)(((l)object0));
                if(p0.Q(v & 1, (v & 3) != 2)) {
                    b0 b00 = B.a.r(musicPlaylistBaseFragment0.getViewModel().getUiState(), p0, 0);
                    b b0 = (b)B.a.r(((MusicPlaylistBaseViewModel)musicPlaylistBaseFragment0.getViewModel()).getOfflinePlaylistHelper().k, p0, 0).getValue();
                    K4 k40 = (K4)b00.getValue();
                    if(q.b(k40, Loading.INSTANCE)) {
                        p0.a0(0xFA07FC3B);
                        c1.H(null, 0L, p0, 0, 3);
                        p0.p(false);
                        return h0;
                    }
                    if(k40 instanceof Success) {
                        p0.a0(828062600);
                        if(((Success)k40).getSongList().isEmpty()) {
                            p0.a0(0xFA0ADC7B);
                            musicPlaylistBaseFragment0.UiWhenPlaylistEmpty(p0, 0);
                        }
                        else {
                            p0.a0(0xFA0DE52D);
                            y y0 = w.a(j.c, d.m, p0, 0);
                            int v1 = p0.P;
                            i0 i00 = p0.m();
                            r0.q q0 = r0.a.d(p0, androidx.compose.foundation.layout.d.c);
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
                            h h1 = P0.j.g;
                            if(p0.O || !q.b(p0.N(), v1)) {
                                A7.d.q(v1, p0, v1, h1);
                            }
                            androidx.compose.runtime.w.x(p0, q0, P0.j.d);
                            Iterable iterable0 = ((Success)k40).getSongList();
                            if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
                                v2 = 0;
                                for(Object object2: iterable0) {
                                    if(((SongUiState)object2).isSelected()) {
                                        ++v2;
                                        if(v2 < 0) {
                                            e.k.N();
                                            throw null;
                                        }
                                        if(false) {
                                            break;
                                        }
                                    }
                                }
                            }
                            else {
                                v2 = 0;
                            }
                            Bc.h h2 = musicPlaylistBaseFragment0.getPlayerUiHelper();
                            h2.getClass();
                            String s = e.h(StringUtils.getFormattedStringNumber(((Success)k40).getSongList().size()), h2.a.a(0x7F1302FA));  // string:detail_common_title_song "곡"
                            String[] arr_s = (String[])musicPlaylistBaseFragment0.h.getValue();
                            String s1 = arr_s[((Success)k40).getSortType().a];
                            q.f(s1, "get(...)");
                            c0 c00 = ((Success)k40).getSectionSelectState();
                            boolean z = p0.i(musicPlaylistBaseFragment0);
                            com.iloen.melon.player.playlist.music.b b1 = p0.N();
                            V v3 = androidx.compose.runtime.k.a;
                            if(z || b1 == v3) {
                                b1 = new com.iloen.melon.player.playlist.music.b(musicPlaylistBaseFragment0, 7);
                                p0.l0(b1);
                            }
                            boolean z1 = p0.i(musicPlaylistBaseFragment0);
                            com.iloen.melon.player.playlist.music.b b2 = p0.N();
                            if(z1 || b2 == v3) {
                                b2 = new com.iloen.melon.player.playlist.music.b(musicPlaylistBaseFragment0, 1);
                                p0.l0(b2);
                            }
                            boolean z2 = p0.i(musicPlaylistBaseFragment0);
                            com.iloen.melon.player.playlist.music.b b3 = p0.N();
                            if(z2 || b3 == v3) {
                                b3 = new com.iloen.melon.player.playlist.music.b(musicPlaylistBaseFragment0, 2);
                                p0.l0(b3);
                            }
                            boolean z3 = p0.i(musicPlaylistBaseFragment0);
                            com.iloen.melon.player.playlist.music.b b4 = p0.N();
                            if(z3 || b4 == v3) {
                                b4 = new com.iloen.melon.player.playlist.music.b(musicPlaylistBaseFragment0, 3);
                                p0.l0(b4);
                            }
                            boolean z4 = p0.i(musicPlaylistBaseFragment0);
                            com.iloen.melon.player.playlist.music.b b5 = p0.N();
                            if(z4 || b5 == v3) {
                                b5 = new com.iloen.melon.player.playlist.music.b(musicPlaylistBaseFragment0, 4);
                                p0.l0(b5);
                            }
                            MusicPlaylistHeaderKt.MusicPlaylistHeader(v2 > 0, s, s1, b0, c00, b1, b2, b3, b4, b5, p0, 0);
                            StateFlow stateFlow0 = ((MusicPlaylistBaseViewModel)musicPlaylistBaseFragment0.getViewModel()).isToolbarVisible();
                            boolean z5 = p0.i(musicPlaylistBaseFragment0);
                            c c0 = p0.N();
                            if(z5 || c0 == v3) {
                                c0 = new c(musicPlaylistBaseFragment0, 2);
                                p0.l0(c0);
                            }
                            boolean z6 = p0.i(musicPlaylistBaseFragment0);
                            c c1 = p0.N();
                            if(z6 || c1 == v3) {
                                c1 = new c(musicPlaylistBaseFragment0, 0);
                                p0.l0(c1);
                            }
                            boolean z7 = p0.i(musicPlaylistBaseFragment0);
                            c c2 = p0.N();
                            if(z7 || c2 == v3) {
                                c2 = new c(musicPlaylistBaseFragment0, 3);
                                p0.l0(c2);
                            }
                            boolean z8 = p0.i(musicPlaylistBaseFragment0);
                            c c3 = p0.N();
                            if(z8 || c3 == v3) {
                                c3 = new c(musicPlaylistBaseFragment0, 4);
                                p0.l0(c3);
                            }
                            boolean z9 = p0.i(musicPlaylistBaseFragment0);
                            c c4 = p0.N();
                            if(z9 || c4 == v3) {
                                c4 = new c(musicPlaylistBaseFragment0, 1);
                                p0.l0(c4);
                            }
                            boolean z10 = p0.i(musicPlaylistBaseFragment0);
                            com.iloen.melon.player.playlist.music.b b6 = p0.N();
                            if(z10 || b6 == v3) {
                                b6 = new com.iloen.melon.player.playlist.music.b(musicPlaylistBaseFragment0, 8);
                                p0.l0(b6);
                            }
                            boolean z11 = p0.i(musicPlaylistBaseFragment0);
                            a a0 = p0.N();
                            if(z11 || a0 == v3) {
                                a0 = new a(musicPlaylistBaseFragment0, 1);
                                p0.l0(a0);
                            }
                            boolean z12 = p0.i(musicPlaylistBaseFragment0);
                            com.iloen.melon.player.playlist.music.b b7 = p0.N();
                            if(z12 || b7 == v3) {
                                b7 = new com.iloen.melon.player.playlist.music.b(musicPlaylistBaseFragment0, 0);
                                p0.l0(b7);
                            }
                            boolean z13 = p0.i(musicPlaylistBaseFragment0);
                            a a1 = p0.N();
                            if(z13 || a1 == v3) {
                                a1 = new a(musicPlaylistBaseFragment0, 2);
                                p0.l0(a1);
                            }
                            MusicSongListKt.MusicSongList(((Success)k40), stateFlow0, c0, c1, c2, c3, c4, b6, a0, b7, a1, p0, 0, 0, 0);
                            p0.p(true);
                        }
                        p0.p(false);
                    }
                    else {
                        p0.a0(-105399960);
                    }
                    p0.p(false);
                    return h0;
                }
                p0.T();
                return h0;
            }
            case 1: {
                musicPlaylistBaseFragment0.sendUserEvent(new MoveSongItem(((int)(((Integer)object0))), ((int)(((Integer)object1)))));
                ((MusicPlaylistBaseViewModel)musicPlaylistBaseFragment0.getViewModel()).setIsDragging(false);
                return h0;
            }
            default: {
                musicPlaylistBaseFragment0.sendUserEvent(new ClickGroupTitle(((int)(((Integer)object0))), ((int)(((Integer)object1)))));
                return h0;
            }
        }
    }
}

