package androidx.lifecycle;

import kotlin.jvm.internal.q;

public final class p {
    public static r a(s s0) {
        q.g(s0, "state");
        switch(s0.ordinal()) {
            case 2: {
                return r.ON_DESTROY;
            }
            case 3: {
                return r.ON_STOP;
            }
            case 4: {
                return r.ON_PAUSE;
            }
            default: {
                return null;
            }
        }
    }

    public static r b(s s0) {
        switch(s0.ordinal()) {
            case 2: {
                return r.ON_CREATE;
            }
            case 3: {
                return r.ON_START;
            }
            case 4: {
                return r.ON_RESUME;
            }
            default: {
                return null;
            }
        }
    }
}

