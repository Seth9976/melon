package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\'¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001A\u0004\u0018\u00010\u0005H\'¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\b\u001A\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u000F\u0010\n\u001A\u00020\tH&¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH&¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\u000FH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0013\u001A\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0016\u001A\u00020\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0019\u001A\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001AJ\u000F\u0010\u001C\u001A\u00020\u001BH&¢\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001F\u001A\u00020\u001EH&¢\u0006\u0004\b\u001F\u0010 J\u0017\u0010#\u001A\u00020\u00122\u0006\u0010\"\u001A\u00020!H&¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001A\u00020\u00002\u0006\u0010%\u001A\u00020!H&¢\u0006\u0004\b&\u0010\'J\u0017\u0010)\u001A\u00020(2\u0006\u0010%\u001A\u00020!H&¢\u0006\u0004\b)\u0010*J)\u0010.\u001A\u00028\u0000\"\n\b\u0000\u0010+*\u0004\u0018\u00010\u00012\f\u0010-\u001A\b\u0012\u0004\u0012\u00028\u00000,H\u0016¢\u0006\u0004\b.\u0010/R\u0014\u00103\u001A\u0002008&X¦\u0004¢\u0006\u0006\u001A\u0004\b1\u00102¨\u00064"}, d2 = {"Lkotlinx/serialization/encoding/Decoder;", "", "", "decodeNotNullMark", "()Z", "", "decodeNull", "()Ljava/lang/Void;", "decodeBoolean", "", "decodeByte", "()B", "", "decodeShort", "()S", "", "decodeChar", "()C", "", "decodeInt", "()I", "", "decodeLong", "()J", "", "decodeFloat", "()F", "", "decodeDouble", "()D", "", "decodeString", "()Ljava/lang/String;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "enumDescriptor", "decodeEnum", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "descriptor", "decodeInline", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;", "T", "Lkotlinx/serialization/DeserializationStrategy;", "deserializer", "decodeSerializableValue", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public interface Decoder {
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 0x30)
    public static abstract class DefaultImpls {
        public static Object decodeSerializableValue(@NotNull Decoder decoder0, @NotNull DeserializationStrategy deserializationStrategy0) {
            q.g(deserializationStrategy0, "deserializer");
            return deserializationStrategy0.deserialize(decoder0);
        }
    }

    @NotNull
    CompositeDecoder beginStructure(@NotNull SerialDescriptor arg1);

    boolean decodeBoolean();

    byte decodeByte();

    char decodeChar();

    double decodeDouble();

    int decodeEnum(@NotNull SerialDescriptor arg1);

    float decodeFloat();

    @NotNull
    Decoder decodeInline(@NotNull SerialDescriptor arg1);

    int decodeInt();

    long decodeLong();

    boolean decodeNotNullMark();

    @Nullable
    Void decodeNull();

    Object decodeSerializableValue(@NotNull DeserializationStrategy arg1);

    short decodeShort();

    @NotNull
    String decodeString();

    @NotNull
    SerializersModule getSerializersModule();
}

