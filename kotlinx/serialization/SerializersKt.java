package kotlinx.serialization;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"kotlinx/serialization/SerializersKt__SerializersJvmKt"}, d2 = {}, k = 4, mv = {2, 0, 0}, xi = 0x30)
public abstract class SerializersKt {
    @NotNull
    public static final KSerializer serializer(@NotNull SerializersModule serializersModule0, @NotNull Type type0) {
        return SerializersKt__SerializersJvmKt.serializer(serializersModule0, type0);
    }

    @Nullable
    public static final KSerializer serializerOrNull(@NotNull SerializersModule serializersModule0, @NotNull Type type0) {
        return SerializersKt__SerializersJvmKt.serializerOrNull(serializersModule0, type0);
    }
}

