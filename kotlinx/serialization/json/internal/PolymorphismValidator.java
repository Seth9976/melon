package kotlinx.serialization.json.internal;

import De.d;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind.CONTEXTUAL;
import kotlinx.serialization.descriptors.SerialKind.ENUM;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind.LIST;
import kotlinx.serialization.descriptors.StructureKind.MAP;
import kotlinx.serialization.modules.SerializersModuleCollector.DefaultImpls;
import kotlinx.serialization.modules.SerializersModuleCollector;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007J#\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\n\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\nH\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ#\u0010\u000F\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\n\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\nH\u0002\u00A2\u0006\u0004\b\u000F\u0010\u000EJI\u0010\u0017\u001A\u00020\f\"\b\b\u0000\u0010\u0011*\u00020\u00102\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\n2 \u0010\u0016\u001A\u001C\u0012\u000E\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0013H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018JM\u0010\u001D\u001A\u00020\f\"\b\b\u0000\u0010\u0019*\u00020\u0010\"\b\b\u0001\u0010\u001A*\u00028\u00002\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00010\n2\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u00028\u00010\u0015H\u0016\u00A2\u0006\u0004\b\u001D\u0010\u001EJC\u0010!\u001A\u00020\f\"\b\b\u0000\u0010\u0019*\u00020\u00102\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00028\u00000\n2\u001A\u0010 \u001A\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001F0\u0013H\u0016\u00A2\u0006\u0004\b!\u0010\u0018JE\u0010$\u001A\u00020\f\"\b\b\u0000\u0010\u0019*\u00020\u00102\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00028\u00000\n2\u001C\u0010#\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\"0\u0013H\u0016\u00A2\u0006\u0004\b$\u0010\u0018R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010%R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010&\u00A8\u0006\'"}, d2 = {"Lkotlinx/serialization/json/internal/PolymorphismValidator;", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "", "useArrayPolymorphism", "", "discriminator", "<init>", "(ZLjava/lang/String;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "LDe/d;", "actualClass", "Lie/H;", "checkKind", "(Lkotlinx/serialization/descriptors/SerialDescriptor;LDe/d;)V", "checkDiscriminatorCollisions", "", "T", "kClass", "Lkotlin/Function1;", "", "Lkotlinx/serialization/KSerializer;", "provider", "contextual", "(LDe/d;Lwe/k;)V", "Base", "Sub", "baseClass", "actualSerializer", "polymorphic", "(LDe/d;LDe/d;Lkotlinx/serialization/KSerializer;)V", "Lkotlinx/serialization/SerializationStrategy;", "defaultSerializerProvider", "polymorphicDefaultSerializer", "Lkotlinx/serialization/DeserializationStrategy;", "defaultDeserializerProvider", "polymorphicDefaultDeserializer", "Z", "Ljava/lang/String;", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class PolymorphismValidator implements SerializersModuleCollector {
    @NotNull
    private final String discriminator;
    private final boolean useArrayPolymorphism;

    public PolymorphismValidator(boolean z, @NotNull String s) {
        q.g(s, "discriminator");
        super();
        this.useArrayPolymorphism = z;
        this.discriminator = s;
    }

    private final void checkDiscriminatorCollisions(SerialDescriptor serialDescriptor0, d d0) {
        int v = serialDescriptor0.getElementsCount();
        for(int v1 = 0; v1 < v; ++v1) {
            String s = serialDescriptor0.getElementName(v1);
            if(q.b(s, this.discriminator)) {
                throw new IllegalArgumentException("Polymorphic serializer for " + d0 + " has property \'" + s + "\' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
            }
        }
    }

    private final void checkKind(SerialDescriptor serialDescriptor0, d d0) {
        SerialKind serialKind0 = serialDescriptor0.getKind();
        if(serialKind0 instanceof PolymorphicKind || q.b(serialKind0, CONTEXTUAL.INSTANCE)) {
            throw new IllegalArgumentException("Serializer for " + d0.m() + " can\'t be registered as a subclass for polymorphic serialization because its kind " + serialKind0 + " is not concrete. To work with multiple hierarchies, register it as a base class.");
        }
        if(!this.useArrayPolymorphism && (q.b(serialKind0, LIST.INSTANCE) || q.b(serialKind0, MAP.INSTANCE) || serialKind0 instanceof PrimitiveKind || serialKind0 instanceof ENUM)) {
            throw new IllegalArgumentException("Serializer for " + d0.m() + " of kind " + serialKind0 + " cannot be serialized polymorphically with class discriminator.");
        }
    }

    @Override  // kotlinx.serialization.modules.SerializersModuleCollector
    public void contextual(@NotNull d d0, @NotNull KSerializer kSerializer0) {
        DefaultImpls.contextual(this, d0, kSerializer0);
    }

    @Override  // kotlinx.serialization.modules.SerializersModuleCollector
    public void contextual(@NotNull d d0, @NotNull k k0) {
        q.g(d0, "kClass");
        q.g(k0, "provider");
    }

    @Override  // kotlinx.serialization.modules.SerializersModuleCollector
    public void polymorphic(@NotNull d d0, @NotNull d d1, @NotNull KSerializer kSerializer0) {
        q.g(d0, "baseClass");
        q.g(d1, "actualClass");
        q.g(kSerializer0, "actualSerializer");
        SerialDescriptor serialDescriptor0 = kSerializer0.getDescriptor();
        this.checkKind(serialDescriptor0, d1);
        if(!this.useArrayPolymorphism) {
            this.checkDiscriminatorCollisions(serialDescriptor0, d1);
        }
    }

    @Override  // kotlinx.serialization.modules.SerializersModuleCollector
    public void polymorphicDefaultDeserializer(@NotNull d d0, @NotNull k k0) {
        q.g(d0, "baseClass");
        q.g(k0, "defaultDeserializerProvider");
    }

    @Override  // kotlinx.serialization.modules.SerializersModuleCollector
    public void polymorphicDefaultSerializer(@NotNull d d0, @NotNull k k0) {
        q.g(d0, "baseClass");
        q.g(k0, "defaultSerializerProvider");
    }
}

