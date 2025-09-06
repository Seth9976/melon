package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;

public class PathParser implements ValueParser {
    public static final PathParser INSTANCE;

    static {
        PathParser.INSTANCE = new PathParser();
    }

    public PointF parse(JsonReader jsonReader0, float f) {
        return JsonUtils.jsonToPoint(jsonReader0, f);
    }

    @Override  // com.airbnb.lottie.parser.ValueParser
    public Object parse(JsonReader jsonReader0, float f) {
        return this.parse(jsonReader0, f);
    }
}

