package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import java.util.List;

public class AnimatableValueParser {
    private static List parse(JsonReader jsonReader0, float f, LottieComposition lottieComposition0, ValueParser valueParser0) {
        return KeyframesParser.parse(jsonReader0, lottieComposition0, f, valueParser0, false);
    }

    private static List parse(JsonReader jsonReader0, LottieComposition lottieComposition0, ValueParser valueParser0) {
        return KeyframesParser.parse(jsonReader0, lottieComposition0, 1.0f, valueParser0, false);
    }

    public static AnimatableColorValue parseColor(JsonReader jsonReader0, LottieComposition lottieComposition0) {
        return new AnimatableColorValue(AnimatableValueParser.parse(jsonReader0, lottieComposition0, ColorParser.INSTANCE));
    }

    public static AnimatableTextFrame parseDocumentData(JsonReader jsonReader0, LottieComposition lottieComposition0) {
        return new AnimatableTextFrame(AnimatableValueParser.parse(jsonReader0, Utils.dpScale(), lottieComposition0, DocumentDataParser.INSTANCE));
    }

    public static AnimatableFloatValue parseFloat(JsonReader jsonReader0, LottieComposition lottieComposition0) {
        return AnimatableValueParser.parseFloat(jsonReader0, lottieComposition0, true);
    }

    // 去混淆评级： 低(20)
    public static AnimatableFloatValue parseFloat(JsonReader jsonReader0, LottieComposition lottieComposition0, boolean z) {
        return z ? new AnimatableFloatValue(AnimatableValueParser.parse(jsonReader0, Utils.dpScale(), lottieComposition0, FloatParser.INSTANCE)) : new AnimatableFloatValue(AnimatableValueParser.parse(jsonReader0, 1.0f, lottieComposition0, FloatParser.INSTANCE));
    }

    public static AnimatableGradientColorValue parseGradientColor(JsonReader jsonReader0, LottieComposition lottieComposition0, int v) {
        return new AnimatableGradientColorValue(AnimatableValueParser.parse(jsonReader0, lottieComposition0, new GradientColorParser(v)));
    }

    public static AnimatableIntegerValue parseInteger(JsonReader jsonReader0, LottieComposition lottieComposition0) {
        return new AnimatableIntegerValue(AnimatableValueParser.parse(jsonReader0, lottieComposition0, IntegerParser.INSTANCE));
    }

    public static AnimatablePointValue parsePoint(JsonReader jsonReader0, LottieComposition lottieComposition0) {
        return new AnimatablePointValue(KeyframesParser.parse(jsonReader0, lottieComposition0, Utils.dpScale(), PointFParser.INSTANCE, true));
    }

    public static AnimatableScaleValue parseScale(JsonReader jsonReader0, LottieComposition lottieComposition0) {
        return new AnimatableScaleValue(AnimatableValueParser.parse(jsonReader0, lottieComposition0, ScaleXYParser.INSTANCE));
    }

    public static AnimatableShapeValue parseShapeData(JsonReader jsonReader0, LottieComposition lottieComposition0) {
        return new AnimatableShapeValue(AnimatableValueParser.parse(jsonReader0, Utils.dpScale(), lottieComposition0, ShapeDataParser.INSTANCE));
    }
}

