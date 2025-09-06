package kotlinx.serialization.json.internal;

import i.n.i.b.a.s.e.M3;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonArraySerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;
import kotlinx.serialization.json.JsonPrimitive;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\r\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0016\u0010\u0011\u001A\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001A\u00020\u00138\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeMapEncoder;", "Lkotlinx/serialization/json/internal/JsonTreeEncoder;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlin/Function1;", "Lkotlinx/serialization/json/JsonElement;", "Lie/H;", "nodeConsumer", "<init>", "(Lkotlinx/serialization/json/Json;Lwe/k;)V", "", "key", "element", "putElement", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;)V", "getCurrent", "()Lkotlinx/serialization/json/JsonElement;", "tag", "Ljava/lang/String;", "", "isKey", "Z", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
final class JsonTreeMapEncoder extends JsonTreeEncoder {
    private boolean isKey;
    private String tag;

    public JsonTreeMapEncoder(@NotNull Json json0, @NotNull k k0) {
        q.g(json0, "json");
        q.g(k0, "nodeConsumer");
        super(json0, k0);
        this.isKey = true;
    }

    @Override  // kotlinx.serialization.json.internal.JsonTreeEncoder
    @NotNull
    public JsonElement getCurrent() {
        return new JsonObject(this.getContent());
    }

    @Override  // kotlinx.serialization.json.internal.JsonTreeEncoder
    public void putElement(@NotNull String s, @NotNull JsonElement jsonElement0) {
        q.g(s, "key");
        q.g(jsonElement0, "element");
        if(this.isKey) {
            if(jsonElement0 instanceof JsonPrimitive) {
                this.tag = ((JsonPrimitive)jsonElement0).getContent();
                this.isKey = false;
                return;
            }
            if(jsonElement0 instanceof JsonObject) {
                throw JsonExceptionsKt.InvalidKeyKindException(JsonObjectSerializer.INSTANCE.getDescriptor());
            }
            if(!(jsonElement0 instanceof JsonArray)) {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            throw JsonExceptionsKt.InvalidKeyKindException(JsonArraySerializer.INSTANCE.getDescriptor());
        }
        Map map0 = this.getContent();
        String s1 = this.tag;
        if(s1 != null) {
            map0.put(s1, jsonElement0);
            this.isKey = true;
            return;
        }
        q.m("tag");
        throw null;
    }
}

