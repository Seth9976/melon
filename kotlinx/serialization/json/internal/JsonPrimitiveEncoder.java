package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\r\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0018\u0010\u0011\u001A\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/serialization/json/internal/JsonPrimitiveEncoder;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlin/Function1;", "Lkotlinx/serialization/json/JsonElement;", "Lie/H;", "nodeConsumer", "<init>", "(Lkotlinx/serialization/json/Json;Lwe/k;)V", "", "key", "element", "putElement", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;)V", "getCurrent", "()Lkotlinx/serialization/json/JsonElement;", "content", "Lkotlinx/serialization/json/JsonElement;", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
final class JsonPrimitiveEncoder extends AbstractJsonTreeEncoder {
    @Nullable
    private JsonElement content;

    public JsonPrimitiveEncoder(@NotNull Json json0, @NotNull k k0) {
        q.g(json0, "json");
        q.g(k0, "nodeConsumer");
        super(json0, k0, null);
        this.pushTag("primitive");
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonTreeEncoder
    @NotNull
    public JsonElement getCurrent() {
        JsonElement jsonElement0 = this.content;
        if(jsonElement0 == null) {
            throw new IllegalArgumentException("Primitive element has not been recorded. Is call to .encodeXxx is missing in serializer?");
        }
        return jsonElement0;
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonTreeEncoder
    public void putElement(@NotNull String s, @NotNull JsonElement jsonElement0) {
        q.g(s, "key");
        q.g(jsonElement0, "element");
        if(s != "primitive") {
            throw new IllegalArgumentException("This output can only consume primitives with \'primitive\' tag");
        }
        if(this.content != null) {
            throw new IllegalArgumentException("Primitive element was already recorded. Does call to .encodeXxx happen more than once?");
        }
        this.content = jsonElement0;
        this.getNodeConsumer().invoke(jsonElement0);
    }
}

