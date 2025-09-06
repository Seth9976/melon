package hf;

import kotlin.jvm.internal.q;
import pe.b;

public enum p {
    FLEXIBLE_LOWER,
    FLEXIBLE_UPPER,
    INFLEXIBLE;

    public static final p[] d;

    static {
        p.d = arr_p;
        q.g(arr_p, "entries");
        new b(arr_p);
    }
}

