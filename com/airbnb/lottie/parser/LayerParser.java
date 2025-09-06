package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.LBlendMode;
import com.airbnb.lottie.model.layer.Layer.LayerType;
import com.airbnb.lottie.model.layer.Layer.MatteType;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LayerParser {
    private static final Options EFFECTS_NAMES;
    private static final Options NAMES;
    private static final Options TEXT_NAMES;

    static {
        LayerParser.NAMES = Options.of(new String[]{"nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd", "ao", "bm"});
        LayerParser.TEXT_NAMES = Options.of(new String[]{"d", "a"});
        LayerParser.EFFECTS_NAMES = Options.of(new String[]{"ty", "nm"});
    }

    public static Layer parse(LottieComposition lottieComposition0) {
        Rect rect0 = lottieComposition0.getBounds();
        List list0 = Collections.EMPTY_LIST;
        AnimatableTransform animatableTransform0 = new AnimatableTransform();
        float f = (float)rect0.width();
        float f1 = (float)rect0.height();
        return new Layer(list0, lottieComposition0, "__container", -1L, LayerType.PRE_COMP, -1L, null, list0, animatableTransform0, 0, 0, 0, 0.0f, 0.0f, f, f1, null, null, list0, MatteType.NONE, null, false, null, null, LBlendMode.NORMAL);
    }

    public static Layer parse(JsonReader jsonReader0, LottieComposition lottieComposition0) {
        float f6;
        boolean z2;
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        jsonReader0.beginObject();
        MatteType layer$MatteType0 = MatteType.NONE;
        LBlendMode lBlendMode0 = LBlendMode.NORMAL;
        float f = 0.0f;
        float f1 = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        String s = null;
        AnimatableTextFrame animatableTextFrame0 = null;
        AnimatableTextProperties animatableTextProperties0 = null;
        AnimatableFloatValue animatableFloatValue0 = null;
        BlurEffect blurEffect0 = null;
        DropShadowEffect dropShadowEffect0 = null;
        long v = 0L;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        boolean z = false;
        long v4 = -1L;
        float f5 = 1.0f;
        String s1 = "UNSET";
        String s2 = null;
        AnimatableTransform animatableTransform0 = null;
        LayerType layer$LayerType0 = null;
        boolean z1 = false;
        while(jsonReader0.hasNext()) {
            switch(jsonReader0.selectName(LayerParser.NAMES)) {
                case 0: {
                    s1 = jsonReader0.nextString();
                    continue;
                }
                case 1: {
                    v = (long)jsonReader0.nextInt();
                    continue;
                }
                case 2: {
                    s = jsonReader0.nextString();
                    continue;
                }
                case 3: {
                    goto label_40;
                }
                case 4: {
                    v4 = (long)jsonReader0.nextInt();
                    continue;
                }
                case 5: {
                    goto label_50;
                }
                case 6: {
                    goto label_53;
                }
                case 7: {
                    v3 = Color.parseColor(jsonReader0.nextString());
                    continue;
                }
                case 8: {
                    animatableTransform0 = AnimatableTransformParser.parse(jsonReader0, lottieComposition0);
                    continue;
                }
                case 9: {
                    goto label_60;
                }
                case 10: {
                    goto label_73;
                }
                case 11: {
                    goto label_81;
                }
                case 12: {
                    goto label_90;
                }
                case 13: {
                    goto label_109;
                }
                case 14: {
                    f5 = (float)jsonReader0.nextDouble();
                    continue;
                }
                case 15: {
                    f4 = (float)jsonReader0.nextDouble();
                    continue;
                }
                case 16: {
                    f6 = f5;
                    f2 = (float)(jsonReader0.nextDouble() * ((double)Utils.dpScale()));
                    f5 = f6;
                    continue;
                }
                case 17: {
                    f6 = f5;
                    f3 = (float)(jsonReader0.nextDouble() * ((double)Utils.dpScale()));
                    f5 = f6;
                    continue;
                }
                case 18: {
                    f = (float)jsonReader0.nextDouble();
                    continue;
                }
                case 19: {
                    f1 = (float)jsonReader0.nextDouble();
                    continue;
                }
                case 20: {
                    animatableFloatValue0 = AnimatableValueParser.parseFloat(jsonReader0, lottieComposition0, false);
                    continue;
                }
                case 21: {
                    s2 = jsonReader0.nextString();
                    continue;
                }
                case 22: {
                    z = jsonReader0.nextBoolean();
                    continue;
                }
                case 23: {
                    z1 = jsonReader0.nextInt() == 1;
                    continue;
                }
                case 24: {
                    goto label_160;
                }
            }
            jsonReader0.skipName();
            jsonReader0.skipValue();
            f6 = f5;
            f5 = f6;
            continue;
        label_40:
            f6 = f5;
            int v5 = jsonReader0.nextInt();
            LayerType layer$LayerType1 = LayerType.UNKNOWN;
            layer$LayerType0 = v5 >= layer$LayerType1.ordinal() ? layer$LayerType1 : LayerType.values()[v5];
            f5 = f6;
            continue;
        label_50:
            float f7 = (float)jsonReader0.nextInt();
            v1 = (int)(Utils.dpScale() * f7);
            continue;
        label_53:
            float f8 = (float)jsonReader0.nextInt();
            v2 = (int)(Utils.dpScale() * f8);
            continue;
        label_60:
            f6 = f5;
            int v6 = jsonReader0.nextInt();
            if(v6 >= MatteType.values().length) {
                lottieComposition0.addWarning("Unsupported matte type: " + v6);
            }
            else {
                layer$MatteType0 = MatteType.values()[v6];
                switch(com.airbnb.lottie.parser.LayerParser.1.$SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[layer$MatteType0.ordinal()]) {
                    case 1: {
                        lottieComposition0.addWarning("Unsupported matte type: Luma");
                        break;
                    }
                    case 2: {
                        lottieComposition0.addWarning("Unsupported matte type: Luma Inverted");
                    }
                }
                lottieComposition0.incrementMatteOrMaskCount(1);
            }
            f5 = f6;
            continue;
        label_73:
            f6 = f5;
            jsonReader0.beginArray();
            while(jsonReader0.hasNext()) {
                arrayList0.add(MaskParser.parse(jsonReader0, lottieComposition0));
            }
            lottieComposition0.incrementMatteOrMaskCount(arrayList0.size());
            jsonReader0.endArray();
            f5 = f6;
            continue;
        label_81:
            f6 = f5;
            jsonReader0.beginArray();
            while(jsonReader0.hasNext()) {
                ContentModel contentModel0 = ContentModelParser.parse(jsonReader0, lottieComposition0);
                if(contentModel0 != null) {
                    arrayList1.add(contentModel0);
                }
            }
            jsonReader0.endArray();
            f5 = f6;
            continue;
        label_90:
            f6 = f5;
            jsonReader0.beginObject();
            while(jsonReader0.hasNext()) {
            alab1:
                switch(jsonReader0.selectName(LayerParser.TEXT_NAMES)) {
                    case 0: {
                        animatableTextFrame0 = AnimatableValueParser.parseDocumentData(jsonReader0, lottieComposition0);
                        continue;
                    }
                    case 1: {
                        jsonReader0.beginArray();
                        if(jsonReader0.hasNext()) {
                            animatableTextProperties0 = AnimatableTextPropertiesParser.parse(jsonReader0, lottieComposition0);
                        }
                        while(true) {
                            if(!jsonReader0.hasNext()) {
                                break alab1;
                            }
                            jsonReader0.skipValue();
                        }
                    }
                    default: {
                        jsonReader0.skipName();
                        jsonReader0.skipValue();
                        continue;
                    }
                }
                jsonReader0.endArray();
            }
            jsonReader0.endObject();
            f5 = f6;
            continue;
        label_109:
            f6 = f5;
            jsonReader0.beginArray();
            ArrayList arrayList2 = new ArrayList();
            while(jsonReader0.hasNext()) {
                jsonReader0.beginObject();
                while(jsonReader0.hasNext()) {
                    switch(jsonReader0.selectName(LayerParser.EFFECTS_NAMES)) {
                        case 0: {
                            int v7 = jsonReader0.nextInt();
                            if(v7 == 29) {
                                blurEffect0 = BlurEffectParser.parse(jsonReader0, lottieComposition0);
                                continue;
                            }
                            else {
                                if(v7 != 25) {
                                    continue;
                                }
                                dropShadowEffect0 = new DropShadowEffectParser().parse(jsonReader0, lottieComposition0);
                                break;
                            }
                            arrayList2.add(jsonReader0.nextString());
                            break;
                        }
                        case 1: {
                            arrayList2.add(jsonReader0.nextString());
                            break;
                        }
                        default: {
                            jsonReader0.skipName();
                            jsonReader0.skipValue();
                        }
                    }
                }
                jsonReader0.endObject();
            }
            jsonReader0.endArray();
            lottieComposition0.addWarning("Lottie doesn\'t support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList2);
            f5 = f6;
            continue;
        label_160:
            int v8 = jsonReader0.nextInt();
            if(v8 >= LBlendMode.values().length) {
                lottieComposition0.addWarning("Unsupported Blend Mode: " + v8);
                lBlendMode0 = LBlendMode.NORMAL;
            }
            else {
                lBlendMode0 = LBlendMode.values()[v8];
            }
        }
        jsonReader0.endObject();
        ArrayList arrayList3 = new ArrayList();
        if(f > 0.0f) {
            z2 = z1;
            arrayList3.add(new Keyframe(lottieComposition0, 0.0f, 0.0f, null, 0.0f, f));
        }
        else {
            z2 = z1;
        }
        if(f1 <= 0.0f) {
            f1 = lottieComposition0.getEndFrame();
        }
        arrayList3.add(new Keyframe(lottieComposition0, 1.0f, 1.0f, null, f, f1));
        arrayList3.add(new Keyframe(lottieComposition0, 0.0f, 0.0f, null, f1, 3.402823E+38f));
        if(s1.endsWith(".ai") || "ai".equals(s2)) {
            lottieComposition0.addWarning("Convert your Illustrator layers to shape layers.");
        }
        if(z2) {
            if(animatableTransform0 == null) {
                animatableTransform0 = new AnimatableTransform();
            }
            animatableTransform0.setAutoOrient(true);
        }
        return new Layer(arrayList1, lottieComposition0, s1, v, layer$LayerType0, v4, s, arrayList0, animatableTransform0, v1, v2, v3, f5, f4, f2, f3, animatableTextFrame0, animatableTextProperties0, arrayList3, layer$MatteType0, animatableFloatValue0, z, blurEffect0, dropShadowEffect0, lBlendMode0);
    }
}

