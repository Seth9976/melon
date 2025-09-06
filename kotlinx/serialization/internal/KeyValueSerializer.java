package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder.DefaultImpls;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u00028\u00020\u0004B%\b\u0004\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\u000B\u001A\u00028\u00022\u0006\u0010\t\u001A\u00028\u00002\u0006\u0010\n\u001A\u00028\u0001H$¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\n\u001A\u00028\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001A\u00028\u00022\u0006\u0010\u0013\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R \u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018R \u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00010\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001A\u0004\b\u0019\u0010\u0018R\u0018\u0010\t\u001A\u00028\u0000*\u00028\u00028$X¤\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001BR\u0018\u0010\n\u001A\u00028\u0001*\u00028\u00028$X¤\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001B\u0082\u0001\u0002\u001D\u001E¨\u0006\u001F"}, d2 = {"Lkotlinx/serialization/internal/KeyValueSerializer;", "K", "V", "R", "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "key", "value", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "Lkotlinx/serialization/KSerializer;", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "getValueSerializer", "getKey", "(Ljava/lang/Object;)Ljava/lang/Object;", "getValue", "Lkotlinx/serialization/internal/MapEntrySerializer;", "Lkotlinx/serialization/internal/PairSerializer;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public abstract class KeyValueSerializer implements KSerializer {
    @NotNull
    private final KSerializer keySerializer;
    @NotNull
    private final KSerializer valueSerializer;

    private KeyValueSerializer(KSerializer kSerializer0, KSerializer kSerializer1) {
        this.keySerializer = kSerializer0;
        this.valueSerializer = kSerializer1;
    }

    public KeyValueSerializer(KSerializer kSerializer0, KSerializer kSerializer1, DefaultConstructorMarker defaultConstructorMarker0) {
        this(kSerializer0, kSerializer1);
    }

    @Override  // kotlinx.serialization.DeserializationStrategy
    public Object deserialize(@NotNull Decoder decoder0) {
        Object object0;
        q.g(decoder0, "decoder");
        SerialDescriptor serialDescriptor0 = this.getDescriptor();
        CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
        if(compositeDecoder0.decodeSequentially()) {
            object0 = this.toResult(DefaultImpls.decodeSerializableElement$default(compositeDecoder0, this.getDescriptor(), 0, this.getKeySerializer(), null, 8, null), DefaultImpls.decodeSerializableElement$default(compositeDecoder0, this.getDescriptor(), 1, this.getValueSerializer(), null, 8, null));
            compositeDecoder0.endStructure(serialDescriptor0);
            return object0;
        }
        Object object1 = TuplesKt.access$getNULL$p();
        Object object2 = TuplesKt.access$getNULL$p();
        while(true) {
            int v = compositeDecoder0.decodeElementIndex(this.getDescriptor());
            switch(v) {
                case -1: {
                    if(object1 == TuplesKt.access$getNULL$p()) {
                        throw new SerializationException("Element \'key\' is missing");
                    }
                    if(object2 == TuplesKt.access$getNULL$p()) {
                        throw new SerializationException("Element \'value\' is missing");
                    }
                    object0 = this.toResult(object1, object2);
                    compositeDecoder0.endStructure(serialDescriptor0);
                    return object0;
                }
                case 0: {
                    object1 = DefaultImpls.decodeSerializableElement$default(compositeDecoder0, this.getDescriptor(), 0, this.getKeySerializer(), null, 8, null);
                    break;
                }
                default: {
                    if(v != 1) {
                        throw new SerializationException("Invalid index: " + v);
                    }
                    object2 = DefaultImpls.decodeSerializableElement$default(compositeDecoder0, this.getDescriptor(), 1, this.getValueSerializer(), null, 8, null);
                    break;
                }
            }
        }
    }

    public abstract Object getKey(Object arg1);

    @NotNull
    public final KSerializer getKeySerializer() {
        return this.keySerializer;
    }

    public abstract Object getValue(Object arg1);

    @NotNull
    public final KSerializer getValueSerializer() {
        return this.valueSerializer;
    }

    @Override  // kotlinx.serialization.SerializationStrategy
    public void serialize(@NotNull Encoder encoder0, Object object0) {
        q.g(encoder0, "encoder");
        CompositeEncoder compositeEncoder0 = encoder0.beginStructure(this.getDescriptor());
        SerialDescriptor serialDescriptor0 = this.getDescriptor();
        Object object1 = this.getKey(object0);
        compositeEncoder0.encodeSerializableElement(serialDescriptor0, 0, this.keySerializer, object1);
        SerialDescriptor serialDescriptor1 = this.getDescriptor();
        Object object2 = this.getValue(object0);
        compositeEncoder0.encodeSerializableElement(serialDescriptor1, 1, this.valueSerializer, object2);
        compositeEncoder0.endStructure(this.getDescriptor());
    }

    public abstract Object toResult(Object arg1, Object arg2);
}

