package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import androidx.collection.W;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.airbnb.lottie.parser.moshi.JsonReader.Token;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.lang.ref.WeakReference;

class KeyframeParser {
    static Options INTERPOLATOR_NAMES = null;
    private static final Interpolator LINEAR_INTERPOLATOR = null;
    private static final float MAX_CP_VALUE = 100.0f;
    static Options NAMES;
    private static W pathInterpolatorCache;

    static {
        KeyframeParser.LINEAR_INTERPOLATOR = new LinearInterpolator();
        KeyframeParser.NAMES = Options.of(new String[]{"t", "s", "e", "o", "i", "h", "to", "ti"});
        KeyframeParser.INTERPOLATOR_NAMES = Options.of(new String[]{"x", "y"});
    }

    private static WeakReference getInterpolator(int v) {
        synchronized(KeyframeParser.class) {
        }
        return (WeakReference)KeyframeParser.pathInterpolatorCache().c(v);
    }

    private static Interpolator interpolatorFor(PointF pointF0, PointF pointF1) {
        try {
            pointF0.x = MiscUtils.clamp(pointF0.x, -1.0f, 1.0f);
            pointF0.y = MiscUtils.clamp(pointF0.y, -100.0f, 100.0f);
            pointF1.x = MiscUtils.clamp(pointF1.x, -1.0f, 1.0f);
            pointF1.y = MiscUtils.clamp(pointF1.y, -100.0f, 100.0f);
            return new PathInterpolator(pointF0.x, pointF0.y, pointF1.x, pointF1.y);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            return "The Path cannot loop back on itself.".equals(illegalArgumentException0.getMessage()) ? new PathInterpolator(Math.min(pointF0.x, 1.0f), pointF0.y, Math.max(pointF1.x, 0.0f), pointF1.y) : new LinearInterpolator();
        }
    }

    public static Keyframe parse(JsonReader jsonReader0, LottieComposition lottieComposition0, float f, ValueParser valueParser0, boolean z, boolean z1) {
        if(z && z1) {
            return KeyframeParser.parseMultiDimensionalKeyframe(lottieComposition0, jsonReader0, f, valueParser0);
        }
        return z ? KeyframeParser.parseKeyframe(lottieComposition0, jsonReader0, f, valueParser0) : KeyframeParser.parseStaticValue(jsonReader0, f, valueParser0);
    }

    private static Keyframe parseKeyframe(LottieComposition lottieComposition0, JsonReader jsonReader0, float f, ValueParser valueParser0) {
        Object object2;
        Interpolator interpolator0;
        jsonReader0.beginObject();
        PointF pointF0 = null;
        Object object0 = null;
        Object object1 = null;
        PointF pointF1 = null;
        PointF pointF2 = null;
        float f1 = 0.0f;
        boolean z = false;
        PointF pointF3 = null;
        while(jsonReader0.hasNext()) {
            switch(jsonReader0.selectName(KeyframeParser.NAMES)) {
                case 0: {
                    f1 = (float)jsonReader0.nextDouble();
                    break;
                }
                case 1: {
                    object1 = valueParser0.parse(jsonReader0, f);
                    break;
                }
                case 2: {
                    object0 = valueParser0.parse(jsonReader0, f);
                    break;
                }
                case 3: {
                    pointF0 = JsonUtils.jsonToPoint(jsonReader0, 1.0f);
                    break;
                }
                case 4: {
                    pointF3 = JsonUtils.jsonToPoint(jsonReader0, 1.0f);
                    break;
                }
                case 5: {
                    if(jsonReader0.nextInt() == 1) {
                        z = true;
                        continue;
                    }
                    else {
                        z = false;
                        break;
                    }
                    pointF1 = JsonUtils.jsonToPoint(jsonReader0, f);
                    break;
                }
                case 6: {
                    pointF1 = JsonUtils.jsonToPoint(jsonReader0, f);
                    break;
                }
                case 7: {
                    pointF2 = JsonUtils.jsonToPoint(jsonReader0, f);
                    break;
                }
                default: {
                    jsonReader0.skipValue();
                }
            }
        }
        jsonReader0.endObject();
        if(z) {
            interpolator0 = KeyframeParser.LINEAR_INTERPOLATOR;
            object2 = object1;
        }
        else {
            interpolator0 = pointF0 == null || pointF3 == null ? KeyframeParser.LINEAR_INTERPOLATOR : KeyframeParser.interpolatorFor(pointF0, pointF3);
            object2 = object0;
        }
        Keyframe keyframe0 = new Keyframe(lottieComposition0, object1, object2, interpolator0, f1, null);
        keyframe0.pathCp1 = pointF1;
        keyframe0.pathCp2 = pointF2;
        return keyframe0;
    }

