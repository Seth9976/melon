package N9;

import kotlin.jvm.internal.q;

public enum b {
    NONE,
    PREPARE,
    ERROR,
    CONNECTED;

    public static final b[] e;

    static {
        b.e = arr_b;
        q.g(arr_b, "entries");
        new pe.b(arr_b);
    }
}

