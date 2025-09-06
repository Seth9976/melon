package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape.Type;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class PolystarContent implements KeyPathElementContent, PathContent, AnimationListener {
    private static final float POLYGON_MAGIC_NUMBER = 0.25f;
    private static final float POLYSTAR_MAGIC_NUMBER = 0.47829f;
    private final boolean hidden;
    private final BaseKeyframeAnimation innerRadiusAnimation;
    private final BaseKeyframeAnimation innerRoundednessAnimation;
    private boolean isPathValid;
    private final boolean isReversed;
    private final Path lastSegmentPath;
    private final PathMeasure lastSegmentPathMeasure;
    private final float[] lastSegmentPosition;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation outerRadiusAnimation;
    private final BaseKeyframeAnimation outerRoundednessAnimation;
    private final Path path;
    private final BaseKeyframeAnimation pointsAnimation;
    private final BaseKeyframeAnimation positionAnimation;
    private final BaseKeyframeAnimation rotationAnimation;
    private final CompoundTrimPathContent trimPaths;
    private final Type type;

    public PolystarContent(LottieDrawable lottieDrawable0, BaseLayer baseLayer0, PolystarShape polystarShape0) {
        this.path = new Path();
        this.lastSegmentPath = new Path();
        this.lastSegmentPathMeasure = new PathMeasure();
        this.lastSegmentPosition = new float[2];
        this.trimPaths = new CompoundTrimPathContent();
        this.lottieDrawable = lottieDrawable0;
        this.name = polystarShape0.getName();
        Type polystarShape$Type0 = polystarShape0.getType();
        this.type = polystarShape$Type0;
        this.hidden = polystarShape0.isHidden();
        this.isReversed = polystarShape0.isReversed();
        FloatKeyframeAnimation floatKeyframeAnimation0 = polystarShape0.getPoints().createAnimation();
        this.pointsAnimation = floatKeyframeAnimation0;
        BaseKeyframeAnimation baseKeyframeAnimation0 = polystarShape0.getPosition().createAnimation();
        this.positionAnimation = baseKeyframeAnimation0;
        FloatKeyframeAnimation floatKeyframeAnimation1 = polystarShape0.getRotation().createAnimation();
        this.rotationAnimation = floatKeyframeAnimation1;
        FloatKeyframeAnimation floatKeyframeAnimation2 = polystarShape0.getOuterRadius().createAnimation();
        this.outerRadiusAnimation = floatKeyframeAnimation2;
        FloatKeyframeAnimation floatKeyframeAnimation3 = polystarShape0.getOuterRoundedness().createAnimation();
        this.outerRoundednessAnimation = floatKeyframeAnimation3;
        Type polystarShape$Type1 = Type.STAR;
        if(polystarShape$Type0 == polystarShape$Type1) {
            this.innerRadiusAnimation = polystarShape0.getInnerRadius().createAnimation();
            this.innerRoundednessAnimation = polystarShape0.getInnerRoundedness().createAnimation();
        }
        else {
            this.innerRadiusAnimation = null;
            this.innerRoundednessAnimation = null;
        }
        baseLayer0.addAnimation(floatKeyframeAnimation0);
        baseLayer0.addAnimation(baseKeyframeAnimation0);
        baseLayer0.addAnimation(floatKeyframeAnimation1);
        baseLayer0.addAnimation(floatKeyframeAnimation2);
        baseLayer0.addAnimation(floatKeyframeAnimation3);
        if(polystarShape$Type0 == polystarShape$Type1) {
            baseLayer0.addAnimation(this.innerRadiusAnimation);
            baseLayer0.addAnimation(this.innerRoundednessAnimation);
        }
        floatKeyframeAnimation0.addUpdateListener(this);
        baseKeyframeAnimation0.addUpdateListener(this);
        floatKeyframeAnimation1.addUpdateListener(this);
        floatKeyframeAnimation2.addUpdateListener(this);
        floatKeyframeAnimation3.addUpdateListener(this);
        if(polystarShape$Type0 == polystarShape$Type1) {
            this.innerRadiusAnimation.addUpdateListener(this);
            this.innerRoundednessAnimation.addUpdateListener(this);
        }
    }

    @Override  // com.airbnb.lottie.model.KeyPathElement
    public void addValueCallback(Object object0, LottieValueCallback lottieValueCallback0) {
        if(object0 == LottieProperty.POLYSTAR_POINTS) {
            this.pointsAnimation.setValueCallback(lottieValueCallback0);
            return;
        }
        if(object0 == LottieProperty.POLYSTAR_ROTATION) {
            this.rotationAnimation.setValueCallback(lottieValueCallback0);
            return;
        }
        if(object0 == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback0);
            return;
        }
        if(object0 == LottieProperty.POLYSTAR_INNER_RADIUS) {
            BaseKeyframeAnimation baseKeyframeAnimation0 = this.innerRadiusAnimation;
            if(baseKeyframeAnimation0 != null) {
                baseKeyframeAnimation0.setValueCallback(lottieValueCallback0);
                return;
            }
        }
        if(object0 == LottieProperty.POLYSTAR_OUTER_RADIUS) {
            this.outerRadiusAnimation.setValueCallback(lottieValueCallback0);
            return;
        }
        if(object0 == LottieProperty.POLYSTAR_INNER_ROUNDEDNESS) {
            BaseKeyframeAnimation baseKeyframeAnimation1 = this.innerRoundednessAnimation;
            if(baseKeyframeAnimation1 != null) {
                baseKeyframeAnimation1.setValueCallback(lottieValueCallback0);
                return;
            }
        }
        if(object0 == LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) {
            this.outerRoundednessAnimation.setValueCallback(lottieValueCallback0);
        }
    }

    private void createPolygonPath() {
        float f22;
        float f21;
        int v = (int)Math.floor(((float)(((Float)this.pointsAnimation.getValue()))));
        double f = Math.toRadians((this.rotationAnimation == null ? 0.0 : ((double)(((float)(((Float)this.rotationAnimation.getValue())))))) - 90.0);
        float f1 = ((float)(((Float)this.outerRoundednessAnimation.getValue()))) / 100.0f;
        float f2 = (float)(((Float)this.outerRadiusAnimation.getValue()));
        float f3 = (float)(Math.cos(f) * ((double)f2));
        float f4 = (float)(Math.sin(f) * ((double)f2));
        this.path.moveTo(f3, f4);
        double f5 = (double)(((float)(6.283185 / ((double)v))));
        double f6 = Math.ceil(v);
        double f7 = f + f5;
        for(int v1 = 0; ((double)v1) < f6; ++v1) {
            float f8 = (float)(Math.cos(f7) * ((double)f2));
            float f9 = (float)(Math.sin(f7) * ((double)f2));
            if(Float.compare(f1, 0.0f) == 0) {
                f3 = f8;
                f4 = f9;
                if(((double)v1) != f6 - 1.0) {
                    this.path.lineTo(f3, f4);
                    f7 += f5;
                }
            }
            else {
                double f10 = (double)(((float)(Math.atan2(f4, f3) - 1.570796)));
                double f11 = (double)(((float)(Math.atan2(f9, f8) - 1.570796)));
                float f12 = f2 * f1 * 0.25f;
                float f13 = f12 * ((float)Math.cos(f10));
                float f14 = f12 * ((float)Math.sin(f10));
                float f15 = ((float)Math.cos(f11)) * f12;
                float f16 = f12 * ((float)Math.sin(f11));
                if(((double)v1) == f6 - 1.0) {
                    this.lastSegmentPath.reset();
                    this.lastSegmentPath.moveTo(f3, f4);
                    float f17 = f3 - f13;
                    float f18 = f4 - f14;
                    float f19 = f8 + f15;
                    float f20 = f9 + f16;
                    f21 = f8;
                    f22 = f9;
                    this.lastSegmentPath.cubicTo(f17, f18, f19, f20, f21, f22);
                    this.lastSegmentPathMeasure.setPath(this.lastSegmentPath, false);
                    float f23 = this.lastSegmentPathMeasure.getLength();
                    this.lastSegmentPathMeasure.getPosTan(f23 * 0.9999f, this.lastSegmentPosition, null);
                    this.path.cubicTo(f17, f18, f19, f20, this.lastSegmentPosition[0], this.lastSegmentPosition[1]);
                }
                else {
                    f21 = f8;
                    f22 = f9;
                    this.path.cubicTo(f3 - f13, f4 - f14, f21 + f15, f22 + f16, f21, f22);
                }
                f3 = f21;
                f4 = f22;
                f7 += f5;
            }
        }
        PointF pointF0 = (PointF)this.positionAnimation.getValue();
        this.path.offset(pointF0.x, pointF0.y);
        this.path.close();
    }

    private void createStarPath() {
        double f27;
        float f26;
        float f25;
        float f24;
        float f21;
        double f20;
        float f19;
        int v5;
        float f14;
        float f13;
        float f12;
        double f11;
        float f10;
        int v1;
        float f8;
        float f = (float)(((Float)this.pointsAnimation.getValue()));
        double f1 = Math.toRadians((this.rotationAnimation == null ? 0.0 : ((double)(((float)(((Float)this.rotationAnimation.getValue())))))) - 90.0);
        float f2 = (float)(6.283185 / ((double)f));
        if(this.isReversed) {
            f2 *= -1.0f;
        }
        float f3 = f - ((float)(((int)f)));
        int v = Float.compare(f3, 0.0f);
        if(v != 0) {
            f1 += (double)((1.0f - f3) * (f2 / 2.0f));
        }
        float f4 = (float)(((Float)this.outerRadiusAnimation.getValue()));
        float f5 = (float)(((Float)this.innerRadiusAnimation.getValue()));
        float f6 = this.innerRoundednessAnimation == null ? 0.0f : ((float)(((Float)this.innerRoundednessAnimation.getValue()))) / 100.0f;
        float f7 = this.outerRoundednessAnimation == null ? 0.0f : ((float)(((Float)this.outerRoundednessAnimation.getValue()))) / 100.0f;
        if(v == 0) {
            v1 = 0;
            f13 = (float)(Math.cos(f1) * ((double)f4));
            f10 = (float)(((double)f4) * Math.sin(f1));
            this.path.moveTo(f13, f10);
            f12 = f3;
            f14 = f2 / 2.0f;
            f11 = f1 + ((double)f14);
            f8 = 0.0f;
        }
        else {
            f8 = (f4 - f5) * f3 + f5;
            v1 = v;
            float f9 = (float)(Math.cos(f1) * ((double)f8));
            f10 = (float)(Math.sin(f1) * ((double)f8));
            this.path.moveTo(f9, f10);
            f11 = f1 + ((double)(f2 * f3 / 2.0f));
            f12 = f3;
            f13 = f9;
            f14 = f2 / 2.0f;
        }
        double f15 = Math.ceil(f);
        int v2 = 0;
        int v3 = 0;
        float f16 = f10;
        float f17 = f13;
        double f18 = f11;
        while(((double)v2) < f15 * 2.0) {
            int v4 = Float.compare(f8, 0.0f);
            if(v4 == 0 || ((double)v2) != f15 * 2.0 - 2.0) {
                v5 = v2;
                f19 = f14;
            }
            else {
                v5 = v2;
                f19 = f2 * f12 / 2.0f;
            }
            if(v4 == 0 || ((double)v2) != f15 * 2.0 - 1.0) {
                f20 = (double)v2;
                f21 = v3 == 0 ? f5 : f4;
            }
            else {
                f20 = (double)v2;
                f21 = f8;
            }
            float f22 = (float)(Math.cos(f18) * ((double)f21));
            float f23 = (float)(Math.sin(f18) * ((double)f21));
            if(f6 != 0.0f || f7 != 0.0f) {
                f26 = f14;
                f27 = f18;
                double f28 = (double)(((float)(Math.atan2(f16, f17) - 1.570796)));
                f25 = f23;
                double f29 = (double)(((float)(Math.atan2(f23, f22) - 1.570796)));
                float f30 = (v3 == 0 ? f4 : f5) * (v3 == 0 ? f7 : f6) * 0.47829f;
                float f31 = ((float)Math.cos(f28)) * f30;
                float f32 = f30 * ((float)Math.sin(f28));
                float f33 = (v3 == 0 ? f5 : f4) * (v3 == 0 ? f6 : f7) * 0.47829f;
                float f34 = ((float)Math.cos(f29)) * f33;
                float f35 = f33 * ((float)Math.sin(f29));
                if(v1 != 0) {
                    if(v5 == 0) {
                        f31 *= f12;
                        f32 *= f12;
                    }
                    else if(f20 == f15 * 2.0 - 1.0) {
                        f34 *= f12;
                        f35 *= f12;
                    }
                }
                f24 = f22;
                this.path.cubicTo(f17 - f31, f16 - f32, f22 + f34, f25 + f35, f24, f25);
            }
            else {
                this.path.lineTo(f22, f23);
                f24 = f22;
                f25 = f23;
                f26 = f14;
                f27 = f18;
            }
            f18 = f27 + ((double)f19);
            v3 ^= 1;
            v2 = v5 + 1;
            f14 = f26;
            f17 = f24;
            f16 = f25;
        }
        PointF pointF0 = (PointF)this.positionAnimation.getValue();
        this.path.offset(pointF0.x, pointF0.y);
        this.path.close();
    }

    @Override  // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override  // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        if(this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        if(this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        switch(com.airbnb.lottie.animation.content.PolystarContent.1.$SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[this.type.ordinal()]) {
            case 1: {
                this.createStarPath();
                break;
            }
            case 2: {
                this.createPolygonPath();
            }
        }
        this.path.close();
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener
    public void onValueChanged() {
        this.invalidate();
    }

    @Override  // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath0, int v, List list0, KeyPath keyPath1) {
        MiscUtils.resolveKeyPath(keyPath0, v, list0, keyPath1, this);
    }

    @Override  // com.airbnb.lottie.animation.content.Content
    public void setContents(List list0, List list1) {
        for(int v = 0; v < list0.size(); ++v) {
            Content content0 = (Content)list0.get(v);
            if(content0 instanceof TrimPathContent && ((TrimPathContent)content0).getType() == com.airbnb.lottie.model.content.ShapeTrimPath.Type.SIMULTANEOUSLY) {
                this.trimPaths.addTrimPath(((TrimPathContent)content0));
                ((TrimPathContent)content0).addListener(this);
            }
        }
    }

    class com.airbnb.lottie.animation.content.PolystarContent.1 {
        static final int[] $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type;

        static {
            int[] arr_v = new int[Type.values().length];
            com.airbnb.lottie.animation.content.PolystarContent.1.$SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type = arr_v;
            try {
                arr_v[Type.STAR.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                com.airbnb.lottie.animation.content.PolystarContent.1.$SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[Type.POLYGON.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

}

