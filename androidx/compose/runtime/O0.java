package androidx.compose.runtime;

import kotlin.jvm.internal.q;
import pe.b;

public enum o0 {
    ShutDown,
    ShuttingDown,
    Inactive,
    InactivePendingWork,
    Idle,
    PendingWork;

    public static final o0[] g;

    static {
        o0.g = arr_o0;
        q.g(arr_o0, "entries");
        new b(arr_o0);
    }
}

