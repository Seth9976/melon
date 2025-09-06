package com.iloen.melon.player.playlist.mixup;

import ie.H;
import oc.U;
import we.k;

public final class o implements k {
    public final int a;
    public final MixUpPlaylistComposeViewModel b;
    public final boolean c;

    public o(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0, boolean z, int v) {
        this.a = v;
        this.b = mixUpPlaylistComposeViewModel0;
        this.c = z;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            MixUpPlaylistComposeViewModel.access$afterDeleteTask(this.b, this.c, ((U)object0));
            return H.a;
        }
        MixUpPlaylistComposeViewModel.access$afterDeleteTask(this.b, this.c, ((U)object0));
        return H.a;
    }
}

