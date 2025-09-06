package kotlinx.serialization;

import i.n.i.b.a.s.e.M3;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.AbstractPolymorphicSerializerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A4\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\bH\u0007\u001A7\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u0002H\u0002H\u0007¢\u0006\u0002\u0010\r¨\u0006\u000E"}, d2 = {"findPolymorphicSerializer", "Lkotlinx/serialization/DeserializationStrategy;", "T", "", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "klassName", "", "Lkotlinx/serialization/SerializationStrategy;", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class PolymorphicSerializerKt {
    @NotNull
    public static final DeserializationStrategy findPolymorphicSerializer(@NotNull AbstractPolymorphicSerializer abstractPolymorphicSerializer0, @NotNull CompositeDecoder compositeDecoder0, @Nullable String s) {
        q.g(abstractPolymorphicSerializer0, "<this>");
        q.g(compositeDecoder0, "decoder");
        DeserializationStrategy deserializationStrategy0 = abstractPolymorphicSerializer0.findPolymorphicSerializerOrNull(compositeDecoder0, s);
        if(deserializationStrategy0 != null) {
            return deserializationStrategy0;
        }
        AbstractPolymorphicSerializerKt.throwSubtypeNotRegistered(s, abstractPolymorphicSerializer0.getBaseClass());
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @NotNull
    public static final SerializationStrategy findPolymorphicSerializer(@NotNull AbstractPolymorphicSerializer abstractPolymorphicSerializer0, @NotNull Encoder encoder0, @NotNull Object object0) {
        q.g(abstractPolymorphicSerializer0, "<this>");
        q.g(encoder0, "encoder");
        q.g(object0, "value");
        SerializationStrategy serializationStrategy0 = abstractPolymorphicSerializer0.findPolymorphicSerializerOrNull(encoder0, object0);
        if(serializationStrategy0 != null) {
            return serializationStrategy0;
        }
        Class class0 = object0.getClass();
        AbstractPolymorphicSerializerKt.throwSubtypeNotRegistered(I.a.b(class0), abstractPolymorphicSerializer0.getBaseClass());
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }
}

