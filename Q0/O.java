package Q0;

import kotlin.jvm.internal.r;
import w0.d;
import w0.u;
import we.k;

public final class o extends r implements k {
    public final int f;
    public final d g;

    public o(d d0, int v) {
        this.f = v;
        this.g = d0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return Boolean.valueOf(((u)object0).q0(this.g.a));
    }
}

