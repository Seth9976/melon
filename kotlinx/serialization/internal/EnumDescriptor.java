package kotlinx.serialization.internal;

import Cc.P0;
import d3.g;
import ie.j;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorKt;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind.ENUM;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind.OBJECT;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u001A\u0010\u000F\u001A\u00020\u000E2\b\u0010\r\u001A\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0011\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001A\u0010\u0016\u001A\u00020\u00158\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019R!\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\t0\u001A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\u001E¨\u0006 "}, d2 = {"Lkotlinx/serialization/internal/EnumDescriptor;", "Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "", "name", "", "elementsCount", "<init>", "(Ljava/lang/String;I)V", "index", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getElementDescriptor", "(I)Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "hashCode", "()I", "Lkotlinx/serialization/descriptors/SerialKind;", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "", "elementDescriptors$delegate", "Lie/j;", "getElementDescriptors", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementDescriptors", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class EnumDescriptor extends PluginGeneratedSerialDescriptor {
    @NotNull
    private final j elementDescriptors$delegate;
    @NotNull
    private final SerialKind kind;

    public EnumDescriptor(@NotNull String s, int v) {
        q.g(s, "name");
        super(s, null, v, 2, null);
        this.kind = ENUM.INSTANCE;
        this.elementDescriptors$delegate = g.Q(new P0(v, s, this, 9));
    }

    public static SerialDescriptor[] e(int v, String s, EnumDescriptor enumDescriptor0) {
        return EnumDescriptor.elementDescriptors_delegate$lambda$0(v, s, enumDescriptor0);
    }

    private static final SerialDescriptor[] elementDescriptors_delegate$lambda$0(int v, String s, EnumDescriptor enumDescriptor0) {
        SerialDescriptor[] arr_serialDescriptor = new SerialDescriptor[v];
        for(int v1 = 0; v1 < v; ++v1) {
            arr_serialDescriptor[v1] = SerialDescriptorsKt.buildSerialDescriptor$default((s + '.' + enumDescriptor0.getElementName(v1)), OBJECT.INSTANCE, new SerialDescriptor[0], null, 8, null);
        }
        return arr_serialDescriptor;
    }

    @Override  // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof SerialDescriptor)) {
            return false;
        }
        if(((SerialDescriptor)object0).getKind() != ENUM.INSTANCE) {
            return false;
        }
        return q.b(this.getSerialName(), ((SerialDescriptor)object0).getSerialName()) ? q.b(Platform_commonKt.cachedSerialNames(this), Platform_commonKt.cachedSerialNames(((SerialDescriptor)object0))) : false;
    }

    @Override  // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    @NotNull
    public SerialDescriptor getElementDescriptor(int v) {
        return this.getElementDescriptors()[v];
    }

    private final SerialDescriptor[] getElementDescriptors() {
        return (SerialDescriptor[])this.elementDescriptors$delegate.getValue();
    }

    @Override  // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    @NotNull
    public SerialKind getKind() {
        return this.kind;
    }

    @Override  // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public int hashCode() {
        int v = this.getSerialName().hashCode();
        int v1 = 1;
        for(Object object0: SerialDescriptorKt.getElementNames(this)) {
            String s = (String)object0;
            v1 = v1 * 0x1F + (s == null ? 0 : s.hashCode());
        }
        return v * 0x1F + v1;
    }

    @Override  // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    @NotNull
    public String toString() {
        return p.q0(SerialDescriptorKt.getElementNames(this), ", ", this.getSerialName() + '(', ")", null, 56);
    }
}

