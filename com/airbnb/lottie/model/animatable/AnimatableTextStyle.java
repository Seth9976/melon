package com.airbnb.lottie.model.animatable;

public class AnimatableTextStyle {
    public final AnimatableColorValue color;
    public final AnimatableIntegerValue opacity;
    public final AnimatableColorValue stroke;
    public final AnimatableFloatValue strokeWidth;
    public final AnimatableFloatValue tracking;

    public AnimatableTextStyle(AnimatableColorValue animatableColorValue0, AnimatableColorValue animatableColorValue1, AnimatableFloatValue animatableFloatValue0, AnimatableFloatValue animatableFloatValue1, AnimatableIntegerValue animatableIntegerValue0) {
        this.color = animatableColorValue0;
        this.stroke = animatableColorValue1;
        this.strokeWidth = animatableFloatValue0;
        this.tracking = animatableFloatValue1;
        this.opacity = animatableIntegerValue0;
    }
}

