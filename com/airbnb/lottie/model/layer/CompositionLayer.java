package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.collection.s;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.utils.DropShadow;
import com.airbnb.lottie.utils.OffscreenLayer.ComposeOp;
import com.airbnb.lottie.utils.OffscreenLayer;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class CompositionLayer extends BaseLayer {
    private boolean clipToCompositionBounds;
    private DropShadowKeyframeAnimation dropShadowAnimation;
    private Boolean hasMasks;
    private Boolean hasMatte;
    private final RectF layerBounds;
    private final List layers;
    private final RectF newClipRect;
    private final OffscreenLayer offscreenLayer;
    private final ComposeOp offscreenOp;
    private float progress;
    private final RectF rect;
    private BaseKeyframeAnimation timeRemapping;

    public CompositionLayer(LottieDrawable lottieDrawable0, Layer layer0, List list0, LottieComposition lottieComposition0) {
        super(lottieDrawable0, layer0);
        this.layers = new ArrayList();
        this.rect = new RectF();
        this.newClipRect = new RectF();
        this.layerBounds = new RectF();
        this.offscreenLayer = new OffscreenLayer();
        this.offscreenOp = new ComposeOp();
        this.clipToCompositionBounds = true;
        AnimatableFloatValue animatableFloatValue0 = layer0.getTimeRemapping();
        if(animatableFloatValue0 == null) {
            this.timeRemapping = null;
        }
        else {
            FloatKeyframeAnimation floatKeyframeAnimation0 = animatableFloatValue0.createAnimation();
            this.timeRemapping = floatKeyframeAnimation0;
            this.addAnimation(floatKeyframeAnimation0);
            this.timeRemapping.addUpdateListener(this);
        }
        s s0 = new s(lottieComposition0.getLayers().size());
        int v = list0.size() - 1;
        BaseLayer baseLayer0 = null;
        while(v >= 0) {
            Layer layer1 = (Layer)list0.get(v);
            BaseLayer baseLayer1 = BaseLayer.forModel(this, layer1, lottieDrawable0, lottieComposition0);
            if(baseLayer1 != null) {
                s0.f(baseLayer1.getLayerModel().getId(), baseLayer1);
                if(baseLayer0 == null) {
                    this.layers.add(0, baseLayer1);
                    switch(com.airbnb.lottie.model.layer.CompositionLayer.1.$SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[layer1.getMatteType().ordinal()]) {
                        case 1: 
                        case 2: {
                            baseLayer0 = baseLayer1;
                        }
                    }
                }
                else {
                    baseLayer0.setMatteLayer(baseLayer1);
                    baseLayer0 = null;
                }
            }
            --v;
        }
        for(int v1 = 0; v1 < s0.h(); ++v1) {
            BaseLayer baseLayer2 = (BaseLayer)s0.b(s0.e(v1));
            if(baseLayer2 != null) {
                BaseLayer baseLayer3 = (BaseLayer)s0.b(baseLayer2.getLayerModel().getParentId());
                if(baseLayer3 != null) {
                    baseLayer2.setParentLayer(baseLayer3);
                }
            }
        }
        if(this.getDropShadowEffect() != null) {
            this.dropShadowAnimation = new DropShadowKeyframeAnimation(this, this, this.getDropShadowEffect());
        }
    }

    @Override  // com.airbnb.lottie.model.layer.BaseLayer
    public void addValueCallback(Object object0, LottieValueCallback lottieValueCallback0) {
        super.addValueCallback(object0, lottieValueCallback0);
        if(object0 == LottieProperty.TIME_REMAP) {
            if(lottieValueCallback0 != null) {
                goto label_7;
            }
            BaseKeyframeAnimation baseKeyframeAnimation0 = this.timeRemapping;
            if(baseKeyframeAnimation0 != null) {
                baseKeyframeAnimation0.setValueCallback(null);
                return;
            label_7:
                ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation0 = new ValueCallbackKeyframeAnimation(lottieValueCallback0);
                this.timeRemapping = valueCallbackKeyframeAnimation0;
                valueCallbackKeyframeAnimation0.addUpdateListener(this);
                this.addAnimation(this.timeRemapping);
            }
        }
        else {
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
    }

    @Override  // com.airbnb.lottie.model.layer.BaseLayer
    public void drawLayer(Canvas canvas0, Matrix matrix0, int v, DropShadow dropShadow0) {
        Canvas canvas1;
        boolean z = false;
        int v1 = 0xFF;
        if((!this.lottieDrawable.isApplyingOpacityToLayersEnabled() || this.layers.size() <= 1 || v == 0xFF) && (dropShadow0 == null && this.dropShadowAnimation == null || !this.lottieDrawable.isApplyingShadowToLayersEnabled())) {
            v1 = v;
        }
        else {
            z = true;
        }
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation0 = this.dropShadowAnimation;
        if(dropShadowKeyframeAnimation0 != null) {
            dropShadow0 = dropShadowKeyframeAnimation0.evaluate(matrix0, v1);
        }
        if(this.clipToCompositionBounds || !"__container".equals(this.layerModel.getName())) {
            this.newClipRect.set(0.0f, 0.0f, this.layerModel.getPreCompWidth(), this.layerModel.getPreCompHeight());
            matrix0.mapRect(this.newClipRect);
        }
        else {
            this.newClipRect.setEmpty();
            for(Object object0: this.layers) {
                ((BaseLayer)object0).getBounds(this.layerBounds, matrix0, true);
                this.newClipRect.union(this.layerBounds);
            }
        }
        if(z) {
            this.offscreenOp.reset();
            ComposeOp offscreenLayer$ComposeOp0 = this.offscreenOp;
            offscreenLayer$ComposeOp0.alpha = v;
            if(dropShadow0 != null) {
                dropShadow0.applyTo(offscreenLayer$ComposeOp0);
                dropShadow0 = null;
            }
            canvas1 = this.offscreenLayer.start(canvas0, this.newClipRect, this.offscreenOp);
        }
        else {
            canvas1 = canvas0;
        }
        canvas0.save();
        if(canvas0.clipRect(this.newClipRect)) {
            for(int v2 = this.layers.size() - 1; v2 >= 0; --v2) {
                ((BaseLayer)this.layers.get(v2)).draw(canvas1, matrix0, v1, dropShadow0);
            }
        }
        if(z) {
            this.offscreenLayer.finish();
        }
        canvas0.restore();
    }

    @Override  // com.airbnb.lottie.model.layer.BaseLayer
    public void getBounds(RectF rectF0, Matrix matrix0, boolean z) {
        super.getBounds(rectF0, matrix0, z);
        for(int v = this.layers.size() - 1; v >= 0; --v) {
            this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
            ((BaseLayer)this.layers.get(v)).getBounds(this.rect, this.boundsMatrix, true);
            rectF0.union(this.rect);
        }
    }

    public float getProgress() {
        return this.progress;
    }

    public boolean hasMasks() {
        if(this.hasMasks == null) {
            for(int v = this.layers.size() - 1; v >= 0; --v) {
                BaseLayer baseLayer0 = (BaseLayer)this.layers.get(v);
                if(baseLayer0 instanceof ShapeLayer) {
                    if(baseLayer0.hasMasksOnThisLayer()) {
                        this.hasMasks = Boolean.TRUE;
                        return true;
                    }
                }
                else if(baseLayer0 instanceof CompositionLayer && ((CompositionLayer)baseLayer0).hasMasks()) {
                    this.hasMasks = Boolean.TRUE;
                    return true;
                }
            }
            this.hasMasks = Boolean.FALSE;
        }
        return this.hasMasks.booleanValue();
    }

    public boolean hasMatte() {
        if(this.hasMatte == null) {
            if(this.hasMatteOnThisLayer()) {
                this.hasMatte = Boolean.TRUE;
                return true;
            }
            for(int v = this.layers.size() - 1; v >= 0; --v) {
                if(((BaseLayer)this.layers.get(v)).hasMatteOnThisLayer()) {
                    this.hasMatte = Boolean.TRUE;
                    return true;
                }
            }
            this.hasMatte = Boolean.FALSE;
        }
        return this.hasMatte.booleanValue();
    }

    @Override  // com.airbnb.lottie.model.layer.BaseLayer
    public void resolveChildKeyPath(KeyPath keyPath0, int v, List list0, KeyPath keyPath1) {
        for(int v1 = 0; v1 < this.layers.size(); ++v1) {
            ((BaseLayer)this.layers.get(v1)).resolveKeyPath(keyPath0, v, list0, keyPath1);
        }
    }

    public void setClipToCompositionBounds(boolean z) {
        this.clipToCompositionBounds = z;
    }

    @Override  // com.airbnb.lottie.model.layer.BaseLayer
    public void setOutlineMasksAndMattes(boolean z) {
        super.setOutlineMasksAndMattes(z);
        for(Object object0: this.layers) {
            ((BaseLayer)object0).setOutlineMasksAndMattes(z);
        }
    }

    @Override  // com.airbnb.lottie.model.layer.BaseLayer
    public void setProgress(float f) {
        this.progress = f;
        super.setProgress(f);
        if(this.timeRemapping != null) {
            float f1 = (float)(((Float)this.timeRemapping.getValue()));
            f = (this.layerModel.getComposition().getFrameRate() * f1 - this.layerModel.getComposition().getStartFrame()) / (this.lottieDrawable.getComposition().getDurationFrames() + 0.01f);
        }
        if(this.timeRemapping == null) {
            f -= this.layerModel.getStartProgress();
        }
        if(this.layerModel.getTimeStretch() != 0.0f && !"__container".equals(this.layerModel.getName())) {
            f /= this.layerModel.getTimeStretch();
        }
        for(int v = this.layers.size() - 1; v >= 0; --v) {
            ((BaseLayer)this.layers.get(v)).setProgress(f);
        }
    }

    class com.airbnb.lottie.model.layer.CompositionLayer.1 {
        static final int[] $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType;

        static {
            int[] arr_v = new int[MatteType.values().length];
            com.airbnb.lottie.model.layer.CompositionLayer.1.$SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType = arr_v;
            try {
                arr_v[MatteType.ADD.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                com.airbnb.lottie.model.layer.CompositionLayer.1.$SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[MatteType.INVERT.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

}

