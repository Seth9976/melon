package ne;

import kotlin.jvm.internal.q;
import pe.b;

public enum a {
    COROUTINE_SUSPENDED,
    UNDECIDED,
    RESUMED;

    public static final a[] d;

    static {
        a.d = arr_a;
        q.g(arr_a, "entries");
        new b(arr_a);
    }
}

