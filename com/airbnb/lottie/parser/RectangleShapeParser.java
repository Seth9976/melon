package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.airbnb.lottie.parser.moshi.JsonReader;

class RectangleShapeParser {
    private static final Options NAMES;

    static {
        RectangleShapeParser.NAMES = Options.of(new String[]{"nm", "p", "s", "r", "hd"});
    }

    public static RectangleShape parse(JsonReader jsonReader0, LottieComposition lottieComposition0) {
        String s = null;
        AnimatableValue animatableValue0 = null;
        AnimatableValue animatableValue1 = null;
        AnimatableFloatValue animatableFloatValue0 = null;
        boolean z = false;
        while(jsonReader0.hasNext()) {
            switch(jsonReader0.selectName(RectangleShapeParser.NAMES)) {
                case 0: {
                    s = jsonReader0.nextString();
                    break;
                }
                case 1: {
                    animatableValue0 = AnimatablePathValueParser.parseSplitPath(jsonReader0, lottieComposition0);
                    break;
                }
                case 2: {
                    animatableValue1 = AnimatableValueParser.parsePoint(jsonReader0, lottieComposition0);
                    break;
                }
                case 3: {
                    animatableFloatValue0 = AnimatableValueParser.parseFloat(jsonReader0, lottieComposition0);
                    break;
                }
                case 4: {
                    z = jsonReader0.nextBoolean();
                    break;
                }
                default: {
                    jsonReader0.skipValue();
                }
            }
        }
        return new RectangleShape(s, animatableValue0, animatableValue1, animatableFloatValue0, z);
    }
}

