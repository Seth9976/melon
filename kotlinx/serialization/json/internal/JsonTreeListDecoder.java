package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u000BH\u0014J\u0010\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u000EH\u0014J\u0010\u0010\u0015\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016R\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeListDecoder;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonArray;", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonArray;)V", "getValue", "()Lkotlinx/serialization/json/JsonArray;", "size", "", "currentIndex", "elementName", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "tag", "decodeElementIndex", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
final class JsonTreeListDecoder extends AbstractJsonTreeDecoder {
    private int currentIndex;
    private final int size;
    @NotNull
    private final JsonArray value;

    public JsonTreeListDecoder(@NotNull Json json0, @NotNull JsonArray jsonArray0) {
        q.g(json0, "json");
        q.g(jsonArray0, "value");
        super(json0, jsonArray0, null, 4, null);
        this.value = jsonArray0;
        this.size = this.getValue().size();
        this.currentIndex = -1;
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    @NotNull
    public JsonElement currentElement(@NotNull String s) {
        q.g(s, "tag");
        return this.getValue().get(Integer.parseInt(s));
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeElementIndex(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        int v = this.currentIndex;
        if(v < this.size - 1) {
            this.currentIndex = v + 1;
            return v + 1;
        }
        return -1;
    }

    @Override  // kotlinx.serialization.internal.NamedValueDecoder
    @NotNull
    public String elementName(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return String.valueOf(v);
    }

    @NotNull
    public JsonArray getValue() {
        return this.value;
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public JsonElement getValue() {
        return this.getValue();
    }
}

