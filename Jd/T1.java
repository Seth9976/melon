package jd;

import oe.c;

public final class t1 extends c {
    public int B;
    public Object r;
    public final u1 w;

    public t1(u1 u10, c c0) {
        this.w = u10;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.h(null, this);
    }
}

