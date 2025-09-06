package com.airbnb.lottie.utils;

import B0.i;
import Qc.l;
import S1.a;
import S1.e;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.RecordingCanvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.RenderEffect;
import android.graphics.RenderNode;
import android.os.Build.VERSION;
import c2.n0;
import com.airbnb.lottie.animation.LPaint;

public class OffscreenLayer {
    public static class ComposeOp {
        public int alpha;
        public a blendMode;
        public ColorFilter colorFilter;
        public DropShadow shadow;

        public ComposeOp() {
            this.reset();
        }

        public boolean hasBlendMode() {
            return this.blendMode != null && this.blendMode != a.a;
        }

        public boolean hasColorFilter() {
            return this.colorFilter != null;
        }

        public boolean hasShadow() {
            return this.shadow != null;
        }

        // 去混淆评级： 低(40)
        public boolean isNoop() {
            return !this.isTranslucent() && !this.hasBlendMode() && !this.hasShadow() && !this.hasColorFilter();
        }

        public boolean isTranslucent() {
            return this.alpha < 0xFF;
        }

        public void reset() {
            this.alpha = 0xFF;
            this.blendMode = null;
            this.colorFilter = null;
            this.shadow = null;
        }
    }

    public static enum RenderStrategy {
        DIRECT,
        SAVE_LAYER,
        BITMAP,
        RENDER_NODE;

        private static RenderStrategy[] $values() [...] // Inlined contents
    }

    private static final Matrix IDENTITY_MATRIX;
    private Bitmap bitmap;
    private Canvas bitmapCanvas;
    private Rect bitmapSrcRect;
    private LPaint clearPaint;
    private Paint composePaint;
    private RenderStrategy currentStrategy;
    private Rect intRectIncludingShadow;
    private DropShadow lastRenderNodeShadow;
    private float lastShadowBlurRadius;
    private ComposeOp op;
    private Canvas parentCanvas;
    Matrix parentCanvasMatrix;
    float[] preExistingTransform;
    private RectF rectIncludingShadow;
    private RenderNode renderNode;
    private RectF scaledBounds;
    private RectF scaledRectIncludingShadow;
    private Bitmap shadowBitmap;
    private Canvas shadowBitmapCanvas;
    private Rect shadowBitmapSrcRect;
    private BlurMaskFilter shadowBlurFilter;
    private Bitmap shadowMaskBitmap;
    private Canvas shadowMaskBitmapCanvas;
    private LPaint shadowPaint;
    private RenderNode shadowRenderNode;
    private RectF targetRect;
    private RectF tmpRect;

    static {
        OffscreenLayer.IDENTITY_MATRIX = new Matrix();
    }

    public OffscreenLayer() {
        this.lastShadowBlurRadius = 0.0f;
    }

    private Bitmap allocateBitmap(RectF rectF0, Bitmap.Config bitmap$Config0) {
        return Bitmap.createBitmap(Math.max(((int)Math.ceil(((double)rectF0.width()) * 1.05)), 1), Math.max(((int)Math.ceil(((double)rectF0.height()) * 1.05)), 1), bitmap$Config0);
    }

    private RectF calculateRectIncludingShadow(RectF rectF0, DropShadow dropShadow0) {
        if(this.rectIncludingShadow == null) {
            this.rectIncludingShadow = new RectF();
        }
        if(this.tmpRect == null) {
            this.tmpRect = new RectF();
        }
        this.rectIncludingShadow.set(rectF0);
        this.rectIncludingShadow.offsetTo(dropShadow0.getDx() + rectF0.left, dropShadow0.getDy() + rectF0.top);
        this.rectIncludingShadow.inset(-dropShadow0.getRadius(), -dropShadow0.getRadius());
        this.tmpRect.set(rectF0);
        this.rectIncludingShadow.union(this.tmpRect);
        return this.rectIncludingShadow;
    }

