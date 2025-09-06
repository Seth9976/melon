package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class GradientColorKeyframeAnimation extends KeyframeAnimation {
    private final GradientColor gradientColor;

    public GradientColorKeyframeAnimation(List list0) {
        super(list0);
        int v1 = 0;
        for(int v = 0; v < list0.size(); ++v) {
            GradientColor gradientColor0 = (GradientColor)((Keyframe)list0.get(v)).startValue;
            if(gradientColor0 != null) {
                v1 = Math.max(v1, gradientColor0.getSize());
            }
        }
        this.gradientColor = new GradientColor(new float[v1], new int[v1]);
    }

    public GradientColor getValue(Keyframe keyframe0, float f) {
        this.gradientColor.lerp(((GradientColor)keyframe0.startValue), ((GradientColor)keyframe0.endValue), f);
        return this.gradientColor;
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Object getValue(Keyframe keyframe0, float f) {
        return this.getValue(keyframe0, f);
    }
}

