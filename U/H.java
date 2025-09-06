package U;

import kotlin.jvm.internal.r;
import r1.j;
import we.a;
import y0.s;

public final class h extends r implements a {
    public final int f;
    public static final h g;
    public static final h h;
    public static final h i;

    static {
        h.g = new h(0, 0);
        h.h = new h(0, 1);
        h.i = new h(0, 2);
    }

    public h(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.f) {
            case 0: {
                return new s(0x4DFFEB3B00000000L);
            }
            case 1: {
                return new j(0L);
            }
            default: {
                return new j(0L);
            }
        }
    }
}

