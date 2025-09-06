package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016J\u0010\u0010\u0010\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00020\u0007H\u0014R\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0012"}, d2 = {"Lkotlinx/serialization/json/internal/JsonPrimitiveDecoder;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonElement;", "polymorphicDiscriminator", "", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;)V", "getValue", "()Lkotlinx/serialization/json/JsonElement;", "decodeElementIndex", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "currentElement", "tag", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
final class JsonPrimitiveDecoder extends AbstractJsonTreeDecoder {
    @NotNull
    private final JsonElement value;

    public JsonPrimitiveDecoder(@NotNull Json json0, @NotNull JsonElement jsonElement0, @Nullable String s) {
        q.g(json0, "json");
        q.g(jsonElement0, "value");
        super(json0, jsonElement0, s, null);
        this.value = jsonElement0;
        this.pushTag("primitive");
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    @NotNull
    public JsonElement currentElement(@NotNull String s) {
        q.g(s, "tag");
        if(s != "primitive") {
            throw new IllegalArgumentException("This input can only handle primitives with \'primitive\' tag");
        }
        return this.getValue();
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeElementIndex(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        return 0;
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    @NotNull
    public JsonElement getValue() {
        return this.value;
    }
}

