package kc;

import oc.H;
import oe.c;

public final class f extends c {
    public final h B;
    public int D;
    public H r;
    public Object w;

    public f(h h0, c c0) {
        this.B = h0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.a(this);
    }
}

