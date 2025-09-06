package Ic;

import oe.c;

public final class n0 extends c {
    public int B;
    public Object r;
    public final A0 w;

    public n0(A0 a00, c c0) {
        this.w = a00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.g(null, null, this);
    }
}

