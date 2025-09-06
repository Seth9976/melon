package kotlinx.serialization.internal;

import ie.H;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\b\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u0002H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\nH\u0096\u0001¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001A\u00020\u000E8\u0016X\u0096\u0005¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0012"}, d2 = {"Lkotlinx/serialization/internal/UnitSerializer;", "Lkotlinx/serialization/KSerializer;", "Lie/H;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lie/H;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class UnitSerializer implements KSerializer {
    private final ObjectSerializer $$delegate_0;
    @NotNull
    public static final UnitSerializer INSTANCE;

    static {
        UnitSerializer.INSTANCE = new UnitSerializer();
    }

    private UnitSerializer() {
        this.$$delegate_0 = new ObjectSerializer("kotlin.Unit", H.a);
    }

    @Override  // kotlinx.serialization.DeserializationStrategy
    public Object deserialize(Decoder decoder0) {
        this.deserialize(decoder0);
        return H.a;
    }

    public void deserialize(@NotNull Decoder decoder0) {
        q.g(decoder0, "decoder");
        this.$$delegate_0.deserialize(decoder0);
    }

    @Override  // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.$$delegate_0.getDescriptor();
    }

    public void serialize(@NotNull Encoder encoder0, @NotNull H h0) {
        q.g(encoder0, "encoder");
        q.g(h0, "value");
        this.$$delegate_0.serialize(encoder0, h0);
    }

    @Override  // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder0, Object object0) {
        this.serialize(encoder0, ((H)object0));
    }
}

