package kotlinx.serialization.descriptors;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H\u0016J\b\u0010\u0006\u001A\u00020\u0007H\u0016\u0082\u0001\u0005\n\u000B\f\r\u000E¨\u0006\u000F"}, d2 = {"Lkotlinx/serialization/descriptors/SerialKind;", "", "<init>", "()V", "toString", "", "hashCode", "", "ENUM", "CONTEXTUAL", "Lkotlinx/serialization/descriptors/PolymorphicKind;", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "Lkotlinx/serialization/descriptors/SerialKind$CONTEXTUAL;", "Lkotlinx/serialization/descriptors/SerialKind$ENUM;", "Lkotlinx/serialization/descriptors/StructureKind;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public abstract class SerialKind {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/serialization/descriptors/SerialKind$CONTEXTUAL;", "Lkotlinx/serialization/descriptors/SerialKind;", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
    public static final class CONTEXTUAL extends SerialKind {
        @NotNull
        public static final CONTEXTUAL INSTANCE;

        static {
            CONTEXTUAL.INSTANCE = new CONTEXTUAL();
        }

        private CONTEXTUAL() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/serialization/descriptors/SerialKind$ENUM;", "Lkotlinx/serialization/descriptors/SerialKind;", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
    public static final class ENUM extends SerialKind {
        @NotNull
        public static final ENUM INSTANCE;

        static {
            ENUM.INSTANCE = new ENUM();
        }

        private ENUM() {
            super(null);
        }
    }

    private SerialKind() {
    }

    public SerialKind(DefaultConstructorMarker defaultConstructorMarker0) {
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        Class class0 = this.getClass();
        String s = I.a.b(class0).m();
        q.d(s);
        return s;
    }
}

