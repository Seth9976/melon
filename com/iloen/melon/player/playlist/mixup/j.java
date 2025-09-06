package com.iloen.melon.player.playlist.mixup;

import O.F;
import androidx.lifecycle.B;
import androidx.lifecycle.D;
import androidx.lifecycle.r;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

public final class j implements B {
    public final MixUpPlaylistComposeFragment a;
    public final CoroutineScope b;
    public final F c;

    public j(MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0, CoroutineScope coroutineScope0, F f0) {
        this.a = mixUpPlaylistComposeFragment0;
        this.b = coroutineScope0;
        this.c = f0;
    }

    @Override  // androidx.lifecycle.B
    public final void onStateChanged(D d0, r r0) {
        if(r0 == r.ON_PAUSE) {
            int v = ((MixUpPlaylistComposeViewModel)this.a.getViewModel()).getCurrentIndex();
            com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.2.1.observer.1.1 mixUpPlaylistComposeFragment$MixUpPlaylistList$2$1$observer$1$10 = new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.2.1.observer.1.1(this.c, v, null);
            BuildersKt__Builders_commonKt.launch$default(this.b, null, null, mixUpPlaylistComposeFragment$MixUpPlaylistList$2$1$observer$1$10, 3, null);
        }
    }
}

