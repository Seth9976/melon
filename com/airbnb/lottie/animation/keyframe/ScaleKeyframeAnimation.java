package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

public class ScaleKeyframeAnimation extends KeyframeAnimation {
    private final ScaleXY scaleXY;

    public ScaleKeyframeAnimation(List list0) {
        super(list0);
        this.scaleXY = new ScaleXY();
    }

    public ScaleXY getValue(Keyframe keyframe0, float f) {
        Object object0 = keyframe0.startValue;
        if(object0 != null) {
            Object object1 = keyframe0.endValue;
            if(object1 != null) {
                LottieValueCallback lottieValueCallback0 = this.valueCallback;
                if(lottieValueCallback0 != null) {
                    float f1 = (float)keyframe0.endFrame;
                    float f2 = this.getLinearCurrentKeyframeProgress();
                    ScaleXY scaleXY0 = (ScaleXY)lottieValueCallback0.getValueInternal(keyframe0.startFrame, f1, ((ScaleXY)object0), ((ScaleXY)object1), f, f2, this.getProgress());
                    if(scaleXY0 != null) {
                        return scaleXY0;
                    }
                }
                this.scaleXY.set(MiscUtils.lerp(((ScaleXY)object0).getScaleX(), ((ScaleXY)object1).getScaleX(), f), MiscUtils.lerp(((ScaleXY)object0).getScaleY(), ((ScaleXY)object1).getScaleY(), f));
                return this.scaleXY;
            }
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Object getValue(Keyframe keyframe0, float f) {
        return this.getValue(keyframe0, f);
    }
}

