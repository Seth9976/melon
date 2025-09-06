package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.GradientColorKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.List;

public class AnimatableGradientColorValue extends BaseAnimatableValue {
    public AnimatableGradientColorValue(List list0) {
        super(AnimatableGradientColorValue.ensureInterpolatableKeyframes(list0));
    }

    @Override  // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation createAnimation() {
        return new GradientColorKeyframeAnimation(this.keyframes);
    }

    private static Keyframe ensureInterpolatableKeyframe(Keyframe keyframe0) {
        GradientColor gradientColor0 = (GradientColor)keyframe0.startValue;
        GradientColor gradientColor1 = (GradientColor)keyframe0.endValue;
        if(gradientColor0 != null && gradientColor1 != null && gradientColor0.getPositions().length != gradientColor1.getPositions().length) {
            float[] arr_f = AnimatableGradientColorValue.mergePositions(gradientColor0.getPositions(), gradientColor1.getPositions());
            return keyframe0.copyWith(gradientColor0.copyWithPositions(arr_f), gradientColor1.copyWithPositions(arr_f));
        }
        return keyframe0;
    }

    private static List ensureInterpolatableKeyframes(List list0) {
        for(int v = 0; v < list0.size(); ++v) {
            list0.set(v, AnimatableGradientColorValue.ensureInterpolatableKeyframe(((Keyframe)list0.get(v))));
        }
        return list0;
    }

    @Override  // com.airbnb.lottie.model.animatable.BaseAnimatableValue
    public List getKeyframes() {
        return super.getKeyframes();
    }

    @Override  // com.airbnb.lottie.model.animatable.BaseAnimatableValue
    public boolean isStatic() {
        return super.isStatic();
    }

    public static float[] mergePositions(float[] arr_f, float[] arr_f1) {
        int v = arr_f.length + arr_f1.length;
        float[] arr_f2 = new float[v];
        System.arraycopy(arr_f, 0, arr_f2, 0, arr_f.length);
        System.arraycopy(arr_f1, 0, arr_f2, arr_f.length, arr_f1.length);
        Arrays.sort(arr_f2);
        float f = NaNf;
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            float f1 = arr_f2[v1];
            if(f1 != f) {
                arr_f2[v2] = f1;
                ++v2;
                f = arr_f2[v1];
            }
        }
        return Arrays.copyOfRange(arr_f2, 0, v2);
    }

    @Override  // com.airbnb.lottie.model.animatable.BaseAnimatableValue
    public String toString() {
        return super.toString();
    }
}

