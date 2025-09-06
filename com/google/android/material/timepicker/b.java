package com.google.android.material.timepicker;

import android.view.ViewTreeObserver.OnPreDrawListener;

public final class b implements ViewTreeObserver.OnPreDrawListener {
    public final ClockFaceView a;

    public b(ClockFaceView clockFaceView0) {
        this.a = clockFaceView0;
    }

    @Override  // android.view.ViewTreeObserver$OnPreDrawListener
    public final boolean onPreDraw() {
        ClockFaceView clockFaceView0 = this.a;
        if(!clockFaceView0.isShown()) {
            return true;
        }
        clockFaceView0.getViewTreeObserver().removeOnPreDrawListener(this);
        int v = clockFaceView0.getHeight() / 2 - clockFaceView0.B.d - clockFaceView0.T;
        if(v != clockFaceView0.r) {
            clockFaceView0.r = v;
            clockFaceView0.c();
            clockFaceView0.B.l = clockFaceView0.r;
            clockFaceView0.B.invalidate();
        }
        return true;
    }
}

