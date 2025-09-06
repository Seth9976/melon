package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

public class TrimPathContent implements Content, AnimationListener {
    private final BaseKeyframeAnimation endAnimation;
    private final boolean hidden;
    private final List listeners;
    private final String name;
    private final BaseKeyframeAnimation offsetAnimation;
    private final BaseKeyframeAnimation startAnimation;
    private final Type type;

    public TrimPathContent(BaseLayer baseLayer0, ShapeTrimPath shapeTrimPath0) {
        this.listeners = new ArrayList();
        this.name = shapeTrimPath0.getName();
        this.hidden = shapeTrimPath0.isHidden();
        this.type = shapeTrimPath0.getType();
        FloatKeyframeAnimation floatKeyframeAnimation0 = shapeTrimPath0.getStart().createAnimation();
        this.startAnimation = floatKeyframeAnimation0;
        FloatKeyframeAnimation floatKeyframeAnimation1 = shapeTrimPath0.getEnd().createAnimation();
        this.endAnimation = floatKeyframeAnimation1;
        FloatKeyframeAnimation floatKeyframeAnimation2 = shapeTrimPath0.getOffset().createAnimation();
        this.offsetAnimation = floatKeyframeAnimation2;
        baseLayer0.addAnimation(floatKeyframeAnimation0);
        baseLayer0.addAnimation(floatKeyframeAnimation1);
        baseLayer0.addAnimation(floatKeyframeAnimation2);
        floatKeyframeAnimation0.addUpdateListener(this);
        floatKeyframeAnimation1.addUpdateListener(this);
        floatKeyframeAnimation2.addUpdateListener(this);
    }

    public void addListener(AnimationListener baseKeyframeAnimation$AnimationListener0) {
        this.listeners.add(baseKeyframeAnimation$AnimationListener0);
    }

    public BaseKeyframeAnimation getEnd() {
        return this.endAnimation;
    }

    @Override  // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    public BaseKeyframeAnimation getOffset() {
        return this.offsetAnimation;
    }

    public BaseKeyframeAnimation getStart() {
        return this.startAnimation;
    }

    public Type getType() {
        return this.type;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener
    public void onValueChanged() {
        for(int v = 0; v < this.listeners.size(); ++v) {
            ((AnimationListener)this.listeners.get(v)).onValueChanged();
        }
    }

    @Override  // com.airbnb.lottie.animation.content.Content
    public void setContents(List list0, List list1) {
    }
}

