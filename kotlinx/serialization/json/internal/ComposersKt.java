package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.json.Json;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"Composer", "Lkotlinx/serialization/json/internal/Composer;", "sb", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "json", "Lkotlinx/serialization/json/Json;", "kotlinx-serialization-json"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class ComposersKt {
    @NotNull
    public static final Composer Composer(@NotNull InternalJsonWriter internalJsonWriter0, @NotNull Json json0) {
        q.g(internalJsonWriter0, "sb");
        q.g(json0, "json");
        return json0.getConfiguration().getPrettyPrint() ? new ComposerWithPrettyPrint(internalJsonWriter0, json0) : new Composer(internalJsonWriter0);
    }
}

