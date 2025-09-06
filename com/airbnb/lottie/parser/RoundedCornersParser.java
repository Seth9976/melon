package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.RoundedCorners;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.airbnb.lottie.parser.moshi.JsonReader;

public class RoundedCornersParser {
    private static final Options NAMES;

    static {
        RoundedCornersParser.NAMES = Options.of(new String[]{"nm", "r", "hd"});
    }

    public static RoundedCorners parse(JsonReader jsonReader0, LottieComposition lottieComposition0) {
        boolean z = false;
        String s = null;
        AnimatableValue animatableValue0 = null;
        while(jsonReader0.hasNext()) {
            switch(jsonReader0.selectName(RoundedCornersParser.NAMES)) {
                case 0: {
                    s = jsonReader0.nextString();
                    break;
                }
                case 1: {
                    animatableValue0 = AnimatableValueParser.parseFloat(jsonReader0, lottieComposition0, true);
                    break;
                }
                case 2: {
                    z = jsonReader0.nextBoolean();
                    break;
                }
                default: {
                    jsonReader0.skipValue();
                }
            }
        }
        return z ? null : new RoundedCorners(s, animatableValue0);
    }
}

