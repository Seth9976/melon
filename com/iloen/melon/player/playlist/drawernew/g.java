package com.iloen.melon.player.playlist.drawernew;

import androidx.lifecycle.f0;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.melon.ui.k1;
import ie.H;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import we.a;
import we.k;

public final class g implements a {
    public final int a;
    public final k1 b;
    public final Object c;

    public g(k1 k10, Object object0, int v) {
        this.a = v;
        this.b = k10;
        this.c = object0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(((DrawerSongFragmentViewModel)this.b)), null, null, new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.checkSelectRepeatClearAndDo.2.1.1(((DrawerSongFragmentViewModel)this.b), ((k)this.c), null), 3, null);
            return H.a;
        }
        BuildersKt__Builders_commonKt.launch$default(f0.h(((DrawerFragmentViewModel)this.b)), null, null, new com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel.playPlaylist.1.1.canPlay.1.1(((DrawerFragmentViewModel)this.b), ((DrawerPlaylistInfo)this.c), null), 3, null);
        return H.a;
    }
}