    private static Keyframe parseMultiDimensionalKeyframe(LottieComposition lottieComposition0, JsonReader jsonReader0, float f, ValueParser valueParser0) {
        Keyframe keyframe0;
        PointF pointF12;
        PointF pointF11;
        Interpolator interpolator2;
        Interpolator interpolator1;
        Object object2;
        Interpolator interpolator0;
        int v2;
        float f12;
        PointF pointF8;
        jsonReader0.beginObject();
        int v = 0;
        PointF pointF0 = null;
        PointF pointF1 = null;
        PointF pointF2 = null;
        Object object0 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        PointF pointF5 = null;
        PointF pointF6 = null;
        PointF pointF7 = null;
        float f1 = 0.0f;
        Object object1 = null;
        while(jsonReader0.hasNext()) {
            switch(jsonReader0.selectName(KeyframeParser.NAMES)) {
                case 0: {
                    f1 = (float)jsonReader0.nextDouble();
                    break;
                }
                case 1: {
                    object0 = valueParser0.parse(jsonReader0, f);
                    break;
                }
                case 2: {
                    object1 = valueParser0.parse(jsonReader0, f);
                    break;
                }
                case 3: {
                    if(jsonReader0.peek() == Token.BEGIN_OBJECT) {
                        jsonReader0.beginObject();
                        float f2 = 0.0f;
                        float f3 = 0.0f;
                        float f4 = 0.0f;
                        float f5 = 0.0f;
                        while(jsonReader0.hasNext()) {
                            switch(jsonReader0.selectName(KeyframeParser.INTERPOLATOR_NAMES)) {
                                case 0: {
                                    pointF8 = pointF4;
                                    Token jsonReader$Token0 = jsonReader0.peek();
                                    Token jsonReader$Token1 = Token.NUMBER;
                                    if(jsonReader$Token0 == jsonReader$Token1) {
                                        f4 = (float)jsonReader0.nextDouble();
                                        f2 = f4;
                                        goto label_59;
                                    }
                                    else {
                                        jsonReader0.beginArray();
                                        f2 = (float)jsonReader0.nextDouble();
                                        f4 = jsonReader0.peek() == jsonReader$Token1 ? ((float)jsonReader0.nextDouble()) : f2;
                                        break;
                                    }
                                    goto label_47;
                                }
                                case 1: {
                                label_47:
                                    Token jsonReader$Token2 = jsonReader0.peek();
                                    Token jsonReader$Token3 = Token.NUMBER;
                                    if(jsonReader$Token2 == jsonReader$Token3) {
                                        pointF8 = pointF4;
                                        f5 = (float)jsonReader0.nextDouble();
                                        f3 = f5;
                                        goto label_59;
                                    }
                                    else {
                                        pointF8 = pointF4;
                                        jsonReader0.beginArray();
                                        f3 = (float)jsonReader0.nextDouble();
                                        f5 = jsonReader0.peek() == jsonReader$Token3 ? ((float)jsonReader0.nextDouble()) : f3;
                                    }
                                    break;
                                }
                                default: {
                                    jsonReader0.skipValue();
                                    continue;
                                }
                            }
                            jsonReader0.endArray();
                        label_59:
                            pointF4 = pointF8;
                        }
                        pointF2 = new PointF(f2, f3);
                        pointF3 = new PointF(f4, f5);
                        jsonReader0.endObject();
                        continue;
                    }
                    else {
                        pointF0 = JsonUtils.jsonToPoint(jsonReader0, f);
                        break;
                    }
                    goto label_67;
                }
                case 4: {
                label_67:
                    if(jsonReader0.peek() == Token.BEGIN_OBJECT) {
                        jsonReader0.beginObject();
                        float f6 = 0.0f;
                        float f7 = 0.0f;
                        float f8 = 0.0f;
                        float f9 = 0.0f;
                        while(jsonReader0.hasNext()) {
                            int v1 = jsonReader0.selectName(KeyframeParser.INTERPOLATOR_NAMES);
                            if(v1 == 0) {
                                v2 = v;
                                Token jsonReader$Token6 = jsonReader0.peek();
                                Token jsonReader$Token7 = Token.NUMBER;
                                if(jsonReader$Token6 == jsonReader$Token7) {
                                    f8 = (float)jsonReader0.nextDouble();
                                    f6 = f8;
                                }
                                else {
                                    jsonReader0.beginArray();
                                    float f11 = (float)jsonReader0.nextDouble();
                                    if(jsonReader0.peek() == jsonReader$Token7) {
                                        f12 = f11;
                                        f8 = (float)jsonReader0.nextDouble();
                                    }
                                    else {
                                        f12 = f11;
                                        f8 = f12;
                                    }
                                    jsonReader0.endArray();
                                    f6 = f12;
                                }
                            }
                            else {
                                v2 = v;
                                if(v1 == 1) {
                                    Token jsonReader$Token4 = jsonReader0.peek();
                                    Token jsonReader$Token5 = Token.NUMBER;
                                    if(jsonReader$Token4 == jsonReader$Token5) {
                                        f9 = (float)jsonReader0.nextDouble();
                                        f7 = f9;
                                    }
                                    else {
                                        jsonReader0.beginArray();
                                        float f10 = (float)jsonReader0.nextDouble();
                                        f9 = jsonReader0.peek() == jsonReader$Token5 ? ((float)jsonReader0.nextDouble()) : f10;
                                        jsonReader0.endArray();
                                        f7 = f10;
                                    }
                                }
                                else {
                                    jsonReader0.skipValue();
                                }
                            }
                            v = v2;
                        }
                        PointF pointF9 = new PointF(f6, f7);
                        PointF pointF10 = new PointF(f8, f9);
                        jsonReader0.endObject();
                        pointF5 = pointF10;
                        pointF4 = pointF9;
                        continue;
                    }
                    else {
                        pointF1 = JsonUtils.jsonToPoint(jsonReader0, f);
                        break;
                    }
                    goto label_119;
                }
                case 5: {
                label_119:
                    if(jsonReader0.nextInt() == 1) {
                        v = 1;
                        continue;
                    }
                    else {
                        v = 0;
                        break;
                    }
                    pointF6 = JsonUtils.jsonToPoint(jsonReader0, f);
                    break;
                }
                case 6: {
                    pointF6 = JsonUtils.jsonToPoint(jsonReader0, f);
                    break;
                }
                case 7: {
                    pointF7 = JsonUtils.jsonToPoint(jsonReader0, f);
                    break;
                }
                default: {
                    jsonReader0.skipValue();
                }
            }
        }
        jsonReader0.endObject();
        if(v != 0) {
            interpolator0 = KeyframeParser.LINEAR_INTERPOLATOR;
            object2 = object0;
            interpolator1 = null;
            interpolator2 = null;
        }
        else if(pointF0 != null && pointF1 != null) {
            interpolator0 = KeyframeParser.interpolatorFor(pointF0, pointF1);
            object2 = object1;
            interpolator1 = null;
            interpolator2 = null;
        }
        else if(pointF2 == null || pointF3 == null || pointF4 == null || pointF5 == null) {
            interpolator0 = KeyframeParser.LINEAR_INTERPOLATOR;
            object2 = object1;
            interpolator1 = null;
            interpolator2 = null;
        }
        else {
            interpolator1 = KeyframeParser.interpolatorFor(pointF2, pointF4);
            interpolator2 = KeyframeParser.interpolatorFor(pointF3, pointF5);
            object2 = object1;
            interpolator0 = null;
        }
        if(interpolator1 == null || interpolator2 == null) {
            pointF12 = pointF6;
            pointF11 = pointF7;
            keyframe0 = new Keyframe(lottieComposition0, object0, object2, interpolator0, f1, null);
        }
        else {
            pointF11 = pointF7;
            pointF12 = pointF6;
            keyframe0 = new Keyframe(lottieComposition0, object0, object2, interpolator1, interpolator2, f1, null);
        }
        keyframe0.pathCp1 = pointF12;
        keyframe0.pathCp2 = pointF11;
        return keyframe0;
    }

    private static Keyframe parseStaticValue(JsonReader jsonReader0, float f, ValueParser valueParser0) {
        return new Keyframe(valueParser0.parse(jsonReader0, f));
    }

    private static W pathInterpolatorCache() {
        if(KeyframeParser.pathInterpolatorCache == null) {
            KeyframeParser.pathInterpolatorCache = new W(0);
        }
        return KeyframeParser.pathInterpolatorCache;
    }

    private static void putInterpolator(int v, WeakReference weakReference0) {
        synchronized(KeyframeParser.class) {
            KeyframeParser.pathInterpolatorCache.d(v, weakReference0);
        }
    }
}

