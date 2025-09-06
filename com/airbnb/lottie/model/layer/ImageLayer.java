package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.utils.DropShadow;
import com.airbnb.lottie.utils.OffscreenLayer.ComposeOp;
import com.airbnb.lottie.utils.OffscreenLayer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;

public class ImageLayer extends BaseLayer {
    private BaseKeyframeAnimation colorFilterAnimation;
    private DropShadowKeyframeAnimation dropShadowAnimation;
    private final Rect dst;
    private BaseKeyframeAnimation imageAnimation;
    private final RectF layerBounds;
    private final LottieImageAsset lottieImageAsset;
    private OffscreenLayer offscreenLayer;
    private ComposeOp offscreenOp;
    private final Paint paint;
    private final Rect src;

    public ImageLayer(LottieDrawable lottieDrawable0, Layer layer0) {
        super(lottieDrawable0, layer0);
        this.paint = new LPaint(3);
        this.src = new Rect();
        this.dst = new Rect();
        this.layerBounds = new RectF();
        this.lottieImageAsset = lottieDrawable0.getLottieImageAssetForId(layer0.getRefId());
        if(this.getDropShadowEffect() != null) {
            this.dropShadowAnimation = new DropShadowKeyframeAnimation(this, this, this.getDropShadowEffect());
        }
    }

    @Override  // com.airbnb.lottie.model.layer.BaseLayer
    public void addValueCallback(Object object0, LottieValueCallback lottieValueCallback0) {
        super.addValueCallback(object0, lottieValueCallback0);
        if(object0 == LottieProperty.COLOR_FILTER) {
            if(lottieValueCallback0 == null) {
                this.colorFilterAnimation = null;
                return;
            }
            this.colorFilterAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback0);
            return;
        }
        if(object0 == LottieProperty.IMAGE) {
            if(lottieValueCallback0 == null) {
                this.imageAnimation = null;
                return;
            }
            this.imageAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback0);
            return;
        }
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
        Bitmap bitmap0 = this.getBitmap();
        if(bitmap0 != null && !bitmap0.isRecycled() && this.lottieImageAsset != null) {
            float f = Utils.dpScale();
            this.paint.setAlpha(v);
            BaseKeyframeAnimation baseKeyframeAnimation0 = this.colorFilterAnimation;
            if(baseKeyframeAnimation0 != null) {
                ColorFilter colorFilter0 = (ColorFilter)baseKeyframeAnimation0.getValue();
                this.paint.setColorFilter(colorFilter0);
            }
            DropShadowKeyframeAnimation dropShadowKeyframeAnimation0 = this.dropShadowAnimation;
            if(dropShadowKeyframeAnimation0 != null) {
                dropShadow0 = dropShadowKeyframeAnimation0.evaluate(matrix0, v);
            }
            int v1 = bitmap0.getWidth();
            int v2 = bitmap0.getHeight();
            boolean z = false;
            this.src.set(0, 0, v1, v2);
            if(this.lottieDrawable.getMaintainOriginalImageBounds()) {
                this.dst.set(0, 0, ((int)(((float)this.lottieImageAsset.getWidth()) * f)), ((int)(((float)this.lottieImageAsset.getHeight()) * f)));
            }
            else {
                int v3 = (int)(((float)bitmap0.getWidth()) * f);
                int v4 = (int)(((float)bitmap0.getHeight()) * f);
                this.dst.set(0, 0, v3, v4);
            }
            if(dropShadow0 != null) {
                z = true;
                if(this.offscreenLayer == null) {
                    this.offscreenLayer = new OffscreenLayer();
                }
                if(this.offscreenOp == null) {
                    this.offscreenOp = new ComposeOp();
                }
                this.offscreenOp.reset();
                dropShadow0.applyWithAlpha(v, this.offscreenOp);
                this.layerBounds.set(((float)this.dst.left), ((float)this.dst.top), ((float)this.dst.right), ((float)this.dst.bottom));
                matrix0.mapRect(this.layerBounds);
                canvas0 = this.offscreenLayer.start(canvas0, this.layerBounds, this.offscreenOp);
            }
            canvas0.save();
            canvas0.concat(matrix0);
            canvas0.drawBitmap(bitmap0, this.src, this.dst, this.paint);
            if(z) {
                this.offscreenLayer.finish();
                if(!this.offscreenLayer.finishDecrementsCanvasSaveCount()) {
                    canvas0.restore();
                }
            }
            else {
                canvas0.restore();
            }
        }
    }

    private Bitmap getBitmap() {
        BaseKeyframeAnimation baseKeyframeAnimation0 = this.imageAnimation;
        if(baseKeyframeAnimation0 != null) {
            Bitmap bitmap0 = (Bitmap)baseKeyframeAnimation0.getValue();
            if(bitmap0 != null) {
                return bitmap0;
            }
        }
        Bitmap bitmap1 = this.lottieDrawable.getBitmapForId(this.layerModel.getRefId());
        if(bitmap1 != null) {
            return bitmap1;
        }
        return this.lottieImageAsset == null ? null : this.lottieImageAsset.getBitmap();
    }

    @Override  // com.airbnb.lottie.model.layer.BaseLayer
    public void getBounds(RectF rectF0, Matrix matrix0, boolean z) {
        super.getBounds(rectF0, matrix0, z);
        if(this.lottieImageAsset != null) {
            float f = Utils.dpScale();
            if(this.lottieDrawable.getMaintainOriginalImageBounds()) {
                rectF0.set(0.0f, 0.0f, ((float)this.lottieImageAsset.getWidth()) * f, ((float)this.lottieImageAsset.getHeight()) * f);
            }
            else {
                Bitmap bitmap0 = this.getBitmap();
                if(bitmap0 == null) {
                    rectF0.set(0.0f, 0.0f, ((float)this.lottieImageAsset.getWidth()) * f, ((float)this.lottieImageAsset.getHeight()) * f);
                }
                else {
                    rectF0.set(0.0f, 0.0f, ((float)bitmap0.getWidth()) * f, ((float)bitmap0.getHeight()) * f);
                }
            }
            this.boundsMatrix.mapRect(rectF0);
        }
    }
}

