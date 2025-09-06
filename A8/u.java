package A8;

import kotlin.jvm.internal.q;
import pe.b;
import z6.f;

public enum u {
    HIDE("0"),
    SHOW("1");

    public final String a;
    public static final f b;
    public static final u[] e;

    static {
        u.e = arr_u;
        q.g(arr_u, "entries");
        new b(arr_u);
        u.b = new f(4);
    }

    public u(String s1) {
        this.a = s1;
    }
}

