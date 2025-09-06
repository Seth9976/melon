package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;

public class DropShadowEffect {
    private final AnimatableColorValue color;
    private final AnimatableFloatValue direction;
    private final AnimatableFloatValue distance;
    private final AnimatableFloatValue opacity;
    private final AnimatableFloatValue radius;

    public DropShadowEffect(AnimatableColorValue animatableColorValue0, AnimatableFloatValue animatableFloatValue0, AnimatableFloatValue animatableFloatValue1, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3) {
        this.color = animatableColorValue0;
        this.opacity = animatableFloatValue0;
        this.direction = animatableFloatValue1;
        this.distance = animatableFloatValue2;
        this.radius = animatableFloatValue3;
    }

    public AnimatableColorValue getColor() {
        return this.color;
    }

    public AnimatableFloatValue getDirection() {
        return this.direction;
    }

    public AnimatableFloatValue getDistance() {
        return this.distance;
    }

    public AnimatableFloatValue getOpacity() {
        return this.opacity;
    }

    public AnimatableFloatValue getRadius() {
        return this.radius;
    }
}

