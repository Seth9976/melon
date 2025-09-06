package com.airbnb.lottie.parser;

import android.graphics.Path.FillType;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;

class ShapeFillParser {
    private static final Options NAMES;

    static {
        ShapeFillParser.NAMES = Options.of(new String[]{"nm", "c", "o", "fillEnabled", "r", "hd"});
    }

    public static ShapeFill parse(JsonReader jsonReader0, LottieComposition lottieComposition0) {
        AnimatableIntegerValue animatableIntegerValue0 = null;
        String s = null;
        AnimatableColorValue animatableColorValue0 = null;
        boolean z = false;
        boolean z1 = false;
        int v = 1;
        while(jsonReader0.hasNext()) {
            switch(jsonReader0.selectName(ShapeFillParser.NAMES)) {
                case 0: {
                    s = jsonReader0.nextString();
                    break;
                }
                case 1: {
                    animatableColorValue0 = AnimatableValueParser.parseColor(jsonReader0, lottieComposition0);
                    break;
                }
                case 2: {
                    animatableIntegerValue0 = AnimatableValueParser.parseInteger(jsonReader0, lottieComposition0);
                    break;
                }
                case 3: {
                    z = jsonReader0.nextBoolean();
                    break;
                }
                case 4: {
                    v = jsonReader0.nextInt();
                    break;
                }
                case 5: {
                    z1 = jsonReader0.nextBoolean();
                    break;
                }
                default: {
                    jsonReader0.skipName();
                    jsonReader0.skipValue();
                }
            }
        }
        if(animatableIntegerValue0 == null) {
            animatableIntegerValue0 = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100)));
        }
        return v == 1 ? new ShapeFill(s, z, Path.FillType.WINDING, animatableColorValue0, animatableIntegerValue0, z1) : new ShapeFill(s, z, Path.FillType.EVEN_ODD, animatableColorValue0, animatableIntegerValue0, z1);
    }
}

