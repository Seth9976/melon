package com.airbnb.lottie.configurations.reducemotion;

import android.content.Context;
import com.airbnb.lottie.utils.Utils;

public class SystemReducedMotionOption implements ReducedMotionOption {
    @Override  // com.airbnb.lottie.configurations.reducemotion.ReducedMotionOption
    public ReducedMotionMode getCurrentReducedMotionMode(Context context0) {
        return context0 == null || Utils.getAnimationScale(context0) != 0.0f ? ReducedMotionMode.STANDARD_MOTION : ReducedMotionMode.REDUCED_MOTION;
    }
}

