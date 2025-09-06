package com.facebook.appevents.internal;

public final class b implements Runnable {
    public final int a;
    public final long b;
    public final String c;

    public b(long v, String s, int v1) {
        this.a = v1;
        this.b = v;
        this.c = s;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            ActivityLifecycleTracker.onActivityPaused$lambda$7$lambda$5(this.b, this.c);
            return;
        }
        ActivityLifecycleTracker.onActivityPaused$lambda$7(this.b, this.c);
    }
}

