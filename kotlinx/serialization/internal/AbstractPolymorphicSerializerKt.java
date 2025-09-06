package kotlinx.serialization.internal;

import De.d;
import i.n.i.b.a.s.e.M3;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.SerializationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0005\u001A%\u0010\u0005\u001A\u00020\u00042\b\u0010\u0001\u001A\u0004\u0018\u00010\u00002\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001A\'\u0010\u0005\u001A\u00020\u00042\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u00022\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\b¨\u0006\t"}, d2 = {"", "subClassName", "LDe/d;", "baseClass", "", "throwSubtypeNotRegistered", "(Ljava/lang/String;LDe/d;)Ljava/lang/Void;", "subClass", "(LDe/d;LDe/d;)Ljava/lang/Void;", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class AbstractPolymorphicSerializerKt {
    @NotNull
    public static final Void throwSubtypeNotRegistered(@NotNull d d0, @NotNull d d1) {
        q.g(d0, "subClass");
        q.g(d1, "baseClass");
        String s = d0.m();
        if(s == null) {
            s = String.valueOf(d0);
        }
        AbstractPolymorphicSerializerKt.throwSubtypeNotRegistered(s, d1);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @NotNull
    public static final Void throwSubtypeNotRegistered(@Nullable String s, @NotNull d d0) {
        String s2;
        q.g(d0, "baseClass");
        String s1 = "in the polymorphic scope of \'" + d0.m() + '\'';
        if(s == null) {
            s2 = "Class discriminator was missing and no default serializers were registered " + s1 + '.';
        }
        else {
            StringBuilder stringBuilder0 = A7.d.o("Serializer for subclass \'", s, "\' is not found ", s1, ".\nCheck if class with serial name \'");
            A7.d.u(stringBuilder0, s, "\' exists and serializer is registered in a corresponding SerializersModule.\nTo be registered automatically, class \'", s, "\' has to be \'@Serializable\', and the base class \'");
            stringBuilder0.append(d0.m());
            stringBuilder0.append("\' has to be sealed and \'@Serializable\'.");
            s2 = stringBuilder0.toString();
        }
        throw new SerializationException(s2);
    }
}

