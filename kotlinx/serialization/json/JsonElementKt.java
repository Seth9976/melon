package kotlinx.serialization.json;

import i.n.i.b.a.s.e.M3;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.q;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.InlineClassDescriptorKt;
import kotlinx.serialization.json.internal.JsonDecodingException;
import kotlinx.serialization.json.internal.StringJsonLexer;
import kotlinx.serialization.json.internal.StringOpsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\u001A\u0017\u0010\u0003\u001A\u00020\u00022\b\u0010\u0001\u001A\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001A\u0017\u0010\u0003\u001A\u00020\u00022\b\u0010\u0001\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0003\u0010\u0006\u001A\u0017\u0010\u0003\u001A\u00020\u00022\b\u0010\u0001\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0003\u0010\b\u001A\u001B\u0010\f\u001A\u00020\u000B*\u00020\t2\u0006\u0010\n\u001A\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\r\"\u001A\u0010\u000F\u001A\u00020\u000E8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012\"\u0015\u0010\u0015\u001A\u00020\u0002*\u00020\t8F¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014\"\u0015\u0010\u0019\u001A\u00020\u0016*\u00020\t8F¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018\"\u0015\u0010\u001D\u001A\u00020\u001A*\u00020\u00028F¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001C\"\u0015\u0010!\u001A\u00020\u001E*\u00020\u00028F¢\u0006\u0006\u001A\u0004\b\u001F\u0010 \"\u0015\u0010%\u001A\u00020\"*\u00020\u00028F¢\u0006\u0006\u001A\u0004\b#\u0010$\"\u0015\u0010)\u001A\u00020&*\u00020\u00028F¢\u0006\u0006\u001A\u0004\b\'\u0010(\"\u0017\u0010,\u001A\u0004\u0018\u00010\u0000*\u00020\u00028F¢\u0006\u0006\u001A\u0004\b*\u0010+\"\u0017\u0010/\u001A\u0004\u0018\u00010\u0007*\u00020\u00028F¢\u0006\u0006\u001A\u0004\b-\u0010.¨\u00060"}, d2 = {"", "value", "Lkotlinx/serialization/json/JsonPrimitive;", "JsonPrimitive", "(Ljava/lang/Boolean;)Lkotlinx/serialization/json/JsonPrimitive;", "", "(Ljava/lang/Number;)Lkotlinx/serialization/json/JsonPrimitive;", "", "(Ljava/lang/String;)Lkotlinx/serialization/json/JsonPrimitive;", "Lkotlinx/serialization/json/JsonElement;", "element", "", "error", "(Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;)Ljava/lang/Void;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "jsonUnquotedLiteralDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getJsonUnquotedLiteralDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "getJsonPrimitive", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonPrimitive;", "jsonPrimitive", "Lkotlinx/serialization/json/JsonObject;", "getJsonObject", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonObject;", "jsonObject", "", "getInt", "(Lkotlinx/serialization/json/JsonPrimitive;)I", "int", "", "getLong", "(Lkotlinx/serialization/json/JsonPrimitive;)J", "long", "", "getDouble", "(Lkotlinx/serialization/json/JsonPrimitive;)D", "double", "", "getFloat", "(Lkotlinx/serialization/json/JsonPrimitive;)F", "float", "getBooleanOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Boolean;", "booleanOrNull", "getContentOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/String;", "contentOrNull", "kotlinx-serialization-json"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class JsonElementKt {
    @NotNull
    private static final SerialDescriptor jsonUnquotedLiteralDescriptor;

    static {
        JsonElementKt.jsonUnquotedLiteralDescriptor = InlineClassDescriptorKt.InlinePrimitiveDescriptor("kotlinx.serialization.json.JsonUnquotedLiteral", BuiltinSerializersKt.serializer(M.a));
    }

    @NotNull
    public static final JsonPrimitive JsonPrimitive(@Nullable Boolean boolean0) {
        return boolean0 == null ? JsonNull.INSTANCE : new JsonLiteral(boolean0, false, null, 4, null);
    }

    @NotNull
    public static final JsonPrimitive JsonPrimitive(@Nullable Number number0) {
        return number0 == null ? JsonNull.INSTANCE : new JsonLiteral(number0, false, null, 4, null);
    }

    @NotNull
    public static final JsonPrimitive JsonPrimitive(@Nullable String s) {
        return s == null ? JsonNull.INSTANCE : new JsonLiteral(s, true, null, 4, null);
    }

    private static final Void error(JsonElement jsonElement0, String s) {
        Class class0 = jsonElement0.getClass();
        throw new IllegalArgumentException("Element " + I.a.b(class0) + " is not a " + s);
    }

    @Nullable
    public static final Boolean getBooleanOrNull(@NotNull JsonPrimitive jsonPrimitive0) {
        q.g(jsonPrimitive0, "<this>");
        return StringOpsKt.toBooleanStrictOrNull(jsonPrimitive0.getContent());
    }

    @Nullable
    public static final String getContentOrNull(@NotNull JsonPrimitive jsonPrimitive0) {
        q.g(jsonPrimitive0, "<this>");
        return jsonPrimitive0 instanceof JsonNull ? null : jsonPrimitive0.getContent();
    }

    public static final double getDouble(@NotNull JsonPrimitive jsonPrimitive0) {
        q.g(jsonPrimitive0, "<this>");
        return Double.parseDouble(jsonPrimitive0.getContent());
    }

    public static final float getFloat(@NotNull JsonPrimitive jsonPrimitive0) {
        q.g(jsonPrimitive0, "<this>");
        return Float.parseFloat(jsonPrimitive0.getContent());
    }

    public static final int getInt(@NotNull JsonPrimitive jsonPrimitive0) {
        long v;
        q.g(jsonPrimitive0, "<this>");
        try {
            v = new StringJsonLexer(jsonPrimitive0.getContent()).consumeNumericLiteral();
        }
        catch(JsonDecodingException jsonDecodingException0) {
            throw new NumberFormatException(jsonDecodingException0.getMessage());
        }
        if(0xFFFFFFFF80000000L > v || v > 0x7FFFFFFFL) {
            throw new NumberFormatException(jsonPrimitive0.getContent() + " is not an Int");
        }
        return (int)v;
    }

    @NotNull
    public static final JsonObject getJsonObject(@NotNull JsonElement jsonElement0) {
        q.g(jsonElement0, "<this>");
        JsonObject jsonObject0 = jsonElement0 instanceof JsonObject ? ((JsonObject)jsonElement0) : null;
        if(jsonObject0 != null) {
            return jsonObject0;
        }
        JsonElementKt.error(jsonElement0, "JsonObject");
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @NotNull
    public static final JsonPrimitive getJsonPrimitive(@NotNull JsonElement jsonElement0) {
        q.g(jsonElement0, "<this>");
        JsonPrimitive jsonPrimitive0 = jsonElement0 instanceof JsonPrimitive ? ((JsonPrimitive)jsonElement0) : null;
        if(jsonPrimitive0 != null) {
            return jsonPrimitive0;
        }
        JsonElementKt.error(jsonElement0, "JsonPrimitive");
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @NotNull
    public static final SerialDescriptor getJsonUnquotedLiteralDescriptor() {
        return JsonElementKt.jsonUnquotedLiteralDescriptor;
    }

    public static final long getLong(@NotNull JsonPrimitive jsonPrimitive0) {
        q.g(jsonPrimitive0, "<this>");
        try {
            return new StringJsonLexer(jsonPrimitive0.getContent()).consumeNumericLiteral();
        }
        catch(JsonDecodingException jsonDecodingException0) {
            throw new NumberFormatException(jsonDecodingException0.getMessage());
        }
    }
}

