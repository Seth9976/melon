package b0;

import X0.u;
import X0.x;
import ie.H;
import kotlin.jvm.internal.r;
import we.k;

public final class f extends r implements k {
    public final int f;
    public static final f g;
    public static final f h;

    static {
        f.g = new f(1, 0);
        f.h = new f(1, 1);
    }

    public f(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.f != 0) {
            x x0 = (x)object0;
            return H.a;
        }
        u.k(((x)object0), 0);
        return H.a;
    }
}

