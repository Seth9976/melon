package s3;

import g3.j;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class q {
    public final Map a;
    public final long b;
    public static final AtomicLong c;

    static {
        q.c = new AtomicLong();
    }

    public q(j j0) {
        this(Collections.EMPTY_MAP, 0L);
    }

    public q(Map map0, long v) {
        this.a = map0;
        this.b = v;
    }
}

