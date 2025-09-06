package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/serialization/json/ClassDiscriminatorMode;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "ALL_JSON_OBJECTS", "POLYMORPHIC", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public enum ClassDiscriminatorMode {
    NONE,
    ALL_JSON_OBJECTS,
    POLYMORPHIC;

    private static final a $ENTRIES;
    private static final ClassDiscriminatorMode[] $VALUES;

    private static final ClassDiscriminatorMode[] $values() [...] // Inlined contents

    static {
        ClassDiscriminatorMode.$VALUES = arr_classDiscriminatorMode;
        q.g(arr_classDiscriminatorMode, "entries");
        ClassDiscriminatorMode.$ENTRIES = new b(arr_classDiscriminatorMode);
    }
}

