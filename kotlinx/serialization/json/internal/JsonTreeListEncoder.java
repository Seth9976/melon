package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0014¢\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0013\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0019\u001A\u0012\u0012\u0004\u0012\u00020\u00050\u0017j\b\u0012\u0004\u0012\u00020\u0005`\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeListEncoder;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlin/Function1;", "Lkotlinx/serialization/json/JsonElement;", "Lie/H;", "nodeConsumer", "<init>", "(Lkotlinx/serialization/json/Json;Lwe/k;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "index", "", "elementName", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/String;", "key", "element", "putElement", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;)V", "getCurrent", "()Lkotlinx/serialization/json/JsonElement;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "array", "Ljava/util/ArrayList;", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
final class JsonTreeListEncoder extends AbstractJsonTreeEncoder {
    @NotNull
    private final ArrayList array;

    public JsonTreeListEncoder(@NotNull Json json0, @NotNull k k0) {
        q.g(json0, "json");
        q.g(k0, "nodeConsumer");
        super(json0, k0, null);
        this.array = new ArrayList();
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonTreeEncoder
    @NotNull
    public String elementName(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return String.valueOf(v);
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonTreeEncoder
    @NotNull
    public JsonElement getCurrent() {
        return new JsonArray(this.array);
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonTreeEncoder
    public void putElement(@NotNull String s, @NotNull JsonElement jsonElement0) {
        q.g(s, "key");
        q.g(jsonElement0, "element");
        int v = Integer.parseInt(s);
        this.array.add(v, jsonElement0);
    }
}

