package kotlinx.serialization.modules;

import De.d;
import i.n.i.b.a.s.e.M3;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.q;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u00DF\u0001\u0012\u0016\u0010\u0005\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012*\u0010\u0007\u001A&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00020\u0002\u0012.\u0010\u000B\u001A*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u001C\u0012\u001A\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\t0\bj\u0006\u0012\u0002\b\u0003`\n0\u0002\u0012&\u0010\r\u001A\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00020\u0002\u00122\u0010\u0010\u001A.\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012 \u0012\u001E\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u000E0\bj\u0006\u0012\u0002\b\u0003`\u000F0\u0002\u0012\u0006\u0010\u0012\u001A\u00020\u0011\u00A2\u0006\u0004\b\u0013\u0010\u0014J9\u0010\u0019\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t\"\b\b\u0000\u0010\u0016*\u00020\u00152\u000E\u0010\u0017\u001A\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00032\u0006\u0010\u0018\u001A\u00028\u0000H\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ;\u0010\u0019\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000E\"\b\b\u0000\u0010\u0016*\u00020\u00152\u000E\u0010\u0017\u001A\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00032\b\u0010\u001B\u001A\u0004\u0018\u00010\fH\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001CJA\u0010 \u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\"\b\b\u0000\u0010\u0016*\u00020\u00152\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\u0010\u0010\u001F\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u001EH\u0016\u00A2\u0006\u0004\b \u0010!J\u0017\u0010%\u001A\u00020$2\u0006\u0010#\u001A\u00020\"H\u0016\u00A2\u0006\u0004\b%\u0010&R$\u0010\u0005\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010\'R8\u0010\u0007\u001A&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00020\u00028\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u0010\'R<\u0010\u000B\u001A*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u001C\u0012\u001A\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\t0\bj\u0006\u0012\u0002\b\u0003`\n0\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u000B\u0010\'R4\u0010\r\u001A\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\r\u0010\'R@\u0010\u0010\u001A.\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012 \u0012\u001E\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u000E0\bj\u0006\u0012\u0002\b\u0003`\u000F0\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0010\u0010\'R\u001A\u0010\u0012\u001A\u00020\u00118\u0010X\u0090\u0004\u00A2\u0006\f\n\u0004\b\u0012\u0010(\u001A\u0004\b)\u0010*\u00A8\u0006+"}, d2 = {"Lkotlinx/serialization/modules/SerialModuleImpl;", "Lkotlinx/serialization/modules/SerializersModule;", "", "LDe/d;", "Lkotlinx/serialization/modules/ContextualProvider;", "class2ContextualFactory", "Lkotlinx/serialization/KSerializer;", "polyBase2Serializers", "Lkotlin/Function1;", "Lkotlinx/serialization/SerializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicSerializerProvider;", "polyBase2DefaultSerializerProvider", "", "polyBase2NamedSerializers", "Lkotlinx/serialization/DeserializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicDeserializerProvider;", "polyBase2DefaultDeserializerProvider", "", "hasInterfaceContextualSerializers", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Z)V", "", "T", "baseClass", "value", "getPolymorphic", "(LDe/d;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "serializedClassName", "(LDe/d;Ljava/lang/String;)Lkotlinx/serialization/DeserializationStrategy;", "kClass", "", "typeArgumentsSerializers", "getContextual", "(LDe/d;Ljava/util/List;)Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "collector", "Lie/H;", "dumpTo", "(Lkotlinx/serialization/modules/SerializersModuleCollector;)V", "Ljava/util/Map;", "Z", "getHasInterfaceContextualSerializers$kotlinx_serialization_core", "()Z", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class SerialModuleImpl extends SerializersModule {
    @NotNull
    private final Map class2ContextualFactory;
    private final boolean hasInterfaceContextualSerializers;
    @NotNull
    private final Map polyBase2DefaultDeserializerProvider;
    @NotNull
    private final Map polyBase2DefaultSerializerProvider;
    @NotNull
    private final Map polyBase2NamedSerializers;
    @NotNull
    public final Map polyBase2Serializers;

    public SerialModuleImpl(@NotNull Map map0, @NotNull Map map1, @NotNull Map map2, @NotNull Map map3, @NotNull Map map4, boolean z) {
        q.g(map0, "class2ContextualFactory");
        q.g(map1, "polyBase2Serializers");
        q.g(map2, "polyBase2DefaultSerializerProvider");
        q.g(map3, "polyBase2NamedSerializers");
        q.g(map4, "polyBase2DefaultDeserializerProvider");
        super(null);
        this.class2ContextualFactory = map0;
        this.polyBase2Serializers = map1;
        this.polyBase2DefaultSerializerProvider = map2;
        this.polyBase2NamedSerializers = map3;
        this.polyBase2DefaultDeserializerProvider = map4;
        this.hasInterfaceContextualSerializers = z;
    }

    @Override  // kotlinx.serialization.modules.SerializersModule
    public void dumpTo(@NotNull SerializersModuleCollector serializersModuleCollector0) {
        q.g(serializersModuleCollector0, "collector");
        for(Object object0: this.class2ContextualFactory.entrySet()) {
            d d0 = (d)((Map.Entry)object0).getKey();
            ContextualProvider contextualProvider0 = (ContextualProvider)((Map.Entry)object0).getValue();
            if(contextualProvider0 instanceof Argless) {
                q.e(d0, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                KSerializer kSerializer0 = ((Argless)contextualProvider0).getSerializer();
                q.e(kSerializer0, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                serializersModuleCollector0.contextual(d0, kSerializer0);
            }
            else {
                if(!(contextualProvider0 instanceof WithTypeArguments)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                serializersModuleCollector0.contextual(d0, ((WithTypeArguments)contextualProvider0).getProvider());
            }
        }
        for(Object object1: this.polyBase2Serializers.entrySet()) {
            d d1 = (d)((Map.Entry)object1).getKey();
            for(Object object2: ((Map)((Map.Entry)object1).getValue()).entrySet()) {
                d d2 = (d)((Map.Entry)object2).getKey();
                KSerializer kSerializer1 = (KSerializer)((Map.Entry)object2).getValue();
                q.e(d1, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                q.e(d2, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                q.e(kSerializer1, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                serializersModuleCollector0.polymorphic(d1, d2, kSerializer1);
            }
        }
        for(Object object3: this.polyBase2DefaultSerializerProvider.entrySet()) {
            d d3 = (d)((Map.Entry)object3).getKey();
            k k0 = (k)((Map.Entry)object3).getValue();
            q.e(d3, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            q.e(k0, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"value\")] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>");
            N.e(1, k0);
            serializersModuleCollector0.polymorphicDefaultSerializer(d3, k0);
        }
        for(Object object4: this.polyBase2DefaultDeserializerProvider.entrySet()) {
            d d4 = (d)((Map.Entry)object4).getKey();
            k k1 = (k)((Map.Entry)object4).getValue();
            q.e(d4, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            q.e(k1, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"className\")] kotlin.String?, kotlinx.serialization.DeserializationStrategy<kotlin.Any>?>");
            N.e(1, k1);
            serializersModuleCollector0.polymorphicDefaultDeserializer(d4, k1);
        }
    }

    @Override  // kotlinx.serialization.modules.SerializersModule
    @Nullable
    public KSerializer getContextual(@NotNull d d0, @NotNull List list0) {
        q.g(d0, "kClass");
        q.g(list0, "typeArgumentsSerializers");
        ContextualProvider contextualProvider0 = (ContextualProvider)this.class2ContextualFactory.get(d0);
        KSerializer kSerializer0 = contextualProvider0 == null ? null : contextualProvider0.invoke(list0);
        return kSerializer0 == null ? null : kSerializer0;
    }

    @Override  // kotlinx.serialization.modules.SerializersModule
    @Nullable
    public DeserializationStrategy getPolymorphic(@NotNull d d0, @Nullable String s) {
        q.g(d0, "baseClass");
        Map map0 = (Map)this.polyBase2NamedSerializers.get(d0);
        DeserializationStrategy deserializationStrategy0 = map0 == null ? null : ((KSerializer)map0.get(s));
        if(deserializationStrategy0 == null) {
            deserializationStrategy0 = null;
        }
        if(deserializationStrategy0 != null) {
            return deserializationStrategy0;
        }
        Object object0 = this.polyBase2DefaultDeserializerProvider.get(d0);
        k k0 = N.g(1, object0) ? ((k)object0) : null;
        return k0 == null ? null : ((DeserializationStrategy)k0.invoke(s));
    }

    @Override  // kotlinx.serialization.modules.SerializersModule
    @Nullable
    public SerializationStrategy getPolymorphic(@NotNull d d0, @NotNull Object object0) {
        SerializationStrategy serializationStrategy0;
        q.g(d0, "baseClass");
        q.g(object0, "value");
        if(d0.k(object0)) {
            Map map0 = (Map)this.polyBase2Serializers.get(d0);
            if(map0 == null) {
                serializationStrategy0 = null;
            }
            else {
                Class class0 = object0.getClass();
                serializationStrategy0 = (KSerializer)map0.get(I.a.b(class0));
            }
            if(serializationStrategy0 == null) {
                serializationStrategy0 = null;
            }
            if(serializationStrategy0 != null) {
                return serializationStrategy0;
            }
            Object object1 = this.polyBase2DefaultSerializerProvider.get(d0);
            k k0 = N.g(1, object1) ? ((k)object1) : null;
            return k0 == null ? null : ((SerializationStrategy)k0.invoke(object0));
        }
        return null;
    }
}

