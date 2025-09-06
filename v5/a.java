package V5;

import R5.f;
import X5.d;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

public final class a implements c {
    public final W5.c a;
    public final Executor b;
    public final f c;
    public final d d;
    public final Y5.c e;
    public static final Logger f;

    static {
        a.f = Logger.getLogger("Q5.u");
    }

    public a(Executor executor0, f f0, W5.c c0, d d0, Y5.c c1) {
        this.b = executor0;
        this.c = f0;
        this.a = c0;
        this.d = d0;
        this.e = c1;
    }
}

