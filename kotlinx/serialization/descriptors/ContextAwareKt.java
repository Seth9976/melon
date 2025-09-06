package kotlinx.serialization.descriptors;

import De.d;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.SerialDescriptorForNullable;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001A\u001D\u0010\u0003\u001A\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001A\u001F\u0010\u0007\u001A\u00020\u0001*\u00020\u00012\n\u0010\u0006\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\"$\u0010\r\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0005*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000B\u0010\f\u001A\u0004\b\t\u0010\n¨\u0006\u000E"}, d2 = {"Lkotlinx/serialization/modules/SerializersModule;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "getContextualDescriptor", "(Lkotlinx/serialization/modules/SerializersModule;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "LDe/d;", "context", "withContext", "(Lkotlinx/serialization/descriptors/SerialDescriptor;LDe/d;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "getCapturedKClass", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)LDe/d;", "getCapturedKClass$annotations", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "capturedKClass", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class ContextAwareKt {
    @Nullable
    public static final d getCapturedKClass(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "<this>");
        if(serialDescriptor0 instanceof ContextDescriptor) {
            return ((ContextDescriptor)serialDescriptor0).kClass;
        }
        return serialDescriptor0 instanceof SerialDescriptorForNullable ? ContextAwareKt.getCapturedKClass(((SerialDescriptorForNullable)serialDescriptor0).getOriginal$kotlinx_serialization_core()) : null;
    }

    @Nullable
    public static final SerialDescriptor getContextualDescriptor(@NotNull SerializersModule serializersModule0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(serializersModule0, "<this>");
        q.g(serialDescriptor0, "descriptor");
        d d0 = ContextAwareKt.getCapturedKClass(serialDescriptor0);
        if(d0 != null) {
            KSerializer kSerializer0 = SerializersModule.getContextual$default(serializersModule0, d0, null, 2, null);
            return kSerializer0 == null ? null : kSerializer0.getDescriptor();
        }
        return null;
    }

    @NotNull
    public static final SerialDescriptor withContext(@NotNull SerialDescriptor serialDescriptor0, @NotNull d d0) {
        q.g(serialDescriptor0, "<this>");
        q.g(d0, "context");
        return new ContextDescriptor(serialDescriptor0, d0);
    }
}

