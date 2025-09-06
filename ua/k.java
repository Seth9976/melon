package Ua;

import oe.c;

public final class k extends c {
    public int B;
    public Object r;
    public final n w;

    public k(n n0, c c0) {
        this.w = n0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.c(null, null, this);
    }
}

