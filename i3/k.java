package i3;

import android.media.metrics.LogSessionId;

public final class k {
    public final LogSessionId a;
    public static final k b;

    static {
        k.b = new k(LogSessionId.LOG_SESSION_ID_NONE);
    }

    public k(LogSessionId logSessionId0) {
        this.a = logSessionId0;
    }
}

