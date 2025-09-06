package y0;

import N0.Z;
import N0.a0;
import gd.M6;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.r;
import we.k;

public final class l extends r implements k {
    public final int f;
    public final Object g;
    public final Object h;

    public l(int v, Object object0, Object object1) {
        this.f = v;
        this.g = object0;
        this.h = object1;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.f) {
            case 0: {
                Z.k(((Z)object0), ((a0)this.g), 0, 0, ((m)this.h).a, 4);
                return H.a;
            }
            case 1: {
                Z.k(((Z)object0), ((a0)this.g), 0, 0, ((S)this.h).m, 4);
                return H.a;
            }
            default: {
                int v = ((Number)object0).intValue();
                Object object1 = ((List)this.h).get(v);
                return ((M6)this.g).invoke(v, object1);
            }
        }
    }
}

