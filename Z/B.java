package Z;

import De.w;
import X0.s;
import X0.u;
import X0.x;
import ie.H;
import kotlin.jvm.internal.r;
import we.k;

public final class b extends r implements k {
    public final int f;
    public static final b g;
    public static final b h;
    public static final b i;

    static {
        b.g = new b(1, 0);
        b.h = new b(1, 1);
        b.i = new b(1, 2);
    }

    public b(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        switch(this.f) {
            case 0: {
                u.k(((x)object0), 0);
                return h0;
            }
            case 1: {
                x x0 = (x)object0;
                return h0;
            }
            default: {
                w w0 = u.a[5];
                s.l.a(((x)object0), Boolean.TRUE);
                return h0;
            }
        }
    }
}

