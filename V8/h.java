package v8;

import kotlin.jvm.internal.q;
import pe.b;

public enum h {
    SUCCESS,
    NOTIFICATION_ERROR,
    NETWORK_ERROR,
    LOAD_DEFAULT,
    LOAD_MORE;

    public static final h[] f;

    static {
        h.f = arr_h;
        q.g(arr_h, "entries");
        new b(arr_h);
    }
}

