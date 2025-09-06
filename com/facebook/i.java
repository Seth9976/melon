package com.facebook;

public final class i implements Runnable {
    public final long a;

    public i(long v) {
        this.a = v;
    }

    @Override
    public final void run() {
        UserSettingsManager.initializeCodelessSetupEnabledAsync$lambda$0(this.a);
    }
}

