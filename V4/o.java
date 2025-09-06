package V4;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.q;

public abstract class o {
    public static final String a;
    public static final long b;

    static {
        q.f("WM-UnfinishedWorkListen", "tagWithPrefix(\"UnfinishedWorkListener\")");
        o.a = "WM-UnfinishedWorkListen";
        o.b = TimeUnit.HOURS.toMillis(1L);
    }
}

