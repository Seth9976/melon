package com.airbnb.lottie.configurations.reducemotion;

import android.content.Context;

public class IgnoreDisabledSystemAnimationsOption implements ReducedMotionOption {
    @Override  // com.airbnb.lottie.configurations.reducemotion.ReducedMotionOption
    public ReducedMotionMode getCurrentReducedMotionMode(Context context0) {
        return ReducedMotionMode.STANDARD_MOTION;
    }
}