    private RenderStrategy chooseRenderStrategy(Canvas canvas0, ComposeOp offscreenLayer$ComposeOp0) {
        if(offscreenLayer$ComposeOp0.isNoop()) {
            return RenderStrategy.DIRECT;
        }
        if(!offscreenLayer$ComposeOp0.hasShadow()) {
            return RenderStrategy.SAVE_LAYER;
        }
        int v = Build.VERSION.SDK_INT;
        return v >= 29 && canvas0.isHardwareAccelerated() && v > 0x1F ? RenderStrategy.RENDER_NODE : RenderStrategy.BITMAP;
    }

    private void deallocateBitmap(Bitmap bitmap0) {
        bitmap0.recycle();
    }

    public void finish() {
        if(this.parentCanvas != null && this.op != null && this.preExistingTransform != null && this.targetRect != null) {
            switch(this.currentStrategy.ordinal()) {
                case 0: {
                    this.parentCanvas.restore();
                    this.parentCanvas = null;
                    return;
                }
                case 1: {
                    this.parentCanvas.restore();
                    this.parentCanvas = null;
                    return;
                }
                case 2: {
                    if(this.bitmap == null) {
                        throw new IllegalStateException("Bitmap is not ready; should\'ve been initialized at start() time");
                    }
                    if(this.op.hasShadow()) {
                        this.renderBitmapShadow(this.parentCanvas, this.op.shadow);
                    }
                    if(this.bitmapSrcRect == null) {
                        this.bitmapSrcRect = new Rect();
                    }
                    this.bitmapSrcRect.set(0, 0, ((int)(this.targetRect.width() * this.preExistingTransform[0])), ((int)(this.targetRect.height() * this.preExistingTransform[4])));
                    this.parentCanvas.drawBitmap(this.bitmap, this.bitmapSrcRect, this.targetRect, this.composePaint);
                    this.parentCanvas = null;
                    return;
                }
                case 3: {
                    if(this.renderNode == null) {
                        throw new IllegalStateException("RenderNode is not ready; should\'ve been initialized at start() time");
                    }
                    if(Build.VERSION.SDK_INT < 29) {
                        throw new IllegalStateException("RenderNode not supported but we chose it as render strategy");
                    }
                    this.parentCanvas.save();
                    this.parentCanvas.scale(1.0f / this.preExistingTransform[0], 1.0f / this.preExistingTransform[4]);
                    this.renderNode.endRecording();
                    if(this.op.hasShadow()) {
                        this.renderHardwareShadow(this.parentCanvas, this.op.shadow);
                    }
                    this.parentCanvas.drawRenderNode(this.renderNode);
                    this.parentCanvas.restore();
                    this.parentCanvas = null;
                    return;
                }
                default: {
                    this.parentCanvas = null;
                    return;
                }
            }
        }
        throw new IllegalStateException("OffscreenBitmap: finish() call without matching start()");
    }

    public boolean finishDecrementsCanvasSaveCount() {
        return this.currentStrategy == RenderStrategy.RENDER_NODE;
    }

    private boolean needNewBitmap(Bitmap bitmap0, RectF rectF0) {
        return bitmap0 == null ? true : rectF0.width() >= ((float)bitmap0.getWidth()) || rectF0.height() >= ((float)bitmap0.getHeight()) || rectF0.width() < ((float)bitmap0.getWidth()) * 0.75f || rectF0.height() < ((float)bitmap0.getHeight()) * 0.75f;
    }

