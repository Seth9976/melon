package kotlinx.serialization.modules;

import De.d;
import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\n\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u00052\u0012\b\u0002\u0010\t\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007H\'¢\u0006\u0004\b\n\u0010\u000BJ9\u0010\u000F\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000E\"\b\b\u0000\u0010\u0004*\u00020\u00012\u000E\u0010\f\u001A\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00052\u0006\u0010\r\u001A\u00028\u0000H\'¢\u0006\u0004\b\u000F\u0010\u0010J;\u0010\u000F\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0013\"\b\b\u0000\u0010\u0004*\u00020\u00012\u000E\u0010\f\u001A\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00052\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\'¢\u0006\u0004\b\u000F\u0010\u0014J\u0017\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0016\u001A\u00020\u0015H\'¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0001\u0001\u001A¨\u0006\u001B"}, d2 = {"Lkotlinx/serialization/modules/SerializersModule;", "", "<init>", "()V", "T", "LDe/d;", "kClass", "", "Lkotlinx/serialization/KSerializer;", "typeArgumentsSerializers", "getContextual", "(LDe/d;Ljava/util/List;)Lkotlinx/serialization/KSerializer;", "baseClass", "value", "Lkotlinx/serialization/SerializationStrategy;", "getPolymorphic", "(LDe/d;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "", "serializedClassName", "Lkotlinx/serialization/DeserializationStrategy;", "(LDe/d;Ljava/lang/String;)Lkotlinx/serialization/DeserializationStrategy;", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "collector", "Lie/H;", "dumpTo", "(Lkotlinx/serialization/modules/SerializersModuleCollector;)V", "Lkotlinx/serialization/modules/SerialModuleImpl;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public abstract class SerializersModule {
    private SerializersModule() {
    }

    public SerializersModule(DefaultConstructorMarker defaultConstructorMarker0) {
    }

    public abstract void dumpTo(@NotNull SerializersModuleCollector arg1);

    @Nullable
    public abstract KSerializer getContextual(@NotNull d arg1, @NotNull List arg2);

    public static KSerializer getContextual$default(SerializersModule serializersModule0, d d0, List list0, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContextual");
        }
        if((v & 2) != 0) {
            list0 = w.a;
        }
        return serializersModule0.getContextual(d0, list0);
    }

    @Nullable
    public abstract DeserializationStrategy getPolymorphic(@NotNull d arg1, @Nullable String arg2);

    @Nullable
    public abstract SerializationStrategy getPolymorphic(@NotNull d arg1, @NotNull Object arg2);
}

