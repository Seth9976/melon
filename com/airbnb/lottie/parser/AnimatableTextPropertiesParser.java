package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTextRangeSelector;
import com.airbnb.lottie.model.animatable.AnimatableTextStyle;
import com.airbnb.lottie.model.content.TextRangeUnits;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;

public class AnimatableTextPropertiesParser {
    private static final Options ANIMATABLE_PROPERTIES_NAMES;
    private static final Options ANIMATABLE_RANGE_PROPERTIES_NAMES;
    private static final Options PROPERTIES_NAMES;

    static {
        AnimatableTextPropertiesParser.PROPERTIES_NAMES = Options.of(new String[]{"s", "a"});
        AnimatableTextPropertiesParser.ANIMATABLE_RANGE_PROPERTIES_NAMES = Options.of(new String[]{"s", "e", "o", "r"});
        AnimatableTextPropertiesParser.ANIMATABLE_PROPERTIES_NAMES = Options.of(new String[]{"fc", "sc", "sw", "t", "o"});
    }

    public static AnimatableTextProperties parse(JsonReader jsonReader0, LottieComposition lottieComposition0) {
        jsonReader0.beginObject();
        AnimatableTextStyle animatableTextStyle0 = null;
        AnimatableTextRangeSelector animatableTextRangeSelector0 = null;
        while(jsonReader0.hasNext()) {
            switch(jsonReader0.selectName(AnimatableTextPropertiesParser.PROPERTIES_NAMES)) {
                case 0: {
                    animatableTextRangeSelector0 = AnimatableTextPropertiesParser.parseAnimatableTextRangeSelector(jsonReader0, lottieComposition0);
                    break;
                }
                case 1: {
                    animatableTextStyle0 = AnimatableTextPropertiesParser.parseAnimatableTextStyle(jsonReader0, lottieComposition0);
                    break;
                }
                default: {
                    jsonReader0.skipName();
                    jsonReader0.skipValue();
                }
            }
        }
        jsonReader0.endObject();
        return new AnimatableTextProperties(animatableTextStyle0, animatableTextRangeSelector0);
    }

    private static AnimatableTextRangeSelector parseAnimatableTextRangeSelector(JsonReader jsonReader0, LottieComposition lottieComposition0) {
        jsonReader0.beginObject();
        AnimatableIntegerValue animatableIntegerValue0 = null;
        AnimatableIntegerValue animatableIntegerValue1 = null;
        AnimatableIntegerValue animatableIntegerValue2 = null;
        TextRangeUnits textRangeUnits0 = null;
        while(jsonReader0.hasNext()) {
            switch(jsonReader0.selectName(AnimatableTextPropertiesParser.ANIMATABLE_RANGE_PROPERTIES_NAMES)) {
                case 0: {
                    animatableIntegerValue0 = AnimatableValueParser.parseInteger(jsonReader0, lottieComposition0);
                    break;
                }
                case 1: {
                    animatableIntegerValue1 = AnimatableValueParser.parseInteger(jsonReader0, lottieComposition0);
                    break;
                }
                case 2: {
                    animatableIntegerValue2 = AnimatableValueParser.parseInteger(jsonReader0, lottieComposition0);
                    break;
                }
                case 3: {
                    int v = jsonReader0.nextInt();
                    if(v != 1 && v != 2) {
                        lottieComposition0.addWarning("Unsupported text range units: " + v);
                        textRangeUnits0 = TextRangeUnits.INDEX;
                    }
                    else if(v == 1) {
                        textRangeUnits0 = TextRangeUnits.PERCENT;
                    }
                    else {
                        goto label_25;
                    }
                    break;
                }
                default: {
                    jsonReader0.skipName();
                    jsonReader0.skipValue();
                }
            }
            continue;
        label_25:
            textRangeUnits0 = TextRangeUnits.INDEX;
        }
        jsonReader0.endObject();
        if(animatableIntegerValue0 == null && animatableIntegerValue1 != null) {
            animatableIntegerValue0 = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(0)));
        }
        return new AnimatableTextRangeSelector(animatableIntegerValue0, animatableIntegerValue1, animatableIntegerValue2, textRangeUnits0);
    }

    private static AnimatableTextStyle parseAnimatableTextStyle(JsonReader jsonReader0, LottieComposition lottieComposition0) {
        jsonReader0.beginObject();
        AnimatableColorValue animatableColorValue0 = null;
        AnimatableColorValue animatableColorValue1 = null;
        AnimatableFloatValue animatableFloatValue0 = null;
        AnimatableFloatValue animatableFloatValue1 = null;
        AnimatableIntegerValue animatableIntegerValue0 = null;
        while(jsonReader0.hasNext()) {
            switch(jsonReader0.selectName(AnimatableTextPropertiesParser.ANIMATABLE_PROPERTIES_NAMES)) {
                case 0: {
                    animatableColorValue0 = AnimatableValueParser.parseColor(jsonReader0, lottieComposition0);
                    break;
                }
                case 1: {
                    animatableColorValue1 = AnimatableValueParser.parseColor(jsonReader0, lottieComposition0);
                    break;
                }
                case 2: {
                    animatableFloatValue0 = AnimatableValueParser.parseFloat(jsonReader0, lottieComposition0);
                    break;
                }
                case 3: {
                    animatableFloatValue1 = AnimatableValueParser.parseFloat(jsonReader0, lottieComposition0);
                    break;
                }
                case 4: {
                    animatableIntegerValue0 = AnimatableValueParser.parseInteger(jsonReader0, lottieComposition0);
                    break;
                }
                default: {
                    jsonReader0.skipName();
                    jsonReader0.skipValue();
                }
            }
        }
        jsonReader0.endObject();
        return new AnimatableTextStyle(animatableColorValue0, animatableColorValue1, animatableFloatValue0, animatableFloatValue1, animatableIntegerValue0);
    }
}

