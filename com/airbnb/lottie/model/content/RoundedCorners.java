package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RoundedCornersContent;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class RoundedCorners implements ContentModel {
    private final AnimatableValue cornerRadius;
    private final String name;

    public RoundedCorners(String s, AnimatableValue animatableValue0) {
        this.name = s;
        this.cornerRadius = animatableValue0;
    }

    public AnimatableValue getCornerRadius() {
        return this.cornerRadius;
    }

    public String getName() {
        return this.name;
    }

    @Override  // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable0, LottieComposition lottieComposition0, BaseLayer baseLayer0) {
        return new RoundedCornersContent(lottieDrawable0, baseLayer0, this);
    }
}

