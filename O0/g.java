package o0;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.r;
import we.a;

public final class g extends r implements a {
    public final int f;
    public static final g g;
    public static final g h;

    static {
        g.g = new g(0, 0);
        g.h = new g(0, 1);
    }

    public g(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.a
    public final Object invoke() {
        return this.f != 0 ? null : new f(new LinkedHashMap());
    }
}

