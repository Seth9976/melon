package O;

import N0.Z;
import ie.H;
import java.util.List;
import we.k;

public final class r extends kotlin.jvm.internal.r implements k {
    public final int f;
    public static final r g;
    public static final r h;
    public static final r i;

    static {
        r.g = new r(1, 0);
        r.h = new r(1, 1);
        r.i = new r(1, 2);
    }

    public r(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.f) {
            case 0: {
                Z z0 = (Z)object0;
                return H.a;
            }
            case 1: {
                ((Number)object0).intValue();
                return null;
            }
            case 2: {
                return new F(((Number)((List)object0).get(0)).intValue(), ((Number)((List)object0).get(1)).intValue());
            }
            default: {
                ((Number)object0).intValue();
                return null;
            }
        }
    }
}

