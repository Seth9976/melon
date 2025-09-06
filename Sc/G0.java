package sc;

import oc.M;
import oe.c;

public final class g0 extends c {
    public final P0 B;
    public int D;
    public M r;
    public Object w;

    public g0(P0 p00, c c0) {
        this.B = p00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.X(null, this);
    }
}

