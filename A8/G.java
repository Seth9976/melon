package A8;

import kotlin.jvm.internal.q;
import pe.b;

public enum g {
    PRE_INSTALLED("0"),
    APP_INSTALL("1");

    public final String a;
    public static final g[] d;

    static {
        g.d = arr_g;
        q.g(arr_g, "entries");
        new b(arr_g);
    }

    public g(String s1) {
        this.a = s1;
    }
}

