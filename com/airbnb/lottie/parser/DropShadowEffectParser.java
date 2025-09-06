package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.airbnb.lottie.parser.moshi.JsonReader;

public class DropShadowEffectParser {
    private static final Options DROP_SHADOW_EFFECT_NAMES;
    private static final Options INNER_EFFECT_NAMES;
    private AnimatableColorValue color;
    private AnimatableFloatValue direction;
    private AnimatableFloatValue distance;
    private AnimatableFloatValue opacity;
    private AnimatableFloatValue radius;

    static {
        DropShadowEffectParser.DROP_SHADOW_EFFECT_NAMES = Options.of(new String[]{"ef"});
        DropShadowEffectParser.INNER_EFFECT_NAMES = Options.of(new String[]{"nm", "v"});
    }

    private void maybeParseInnerEffect(JsonReader jsonReader0, LottieComposition lottieComposition0) {
        jsonReader0.beginObject();
        String s = "";
        while(jsonReader0.hasNext()) {
        alab1:
            switch(jsonReader0.selectName(DropShadowEffectParser.INNER_EFFECT_NAMES)) {
                case 0: {
                    s = jsonReader0.nextString();
                    continue;
                }
                case 1: {
                    s.getClass();
                    switch(s) {
                        case "Direction": {
                            this.direction = AnimatableValueParser.parseFloat(jsonReader0, lottieComposition0, false);
                            break alab1;
                        }
                        case "Distance": {
                            this.distance = AnimatableValueParser.parseFloat(jsonReader0, lottieComposition0);
                            break alab1;
                        }
                        case "Opacity": {
                            this.opacity = AnimatableValueParser.parseFloat(jsonReader0, lottieComposition0, false);
                            break alab1;
                        }
                        case "Shadow Color": {
                            this.color = AnimatableValueParser.parseColor(jsonReader0, lottieComposition0);
                            break alab1;
                        }
                        case "Softness": {
                            this.radius = AnimatableValueParser.parseFloat(jsonReader0, lottieComposition0);
                            break alab1;
                        }
                        default: {
                            jsonReader0.skipValue();
                            break alab1;
                        }
                    }
                }
                default: {
                    jsonReader0.skipName();
                    jsonReader0.skipValue();
                }
            }
        }
        jsonReader0.endObject();
    }

    public DropShadowEffect parse(JsonReader jsonReader0, LottieComposition lottieComposition0) {
        while(jsonReader0.hasNext()) {
            if(jsonReader0.selectName(DropShadowEffectParser.DROP_SHADOW_EFFECT_NAMES) == 0) {
                jsonReader0.beginArray();
                while(jsonReader0.hasNext()) {
                    this.maybeParseInnerEffect(jsonReader0, lottieComposition0);
                }
                jsonReader0.endArray();
            }
            else {
                jsonReader0.skipName();
                jsonReader0.skipValue();
            }
        }
        AnimatableColorValue animatableColorValue0 = this.color;
        if(animatableColorValue0 != null) {
            AnimatableFloatValue animatableFloatValue0 = this.opacity;
            if(animatableFloatValue0 != null) {
                AnimatableFloatValue animatableFloatValue1 = this.direction;
                if(animatableFloatValue1 != null) {
                    AnimatableFloatValue animatableFloatValue2 = this.distance;
                    if(animatableFloatValue2 != null) {
                        return this.radius == null ? null : new DropShadowEffect(animatableColorValue0, animatableFloatValue0, animatableFloatValue1, animatableFloatValue2, this.radius);
                    }
                }
            }
        }
        return null;
    }
}

