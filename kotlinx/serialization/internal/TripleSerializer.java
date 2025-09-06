package kotlinx.serialization.internal;

import dd.z;
import ie.H;
import ie.s;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder.DefaultImpls;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u001A\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00050\u0004B1\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ)\u0010\r\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\f\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\r\u0010\u000EJ)\u0010\u000F\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\f\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\u000F\u0010\u000EJ1\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0011\u001A\u00020\u00102\u0018\u0010\u0012\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0018\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u0017\u001A\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001A\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001AR\u001A\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001AR\u001A\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001AR\u001A\u0010\u001C\u001A\u00020\u001B8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001F¨\u0006 "}, d2 = {"Lkotlinx/serialization/internal/TripleSerializer;", "A", "B", "C", "Lkotlinx/serialization/KSerializer;", "Lie/s;", "aSerializer", "bSerializer", "cSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "Lkotlinx/serialization/encoding/CompositeDecoder;", "composite", "decodeSequentially", "(Lkotlinx/serialization/encoding/CompositeDecoder;)Lie/s;", "decodeStructure", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lie/s;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lie/s;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class TripleSerializer implements KSerializer {
    @NotNull
    private final KSerializer aSerializer;
    @NotNull
    private final KSerializer bSerializer;
    @NotNull
    private final KSerializer cSerializer;
    @NotNull
    private final SerialDescriptor descriptor;

    public TripleSerializer(@NotNull KSerializer kSerializer0, @NotNull KSerializer kSerializer1, @NotNull KSerializer kSerializer2) {
        q.g(kSerializer0, "aSerializer");
        q.g(kSerializer1, "bSerializer");
        q.g(kSerializer2, "cSerializer");
        super();
        this.aSerializer = kSerializer0;
        this.bSerializer = kSerializer1;
        this.cSerializer = kSerializer2;
        z z0 = new z(this, 9);
        this.descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("kotlin.Triple", new SerialDescriptor[0], z0);
    }

    public static H a(TripleSerializer tripleSerializer0, ClassSerialDescriptorBuilder classSerialDescriptorBuilder0) {
        return TripleSerializer.descriptor$lambda$0(tripleSerializer0, classSerialDescriptorBuilder0);
    }

    private final s decodeSequentially(CompositeDecoder compositeDecoder0) {
        Object object0 = DefaultImpls.decodeSerializableElement$default(compositeDecoder0, this.getDescriptor(), 0, this.aSerializer, null, 8, null);
        Object object1 = DefaultImpls.decodeSerializableElement$default(compositeDecoder0, this.getDescriptor(), 1, this.bSerializer, null, 8, null);
        Object object2 = DefaultImpls.decodeSerializableElement$default(compositeDecoder0, this.getDescriptor(), 2, this.cSerializer, null, 8, null);
        compositeDecoder0.endStructure(this.getDescriptor());
        return new s(object0, object1, object2);
    }

    private final s decodeStructure(CompositeDecoder compositeDecoder0) {
        Object object0 = TuplesKt.NULL;
        Object object1 = TuplesKt.NULL;
        Object object2 = TuplesKt.NULL;
        while(true) {
            int v = compositeDecoder0.decodeElementIndex(this.getDescriptor());
            switch(v) {
                case -1: {
                    compositeDecoder0.endStructure(this.getDescriptor());
                    if(object0 == TuplesKt.NULL) {
                        throw new SerializationException("Element \'first\' is missing");
                    }
                    if(object1 == TuplesKt.NULL) {
                        throw new SerializationException("Element \'second\' is missing");
                    }
                    if(object2 == TuplesKt.NULL) {
                        throw new SerializationException("Element \'third\' is missing");
                    }
                    return new s(object0, object1, object2);
                }
                case 0: {
                    object0 = DefaultImpls.decodeSerializableElement$default(compositeDecoder0, this.getDescriptor(), 0, this.aSerializer, null, 8, null);
                    continue;
                }
                case 1: {
                    object1 = DefaultImpls.decodeSerializableElement$default(compositeDecoder0, this.getDescriptor(), 1, this.bSerializer, null, 8, null);
                    continue;
                }
                case 2: {
                    break;
                }
                default: {
                    throw new SerializationException("Unexpected index " + v);
                }
            }
            object2 = DefaultImpls.decodeSerializableElement$default(compositeDecoder0, this.getDescriptor(), 2, this.cSerializer, null, 8, null);
        }
    }

    private static final H descriptor$lambda$0(TripleSerializer tripleSerializer0, ClassSerialDescriptorBuilder classSerialDescriptorBuilder0) {
        q.g(classSerialDescriptorBuilder0, "$this$buildClassSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder0, "first", tripleSerializer0.aSerializer.getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder0, "second", tripleSerializer0.bSerializer.getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder0, "third", tripleSerializer0.cSerializer.getDescriptor(), null, false, 12, null);
        return H.a;
    }

    @NotNull
    public s deserialize(@NotNull Decoder decoder0) {
        q.g(decoder0, "decoder");
        CompositeDecoder compositeDecoder0 = decoder0.beginStructure(this.getDescriptor());
        return compositeDecoder0.decodeSequentially() ? this.decodeSequentially(compositeDecoder0) : this.decodeStructure(compositeDecoder0);
    }

    @Override  // kotlinx.serialization.DeserializationStrategy
    public Object deserialize(Decoder decoder0) {
        return this.deserialize(decoder0);
    }

    @Override  // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public void serialize(@NotNull Encoder encoder0, @NotNull s s0) {
        q.g(encoder0, "encoder");
        q.g(s0, "value");
        CompositeEncoder compositeEncoder0 = encoder0.beginStructure(this.getDescriptor());
        compositeEncoder0.encodeSerializableElement(this.getDescriptor(), 0, this.aSerializer, s0.a);
        compositeEncoder0.encodeSerializableElement(this.getDescriptor(), 1, this.bSerializer, s0.b);
        compositeEncoder0.encodeSerializableElement(this.getDescriptor(), 2, this.cSerializer, s0.c);
        compositeEncoder0.endStructure(this.getDescriptor());
    }

    @Override  // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder0, Object object0) {
        this.serialize(encoder0, ((s)object0));
    }
}

