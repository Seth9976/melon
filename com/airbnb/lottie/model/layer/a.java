package com.airbnb.lottie.model.layer;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener;

public final class a implements AnimationListener {
    public final BaseLayer a;

    public a(BaseLayer baseLayer0) {
        this.a = baseLayer0;
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener
    public final void onValueChanged() {
        this.a.lambda$setupInOutAnimations$0();
    }
}

