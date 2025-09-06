package com.iloen.melon.player.playlist.music;

import Ce.g;
import kotlin.jvm.internal.q;
import we.k;

public final class i implements k {
    public final MusicPlaylistBaseViewModel a;
    public final g b;

    public i(MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0, g g0) {
        this.a = musicPlaylistBaseViewModel0;
        this.b = g0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((Success)object0), "prevState");
        j j0 = new j(this.a, 1);
        return Success.copy$default(((Success)object0), null, false, false, null, null, this.a.t.c(this.b, ((Success)object0).getSongList(), j0), 0, null, 0xDF, null);
    }
}

