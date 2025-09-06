package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.airbnb.lottie.model.content.ShapeData;

public interface ShapeModifierContent extends Content {
    void addUpdateListener(AnimationListener arg1);

    ShapeData modifyShape(ShapeData arg1);
}

