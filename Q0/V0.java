package Q0;

import kotlin.jvm.internal.r;
import we.a;

public final class v0 extends r implements a {
    public final int f;
    public static final v0 g;
    public static final v0 h;

    static {
        v0.g = new v0(0, 0);
        v0.h = new v0(0, 1);
    }

    public v0(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.a
    public final Object invoke() {
        return this.f != 0 ? null : false;
    }
}

