package hb;

import oe.c;

public final class a extends c {
    public int B;
    public Object r;
    public final ea.a w;

    public a(ea.a a0, c c0) {
        this.w = a0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.u(0, 0, null, this);
    }
}

