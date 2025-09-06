package k5;

import kotlin.jvm.internal.q;
import pe.b;

public enum g {
    MEMORY_CACHE,
    MEMORY,
    DISK,
    NETWORK;

    public static final g[] e;

    static {
        g.e = arr_g;
        q.g(arr_g, "entries");
        new b(arr_g);
    }
}