    private void renderBitmapShadow(Canvas canvas0, DropShadow dropShadow0) {
        RectF rectF0 = this.targetRect;
        if(rectF0 == null || this.bitmap == null) {
            throw new IllegalStateException("Cannot render to bitmap outside a start()/finish() block");
        }
        RectF rectF1 = this.calculateRectIncludingShadow(rectF0, dropShadow0);
        if(this.intRectIncludingShadow == null) {
            this.intRectIncludingShadow = new Rect();
        }
        this.intRectIncludingShadow.set(((int)Math.floor(rectF1.left)), ((int)Math.floor(rectF1.top)), ((int)Math.ceil(rectF1.right)), ((int)Math.ceil(rectF1.bottom)));
        float[] arr_f = this.preExistingTransform;
        float f = 1.0f;
        float f1 = arr_f == null ? 1.0f : arr_f[0];
        if(arr_f != null) {
            f = arr_f[4];
        }
        if(this.scaledRectIncludingShadow == null) {
            this.scaledRectIncludingShadow = new RectF();
        }
        this.scaledRectIncludingShadow.set(rectF1.left * f1, rectF1.top * f, rectF1.right * f1, rectF1.bottom * f);
        if(this.shadowBitmapSrcRect == null) {
            this.shadowBitmapSrcRect = new Rect();
        }
        this.shadowBitmapSrcRect.set(0, 0, Math.round(this.scaledRectIncludingShadow.width()), Math.round(this.scaledRectIncludingShadow.height()));
        if(this.needNewBitmap(this.shadowBitmap, this.scaledRectIncludingShadow)) {
            Bitmap bitmap0 = this.shadowBitmap;
            if(bitmap0 != null) {
                this.deallocateBitmap(bitmap0);
            }
            Bitmap bitmap1 = this.shadowMaskBitmap;
            if(bitmap1 != null) {
                this.deallocateBitmap(bitmap1);
            }
            this.shadowBitmap = this.allocateBitmap(this.scaledRectIncludingShadow, Bitmap.Config.ARGB_8888);
            this.shadowMaskBitmap = this.allocateBitmap(this.scaledRectIncludingShadow, Bitmap.Config.ALPHA_8);
            this.shadowBitmapCanvas = new Canvas(this.shadowBitmap);
            this.shadowMaskBitmapCanvas = new Canvas(this.shadowMaskBitmap);
            goto label_35;
        }
        Canvas canvas1 = this.shadowBitmapCanvas;
        if(canvas1 != null && this.shadowMaskBitmapCanvas != null) {
            LPaint lPaint0 = this.clearPaint;
            if(lPaint0 != null) {
                canvas1.drawRect(this.shadowBitmapSrcRect, lPaint0);
                this.shadowMaskBitmapCanvas.drawRect(this.shadowBitmapSrcRect, this.clearPaint);
            label_35:
                if(this.shadowMaskBitmap == null) {
                    throw new IllegalStateException("Expected to have allocated a shadow mask bitmap");
                }
                if(this.shadowPaint == null) {
                    this.shadowPaint = new LPaint(1);
                }
                this.shadowMaskBitmapCanvas.drawBitmap(this.bitmap, ((float)Math.round((this.targetRect.left - rectF1.left) * f1)), ((float)Math.round((this.targetRect.top - rectF1.top) * f)), null);
                if(this.shadowBlurFilter == null || this.lastShadowBlurRadius != dropShadow0.getRadius()) {
                    float f2 = (f1 + f) * dropShadow0.getRadius() / 2.0f;
                    this.shadowBlurFilter = f2 > 0.0f ? new BlurMaskFilter(f2, BlurMaskFilter.Blur.NORMAL) : null;
                    this.lastShadowBlurRadius = dropShadow0.getRadius();
                }
                this.shadowPaint.setColor(dropShadow0.getColor());
                if(dropShadow0.getRadius() > 0.0f) {
                    this.shadowPaint.setMaskFilter(this.shadowBlurFilter);
                }
                else {
                    this.shadowPaint.setMaskFilter(null);
                }
                this.shadowPaint.setFilterBitmap(true);
                this.shadowBitmapCanvas.drawBitmap(this.shadowMaskBitmap, ((float)Math.round(dropShadow0.getDx() * f1)), ((float)Math.round(dropShadow0.getDy() * f)), this.shadowPaint);
                canvas0.drawBitmap(this.shadowBitmap, this.shadowBitmapSrcRect, this.intRectIncludingShadow, this.composePaint);
                return;
            }
        }
        throw new IllegalStateException("If needNewBitmap() returns true, we should have a canvas and bitmap ready");
    }

