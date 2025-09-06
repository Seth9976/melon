package kotlinx.serialization.json.internal;

import java.util.List;
import je.C;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u000F\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\fH\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001A\u00020\u00152\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0005\u001A\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001A\u0004\b\u0019\u0010\u001AR\u001A\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\f0\u001B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001C\u0010\u001DR\u0014\u0010\u001E\u001A\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001E\u0010\u001FR\u0016\u0010 \u001A\u00020\n8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b \u0010\u001F¨\u0006!"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeMapDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/JsonObject;", "value", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "index", "", "elementName", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/String;", "decodeElementIndex", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "tag", "Lkotlinx/serialization/json/JsonElement;", "currentElement", "(Ljava/lang/String;)Lkotlinx/serialization/json/JsonElement;", "Lie/H;", "endStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "Lkotlinx/serialization/json/JsonObject;", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "", "keys", "Ljava/util/List;", "size", "I", "position", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
final class JsonTreeMapDecoder extends JsonTreeDecoder {
    @NotNull
    private final List keys;
    private int position;
    private final int size;
    @NotNull
    private final JsonObject value;

    public JsonTreeMapDecoder(@NotNull Json json0, @NotNull JsonObject jsonObject0) {
        q.g(json0, "json");
        q.g(jsonObject0, "value");
        super(json0, jsonObject0, null, null, 12, null);
        this.value = jsonObject0;
        List list0 = p.P0(this.getValue().keySet());
        this.keys = list0;
        this.size = list0.size() * 2;
        this.position = -1;
    }

    @Override  // kotlinx.serialization.json.internal.JsonTreeDecoder
    @NotNull
    public JsonElement currentElement(@NotNull String s) {
        q.g(s, "tag");
        return this.position % 2 == 0 ? JsonElementKt.JsonPrimitive(s) : ((JsonElement)C.Q(s, this.getValue()));
    }

    @Override  // kotlinx.serialization.json.internal.JsonTreeDecoder
    public int decodeElementIndex(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        int v = this.position;
        if(v < this.size - 1) {
            this.position = v + 1;
            return v + 1;
        }
        return -1;
    }

    @Override  // kotlinx.serialization.json.internal.JsonTreeDecoder
    @NotNull
    public String elementName(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return (String)this.keys.get(v / 2);
    }

    @Override  // kotlinx.serialization.json.internal.JsonTreeDecoder
    public void endStructure(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
    }

    @Override  // kotlinx.serialization.json.internal.JsonTreeDecoder
    public JsonElement getValue() {
        return this.getValue();
    }

    @Override  // kotlinx.serialization.json.internal.JsonTreeDecoder
    @NotNull
    public JsonObject getValue() {
        return this.value;
    }
}

