package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0017\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0003\u001A\u00020\u0002H&\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\r\u001A\u00020\n2\u0006\u0010\u0003\u001A\u00020\u0002H\u0016\u00A2\u0006\u0004\b\r\u0010\fJ\u001F\u0010\u000F\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\nH&\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\nH&\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u001F\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\nH&\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u001F\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\nH&\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u001F\u0010\u001A\u001A\u00020\n2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\nH&\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u001F\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\nH&\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u001F\u0010 \u001A\u00020\u001F2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\nH&\u00A2\u0006\u0004\b \u0010!J\u001F\u0010#\u001A\u00020\"2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\nH&\u00A2\u0006\u0004\b#\u0010$J\u001F\u0010&\u001A\u00020%2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\nH&\u00A2\u0006\u0004\b&\u0010\'J\u001F\u0010)\u001A\u00020(2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\nH&\u00A2\u0006\u0004\b)\u0010*JE\u0010/\u001A\u00028\u0000\"\n\b\u0000\u0010+*\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\n2\f\u0010-\u001A\b\u0012\u0004\u0012\u00028\u00000,2\n\b\u0002\u0010.\u001A\u0004\u0018\u00018\u0000H&\u00A2\u0006\u0004\b/\u00100JG\u00101\u001A\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010+*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\n2\u000E\u0010-\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000,2\n\b\u0002\u0010.\u001A\u0004\u0018\u00018\u0000H\'\u00A2\u0006\u0004\b1\u00100R\u0014\u00105\u001A\u0002028&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b3\u00104\u00A8\u00066"}, d2 = {"Lkotlinx/serialization/encoding/CompositeDecoder;", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lie/H;", "endStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "decodeSequentially", "()Z", "", "decodeElementIndex", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "decodeCollectionSize", "index", "decodeBooleanElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "", "decodeByteElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)B", "", "decodeCharElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)C", "", "decodeShortElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)S", "decodeIntElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)I", "", "decodeLongElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)J", "", "decodeFloatElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)F", "", "decodeDoubleElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)D", "", "decodeStringElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/String;", "Lkotlinx/serialization/encoding/Decoder;", "decodeInlineElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Lkotlinx/serialization/encoding/Decoder;", "T", "Lkotlinx/serialization/DeserializationStrategy;", "deserializer", "previousValue", "decodeSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeNullableSerializableElement", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public interface CompositeDecoder {
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 0x30)
    public static abstract class DefaultImpls {
        public static int decodeCollectionSize(@NotNull CompositeDecoder compositeDecoder0, @NotNull SerialDescriptor serialDescriptor0) {
            q.g(serialDescriptor0, "descriptor");
            return -1;
        }

        public static boolean decodeSequentially(@NotNull CompositeDecoder compositeDecoder0) [...] // Inlined contents

        public static Object decodeSerializableElement$default(CompositeDecoder compositeDecoder0, SerialDescriptor serialDescriptor0, int v, DeserializationStrategy deserializationStrategy0, Object object0, int v1, Object object1) {
            if(object1 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableElement");
            }
            if((v1 & 8) != 0) {
                object0 = null;
            }
            return compositeDecoder0.decodeSerializableElement(serialDescriptor0, v, deserializationStrategy0, object0);
        }
    }

    boolean decodeBooleanElement(@NotNull SerialDescriptor arg1, int arg2);

    byte decodeByteElement(@NotNull SerialDescriptor arg1, int arg2);

    char decodeCharElement(@NotNull SerialDescriptor arg1, int arg2);

    int decodeCollectionSize(@NotNull SerialDescriptor arg1);

    double decodeDoubleElement(@NotNull SerialDescriptor arg1, int arg2);

    int decodeElementIndex(@NotNull SerialDescriptor arg1);

    float decodeFloatElement(@NotNull SerialDescriptor arg1, int arg2);

    @NotNull
    Decoder decodeInlineElement(@NotNull SerialDescriptor arg1, int arg2);

    int decodeIntElement(@NotNull SerialDescriptor arg1, int arg2);

    long decodeLongElement(@NotNull SerialDescriptor arg1, int arg2);

    @Nullable
    Object decodeNullableSerializableElement(@NotNull SerialDescriptor arg1, int arg2, @NotNull DeserializationStrategy arg3, @Nullable Object arg4);

    boolean decodeSequentially();

    Object decodeSerializableElement(@NotNull SerialDescriptor arg1, int arg2, @NotNull DeserializationStrategy arg3, @Nullable Object arg4);

    short decodeShortElement(@NotNull SerialDescriptor arg1, int arg2);

    @NotNull
    String decodeStringElement(@NotNull SerialDescriptor arg1, int arg2);

    void endStructure(@NotNull SerialDescriptor arg1);

    @NotNull
    SerializersModule getSerializersModule();
}

