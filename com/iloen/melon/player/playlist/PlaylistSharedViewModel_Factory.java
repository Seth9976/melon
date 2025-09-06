package com.iloen.melon.player.playlist;

import ge.b;
import kc.s2;

public final class PlaylistSharedViewModel_Factory implements b {
    public final b a;

    public PlaylistSharedViewModel_Factory(b b0) {
        this.a = b0;
    }

    public static PlaylistSharedViewModel_Factory create(b b0) {
        return new PlaylistSharedViewModel_Factory(b0);
    }

    public PlaylistSharedViewModel get() {
        return PlaylistSharedViewModel_Factory.newInstance(((s2)this.a.get()));
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public static PlaylistSharedViewModel newInstance(s2 s20) {
        return new PlaylistSharedViewModel(s20);
    }
}

