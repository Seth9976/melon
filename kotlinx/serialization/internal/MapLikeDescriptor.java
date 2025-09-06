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
import kotlinx.serialization.descriptors.StructureKind.MAP;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001B\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B!\b\u0004\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0001\u0012\u0006\u0010\u0005\u001A\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001A\u00020\u00022\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\r\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001D\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001A\u0010\u001A\u001A\u00020\u000F2\b\u0010\u0019\u001A\u0004\u0018\u00010\u0018H\u0096\u0002¢\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001C\u001A\u00020\bH\u0016¢\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001E\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u001E\u0010\u001FR\u001A\u0010\u0003\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010 \u001A\u0004\b!\u0010\u001FR\u0017\u0010\u0004\u001A\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0004\u0010\"\u001A\u0004\b#\u0010$R\u0017\u0010\u0005\u001A\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001A\u0004\b%\u0010$R\u001A\u0010&\u001A\u00020\b8\u0016X\u0096D¢\u0006\f\n\u0004\b&\u0010\'\u001A\u0004\b(\u0010\u001DR\u0014\u0010,\u001A\u00020)8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b*\u0010+\u0082\u0001\u0001-¨\u0006."}, d2 = {"Lkotlinx/serialization/internal/MapLikeDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "serialName", "keyDescriptor", "valueDescriptor", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "index", "getElementName", "(I)Ljava/lang/String;", "name", "getElementIndex", "(Ljava/lang/String;)I", "", "isElementOptional", "(I)Z", "", "", "getElementAnnotations", "(I)Ljava/util/List;", "getElementDescriptor", "(I)Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getSerialName", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getKeyDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "getValueDescriptor", "elementsCount", "I", "getElementsCount", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kind", "Lkotlinx/serialization/internal/LinkedHashMapClassDesc;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public abstract class MapLikeDescriptor implements SerialDescriptor {
    private final int elementsCount;
    @NotNull
    private final SerialDescriptor keyDescriptor;
    @NotNull
    private final String serialName;
    @NotNull
    private final SerialDescriptor valueDescriptor;

    private MapLikeDescriptor(String s, SerialDescriptor serialDescriptor0, SerialDescriptor serialDescriptor1) {
        this.serialName = s;
        this.keyDescriptor = serialDescriptor0;
        this.valueDescriptor = serialDescriptor1;
        this.elementsCount = 2;
    }

    public MapLikeDescriptor(String s, SerialDescriptor serialDescriptor0, SerialDescriptor serialDescriptor1, DefaultConstructorMarker defaultConstructorMarker0) {
        this(s, serialDescriptor0, serialDescriptor1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof MapLikeDescriptor)) {
            return false;
        }
        if(!q.b(this.getSerialName(), ((MapLikeDescriptor)object0).getSerialName())) {
            return false;
        }
        return q.b(this.keyDescriptor, ((MapLikeDescriptor)object0).keyDescriptor) ? q.b(this.valueDescriptor, ((MapLikeDescriptor)object0).valueDescriptor) : false;
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
            switch(v % 2) {
                case 0: {
                    return this.keyDescriptor;
                }
                case 1: {
                    return this.valueDescriptor;
                }
                default: {
                    throw new IllegalStateException("Unreached");
                }
            }
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
            throw new IllegalArgumentException(s + " is not a valid map index");
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
        return MAP.INSTANCE;
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String getSerialName() {
        return this.serialName;
    }

    @Override
    public int hashCode() {
        return this.valueDescriptor.hashCode() + (this.keyDescriptor.hashCode() + this.getSerialName().hashCode() * 0x1F) * 0x1F;
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
        return this.getSerialName() + '(' + this.keyDescriptor + ", " + this.valueDescriptor + ')';
    }
}

