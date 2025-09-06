package androidx.lifecycle;

import kotlin.jvm.internal.q;
import pe.b;

public enum s {
    DESTROYED,
    INITIALIZED,
    CREATED,
    STARTED,
    RESUMED;

    public static final s[] f;

    static {
        s.f = arr_s;
        q.g(arr_s, "entries");
        new b(arr_s);
    }

    public final boolean a(s s0) {
        return this.compareTo(s0) >= 0;
    }
}

