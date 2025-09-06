package qc;

import oe.c;

public final class k extends c {
    public int B;
    public Object r;
    public final n0 w;

    public k(n0 n00, c c0) {
        this.w = n00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.F(false, this);
    }
}

