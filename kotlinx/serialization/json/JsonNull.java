package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001A\u0010\b\u001A\u00020\u00078\u0016X\u0096D¢\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lkotlinx/serialization/json/JsonNull;", "Lkotlinx/serialization/json/JsonPrimitive;", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "", "content", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
@Serializable(with = JsonNullSerializer.class)
public final class JsonNull extends JsonPrimitive {
    @NotNull
    public static final JsonNull INSTANCE;
    @NotNull
    private static final String content;

    static {
        JsonNull.INSTANCE = new JsonNull();
        JsonNull.content = "null";
    }

    private JsonNull() {
        super(null);
    }

    // 去混淆评级： 低(20)
    @Override  // kotlinx.serialization.json.JsonPrimitive
    @NotNull
    public String getContent() {
        return "null";
    }

    @NotNull
    public final KSerializer serializer() {
        return JsonNullSerializer.INSTANCE;
    }
}

