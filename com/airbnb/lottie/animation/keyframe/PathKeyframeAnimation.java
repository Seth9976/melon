package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class PathKeyframeAnimation extends KeyframeAnimation {
    private final PathMeasure pathMeasure;
    private PathKeyframe pathMeasureKeyframe;
    private final PointF point;
    private final float[] pos;
    private final float[] tangent;

    public PathKeyframeAnimation(List list0) {
        super(list0);
        this.point = new PointF();
        this.pos = new float[2];
        this.tangent = new float[2];
        this.pathMeasure = new PathMeasure();
    }

    public PointF getValue(Keyframe keyframe0, float f) {
        Path path0 = ((PathKeyframe)keyframe0).getPath();
        LottieValueCallback lottieValueCallback0 = this.valueCallback;
        if(lottieValueCallback0 != null && keyframe0.endFrame != null) {
            float f1 = (float)((PathKeyframe)keyframe0).endFrame;
            PointF pointF0 = (PointF)((PathKeyframe)keyframe0).endValue;
            float f2 = this.getLinearCurrentKeyframeProgress();
            PointF pointF1 = (PointF)lottieValueCallback0.getValueInternal(((PathKeyframe)keyframe0).startFrame, f1, ((PointF)((PathKeyframe)keyframe0).startValue), pointF0, f2, f, this.getProgress());
            if(pointF1 != null) {
                return pointF1;
            }
        }
        if(path0 == null) {
            return (PointF)keyframe0.startValue;
        }
        if(this.pathMeasureKeyframe != ((PathKeyframe)keyframe0)) {
            this.pathMeasure.setPath(path0, false);
            this.pathMeasureKeyframe = (PathKeyframe)keyframe0;
        }
        float f3 = this.pathMeasure.getLength();
        float f4 = f * f3;
        this.pathMeasure.getPosTan(f4, this.pos, this.tangent);
        this.point.set(this.pos[0], this.pos[1]);
        if(f4 < 0.0f) {
            this.point.offset(this.tangent[0] * f4, this.tangent[1] * f4);
            return this.point;
        }
        if(f4 > f3) {
            this.point.offset(this.tangent[0] * (f4 - f3), this.tangent[1] * (f4 - f3));
        }
        return this.point;
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Object getValue(Keyframe keyframe0, float f) {
        return this.getValue(keyframe0, f);
    }
}

