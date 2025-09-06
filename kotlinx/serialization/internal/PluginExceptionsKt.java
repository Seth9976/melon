package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\'\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00002\u0006\u0010\u0004\u001A\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "seen", "goldenMask", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lie/H;", "throwMissingFieldException", "(IILkotlinx/serialization/descriptors/SerialDescriptor;)V", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class PluginExceptionsKt {
    public static final void throwMissingFieldException(int v, int v1, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        ArrayList arrayList0 = new ArrayList();
        int v2 = ~v & v1;
        for(int v3 = 0; v3 < 0x20; ++v3) {
            if((v2 & 1) != 0) {
                arrayList0.add(serialDescriptor0.getElementName(v3));
            }
            v2 >>>= 1;
        }
        throw new MissingFieldException(arrayList0, serialDescriptor0.getSerialName());
    }
}

