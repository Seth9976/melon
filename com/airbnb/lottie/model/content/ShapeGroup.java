package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.Arrays;
import java.util.List;

public class ShapeGroup implements ContentModel {
    private final boolean hidden;
    private final List items;
    private final String name;

    public ShapeGroup(String s, List list0, boolean z) {
        this.name = s;
        this.items = list0;
        this.hidden = z;
    }

    public List getItems() {
        return this.items;
    }

    public String getName() {
        return this.name;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    @Override  // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable0, LottieComposition lottieComposition0, BaseLayer baseLayer0) {
        return new ContentGroup(lottieDrawable0, baseLayer0, this, lottieComposition0);
    }

    @Override
    public String toString() {
        return "ShapeGroup{name=\'" + this.name + "\' Shapes: " + Arrays.toString(this.items.toArray()) + '}';
    }
}

