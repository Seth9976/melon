package com.airbnb.lottie.model.layer;

import S1.a;
import S1.e;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.LBlendMode;
import com.airbnb.lottie.model.content.Mask.MaskMode;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.DropShadowEffect;
import com.airbnb.lottie.utils.DropShadow;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseLayer implements DrawingContent, AnimationListener, KeyPathElement {
    private static final int CLIP_SAVE_FLAG = 2;
    private static final int CLIP_TO_LAYER_SAVE_FLAG = 16;
    private static final int MATRIX_SAVE_FLAG = 1;
    private static final int SAVE_FLAGS = 19;
    private final List animations;
    BlurMaskFilter blurMaskFilter;
    float blurMaskFilterRadius;
    protected final Matrix boundsMatrix;
    private final RectF canvasBounds;
    private final Matrix canvasMatrix;
    private final Paint clearPaint;
    private final Paint contentPaint;
    private final String drawTraceName;
    private final Paint dstInPaint;
    private final Paint dstOutPaint;
    private FloatKeyframeAnimation inOutAnimation;
    final Layer layerModel;
    final LottieDrawable lottieDrawable;
    private MaskKeyframeAnimation mask;
    private final RectF maskBoundsRect;
    private final Matrix matrix;
    private final RectF matteBoundsRect;
    private BaseLayer matteLayer;
    private final Paint mattePaint;
    private boolean outlineMasksAndMattes;
    private Paint outlineMasksAndMattesPaint;
    private BaseLayer parentLayer;
    private List parentLayers;
    private final Path path;
    private final RectF rect;
    LPaint solidWhitePaint;
    private final RectF tempMaskBoundsRect;
    public final TransformKeyframeAnimation transform;
    private boolean visible;

    public BaseLayer(LottieDrawable lottieDrawable0, Layer layer0) {
        this.path = new Path();
        this.matrix = new Matrix();
        this.canvasMatrix = new Matrix();
        this.contentPaint = new LPaint(1);
        PorterDuff.Mode porterDuff$Mode0 = PorterDuff.Mode.DST_IN;
        this.dstInPaint = new LPaint(1, porterDuff$Mode0);
        PorterDuff.Mode porterDuff$Mode1 = PorterDuff.Mode.DST_OUT;
        this.dstOutPaint = new LPaint(1, porterDuff$Mode1);
        LPaint lPaint0 = new LPaint(1);
        this.mattePaint = lPaint0;
        this.clearPaint = new LPaint(PorterDuff.Mode.CLEAR);
        this.rect = new RectF();
        this.canvasBounds = new RectF();
        this.maskBoundsRect = new RectF();
        this.matteBoundsRect = new RectF();
        this.tempMaskBoundsRect = new RectF();
        this.boundsMatrix = new Matrix();
        this.animations = new ArrayList();
        this.visible = true;
        this.blurMaskFilterRadius = 0.0f;
        this.lottieDrawable = lottieDrawable0;
        this.layerModel = layer0;
        this.drawTraceName = layer0.getName() + "#draw";
        if(layer0.getMatteType() == MatteType.INVERT) {
            lPaint0.setXfermode(new PorterDuffXfermode(porterDuff$Mode1));
        }
        else {
            lPaint0.setXfermode(new PorterDuffXfermode(porterDuff$Mode0));
        }
        TransformKeyframeAnimation transformKeyframeAnimation0 = layer0.getTransform().createAnimation();
        this.transform = transformKeyframeAnimation0;
        transformKeyframeAnimation0.addListener(this);
        if(layer0.getMasks() != null && !layer0.getMasks().isEmpty()) {
            MaskKeyframeAnimation maskKeyframeAnimation0 = new MaskKeyframeAnimation(layer0.getMasks());
            this.mask = maskKeyframeAnimation0;
            for(Object object0: maskKeyframeAnimation0.getMaskAnimations()) {
                ((BaseKeyframeAnimation)object0).addUpdateListener(this);
            }
            for(Object object1: this.mask.getOpacityAnimations()) {
                this.addAnimation(((BaseKeyframeAnimation)object1));
                ((BaseKeyframeAnimation)object1).addUpdateListener(this);
            }
        }
        this.setupInOutAnimations();
    }

    public void addAnimation(BaseKeyframeAnimation baseKeyframeAnimation0) {
        if(baseKeyframeAnimation0 == null) {
            return;
        }
        this.animations.add(baseKeyframeAnimation0);
    }

    @Override  // com.airbnb.lottie.model.KeyPathElement
    public void addValueCallback(Object object0, LottieValueCallback lottieValueCallback0) {
        this.transform.applyValueCallback(object0, lottieValueCallback0);
    }

    private void applyAddMask(Canvas canvas0, Matrix matrix0, BaseKeyframeAnimation baseKeyframeAnimation0, BaseKeyframeAnimation baseKeyframeAnimation1) {
        Path path0 = (Path)baseKeyframeAnimation0.getValue();
        this.path.set(path0);
        this.path.transform(matrix0);
        int v = (int)(((float)(((int)(((Integer)baseKeyframeAnimation1.getValue()))))) * 2.55f);
        this.contentPaint.setAlpha(v);
        canvas0.drawPath(this.path, this.contentPaint);
    }

    private void applyIntersectMask(Canvas canvas0, Matrix matrix0, BaseKeyframeAnimation baseKeyframeAnimation0, BaseKeyframeAnimation baseKeyframeAnimation1) {
        Utils.saveLayerCompat(canvas0, this.rect, this.dstInPaint);
        Path path0 = (Path)baseKeyframeAnimation0.getValue();
        this.path.set(path0);
        this.path.transform(matrix0);
        int v = (int)(((float)(((int)(((Integer)baseKeyframeAnimation1.getValue()))))) * 2.55f);
        this.contentPaint.setAlpha(v);
        canvas0.drawPath(this.path, this.contentPaint);
        canvas0.restore();
    }

    private void applyInvertedAddMask(Canvas canvas0, Matrix matrix0, BaseKeyframeAnimation baseKeyframeAnimation0, BaseKeyframeAnimation baseKeyframeAnimation1) {
        Utils.saveLayerCompat(canvas0, this.rect, this.contentPaint);
        canvas0.drawRect(this.rect, this.contentPaint);
        Path path0 = (Path)baseKeyframeAnimation0.getValue();
        this.path.set(path0);
        this.path.transform(matrix0);
        int v = (int)(((float)(((int)(((Integer)baseKeyframeAnimation1.getValue()))))) * 2.55f);
        this.contentPaint.setAlpha(v);
        canvas0.drawPath(this.path, this.dstOutPaint);
        canvas0.restore();
    }

    private void applyInvertedIntersectMask(Canvas canvas0, Matrix matrix0, BaseKeyframeAnimation baseKeyframeAnimation0, BaseKeyframeAnimation baseKeyframeAnimation1) {
        Utils.saveLayerCompat(canvas0, this.rect, this.dstInPaint);
        canvas0.drawRect(this.rect, this.contentPaint);
        int v = (int)(((float)(((int)(((Integer)baseKeyframeAnimation1.getValue()))))) * 2.55f);
        this.dstOutPaint.setAlpha(v);
        Path path0 = (Path)baseKeyframeAnimation0.getValue();
        this.path.set(path0);
        this.path.transform(matrix0);
        canvas0.drawPath(this.path, this.dstOutPaint);
        canvas0.restore();
    }

    private void applyInvertedSubtractMask(Canvas canvas0, Matrix matrix0, BaseKeyframeAnimation baseKeyframeAnimation0, BaseKeyframeAnimation baseKeyframeAnimation1) {
        Utils.saveLayerCompat(canvas0, this.rect, this.dstOutPaint);
        canvas0.drawRect(this.rect, this.contentPaint);
        int v = (int)(((float)(((int)(((Integer)baseKeyframeAnimation1.getValue()))))) * 2.55f);
        this.dstOutPaint.setAlpha(v);
        Path path0 = (Path)baseKeyframeAnimation0.getValue();
        this.path.set(path0);
        this.path.transform(matrix0);
        canvas0.drawPath(this.path, this.dstOutPaint);
        canvas0.restore();
    }

    private void applyMasks(Canvas canvas0, Matrix matrix0) {
        Utils.saveLayerCompat(canvas0, this.rect, this.dstInPaint, 19);
        if(Build.VERSION.SDK_INT < 28) {
            this.clearCanvas(canvas0);
        }
        for(int v = 0; v < this.mask.getMasks().size(); ++v) {
            Mask mask0 = (Mask)this.mask.getMasks().get(v);
            BaseKeyframeAnimation baseKeyframeAnimation0 = (BaseKeyframeAnimation)this.mask.getMaskAnimations().get(v);
            BaseKeyframeAnimation baseKeyframeAnimation1 = (BaseKeyframeAnimation)this.mask.getOpacityAnimations().get(v);
            switch(com.airbnb.lottie.model.layer.BaseLayer.1.$SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode[mask0.getMaskMode().ordinal()]) {
                case 1: {
                    if(this.areAllMasksNone()) {
                        this.contentPaint.setAlpha(0xFF);
                        canvas0.drawRect(this.rect, this.contentPaint);
                    }
                    break;
                }
                case 2: {
                    if(v == 0) {
                        this.contentPaint.setColor(0xFF000000);
                        this.contentPaint.setAlpha(0xFF);
                        canvas0.drawRect(this.rect, this.contentPaint);
                    }
                    if(mask0.isInverted()) {
                        this.applyInvertedSubtractMask(canvas0, matrix0, baseKeyframeAnimation0, baseKeyframeAnimation1);
                    }
                    else {
                        this.applySubtractMask(canvas0, matrix0, baseKeyframeAnimation0);
                    }
                    break;
                }
                case 3: {
                    if(mask0.isInverted()) {
                        this.applyInvertedIntersectMask(canvas0, matrix0, baseKeyframeAnimation0, baseKeyframeAnimation1);
                    }
                    else {
                        this.applyIntersectMask(canvas0, matrix0, baseKeyframeAnimation0, baseKeyframeAnimation1);
                    }
                    break;
                }
                case 4: {
                    if(mask0.isInverted()) {
                        this.applyInvertedAddMask(canvas0, matrix0, baseKeyframeAnimation0, baseKeyframeAnimation1);
                    }
                    else {
                        this.applyAddMask(canvas0, matrix0, baseKeyframeAnimation0, baseKeyframeAnimation1);
                    }
                }
            }
        }
        canvas0.restore();
    }

    private void applySubtractMask(Canvas canvas0, Matrix matrix0, BaseKeyframeAnimation baseKeyframeAnimation0) {
        Path path0 = (Path)baseKeyframeAnimation0.getValue();
        this.path.set(path0);
        this.path.transform(matrix0);
        canvas0.drawPath(this.path, this.dstOutPaint);
    }

    private boolean areAllMasksNone() {
        if(this.mask.getMaskAnimations().isEmpty()) {
            return false;
        }
        for(int v = 0; v < this.mask.getMasks().size(); ++v) {
            if(((Mask)this.mask.getMasks().get(v)).getMaskMode() != MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void buildParentLayerListIfNeeded() {
        if(this.parentLayers == null) {
            if(this.parentLayer == null) {
                this.parentLayers = Collections.EMPTY_LIST;
                return;
            }
            this.parentLayers = new ArrayList();
            for(BaseLayer baseLayer0 = this.parentLayer; baseLayer0 != null; baseLayer0 = baseLayer0.parentLayer) {
                this.parentLayers.add(baseLayer0);
            }
        }
    }

    // 去混淆评级： 低(30)
    private void clearCanvas(Canvas canvas0) {
        canvas0.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, this.rect.bottom + 1.0f, this.clearPaint);
    }

    @Override  // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas0, Matrix matrix0, int v, DropShadow dropShadow0) {
        int v2;
        L.beginSection(this.drawTraceName);
        if(this.visible && !this.layerModel.isHidden()) {
            this.buildParentLayerListIfNeeded();
            this.matrix.reset();
            this.matrix.set(matrix0);
            for(int v1 = this.parentLayers.size() - 1; v1 >= 0; --v1) {
                Matrix matrix1 = ((BaseLayer)this.parentLayers.get(v1)).transform.getMatrix();
                this.matrix.preConcat(matrix1);
            }
            BaseKeyframeAnimation baseKeyframeAnimation0 = this.transform.getOpacity();
            if(baseKeyframeAnimation0 == null) {
                v2 = 100;
            }
            else {
                Integer integer0 = (Integer)baseKeyframeAnimation0.getValue();
                v2 = integer0 == null ? 100 : ((int)integer0);
            }
            int v3 = (int)(((float)v) / 255.0f * ((float)v2) / 100.0f * 255.0f);
            if(!this.hasMatteOnThisLayer() && !this.hasMasksOnThisLayer() && this.getBlendMode() == LBlendMode.NORMAL) {
                Matrix matrix2 = this.transform.getMatrix();
                this.matrix.preConcat(matrix2);
                this.drawLayer(canvas0, this.matrix, v3, dropShadow0);
                this.recordRenderTime(L.endSection(this.drawTraceName));
                return;
            }
            this.getBounds(this.rect, this.matrix, false);
            this.intersectBoundsWithMatte(this.rect, matrix0);
            Matrix matrix3 = this.transform.getMatrix();
            this.matrix.preConcat(matrix3);
            this.intersectBoundsWithMask(this.rect, this.matrix);
            float f = (float)canvas0.getWidth();
            float f1 = (float)canvas0.getHeight();
            this.canvasBounds.set(0.0f, 0.0f, f, f1);
            canvas0.getMatrix(this.canvasMatrix);
            if(!this.canvasMatrix.isIdentity()) {
                this.canvasMatrix.invert(this.canvasMatrix);
                this.canvasMatrix.mapRect(this.canvasBounds);
            }
            if(!this.rect.intersect(this.canvasBounds)) {
                this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            if(this.rect.width() >= 1.0f && this.rect.height() >= 1.0f) {
                this.contentPaint.setAlpha(0xFF);
                a a0 = this.getBlendMode().toNativeBlendMode();
                e.a(this.contentPaint, a0);
                Utils.saveLayerCompat(canvas0, this.rect, this.contentPaint);
                if(this.getBlendMode() == LBlendMode.MULTIPLY) {
                    if(this.solidWhitePaint == null) {
                        LPaint lPaint0 = new LPaint();
                        this.solidWhitePaint = lPaint0;
                        lPaint0.setColor(-1);
                    }
                    canvas0.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, this.rect.bottom + 1.0f, this.solidWhitePaint);
                }
                else {
                    this.clearCanvas(canvas0);
                }
                this.drawLayer(canvas0, this.matrix, v3, dropShadow0);
                if(this.hasMasksOnThisLayer()) {
                    this.applyMasks(canvas0, this.matrix);
                }
                if(this.hasMatteOnThisLayer()) {
                    Utils.saveLayerCompat(canvas0, this.rect, this.mattePaint, 19);
                    this.clearCanvas(canvas0);
                    this.matteLayer.draw(canvas0, matrix0, v, null);
                    canvas0.restore();
                }
                canvas0.restore();
            }
            if(this.outlineMasksAndMattes) {
                Paint paint0 = this.outlineMasksAndMattesPaint;
                if(paint0 != null) {
                    paint0.setStyle(Paint.Style.STROKE);
                    this.outlineMasksAndMattesPaint.setColor(0xFFFC2803);
                    this.outlineMasksAndMattesPaint.setStrokeWidth(4.0f);
                    canvas0.drawRect(this.rect, this.outlineMasksAndMattesPaint);
                    this.outlineMasksAndMattesPaint.setStyle(Paint.Style.FILL);
                    this.outlineMasksAndMattesPaint.setColor(0x50EBEBEB);
                    canvas0.drawRect(this.rect, this.outlineMasksAndMattesPaint);
                }
            }
            this.recordRenderTime(L.endSection(this.drawTraceName));
            return;
        }
        L.endSection(this.drawTraceName);
    }

    public abstract void drawLayer(Canvas arg1, Matrix arg2, int arg3, DropShadow arg4);

    public static BaseLayer forModel(CompositionLayer compositionLayer0, Layer layer0, LottieDrawable lottieDrawable0, LottieComposition lottieComposition0) {
        switch(com.airbnb.lottie.model.layer.BaseLayer.1.$SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType[layer0.getLayerType().ordinal()]) {
            case 1: {
                return new ShapeLayer(lottieDrawable0, layer0, compositionLayer0, lottieComposition0);
            }
            case 2: {
                return new CompositionLayer(lottieDrawable0, layer0, lottieComposition0.getPrecomps(layer0.getRefId()), lottieComposition0);
            }
            case 3: {
                return new SolidLayer(lottieDrawable0, layer0);
            }
            case 4: {
                return new ImageLayer(lottieDrawable0, layer0);
            }
            case 5: {
                return new NullLayer(lottieDrawable0, layer0);
            }
            case 6: {
                return new TextLayer(lottieDrawable0, layer0);
            }
            default: {
                Logger.warning(("Unknown layer type " + layer0.getLayerType()));
                return null;
            }
        }
    }

    public LBlendMode getBlendMode() {
        return this.layerModel.getBlendMode();
    }

    public BlurEffect getBlurEffect() {
        return this.layerModel.getBlurEffect();
    }

    public BlurMaskFilter getBlurMaskFilter(float f) {
        if(this.blurMaskFilterRadius == f) {
            return this.blurMaskFilter;
        }
        BlurMaskFilter blurMaskFilter0 = new BlurMaskFilter(f / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.blurMaskFilter = blurMaskFilter0;
        this.blurMaskFilterRadius = f;
        return blurMaskFilter0;
    }

    @Override  // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF0, Matrix matrix0, boolean z) {
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        this.buildParentLayerListIfNeeded();
        this.boundsMatrix.set(matrix0);
        if(z) {
            List list0 = this.parentLayers;
            if(list0 == null) {
                BaseLayer baseLayer0 = this.parentLayer;
                if(baseLayer0 != null) {
                    Matrix matrix2 = baseLayer0.transform.getMatrix();
                    this.boundsMatrix.preConcat(matrix2);
                }
            }
            else {
                for(int v = list0.size() - 1; v >= 0; --v) {
                    Matrix matrix1 = ((BaseLayer)this.parentLayers.get(v)).transform.getMatrix();
                    this.boundsMatrix.preConcat(matrix1);
                }
            }
        }
        Matrix matrix3 = this.transform.getMatrix();
        this.boundsMatrix.preConcat(matrix3);
    }

    public DropShadowEffect getDropShadowEffect() {
        return this.layerModel.getDropShadowEffect();
    }

    public Layer getLayerModel() {
        return this.layerModel;
    }

    @Override  // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.layerModel.getName();
    }

    public boolean hasMasksOnThisLayer() {
        return this.mask != null && !this.mask.getMaskAnimations().isEmpty();
    }

    public boolean hasMatteOnThisLayer() {
        return this.matteLayer != null;
    }

    private void intersectBoundsWithMask(RectF rectF0, Matrix matrix0) {
        this.maskBoundsRect.set(0.0f, 0.0f, 0.0f, 0.0f);
        if(this.hasMasksOnThisLayer()) {
            int v = this.mask.getMasks().size();
            int v1 = 0;
        alab1:
            while(true) {
                if(v1 >= v) {
                    if(rectF0.intersect(this.maskBoundsRect)) {
                        break;
                    }
                    rectF0.set(0.0f, 0.0f, 0.0f, 0.0f);
                    break;
                }
                Mask mask0 = (Mask)this.mask.getMasks().get(v1);
                Path path0 = (Path)((BaseKeyframeAnimation)this.mask.getMaskAnimations().get(v1)).getValue();
                if(path0 != null) {
                    this.path.set(path0);
                    this.path.transform(matrix0);
                    switch(com.airbnb.lottie.model.layer.BaseLayer.1.$SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode[mask0.getMaskMode().ordinal()]) {
                        case 1: 
                        case 2: {
                            break alab1;
                        }
                        case 3: 
                        case 4: {
                            if(mask0.isInverted()) {
                                break alab1;
                            }
                        label_13:
                            this.path.computeBounds(this.tempMaskBoundsRect, false);
                            if(v1 == 0) {
                                this.maskBoundsRect.set(this.tempMaskBoundsRect);
                            }
                            else {
                                this.maskBoundsRect.set(Math.min(this.maskBoundsRect.left, this.tempMaskBoundsRect.left), Math.min(this.maskBoundsRect.top, this.tempMaskBoundsRect.top), Math.max(this.maskBoundsRect.right, this.tempMaskBoundsRect.right), Math.max(this.maskBoundsRect.bottom, this.tempMaskBoundsRect.bottom));
                            }
                            break;
                        }
                        default: {
                            goto label_13;
                        }
                    }
                }
                ++v1;
            }
        }
    }

    private void intersectBoundsWithMatte(RectF rectF0, Matrix matrix0) {
        if(this.hasMatteOnThisLayer() && this.layerModel.getMatteType() != MatteType.INVERT) {
            this.matteBoundsRect.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.matteLayer.getBounds(this.matteBoundsRect, matrix0, true);
            if(!rectF0.intersect(this.matteBoundsRect)) {
                rectF0.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    private void invalidateSelf() {
        this.lottieDrawable.invalidateSelf();
    }

    // 检测为 Lambda 实现
    private void lambda$setupInOutAnimations$0() [...]

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener
    public void onValueChanged() {
        this.invalidateSelf();
    }

    private void recordRenderTime(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().recordRenderTime(this.layerModel.getName(), f);
    }

    public void removeAnimation(BaseKeyframeAnimation baseKeyframeAnimation0) {
        this.animations.remove(baseKeyframeAnimation0);
    }

    public void resolveChildKeyPath(KeyPath keyPath0, int v, List list0, KeyPath keyPath1) {
    }

    @Override  // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath0, int v, List list0, KeyPath keyPath1) {
        BaseLayer baseLayer0 = this.matteLayer;
        if(baseLayer0 != null) {
            KeyPath keyPath2 = keyPath1.addKey(baseLayer0.getName());
            if(keyPath0.fullyResolvesTo(this.matteLayer.getName(), v)) {
                list0.add(keyPath2.resolve(this.matteLayer));
            }
            if(keyPath0.matches(this.matteLayer.getName(), v) && keyPath0.propagateToChildren(this.getName(), v)) {
                int v1 = keyPath0.incrementDepthBy(this.matteLayer.getName(), v);
                this.matteLayer.resolveChildKeyPath(keyPath0, v1 + v, list0, keyPath2);
            }
        }
        if(keyPath0.matches(this.getName(), v)) {
            if(!"__container".equals(this.getName())) {
                keyPath1 = keyPath1.addKey(this.getName());
                if(keyPath0.fullyResolvesTo(this.getName(), v)) {
                    list0.add(keyPath1.resolve(this));
                }
            }
            if(keyPath0.propagateToChildren(this.getName(), v)) {
                this.resolveChildKeyPath(keyPath0, keyPath0.incrementDepthBy(this.getName(), v) + v, list0, keyPath1);
            }
        }
    }

    @Override  // com.airbnb.lottie.animation.content.Content
    public void setContents(List list0, List list1) {
    }

    public void setMatteLayer(BaseLayer baseLayer0) {
        this.matteLayer = baseLayer0;
    }

    public void setOutlineMasksAndMattes(boolean z) {
        if(z && this.outlineMasksAndMattesPaint == null) {
            this.outlineMasksAndMattesPaint = new LPaint();
        }
        this.outlineMasksAndMattes = z;
    }

    public void setParentLayer(BaseLayer baseLayer0) {
        this.parentLayer = baseLayer0;
    }

    public void setProgress(float f) {
        this.transform.setProgress(f);
        if(this.mask != null) {
            for(int v1 = 0; v1 < this.mask.getMaskAnimations().size(); ++v1) {
                ((BaseKeyframeAnimation)this.mask.getMaskAnimations().get(v1)).setProgress(f);
            }
        }
        if(this.inOutAnimation != null) {
            this.inOutAnimation.setProgress(f);
        }
        if(this.matteLayer != null) {
            this.matteLayer.setProgress(f);
        }
        for(int v = 0; v < this.animations.size(); ++v) {
            ((BaseKeyframeAnimation)this.animations.get(v)).setProgress(f);
        }
    }

    private void setVisible(boolean z) {
        if(z != this.visible) {
            this.visible = z;
            this.invalidateSelf();
        }
    }

    private void setupInOutAnimations() {
        boolean z = true;
        if(!this.layerModel.getInOutKeyframes().isEmpty()) {
            FloatKeyframeAnimation floatKeyframeAnimation0 = new FloatKeyframeAnimation(this.layerModel.getInOutKeyframes());
            this.inOutAnimation = floatKeyframeAnimation0;
            floatKeyframeAnimation0.setIsDiscrete();
            this.inOutAnimation.addUpdateListener(() -> this.setVisible(this.inOutAnimation.getFloatValue() == 1.0f));
            if(((float)(((Float)this.inOutAnimation.getValue()))) != 1.0f) {
                z = false;
            }
            this.setVisible(z);
            this.addAnimation(this.inOutAnimation);
            return;
        }
        this.setVisible(true);
    }
}

