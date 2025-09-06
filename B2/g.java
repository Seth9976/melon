package B2;

import kotlin.jvm.internal.r;
import we.a;

public final class g extends r implements a {
    public final int f;
    public static final g g;
    public static final g h;
    public static final g i;
    public static final g j;
    public static final g k;

    static {
        g.g = new g(0, 0);
        g.h = new g(0, 1);
        g.i = new g(0, 2);
        g.j = new g(0, 3);
        g.k = new g(0, 4);
    }

    public g(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.f) {
            case 0: {
                return I2.a.B;
            }
            case 1: {
                throw new IllegalStateException("No default context");
            }
            case 2: {
                throw new IllegalStateException("No default glance id");
            }
            case 3: {
                throw new IllegalStateException("No default size");
            }
            default: {
                return null;
            }
        }
    }
}

