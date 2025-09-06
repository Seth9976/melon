package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.animatable.AnimatableFloatValue;

public class BlurEffect {
    final AnimatableFloatValue blurriness;

    public BlurEffect(AnimatableFloatValue animatableFloatValue0) {
        this.blurriness = animatableFloatValue0;
    }

    public AnimatableFloatValue getBlurriness() {
        return this.blurriness;
    }
}

