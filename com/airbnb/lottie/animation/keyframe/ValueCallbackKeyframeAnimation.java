package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;

public class ValueCallbackKeyframeAnimation extends BaseKeyframeAnimation {
    private final Object valueCallbackValue;

    public ValueCallbackKeyframeAnimation(LottieValueCallback lottieValueCallback0) {
        this(lottieValueCallback0, null);
    }

    public ValueCallbackKeyframeAnimation(LottieValueCallback lottieValueCallback0, Object object0) {
        super(Collections.EMPTY_LIST);
        this.setValueCallback(lottieValueCallback0);
        this.valueCallbackValue = object0;
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public float getEndProgress() {
        return 1.0f;
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Object getValue() {
        return this.valueCallback.getValueInternal(0.0f, 0.0f, this.valueCallbackValue, this.valueCallbackValue, this.getProgress(), this.getProgress(), this.getProgress());
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Object getValue(Keyframe keyframe0, float f) {
        return this.getValue();
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void notifyListeners() {
        if(this.valueCallback != null) {
            super.notifyListeners();
        }
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void setProgress(float f) {
        this.progress = f;
    }
}

