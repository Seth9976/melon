package Y;

import H0.e;
import J0.L;
import oe.c;

public final class p extends c {
    public int B;
    public L r;
    public Object w;

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.B |= 0x80000000;
        return e.q(null, this);
    }
}

