package hb;

import ea.a;

public final class c extends oe.c {
    public int B;
    public Object r;
    public final a w;

    public c(a a0, oe.c c0) {
        this.w = a0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.w(0, 0, this);
    }
}

