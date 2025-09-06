package com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.Collections;

public class TransformKeyframeAnimation {
    private BaseKeyframeAnimation anchorPoint;
    private final boolean autoOrient;
    private BaseKeyframeAnimation endOpacity;
    private final Matrix matrix;
    private BaseKeyframeAnimation opacity;
    private BaseKeyframeAnimation position;
    private BaseKeyframeAnimation rotation;
    private BaseKeyframeAnimation scale;
    private FloatKeyframeAnimation skew;
    private FloatKeyframeAnimation skewAngle;
    private final Matrix skewMatrix1;
    private final Matrix skewMatrix2;
    private final Matrix skewMatrix3;
    private final float[] skewValues;
    private BaseKeyframeAnimation startOpacity;

    public TransformKeyframeAnimation(AnimatableTransform animatableTransform0) {
        this.matrix = new Matrix();
        this.anchorPoint = animatableTransform0.getAnchorPoint() == null ? null : animatableTransform0.getAnchorPoint().createAnimation();
        this.position = animatableTransform0.getPosition() == null ? null : animatableTransform0.getPosition().createAnimation();
        this.scale = animatableTransform0.getScale() == null ? null : animatableTransform0.getScale().createAnimation();
        this.rotation = animatableTransform0.getRotation() == null ? null : animatableTransform0.getRotation().createAnimation();
        this.skew = animatableTransform0.getSkew() == null ? null : animatableTransform0.getSkew().createAnimation();
        this.autoOrient = animatableTransform0.isAutoOrient();
        if(this.skew == null) {
            this.skewMatrix1 = null;
            this.skewMatrix2 = null;
            this.skewMatrix3 = null;
            this.skewValues = null;
        }
        else {
            this.skewMatrix1 = new Matrix();
            this.skewMatrix2 = new Matrix();
            this.skewMatrix3 = new Matrix();
            this.skewValues = new float[9];
        }
        this.skewAngle = animatableTransform0.getSkewAngle() == null ? null : animatableTransform0.getSkewAngle().createAnimation();
        if(animatableTransform0.getOpacity() != null) {
            this.opacity = animatableTransform0.getOpacity().createAnimation();
        }
        this.startOpacity = animatableTransform0.getStartOpacity() == null ? null : animatableTransform0.getStartOpacity().createAnimation();
        if(animatableTransform0.getEndOpacity() != null) {
            this.endOpacity = animatableTransform0.getEndOpacity().createAnimation();
            return;
        }
        this.endOpacity = null;
    }

    public void addAnimationsToLayer(BaseLayer baseLayer0) {
        baseLayer0.addAnimation(this.opacity);
        baseLayer0.addAnimation(this.startOpacity);
        baseLayer0.addAnimation(this.endOpacity);
        baseLayer0.addAnimation(this.anchorPoint);
        baseLayer0.addAnimation(this.position);
        baseLayer0.addAnimation(this.scale);
        baseLayer0.addAnimation(this.rotation);
        baseLayer0.addAnimation(this.skew);
        baseLayer0.addAnimation(this.skewAngle);
    }

    public void addListener(AnimationListener baseKeyframeAnimation$AnimationListener0) {
        BaseKeyframeAnimation baseKeyframeAnimation0 = this.opacity;
        if(baseKeyframeAnimation0 != null) {
            baseKeyframeAnimation0.addUpdateListener(baseKeyframeAnimation$AnimationListener0);
        }
        BaseKeyframeAnimation baseKeyframeAnimation1 = this.startOpacity;
        if(baseKeyframeAnimation1 != null) {
            baseKeyframeAnimation1.addUpdateListener(baseKeyframeAnimation$AnimationListener0);
        }
        BaseKeyframeAnimation baseKeyframeAnimation2 = this.endOpacity;
        if(baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.addUpdateListener(baseKeyframeAnimation$AnimationListener0);
        }
        BaseKeyframeAnimation baseKeyframeAnimation3 = this.anchorPoint;
        if(baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.addUpdateListener(baseKeyframeAnimation$AnimationListener0);
        }
        BaseKeyframeAnimation baseKeyframeAnimation4 = this.position;
        if(baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.addUpdateListener(baseKeyframeAnimation$AnimationListener0);
        }
        BaseKeyframeAnimation baseKeyframeAnimation5 = this.scale;
        if(baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.addUpdateListener(baseKeyframeAnimation$AnimationListener0);
        }
        BaseKeyframeAnimation baseKeyframeAnimation6 = this.rotation;
        if(baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.addUpdateListener(baseKeyframeAnimation$AnimationListener0);
        }
        FloatKeyframeAnimation floatKeyframeAnimation0 = this.skew;
        if(floatKeyframeAnimation0 != null) {
            floatKeyframeAnimation0.addUpdateListener(baseKeyframeAnimation$AnimationListener0);
        }
        FloatKeyframeAnimation floatKeyframeAnimation1 = this.skewAngle;
        if(floatKeyframeAnimation1 != null) {
            floatKeyframeAnimation1.addUpdateListener(baseKeyframeAnimation$AnimationListener0);
        }
    }

