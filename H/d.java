package H;

import J0.L;
import U4.F;
import oe.c;

public final class d extends c {
    public int B;
    public L r;
    public Object w;

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.B |= 0x80000000;
        return F.h(null, this);
    }
}

