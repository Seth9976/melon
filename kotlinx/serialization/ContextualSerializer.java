package kotlinx.serialization;

import De.d;
import Vc.B;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.List;
import je.n;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.ContextAwareKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind.CONTEXTUAL;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B7\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003\u0012\u0010\u0010\b\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0007¢\u0006\u0004\b\t\u0010\nJ\u001D\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\f\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001A\u00028\u00002\u0006\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001A\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u001C\u0010\u0006\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001AR\u001E\u0010\b\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u001B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001CR\u001A\u0010\u001E\u001A\u00020\u001D8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b \u0010!¨\u0006\""}, d2 = {"Lkotlinx/serialization/ContextualSerializer;", "", "T", "Lkotlinx/serialization/KSerializer;", "LDe/d;", "serializableClass", "fallbackSerializer", "", "typeArgumentsSerializers", "<init>", "(LDe/d;Lkotlinx/serialization/KSerializer;[Lkotlinx/serialization/KSerializer;)V", "Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "serializer", "(Lkotlinx/serialization/modules/SerializersModule;)Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "LDe/d;", "Lkotlinx/serialization/KSerializer;", "", "Ljava/util/List;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class ContextualSerializer implements KSerializer {
    @NotNull
    private final SerialDescriptor descriptor;
    @Nullable
    private final KSerializer fallbackSerializer;
    @NotNull
    private final d serializableClass;
    @NotNull
    private final List typeArgumentsSerializers;

    public ContextualSerializer(@NotNull d d0, @Nullable KSerializer kSerializer0, @NotNull KSerializer[] arr_kSerializer) {
        q.g(d0, "serializableClass");
        q.g(arr_kSerializer, "typeArgumentsSerializers");
        super();
        this.serializableClass = d0;
        this.fallbackSerializer = kSerializer0;
        this.typeArgumentsSerializers = n.N(arr_kSerializer);
        B b0 = new B(this, 13);
        this.descriptor = ContextAwareKt.withContext(SerialDescriptorsKt.buildSerialDescriptor("kotlinx.serialization.ContextualSerializer", CONTEXTUAL.INSTANCE, new SerialDescriptor[0], b0), d0);
    }

    public static H a(ContextualSerializer contextualSerializer0, ClassSerialDescriptorBuilder classSerialDescriptorBuilder0) {
        return ContextualSerializer.descriptor$lambda$0(contextualSerializer0, classSerialDescriptorBuilder0);
    }

    private static final H descriptor$lambda$0(ContextualSerializer contextualSerializer0, ClassSerialDescriptorBuilder classSerialDescriptorBuilder0) {
        List list0;
        q.g(classSerialDescriptorBuilder0, "$this$buildSerialDescriptor");
        KSerializer kSerializer0 = contextualSerializer0.fallbackSerializer;
        if(kSerializer0 == null) {
            list0 = null;
        }
        else {
            SerialDescriptor serialDescriptor0 = kSerializer0.getDescriptor();
            list0 = serialDescriptor0 == null ? null : serialDescriptor0.getAnnotations();
        }
        if(list0 == null) {
            list0 = w.a;
        }
        classSerialDescriptorBuilder0.setAnnotations(list0);
        return H.a;
    }

    @Override  // kotlinx.serialization.DeserializationStrategy
    @NotNull
    public Object deserialize(@NotNull Decoder decoder0) {
        q.g(decoder0, "decoder");
        return decoder0.decodeSerializableValue(this.serializer(decoder0.getSerializersModule()));
    }

    @Override  // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override  // kotlinx.serialization.SerializationStrategy
    public void serialize(@NotNull Encoder encoder0, @NotNull Object object0) {
        q.g(encoder0, "encoder");
        q.g(object0, "value");
        encoder0.encodeSerializableValue(this.serializer(encoder0.getSerializersModule()), object0);
    }

    private final KSerializer serializer(SerializersModule serializersModule0) {
        KSerializer kSerializer0 = serializersModule0.getContextual(this.serializableClass, this.typeArgumentsSerializers);
        if(kSerializer0 == null) {
            KSerializer kSerializer1 = this.fallbackSerializer;
            if(kSerializer1 != null) {
                return kSerializer1;
            }
            Platform_commonKt.serializerNotRegistered(this.serializableClass);
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return kSerializer0;
    }
}

