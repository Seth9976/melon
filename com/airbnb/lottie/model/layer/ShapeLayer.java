package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.utils.DropShadow;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;
import java.util.List;

public class ShapeLayer extends BaseLayer {
    private final CompositionLayer compositionLayer;
    private final ContentGroup contentGroup;
    private DropShadowKeyframeAnimation dropShadowAnimation;

    public ShapeLayer(LottieDrawable lottieDrawable0, Layer layer0, CompositionLayer compositionLayer0, LottieComposition lottieComposition0) {
        super(lottieDrawable0, layer0);
        this.compositionLayer = compositionLayer0;
        ContentGroup contentGroup0 = new ContentGroup(lottieDrawable0, this, new ShapeGroup("__container", layer0.getShapes(), false), lottieComposition0);
        this.contentGroup = contentGroup0;
        contentGroup0.setContents(Collections.EMPTY_LIST, Collections.EMPTY_LIST);
        if(this.getDropShadowEffect() != null) {
            this.dropShadowAnimation = new DropShadowKeyframeAnimation(this, this, this.getDropShadowEffect());
        }
    }

    @Override  // com.airbnb.lottie.model.layer.BaseLayer
    public void addValueCallback(Object object0, LottieValueCallback lottieValueCallback0) {
        super.addValueCallback(object0, lottieValueCallback0);
        if(object0 == LottieProperty.DROP_SHADOW_COLOR) {
            DropShadowKeyframeAnimation dropShadowKeyframeAnimation0 = this.dropShadowAnimation;
            if(dropShadowKeyframeAnimation0 != null) {
                dropShadowKeyframeAnimation0.setColorCallback(lottieValueCallback0);
                return;
            }
        }
        if(object0 == LottieProperty.DROP_SHADOW_OPACITY) {
            DropShadowKeyframeAnimation dropShadowKeyframeAnimation1 = this.dropShadowAnimation;
            if(dropShadowKeyframeAnimation1 != null) {
                dropShadowKeyframeAnimation1.setOpacityCallback(lottieValueCallback0);
                return;
            }
        }
        if(object0 == LottieProperty.DROP_SHADOW_DIRECTION) {
            DropShadowKeyframeAnimation dropShadowKeyframeAnimation2 = this.dropShadowAnimation;
            if(dropShadowKeyframeAnimation2 != null) {
                dropShadowKeyframeAnimation2.setDirectionCallback(lottieValueCallback0);
                return;
            }
        }
        if(object0 == LottieProperty.DROP_SHADOW_DISTANCE) {
            DropShadowKeyframeAnimation dropShadowKeyframeAnimation3 = this.dropShadowAnimation;
            if(dropShadowKeyframeAnimation3 != null) {
                dropShadowKeyframeAnimation3.setDistanceCallback(lottieValueCallback0);
                return;
            }
        }
        if(object0 == LottieProperty.DROP_SHADOW_RADIUS) {
            DropShadowKeyframeAnimation dropShadowKeyframeAnimation4 = this.dropShadowAnimation;
            if(dropShadowKeyframeAnimation4 != null) {
                dropShadowKeyframeAnimation4.setRadiusCallback(lottieValueCallback0);
            }
        }
    }

    @Override  // com.airbnb.lottie.model.layer.BaseLayer
    public void drawLayer(Canvas canvas0, Matrix matrix0, int v, DropShadow dropShadow0) {
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation0 = this.dropShadowAnimation;
        if(dropShadowKeyframeAnimation0 != null) {
            dropShadow0 = dropShadowKeyframeAnimation0.evaluate(matrix0, v);
        }
        this.contentGroup.draw(canvas0, matrix0, v, dropShadow0);
    }

    @Override  // com.airbnb.lottie.model.layer.BaseLayer
    public BlurEffect getBlurEffect() {
        BlurEffect blurEffect0 = super.getBlurEffect();
        return blurEffect0 == null ? this.compositionLayer.getBlurEffect() : blurEffect0;
    }

    @Override  // com.airbnb.lottie.model.layer.BaseLayer
    public void getBounds(RectF rectF0, Matrix matrix0, boolean z) {
        super.getBounds(rectF0, matrix0, z);
        this.contentGroup.getBounds(rectF0, this.boundsMatrix, z);
    }

    @Override  // com.airbnb.lottie.model.layer.BaseLayer
    public void resolveChildKeyPath(KeyPath keyPath0, int v, List list0, KeyPath keyPath1) {
        this.contentGroup.resolveKeyPath(keyPath0, v, list0, keyPath1);
    }
}

