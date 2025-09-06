package kotlinx.serialization.modules;

import je.x;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\" \u0010\u0001\u001A\u00020\u00008\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0001\u0010\u0002\u0012\u0004\b\u0005\u0010\u0006\u001A\u0004\b\u0003\u0010\u0004*>\b\u0000\u0010\u000B\u001A\u0004\b\u0000\u0010\u0007\"\u0018\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n0\b2\u0018\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n0\b*:\b\u0000\u0010\r\u001A\u0004\b\u0000\u0010\u0007\"\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f0\b2\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f0\b¨\u0006\u000E"}, d2 = {"Lkotlinx/serialization/modules/SerializersModule;", "EmptySerializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getEmptySerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "getEmptySerializersModule$annotations", "()V", "Base", "Lkotlin/Function1;", "", "Lkotlinx/serialization/DeserializationStrategy;", "PolymorphicDeserializerProvider", "Lkotlinx/serialization/SerializationStrategy;", "PolymorphicSerializerProvider", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class SerializersModuleKt {
    @NotNull
    private static final SerializersModule EmptySerializersModule;

    static {
        SerializersModuleKt.EmptySerializersModule = new SerialModuleImpl(x.a, x.a, x.a, x.a, x.a, false);
    }

    @NotNull
    public static final SerializersModule getEmptySerializersModule() {
        return SerializersModuleKt.EmptySerializersModule;
    }
}

