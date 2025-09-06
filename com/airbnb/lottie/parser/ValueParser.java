package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;

interface ValueParser {
    Object parse(JsonReader arg1, float arg2);
}

