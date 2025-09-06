package kotlinx.serialization.internal;

import Zc.N;
import d3.g;
import dd.z;
import ie.H;
import ie.j;
import ie.k;
import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.StructureKind.OBJECT;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u001B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00028\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\r\u001A\u00020\f2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00028\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0011\u001A\u00028\u00002\u0006\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001A\u00028\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u001C\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001B\u0010\u001D\u001A\u00020\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001C¨\u0006\u001E"}, d2 = {"Lkotlinx/serialization/internal/ObjectSerializer;", "", "T", "Lkotlinx/serialization/KSerializer;", "", "serialName", "objectInstance", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "Ljava/lang/Object;", "", "", "_annotations", "Ljava/util/List;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lie/j;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class ObjectSerializer implements KSerializer {
    @NotNull
    private List _annotations;
    @NotNull
    private final j descriptor$delegate;
    @NotNull
    private final Object objectInstance;

    public ObjectSerializer(@NotNull String s, @NotNull Object object0) {
        q.g(s, "serialName");
        q.g(object0, "objectInstance");
        super();
        this.objectInstance = object0;
        this._annotations = w.a;
        N n0 = new N(27, s, this);
        this.descriptor$delegate = g.P(k.b, n0);
    }

    public static H a(ObjectSerializer objectSerializer0, ClassSerialDescriptorBuilder classSerialDescriptorBuilder0) {
        return ObjectSerializer.descriptor_delegate$lambda$1$lambda$0(objectSerializer0, classSerialDescriptorBuilder0);
    }

    public static SerialDescriptor b(String s, ObjectSerializer objectSerializer0) {
        return ObjectSerializer.descriptor_delegate$lambda$1(s, objectSerializer0);
    }

    private static final SerialDescriptor descriptor_delegate$lambda$1(String s, ObjectSerializer objectSerializer0) {
        z z0 = new z(objectSerializer0, 7);
        return SerialDescriptorsKt.buildSerialDescriptor(s, OBJECT.INSTANCE, new SerialDescriptor[0], z0);
    }

    private static final H descriptor_delegate$lambda$1$lambda$0(ObjectSerializer objectSerializer0, ClassSerialDescriptorBuilder classSerialDescriptorBuilder0) {
        q.g(classSerialDescriptorBuilder0, "$this$buildSerialDescriptor");
        classSerialDescriptorBuilder0.setAnnotations(objectSerializer0._annotations);
        return H.a;
    }

    @Override  // kotlinx.serialization.DeserializationStrategy
    @NotNull
    public Object deserialize(@NotNull Decoder decoder0) {
        q.g(decoder0, "decoder");
        SerialDescriptor serialDescriptor0 = this.getDescriptor();
        CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
        if(!compositeDecoder0.decodeSequentially()) {
            int v = compositeDecoder0.decodeElementIndex(this.getDescriptor());
            if(v != -1) {
                throw new SerializationException("Unexpected index " + v);
            }
        }
        compositeDecoder0.endStructure(serialDescriptor0);
        return this.objectInstance;
    }

    @Override  // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor)this.descriptor$delegate.getValue();
    }

    @Override  // kotlinx.serialization.SerializationStrategy
    public void serialize(@NotNull Encoder encoder0, @NotNull Object object0) {
        q.g(encoder0, "encoder");
        q.g(object0, "value");
        encoder0.beginStructure(this.getDescriptor()).endStructure(this.getDescriptor());
    }
}

