package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.airbnb.lottie.parser.moshi.JsonReader;

class ShapePathParser {
    static Options NAMES;

    static {
        ShapePathParser.NAMES = Options.of(new String[]{"nm", "ind", "ks", "hd"});
    }

    public static ShapePath parse(JsonReader jsonReader0, LottieComposition lottieComposition0) {
        String s = null;
        int v = 0;
        boolean z = false;
        AnimatableShapeValue animatableShapeValue0 = null;
        while(jsonReader0.hasNext()) {
            switch(jsonReader0.selectName(ShapePathParser.NAMES)) {
                case 0: {
                    s = jsonReader0.nextString();
                    break;
                }
                case 1: {
                    v = jsonReader0.nextInt();
                    break;
                }
                case 2: {
                    animatableShapeValue0 = AnimatableValueParser.parseShapeData(jsonReader0, lottieComposition0);
                    break;
                }
                case 3: {
                    z = jsonReader0.nextBoolean();
                    break;
                }
                default: {
                    jsonReader0.skipValue();
                }
            }
        }
        return new ShapePath(s, v, animatableShapeValue0, z);
    }
}

