package kotlinx.serialization.internal;

import De.d;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder.DefaultImpls;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\t\b\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001A\u00028\u00002\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001D\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00028\u0000¢\u0006\u0004\b\u000E\u0010\u000FJ\u0015\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0011\u001A\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0017\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00162\u0006\u0010\u0011\u001A\u00020\u00062\b\u0010\u0015\u001A\u0004\u0018\u00010\u0014H\u0017¢\u0006\u0004\b\u0017\u0010\u0018J\'\u0010\u0017\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00192\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00028\u0000H\u0017¢\u0006\u0004\b\u0017\u0010\u001AR\u001A\u0010\u001E\u001A\b\u0012\u0004\u0012\u00028\u00000\u001B8&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001D¨\u0006\u001F"}, d2 = {"Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "", "T", "Lkotlinx/serialization/KSerializer;", "<init>", "()V", "Lkotlinx/serialization/encoding/CompositeDecoder;", "compositeDecoder", "decodeSequentially", "(Lkotlinx/serialization/encoding/CompositeDecoder;)Ljava/lang/Object;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "", "klassName", "Lkotlinx/serialization/DeserializationStrategy;", "findPolymorphicSerializerOrNull", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/String;)Lkotlinx/serialization/DeserializationStrategy;", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "LDe/d;", "getBaseClass", "()LDe/d;", "baseClass", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public abstract class AbstractPolymorphicSerializer implements KSerializer {
    private final Object decodeSequentially(CompositeDecoder compositeDecoder0) {
        DeserializationStrategy deserializationStrategy0 = PolymorphicSerializerKt.findPolymorphicSerializer(this, compositeDecoder0, compositeDecoder0.decodeStringElement(this.getDescriptor(), 0));
        return DefaultImpls.decodeSerializableElement$default(compositeDecoder0, this.getDescriptor(), 1, deserializationStrategy0, null, 8, null);
    }

    @Override  // kotlinx.serialization.DeserializationStrategy
    @NotNull
    public final Object deserialize(@NotNull Decoder decoder0) {
        Object object0;
        q.g(decoder0, "decoder");
        SerialDescriptor serialDescriptor0 = this.getDescriptor();
        CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
        if(compositeDecoder0.decodeSequentially()) {
            object0 = this.decodeSequentially(compositeDecoder0);
            compositeDecoder0.endStructure(serialDescriptor0);
            return object0;
        }
        object0 = null;
        String s = null;
        while(true) {
            int v = compositeDecoder0.decodeElementIndex(this.getDescriptor());
            switch(v) {
                case -1: {
                    if(object0 == null) {
                        throw new IllegalArgumentException(("Polymorphic value has not been read for class " + s).toString());
                    }
                    compositeDecoder0.endStructure(serialDescriptor0);
                    return object0;
                }
                case 0: {
                    s = compositeDecoder0.decodeStringElement(this.getDescriptor(), 0);
                    break;
                }
                default: {
                    if(v != 1) {
                        StringBuilder stringBuilder0 = new StringBuilder("Invalid index in polymorphic deserialization of ");
                        if(s == null) {
                            s = "unknown class";
                        }
                        stringBuilder0.append(s);
                        stringBuilder0.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                        stringBuilder0.append(v);
                        throw new SerializationException(stringBuilder0.toString());
                    }
                    if(s == null) {
                        throw new IllegalArgumentException("Cannot read polymorphic value before its type token");
                    }
                    DeserializationStrategy deserializationStrategy0 = PolymorphicSerializerKt.findPolymorphicSerializer(this, compositeDecoder0, s);
                    object0 = DefaultImpls.decodeSerializableElement$default(compositeDecoder0, this.getDescriptor(), 1, deserializationStrategy0, null, 8, null);
                    break;
                }
            }
        }
    }

    @Nullable
    public DeserializationStrategy findPolymorphicSerializerOrNull(@NotNull CompositeDecoder compositeDecoder0, @Nullable String s) {
        q.g(compositeDecoder0, "decoder");
        return compositeDecoder0.getSerializersModule().getPolymorphic(this.getBaseClass(), s);
    }

    @Nullable
    public SerializationStrategy findPolymorphicSerializerOrNull(@NotNull Encoder encoder0, @NotNull Object object0) {
        q.g(encoder0, "encoder");
        q.g(object0, "value");
        return encoder0.getSerializersModule().getPolymorphic(this.getBaseClass(), object0);
    }

    @NotNull
    public abstract d getBaseClass();

    @Override  // kotlinx.serialization.SerializationStrategy
    public final void serialize(@NotNull Encoder encoder0, @NotNull Object object0) {
        q.g(encoder0, "encoder");
        q.g(object0, "value");
        SerializationStrategy serializationStrategy0 = PolymorphicSerializerKt.findPolymorphicSerializer(this, encoder0, object0);
        SerialDescriptor serialDescriptor0 = this.getDescriptor();
        CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
        compositeEncoder0.encodeStringElement(this.getDescriptor(), 0, serializationStrategy0.getDescriptor().getSerialName());
        compositeEncoder0.encodeSerializableElement(this.getDescriptor(), 1, serializationStrategy0, object0);
        compositeEncoder0.endStructure(serialDescriptor0);
    }
}

