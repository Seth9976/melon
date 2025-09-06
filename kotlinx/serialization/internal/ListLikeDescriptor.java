package kotlinx.serialization.internal;

import Tf.v;
import U4.x;
import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.descriptors.SerialDescriptor.DefaultImpls;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind.LIST;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001B\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000B\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u001D\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001A\u0010\u0018\u001A\u00020\r2\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001C\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u001C\u0010\u001DR\u0017\u0010\u0002\u001A\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u001E\u001A\u0004\b\u0014\u0010\u001FR\u001A\u0010 \u001A\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b \u0010!\u001A\u0004\b\"\u0010\u001BR\u0014\u0010&\u001A\u00020#8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b$\u0010%\u0082\u0001\u0004\'()*¨\u0006+"}, d2 = {"Lkotlinx/serialization/internal/ListLikeDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementDescriptor", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "index", "", "getElementName", "(I)Ljava/lang/String;", "name", "getElementIndex", "(Ljava/lang/String;)I", "", "isElementOptional", "(I)Z", "", "", "getElementAnnotations", "(I)Ljava/util/List;", "getElementDescriptor", "(I)Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementsCount", "I", "getElementsCount", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kind", "Lkotlinx/serialization/internal/ArrayClassDesc;", "Lkotlinx/serialization/internal/ArrayListClassDesc;", "Lkotlinx/serialization/internal/LinkedHashSetClassDesc;", "Lkotlinx/serialization/internal/PrimitiveArrayDescriptor;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public abstract class ListLikeDescriptor implements SerialDescriptor {
    @NotNull
    private final SerialDescriptor elementDescriptor;
    private final int elementsCount;

    private ListLikeDescriptor(SerialDescriptor serialDescriptor0) {
        this.elementDescriptor = serialDescriptor0;
        this.elementsCount = 1;
    }

    public ListLikeDescriptor(SerialDescriptor serialDescriptor0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(serialDescriptor0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof ListLikeDescriptor ? q.b(this.elementDescriptor, ((ListLikeDescriptor)object0).elementDescriptor) && q.b(this.getSerialName(), ((ListLikeDescriptor)object0).getSerialName()) : false;
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public List getAnnotations() {
        return DefaultImpls.getAnnotations(this);
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public List getElementAnnotations(int v) {
        if(v >= 0) {
            return w.a;
        }
        StringBuilder stringBuilder0 = x.n(v, "Illegal index ", ", ");
        stringBuilder0.append(this.getSerialName());
        stringBuilder0.append(" expects only non-negative indices");
        throw new IllegalArgumentException(stringBuilder0.toString().toString());
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public SerialDescriptor getElementDescriptor(int v) {
        if(v >= 0) {
            return this.elementDescriptor;
        }
        StringBuilder stringBuilder0 = x.n(v, "Illegal index ", ", ");
        stringBuilder0.append(this.getSerialName());
        stringBuilder0.append(" expects only non-negative indices");
        throw new IllegalArgumentException(stringBuilder0.toString().toString());
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementIndex(@NotNull String s) {
        q.g(s, "name");
        Integer integer0 = v.t0(s);
        if(integer0 == null) {
            throw new IllegalArgumentException(s + " is not a valid list index");
        }
        return (int)integer0;
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String getElementName(int v) {
        return String.valueOf(v);
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementsCount() {
        return this.elementsCount;
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public SerialKind getKind() {
        return LIST.INSTANCE;
    }

    @Override
    public int hashCode() {
        return this.getSerialName().hashCode() + this.elementDescriptor.hashCode() * 0x1F;
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isElementOptional(int v) {
        if(v >= 0) {
            return false;
        }
        StringBuilder stringBuilder0 = x.n(v, "Illegal index ", ", ");
        stringBuilder0.append(this.getSerialName());
        stringBuilder0.append(" expects only non-negative indices");
        throw new IllegalArgumentException(stringBuilder0.toString().toString());
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return false;
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isNullable() {
        return false;
    }

    @Override
    @NotNull
    public String toString() {
        return this.getSerialName() + '(' + this.elementDescriptor + ')';
    }
}

