package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;

public class LottieRelativeIntegerValueCallback extends LottieValueCallback {
    public Integer getOffset(LottieFrameInfo lottieFrameInfo0) {
        Object object0 = this.value;
        if(object0 == null) {
            throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
        }
        return (Integer)object0;
    }

    public Integer getValue(LottieFrameInfo lottieFrameInfo0) {
        return (int)(((int)this.getOffset(lottieFrameInfo0)) + MiscUtils.lerp(((int)(((Integer)lottieFrameInfo0.getStartValue()))), ((int)(((Integer)lottieFrameInfo0.getEndValue()))), lottieFrameInfo0.getInterpolatedKeyframeProgress()));
    }

    @Override  // com.airbnb.lottie.value.LottieValueCallback
    public Object getValue(LottieFrameInfo lottieFrameInfo0) {
        return this.getValue(lottieFrameInfo0);
    }
}

