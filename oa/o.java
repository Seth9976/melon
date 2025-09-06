package oa;

import oe.c;

public final class o extends c {
    public int B;
    public Object r;
    public final x w;

    public o(x x0, c c0) {
        this.w = x0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.c(null, this);
    }
}

