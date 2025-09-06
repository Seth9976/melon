package kotlinx.serialization.json;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001A\u0004\u0018\u00010\u00072\u0006\u0010\t\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u0007J\b\u0010\u000B\u001A\u00020\fH\u0001R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/serialization/json/JsonObjectBuilder;", "", "<init>", "()V", "content", "", "", "Lkotlinx/serialization/json/JsonElement;", "put", "key", "element", "build", "Lkotlinx/serialization/json/JsonObject;", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class JsonObjectBuilder {
    @NotNull
    private final Map content;

    public JsonObjectBuilder() {
        this.content = new LinkedHashMap();
    }

    @NotNull
    public final JsonObject build() {
        return new JsonObject(this.content);
    }

    @Nullable
    public final JsonElement put(@NotNull String s, @NotNull JsonElement jsonElement0) {
        q.g(s, "key");
        q.g(jsonElement0, "element");
        return (JsonElement)this.content.put(s, jsonElement0);
    }
}

