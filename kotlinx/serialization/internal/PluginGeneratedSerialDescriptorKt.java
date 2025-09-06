package kotlinx.serialization.internal;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorKt;
import kotlinx.serialization.descriptors.SerialKind;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001A!\u0010\u0004\u001A\u00020\u0003*\u00020\u00002\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00000\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "typeParams", "", "hashCodeImpl", "(Lkotlinx/serialization/descriptors/SerialDescriptor;[Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class PluginGeneratedSerialDescriptorKt {
    public static final int hashCodeImpl(@NotNull SerialDescriptor serialDescriptor0, @NotNull SerialDescriptor[] arr_serialDescriptor) {
        q.g(serialDescriptor0, "<this>");
        q.g(arr_serialDescriptor, "typeParams");
        int v = serialDescriptor0.getSerialName().hashCode();
        int v1 = Arrays.hashCode(arr_serialDescriptor);
        Iterable iterable0 = SerialDescriptorKt.getElementDescriptors(serialDescriptor0);
        Iterator iterator0 = iterable0.iterator();
        int v2 = 1;
        int v3;
        for(v3 = 1; true; v3 = v3 * 0x1F + v4) {
            int v4 = 0;
            if(!iterator0.hasNext()) {
                break;
            }
            Object object0 = iterator0.next();
            String s = ((SerialDescriptor)object0).getSerialName();
            if(s != null) {
                v4 = s.hashCode();
            }
        }
        for(Object object1: iterable0) {
            SerialKind serialKind0 = ((SerialDescriptor)object1).getKind();
            v2 = v2 * 0x1F + (serialKind0 == null ? 0 : serialKind0.hashCode());
        }
        return ((v * 0x1F + v1) * 0x1F + v3) * 0x1F + v2;
    }
}

