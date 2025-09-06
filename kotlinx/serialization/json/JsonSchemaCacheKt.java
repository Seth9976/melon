package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u001E\u0010\u0006\u001A\u00020\u0001*\u00020\u00008@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lkotlinx/serialization/json/Json;", "Lkotlinx/serialization/json/internal/DescriptorSchemaCache;", "getSchemaCache", "(Lkotlinx/serialization/json/Json;)Lkotlinx/serialization/json/internal/DescriptorSchemaCache;", "getSchemaCache$annotations", "(Lkotlinx/serialization/json/Json;)V", "schemaCache", "kotlinx-serialization-json"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class JsonSchemaCacheKt {
    @NotNull
    public static final DescriptorSchemaCache getSchemaCache(@NotNull Json json0) {
        q.g(json0, "<this>");
        return json0.get_schemaCache$kotlinx_serialization_json();
    }
}

