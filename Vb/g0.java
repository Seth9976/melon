package Vb;

import oe.c;

public final class g0 extends c {
    public final o0 B;
    public int D;
    public long r;
    public Object w;

    public g0(o0 o00, c c0) {
        this.B = o00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.t1(0L, this);
    }
}

