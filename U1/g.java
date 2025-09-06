package u1;

import ie.H;
import kotlin.jvm.internal.r;
import we.a;

public final class g extends r implements a {
    public final int f;
    public static final g g;
    public static final g h;
    public static final g i;

    static {
        g.g = new g(0, 0);
        g.h = new g(0, 1);
        g.i = new g(0, 2);
    }

    public g(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.f) {
            case 0: {
                return H.a;
            }
            case 1: {
                return H.a;
            }
            default: {
                return H.a;
            }
        }
    }
}

