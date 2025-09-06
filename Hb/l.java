package hb;

import oe.c;

public final class l extends c {
    public int B;
    public Object r;
    public final ea.c w;

    public l(ea.c c0, c c1) {
        this.w = c0;
        super(c1);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.g(this);
    }
}

