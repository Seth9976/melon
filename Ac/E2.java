package Ac;

import oe.c;

public final class e2 extends c {
    public int B;
    public Object r;
    public final g2 w;

    public e2(g2 g20, c c0) {
        this.w = g20;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.i(this);
    }
}

