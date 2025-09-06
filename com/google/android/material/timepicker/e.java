package com.google.android.material.timepicker;

public final class e implements Runnable {
    public final RadialViewGroup a;

    public e(RadialViewGroup radialViewGroup0) {
        this.a = radialViewGroup0;
    }

    @Override
    public final void run() {
        this.a.c();
    }
}

