package com.airbnb.lottie.model.content;

import androidx.appcompat.app.o;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ShapeContent;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class ShapePath implements ContentModel {
    private final boolean hidden;
    private final int index;
    private final String name;
    private final AnimatableShapeValue shapePath;

    public ShapePath(String s, int v, AnimatableShapeValue animatableShapeValue0, boolean z) {
        this.name = s;
        this.index = v;
        this.shapePath = animatableShapeValue0;
        this.hidden = z;
    }

    public String getName() {
        return this.name;
    }

    public AnimatableShapeValue getShapePath() {
        return this.shapePath;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    @Override  // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable0, LottieComposition lottieComposition0, BaseLayer baseLayer0) {
        return new ShapeContent(lottieDrawable0, baseLayer0, this);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ShapePath{name=");
        stringBuilder0.append(this.name);
        stringBuilder0.append(", index=");
        return o.q(stringBuilder0, this.index, '}');
    }
}

