package com.airbnb.lottie.animation.content;

import android.graphics.BlurMaskFilter.Blur;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import androidx.collection.s;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.DropShadow;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class GradientFillContent implements DrawingContent, KeyPathElementContent, AnimationListener {
    private static final int CACHE_STEPS_MS = 0x20;
    private BaseKeyframeAnimation blurAnimation;
    float blurMaskFilterRadius;
    private final RectF boundsRect;
    private final int cacheSteps;
    private final BaseKeyframeAnimation colorAnimation;
    private ValueCallbackKeyframeAnimation colorCallbackAnimation;
    private BaseKeyframeAnimation colorFilterAnimation;
    private final BaseKeyframeAnimation endPointAnimation;
    private final boolean hidden;
    private final BaseLayer layer;
    private final s linearGradientCache;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation opacityAnimation;
    private final Paint paint;
    private final Path path;
    private final List paths;
    private final s radialGradientCache;
    private final BaseKeyframeAnimation startPointAnimation;
    private final GradientType type;

    public GradientFillContent(LottieDrawable lottieDrawable0, LottieComposition lottieComposition0, BaseLayer baseLayer0, GradientFill gradientFill0) {
        this.linearGradientCache = new s(null);
        this.radialGradientCache = new s(null);
        Path path0 = new Path();
        this.path = path0;
        this.paint = new LPaint(1);
        this.boundsRect = new RectF();
        this.paths = new ArrayList();
        this.blurMaskFilterRadius = 0.0f;
        this.layer = baseLayer0;
        this.name = gradientFill0.getName();
        this.hidden = gradientFill0.isHidden();
        this.lottieDrawable = lottieDrawable0;
        this.type = gradientFill0.getGradientType();
        path0.setFillType(gradientFill0.getFillType());
        this.cacheSteps = (int)(lottieComposition0.getDuration() / 32.0f);
        BaseKeyframeAnimation baseKeyframeAnimation0 = gradientFill0.getGradientColor().createAnimation();
        this.colorAnimation = baseKeyframeAnimation0;
        baseKeyframeAnimation0.addUpdateListener(this);
        baseLayer0.addAnimation(baseKeyframeAnimation0);
        BaseKeyframeAnimation baseKeyframeAnimation1 = gradientFill0.getOpacity().createAnimation();
        this.opacityAnimation = baseKeyframeAnimation1;
        baseKeyframeAnimation1.addUpdateListener(this);
        baseLayer0.addAnimation(baseKeyframeAnimation1);
        BaseKeyframeAnimation baseKeyframeAnimation2 = gradientFill0.getStartPoint().createAnimation();
        this.startPointAnimation = baseKeyframeAnimation2;
        baseKeyframeAnimation2.addUpdateListener(this);
        baseLayer0.addAnimation(baseKeyframeAnimation2);
        BaseKeyframeAnimation baseKeyframeAnimation3 = gradientFill0.getEndPoint().createAnimation();
        this.endPointAnimation = baseKeyframeAnimation3;
        baseKeyframeAnimation3.addUpdateListener(this);
        baseLayer0.addAnimation(baseKeyframeAnimation3);
        if(baseLayer0.getBlurEffect() != null) {
            FloatKeyframeAnimation floatKeyframeAnimation0 = baseLayer0.getBlurEffect().getBlurriness().createAnimation();
            this.blurAnimation = floatKeyframeAnimation0;
            floatKeyframeAnimation0.addUpdateListener(this);
            baseLayer0.addAnimation(this.blurAnimation);
        }
    }

    @Override  // com.airbnb.lottie.model.KeyPathElement
    public void addValueCallback(Object object0, LottieValueCallback lottieValueCallback0) {
        if(object0 == LottieProperty.OPACITY) {
            this.opacityAnimation.setValueCallback(lottieValueCallback0);
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
        if(object0 == LottieProperty.GRADIENT_COLOR) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation1 = this.colorCallbackAnimation;
            if(valueCallbackKeyframeAnimation1 != null) {
                this.layer.removeAnimation(valueCallbackKeyframeAnimation1);
            }
            if(lottieValueCallback0 == null) {
                this.colorCallbackAnimation = null;
                return;
            }
            this.linearGradientCache.a();
            this.radialGradientCache.a();
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback0);
            this.colorCallbackAnimation = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.addUpdateListener(this);
            this.layer.addAnimation(this.colorCallbackAnimation);
            return;
        }
        if(object0 == LottieProperty.BLUR_RADIUS) {
            BaseKeyframeAnimation baseKeyframeAnimation1 = this.blurAnimation;
            if(baseKeyframeAnimation1 != null) {
                baseKeyframeAnimation1.setValueCallback(lottieValueCallback0);
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback0);
            this.blurAnimation = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.addUpdateListener(this);
            this.layer.addAnimation(this.blurAnimation);
        }
    }

    private int[] applyDynamicColorsIfNeeded(int[] arr_v) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation0 = this.colorCallbackAnimation;
        if(valueCallbackKeyframeAnimation0 != null) {
            Integer[] arr_integer = (Integer[])valueCallbackKeyframeAnimation0.getValue();
            int v = 0;
            if(arr_v.length == arr_integer.length) {
                while(v < arr_v.length) {
                    arr_v[v] = (int)arr_integer[v];
                    ++v;
                }
                return arr_v;
            }
            arr_v = new int[arr_integer.length];
            while(v < arr_integer.length) {
                arr_v[v] = (int)arr_integer[v];
                ++v;
            }
        }
        return arr_v;
    }

    @Override  // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas0, Matrix matrix0, int v, DropShadow dropShadow0) {
        if(!this.hidden) {
            this.path.reset();
            for(int v1 = 0; v1 < this.paths.size(); ++v1) {
                Path path0 = ((PathContent)this.paths.get(v1)).getPath();
                this.path.addPath(path0, matrix0);
            }
            this.path.computeBounds(this.boundsRect, false);
            LinearGradient linearGradient0 = this.type == GradientType.LINEAR ? this.getLinearGradient() : this.getRadialGradient();
            linearGradient0.setLocalMatrix(matrix0);
            this.paint.setShader(linearGradient0);
            BaseKeyframeAnimation baseKeyframeAnimation0 = this.colorFilterAnimation;
            if(baseKeyframeAnimation0 != null) {
                ColorFilter colorFilter0 = (ColorFilter)baseKeyframeAnimation0.getValue();
                this.paint.setColorFilter(colorFilter0);
            }
            BaseKeyframeAnimation baseKeyframeAnimation1 = this.blurAnimation;
            if(baseKeyframeAnimation1 != null) {
                float f = (float)(((Float)baseKeyframeAnimation1.getValue()));
                if(f == 0.0f) {
                    this.paint.setMaskFilter(null);
                }
                else if(f != this.blurMaskFilterRadius) {
                    BlurMaskFilter blurMaskFilter0 = new BlurMaskFilter(f, BlurMaskFilter.Blur.NORMAL);
                    this.paint.setMaskFilter(blurMaskFilter0);
                }
                this.blurMaskFilterRadius = f;
            }
            float f1 = ((float)(((int)(((Integer)this.opacityAnimation.getValue()))))) / 100.0f;
            this.paint.setAlpha(MiscUtils.clamp(((int)(((float)v) * f1)), 0, 0xFF));
            if(dropShadow0 != null) {
                dropShadow0.applyWithAlpha(((int)(f1 * 255.0f)), this.paint);
            }
            canvas0.drawPath(this.path, this.paint);
        }
    }

    @Override  // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF0, Matrix matrix0, boolean z) {
        this.path.reset();
        for(int v = 0; v < this.paths.size(); ++v) {
            Path path0 = ((PathContent)this.paths.get(v)).getPath();
            this.path.addPath(path0, matrix0);
        }
        this.path.computeBounds(rectF0, false);
        rectF0.set(rectF0.left - 1.0f, rectF0.top - 1.0f, rectF0.right + 1.0f, rectF0.bottom + 1.0f);
    }

    private int getGradientHash() {
        int v = Math.round(this.startPointAnimation.getProgress() * ((float)this.cacheSteps));
        int v1 = Math.round(this.endPointAnimation.getProgress() * ((float)this.cacheSteps));
        int v2 = Math.round(this.colorAnimation.getProgress() * ((float)this.cacheSteps));
        int v3 = v == 0 ? 17 : 0x20F * v;
        if(v1 != 0) {
            v3 = v3 * 0x1F * v1;
        }
        return v2 == 0 ? v3 : v3 * 0x1F * v2;
    }

    private LinearGradient getLinearGradient() {
        float[] arr_f1;
        int[] arr_v1;
        long v = (long)this.getGradientHash();
        LinearGradient linearGradient0 = (LinearGradient)this.linearGradientCache.b(v);
        if(linearGradient0 != null) {
            return linearGradient0;
        }
        PointF pointF0 = (PointF)this.startPointAnimation.getValue();
        PointF pointF1 = (PointF)this.endPointAnimation.getValue();
        GradientColor gradientColor0 = (GradientColor)this.colorAnimation.getValue();
        int[] arr_v = this.applyDynamicColorsIfNeeded(gradientColor0.getColors());
        float[] arr_f = gradientColor0.getPositions();
        if(arr_v.length < 2) {
            arr_v1 = new int[]{arr_v[0], arr_v[0]};
            arr_f1 = new float[]{0.0f, 1.0f};
        }
        else {
            arr_f1 = arr_f;
            arr_v1 = arr_v;
        }
        LinearGradient linearGradient1 = new LinearGradient(pointF0.x, pointF0.y, pointF1.x, pointF1.y, arr_v1, arr_f1, Shader.TileMode.CLAMP);
        this.linearGradientCache.f(v, linearGradient1);
        return linearGradient1;
    }

    @Override  // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    private RadialGradient getRadialGradient() {
        float[] arr_f1;
        int[] arr_v1;
        long v = (long)this.getGradientHash();
        RadialGradient radialGradient0 = (RadialGradient)this.radialGradientCache.b(v);
        if(radialGradient0 != null) {
            return radialGradient0;
        }
        PointF pointF0 = (PointF)this.startPointAnimation.getValue();
        PointF pointF1 = (PointF)this.endPointAnimation.getValue();
        GradientColor gradientColor0 = (GradientColor)this.colorAnimation.getValue();
        int[] arr_v = this.applyDynamicColorsIfNeeded(gradientColor0.getColors());
        float[] arr_f = gradientColor0.getPositions();
        if(arr_v.length < 2) {
            arr_v1 = new int[]{arr_v[0], arr_v[0]};
            arr_f1 = new float[]{0.0f, 1.0f};
        }
        else {
            arr_f1 = arr_f;
            arr_v1 = arr_v;
        }
        RadialGradient radialGradient1 = new RadialGradient(pointF0.x, pointF0.y, (((float)Math.hypot(pointF1.x - pointF0.x, pointF1.y - pointF0.y)) <= 0.0f ? 0.001f : ((float)Math.hypot(pointF1.x - pointF0.x, pointF1.y - pointF0.y))), arr_v1, arr_f1, Shader.TileMode.CLAMP);
        this.radialGradientCache.f(v, radialGradient1);
        return radialGradient1;
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
        for(int v = 0; v < list1.size(); ++v) {
            Content content0 = (Content)list1.get(v);
            if(content0 instanceof PathContent) {
                this.paths.add(((PathContent)content0));
            }
        }
    }
}

