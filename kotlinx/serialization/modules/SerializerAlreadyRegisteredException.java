package kotlinx.serialization.modules;

import De.d;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\b\u0000\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B!\b\u0010\u0012\n\u0010\b\u001A\u0006\u0012\u0002\b\u00030\u0007\u0012\n\u0010\t\u001A\u0006\u0012\u0002\b\u00030\u0007¢\u0006\u0004\b\u0005\u0010\n¨\u0006\u000B"}, d2 = {"Lkotlinx/serialization/modules/SerializerAlreadyRegisteredException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "", "msg", "<init>", "(Ljava/lang/String;)V", "LDe/d;", "baseClass", "concreteClass", "(LDe/d;LDe/d;)V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
final class SerializerAlreadyRegisteredException extends IllegalArgumentException {
    public SerializerAlreadyRegisteredException(@NotNull d d0, @NotNull d d1) {
        q.g(d0, "baseClass");
        q.g(d1, "concreteClass");
        this("Serializer for " + d1 + " already registered in the scope of " + d0);
    }

    public SerializerAlreadyRegisteredException(@NotNull String s) {
        q.g(s, "msg");
        super(s);
    }
}

