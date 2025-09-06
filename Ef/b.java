package ef;

import kotlin.jvm.internal.q;

public enum b {
    INFLEXIBLE,
    FLEXIBLE_UPPER_BOUND,
    FLEXIBLE_LOWER_BOUND;

    public static final b[] d;

    static {
        b.d = arr_b;
        q.g(arr_b, "entries");
        new pe.b(arr_b);
    }
}

