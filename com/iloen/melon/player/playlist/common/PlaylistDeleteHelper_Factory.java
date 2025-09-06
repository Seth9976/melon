package com.iloen.melon.player.playlist.common;

import Pc.d;
import ge.b;
import kc.s2;
import ob.z;

public final class PlaylistDeleteHelper_Factory implements b {
    public final b a;
    public final b b;
    public final b c;

    public PlaylistDeleteHelper_Factory(b b0, b b1, b b2) {
        this.a = b0;
        this.b = b1;
        this.c = b2;
    }

    public static PlaylistDeleteHelper_Factory create(b b0, b b1, b b2) {
        return new PlaylistDeleteHelper_Factory(b0, b1, b2);
    }

    public PlaylistDeleteHelper get() {
        return PlaylistDeleteHelper_Factory.newInstance(((s2)this.a.get()), ((z)this.b.get()), ((d)this.c.get()));
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public static PlaylistDeleteHelper newInstance(s2 s20, z z0, d d0) {
        return new PlaylistDeleteHelper(s20, z0, d0);
    }
}

