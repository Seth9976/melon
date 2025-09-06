package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A%\u0010\u0006\u001A\u0004\u0018\u00010\u0005*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001A%\u0010\u0006\u001A\u0004\u0018\u00010\u0005*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/serialization/json/JsonObjectBuilder;", "", "key", "", "value", "Lkotlinx/serialization/json/JsonElement;", "put", "(Lkotlinx/serialization/json/JsonObjectBuilder;Ljava/lang/String;Ljava/lang/Number;)Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/json/JsonObjectBuilder;Ljava/lang/String;Ljava/lang/String;)Lkotlinx/serialization/json/JsonElement;", "kotlinx-serialization-json"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class JsonElementBuildersKt {
    @Nullable
    public static final JsonElement put(@NotNull JsonObjectBuilder jsonObjectBuilder0, @NotNull String s, @Nullable Number number0) {
        q.g(jsonObjectBuilder0, "<this>");
        q.g(s, "key");
        return jsonObjectBuilder0.put(s, JsonElementKt.JsonPrimitive(number0));
    }

    @Nullable
    public static final JsonElement put(@NotNull JsonObjectBuilder jsonObjectBuilder0, @NotNull String s, @Nullable String s1) {
        q.g(jsonObjectBuilder0, "<this>");
        q.g(s, "key");
        return jsonObjectBuilder0.put(s, JsonElementKt.JsonPrimitive(s1));
    }
}