    public boolean applyValueCallback(Object object0, LottieValueCallback lottieValueCallback0) {
        if(object0 == LottieProperty.TRANSFORM_ANCHOR_POINT) {
            BaseKeyframeAnimation baseKeyframeAnimation0 = this.anchorPoint;
            if(baseKeyframeAnimation0 == null) {
                this.anchorPoint = new ValueCallbackKeyframeAnimation(lottieValueCallback0, new PointF());
                return true;
            }
            baseKeyframeAnimation0.setValueCallback(lottieValueCallback0);
            return true;
        }
        if(object0 == LottieProperty.TRANSFORM_POSITION) {
            BaseKeyframeAnimation baseKeyframeAnimation1 = this.position;
            if(baseKeyframeAnimation1 == null) {
                this.position = new ValueCallbackKeyframeAnimation(lottieValueCallback0, new PointF());
                return true;
            }
            baseKeyframeAnimation1.setValueCallback(lottieValueCallback0);
            return true;
        }
        if(object0 == LottieProperty.TRANSFORM_POSITION_X) {
            BaseKeyframeAnimation baseKeyframeAnimation2 = this.position;
            if(baseKeyframeAnimation2 instanceof SplitDimensionPathKeyframeAnimation) {
                ((SplitDimensionPathKeyframeAnimation)baseKeyframeAnimation2).setXValueCallback(lottieValueCallback0);
                return true;
            }
        }
        if(object0 == LottieProperty.TRANSFORM_POSITION_Y) {
            BaseKeyframeAnimation baseKeyframeAnimation3 = this.position;
            if(baseKeyframeAnimation3 instanceof SplitDimensionPathKeyframeAnimation) {
                ((SplitDimensionPathKeyframeAnimation)baseKeyframeAnimation3).setYValueCallback(lottieValueCallback0);
                return true;
            }
        }
        if(object0 == LottieProperty.TRANSFORM_SCALE) {
            BaseKeyframeAnimation baseKeyframeAnimation4 = this.scale;
            if(baseKeyframeAnimation4 == null) {
                this.scale = new ValueCallbackKeyframeAnimation(lottieValueCallback0, new ScaleXY());
                return true;
            }
            baseKeyframeAnimation4.setValueCallback(lottieValueCallback0);
            return true;
        }
        if(object0 == LottieProperty.TRANSFORM_ROTATION) {
            BaseKeyframeAnimation baseKeyframeAnimation5 = this.rotation;
            if(baseKeyframeAnimation5 == null) {
                this.rotation = new ValueCallbackKeyframeAnimation(lottieValueCallback0, 0.0f);
                return true;
            }
            baseKeyframeAnimation5.setValueCallback(lottieValueCallback0);
            return true;
        }
        if(object0 == LottieProperty.TRANSFORM_OPACITY) {
            BaseKeyframeAnimation baseKeyframeAnimation6 = this.opacity;
            if(baseKeyframeAnimation6 == null) {
                this.opacity = new ValueCallbackKeyframeAnimation(lottieValueCallback0, 100);
                return true;
            }
            baseKeyframeAnimation6.setValueCallback(lottieValueCallback0);
            return true;
        }
        if(object0 == LottieProperty.TRANSFORM_START_OPACITY) {
            BaseKeyframeAnimation baseKeyframeAnimation7 = this.startOpacity;
            if(baseKeyframeAnimation7 == null) {
                this.startOpacity = new ValueCallbackKeyframeAnimation(lottieValueCallback0, 100.0f);
                return true;
            }
            baseKeyframeAnimation7.setValueCallback(lottieValueCallback0);
            return true;
        }
        if(object0 == LottieProperty.TRANSFORM_END_OPACITY) {
            BaseKeyframeAnimation baseKeyframeAnimation8 = this.endOpacity;
            if(baseKeyframeAnimation8 == null) {
                this.endOpacity = new ValueCallbackKeyframeAnimation(lottieValueCallback0, 100.0f);
                return true;
            }
            baseKeyframeAnimation8.setValueCallback(lottieValueCallback0);
            return true;
        }
        if(object0 == LottieProperty.TRANSFORM_SKEW) {
            if(this.skew == null) {
                this.skew = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(0.0f)));
            }
            this.skew.setValueCallback(lottieValueCallback0);
            return true;
        }
        if(object0 == LottieProperty.TRANSFORM_SKEW_ANGLE) {
            if(this.skewAngle == null) {
                this.skewAngle = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(0.0f)));
            }
            this.skewAngle.setValueCallback(lottieValueCallback0);
            return true;
        }
        return false;
    }

    private void clearSkewValues() {
        for(int v = 0; v < 9; ++v) {
            this.skewValues[v] = 0.0f;
        }
    }

    public BaseKeyframeAnimation getEndOpacity() {
        return this.endOpacity;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        BaseKeyframeAnimation baseKeyframeAnimation0 = this.position;
        if(baseKeyframeAnimation0 != null) {
            PointF pointF0 = (PointF)baseKeyframeAnimation0.getValue();
            if(pointF0 != null) {
                float f = pointF0.x;
                if(f != 0.0f || pointF0.y != 0.0f) {
                    this.matrix.preTranslate(f, pointF0.y);
                }
            }
        }
        if(!this.autoOrient) {
            BaseKeyframeAnimation baseKeyframeAnimation1 = this.rotation;
            if(baseKeyframeAnimation1 != null) {
                float f4 = baseKeyframeAnimation1 instanceof ValueCallbackKeyframeAnimation ? ((float)(((Float)baseKeyframeAnimation1.getValue()))) : ((FloatKeyframeAnimation)baseKeyframeAnimation1).getFloatValue();
                if(f4 != 0.0f) {
                    this.matrix.preRotate(f4);
                }
            }
        }
        else if(baseKeyframeAnimation0 != null) {
            float f1 = baseKeyframeAnimation0.getProgress();
            PointF pointF1 = (PointF)baseKeyframeAnimation0.getValue();
            float f2 = pointF1.x;
            float f3 = pointF1.y;
            baseKeyframeAnimation0.setProgress(f1 + 0.0001f);
            PointF pointF2 = (PointF)baseKeyframeAnimation0.getValue();
            baseKeyframeAnimation0.setProgress(f1);
            this.matrix.preRotate(((float)Math.toDegrees(Math.atan2(pointF2.y - f3, pointF2.x - f2))));
        }
        FloatKeyframeAnimation floatKeyframeAnimation0 = this.skew;
        if(floatKeyframeAnimation0 != null) {
            float f5 = this.skewAngle == null ? 0.0f : ((float)Math.cos(Math.toRadians(90.0f - this.skewAngle.getFloatValue())));
            float f6 = this.skewAngle == null ? 1.0f : ((float)Math.sin(Math.toRadians(90.0f - this.skewAngle.getFloatValue())));
            double f7 = Math.toRadians(floatKeyframeAnimation0.getFloatValue());
            this.clearSkewValues();
            this.skewValues[0] = f5;
            this.skewValues[1] = f6;
            this.skewValues[3] = -f6;
            this.skewValues[4] = f5;
            this.skewValues[8] = 1.0f;
            this.skewMatrix1.setValues(this.skewValues);
            this.clearSkewValues();
            this.skewValues[0] = 1.0f;
            this.skewValues[3] = (float)Math.tan(f7);
            this.skewValues[4] = 1.0f;
            this.skewValues[8] = 1.0f;
            this.skewMatrix2.setValues(this.skewValues);
            this.clearSkewValues();
            this.skewValues[0] = f5;
            this.skewValues[1] = -f6;
            this.skewValues[3] = f6;
            this.skewValues[4] = f5;
            this.skewValues[8] = 1.0f;
            this.skewMatrix3.setValues(this.skewValues);
            this.skewMatrix2.preConcat(this.skewMatrix1);
            this.skewMatrix3.preConcat(this.skewMatrix2);
            this.matrix.preConcat(this.skewMatrix3);
        }
        BaseKeyframeAnimation baseKeyframeAnimation2 = this.scale;
        if(baseKeyframeAnimation2 != null) {
            ScaleXY scaleXY0 = (ScaleXY)baseKeyframeAnimation2.getValue();
            if(scaleXY0 != null && (scaleXY0.getScaleX() != 1.0f || scaleXY0.getScaleY() != 1.0f)) {
                this.matrix.preScale(scaleXY0.getScaleX(), scaleXY0.getScaleY());
            }
        }
        BaseKeyframeAnimation baseKeyframeAnimation3 = this.anchorPoint;
        if(baseKeyframeAnimation3 != null) {
            PointF pointF3 = (PointF)baseKeyframeAnimation3.getValue();
            if(pointF3 != null) {
                float f8 = pointF3.x;
                if(f8 != 0.0f || pointF3.y != 0.0f) {
                    this.matrix.preTranslate(-f8, -pointF3.y);
                }
            }
        }
        return this.matrix;
    }

    public Matrix getMatrixForRepeater(float f) {
        PointF pointF0 = null;
        PointF pointF1 = this.position == null ? null : ((PointF)this.position.getValue());
        ScaleXY scaleXY0 = this.scale == null ? null : ((ScaleXY)this.scale.getValue());
        this.matrix.reset();
        if(pointF1 != null) {
            this.matrix.preTranslate(pointF1.x * f, pointF1.y * f);
        }
        if(scaleXY0 != null) {
            this.matrix.preScale(((float)Math.pow(scaleXY0.getScaleX(), f)), ((float)Math.pow(scaleXY0.getScaleY(), f)));
        }
        BaseKeyframeAnimation baseKeyframeAnimation0 = this.rotation;
        if(baseKeyframeAnimation0 != null) {
            float f1 = (float)(((Float)baseKeyframeAnimation0.getValue()));
            BaseKeyframeAnimation baseKeyframeAnimation1 = this.anchorPoint;
            if(baseKeyframeAnimation1 != null) {
                pointF0 = (PointF)baseKeyframeAnimation1.getValue();
            }
            Matrix matrix0 = this.matrix;
            float f2 = 0.0f;
            float f3 = pointF0 == null ? 0.0f : pointF0.x;
            if(pointF0 != null) {
                f2 = pointF0.y;
            }
            matrix0.preRotate(f1 * f, f3, f2);
        }
        return this.matrix;
    }

    public BaseKeyframeAnimation getOpacity() {
        return this.opacity;
    }

    public BaseKeyframeAnimation getStartOpacity() {
        return this.startOpacity;
    }

    public void setProgress(float f) {
        BaseKeyframeAnimation baseKeyframeAnimation0 = this.opacity;
        if(baseKeyframeAnimation0 != null) {
            baseKeyframeAnimation0.setProgress(f);
        }
        BaseKeyframeAnimation baseKeyframeAnimation1 = this.startOpacity;
        if(baseKeyframeAnimation1 != null) {
            baseKeyframeAnimation1.setProgress(f);
        }
        BaseKeyframeAnimation baseKeyframeAnimation2 = this.endOpacity;
        if(baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.setProgress(f);
        }
        BaseKeyframeAnimation baseKeyframeAnimation3 = this.anchorPoint;
        if(baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.setProgress(f);
        }
        BaseKeyframeAnimation baseKeyframeAnimation4 = this.position;
        if(baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.setProgress(f);
        }
        BaseKeyframeAnimation baseKeyframeAnimation5 = this.scale;
        if(baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.setProgress(f);
        }
        BaseKeyframeAnimation baseKeyframeAnimation6 = this.rotation;
        if(baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.setProgress(f);
        }
        FloatKeyframeAnimation floatKeyframeAnimation0 = this.skew;
        if(floatKeyframeAnimation0 != null) {
            floatKeyframeAnimation0.setProgress(f);
        }
        FloatKeyframeAnimation floatKeyframeAnimation1 = this.skewAngle;
        if(floatKeyframeAnimation1 != null) {
            floatKeyframeAnimation1.setProgress(f);
        }
    }
}

