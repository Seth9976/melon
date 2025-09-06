package Aa;

import oe.c;

public final class d extends c {
    public int B;
    public Object r;
    public final j w;

    public d(j j0, c c0) {
        this.w = j0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.c(this);
    }
}

