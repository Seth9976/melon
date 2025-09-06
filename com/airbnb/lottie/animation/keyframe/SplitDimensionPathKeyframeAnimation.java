package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;

public class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation {
    private final PointF point;
    private final PointF pointWithCallbackValues;
    private final BaseKeyframeAnimation xAnimation;
    protected LottieValueCallback xValueCallback;
    private final BaseKeyframeAnimation yAnimation;
    protected LottieValueCallback yValueCallback;

    public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation baseKeyframeAnimation0, BaseKeyframeAnimation baseKeyframeAnimation1) {
        super(Collections.EMPTY_LIST);
        this.point = new PointF();
        this.pointWithCallbackValues = new PointF();
        this.xAnimation = baseKeyframeAnimation0;
        this.yAnimation = baseKeyframeAnimation1;
        this.setProgress(this.getProgress());
    }

    public PointF getValue() {
        return this.getValue(null, 0.0f);
    }

    public PointF getValue(Keyframe keyframe0, float f) {
        Float float2;
        Float float0 = null;
        if(this.xValueCallback == null) {
            float2 = null;
        }
        else {
            Keyframe keyframe1 = this.xAnimation.getCurrentKeyframe();
            if(keyframe1 == null) {
                float2 = null;
            }
            else {
                LottieValueCallback lottieValueCallback0 = this.xValueCallback;
                float f1 = keyframe1.endFrame == null ? keyframe1.startFrame : ((float)keyframe1.endFrame);
                Float float1 = (Float)keyframe1.endValue;
                float f2 = this.xAnimation.getInterpolatedCurrentKeyframeProgress();
                float f3 = this.xAnimation.getLinearCurrentKeyframeProgress();
                float2 = (Float)lottieValueCallback0.getValueInternal(keyframe1.startFrame, f1, ((Float)keyframe1.startValue), float1, f2, f3, this.xAnimation.getProgress());
            }
        }
        if(this.yValueCallback != null) {
            Keyframe keyframe2 = this.yAnimation.getCurrentKeyframe();
            if(keyframe2 != null) {
                LottieValueCallback lottieValueCallback1 = this.yValueCallback;
                float f4 = keyframe2.endFrame == null ? keyframe2.startFrame : ((float)keyframe2.endFrame);
                Float float3 = (Float)keyframe2.endValue;
                float f5 = this.yAnimation.getInterpolatedCurrentKeyframeProgress();
                float f6 = this.yAnimation.getLinearCurrentKeyframeProgress();
                float0 = (Float)lottieValueCallback1.getValueInternal(keyframe2.startFrame, f4, ((Float)keyframe2.startValue), float3, f5, f6, this.yAnimation.getProgress());
            }
        }
        if(float2 == null) {
            this.pointWithCallbackValues.set(this.point.x, 0.0f);
        }
        else {
            this.pointWithCallbackValues.set(((float)float2), 0.0f);
        }
        if(float0 == null) {
            this.pointWithCallbackValues.set(this.pointWithCallbackValues.x, this.point.y);
            return this.pointWithCallbackValues;
        }
        this.pointWithCallbackValues.set(this.pointWithCallbackValues.x, ((float)float0));
        return this.pointWithCallbackValues;
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Object getValue() {
        return this.getValue();
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Object getValue(Keyframe keyframe0, float f) {
        return this.getValue(keyframe0, f);
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void setProgress(float f) {
        this.xAnimation.setProgress(f);
        this.yAnimation.setProgress(f);
        float f1 = (float)(((Float)this.xAnimation.getValue()));
        float f2 = (float)(((Float)this.yAnimation.getValue()));
        this.point.set(f1, f2);
        for(int v = 0; v < this.listeners.size(); ++v) {
            ((AnimationListener)this.listeners.get(v)).onValueChanged();
        }
    }

    public void setXValueCallback(LottieValueCallback lottieValueCallback0) {
        LottieValueCallback lottieValueCallback1 = this.xValueCallback;
        if(lottieValueCallback1 != null) {
            lottieValueCallback1.setAnimation(null);
        }
        this.xValueCallback = lottieValueCallback0;
        if(lottieValueCallback0 != null) {
            lottieValueCallback0.setAnimation(this);
        }
    }

    public void setYValueCallback(LottieValueCallback lottieValueCallback0) {
        LottieValueCallback lottieValueCallback1 = this.yValueCallback;
        if(lottieValueCallback1 != null) {
            lottieValueCallback1.setAnimation(null);
        }
        this.yValueCallback = lottieValueCallback0;
        if(lottieValueCallback0 != null) {
            lottieValueCallback0.setAnimation(this);
        }
    }
}

