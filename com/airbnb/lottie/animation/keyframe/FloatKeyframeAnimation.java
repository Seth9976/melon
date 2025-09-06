package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class FloatKeyframeAnimation extends KeyframeAnimation {
    public FloatKeyframeAnimation(List list0) {
        super(list0);
    }

    public float getFloatValue() {
        return this.getFloatValue(this.getCurrentKeyframe(), this.getInterpolatedCurrentKeyframeProgress());
    }

    public float getFloatValue(Keyframe keyframe0, float f) {
        if(keyframe0.startValue == null || keyframe0.endValue == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        LottieValueCallback lottieValueCallback0 = this.valueCallback;
        if(lottieValueCallback0 != null) {
            float f1 = (float)keyframe0.endFrame;
            Float float0 = (Float)keyframe0.endValue;
            float f2 = this.getLinearCurrentKeyframeProgress();
            Float float1 = (Float)lottieValueCallback0.getValueInternal(keyframe0.startFrame, f1, ((Float)keyframe0.startValue), float0, f, f2, this.getProgress());
            return float1 == null ? MiscUtils.lerp(keyframe0.getStartValueFloat(), keyframe0.getEndValueFloat(), f) : ((float)float1);
        }
        return MiscUtils.lerp(keyframe0.getStartValueFloat(), keyframe0.getEndValueFloat(), f);
    }

    public Float getValue(Keyframe keyframe0, float f) {
        return this.getFloatValue(keyframe0, f);
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Object getValue(Keyframe keyframe0, float f) {
        return this.getValue(keyframe0, f);
    }
}

