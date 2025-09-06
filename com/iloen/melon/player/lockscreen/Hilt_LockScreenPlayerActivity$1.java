package com.iloen.melon.player.lockscreen;

import android.content.Context;
import d.b;

class Hilt_LockScreenPlayerActivity.1 implements b {
    public final LockScreenPlayerActivity a;

    public Hilt_LockScreenPlayerActivity.1(LockScreenPlayerActivity lockScreenPlayerActivity0) {
        this.a = lockScreenPlayerActivity0;
    }

    @Override  // d.b
    public void onContextAvailable(Context context0) {
        this.a.inject();
    }
}

