package com.airbnb.lottie.animation.keyframe;

import android.graphics.Color;
import android.graphics.Matrix;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.parser.DropShadowEffect;
import com.airbnb.lottie.utils.DropShadow;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;

public class DropShadowKeyframeAnimation implements AnimationListener {
    private static final float AFTER_EFFECT_SOFTNESS_SCALE_FACTOR = 0.33f;
    private static final float DEG_TO_RAD = 0.017453f;
    private final BaseKeyframeAnimation color;
    private final FloatKeyframeAnimation direction;
    private final FloatKeyframeAnimation distance;
    private final BaseLayer layer;
    private Matrix layerInvMatrix;
    private final AnimationListener listener;
    private final FloatKeyframeAnimation opacity;
    private final FloatKeyframeAnimation radius;

    public DropShadowKeyframeAnimation(AnimationListener baseKeyframeAnimation$AnimationListener0, BaseLayer baseLayer0, DropShadowEffect dropShadowEffect0) {
        this.listener = baseKeyframeAnimation$AnimationListener0;
        this.layer = baseLayer0;
        BaseKeyframeAnimation baseKeyframeAnimation0 = dropShadowEffect0.getColor().createAnimation();
        this.color = baseKeyframeAnimation0;
        baseKeyframeAnimation0.addUpdateListener(this);
        baseLayer0.addAnimation(baseKeyframeAnimation0);
        FloatKeyframeAnimation floatKeyframeAnimation0 = dropShadowEffect0.getOpacity().createAnimation();
        this.opacity = floatKeyframeAnimation0;
        floatKeyframeAnimation0.addUpdateListener(this);
        baseLayer0.addAnimation(floatKeyframeAnimation0);
        FloatKeyframeAnimation floatKeyframeAnimation1 = dropShadowEffect0.getDirection().createAnimation();
        this.direction = floatKeyframeAnimation1;
        floatKeyframeAnimation1.addUpdateListener(this);
        baseLayer0.addAnimation(floatKeyframeAnimation1);
        FloatKeyframeAnimation floatKeyframeAnimation2 = dropShadowEffect0.getDistance().createAnimation();
        this.distance = floatKeyframeAnimation2;
        floatKeyframeAnimation2.addUpdateListener(this);
        baseLayer0.addAnimation(floatKeyframeAnimation2);
        FloatKeyframeAnimation floatKeyframeAnimation3 = dropShadowEffect0.getRadius().createAnimation();
        this.radius = floatKeyframeAnimation3;
        floatKeyframeAnimation3.addUpdateListener(this);
        baseLayer0.addAnimation(floatKeyframeAnimation3);
    }

    public DropShadow evaluate(Matrix matrix0, int v) {
        float f = this.direction.getFloatValue();
        float f1 = (float)(((Float)this.distance.getValue()));
        float f2 = (float)(((Float)this.radius.getValue()));
        int v1 = (int)(((Integer)this.color.getValue()));
        DropShadow dropShadow0 = new DropShadow(f2 * 0.33f, ((float)Math.sin(f * 0.017453f)) * f1, ((float)Math.cos(((double)(f * 0.017453f)) + 3.141593)) * f1, Color.argb(Math.round(((float)(((Float)this.opacity.getValue()))) * ((float)v) / 255.0f), Color.red(v1), Color.green(v1), Color.blue(v1)));
        dropShadow0.transformBy(matrix0);
        if(this.layerInvMatrix == null) {
            this.layerInvMatrix = new Matrix();
        }
        this.layer.transform.getMatrix().invert(this.layerInvMatrix);
        dropShadow0.transformBy(this.layerInvMatrix);
        return dropShadow0;
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener
    public void onValueChanged() {
        this.listener.onValueChanged();
    }

    public void setColorCallback(LottieValueCallback lottieValueCallback0) {
        this.color.setValueCallback(lottieValueCallback0);
    }

    public void setDirectionCallback(LottieValueCallback lottieValueCallback0) {
        this.direction.setValueCallback(lottieValueCallback0);
    }

    public void setDistanceCallback(LottieValueCallback lottieValueCallback0) {
        this.distance.setValueCallback(lottieValueCallback0);
    }

    public void setOpacityCallback(LottieValueCallback lottieValueCallback0) {
        if(lottieValueCallback0 == null) {
            this.opacity.setValueCallback(null);
            return;
        }
        com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation.1 dropShadowKeyframeAnimation$10 = new LottieValueCallback() {
            public Float getValue(LottieFrameInfo lottieFrameInfo0) {
                Float float0 = (Float)lottieValueCallback0.getValue(lottieFrameInfo0);
                return float0 == null ? null : ((float)(((float)float0) * 2.55f));
            }

            @Override  // com.airbnb.lottie.value.LottieValueCallback
            public Object getValue(LottieFrameInfo lottieFrameInfo0) {
                return this.getValue(lottieFrameInfo0);
            }
        };
        this.opacity.setValueCallback(dropShadowKeyframeAnimation$10);
    }

    public void setRadiusCallback(LottieValueCallback lottieValueCallback0) {
        this.radius.setValueCallback(lottieValueCallback0);
    }
}

