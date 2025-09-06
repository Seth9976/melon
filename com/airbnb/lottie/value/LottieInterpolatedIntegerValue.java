package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieInterpolatedIntegerValue extends LottieInterpolatedValue {
    public LottieInterpolatedIntegerValue(Integer integer0, Integer integer1) {
        super(integer0, integer1);
    }

    public LottieInterpolatedIntegerValue(Integer integer0, Integer integer1, Interpolator interpolator0) {
        super(integer0, integer1, interpolator0);
    }

    @Override  // com.airbnb.lottie.value.LottieInterpolatedValue
    public Object getValue(LottieFrameInfo lottieFrameInfo0) {
        return super.getValue(lottieFrameInfo0);
    }

    public Integer interpolateValue(Integer integer0, Integer integer1, float f) {
        return MiscUtils.lerp(((int)integer0), ((int)integer1), f);
    }

    @Override  // com.airbnb.lottie.value.LottieInterpolatedValue
    public Object interpolateValue(Object object0, Object object1, float f) {
        return this.interpolateValue(((Integer)object0), ((Integer)object1), f);
    }
}

