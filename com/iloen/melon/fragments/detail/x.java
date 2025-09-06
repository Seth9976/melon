package com.iloen.melon.fragments.detail;

import com.iloen.melon.playback.Playable;
import com.melon.ui.k2;
import we.k;

public final class x implements k {
    public final Playable a;
    public final MixPlaylistDetailFragment b;
    public final int c;

    public x(int v, MixPlaylistDetailFragment mixPlaylistDetailFragment0, Playable playable0) {
        this.a = playable0;
        this.b = mixPlaylistDetailFragment0;
        this.c = v;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return MixPlaylistDetailFragment.showContextPopupFromSong$lambda$34(this.a, this.b, this.c, ((k2)object0));
    }
}

