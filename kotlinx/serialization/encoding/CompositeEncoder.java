package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u001F\u0010\n\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u0007H\u0017\u00A2\u0006\u0004\b\n\u0010\u000BJ\'\u0010\r\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\tH&\u00A2\u0006\u0004\b\r\u0010\u000EJ\'\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u000FH&\u00A2\u0006\u0004\b\u0010\u0010\u0011J\'\u0010\u0013\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u0012H&\u00A2\u0006\u0004\b\u0013\u0010\u0014J\'\u0010\u0016\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u0015H&\u00A2\u0006\u0004\b\u0016\u0010\u0017J\'\u0010\u0018\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u0007H&\u00A2\u0006\u0004\b\u0018\u0010\u0019J\'\u0010\u001B\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u001AH&\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\'\u0010\u001E\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u001DH&\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\'\u0010!\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020 H&\u00A2\u0006\u0004\b!\u0010\"J\'\u0010$\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020#H&\u00A2\u0006\u0004\b$\u0010%J\u001F\u0010\'\u001A\u00020&2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u0007H&\u00A2\u0006\u0004\b\'\u0010(JA\u0010,\u001A\u00020\u0004\"\n\b\u0000\u0010)*\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u00072\f\u0010+\u001A\b\u0012\u0004\u0012\u00028\u00000*2\u0006\u0010\f\u001A\u00028\u0000H&\u00A2\u0006\u0004\b,\u0010-JA\u0010.\u001A\u00020\u0004\"\b\b\u0000\u0010)*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u00072\f\u0010+\u001A\b\u0012\u0004\u0012\u00028\u00000*2\b\u0010\f\u001A\u0004\u0018\u00018\u0000H\'\u00A2\u0006\u0004\b.\u0010-\u00A8\u0006/"}, d2 = {"Lkotlinx/serialization/encoding/CompositeEncoder;", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lie/H;", "endStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "index", "", "shouldEncodeElementDefault", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "value", "encodeBooleanElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IZ)V", "", "encodeByteElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IB)V", "", "encodeShortElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IS)V", "", "encodeCharElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IC)V", "encodeIntElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;II)V", "", "encodeLongElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IJ)V", "", "encodeFloatElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IF)V", "", "encodeDoubleElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ID)V", "", "encodeStringElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILjava/lang/String;)V", "Lkotlinx/serialization/encoding/Encoder;", "encodeInlineElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Lkotlinx/serialization/encoding/Encoder;", "T", "Lkotlinx/serialization/SerializationStrategy;", "serializer", "encodeSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeNullableSerializableElement", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public interface CompositeEncoder {
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 0x30)
    public static abstract class DefaultImpls {
        public static boolean shouldEncodeElementDefault(@NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0, int v) {
            q.g(serialDescriptor0, "descriptor");
            return true;
        }
    }

    void encodeBooleanElement(@NotNull SerialDescriptor arg1, int arg2, boolean arg3);

    void encodeByteElement(@NotNull SerialDescriptor arg1, int arg2, byte arg3);

    void encodeCharElement(@NotNull SerialDescriptor arg1, int arg2, char arg3);

    void encodeDoubleElement(@NotNull SerialDescriptor arg1, int arg2, double arg3);

    void encodeFloatElement(@NotNull SerialDescriptor arg1, int arg2, float arg3);

    @NotNull
    Encoder encodeInlineElement(@NotNull SerialDescriptor arg1, int arg2);

    void encodeIntElement(@NotNull SerialDescriptor arg1, int arg2, int arg3);

    void encodeLongElement(@NotNull SerialDescriptor arg1, int arg2, long arg3);

    void encodeNullableSerializableElement(@NotNull SerialDescriptor arg1, int arg2, @NotNull SerializationStrategy arg3, @Nullable Object arg4);

    void encodeSerializableElement(@NotNull SerialDescriptor arg1, int arg2, @NotNull SerializationStrategy arg3, Object arg4);

    void encodeShortElement(@NotNull SerialDescriptor arg1, int arg2, short arg3);

    void encodeStringElement(@NotNull SerialDescriptor arg1, int arg2, @NotNull String arg3);

    void endStructure(@NotNull SerialDescriptor arg1);

    boolean shouldEncodeElementDefault(@NotNull SerialDescriptor arg1, int arg2);
}

