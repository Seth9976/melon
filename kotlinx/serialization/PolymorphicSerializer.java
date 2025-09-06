package kotlinx.serialization;

import De.d;
import Vc.B;
import b9.a;
import d3.g;
import ie.H;
import ie.j;
import ie.k;
import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.q;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.ContextAwareKt;
import kotlinx.serialization.descriptors.PolymorphicKind.OPEN;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind.CONTEXTUAL;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u001B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0015\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR \u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000B\u001A\u0004\b\f\u0010\rR\u001C\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000E8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001B\u0010\u0017\u001A\u00020\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lkotlinx/serialization/PolymorphicSerializer;", "", "T", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "LDe/d;", "baseClass", "<init>", "(LDe/d;)V", "", "toString", "()Ljava/lang/String;", "LDe/d;", "getBaseClass", "()LDe/d;", "", "", "_annotations", "Ljava/util/List;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lie/j;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class PolymorphicSerializer extends AbstractPolymorphicSerializer {
    @NotNull
    private List _annotations;
    @NotNull
    private final d baseClass;
    @NotNull
    private final j descriptor$delegate;

    public PolymorphicSerializer(@NotNull d d0) {
        q.g(d0, "baseClass");
        super();
        this.baseClass = d0;
        this._annotations = w.a;
        a a0 = new a(this, 2);
        this.descriptor$delegate = g.P(k.b, a0);
    }

    public static SerialDescriptor a(PolymorphicSerializer polymorphicSerializer0) {
        return PolymorphicSerializer.descriptor_delegate$lambda$1(polymorphicSerializer0);
    }

    public static H b(PolymorphicSerializer polymorphicSerializer0, ClassSerialDescriptorBuilder classSerialDescriptorBuilder0) {
        return PolymorphicSerializer.descriptor_delegate$lambda$1$lambda$0(polymorphicSerializer0, classSerialDescriptorBuilder0);
    }

    private static final SerialDescriptor descriptor_delegate$lambda$1(PolymorphicSerializer polymorphicSerializer0) {
        B b0 = new B(polymorphicSerializer0, 14);
        return ContextAwareKt.withContext(SerialDescriptorsKt.buildSerialDescriptor("kotlinx.serialization.Polymorphic", OPEN.INSTANCE, new SerialDescriptor[0], b0), polymorphicSerializer0.getBaseClass());
    }

    private static final H descriptor_delegate$lambda$1$lambda$0(PolymorphicSerializer polymorphicSerializer0, ClassSerialDescriptorBuilder classSerialDescriptorBuilder0) {
        q.g(classSerialDescriptorBuilder0, "$this$buildSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder0, "type", BuiltinSerializersKt.serializer(M.a).getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder0, "value", SerialDescriptorsKt.buildSerialDescriptor$default(("kotlinx.serialization.Polymorphic<" + polymorphicSerializer0.getBaseClass().m() + '>'), CONTEXTUAL.INSTANCE, new SerialDescriptor[0], null, 8, null), null, false, 12, null);
        classSerialDescriptorBuilder0.setAnnotations(polymorphicSerializer0._annotations);
        return H.a;
    }

    @Override  // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    @NotNull
    public d getBaseClass() {
        return this.baseClass;
    }

    @Override  // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor)this.descriptor$delegate.getValue();
    }

    @Override
    @NotNull
    public String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + this.getBaseClass() + ')';
    }
}

