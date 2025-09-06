package kotlinx.serialization.internal;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b!\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\t\b\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\n\u001A\u00020\u00072\b\b\u0002\u0010\u0006\u001A\u00020\u0005H ¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\r\u001A\u00028\u0000H ¢\u0006\u0004\b\u000B\u0010\fR\u0014\u0010\u0010\u001A\u00020\u00058 X \u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0011"}, d2 = {"Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "Array", "", "<init>", "()V", "", "requiredCapacity", "Lie/H;", "ensureCapacity$kotlinx_serialization_core", "(I)V", "ensureCapacity", "build$kotlinx_serialization_core", "()Ljava/lang/Object;", "build", "getPosition$kotlinx_serialization_core", "()I", "position", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public abstract class PrimitiveArrayBuilder {
    public abstract Object build$kotlinx_serialization_core();

    public abstract void ensureCapacity$kotlinx_serialization_core(int arg1);

    public static void ensureCapacity$kotlinx_serialization_core$default(PrimitiveArrayBuilder primitiveArrayBuilder0, int v, int v1, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ensureCapacity");
        }
        if((v1 & 1) != 0) {
            v = primitiveArrayBuilder0.getPosition$kotlinx_serialization_core() + 1;
        }
        primitiveArrayBuilder0.ensureCapacity$kotlinx_serialization_core(v);
    }

    public abstract int getPosition$kotlinx_serialization_core();
}

