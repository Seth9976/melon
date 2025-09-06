package kotlinx.serialization.internal;

import Tf.d;
import Vf.b;
import h7.u0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind.STRING;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\r\u0010\u000ER\u001A\u0010\u0010\u001A\u00020\u000F8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkotlinx/serialization/internal/UuidSerializer;", "Lkotlinx/serialization/KSerializer;", "LVf/b;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;LVf/b;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)LVf/b;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class UuidSerializer implements KSerializer {
    @NotNull
    public static final UuidSerializer INSTANCE;
    @NotNull
    private static final SerialDescriptor descriptor;

    static {
        UuidSerializer.INSTANCE = new UuidSerializer();
        UuidSerializer.descriptor = new PrimitiveSerialDescriptor("kotlin.uuid.Uuid", STRING.INSTANCE);
    }

    @NotNull
    public b deserialize(@NotNull Decoder decoder0) {
        String s1;
        q.g(decoder0, "decoder");
        String s = decoder0.decodeString();
        q.g(s, "uuidString");
        switch(s.length()) {
            case 0x20: {
                long v = d.b(0, 16, s);
                long v1 = d.b(16, 0x20, s);
                return v != 0L || v1 != 0L ? new b(v, v1) : b.d;
            }
            case 36: {
                long v2 = d.b(0, 8, s);
                u0.k(8, s);
                long v3 = d.b(9, 13, s);
                u0.k(13, s);
                long v4 = d.b(14, 18, s);
                u0.k(18, s);
                long v5 = d.b(19, 23, s);
                u0.k(23, s);
                long v6 = v3 << 16 | v2 << 0x20 | v4;
                long v7 = d.b(24, 36, s) | v5 << 0x30;
                return v6 == 0L && v7 == 0L ? b.d : new b(v6, v7);
            }
            default: {
                StringBuilder stringBuilder0 = new StringBuilder("Expected either a 36-char string in the standard hex-and-dash UUID format or a 32-char hexadecimal string, but was \"");
                if(s.length() <= 0x40) {
                    s1 = s;
                }
                else {
                    String s2 = s.substring(0, 0x40);
                    q.f(s2, "substring(...)");
                    s1 = s2 + "...";
                }
                stringBuilder0.append(s1);
                stringBuilder0.append("\" of length ");
                stringBuilder0.append(s.length());
                throw new IllegalArgumentException(stringBuilder0.toString());
            }
        }
    }

    @Override  // kotlinx.serialization.DeserializationStrategy
    public Object deserialize(Decoder decoder0) {
        return this.deserialize(decoder0);
    }

    @Override  // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return UuidSerializer.descriptor;
    }

    public void serialize(@NotNull Encoder encoder0, @NotNull b b0) {
        q.g(encoder0, "encoder");
        q.g(b0, "value");
        encoder0.encodeString(b0.toString());
    }

    @Override  // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder0, Object object0) {
        this.serialize(encoder0, ((b)object0));
    }
}

