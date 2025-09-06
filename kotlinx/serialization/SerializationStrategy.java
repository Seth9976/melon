package kotlinx.serialization;

import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00028\u0000H&¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001A\u00020\t8&X¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006\r"}, d2 = {"Lkotlinx/serialization/SerializationStrategy;", "T", "", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public interface SerializationStrategy {
    @NotNull
    SerialDescriptor getDescriptor();

    void serialize(@NotNull Encoder arg1, Object arg2);
}