    private void renderHardwareShadow(Canvas canvas0, DropShadow dropShadow0) {
        if(this.renderNode == null || this.shadowRenderNode == null) {
            throw new IllegalStateException("Cannot render to render node outside a start()/finish() block");
        }
        if(Build.VERSION.SDK_INT < 0x1F) {
            throw new RuntimeException("RenderEffect is not supported on API level <31");
        }
        float[] arr_f = this.preExistingTransform;
        float f = 1.0f;
        float f1 = arr_f == null ? 1.0f : arr_f[0];
        if(arr_f != null) {
            f = arr_f[4];
        }
        if(this.lastRenderNodeShadow == null || !dropShadow0.sameAs(this.lastRenderNodeShadow)) {
            RenderEffect renderEffect0 = RenderEffect.createColorFilterEffect(new PorterDuffColorFilter(dropShadow0.getColor(), PorterDuff.Mode.SRC_IN));
            if(dropShadow0.getRadius() > 0.0f) {
                float f2 = (f1 + f) * dropShadow0.getRadius() / 2.0f;
                renderEffect0 = com.airbnb.lottie.utils.a.b(f2, f2, renderEffect0);
            }
            this.shadowRenderNode.setRenderEffect(renderEffect0);
            this.lastRenderNodeShadow = dropShadow0;
        }
        RectF rectF0 = this.calculateRectIncludingShadow(this.targetRect, dropShadow0);
        RectF rectF1 = new RectF(rectF0.left * f1, rectF0.top * f, rectF0.right * f1, rectF0.bottom * f);
        l.u(this.shadowRenderNode, ((int)rectF1.width()), ((int)rectF1.height()));
        RecordingCanvas recordingCanvas0 = this.shadowRenderNode.beginRecording(((int)rectF1.width()), ((int)rectF1.height()));
        recordingCanvas0.translate(dropShadow0.getDx() * f1 + -rectF1.left, dropShadow0.getDy() * f + -rectF1.top);
        recordingCanvas0.drawRenderNode(this.renderNode);
        this.shadowRenderNode.endRecording();
        canvas0.save();
        canvas0.translate(rectF1.left, rectF1.top);
        canvas0.drawRenderNode(this.shadowRenderNode);
        canvas0.restore();
    }

