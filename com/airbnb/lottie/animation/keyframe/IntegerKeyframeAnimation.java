package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class IntegerKeyframeAnimation extends KeyframeAnimation {
    public IntegerKeyframeAnimation(List list0) {
        super(list0);
    }

    public int getIntValue() {
        return this.getIntValue(this.getCurrentKeyframe(), this.getInterpolatedCurrentKeyframeProgress());
    }

    public int getIntValue(Keyframe keyframe0, float f) {
        if(keyframe0.startValue == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int v = keyframe0.endValue == null ? keyframe0.getStartValueInt() : keyframe0.getEndValueInt();
        LottieValueCallback lottieValueCallback0 = this.valueCallback;
        if(lottieValueCallback0 != null) {
            float f1 = (float)keyframe0.endFrame;
            float f2 = this.getLinearCurrentKeyframeProgress();
            Integer integer0 = (Integer)lottieValueCallback0.getValueInternal(keyframe0.startFrame, f1, ((Integer)keyframe0.startValue), v, f, f2, this.getProgress());
            return integer0 == null ? MiscUtils.lerp(keyframe0.getStartValueInt(), v, f) : ((int)integer0);
        }
        return MiscUtils.lerp(keyframe0.getStartValueInt(), v, f);
    }

    public Integer getValue(Keyframe keyframe0, float f) {
        return this.getIntValue(keyframe0, f);
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Object getValue(Keyframe keyframe0, float f) {
        return this.getValue(keyframe0, f);
    }
}

