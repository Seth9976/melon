package com.iloen.melon.player.video;

import eb.n;
import ge.b;

public final class VideoPipPvLogManager_Factory implements b {
    public final b a;

    public VideoPipPvLogManager_Factory(b b0) {
        this.a = b0;
    }

    public static VideoPipPvLogManager_Factory create(b b0) {
        return new VideoPipPvLogManager_Factory(b0);
    }

    public VideoPipPvLogManager get() {
        return VideoPipPvLogManager_Factory.newInstance(((n)this.a.get()));
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public static VideoPipPvLogManager newInstance(n n0) {
        return new VideoPipPvLogManager(n0);
    }
}

