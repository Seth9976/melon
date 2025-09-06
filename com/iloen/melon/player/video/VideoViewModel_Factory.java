package com.iloen.melon.player.video;

import ge.b;
import kc.s2;
import ob.z;

public final class VideoViewModel_Factory implements b {
    public final b a;
    public final b b;
    public final b c;

    public VideoViewModel_Factory(b b0, b b1, b b2) {
        this.a = b0;
        this.b = b1;
        this.c = b2;
    }

    public static VideoViewModel_Factory create(b b0, b b1, b b2) {
        return new VideoViewModel_Factory(b0, b1, b2);
    }

    public VideoViewModel get() {
        return VideoViewModel_Factory.newInstance(((VideoPipPvLogManager)this.a.get()), ((s2)this.b.get()), ((z)this.c.get()));
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public static VideoViewModel newInstance(VideoPipPvLogManager videoPipPvLogManager0, s2 s20, z z0) {
        return new VideoViewModel(videoPipPvLogManager0, s20, z0);
    }
}

