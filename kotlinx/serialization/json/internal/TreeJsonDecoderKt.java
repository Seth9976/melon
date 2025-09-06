package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A7\u0010\b\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"T", "Lkotlinx/serialization/json/Json;", "", "discriminator", "Lkotlinx/serialization/json/JsonObject;", "element", "Lkotlinx/serialization/DeserializationStrategy;", "deserializer", "readPolymorphicJson", "(Lkotlinx/serialization/json/Json;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "kotlinx-serialization-json"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class TreeJsonDecoderKt {
    public static final Object readPolymorphicJson(@NotNull Json json0, @NotNull String s, @NotNull JsonObject jsonObject0, @NotNull DeserializationStrategy deserializationStrategy0) {
        q.g(json0, "<this>");
        q.g(s, "discriminator");
        q.g(jsonObject0, "element");
        q.g(deserializationStrategy0, "deserializer");
        return new JsonTreeDecoder(json0, jsonObject0, s, deserializationStrategy0.getDescriptor()).decodeSerializableValue(deserializationStrategy0);
    }
}

