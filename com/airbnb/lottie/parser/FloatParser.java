package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;

public class FloatParser implements ValueParser {
    public static final FloatParser INSTANCE;

    static {
        FloatParser.INSTANCE = new FloatParser();
    }

    public Float parse(JsonReader jsonReader0, float f) {
        return (float)(JsonUtils.valueFromObject(jsonReader0) * f);
    }

    @Override  // com.airbnb.lottie.parser.ValueParser
    public Object parse(JsonReader jsonReader0, float f) {
        return this.parse(jsonReader0, f);
    }
}

