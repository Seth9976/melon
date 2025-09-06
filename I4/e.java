package I4;

import kotlin.jvm.internal.q;
import pe.b;

public enum e {
    ON_CONFIGURE,
    ON_CREATE,
    ON_UPGRADE,
    ON_DOWNGRADE,
    ON_OPEN;

    public static final e[] f;

    static {
        e.f = arr_e;
        q.g(arr_e, "entries");
        new b(arr_e);
    }
}

