package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.animation.content.ShapeModifierContent;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class ShapeKeyframeAnimation extends BaseKeyframeAnimation {
    private List shapeModifiers;
    private final Path tempPath;
    private final ShapeData tempShapeData;
    private Path valueCallbackEndPath;
    private Path valueCallbackStartPath;

    public ShapeKeyframeAnimation(List list0) {
        super(list0);
        this.tempShapeData = new ShapeData();
        this.tempPath = new Path();
    }

    public Path getValue(Keyframe keyframe0, float f) {
        ShapeData shapeData0 = (ShapeData)keyframe0.startValue;
        ShapeData shapeData1 = (ShapeData)keyframe0.endValue;
        this.tempShapeData.interpolateBetween(shapeData0, (shapeData1 == null ? shapeData0 : shapeData1), f);
        ShapeData shapeData2 = this.tempShapeData;
        List list0 = this.shapeModifiers;
        if(list0 != null) {
            for(int v = list0.size() - 1; v >= 0; --v) {
                shapeData2 = ((ShapeModifierContent)this.shapeModifiers.get(v)).modifyShape(shapeData2);
            }
        }
        MiscUtils.getPathFromData(shapeData2, this.tempPath);
        if(this.valueCallback != null) {
            if(this.valueCallbackStartPath == null) {
                this.valueCallbackStartPath = new Path();
                this.valueCallbackEndPath = new Path();
            }
            MiscUtils.getPathFromData(shapeData0, this.valueCallbackStartPath);
            if(shapeData1 != null) {
                MiscUtils.getPathFromData(shapeData1, this.valueCallbackEndPath);
            }
            LottieValueCallback lottieValueCallback0 = this.valueCallback;
            float f1 = (float)keyframe0.endFrame;
            Path path0 = this.valueCallbackStartPath;
            return shapeData1 == null ? ((Path)lottieValueCallback0.getValueInternal(keyframe0.startFrame, f1, path0, path0, f, this.getLinearCurrentKeyframeProgress(), this.getProgress())) : ((Path)lottieValueCallback0.getValueInternal(keyframe0.startFrame, f1, path0, this.valueCallbackEndPath, f, this.getLinearCurrentKeyframeProgress(), this.getProgress()));
        }
        return this.tempPath;
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Object getValue(Keyframe keyframe0, float f) {
        return this.getValue(keyframe0, f);
    }

    public void setShapeModifiers(List list0) {
        this.shapeModifiers = list0;
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public boolean skipCache() {
        return this.shapeModifiers != null && !this.shapeModifiers.isEmpty();
    }
}

