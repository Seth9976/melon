package ub;

import oe.c;

public final class j extends c {
    public int B;
    public Object r;
    public final l w;

    public j(l l0, c c0) {
        this.w = l0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.d(this);
    }
}

