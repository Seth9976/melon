package kotlinx.serialization.internal;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\u001A\u0012\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"jsonCachedSerialNames", "", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class JsonInternalDependenciesKt {
    @NotNull
    public static final Set jsonCachedSerialNames(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "<this>");
        return Platform_commonKt.cachedSerialNames(serialDescriptor0);
    }
}

