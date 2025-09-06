package m1;

import ie.m;
import kotlin.jvm.internal.r;
import we.k;

public final class p extends r implements k {
    public final int f;
    public static final p g;
    public static final p h;
    public static final p i;
    public static final p j;
    public static final p k;

    static {
        p.g = new p(1, 0);
        p.h = new p(1, 1);
        p.i = new p(1, 2);
        p.j = new p(1, 3);
        p.k = new p(1, 4);
    }

    public p(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.f) {
            case 0: {
                return (o)((m)object0).b;
            }
            case 1: {
                q q0 = (q)object0;
                return true;
            }
            case 2: {
                return ((q)object0).a;
            }
            case 3: {
                return ((q)object0).b;
            }
            default: {
                return ((q)object0).a().size();
            }
        }
    }
}

