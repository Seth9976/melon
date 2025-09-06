package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0017\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0005\u001A\u00020\u0002H\'\u00A2\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001A\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0006H&\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000B\u001A\u00020\u00022\u0006\u0010\u0007\u001A\u00020\nH&\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000E\u001A\u00020\u00022\u0006\u0010\u0007\u001A\u00020\rH&\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0011\u001A\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0010H&\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0013H&\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001A\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0016H&\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001A\u001A\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0019H&\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001D\u001A\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u001CH&\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010 \u001A\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u001FH&\u00A2\u0006\u0004\b \u0010!J\u001F\u0010%\u001A\u00020\u00022\u0006\u0010#\u001A\u00020\"2\u0006\u0010$\u001A\u00020\u0013H&\u00A2\u0006\u0004\b%\u0010&J\u0017\u0010(\u001A\u00020\u00002\u0006\u0010\'\u001A\u00020\"H&\u00A2\u0006\u0004\b(\u0010)J\u0017\u0010+\u001A\u00020*2\u0006\u0010\'\u001A\u00020\"H&\u00A2\u0006\u0004\b+\u0010,J\u001F\u0010.\u001A\u00020*2\u0006\u0010\'\u001A\u00020\"2\u0006\u0010-\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b.\u0010/J1\u00103\u001A\u00020\u0002\"\n\b\u0000\u00100*\u0004\u0018\u00010\u00012\f\u00102\u001A\b\u0012\u0004\u0012\u00028\u0000012\u0006\u0010\u0007\u001A\u00028\u0000H\u0016\u00A2\u0006\u0004\b3\u00104R\u0014\u00108\u001A\u0002058&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b6\u00107\u00A8\u00069"}, d2 = {"Lkotlinx/serialization/encoding/Encoder;", "", "Lie/H;", "encodeNotNullMark", "()V", "encodeNull", "", "value", "encodeBoolean", "(Z)V", "", "encodeByte", "(B)V", "", "encodeShort", "(S)V", "", "encodeChar", "(C)V", "", "encodeInt", "(I)V", "", "encodeLong", "(J)V", "", "encodeFloat", "(F)V", "", "encodeDouble", "(D)V", "", "encodeString", "(Ljava/lang/String;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "enumDescriptor", "index", "encodeEnum", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "descriptor", "encodeInline", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeEncoder;", "collectionSize", "beginCollection", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Lkotlinx/serialization/encoding/CompositeEncoder;", "T", "Lkotlinx/serialization/SerializationStrategy;", "serializer", "encodeSerializableValue", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public interface Encoder {
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 0x30)
    public static abstract class DefaultImpls {
        @NotNull
        public static CompositeEncoder beginCollection(@NotNull Encoder encoder0, @NotNull SerialDescriptor serialDescriptor0, int v) {
            q.g(serialDescriptor0, "descriptor");
            return encoder0.beginStructure(serialDescriptor0);
        }

        public static void encodeNotNullMark(@NotNull Encoder encoder0) {
        }

        public static void encodeNullableSerializableValue(@NotNull Encoder encoder0, @NotNull SerializationStrategy serializationStrategy0, @Nullable Object object0) {
            q.g(serializationStrategy0, "serializer");
            if(serializationStrategy0.getDescriptor().isNullable()) {
                encoder0.encodeSerializableValue(serializationStrategy0, object0);
                return;
            }
            if(object0 == null) {
                encoder0.encodeNull();
                return;
            }
            encoder0.encodeNotNullMark();
            encoder0.encodeSerializableValue(serializationStrategy0, object0);
        }

        public static void encodeSerializableValue(@NotNull Encoder encoder0, @NotNull SerializationStrategy serializationStrategy0, Object object0) {
            q.g(serializationStrategy0, "serializer");
            serializationStrategy0.serialize(encoder0, object0);
        }
    }

    @NotNull
    CompositeEncoder beginCollection(@NotNull SerialDescriptor arg1, int arg2);

    @NotNull
    CompositeEncoder beginStructure(@NotNull SerialDescriptor arg1);

    void encodeBoolean(boolean arg1);

    void encodeByte(byte arg1);

    void encodeChar(char arg1);

    void encodeDouble(double arg1);

    void encodeEnum(@NotNull SerialDescriptor arg1, int arg2);

    void encodeFloat(float arg1);

    @NotNull
    Encoder encodeInline(@NotNull SerialDescriptor arg1);

    void encodeInt(int arg1);

    void encodeLong(long arg1);

    void encodeNotNullMark();

    void encodeNull();

    void encodeSerializableValue(@NotNull SerializationStrategy arg1, Object arg2);

    void encodeShort(short arg1);

    void encodeString(@NotNull String arg1);

    @NotNull
    SerializersModule getSerializersModule();
}

