package com.google.android.material.internal;

import android.animation.TimeInterpolator;

public final class t implements TimeInterpolator {
    public final TimeInterpolator a;

    public t(TimeInterpolator timeInterpolator0) {
        this.a = timeInterpolator0;
    }

    public static TimeInterpolator a(boolean z, TimeInterpolator timeInterpolator0) {
        return z ? timeInterpolator0 : new t(timeInterpolator0);
    }

    @Override  // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        return 1.0f - this.a.getInterpolation(f);
    }
}

