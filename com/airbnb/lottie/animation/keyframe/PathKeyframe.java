package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;

public class PathKeyframe extends Keyframe {
    private Path path;
    private final Keyframe pointKeyFrame;

    public PathKeyframe(LottieComposition lottieComposition0, Keyframe keyframe0) {
        super(lottieComposition0, ((PointF)keyframe0.startValue), ((PointF)keyframe0.endValue), keyframe0.interpolator, keyframe0.xInterpolator, keyframe0.yInterpolator, keyframe0.startFrame, keyframe0.endFrame);
        this.pointKeyFrame = keyframe0;
        this.createPath();
    }

    public void createPath() {
        boolean z = this.endValue != null && (this.startValue != null && ((PointF)this.startValue).equals(((PointF)this.endValue).x, ((PointF)this.endValue).y));
        Object object0 = this.startValue;
        if(object0 != null) {
            Object object1 = this.endValue;
            if(object1 != null && !z) {
                this.path = Utils.createPath(((PointF)object0), ((PointF)object1), this.pointKeyFrame.pathCp1, this.pointKeyFrame.pathCp2);
            }
        }
    }

    public Path getPath() {
        return this.path;
    }
}

