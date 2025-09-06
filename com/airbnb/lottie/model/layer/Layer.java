package com.airbnb.lottie.model.layer;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.LBlendMode;
import com.airbnb.lottie.parser.DropShadowEffect;
import java.util.List;
import java.util.Locale;
import k8.Y;

public class Layer {
    public static enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN;

        private static LayerType[] $values() [...] // Inlined contents
    }

    public static enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN;

        private static MatteType[] $values() [...] // Inlined contents
    }

    private final LBlendMode blendMode;
    private final BlurEffect blurEffect;
    private final LottieComposition composition;
    private final DropShadowEffect dropShadowEffect;
    private final boolean hidden;
    private final List inOutKeyframes;
    private final long layerId;
    private final String layerName;
    private final LayerType layerType;
    private final List masks;
    private final MatteType matteType;
    private final long parentId;
    private final float preCompHeight;
    private final float preCompWidth;
    private final String refId;
    private final List shapes;
    private final int solidColor;
    private final int solidHeight;
    private final int solidWidth;
    private final float startFrame;
    private final AnimatableTextFrame text;
    private final AnimatableTextProperties textProperties;
    private final AnimatableFloatValue timeRemapping;
    private final float timeStretch;
    private final AnimatableTransform transform;

    public Layer(List list0, LottieComposition lottieComposition0, String s, long v, LayerType layer$LayerType0, long v1, String s1, List list1, AnimatableTransform animatableTransform0, int v2, int v3, int v4, float f, float f1, float f2, float f3, AnimatableTextFrame animatableTextFrame0, AnimatableTextProperties animatableTextProperties0, List list2, MatteType layer$MatteType0, AnimatableFloatValue animatableFloatValue0, boolean z, BlurEffect blurEffect0, DropShadowEffect dropShadowEffect0, LBlendMode lBlendMode0) {
        this.shapes = list0;
        this.composition = lottieComposition0;
        this.layerName = s;
        this.layerId = v;
        this.layerType = layer$LayerType0;
        this.parentId = v1;
        this.refId = s1;
        this.masks = list1;
        this.transform = animatableTransform0;
        this.solidWidth = v2;
        this.solidHeight = v3;
        this.solidColor = v4;
        this.timeStretch = f;
        this.startFrame = f1;
        this.preCompWidth = f2;
        this.preCompHeight = f3;
        this.text = animatableTextFrame0;
        this.textProperties = animatableTextProperties0;
        this.inOutKeyframes = list2;
        this.matteType = layer$MatteType0;
        this.timeRemapping = animatableFloatValue0;
        this.hidden = z;
        this.blurEffect = blurEffect0;
        this.dropShadowEffect = dropShadowEffect0;
        this.blendMode = lBlendMode0;
    }

    public LBlendMode getBlendMode() {
        return this.blendMode;
    }

    public BlurEffect getBlurEffect() {
        return this.blurEffect;
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    public DropShadowEffect getDropShadowEffect() {
        return this.dropShadowEffect;
    }

    public long getId() {
        return this.layerId;
    }

    public List getInOutKeyframes() {
        return this.inOutKeyframes;
    }

    public LayerType getLayerType() {
        return this.layerType;
    }

    public List getMasks() {
        return this.masks;
    }

    public MatteType getMatteType() {
        return this.matteType;
    }

    public String getName() {
        return this.layerName;
    }

    public long getParentId() {
        return this.parentId;
    }

    public float getPreCompHeight() {
        return this.preCompHeight;
    }

    public float getPreCompWidth() {
        return this.preCompWidth;
    }

    public String getRefId() {
        return this.refId;
    }

    public List getShapes() {
        return this.shapes;
    }

    public int getSolidColor() {
        return this.solidColor;
    }

    public int getSolidHeight() {
        return this.solidHeight;
    }

    public int getSolidWidth() {
        return this.solidWidth;
    }

    public float getStartProgress() {
        return this.startFrame / this.composition.getDurationFrames();
    }

    public AnimatableTextFrame getText() {
        return this.text;
    }

    public AnimatableTextProperties getTextProperties() {
        return this.textProperties;
    }

    public AnimatableFloatValue getTimeRemapping() {
        return this.timeRemapping;
    }

    public float getTimeStretch() {
        return this.timeStretch;
    }

    public AnimatableTransform getTransform() {
        return this.transform;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    @Override
    public String toString() {
        return this.toString("");
    }

    public String toString(String s) {
        StringBuilder stringBuilder0 = Y.p(s);
        stringBuilder0.append(this.getName());
        stringBuilder0.append("\n");
        Layer layer0 = this.composition.layerModelForId(this.getParentId());
        if(layer0 != null) {
            stringBuilder0.append("\t\tParents: ");
            stringBuilder0.append(layer0.getName());
            for(Layer layer1 = this.composition.layerModelForId(layer0.getParentId()); layer1 != null; layer1 = this.composition.layerModelForId(layer1.getParentId())) {
                stringBuilder0.append("->");
                stringBuilder0.append(layer1.getName());
            }
            stringBuilder0.append(s);
            stringBuilder0.append("\n");
        }
        if(!this.getMasks().isEmpty()) {
            stringBuilder0.append(s);
            stringBuilder0.append("\tMasks: ");
            stringBuilder0.append(this.getMasks().size());
            stringBuilder0.append("\n");
        }
        if(this.getSolidWidth() != 0 && this.getSolidHeight() != 0) {
            stringBuilder0.append(s);
            stringBuilder0.append("\tBackground: ");
            stringBuilder0.append(String.format(Locale.US, "%dx%d %X\n", this.getSolidWidth(), this.getSolidHeight(), this.getSolidColor()));
        }
        if(!this.shapes.isEmpty()) {
            stringBuilder0.append(s);
            stringBuilder0.append("\tShapes:\n");
            for(Object object0: this.shapes) {
                stringBuilder0.append(s);
                stringBuilder0.append("\t\t");
                stringBuilder0.append(object0);
                stringBuilder0.append("\n");
            }
        }
        return stringBuilder0.toString();
    }
}

