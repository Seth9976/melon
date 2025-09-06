package androidx.compose.runtime;

import P0.I;
import ie.H;
import kotlin.jvm.internal.r;
import we.n;

public final class g extends r implements n {
    public final int f;
    public static final g g;
    public static final g h;

    static {
        g.g = new g(2, 0);
        g.h = new g(2, 1);
    }

    public g(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.f) {
            case 0: {
                int v = ((Number)object1).intValue();
                if(!((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                    ((p)(((l)object0))).T();
                }
                return H.a;
            }
            case 1: {
                int v1 = ((Number)object1).intValue();
                if(!((p)(((l)object0))).Q(v1 & 1, (v1 & 3) != 2)) {
                    ((p)(((l)object0))).T();
                }
                return H.a;
            }
            default: {
                H h0 = (H)object1;
                ((I)object0).Z = true;
                return H.a;
            }
        }
    }
}

