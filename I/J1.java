package I;

import J0.L;
import oe.c;

public final class j1 extends c {
    public int B;
    public L r;
    public Object w;

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.B |= 0x80000000;
        return G1.a(null, this);
    }
}

