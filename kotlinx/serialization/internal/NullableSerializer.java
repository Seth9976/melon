package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0003B\u0015\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000B\u001A\u00020\n2\u0006\u0010\b\u001A\u00020\u00072\b\u0010\t\u001A\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u0019\u0010\u000F\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u000E\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u001A\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0018R\u001A\u0010\u001A\u001A\u00020\u00198\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u001D¨\u0006\u001E"}, d2 = {"Lkotlinx/serialization/internal/NullableSerializer;", "", "T", "Lkotlinx/serialization/KSerializer;", "serializer", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class NullableSerializer implements KSerializer {
    @NotNull
    private final SerialDescriptor descriptor;
    @NotNull
    private final KSerializer serializer;

    public NullableSerializer(@NotNull KSerializer kSerializer0) {
        q.g(kSerializer0, "serializer");
        super();
        this.serializer = kSerializer0;
        this.descriptor = new SerialDescriptorForNullable(kSerializer0.getDescriptor());
    }

    @Override  // kotlinx.serialization.DeserializationStrategy
    @Nullable
    public Object deserialize(@NotNull Decoder decoder0) {
        q.g(decoder0, "decoder");
        return decoder0.decodeNotNullMark() ? decoder0.decodeSerializableValue(this.serializer) : decoder0.decodeNull();
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return NullableSerializer.class == class0 && q.b(this.serializer, ((NullableSerializer)object0).serializer);
        }
        return false;
    }

    @Override  // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override
    public int hashCode() {
        return this.serializer.hashCode();
    }

    @Override  // kotlinx.serialization.SerializationStrategy
    public void serialize(@NotNull Encoder encoder0, @Nullable Object object0) {
        q.g(encoder0, "encoder");
        if(object0 != null) {
            encoder0.encodeNotNullMark();
            encoder0.encodeSerializableValue(this.serializer, object0);
            return;
        }
        encoder0.encodeNull();
    }
}

