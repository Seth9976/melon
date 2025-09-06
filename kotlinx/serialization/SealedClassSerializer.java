package kotlinx.serialization;

import De.d;
import Zc.N;
import bg.a;
import d3.g;
import ie.H;
import ie.j;
import ie.k;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import je.C;
import je.D;
import je.n;
import je.w;
import je.z;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.q;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.PolymorphicKind.SEALED;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind.CONTEXTUAL;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003BI\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0014\u0010\t\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00060\b\u0012\u0014\u0010\u000B\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\n0\b\u00A2\u0006\u0004\b\f\u0010\rBY\b\u0011\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0014\u0010\t\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00060\b\u0012\u0014\u0010\u000B\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\n0\b\u0012\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u000E0\b\u00A2\u0006\u0004\b\f\u0010\u0010J)\u0010\u0015\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010\u0012\u001A\u00020\u00112\b\u0010\u0013\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0016J\'\u0010\u0015\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001A2\u0006\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0019\u001A\u00028\u0000H\u0016\u00A2\u0006\u0004\b\u0015\u0010\u001BR \u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u00068\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0007\u0010\u001C\u001A\u0004\b\u001D\u0010\u001ER\u001C\u0010 \u001A\b\u0012\u0004\u0012\u00020\u000E0\u001F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b \u0010!R\u001B\u0010\'\u001A\u00020\"8VX\u0096\u0084\u0002\u00A2\u0006\f\n\u0004\b#\u0010$\u001A\u0004\b%\u0010&R0\u0010)\u001A\u001E\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0006\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\n0(8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b)\u0010*R(\u0010+\u001A\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\n0(8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b+\u0010*\u00A8\u0006,"}, d2 = {"Lkotlinx/serialization/SealedClassSerializer;", "", "T", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "", "serialName", "LDe/d;", "baseClass", "", "subclasses", "Lkotlinx/serialization/KSerializer;", "subclassSerializers", "<init>", "(Ljava/lang/String;LDe/d;[LDe/d;[Lkotlinx/serialization/KSerializer;)V", "", "classAnnotations", "(Ljava/lang/String;LDe/d;[LDe/d;[Lkotlinx/serialization/KSerializer;[Ljava/lang/annotation/Annotation;)V", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decoder", "klassName", "Lkotlinx/serialization/DeserializationStrategy;", "findPolymorphicSerializerOrNull", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/String;)Lkotlinx/serialization/DeserializationStrategy;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "LDe/d;", "getBaseClass", "()LDe/d;", "", "_annotations", "Ljava/util/List;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lie/j;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "class2Serializer", "Ljava/util/Map;", "serialName2Serializer", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class SealedClassSerializer extends AbstractPolymorphicSerializer {
    @NotNull
    private List _annotations;
    @NotNull
    private final d baseClass;
    @NotNull
    private final Map class2Serializer;
    @NotNull
    private final j descriptor$delegate;
    @NotNull
    private final Map serialName2Serializer;

    public SealedClassSerializer(@NotNull String s, @NotNull d d0, @NotNull d[] arr_d, @NotNull KSerializer[] arr_kSerializer) {
        q.g(s, "serialName");
        q.g(d0, "baseClass");
        q.g(arr_d, "subclasses");
        q.g(arr_kSerializer, "subclassSerializers");
        super();
        this.baseClass = d0;
        this._annotations = w.a;
        N n0 = new N(1, s, this);
        this.descriptor$delegate = g.P(k.b, n0);
        if(arr_d.length != arr_kSerializer.length) {
            throw new IllegalArgumentException("All subclasses of sealed class " + this.getBaseClass().m() + " should be marked @Serializable");
        }
        Map map0 = C.Y(n.B0(arr_d, arr_kSerializer));
        this.class2Serializer = map0;
        kotlinx.serialization.SealedClassSerializer.special..inlined.groupingBy.1 sealedClassSerializer$special$$inlined$groupingBy$10 = new z() {
            @Override  // je.z
            public Object keyOf(Object object0) {
                return ((KSerializer)((Map.Entry)object0).getValue()).getDescriptor().getSerialName();
            }

            @Override  // je.z
            public Iterator sourceIterator() {
                return this.$this_groupingBy.iterator();
            }
        };
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        Iterator iterator0 = sealedClassSerializer$special$$inlined$groupingBy$10.sourceIterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            Object object1 = sealedClassSerializer$special$$inlined$groupingBy$10.keyOf(object0);
            Object object2 = linkedHashMap0.get(object1);
            if(object2 == null) {
                linkedHashMap0.containsKey(object1);
            }
            if(((Map.Entry)object2) != null) {
                throw new IllegalStateException(("Multiple sealed subclasses of \'" + this.getBaseClass() + "\' have the same serial name \'" + ((String)object1) + "\': \'" + ((Map.Entry)object2).getKey() + "\', \'" + ((Map.Entry)object0).getKey() + '\'').toString());
            }
            linkedHashMap0.put(object1, ((Map.Entry)object0));
        }
        LinkedHashMap linkedHashMap1 = new LinkedHashMap(D.N(linkedHashMap0.size()));
        for(Object object3: linkedHashMap0.entrySet()) {
            linkedHashMap1.put(((Map.Entry)object3).getKey(), ((KSerializer)((Map.Entry)((Map.Entry)object3).getValue()).getValue()));
        }
        this.serialName2Serializer = linkedHashMap1;
    }

    public SealedClassSerializer(@NotNull String s, @NotNull d d0, @NotNull d[] arr_d, @NotNull KSerializer[] arr_kSerializer, @NotNull Annotation[] arr_annotation) {
        q.g(s, "serialName");
        q.g(d0, "baseClass");
        q.g(arr_d, "subclasses");
        q.g(arr_kSerializer, "subclassSerializers");
        q.g(arr_annotation, "classAnnotations");
        this(s, d0, arr_d, arr_kSerializer);
        this._annotations = n.N(arr_annotation);
    }

    public static H a(SealedClassSerializer sealedClassSerializer0, ClassSerialDescriptorBuilder classSerialDescriptorBuilder0) {
        return SealedClassSerializer.descriptor_delegate$lambda$3$lambda$2(sealedClassSerializer0, classSerialDescriptorBuilder0);
    }

    public static H b(SealedClassSerializer sealedClassSerializer0, ClassSerialDescriptorBuilder classSerialDescriptorBuilder0) {
        return SealedClassSerializer.descriptor_delegate$lambda$3$lambda$2$lambda$1(sealedClassSerializer0, classSerialDescriptorBuilder0);
    }

    public static SerialDescriptor c(String s, SealedClassSerializer sealedClassSerializer0) {
        return SealedClassSerializer.descriptor_delegate$lambda$3(s, sealedClassSerializer0);
    }

    private static final SerialDescriptor descriptor_delegate$lambda$3(String s, SealedClassSerializer sealedClassSerializer0) {
        a a0 = new a(sealedClassSerializer0, 0);
        return SerialDescriptorsKt.buildSerialDescriptor(s, SEALED.INSTANCE, new SerialDescriptor[0], a0);
    }

    private static final H descriptor_delegate$lambda$3$lambda$2(SealedClassSerializer sealedClassSerializer0, ClassSerialDescriptorBuilder classSerialDescriptorBuilder0) {
        q.g(classSerialDescriptorBuilder0, "$this$buildSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder0, "type", BuiltinSerializersKt.serializer(M.a).getDescriptor(), null, false, 12, null);
        a a0 = new a(sealedClassSerializer0, 1);
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder0, "value", SerialDescriptorsKt.buildSerialDescriptor(("kotlinx.serialization.Sealed<" + sealedClassSerializer0.getBaseClass().m() + '>'), CONTEXTUAL.INSTANCE, new SerialDescriptor[0], a0), null, false, 12, null);
        classSerialDescriptorBuilder0.setAnnotations(sealedClassSerializer0._annotations);
        return H.a;
    }

    private static final H descriptor_delegate$lambda$3$lambda$2$lambda$1(SealedClassSerializer sealedClassSerializer0, ClassSerialDescriptorBuilder classSerialDescriptorBuilder0) {
        q.g(classSerialDescriptorBuilder0, "$this$buildSerialDescriptor");
        for(Object object0: sealedClassSerializer0.serialName2Serializer.entrySet()) {
            ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder0, ((String)((Map.Entry)object0).getKey()), ((KSerializer)((Map.Entry)object0).getValue()).getDescriptor(), null, false, 12, null);
        }
        return H.a;
    }

    @Override  // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    @Nullable
    public DeserializationStrategy findPolymorphicSerializerOrNull(@NotNull CompositeDecoder compositeDecoder0, @Nullable String s) {
        q.g(compositeDecoder0, "decoder");
        DeserializationStrategy deserializationStrategy0 = (KSerializer)this.serialName2Serializer.get(s);
        return deserializationStrategy0 == null ? super.findPolymorphicSerializerOrNull(compositeDecoder0, s) : deserializationStrategy0;
    }

    @Override  // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    @Nullable
    public SerializationStrategy findPolymorphicSerializerOrNull(@NotNull Encoder encoder0, @NotNull Object object0) {
        q.g(encoder0, "encoder");
        q.g(object0, "value");
        Class class0 = object0.getClass();
        d d0 = I.a.b(class0);
        SerializationStrategy serializationStrategy0 = (KSerializer)this.class2Serializer.get(d0);
        if(serializationStrategy0 == null) {
            serializationStrategy0 = super.findPolymorphicSerializerOrNull(encoder0, object0);
        }
        return serializationStrategy0 == null ? null : serializationStrategy0;
    }

    @Override  // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    @NotNull
    public d getBaseClass() {
        return this.baseClass;
    }

    @Override  // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor)this.descriptor$delegate.getValue();
    }
}

