package i.n.i.b.a.s.e;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class Sd {
    public final W2 a;
    public final Uri b;
    public final Map c;
    public final long d;
    public final long e;
    public final long f;
    public static final AtomicLong g;

    static {
        Sd.g = new AtomicLong();
    }

    public Sd(W2 w20, long v) {
        this(w20, w20.b, Collections.EMPTY_MAP, v, 0L, 0L);
    }

    public Sd(W2 w20, Uri uri0, Map map0, long v, long v1, long v2) {
        this.a = w20;
        this.b = uri0;
        this.c = map0;
        this.d = v;
        this.e = v1;
        this.f = v2;
    }
}

