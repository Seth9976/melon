package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.descriptors.ContextAwareKt;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind.CONTEXTUAL;
import kotlinx.serialization.descriptors.SerialKind.ENUM;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind.LIST;
import kotlinx.serialization.descriptors.StructureKind.MAP;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u001B\u0010\u0004\u001A\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001A\u001B\u0010\b\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001A\u00020\u0006H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/serialization/json/Json;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "desc", "Lkotlinx/serialization/json/internal/WriteMode;", "switchMode", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/json/internal/WriteMode;", "Lkotlinx/serialization/modules/SerializersModule;", "module", "carrierDescriptor", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/modules/SerializersModule;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-json"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class WriteModeKt {
    @NotNull
    public static final SerialDescriptor carrierDescriptor(@NotNull SerialDescriptor serialDescriptor0, @NotNull SerializersModule serializersModule0) {
        q.g(serialDescriptor0, "<this>");
        q.g(serializersModule0, "module");
        if(q.b(serialDescriptor0.getKind(), CONTEXTUAL.INSTANCE)) {
            SerialDescriptor serialDescriptor1 = ContextAwareKt.getContextualDescriptor(serializersModule0, serialDescriptor0);
            if(serialDescriptor1 != null) {
                SerialDescriptor serialDescriptor2 = WriteModeKt.carrierDescriptor(serialDescriptor1, serializersModule0);
                return serialDescriptor2 == null ? serialDescriptor0 : serialDescriptor2;
            }
            return serialDescriptor0;
        }
        return serialDescriptor0.isInline() ? WriteModeKt.carrierDescriptor(serialDescriptor0.getElementDescriptor(0), serializersModule0) : serialDescriptor0;
    }

    @NotNull
    public static final WriteMode switchMode(@NotNull Json json0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(json0, "<this>");
        q.g(serialDescriptor0, "desc");
        SerialKind serialKind0 = serialDescriptor0.getKind();
        if(serialKind0 instanceof PolymorphicKind) {
            return WriteMode.POLY_OBJ;
        }
        if(q.b(serialKind0, LIST.INSTANCE)) {
            return WriteMode.LIST;
        }
        if(q.b(serialKind0, MAP.INSTANCE)) {
            SerialDescriptor serialDescriptor1 = WriteModeKt.carrierDescriptor(serialDescriptor0.getElementDescriptor(0), json0.getSerializersModule());
            SerialKind serialKind1 = serialDescriptor1.getKind();
            if(!(serialKind1 instanceof PrimitiveKind) && !q.b(serialKind1, ENUM.INSTANCE)) {
                if(!json0.getConfiguration().getAllowStructuredMapKeys()) {
                    throw JsonExceptionsKt.InvalidKeyKindException(serialDescriptor1);
                }
                return WriteMode.LIST;
            }
            return WriteMode.MAP;
        }
        return WriteMode.OBJ;
    }
}

