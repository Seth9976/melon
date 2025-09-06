package kotlinx.serialization.internal;

import De.d;
import Tf.p;
import com.iloen.melon.utils.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\u001A\u001F\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001A\u0017\u0010\b\u001A\u00020\u00072\u0006\u0010\u0001\u001A\u00020\u0000H\u0002¢\u0006\u0004\b\b\u0010\t\u001A+\u0010\u000E\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r\"\b\b\u0000\u0010\u000B*\u00020\n*\b\u0012\u0004\u0012\u00028\u00000\fH\u0000¢\u0006\u0004\b\u000E\u0010\u000F\"(\u0010\u0011\u001A\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"", "serialName", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "kind", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "PrimitiveDescriptorSafe", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/PrimitiveKind;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lie/H;", "checkName", "(Ljava/lang/String;)V", "", "T", "LDe/d;", "Lkotlinx/serialization/KSerializer;", "builtinSerializerOrNull", "(LDe/d;)Lkotlinx/serialization/KSerializer;", "", "BUILTIN_SERIALIZERS", "Ljava/util/Map;", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class PrimitivesKt {
    @NotNull
    private static final Map BUILTIN_SERIALIZERS;

    static {
        PrimitivesKt.BUILTIN_SERIALIZERS = PlatformKt.initBuiltins();
    }

    @NotNull
    public static final SerialDescriptor PrimitiveDescriptorSafe(@NotNull String s, @NotNull PrimitiveKind primitiveKind0) {
        q.g(s, "serialName");
        q.g(primitiveKind0, "kind");
        PrimitivesKt.checkName(s);
        return new PrimitiveSerialDescriptor(s, primitiveKind0);
    }

    @Nullable
    public static final KSerializer builtinSerializerOrNull(@NotNull d d0) {
        q.g(d0, "<this>");
        return (KSerializer)PrimitivesKt.BUILTIN_SERIALIZERS.get(d0);
    }

    private static final void checkName(String s) {
        for(Object object0: PrimitivesKt.BUILTIN_SERIALIZERS.values()) {
            KSerializer kSerializer0 = (KSerializer)object0;
            if(q.b(s, kSerializer0.getDescriptor().getSerialName())) {
                StringBuilder stringBuilder0 = a.n("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name ", s, " there already exists ");
                Class class0 = kSerializer0.getClass();
                stringBuilder0.append(I.a.b(class0).m());
                stringBuilder0.append(".\n                Please refer to SerialDescriptor documentation for additional information.\n            ");
                throw new IllegalArgumentException(p.c0(stringBuilder0.toString()));
            }
            if(false) {
                break;
            }
        }
    }
}