    public Canvas start(Canvas canvas0, RectF rectF0, ComposeOp offscreenLayer$ComposeOp0) {
        if(this.parentCanvas == null) {
            if(this.preExistingTransform == null) {
                this.preExistingTransform = new float[9];
            }
            if(this.parentCanvasMatrix == null) {
                this.parentCanvasMatrix = new Matrix();
            }
            canvas0.getMatrix(this.parentCanvasMatrix);
            this.parentCanvasMatrix.getValues(this.preExistingTransform);
            float[] arr_f = this.preExistingTransform;
            float f = arr_f[0];
            float f1 = arr_f[4];
            if(this.scaledBounds == null) {
                this.scaledBounds = new RectF();
            }
            this.scaledBounds.set(rectF0.left * f, rectF0.top * f1, rectF0.right * f, rectF0.bottom * f1);
            this.parentCanvas = canvas0;
            this.op = offscreenLayer$ComposeOp0;
            this.currentStrategy = this.chooseRenderStrategy(canvas0, offscreenLayer$ComposeOp0);
            if(this.targetRect == null) {
                this.targetRect = new RectF();
            }
            this.targetRect.set(((float)(((int)rectF0.left))), ((float)(((int)rectF0.top))), ((float)(((int)rectF0.right))), ((float)(((int)rectF0.bottom))));
            if(this.composePaint == null) {
                this.composePaint = new LPaint();
            }
            this.composePaint.reset();
            switch(this.currentStrategy.ordinal()) {
                case 0: {
                    canvas0.save();
                    return canvas0;
                }
                case 1: {
                    this.composePaint.setAlpha(offscreenLayer$ComposeOp0.alpha);
                    this.composePaint.setColorFilter(offscreenLayer$ComposeOp0.colorFilter);
                    if(offscreenLayer$ComposeOp0.hasBlendMode()) {
                        e.a(this.composePaint, offscreenLayer$ComposeOp0.blendMode);
                    }
                    Utils.saveLayerCompat(canvas0, rectF0, this.composePaint);
                    return canvas0;
                }
                case 2: {
                    if(this.clearPaint == null) {
                        LPaint lPaint0 = new LPaint();
                        this.clearPaint = lPaint0;
                        lPaint0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                    }
                    if(this.needNewBitmap(this.bitmap, this.scaledBounds)) {
                        Bitmap bitmap0 = this.bitmap;
                        if(bitmap0 != null) {
                            this.deallocateBitmap(bitmap0);
                        }
                        this.bitmap = this.allocateBitmap(this.scaledBounds, Bitmap.Config.ARGB_8888);
                        this.bitmapCanvas = new Canvas(this.bitmap);
                    }
                    else {
                        Canvas canvas1 = this.bitmapCanvas;
                        if(canvas1 == null) {
                            throw new IllegalStateException("If needNewBitmap() returns true, we should have a canvas ready");
                        }
                        canvas1.setMatrix(OffscreenLayer.IDENTITY_MATRIX);
                        this.bitmapCanvas.drawRect(-1.0f, -1.0f, this.scaledBounds.width() + 1.0f, this.scaledBounds.height() + 1.0f, this.clearPaint);
                    }
                    e.a(this.composePaint, offscreenLayer$ComposeOp0.blendMode);
                    this.composePaint.setColorFilter(offscreenLayer$ComposeOp0.colorFilter);
                    this.composePaint.setAlpha(offscreenLayer$ComposeOp0.alpha);
                    Canvas canvas2 = this.bitmapCanvas;
                    canvas2.scale(f, f1);
                    canvas2.translate(-rectF0.left, -rectF0.top);
                    return canvas2;
                }
                case 3: {
                    if(Build.VERSION.SDK_INT < 29) {
                        throw new IllegalStateException("RenderNode not supported but we chose it as render strategy");
                    }
                    if(this.renderNode == null) {
                        this.renderNode = n0.f();
                    }
                    if(offscreenLayer$ComposeOp0.hasShadow() && this.shadowRenderNode == null) {
                        this.shadowRenderNode = n0.x();
                        this.lastRenderNodeShadow = null;
                    }
                    if(offscreenLayer$ComposeOp0.hasBlendMode() || offscreenLayer$ComposeOp0.hasColorFilter()) {
                        if(this.composePaint == null) {
                            this.composePaint = new LPaint();
                        }
                        this.composePaint.reset();
                        e.a(this.composePaint, offscreenLayer$ComposeOp0.blendMode);
                        this.composePaint.setColorFilter(offscreenLayer$ComposeOp0.colorFilter);
                        n0.q(this.renderNode, this.composePaint);
                        if(offscreenLayer$ComposeOp0.hasShadow()) {
                            RenderNode renderNode0 = this.shadowRenderNode;
                            if(renderNode0 == null) {
                                throw new IllegalStateException("Must initialize shadowRenderNode when we have shadow");
                            }
                            n0.q(renderNode0, this.composePaint);
                        }
                    }
                    this.renderNode.setAlpha(((float)offscreenLayer$ComposeOp0.alpha) / 255.0f);
                    if(offscreenLayer$ComposeOp0.hasShadow()) {
                        RenderNode renderNode1 = this.shadowRenderNode;
                        if(renderNode1 == null) {
                            throw new IllegalStateException("Must initialize shadowRenderNode when we have shadow");
                        }
                        renderNode1.setAlpha(((float)offscreenLayer$ComposeOp0.alpha) / 255.0f);
                    }
                    i.r(this.renderNode);
                    this.renderNode.setPosition(((int)this.scaledBounds.left), ((int)this.scaledBounds.top), ((int)this.scaledBounds.right), ((int)this.scaledBounds.bottom));
                    Canvas canvas3 = this.renderNode.beginRecording(((int)this.scaledBounds.width()), ((int)this.scaledBounds.height()));
                    canvas3.setMatrix(OffscreenLayer.IDENTITY_MATRIX);
                    canvas3.scale(f, f1);
                    canvas3.translate(-rectF0.left, -rectF0.top);
                    return canvas3;
                }
                default: {
                    throw new RuntimeException("Invalid render strategy for OffscreenLayer");
                }
            }
        }
        throw new IllegalStateException("Cannot nest start() calls on a single OffscreenBitmap - call finish() first");
    }
}

