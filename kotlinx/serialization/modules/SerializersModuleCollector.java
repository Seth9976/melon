package kotlinx.serialization.modules;

import De.d;
import dd.z;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J5\u0010\b\u001A\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJI\u0010\b\u001A\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032 \u0010\f\u001A\u001C\u0012\u000E\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u000B\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\nH&¢\u0006\u0004\b\b\u0010\rJM\u0010\u0013\u001A\u00020\u0007\"\b\b\u0000\u0010\u000E*\u00020\u0001\"\b\b\u0001\u0010\u000F*\u00028\u00002\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00010\u0005H&¢\u0006\u0004\b\u0013\u0010\u0014JC\u0010\u0017\u001A\u00020\u0007\"\b\b\u0000\u0010\u000E*\u00020\u00012\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\u001A\u0010\u0016\u001A\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00150\nH&¢\u0006\u0004\b\u0017\u0010\rJE\u0010\u001B\u001A\u00020\u0007\"\b\b\u0000\u0010\u000E*\u00020\u00012\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\u001C\u0010\u001A\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00190\nH&¢\u0006\u0004\b\u001B\u0010\r¨\u0006\u001C"}, d2 = {"Lkotlinx/serialization/modules/SerializersModuleCollector;", "", "T", "LDe/d;", "kClass", "Lkotlinx/serialization/KSerializer;", "serializer", "Lie/H;", "contextual", "(LDe/d;Lkotlinx/serialization/KSerializer;)V", "Lkotlin/Function1;", "", "provider", "(LDe/d;Lwe/k;)V", "Base", "Sub", "baseClass", "actualClass", "actualSerializer", "polymorphic", "(LDe/d;LDe/d;Lkotlinx/serialization/KSerializer;)V", "Lkotlinx/serialization/SerializationStrategy;", "defaultSerializerProvider", "polymorphicDefaultSerializer", "", "Lkotlinx/serialization/DeserializationStrategy;", "defaultDeserializerProvider", "polymorphicDefaultDeserializer", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public interface SerializersModuleCollector {
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 0x30)
    public static abstract class DefaultImpls {
        public static KSerializer a(KSerializer kSerializer0, List list0) {
            return DefaultImpls.contextual$lambda$0(kSerializer0, list0);
        }

        public static void contextual(@NotNull SerializersModuleCollector serializersModuleCollector0, @NotNull d d0, @NotNull KSerializer kSerializer0) {
            q.g(d0, "kClass");
            q.g(kSerializer0, "serializer");
            serializersModuleCollector0.contextual(d0, new z(kSerializer0, 28));
        }

        private static KSerializer contextual$lambda$0(KSerializer kSerializer0, List list0) {
            q.g(list0, "it");
            return kSerializer0;
        }
    }

    void contextual(@NotNull d arg1, @NotNull KSerializer arg2);

    void contextual(@NotNull d arg1, @NotNull k arg2);

    void polymorphic(@NotNull d arg1, @NotNull d arg2, @NotNull KSerializer arg3);

    void polymorphicDefaultDeserializer(@NotNull d arg1, @NotNull k arg2);

    void polymorphicDefaultSerializer(@NotNull d arg1, @NotNull k arg2);
}

