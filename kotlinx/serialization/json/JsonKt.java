package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A+\u0010\u0006\u001A\u00020\u00002\b\b\u0002\u0010\u0001\u001A\u00020\u00002\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/serialization/json/Json;", "from", "Lkotlin/Function1;", "Lkotlinx/serialization/json/JsonBuilder;", "Lie/H;", "builderAction", "Json", "(Lkotlinx/serialization/json/Json;Lwe/k;)Lkotlinx/serialization/json/Json;", "kotlinx-serialization-json"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class JsonKt {
    @NotNull
    public static final Json Json(@NotNull Json json0, @NotNull k k0) {
        q.g(json0, "from");
        q.g(k0, "builderAction");
        JsonBuilder jsonBuilder0 = new JsonBuilder(json0);
        k0.invoke(jsonBuilder0);
        return new JsonImpl(jsonBuilder0.build$kotlinx_serialization_json(), jsonBuilder0.getSerializersModule());
    }

    public static Json Json$default(Json json0, k k0, int v, Object object0) {
        if((v & 1) != 0) {
            json0 = Json.Default;
        }
        return JsonKt.Json(json0, k0);
    }
}

