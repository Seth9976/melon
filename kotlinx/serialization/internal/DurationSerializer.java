package kotlinx.serialization.internal;

import Uf.b;
import Uf.d;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind.STRING;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;
import x1.a;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001F\u0010\u000B\u001A\u00020\b2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0010\u001A\u00020\u00022\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0012\u001A\u00020\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lkotlinx/serialization/internal/DurationSerializer;", "Lkotlinx/serialization/KSerializer;", "LUf/b;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize-HG0u8IE", "(Lkotlinx/serialization/encoding/Encoder;J)V", "serialize", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize-5sfh64U", "(Lkotlinx/serialization/encoding/Decoder;)J", "deserialize", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class DurationSerializer implements KSerializer {
    @NotNull
    public static final DurationSerializer INSTANCE;
    @NotNull
    private static final SerialDescriptor descriptor;

    static {
        DurationSerializer.INSTANCE = new DurationSerializer();
        DurationSerializer.descriptor = new PrimitiveSerialDescriptor("kotlin.time.Duration", STRING.INSTANCE);
    }

    @Override  // kotlinx.serialization.DeserializationStrategy
    public Object deserialize(Decoder decoder0) {
        return new b(this.deserialize-5sfh64U(decoder0));
    }

    public long deserialize-5sfh64U(@NotNull Decoder decoder0) {
        q.g(decoder0, "decoder");
        String s = decoder0.decodeString();
        q.g(s, "value");
        try {
            return a.k(s);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            throw new IllegalArgumentException("Invalid ISO duration string format: \'" + s + "\'.", illegalArgumentException0);
        }
    }

    @Override  // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return DurationSerializer.descriptor;
    }

    @Override  // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder0, Object object0) {
        this.serialize-HG0u8IE(encoder0, ((b)object0).a);
    }

    public void serialize-HG0u8IE(@NotNull Encoder encoder0, long v) {
        q.g(encoder0, "encoder");
        StringBuilder stringBuilder0 = new StringBuilder();
        int v1 = Long.compare(v, 0L);
        if(v1 < 0) {
            stringBuilder0.append('-');
        }
        stringBuilder0.append("PT");
        long v2 = v1 >= 0 ? v : b.k(v);
        long v3 = b.i(v2, d.f);
        boolean z = false;
        int v4 = b.g(v2) ? 0 : ((int)(b.i(v2, d.e) % 60L));
        int v5 = b.g(v2) ? 0 : ((int)(b.i(v2, d.d) % 60L));
        int v6 = b.f(v2);
        if(b.g(v)) {
            v3 = 0x9184E729FFFL;
        }
        boolean z1 = Long.compare(v3, 0L) != 0;
        boolean z2 = v5 != 0 || v6 != 0;
        if(v4 != 0 || z2 && z1) {
            z = true;
        }
        if(z1) {
            stringBuilder0.append(v3);
            stringBuilder0.append('H');
        }
        if(z) {
            stringBuilder0.append(v4);
            stringBuilder0.append('M');
        }
        if(z2 || !z1 && !z) {
            b.b(stringBuilder0, v5, v6, 9, "S", true);
        }
        encoder0.encodeString(stringBuilder0.toString());
    }
}

