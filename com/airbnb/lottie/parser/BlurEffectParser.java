package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.airbnb.lottie.parser.moshi.JsonReader;

class BlurEffectParser {
    private static final Options BLUR_EFFECT_NAMES;
    private static final Options INNER_BLUR_EFFECT_NAMES;

    static {
        BlurEffectParser.BLUR_EFFECT_NAMES = Options.of(new String[]{"ef"});
        BlurEffectParser.INNER_BLUR_EFFECT_NAMES = Options.of(new String[]{"ty", "v"});
    }

    private static BlurEffect maybeParseInnerEffect(JsonReader jsonReader0, LottieComposition lottieComposition0) {
        boolean z;
        jsonReader0.beginObject();
        BlurEffect blurEffect0 = null;
    alab1:
        while(true) {
            z = false;
        label_3:
            if(!jsonReader0.hasNext()) {
                jsonReader0.endObject();
                return blurEffect0;
            }
            switch(jsonReader0.selectName(BlurEffectParser.INNER_BLUR_EFFECT_NAMES)) {
                case 0: {
                    if(jsonReader0.nextInt() != 0) {
                        break;
                    }
                    break alab1;
                }
                case 1: {
                    goto label_11;
                }
                default: {
                    jsonReader0.skipName();
                    jsonReader0.skipValue();
                    goto label_3;
                }
            }
        }
        z = true;
        goto label_3;
    label_11:
        if(z) {
            blurEffect0 = new BlurEffect(AnimatableValueParser.parseFloat(jsonReader0, lottieComposition0));
        }
        else {
            jsonReader0.skipValue();
        }
        goto label_3;
    }

    public static BlurEffect parse(JsonReader jsonReader0, LottieComposition lottieComposition0) {
        BlurEffect blurEffect0 = null;
        while(jsonReader0.hasNext()) {
            if(jsonReader0.selectName(BlurEffectParser.BLUR_EFFECT_NAMES) == 0) {
                jsonReader0.beginArray();
                while(jsonReader0.hasNext()) {
                    BlurEffect blurEffect1 = BlurEffectParser.maybeParseInnerEffect(jsonReader0, lottieComposition0);
                    if(blurEffect1 != null) {
                        blurEffect0 = blurEffect1;
                    }
                }
                jsonReader0.endArray();
            }
            else {
                jsonReader0.skipName();
                jsonReader0.skipValue();
            }
        }
        return blurEffect0;
    }
}

