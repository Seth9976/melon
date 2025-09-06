package nd;

import kotlin.jvm.internal.q;

public enum b {
    STRATEGY_NONE_SCROLL,
    STRATEGY_PARALLAX_SCROLL;

    public static final b[] c;

    static {
        b.c = arr_b;
        q.g(arr_b, "entries");
        new pe.b(arr_b);
    }
}

