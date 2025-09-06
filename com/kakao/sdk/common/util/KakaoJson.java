package com.kakao.sdk.common.util;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\b\u001A\u0002H\t\"\u0006\b\u0000\u0010\t\u0018\u00012\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000BH\u0086\b¢\u0006\u0002\u0010\rJ\u001E\u0010\u000E\u001A\u0002H\t\"\u0006\b\u0000\u0010\t\u0018\u00012\u0006\u0010\u000F\u001A\u00020\fH\u0086\b¢\u0006\u0002\u0010\u0010J\u001E\u0010\u0011\u001A\u00020\u0012\"\u0006\b\u0000\u0010\t\u0018\u00012\u0006\u0010\u0013\u001A\u0002H\tH\u0086\b¢\u0006\u0002\u0010\u0014J%\u0010\u0015\u001A\u00020\u0016\"\u0006\b\u0000\u0010\t\u0018\u00012\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\t0\u000BH\u0086\bJ\u001E\u0010\u0017\u001A\u00020\f\"\u0006\b\u0000\u0010\t\u0018\u00012\u0006\u0010\u0018\u001A\u0002H\tH\u0086\b¢\u0006\u0002\u0010\u0019R\u0017\u0010\u0003\u001A\u00020\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u001A"}, d2 = {"Lcom/kakao/sdk/common/util/KakaoJson;", "", "()V", "json", "Lkotlinx/serialization/json/Json;", "getJson$annotations", "getJson", "()Lkotlinx/serialization/json/Json;", "decodeFromMap", "T", "map", "", "", "(Ljava/util/Map;)Ljava/lang/Object;", "decodeFromString", "string", "(Ljava/lang/String;)Ljava/lang/Object;", "encodeToJsonElement", "Lkotlinx/serialization/json/JsonElement;", "value", "(Ljava/lang/Object;)Lkotlinx/serialization/json/JsonElement;", "encodeToJsonObject", "Lkotlinx/serialization/json/JsonObject;", "encodeToString", "model", "(Ljava/lang/Object;)Ljava/lang/String;", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class KakaoJson {
    @NotNull
    public static final KakaoJson INSTANCE;
    @NotNull
    private static final Json json;

    static {
        KakaoJson.INSTANCE = new KakaoJson();
        KakaoJson.json = JsonKt.Json$default(null, KakaoJson.json.1.INSTANCE, 1, null);
    }

    public final Object decodeFromMap(Map map0) {
        q.g(map0, "map");
        JsonObjectBuilder jsonObjectBuilder0 = new JsonObjectBuilder();
        for(Object object0: map0.entrySet()) {
            String s = (String)((Map.Entry)object0).getKey();
            Object object1 = ((Map.Entry)object0).getValue();
            Json json0 = KakaoJson.INSTANCE.getJson();
            json0.getSerializersModule();
            jsonObjectBuilder0.put(s, json0.encodeToJsonElement(StringSerializer.INSTANCE, object1));
        }
        jsonObjectBuilder0.build().toString();
        this.getJson().getSerializersModule();
        q.k();
        throw null;
    }

    public final Object decodeFromString(String s) {
        q.g(s, "string");
        this.getJson().getSerializersModule();
        q.k();
        throw null;
    }

    public final JsonElement encodeToJsonElement(Object object0) {
        this.getJson().getSerializersModule();
        q.k();
        throw null;
    }

    public final JsonObject encodeToJsonObject(Map map0) {
        q.g(map0, "map");
        JsonObjectBuilder jsonObjectBuilder0 = new JsonObjectBuilder();
        Iterator iterator0 = map0.entrySet().iterator();
        if(!iterator0.hasNext()) {
            return jsonObjectBuilder0.build();
        }
        Object object0 = iterator0.next();
        String s = (String)((Map.Entry)object0).getKey();
        ((Map.Entry)object0).getValue();
        KakaoJson.INSTANCE.getJson().getSerializersModule();
        q.k();
        throw null;
    }

    public final String encodeToString(Object object0) {
        this.getJson().getSerializersModule();
        q.k();
        throw null;
    }

    @NotNull
    public final Json getJson() {
        return KakaoJson.json;
    }

    public static void getJson$annotations() {
    }
}

