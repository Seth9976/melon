package Q;

import N0.Z;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import we.k;

public final class d extends r implements k {
    public final int f;
    public static final d g;
    public static final d h;

    static {
        d.g = new d(1, 0);
        d.h = new d(1, 1);
    }

    public d(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.f != 0) {
            Z z0 = (Z)object0;
            return H.a;
        }
        Object object1 = ((List)object0).get(0);
        q.e(object1, "null cannot be cast to non-null type kotlin.Int");
        Object object2 = ((List)object0).get(1);
        q.e(object2, "null cannot be cast to non-null type kotlin.Float");
        return new e(((int)(((Integer)object1))), ((float)(((Float)object2))), new c(((List)object0)));
    }
}

