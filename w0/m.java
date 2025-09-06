package w0;

import ie.H;
import kotlin.jvm.internal.r;
import we.k;

public final class m extends r implements k {
    public final int f;
    public static final m g;
    public static final m h;
    public static final m i;

    static {
        m.g = new m(1, 0);
        m.h = new m(1, 1);
        m.i = new m(1, 2);
    }

    public m(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.f) {
            case 0: {
                a a0 = (a)object0;
                return H.a;
            }
            case 1: {
                a a1 = (a)object0;
                return H.a;
            }
            case 2: {
                return Boolean.valueOf(((u)object0).q0(7));
            }
            default: {
                return Boolean.valueOf(((u)object0).q0(7));
            }
        }
    }
}

