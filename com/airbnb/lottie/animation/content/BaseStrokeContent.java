package com.airbnb.lottie.animation.content;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.DropShadow;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseStrokeContent implements DrawingContent, KeyPathElementContent, AnimationListener {
    static final class PathGroup {
        private final List paths;
        private final TrimPathContent trimPath;

        private PathGroup(TrimPathContent trimPathContent0) {
            this.paths = new ArrayList();
            this.trimPath = trimPathContent0;
        }

        public PathGroup(TrimPathContent trimPathContent0, com.airbnb.lottie.animation.content.BaseStrokeContent.1 baseStrokeContent$10) {
            this(trimPathContent0);
        }
    }

    private BaseKeyframeAnimation blurAnimation;
    float blurMaskFilterRadius;
    private BaseKeyframeAnimation colorFilterAnimation;
    private final List dashPatternAnimations;
    private final BaseKeyframeAnimation dashPatternOffsetAnimation;
    private final float[] dashPatternValues;
    protected final BaseLayer layer;
    private final LottieDrawable lottieDrawable;
    private final BaseKeyframeAnimation opacityAnimation;
    final Paint paint;
    private final Path path;
    private final List pathGroups;
    private final PathMeasure pm;
    private final RectF rect;
    private final Path trimPathPath;
    private final BaseKeyframeAnimation widthAnimation;

    public BaseStrokeContent(LottieDrawable lottieDrawable0, BaseLayer baseLayer0, Paint.Cap paint$Cap0, Paint.Join paint$Join0, float f, AnimatableIntegerValue animatableIntegerValue0, AnimatableFloatValue animatableFloatValue0, List list0, AnimatableFloatValue animatableFloatValue1) {
        this.pm = new PathMeasure();
        this.path = new Path();
        this.trimPathPath = new Path();
        this.rect = new RectF();
        this.pathGroups = new ArrayList();
        LPaint lPaint0 = new LPaint(1);
        this.paint = lPaint0;
        this.blurMaskFilterRadius = 0.0f;
        this.lottieDrawable = lottieDrawable0;
        this.layer = baseLayer0;
        lPaint0.setStyle(Paint.Style.STROKE);
        lPaint0.setStrokeCap(paint$Cap0);
        lPaint0.setStrokeJoin(paint$Join0);
        lPaint0.setStrokeMiter(f);
        this.opacityAnimation = animatableIntegerValue0.createAnimation();
        this.widthAnimation = animatableFloatValue0.createAnimation();
        this.dashPatternOffsetAnimation = animatableFloatValue1 == null ? null : animatableFloatValue1.createAnimation();
        this.dashPatternAnimations = new ArrayList(list0.size());
        this.dashPatternValues = new float[list0.size()];
        for(int v1 = 0; v1 < list0.size(); ++v1) {
            FloatKeyframeAnimation floatKeyframeAnimation0 = ((AnimatableFloatValue)list0.get(v1)).createAnimation();
            this.dashPatternAnimations.add(floatKeyframeAnimation0);
        }
        baseLayer0.addAnimation(this.opacityAnimation);
        baseLayer0.addAnimation(this.widthAnimation);
        for(int v2 = 0; v2 < this.dashPatternAnimations.size(); ++v2) {
            baseLayer0.addAnimation(((BaseKeyframeAnimation)this.dashPatternAnimations.get(v2)));
        }
        BaseKeyframeAnimation baseKeyframeAnimation0 = this.dashPatternOffsetAnimation;
        if(baseKeyframeAnimation0 != null) {
            baseLayer0.addAnimation(baseKeyframeAnimation0);
        }
        this.opacityAnimation.addUpdateListener(this);
        this.widthAnimation.addUpdateListener(this);
        for(int v = 0; v < list0.size(); ++v) {
            ((BaseKeyframeAnimation)this.dashPatternAnimations.get(v)).addUpdateListener(this);
        }
        BaseKeyframeAnimation baseKeyframeAnimation1 = this.dashPatternOffsetAnimation;
        if(baseKeyframeAnimation1 != null) {
            baseKeyframeAnimation1.addUpdateListener(this);
        }
        if(baseLayer0.getBlurEffect() != null) {
            FloatKeyframeAnimation floatKeyframeAnimation1 = baseLayer0.getBlurEffect().getBlurriness().createAnimation();
            this.blurAnimation = floatKeyframeAnimation1;
            floatKeyframeAnimation1.addUpdateListener(this);
            baseLayer0.addAnimation(this.blurAnimation);
        }
    }

    @Override  // com.airbnb.lottie.model.KeyPathElement
    public void addValueCallback(Object object0, LottieValueCallback lottieValueCallback0) {
        if(object0 == LottieProperty.OPACITY) {
            this.opacityAnimation.setValueCallback(lottieValueCallback0);
            return;
        }
        if(object0 == LottieProperty.STROKE_WIDTH) {
            this.widthAnimation.setValueCallback(lottieValueCallback0);
            return;
        }
        if(object0 == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation baseKeyframeAnimation0 = this.colorFilterAnimation;
            if(baseKeyframeAnimation0 != null) {
                this.layer.removeAnimation(baseKeyframeAnimation0);
            }
            if(lottieValueCallback0 == null) {
                this.colorFilterAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation0 = new ValueCallbackKeyframeAnimation(lottieValueCallback0);
            this.colorFilterAnimation = valueCallbackKeyframeAnimation0;
            valueCallbackKeyframeAnimation0.addUpdateListener(this);
            this.layer.addAnimation(this.colorFilterAnimation);
            return;
        }
        if(object0 == LottieProperty.BLUR_RADIUS) {
            BaseKeyframeAnimation baseKeyframeAnimation1 = this.blurAnimation;
            if(baseKeyframeAnimation1 != null) {
                baseKeyframeAnimation1.setValueCallback(lottieValueCallback0);
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation1 = new ValueCallbackKeyframeAnimation(lottieValueCallback0);
            this.blurAnimation = valueCallbackKeyframeAnimation1;
            valueCallbackKeyframeAnimation1.addUpdateListener(this);
            this.layer.addAnimation(this.blurAnimation);
        }
    }

    private void applyDashPatternIfNeeded() {
        if(!this.dashPatternAnimations.isEmpty()) {
            for(int v = 0; v < this.dashPatternAnimations.size(); ++v) {
                this.dashPatternValues[v] = (float)(((Float)((BaseKeyframeAnimation)this.dashPatternAnimations.get(v)).getValue()));
                if(v % 2 == 0) {
                    float[] arr_f = this.dashPatternValues;
                    if(arr_f[v] < 1.0f) {
                        arr_f[v] = 1.0f;
                    }
                }
                else {
                    float[] arr_f1 = this.dashPatternValues;
                    if(arr_f1[v] < 0.1f) {
                        arr_f1[v] = 0.1f;
                    }
                }
            }
            float f = this.dashPatternOffsetAnimation == null ? 0.0f : ((float)(((Float)this.dashPatternOffsetAnimation.getValue())));
            DashPathEffect dashPathEffect0 = new DashPathEffect(this.dashPatternValues, f);
            this.paint.setPathEffect(dashPathEffect0);
        }
    }

    private void applyTrimPath(Canvas canvas0, PathGroup baseStrokeContent$PathGroup0) {
        if(baseStrokeContent$PathGroup0.trimPath != null) {
            this.path.reset();
            for(int v = baseStrokeContent$PathGroup0.paths.size() - 1; v >= 0; --v) {
                Path path0 = ((PathContent)baseStrokeContent$PathGroup0.paths.get(v)).getPath();
                this.path.addPath(path0);
            }
            float f = (float)(((Float)baseStrokeContent$PathGroup0.trimPath.getStart().getValue()));
            float f1 = (float)(((Float)baseStrokeContent$PathGroup0.trimPath.getEnd().getValue()));
            float f2 = (float)(((Float)baseStrokeContent$PathGroup0.trimPath.getOffset().getValue()));
            if(f / 100.0f < 0.01f && f1 / 100.0f > 0.99f) {
                canvas0.drawPath(this.path, this.paint);
                return;
            }
            this.pm.setPath(this.path, false);
            float f3;
            for(f3 = this.pm.getLength(); this.pm.nextContour(); f3 += this.pm.getLength()) {
            }
            float f4 = f2 / 360.0f * f3;
            float f5 = f / 100.0f * f3 + f4;
            float f6 = Math.min(f1 / 100.0f * f3 + f4, f5 + f3 - 1.0f);
            int v1 = baseStrokeContent$PathGroup0.paths.size() - 1;
            float f7 = 0.0f;
            while(v1 >= 0) {
                Path path1 = ((PathContent)baseStrokeContent$PathGroup0.paths.get(v1)).getPath();
                this.trimPathPath.set(path1);
                this.pm.setPath(this.trimPathPath, false);
                float f8 = this.pm.getLength();
                if(f6 > f3) {
                    float f9 = f6 - f3;
                    if(f9 < f7 + f8 && f7 < f9) {
                        Utils.applyTrimPathIfNeeded(this.trimPathPath, (f5 > f3 ? (f5 - f3) / f8 : 0.0f), Math.min(f9 / f8, 1.0f), 0.0f);
                        canvas0.drawPath(this.trimPathPath, this.paint);
                    }
                }
                else {
                    float f10 = f7 + f8;
                    if(f10 >= f5 && f7 <= f6) {
                        if(f10 > f6 || f5 >= f7) {
                            Utils.applyTrimPathIfNeeded(this.trimPathPath, (f5 < f7 ? 0.0f : (f5 - f7) / f8), (f6 > f10 ? 1.0f : (f6 - f7) / f8), 0.0f);
                        }
                        canvas0.drawPath(this.trimPathPath, this.paint);
                    }
                }
                f7 += f8;
                --v1;
            }
        }
    }

    @Override  // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas0, Matrix matrix0, int v, DropShadow dropShadow0) {
        if(!Utils.hasZeroScaleAxis(matrix0)) {
            float f = ((float)(((int)(((Integer)this.opacityAnimation.getValue()))))) / 100.0f;
            this.paint.setAlpha(MiscUtils.clamp(((int)(((float)v) * f)), 0, 0xFF));
            float f1 = ((FloatKeyframeAnimation)this.widthAnimation).getFloatValue();
            this.paint.setStrokeWidth(f1);
            if(this.paint.getStrokeWidth() > 0.0f) {
                this.applyDashPatternIfNeeded();
                BaseKeyframeAnimation baseKeyframeAnimation0 = this.colorFilterAnimation;
                if(baseKeyframeAnimation0 != null) {
                    ColorFilter colorFilter0 = (ColorFilter)baseKeyframeAnimation0.getValue();
                    this.paint.setColorFilter(colorFilter0);
                }
                BaseKeyframeAnimation baseKeyframeAnimation1 = this.blurAnimation;
                if(baseKeyframeAnimation1 != null) {
                    float f2 = (float)(((Float)baseKeyframeAnimation1.getValue()));
                    if(f2 == 0.0f) {
                        this.paint.setMaskFilter(null);
                    }
                    else if(f2 != this.blurMaskFilterRadius) {
                        BlurMaskFilter blurMaskFilter0 = this.layer.getBlurMaskFilter(f2);
                        this.paint.setMaskFilter(blurMaskFilter0);
                    }
                    this.blurMaskFilterRadius = f2;
                }
                if(dropShadow0 != null) {
                    dropShadow0.applyWithAlpha(((int)(f * 255.0f)), this.paint);
                }
                canvas0.save();
                canvas0.concat(matrix0);
                for(int v1 = 0; v1 < this.pathGroups.size(); ++v1) {
                    PathGroup baseStrokeContent$PathGroup0 = (PathGroup)this.pathGroups.get(v1);
                    if(baseStrokeContent$PathGroup0.trimPath == null) {
                        this.path.reset();
                        for(int v2 = baseStrokeContent$PathGroup0.paths.size() - 1; v2 >= 0; --v2) {
                            Path path0 = ((PathContent)baseStrokeContent$PathGroup0.paths.get(v2)).getPath();
                            this.path.addPath(path0);
                        }
                        canvas0.drawPath(this.path, this.paint);
                    }
                    else {
                        this.applyTrimPath(canvas0, baseStrokeContent$PathGroup0);
                    }
                }
                canvas0.restore();
            }
        }
    }

    @Override  // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF0, Matrix matrix0, boolean z) {
        this.path.reset();
        for(int v = 0; v < this.pathGroups.size(); ++v) {
            PathGroup baseStrokeContent$PathGroup0 = (PathGroup)this.pathGroups.get(v);
            for(int v1 = 0; v1 < baseStrokeContent$PathGroup0.paths.size(); ++v1) {
                Path path0 = ((PathContent)baseStrokeContent$PathGroup0.paths.get(v1)).getPath();
                this.path.addPath(path0, matrix0);
            }
        }
        this.path.computeBounds(this.rect, false);
        float f = ((FloatKeyframeAnimation)this.widthAnimation).getFloatValue();
        this.rect.set(this.rect.left - f / 2.0f, this.rect.top - f / 2.0f, this.rect.right + f / 2.0f, this.rect.bottom + f / 2.0f);
        rectF0.set(this.rect);
        rectF0.set(rectF0.left - 1.0f, rectF0.top - 1.0f, rectF0.right + 1.0f, rectF0.bottom + 1.0f);
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override  // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath0, int v, List list0, KeyPath keyPath1) {
        MiscUtils.resolveKeyPath(keyPath0, v, list0, keyPath1, this);
    }

    @Override  // com.airbnb.lottie.animation.content.Content
    public void setContents(List list0, List list1) {
        int v = list0.size() - 1;
        TrimPathContent trimPathContent0 = null;
        while(v >= 0) {
            Content content0 = (Content)list0.get(v);
            if(content0 instanceof TrimPathContent && ((TrimPathContent)content0).getType() == Type.INDIVIDUALLY) {
                trimPathContent0 = (TrimPathContent)content0;
            }
            --v;
        }
        if(trimPathContent0 != null) {
            trimPathContent0.addListener(this);
        }
        int v1 = list1.size() - 1;
        PathGroup baseStrokeContent$PathGroup0 = null;
        while(v1 >= 0) {
            Content content1 = (Content)list1.get(v1);
            if(content1 instanceof TrimPathContent && ((TrimPathContent)content1).getType() == Type.INDIVIDUALLY) {
                if(baseStrokeContent$PathGroup0 != null) {
                    this.pathGroups.add(baseStrokeContent$PathGroup0);
                }
                baseStrokeContent$PathGroup0 = new PathGroup(((TrimPathContent)content1), null);
                ((TrimPathContent)content1).addListener(this);
            }
            else if(content1 instanceof PathContent) {
                if(baseStrokeContent$PathGroup0 == null) {
                    baseStrokeContent$PathGroup0 = new PathGroup(trimPathContent0, null);
                }
                baseStrokeContent$PathGroup0.paths.add(((PathContent)content1));
            }
            --v1;
        }
        if(baseStrokeContent$PathGroup0 != null) {
            this.pathGroups.add(baseStrokeContent$PathGroup0);
        }
    }

    class com.airbnb.lottie.animation.content.BaseStrokeContent.1 {
    }

}

