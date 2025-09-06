package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieInterpolatedPointValue extends LottieInterpolatedValue {
    private final PointF point;

    public LottieInterpolatedPointValue(PointF pointF0, PointF pointF1) {
        super(pointF0, pointF1);
        this.point = new PointF();
    }

    public LottieInterpolatedPointValue(PointF pointF0, PointF pointF1, Interpolator interpolator0) {
        super(pointF0, pointF1, interpolator0);
        this.point = new PointF();
    }

    @Override  // com.airbnb.lottie.value.LottieInterpolatedValue
    public Object getValue(LottieFrameInfo lottieFrameInfo0) {
        return super.getValue(lottieFrameInfo0);
    }

    public PointF interpolateValue(PointF pointF0, PointF pointF1, float f) {
        this.point.set(MiscUtils.lerp(pointF0.x, pointF1.x, f), MiscUtils.lerp(pointF0.y, pointF1.y, f));
        return this.point;
    }

    @Override  // com.airbnb.lottie.value.LottieInterpolatedValue
    public Object interpolateValue(Object object0, Object object1, float f) {
        return this.interpolateValue(((PointF)object0), ((PointF)object1), f);
    }
}

