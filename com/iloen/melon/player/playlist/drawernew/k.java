package com.iloen.melon.player.playlist.drawernew;

import androidx.compose.runtime.l;
import androidx.fragment.app.I;
import androidx.lifecycle.f0;
import com.iloen.melon.player.playlist.DrawerPlaylistTabInfo;
import ie.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import we.n;

public final class k implements n {
    public final int a;
    public final I b;

    public k(DrawerBtmSheetFragment drawerBtmSheetFragment0, int v) {
        this.a = 3;
        super();
        this.b = drawerBtmSheetFragment0;
    }

    public k(DrawerSongFragment drawerSongFragment0, int v) {
        this.a = v;
        this.b = drawerSongFragment0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        H h0 = H.a;
        I i0 = this.b;
        switch(this.a) {
            case 0: {
                ((Boolean)object1).booleanValue();
                q.g(((DrawerPlaylistTabInfo)object0), "playlistTabInfo");
                BuildersKt__Builders_commonKt.launch$default(f0.f(((DrawerSongFragment)i0)), null, null, new com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.onUiEvent.1.1(((DrawerSongFragment)i0), ((DrawerPlaylistTabInfo)object0), null), 3, null);
                return h0;
            }
            case 1: {
                ((DrawerSongFragmentViewModel)((DrawerSongFragment)i0).getViewModel()).updateUserEvent(new OnSwapSongPosition(((int)(((Integer)object0))), ((int)(((Integer)object1)))));
                ((DrawerSongFragmentViewModel)((DrawerSongFragment)i0).getViewModel()).setIsDragging(false);
                return h0;
            }
            case 2: {
                ((DrawerSongFragmentViewModel)((DrawerSongFragment)i0).getViewModel()).updateUserEvent(new OnLongClickSong(((int)(((Integer)object0))), ((Boolean)object1).booleanValue()));
                return h0;
            }
            default: {
                ((Integer)object1).getClass();
                ((DrawerBtmSheetFragment)i0).o(((l)object0), 1);
                return h0;
            }
        }
    }
}

