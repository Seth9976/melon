package kotlinx.serialization.internal;

import De.d;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\t\u001A\u0019\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001A!\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00000\u0006*\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001A\u0017\u0010\u000B\u001A\u00020\n*\u0006\u0012\u0002\b\u00030\tH\u0000¢\u0006\u0004\b\u000B\u0010\f\u001A\u0017\u0010\r\u001A\u00020\u0002*\u0006\u0012\u0002\b\u00030\tH\u0000¢\u0006\u0004\b\r\u0010\u000E\u001A\u0017\u0010\r\u001A\u00020\u00022\u0006\u0010\u000F\u001A\u00020\u0002H\u0000¢\u0006\u0004\b\r\u0010\u0010\"\u001A\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00000\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "", "cachedSerialNames", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Ljava/util/Set;", "", "", "compactArray", "(Ljava/util/List;)[Lkotlinx/serialization/descriptors/SerialDescriptor;", "LDe/d;", "", "serializerNotRegistered", "(LDe/d;)Ljava/lang/Void;", "notRegisteredMessage", "(LDe/d;)Ljava/lang/String;", "className", "(Ljava/lang/String;)Ljava/lang/String;", "EMPTY_DESCRIPTOR_ARRAY", "[Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class Platform_commonKt {
    @NotNull
    private static final SerialDescriptor[] EMPTY_DESCRIPTOR_ARRAY;

    static {
        Platform_commonKt.EMPTY_DESCRIPTOR_ARRAY = new SerialDescriptor[0];
    }

    @NotNull
    public static final Set cachedSerialNames(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "<this>");
        if(serialDescriptor0 instanceof CachedNames) {
            return ((CachedNames)serialDescriptor0).getSerialNames();
        }
        Set set0 = new HashSet(serialDescriptor0.getElementsCount());
        int v = serialDescriptor0.getElementsCount();
        for(int v1 = 0; v1 < v; ++v1) {
            set0.add(serialDescriptor0.getElementName(v1));
        }
        return set0;
    }

    @NotNull
    public static final SerialDescriptor[] compactArray(@Nullable List list0) {
        if(list0 == null || list0.isEmpty()) {
            list0 = null;
        }
        if(list0 != null) {
            SerialDescriptor[] arr_serialDescriptor = (SerialDescriptor[])list0.toArray(new SerialDescriptor[0]);
            return arr_serialDescriptor == null ? Platform_commonKt.EMPTY_DESCRIPTOR_ARRAY : arr_serialDescriptor;
        }
        return Platform_commonKt.EMPTY_DESCRIPTOR_ARRAY;
    }

    @NotNull
    public static final String notRegisteredMessage(@NotNull d d0) {
        q.g(d0, "<this>");
        String s = d0.m();
        if(s == null) {
            s = "<local class name not available>";
        }
        return Platform_commonKt.notRegisteredMessage(s);
    }

    @NotNull
    public static final String notRegisteredMessage(@NotNull String s) {
        q.g(s, "className");
        return "Serializer for class \'" + s + "\' is not found.\nPlease ensure that class is marked as \'@Serializable\' and that the serialization compiler plugin is applied.\n";
    }

    @NotNull
    public static final Void serializerNotRegistered(@NotNull d d0) {
        q.g(d0, "<this>");
        throw new SerializationException(Platform_commonKt.notRegisteredMessage(d0));
    }
}

