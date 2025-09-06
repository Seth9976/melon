package kotlinx.serialization.modules;

import De.d;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.PlatformKt;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0001\u00A2\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u000B\u001A\u00020\n\"\b\b\u0000\u0010\u0005*\u00020\u00042\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\bH\u0016\u00A2\u0006\u0004\b\u000B\u0010\fJI\u0010\u000B\u001A\u00020\n\"\b\b\u0000\u0010\u0005*\u00020\u00042\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u00062 \u0010\u000F\u001A\u001C\u0012\u000E\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u000E\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\rH\u0016\u00A2\u0006\u0004\b\u000B\u0010\u0010JM\u0010\u0016\u001A\u00020\n\"\b\b\u0000\u0010\u0011*\u00020\u0004\"\b\b\u0001\u0010\u0012*\u00028\u00002\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00010\u00062\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00010\bH\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017JC\u0010\u001A\u001A\u00020\n\"\b\b\u0000\u0010\u0011*\u00020\u00042\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u00062\u001A\u0010\u0019\u001A\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00180\rH\u0016\u00A2\u0006\u0004\b\u001A\u0010\u0010JE\u0010\u001E\u001A\u00020\n\"\b\b\u0000\u0010\u0011*\u00020\u00042\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u00062\u001C\u0010\u001D\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u001B\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001C0\rH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u0010J9\u0010#\u001A\u00020\n\"\b\b\u0000\u0010\u0005*\u00020\u00042\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u000F\u001A\u00020 2\b\b\u0002\u0010\"\u001A\u00020!H\u0001\u00A2\u0006\u0004\b#\u0010$JK\u0010%\u001A\u00020\n\"\b\b\u0000\u0010\u0011*\u00020\u00042\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u00062\u001A\u0010\u0019\u001A\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00180\r2\u0006\u0010\"\u001A\u00020!H\u0001\u00A2\u0006\u0004\b%\u0010&JM\u0010\'\u001A\u00020\n\"\b\b\u0000\u0010\u0011*\u00020\u00042\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u00062\u001C\u0010\u001D\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u001B\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001C0\r2\u0006\u0010\"\u001A\u00020!H\u0001\u00A2\u0006\u0004\b\'\u0010&JW\u0010*\u001A\u00020\n\"\b\b\u0000\u0010\u0011*\u00020\u0004\"\b\b\u0001\u0010\u0012*\u00028\u00002\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010(\u001A\b\u0012\u0004\u0012\u00028\u00010\u00062\f\u0010)\u001A\b\u0012\u0004\u0012\u00028\u00010\b2\b\b\u0002\u0010\"\u001A\u00020!H\u0001\u00A2\u0006\u0004\b*\u0010+J\u000F\u0010-\u001A\u00020,H\u0001\u00A2\u0006\u0004\b-\u0010.R$\u00100\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020 0/8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b0\u00101R8\u00102\u001A&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0/0/8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b2\u00101R<\u00104\u001A*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u001C\u0012\u001A\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00180\rj\u0006\u0012\u0002\b\u0003`30/8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b4\u00101R4\u00105\u001A\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001B\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0/0/8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b5\u00101R@\u00107\u001A.\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012 \u0012\u001E\u0012\u0006\u0012\u0004\u0018\u00010\u001B\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u001C0\rj\u0006\u0012\u0002\b\u0003`60/8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b7\u00101R\u0016\u00108\u001A\u00020!8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b8\u00109\u00A8\u0006:"}, d2 = {"Lkotlinx/serialization/modules/SerializersModuleBuilder;", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "<init>", "()V", "", "T", "LDe/d;", "kClass", "Lkotlinx/serialization/KSerializer;", "serializer", "Lie/H;", "contextual", "(LDe/d;Lkotlinx/serialization/KSerializer;)V", "Lkotlin/Function1;", "", "provider", "(LDe/d;Lwe/k;)V", "Base", "Sub", "baseClass", "actualClass", "actualSerializer", "polymorphic", "(LDe/d;LDe/d;Lkotlinx/serialization/KSerializer;)V", "Lkotlinx/serialization/SerializationStrategy;", "defaultSerializerProvider", "polymorphicDefaultSerializer", "", "Lkotlinx/serialization/DeserializationStrategy;", "defaultDeserializerProvider", "polymorphicDefaultDeserializer", "forClass", "Lkotlinx/serialization/modules/ContextualProvider;", "", "allowOverwrite", "registerSerializer", "(LDe/d;Lkotlinx/serialization/modules/ContextualProvider;Z)V", "registerDefaultPolymorphicSerializer", "(LDe/d;Lwe/k;Z)V", "registerDefaultPolymorphicDeserializer", "concreteClass", "concreteSerializer", "registerPolymorphicSerializer", "(LDe/d;LDe/d;Lkotlinx/serialization/KSerializer;Z)V", "Lkotlinx/serialization/modules/SerializersModule;", "build", "()Lkotlinx/serialization/modules/SerializersModule;", "", "class2ContextualProvider", "Ljava/util/Map;", "polyBase2Serializers", "Lkotlinx/serialization/modules/PolymorphicSerializerProvider;", "polyBase2DefaultSerializerProvider", "polyBase2NamedSerializers", "Lkotlinx/serialization/modules/PolymorphicDeserializerProvider;", "polyBase2DefaultDeserializerProvider", "hasInterfaceContextualSerializers", "Z", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class SerializersModuleBuilder implements SerializersModuleCollector {
    @NotNull
    private final Map class2ContextualProvider;
    private boolean hasInterfaceContextualSerializers;
    @NotNull
    private final Map polyBase2DefaultDeserializerProvider;
    @NotNull
    private final Map polyBase2DefaultSerializerProvider;
    @NotNull
    private final Map polyBase2NamedSerializers;
    @NotNull
    private final Map polyBase2Serializers;

    public SerializersModuleBuilder() {
        this.class2ContextualProvider = new HashMap();
        this.polyBase2Serializers = new HashMap();
        this.polyBase2DefaultSerializerProvider = new HashMap();
        this.polyBase2NamedSerializers = new HashMap();
        this.polyBase2DefaultDeserializerProvider = new HashMap();
    }

    @NotNull
    public final SerializersModule build() {
        return new SerialModuleImpl(this.class2ContextualProvider, this.polyBase2Serializers, this.polyBase2DefaultSerializerProvider, this.polyBase2NamedSerializers, this.polyBase2DefaultDeserializerProvider, this.hasInterfaceContextualSerializers);
    }

    @Override  // kotlinx.serialization.modules.SerializersModuleCollector
    public void contextual(@NotNull d d0, @NotNull KSerializer kSerializer0) {
        q.g(d0, "kClass");
        q.g(kSerializer0, "serializer");
        SerializersModuleBuilder.registerSerializer$default(this, d0, new Argless(kSerializer0), false, 4, null);
    }

    @Override  // kotlinx.serialization.modules.SerializersModuleCollector
    public void contextual(@NotNull d d0, @NotNull k k0) {
        q.g(d0, "kClass");
        q.g(k0, "provider");
        SerializersModuleBuilder.registerSerializer$default(this, d0, new WithTypeArguments(k0), false, 4, null);
    }

    @Override  // kotlinx.serialization.modules.SerializersModuleCollector
    public void polymorphic(@NotNull d d0, @NotNull d d1, @NotNull KSerializer kSerializer0) {
        q.g(d0, "baseClass");
        q.g(d1, "actualClass");
        q.g(kSerializer0, "actualSerializer");
        SerializersModuleBuilder.registerPolymorphicSerializer$default(this, d0, d1, kSerializer0, false, 8, null);
    }

    @Override  // kotlinx.serialization.modules.SerializersModuleCollector
    public void polymorphicDefaultDeserializer(@NotNull d d0, @NotNull k k0) {
        q.g(d0, "baseClass");
        q.g(k0, "defaultDeserializerProvider");
        this.registerDefaultPolymorphicDeserializer(d0, k0, false);
    }

    @Override  // kotlinx.serialization.modules.SerializersModuleCollector
    public void polymorphicDefaultSerializer(@NotNull d d0, @NotNull k k0) {
        q.g(d0, "baseClass");
        q.g(k0, "defaultSerializerProvider");
        this.registerDefaultPolymorphicSerializer(d0, k0, false);
    }

    public final void registerDefaultPolymorphicDeserializer(@NotNull d d0, @NotNull k k0, boolean z) {
        q.g(d0, "baseClass");
        q.g(k0, "defaultDeserializerProvider");
        k k1 = (k)this.polyBase2DefaultDeserializerProvider.get(d0);
        if(k1 != null && !k1.equals(k0) && !z) {
            throw new IllegalArgumentException("Default deserializers provider for " + d0 + " is already registered: " + k1);
        }
        this.polyBase2DefaultDeserializerProvider.put(d0, k0);
    }

    public final void registerDefaultPolymorphicSerializer(@NotNull d d0, @NotNull k k0, boolean z) {
        q.g(d0, "baseClass");
        q.g(k0, "defaultSerializerProvider");
        k k1 = (k)this.polyBase2DefaultSerializerProvider.get(d0);
        if(k1 != null && !k1.equals(k0) && !z) {
            throw new IllegalArgumentException("Default serializers provider for " + d0 + " is already registered: " + k1);
        }
        this.polyBase2DefaultSerializerProvider.put(d0, k0);
    }

    public final void registerPolymorphicSerializer(@NotNull d d0, @NotNull d d1, @NotNull KSerializer kSerializer0, boolean z) {
        q.g(d0, "baseClass");
        q.g(d1, "concreteClass");
        q.g(kSerializer0, "concreteSerializer");
        String s = kSerializer0.getDescriptor().getSerialName();
        Map map0 = this.polyBase2Serializers;
        HashMap hashMap0 = map0.get(d0);
        if(hashMap0 == null) {
            hashMap0 = new HashMap();
            map0.put(d0, hashMap0);
        }
        KSerializer kSerializer1 = (KSerializer)hashMap0.get(d1);
        Map map1 = this.polyBase2NamedSerializers;
        HashMap hashMap1 = map1.get(d0);
        if(hashMap1 == null) {
            hashMap1 = new HashMap();
            map1.put(d0, hashMap1);
        }
        if(z) {
            if(kSerializer1 != null) {
                hashMap1.remove(kSerializer1.getDescriptor().getSerialName());
            }
            hashMap0.put(d1, kSerializer0);
            hashMap1.put(s, kSerializer0);
            return;
        }
        if(kSerializer1 != null) {
            if(!kSerializer1.equals(kSerializer0)) {
                throw new SerializerAlreadyRegisteredException(d0, d1);
            }
            KSerializer kSerializer2 = (KSerializer)hashMap1.remove(kSerializer1.getDescriptor().getSerialName());
        }
        KSerializer kSerializer3 = (KSerializer)hashMap1.get(s);
        if(kSerializer3 != null) {
            Object object0 = null;
            Object object1 = this.polyBase2Serializers.get(d0);
            q.d(object1);
            for(Object object2: ((Iterable)p.c0(((Map)object1).entrySet()).b)) {
                if(((Map.Entry)object2).getValue() == kSerializer3) {
                    object0 = object2;
                    break;
                }
            }
            throw new IllegalArgumentException("Multiple polymorphic serializers for base class \'" + d0 + "\' have the same serial name \'" + s + "\': \'" + d1 + "\' and \'" + ((Map.Entry)object0) + '\'');
        }
        hashMap0.put(d1, kSerializer0);
        hashMap1.put(s, kSerializer0);
    }

    public static void registerPolymorphicSerializer$default(SerializersModuleBuilder serializersModuleBuilder0, d d0, d d1, KSerializer kSerializer0, boolean z, int v, Object object0) {
        if((v & 8) != 0) {
            z = false;
        }
        serializersModuleBuilder0.registerPolymorphicSerializer(d0, d1, kSerializer0, z);
    }

    public final void registerSerializer(@NotNull d d0, @NotNull ContextualProvider contextualProvider0, boolean z) {
        q.g(d0, "forClass");
        q.g(contextualProvider0, "provider");
        if(!z) {
            ContextualProvider contextualProvider1 = (ContextualProvider)this.class2ContextualProvider.get(d0);
            if(contextualProvider1 != null && !contextualProvider1.equals(contextualProvider0)) {
                throw new SerializerAlreadyRegisteredException("Contextual serializer or serializer provider for " + d0 + " already registered in this module");
            }
        }
        this.class2ContextualProvider.put(d0, contextualProvider0);
        if(PlatformKt.isInterface(d0)) {
            this.hasInterfaceContextualSerializers = true;
        }
    }

    public static void registerSerializer$default(SerializersModuleBuilder serializersModuleBuilder0, d d0, ContextualProvider contextualProvider0, boolean z, int v, Object object0) {
        if((v & 4) != 0) {
            z = false;
        }
        serializersModuleBuilder0.registerSerializer(d0, contextualProvider0, z);
    }
}

