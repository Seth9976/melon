package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class ColorKeyframeAnimation extends KeyframeAnimation {
    public ColorKeyframeAnimation(List list0) {
        super(list0);
    }

    public int getIntValue() {
        return this.getIntValue(this.getCurrentKeyframe(), this.getInterpolatedCurrentKeyframeProgress());
    }

    public int getIntValue(Keyframe keyframe0, float f) {
        if(keyframe0.startValue == null || keyframe0.endValue == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        LottieValueCallback lottieValueCallback0 = this.valueCallback;
        if(lottieValueCallback0 != null) {
            Float float0 = keyframe0.endFrame;
            if(float0 != null) {
                Integer integer0 = (Integer)keyframe0.endValue;
                float f1 = this.getLinearCurrentKeyframeProgress();
                Integer integer1 = (Integer)lottieValueCallback0.getValueInternal(keyframe0.startFrame, ((float)float0), ((Integer)keyframe0.startValue), integer0, f, f1, this.getProgress());
                return integer1 == null ? GammaEvaluator.evaluate(MiscUtils.clamp(f, 0.0f, 1.0f), ((int)(((Integer)keyframe0.startValue))), ((int)(((Integer)keyframe0.endValue)))) : ((int)integer1);
            }
        }
        return GammaEvaluator.evaluate(MiscUtils.clamp(f, 0.0f, 1.0f), ((int)(((Integer)keyframe0.startValue))), ((int)(((Integer)keyframe0.endValue))));
    }

    public Integer getValue(Keyframe keyframe0, float f) {
        return this.getIntValue(keyframe0, f);
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Object getValue(Keyframe keyframe0, float f) {
        return this.getValue(keyframe0, f);
    }
}

