package com.iloen.melon.player.video;

import ge.b;
import kc.s2;
import ob.z;

public final class LiveViewModel_Factory implements b {
    public final b a;
    public final b b;
    public final b c;

    public LiveViewModel_Factory(b b0, b b1, b b2) {
        this.a = b0;
        this.b = b1;
        this.c = b2;
    }

    public static LiveViewModel_Factory create(b b0, b b1, b b2) {
        return new LiveViewModel_Factory(b0, b1, b2);
    }

    public LiveViewModel get() {
        return LiveViewModel_Factory.newInstance(((VideoPipPvLogManager)this.a.get()), ((s2)this.b.get()), ((z)this.c.get()));
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public static LiveViewModel newInstance(VideoPipPvLogManager videoPipPvLogManager0, s2 s20, z z0) {
        return new LiveViewModel(videoPipPvLogManager0, s20, z0);
    }
}

