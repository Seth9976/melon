package w1;

import java.util.concurrent.Executor;

public final class d {
    public final Runnable a;
    public final Executor b;
    public d c;
    public static final d d;

    static {
        d.d = new d(null, null);
    }

    public d(Runnable runnable0, Executor executor0) {
        this.a = runnable0;
        this.b = executor0;
    }
}

