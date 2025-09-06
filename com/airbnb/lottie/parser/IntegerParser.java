package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;

public class IntegerParser implements ValueParser {
    public static final IntegerParser INSTANCE;

    static {
        IntegerParser.INSTANCE = new IntegerParser();
    }

    public Integer parse(JsonReader jsonReader0, float f) {
        return Math.round(JsonUtils.valueFromObject(jsonReader0) * f);
    }

    @Override  // com.airbnb.lottie.parser.ValueParser
    public Object parse(JsonReader jsonReader0, float f) {
        return this.parse(jsonReader0, f);
    }
}

