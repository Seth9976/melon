package Ze;

import kotlin.jvm.internal.q;
import pe.b;

public enum z {
    IGNORE("ignore"),
    WARN("warn"),
    STRICT("strict");

    public final String a;
    public static final z[] e;

    static {
        z.e = arr_z;
        q.g(arr_z, "entries");
        new b(arr_z);
    }

    public z(String s1) {
        this.a = s1;
    }
}

