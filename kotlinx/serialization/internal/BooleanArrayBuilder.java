package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u000F\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u000B\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0010¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0010\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\fH\u0000¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0013\u001A\u00020\u0002H\u0010¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001A\u00020\u00062\u0006\u0010\u0016\u001A\u00020\u00068\u0010@RX\u0090\u000E¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2 = {"Lkotlinx/serialization/internal/BooleanArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "<init>", "([Z)V", "", "requiredCapacity", "Lie/H;", "ensureCapacity$kotlinx_serialization_core", "(I)V", "ensureCapacity", "", "c", "append$kotlinx_serialization_core", "(Z)V", "append", "build$kotlinx_serialization_core", "()[Z", "build", "buffer", "[Z", "value", "position", "I", "getPosition$kotlinx_serialization_core", "()I", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class BooleanArrayBuilder extends PrimitiveArrayBuilder {
    @NotNull
    private boolean[] buffer;
    private int position;

    public BooleanArrayBuilder(@NotNull boolean[] arr_z) {
        q.g(arr_z, "bufferWithData");
        super();
        this.buffer = arr_z;
        this.position = arr_z.length;
        this.ensureCapacity$kotlinx_serialization_core(10);
    }

    public final void append$kotlinx_serialization_core(boolean z) {
        PrimitiveArrayBuilder.ensureCapacity$kotlinx_serialization_core$default(this, 0, 1, null);
        int v = this.getPosition$kotlinx_serialization_core();
        this.position = v + 1;
        this.buffer[v] = z;
    }

    @Override  // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public Object build$kotlinx_serialization_core() {
        return this.build$kotlinx_serialization_core();
    }

    @NotNull
    public boolean[] build$kotlinx_serialization_core() {
        boolean[] arr_z = Arrays.copyOf(this.buffer, this.getPosition$kotlinx_serialization_core());
        q.f(arr_z, "copyOf(...)");
        return arr_z;
    }

    @Override  // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void ensureCapacity$kotlinx_serialization_core(int v) {
        boolean[] arr_z = this.buffer;
        if(arr_z.length < v) {
            int v1 = arr_z.length * 2;
            if(v < v1) {
                v = v1;
            }
            boolean[] arr_z1 = Arrays.copyOf(arr_z, v);
            q.f(arr_z1, "copyOf(...)");
            this.buffer = arr_z1;
        }
    }

    @Override  // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int getPosition$kotlinx_serialization_core() {
        return this.position;
    }
}

