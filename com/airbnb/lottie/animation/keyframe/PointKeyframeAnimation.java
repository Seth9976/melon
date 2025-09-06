package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.iloen.melon.utils.a;
import java.util.List;

public class PointKeyframeAnimation extends KeyframeAnimation {
    private final PointF point;

    public PointKeyframeAnimation(List list0) {
        super(list0);
        this.point = new PointF();
    }

    public PointF getValue(Keyframe keyframe0, float f) {
        return this.getValue(keyframe0, f, f, f);
    }

    public PointF getValue(Keyframe keyframe0, float f, float f1, float f2) {
        Object object0 = keyframe0.startValue;
        if(object0 != null) {
            Object object1 = keyframe0.endValue;
            if(object1 != null) {
                LottieValueCallback lottieValueCallback0 = this.valueCallback;
                if(lottieValueCallback0 != null) {
                    float f3 = (float)keyframe0.endFrame;
                    float f4 = this.getLinearCurrentKeyframeProgress();
                    PointF pointF0 = (PointF)lottieValueCallback0.getValueInternal(keyframe0.startFrame, f3, ((PointF)object0), ((PointF)object1), f, f4, this.getProgress());
                    if(pointF0 != null) {
                        return pointF0;
                    }
                }
                float f5 = ((PointF)object0).x;
                float f6 = a.c(((PointF)object1).x, f5, f1, f5);
                float f7 = ((PointF)object0).y;
                this.point.set(f6, a.c(((PointF)object1).y, f7, f2, f7));
                return this.point;
            }
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Object getValue(Keyframe keyframe0, float f) {
        return this.getValue(keyframe0, f);
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Object getValue(Keyframe keyframe0, float f, float f1, float f2) {
        return this.getValue(keyframe0, f, f1, f2);
    }
}

