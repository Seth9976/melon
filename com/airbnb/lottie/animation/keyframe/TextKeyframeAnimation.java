package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class TextKeyframeAnimation extends KeyframeAnimation {
    public TextKeyframeAnimation(List list0) {
        super(list0);
    }

    public DocumentData getValue(Keyframe keyframe0, float f) {
        LottieValueCallback lottieValueCallback0 = this.valueCallback;
        if(lottieValueCallback0 != null) {
            float f1 = keyframe0.endFrame == null ? 3.402823E+38f : ((float)keyframe0.endFrame);
            return keyframe0.endValue == null ? ((DocumentData)lottieValueCallback0.getValueInternal(keyframe0.startFrame, f1, ((DocumentData)keyframe0.startValue), ((DocumentData)keyframe0.startValue), f, this.getInterpolatedCurrentKeyframeProgress(), this.getProgress())) : ((DocumentData)lottieValueCallback0.getValueInternal(keyframe0.startFrame, f1, ((DocumentData)keyframe0.startValue), ((DocumentData)keyframe0.endValue), f, this.getInterpolatedCurrentKeyframeProgress(), this.getProgress()));
        }
        if(f == 1.0f) {
            return keyframe0.endValue == null ? ((DocumentData)keyframe0.startValue) : ((DocumentData)keyframe0.endValue);
        }
        return (DocumentData)keyframe0.startValue;
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Object getValue(Keyframe keyframe0, float f) {
        return this.getValue(keyframe0, f);
    }

    public void setStringValueCallback(LottieValueCallback lottieValueCallback0) {
        super.setValueCallback(new LottieValueCallback() {
            public DocumentData getValue(LottieFrameInfo lottieFrameInfo0) {
                new LottieFrameInfo().set(lottieFrameInfo0.getStartFrame(), lottieFrameInfo0.getEndFrame(), ((DocumentData)lottieFrameInfo0.getStartValue()).text, ((DocumentData)lottieFrameInfo0.getEndValue()).text, lottieFrameInfo0.getLinearKeyframeProgress(), lottieFrameInfo0.getInterpolatedKeyframeProgress(), lottieFrameInfo0.getOverallProgress());
                Object object0 = lottieValueCallback0.getValue(new LottieFrameInfo());
                Object object1 = lottieFrameInfo0.getInterpolatedKeyframeProgress() == 1.0f ? lottieFrameInfo0.getEndValue() : lottieFrameInfo0.getStartValue();
                new DocumentData().set(((String)object0), ((DocumentData)object1).fontName, ((DocumentData)object1).size, ((DocumentData)object1).justification, ((DocumentData)object1).tracking, ((DocumentData)object1).lineHeight, ((DocumentData)object1).baselineShift, ((DocumentData)object1).color, ((DocumentData)object1).strokeColor, ((DocumentData)object1).strokeWidth, ((DocumentData)object1).strokeOverFill, ((DocumentData)object1).boxPosition, ((DocumentData)object1).boxSize);
                return new DocumentData();
            }

            @Override  // com.airbnb.lottie.value.LottieValueCallback
            public Object getValue(LottieFrameInfo lottieFrameInfo0) {
                return this.getValue(lottieFrameInfo0);
            }
        });
    }
}

