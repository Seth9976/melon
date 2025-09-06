package kotlinx.serialization.internal;

import ie.E;
import kotlin.Metadata;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001F\u0010\u000B\u001A\u00020\b2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0010\u001A\u00020\u00022\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0012\u001A\u00020\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lkotlinx/serialization/internal/UShortSerializer;", "Lkotlinx/serialization/KSerializer;", "Lie/E;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize-i8woANY", "(Lkotlinx/serialization/encoding/Encoder;S)V", "serialize", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize-BwKQO78", "(Lkotlinx/serialization/encoding/Decoder;)S", "deserialize", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class UShortSerializer implements KSerializer {
    @NotNull
    public static final UShortSerializer INSTANCE;
    @NotNull
    private static final SerialDescriptor descriptor;

    static {
        UShortSerializer.INSTANCE = new UShortSerializer();
        UShortSerializer.descriptor = InlineClassDescriptorKt.InlinePrimitiveDescriptor("kotlin.UShort", BuiltinSerializersKt.serializer(L.a));
    }

    @Override  // kotlinx.serialization.DeserializationStrategy
    public Object deserialize(Decoder decoder0) {
        return new E(this.deserialize-BwKQO78(decoder0));
    }

    public short deserialize-BwKQO78(@NotNull Decoder decoder0) {
        q.g(decoder0, "decoder");
        return decoder0.decodeInline(this.getDescriptor()).decodeShort();
    }

    @Override  // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return UShortSerializer.descriptor;
    }

    @Override  // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder0, Object object0) {
        this.serialize-i8woANY(encoder0, ((E)object0).a);
    }

    public void serialize-i8woANY(@NotNull Encoder encoder0, short v) {
        q.g(encoder0, "encoder");
        encoder0.encodeInline(this.getDescriptor()).encodeShort(v);
    }
}

