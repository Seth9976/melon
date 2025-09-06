package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u000B\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0010¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000E\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u0006H\u0000¢\u0006\u0004\b\r\u0010\nJ\u000F\u0010\u0011\u001A\u00020\u0002H\u0010¢\u0006\u0004\b\u000F\u0010\u0010R\u0016\u0010\u0012\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001A\u00020\u00062\u0006\u0010\u0014\u001A\u00020\u00068\u0010@RX\u0090\u000E¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lkotlinx/serialization/internal/IntArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "<init>", "([I)V", "", "requiredCapacity", "Lie/H;", "ensureCapacity$kotlinx_serialization_core", "(I)V", "ensureCapacity", "c", "append$kotlinx_serialization_core", "append", "build$kotlinx_serialization_core", "()[I", "build", "buffer", "[I", "value", "position", "I", "getPosition$kotlinx_serialization_core", "()I", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class IntArrayBuilder extends PrimitiveArrayBuilder {
    @NotNull
    private int[] buffer;
    private int position;

    public IntArrayBuilder(@NotNull int[] arr_v) {
        q.g(arr_v, "bufferWithData");
        super();
        this.buffer = arr_v;
        this.position = arr_v.length;
        this.ensureCapacity$kotlinx_serialization_core(10);
    }

    public final void append$kotlinx_serialization_core(int v) {
        PrimitiveArrayBuilder.ensureCapacity$kotlinx_serialization_core$default(this, 0, 1, null);
        int v1 = this.getPosition$kotlinx_serialization_core();
        this.position = v1 + 1;
        this.buffer[v1] = v;
    }

    @Override  // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public Object build$kotlinx_serialization_core() {
        return this.build$kotlinx_serialization_core();
    }

    @NotNull
    public int[] build$kotlinx_serialization_core() {
        int[] arr_v = Arrays.copyOf(this.buffer, this.getPosition$kotlinx_serialization_core());
        q.f(arr_v, "copyOf(...)");
        return arr_v;
    }

    @Override  // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void ensureCapacity$kotlinx_serialization_core(int v) {
        int[] arr_v = this.buffer;
        if(arr_v.length < v) {
            int v1 = arr_v.length * 2;
            if(v < v1) {
                v = v1;
            }
            int[] arr_v1 = Arrays.copyOf(arr_v, v);
            q.f(arr_v1, "copyOf(...)");
            this.buffer = arr_v1;
        }
    }

    @Override  // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int getPosition$kotlinx_serialization_core() {
        return this.position;
    }
}

