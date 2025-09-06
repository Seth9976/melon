package com.airbnb.lottie.animation.content;

import android.graphics.Path.FillType;
import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.airbnb.lottie.animation.keyframe.ShapeKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class ShapeContent implements KeyPathElementContent, PathContent, AnimationListener {
    private final boolean hidden;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final Path path;
    private final ShapeKeyframeAnimation shapeAnimation;
    private List shapeModifierContents;
    private final CompoundTrimPathContent trimPaths;

    public ShapeContent(LottieDrawable lottieDrawable0, BaseLayer baseLayer0, ShapePath shapePath0) {
        this.path = new Path();
        this.trimPaths = new CompoundTrimPathContent();
        this.name = shapePath0.getName();
        this.hidden = shapePath0.isHidden();
        this.lottieDrawable = lottieDrawable0;
        ShapeKeyframeAnimation shapeKeyframeAnimation0 = shapePath0.getShapePath().createAnimation();
        this.shapeAnimation = shapeKeyframeAnimation0;
        baseLayer0.addAnimation(shapeKeyframeAnimation0);
        shapeKeyframeAnimation0.addUpdateListener(this);
    }

    @Override  // com.airbnb.lottie.model.KeyPathElement
    public void addValueCallback(Object object0, LottieValueCallback lottieValueCallback0) {
        if(object0 == LottieProperty.PATH) {
            this.shapeAnimation.setValueCallback(lottieValueCallback0);
        }
    }

    @Override  // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override  // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        if(this.isPathValid && !this.shapeAnimation.hasValueCallback()) {
            return this.path;
        }
        this.path.reset();
        if(this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        Path path0 = (Path)this.shapeAnimation.getValue();
        if(path0 == null) {
            return this.path;
        }
        this.path.set(path0);
        this.path.setFillType(Path.FillType.EVEN_ODD);
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
        List list2 = null;
        for(int v = 0; v < list0.size(); ++v) {
            Content content0 = (Content)list0.get(v);
            if(content0 instanceof TrimPathContent && ((TrimPathContent)content0).getType() == Type.SIMULTANEOUSLY) {
                this.trimPaths.addTrimPath(((TrimPathContent)content0));
                ((TrimPathContent)content0).addListener(this);
            }
            else if(content0 instanceof ShapeModifierContent) {
                if(list2 == null) {
                    list2 = new ArrayList();
                }
                ((ShapeModifierContent)content0).addUpdateListener(this);
                list2.add(((ShapeModifierContent)content0));
            }
        }
        this.shapeAnimation.setShapeModifiers(list2);
    }
}

