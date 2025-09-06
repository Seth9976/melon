package kotlinx.serialization.json.internal;

import A7.d;
import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind.ENUM;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.internal.JsonInternalDependenciesKt;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonClassDiscriminator;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A/\u0010\u0006\u001A\u00020\u00052\n\u0010\u0001\u001A\u0006\u0012\u0002\b\u00030\u00002\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0004\u001A\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001A\u0017\u0010\n\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\bH\u0000¢\u0006\u0004\b\n\u0010\u000B\u001A\u001B\u0010\u0004\u001A\u00020\u0003*\u00020\f2\u0006\u0010\u000E\u001A\u00020\rH\u0000¢\u0006\u0004\b\u0004\u0010\u000F¨\u0006\u0010"}, d2 = {"Lkotlinx/serialization/SerializationStrategy;", "serializer", "actualSerializer", "", "classDiscriminator", "Lie/H;", "validateIfSealed", "(Lkotlinx/serialization/SerializationStrategy;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/String;)V", "Lkotlinx/serialization/descriptors/SerialKind;", "kind", "checkKind", "(Lkotlinx/serialization/descriptors/SerialKind;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/json/Json;", "json", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/Json;)Ljava/lang/String;", "kotlinx-serialization-json"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class PolymorphicKt {
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 0xB0)
    public abstract class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[ClassDiscriminatorMode.values().length];
            try {
                arr_v[ClassDiscriminatorMode.NONE.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ClassDiscriminatorMode.POLYMORPHIC.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ClassDiscriminatorMode.ALL_JSON_OBJECTS.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final void checkKind(@NotNull SerialKind serialKind0) {
        q.g(serialKind0, "kind");
        if(serialKind0 instanceof ENUM) {
            throw new IllegalStateException("Enums cannot be serialized polymorphically with \'type\' parameter. You can use \'JsonBuilder.useArrayPolymorphism\' instead");
        }
        if(serialKind0 instanceof PrimitiveKind) {
            throw new IllegalStateException("Primitives cannot be serialized polymorphically with \'type\' parameter. You can use \'JsonBuilder.useArrayPolymorphism\' instead");
        }
        if(serialKind0 instanceof PolymorphicKind) {
            throw new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself");
        }
    }

    @NotNull
    public static final String classDiscriminator(@NotNull SerialDescriptor serialDescriptor0, @NotNull Json json0) {
        q.g(serialDescriptor0, "<this>");
        q.g(json0, "json");
        for(Object object0: serialDescriptor0.getAnnotations()) {
            Annotation annotation0 = (Annotation)object0;
            if(annotation0 instanceof JsonClassDiscriminator) {
                return ((JsonClassDiscriminator)annotation0).discriminator();
            }
            if(false) {
                break;
            }
        }
        return json0.getConfiguration().getClassDiscriminator();
    }

    private static final void validateIfSealed(SerializationStrategy serializationStrategy0, SerializationStrategy serializationStrategy1, String s) {
        if(!(serializationStrategy0 instanceof SealedClassSerializer) || !JsonInternalDependenciesKt.jsonCachedSerialNames(serializationStrategy1.getDescriptor()).contains(s)) {
            return;
        }
        String s1 = ((SealedClassSerializer)serializationStrategy0).getDescriptor().getSerialName();
        StringBuilder stringBuilder0 = d.o("Sealed class \'", serializationStrategy1.getDescriptor().getSerialName(), "\' cannot be serialized as base class \'", s1, "\' because it has property name that conflicts with JSON class discriminator \'");
        stringBuilder0.append(s);
        stringBuilder0.append("\'. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
        throw new IllegalStateException(stringBuilder0.toString().toString());
    }
}

