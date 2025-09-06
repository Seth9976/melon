package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.DropShadow;
import com.airbnb.lottie.utils.OffscreenLayer.ComposeOp;
import com.airbnb.lottie.utils.OffscreenLayer;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class ContentGroup implements DrawingContent, PathContent, AnimationListener, KeyPathElement {
    private final List contents;
    private final boolean hidden;
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix;
    private final String name;
    private final RectF offScreenRectF;
    private final OffscreenLayer offscreenLayer;
    private final ComposeOp offscreenOp;
    private final Path path;
    private List pathContents;
    private final RectF rect;
    private TransformKeyframeAnimation transformAnimation;

    public ContentGroup(LottieDrawable lottieDrawable0, BaseLayer baseLayer0, ShapeGroup shapeGroup0, LottieComposition lottieComposition0) {
        this(lottieDrawable0, baseLayer0, shapeGroup0.getName(), shapeGroup0.isHidden(), ContentGroup.contentsFromModels(lottieDrawable0, lottieComposition0, baseLayer0, shapeGroup0.getItems()), ContentGroup.findTransform(shapeGroup0.getItems()));
    }

    public ContentGroup(LottieDrawable lottieDrawable0, BaseLayer baseLayer0, String s, boolean z, List list0, AnimatableTransform animatableTransform0) {
        this.offscreenOp = new ComposeOp();
        this.offScreenRectF = new RectF();
        this.offscreenLayer = new OffscreenLayer();
        this.matrix = new Matrix();
        this.path = new Path();
        this.rect = new RectF();
        this.name = s;
        this.lottieDrawable = lottieDrawable0;
        this.hidden = z;
        this.contents = list0;
        if(animatableTransform0 != null) {
            TransformKeyframeAnimation transformKeyframeAnimation0 = animatableTransform0.createAnimation();
            this.transformAnimation = transformKeyframeAnimation0;
            transformKeyframeAnimation0.addAnimationsToLayer(baseLayer0);
            this.transformAnimation.addListener(this);
        }
        ArrayList arrayList0 = new ArrayList();
        for(int v = list0.size() - 1; v >= 0; --v) {
            Content content0 = (Content)list0.get(v);
            if(content0 instanceof GreedyContent) {
                arrayList0.add(((GreedyContent)content0));
            }
        }
        for(int v1 = arrayList0.size() - 1; v1 >= 0; --v1) {
            ((GreedyContent)arrayList0.get(v1)).absorbContent(list0.listIterator(list0.size()));
        }
    }

    @Override  // com.airbnb.lottie.model.KeyPathElement
    public void addValueCallback(Object object0, LottieValueCallback lottieValueCallback0) {
        TransformKeyframeAnimation transformKeyframeAnimation0 = this.transformAnimation;
        if(transformKeyframeAnimation0 != null) {
            transformKeyframeAnimation0.applyValueCallback(object0, lottieValueCallback0);
        }
    }

    private static List contentsFromModels(LottieDrawable lottieDrawable0, LottieComposition lottieComposition0, BaseLayer baseLayer0, List list0) {
        List list1 = new ArrayList(list0.size());
        for(int v = 0; v < list0.size(); ++v) {
            Content content0 = ((ContentModel)list0.get(v)).toContent(lottieDrawable0, lottieComposition0, baseLayer0);
            if(content0 != null) {
                ((ArrayList)list1).add(content0);
            }
        }
        return list1;
    }

    @Override  // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas0, Matrix matrix0, int v, DropShadow dropShadow0) {
        if(!this.hidden) {
            this.matrix.set(matrix0);
            TransformKeyframeAnimation transformKeyframeAnimation0 = this.transformAnimation;
            if(transformKeyframeAnimation0 != null) {
                Matrix matrix1 = transformKeyframeAnimation0.getMatrix();
                this.matrix.preConcat(matrix1);
                v = (int)(((float)(this.transformAnimation.getOpacity() == null ? 100 : ((int)(((Integer)this.transformAnimation.getOpacity().getValue()))))) / 100.0f * ((float)v) / 255.0f * 255.0f);
            }
            int v1 = 0xFF;
            boolean z = this.lottieDrawable.isApplyingOpacityToLayersEnabled() && this.hasTwoOrMoreDrawableContent() && v != 0xFF || dropShadow0 != null && this.lottieDrawable.isApplyingShadowToLayersEnabled() && this.hasTwoOrMoreDrawableContent();
            if(!z) {
                v1 = v;
            }
            if(z) {
                this.offScreenRectF.set(0.0f, 0.0f, 0.0f, 0.0f);
                this.getBounds(this.offScreenRectF, matrix0, true);
                ComposeOp offscreenLayer$ComposeOp0 = this.offscreenOp;
                offscreenLayer$ComposeOp0.alpha = v;
                if(dropShadow0 == null) {
                    offscreenLayer$ComposeOp0.shadow = null;
                }
                else {
                    dropShadow0.applyTo(offscreenLayer$ComposeOp0);
                    dropShadow0 = null;
                }
                canvas0 = this.offscreenLayer.start(canvas0, this.offScreenRectF, this.offscreenOp);
            }
            else if(dropShadow0 != null) {
                DropShadow dropShadow1 = new DropShadow(dropShadow0);
                dropShadow1.multiplyOpacity(v1);
                dropShadow0 = dropShadow1;
            }
            for(int v2 = this.contents.size() - 1; v2 >= 0; --v2) {
                Object object0 = this.contents.get(v2);
                if(object0 instanceof DrawingContent) {
                    ((DrawingContent)object0).draw(canvas0, this.matrix, v1, dropShadow0);
                }
            }
            if(z) {
                this.offscreenLayer.finish();
            }
        }
    }

    public static AnimatableTransform findTransform(List list0) {
        for(int v = 0; v < list0.size(); ++v) {
            ContentModel contentModel0 = (ContentModel)list0.get(v);
            if(contentModel0 instanceof AnimatableTransform) {
                return (AnimatableTransform)contentModel0;
            }
        }
        return null;
    }

    @Override  // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF0, Matrix matrix0, boolean z) {
        this.matrix.set(matrix0);
        TransformKeyframeAnimation transformKeyframeAnimation0 = this.transformAnimation;
        if(transformKeyframeAnimation0 != null) {
            Matrix matrix1 = transformKeyframeAnimation0.getMatrix();
            this.matrix.preConcat(matrix1);
        }
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for(int v = this.contents.size() - 1; v >= 0; --v) {
            Content content0 = (Content)this.contents.get(v);
            if(content0 instanceof DrawingContent) {
                ((DrawingContent)content0).getBounds(this.rect, this.matrix, z);
                rectF0.union(this.rect);
            }
        }
    }

    public List getContents() {
        return this.contents;
    }

    @Override  // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override  // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        this.matrix.reset();
        TransformKeyframeAnimation transformKeyframeAnimation0 = this.transformAnimation;
        if(transformKeyframeAnimation0 != null) {
            Matrix matrix0 = transformKeyframeAnimation0.getMatrix();
            this.matrix.set(matrix0);
        }
        this.path.reset();
        if(this.hidden) {
            return this.path;
        }
        for(int v = this.contents.size() - 1; v >= 0; --v) {
            Content content0 = (Content)this.contents.get(v);
            if(content0 instanceof PathContent) {
                Path path0 = ((PathContent)content0).getPath();
                this.path.addPath(path0, this.matrix);
            }
        }
        return this.path;
    }

    public List getPathList() {
        if(this.pathContents == null) {
            this.pathContents = new ArrayList();
            for(int v = 0; v < this.contents.size(); ++v) {
                Content content0 = (Content)this.contents.get(v);
                if(content0 instanceof PathContent) {
                    this.pathContents.add(((PathContent)content0));
                }
            }
        }
        return this.pathContents;
    }

    public Matrix getTransformationMatrix() {
        TransformKeyframeAnimation transformKeyframeAnimation0 = this.transformAnimation;
        if(transformKeyframeAnimation0 != null) {
            return transformKeyframeAnimation0.getMatrix();
        }
        this.matrix.reset();
        return this.matrix;
    }

    private boolean hasTwoOrMoreDrawableContent() {
        int v1 = 0;
        for(int v = 0; v < this.contents.size(); ++v) {
            if(this.contents.get(v) instanceof DrawingContent) {
                ++v1;
                if(v1 >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override  // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath0, int v, List list0, KeyPath keyPath1) {
        if(keyPath0.matches(this.getName(), v) || "__container".equals(this.getName())) {
            if(!"__container".equals(this.getName())) {
                keyPath1 = keyPath1.addKey(this.getName());
                if(keyPath0.fullyResolvesTo(this.getName(), v)) {
                    list0.add(keyPath1.resolve(this));
                }
            }
            if(keyPath0.propagateToChildren(this.getName(), v)) {
                int v1 = keyPath0.incrementDepthBy(this.getName(), v);
                for(int v2 = 0; v2 < this.contents.size(); ++v2) {
                    Content content0 = (Content)this.contents.get(v2);
                    if(content0 instanceof KeyPathElement) {
                        ((KeyPathElement)content0).resolveKeyPath(keyPath0, v1 + v, list0, keyPath1);
                    }
                }
            }
        }
    }

    @Override  // com.airbnb.lottie.animation.content.Content
    public void setContents(List list0, List list1) {
        ArrayList arrayList0 = new ArrayList(this.contents.size() + list0.size());
        arrayList0.addAll(list0);
        for(int v = this.contents.size() - 1; v >= 0; --v) {
            Content content0 = (Content)this.contents.get(v);
            content0.setContents(arrayList0, this.contents.subList(0, v));
            arrayList0.add(content0);
        }
    }
}

