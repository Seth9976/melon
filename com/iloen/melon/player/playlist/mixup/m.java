package com.iloen.melon.player.playlist.mixup;

import com.iloen.melon.playback.Playable;
import we.k;

public final class m implements k {
    public final int a;
    public final MixUpPlaylistComposeViewModel b;

    public m(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0, int v) {
        this.a = v;
        this.b = mixUpPlaylistComposeViewModel0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0 = this.b;
        switch(this.a) {
            case 0: {
                return mixUpPlaylistComposeViewModel0.c().d(mixUpPlaylistComposeViewModel0.a, ((Playable)object0));
            }
            case 1: {
                return mixUpPlaylistComposeViewModel0.c().a(((Playable)object0));
            }
            case 2: {
                return mixUpPlaylistComposeViewModel0.c().b();
            }
            case 3: {
                return mixUpPlaylistComposeViewModel0.c().d(mixUpPlaylistComposeViewModel0.a, ((Playable)object0));
            }
            case 4: {
                return mixUpPlaylistComposeViewModel0.c().a(((Playable)object0));
            }
            default: {
                return mixUpPlaylistComposeViewModel0.c().b();
            }
        }
    }
}

