package com.iloen.melon.player.playlist.mixup;

import com.iloen.melon.playback.Playable;
import ie.H;
import kotlin.jvm.internal.q;
import we.o;

public final class i implements o {
    public final MixUpPlaylistComposeFragment a;

    public i(MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0) {
        this.a = mixUpPlaylistComposeFragment0;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        q.g(((Playable)object2), "playable");
        this.a.n().logClickArtistChannelFromMorePopup(((Playable)object2), ((String)object0), ((String)object1));
        return H.a;
    }
}

