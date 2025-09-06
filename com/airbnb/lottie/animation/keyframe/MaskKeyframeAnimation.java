package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;

public class MaskKeyframeAnimation {
    private final List maskAnimations;
    private final List masks;
    private final List opacityAnimations;

    public MaskKeyframeAnimation(List list0) {
        this.masks = list0;
        this.maskAnimations = new ArrayList(list0.size());
        this.opacityAnimations = new ArrayList(list0.size());
        for(int v = 0; v < list0.size(); ++v) {
            ShapeKeyframeAnimation shapeKeyframeAnimation0 = ((Mask)list0.get(v)).getMaskPath().createAnimation();
            this.maskAnimations.add(shapeKeyframeAnimation0);
            BaseKeyframeAnimation baseKeyframeAnimation0 = ((Mask)list0.get(v)).getOpacity().createAnimation();
            this.opacityAnimations.add(baseKeyframeAnimation0);
        }
    }

    public List getMaskAnimations() {
        return this.maskAnimations;
    }

    public List getMasks() {
        return this.masks;
    }

    public List getOpacityAnimations() {
        return this.opacityAnimations;
    }
}

