package kotlinx.serialization.json.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0005\b\u0012\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\r\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000EJA\u0010\u0018\u001A\u00020\u0006\"\b\b\u0000\u0010\u0010*\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u00132\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00028\u00000\u00152\b\u0010\u0017\u001A\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u001A\u0010\u001BR&\u0010\u001D\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u001C8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u001F\u0010 ¨\u0006!"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeEncoder;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlin/Function1;", "Lkotlinx/serialization/json/JsonElement;", "Lie/H;", "nodeConsumer", "<init>", "(Lkotlinx/serialization/json/Json;Lwe/k;)V", "", "key", "element", "putElement", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;)V", "", "T", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "index", "Lkotlinx/serialization/SerializationStrategy;", "serializer", "value", "encodeNullableSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "getCurrent", "()Lkotlinx/serialization/json/JsonElement;", "", "content", "Ljava/util/Map;", "getContent", "()Ljava/util/Map;", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
class JsonTreeEncoder extends AbstractJsonTreeEncoder {
    @NotNull
    private final Map content;

    public JsonTreeEncoder(@NotNull Json json0, @NotNull k k0) {
        q.g(json0, "json");
        q.g(k0, "nodeConsumer");
        super(json0, k0, null);
        this.content = new LinkedHashMap();
    }

    @Override  // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public void encodeNullableSerializableElement(@NotNull SerialDescriptor serialDescriptor0, int v, @NotNull SerializationStrategy serializationStrategy0, @Nullable Object object0) {
        q.g(serialDescriptor0, "descriptor");
        q.g(serializationStrategy0, "serializer");
        if(object0 == null && !this.configuration.getExplicitNulls()) {
            return;
        }
        super.encodeNullableSerializableElement(serialDescriptor0, v, serializationStrategy0, object0);
    }

    @NotNull
    public final Map getContent() {
        return this.content;
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonTreeEncoder
    @NotNull
    public JsonElement getCurrent() {
        return new JsonObject(this.content);
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonTreeEncoder
    public void putElement(@NotNull String s, @NotNull JsonElement jsonElement0) {
        q.g(s, "key");
        q.g(jsonElement0, "element");
        this.content.put(s, jsonElement0);
    }
}

