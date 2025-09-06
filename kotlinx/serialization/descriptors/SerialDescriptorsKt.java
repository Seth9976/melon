package kotlinx.serialization.descriptors;

import Tf.o;
import Wf.a;
import ie.H;
import java.util.List;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.internal.PrimitivesKt;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u00000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A?\u0010\t\u001A\u00020\u00032\u0006\u0010\u0001\u001A\u00020\u00002\u0012\u0010\u0004\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u00032\u0014\b\u0002\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\t\u0010\n\u001A\u001D\u0010\r\u001A\u00020\u00032\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\r\u0010\u000E\u001AI\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\f\u001A\u00020\u000F2\u0012\u0010\u0004\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u00032\u0014\b\u0002\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"", "serialName", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeParameters", "Lkotlin/Function1;", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "Lie/H;", "builderAction", "buildClassSerialDescriptor", "(Ljava/lang/String;[Lkotlinx/serialization/descriptors/SerialDescriptor;Lwe/k;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "kind", "PrimitiveSerialDescriptor", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/PrimitiveKind;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialKind;", "builder", "buildSerialDescriptor", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialKind;[Lkotlinx/serialization/descriptors/SerialDescriptor;Lwe/k;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class SerialDescriptorsKt {
    @NotNull
    public static final SerialDescriptor PrimitiveSerialDescriptor(@NotNull String s, @NotNull PrimitiveKind primitiveKind0) {
        q.g(s, "serialName");
        q.g(primitiveKind0, "kind");
        if(o.H0(s)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        return PrimitivesKt.PrimitiveDescriptorSafe(s, primitiveKind0);
    }

    public static H a(ClassSerialDescriptorBuilder classSerialDescriptorBuilder0) {
        return SerialDescriptorsKt.buildSerialDescriptor$lambda$6(classSerialDescriptorBuilder0);
    }

    @NotNull
    public static final SerialDescriptor buildClassSerialDescriptor(@NotNull String s, @NotNull SerialDescriptor[] arr_serialDescriptor, @NotNull k k0) {
        q.g(s, "serialName");
        q.g(arr_serialDescriptor, "typeParameters");
        q.g(k0, "builderAction");
        if(o.H0(s)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder0 = new ClassSerialDescriptorBuilder(s);
        k0.invoke(classSerialDescriptorBuilder0);
        List list0 = n.z0(arr_serialDescriptor);
        return new SerialDescriptorImpl(s, CLASS.INSTANCE, classSerialDescriptorBuilder0.getElementNames$kotlinx_serialization_core().size(), list0, classSerialDescriptorBuilder0);
    }

    @NotNull
    public static final SerialDescriptor buildSerialDescriptor(@NotNull String s, @NotNull SerialKind serialKind0, @NotNull SerialDescriptor[] arr_serialDescriptor, @NotNull k k0) {
        q.g(s, "serialName");
        q.g(serialKind0, "kind");
        q.g(arr_serialDescriptor, "typeParameters");
        q.g(k0, "builder");
        if(o.H0(s)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if(serialKind0.equals(CLASS.INSTANCE)) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use \'buildClassSerialDescriptor\' instead");
        }
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder0 = new ClassSerialDescriptorBuilder(s);
        k0.invoke(classSerialDescriptorBuilder0);
        return new SerialDescriptorImpl(s, serialKind0, classSerialDescriptorBuilder0.getElementNames$kotlinx_serialization_core().size(), n.z0(arr_serialDescriptor), classSerialDescriptorBuilder0);
    }

    public static SerialDescriptor buildSerialDescriptor$default(String s, SerialKind serialKind0, SerialDescriptor[] arr_serialDescriptor, k k0, int v, Object object0) {
        if((v & 8) != 0) {
            k0 = new a(23);
        }
        return SerialDescriptorsKt.buildSerialDescriptor(s, serialKind0, arr_serialDescriptor, k0);
    }

    private static final H buildSerialDescriptor$lambda$6(ClassSerialDescriptorBuilder classSerialDescriptorBuilder0) {
        q.g(classSerialDescriptorBuilder0, "<this>");
        return H.a;
    }
}

