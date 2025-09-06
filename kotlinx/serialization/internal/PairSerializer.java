package kotlinx.serialization.internal;

import dg.a;
import ie.H;
import ie.m;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0003B#\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\n\u001A\u00028\u00002\u0006\u0010\u000B\u001A\u00028\u0001H\u0014¢\u0006\u0004\b\f\u0010\rR\u001A\u0010\u000F\u001A\u00020\u000E8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012R$\u0010\n\u001A\u00028\u0000*\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014R$\u0010\u000B\u001A\u00028\u0001*\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0014¨\u0006\u0016"}, d2 = {"Lkotlinx/serialization/internal/PairSerializer;", "K", "V", "Lkotlinx/serialization/internal/KeyValueSerializer;", "Lie/m;", "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "key", "value", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Lie/m;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "getKey", "(Lie/m;)Ljava/lang/Object;", "getValue", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class PairSerializer extends KeyValueSerializer {
    @NotNull
    private final SerialDescriptor descriptor;

    public PairSerializer(@NotNull KSerializer kSerializer0, @NotNull KSerializer kSerializer1) {
        q.g(kSerializer0, "keySerializer");
        q.g(kSerializer1, "valueSerializer");
        super(kSerializer0, kSerializer1, null);
        a a0 = new a(kSerializer0, kSerializer1, 1);
        this.descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("kotlin.Pair", new SerialDescriptor[0], a0);
    }

    public static H a(KSerializer kSerializer0, KSerializer kSerializer1, ClassSerialDescriptorBuilder classSerialDescriptorBuilder0) {
        return PairSerializer.descriptor$lambda$0(kSerializer0, kSerializer1, classSerialDescriptorBuilder0);
    }

    private static final H descriptor$lambda$0(KSerializer kSerializer0, KSerializer kSerializer1, ClassSerialDescriptorBuilder classSerialDescriptorBuilder0) {
        q.g(classSerialDescriptorBuilder0, "$this$buildClassSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder0, "first", kSerializer0.getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder0, "second", kSerializer1.getDescriptor(), null, false, 12, null);
        return H.a;
    }

    @Override  // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public Object getKey(@NotNull m m0) {
        q.g(m0, "<this>");
        return m0.a;
    }

    @Override  // kotlinx.serialization.internal.KeyValueSerializer
    public Object getKey(Object object0) {
        return this.getKey(((m)object0));
    }

    public Object getValue(@NotNull m m0) {
        q.g(m0, "<this>");
        return m0.b;
    }

    @Override  // kotlinx.serialization.internal.KeyValueSerializer
    public Object getValue(Object object0) {
        return this.getValue(((m)object0));
    }

    @NotNull
    public m toResult(Object object0, Object object1) {
        return new m(object0, object1);
    }

    @Override  // kotlinx.serialization.internal.KeyValueSerializer
    public Object toResult(Object object0, Object object1) {
        return this.toResult(object0, object1);
    }
}

