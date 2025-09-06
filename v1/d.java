package v1;

import N0.Z;
import X0.l;
import X0.s;
import X0.x;
import ie.H;
import kotlin.jvm.internal.r;
import we.k;

public final class d extends r implements k {
    public final int f;
    public static final d g;
    public static final d h;
    public static final d i;
    public static final d j;
    public static final d k;

    static {
        d.g = new d(1, 0);
        d.h = new d(1, 1);
        d.i = new d(1, 2);
        d.j = new d(1, 3);
        d.k = new d(1, 4);
    }

    public d(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        switch(this.f) {
            case 0: {
                ((Number)object0).longValue();
                return h0;
            }
            case 1: {
                Z z0 = (Z)object0;
                return h0;
            }
            case 2: {
                ((l)(((x)object0))).g(s.u, h0);
                return h0;
            }
            case 3: {
                Z z1 = (Z)object0;
                return h0;
            }
            default: {
                if(((m)object0).isAttachedToWindow()) {
                    ((m)object0).m();
                }
                return h0;
            }
        }
    }
}

