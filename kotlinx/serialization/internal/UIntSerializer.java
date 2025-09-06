package kotlinx.serialization.internal;

import ie.x;
import kotlin.Metadata;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001F\u0010\u000B\u001A\u00020\b2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0010\u001A\u00020\u00022\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0012\u001A\u00020\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lkotlinx/serialization/internal/UIntSerializer;", "Lkotlinx/serialization/KSerializer;", "Lie/x;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize-Qn1smSk", "(Lkotlinx/serialization/encoding/Encoder;I)V", "serialize", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize-OGnWXxg", "(Lkotlinx/serialization/encoding/Decoder;)I", "deserialize", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class UIntSerializer implements KSerializer {
    @NotNull
    public static final UIntSerializer INSTANCE;
    @NotNull
    private static final SerialDescriptor descriptor;

    static {
        UIntSerializer.INSTANCE = new UIntSerializer();
        UIntSerializer.descriptor = InlineClassDescriptorKt.InlinePrimitiveDescriptor("kotlin.UInt", BuiltinSerializersKt.serializer(o.a));
    }

    @Override  // kotlinx.serialization.DeserializationStrategy
    public Object deserialize(Decoder decoder0) {
        return new x(this.deserialize-OGnWXxg(decoder0));
    }

    public int deserialize-OGnWXxg(@NotNull Decoder decoder0) {
        q.g(decoder0, "decoder");
        return decoder0.decodeInline(this.getDescriptor()).decodeInt();
    }

    @Override  // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return UIntSerializer.descriptor;
    }

    @Override  // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder0, Object object0) {
        this.serialize-Qn1smSk(encoder0, ((x)object0).a);
    }

    public void serialize-Qn1smSk(@NotNull Encoder encoder0, int v) {
        q.g(encoder0, "encoder");
        encoder0.encodeInline(this.getDescriptor()).encodeInt(v);
    }
}

