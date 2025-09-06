package tc;

import oe.c;

public final class w extends c {
    public int B;
    public Object r;
    public final x w;

    public w(x x0, c c0) {
        this.w = x0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.m(null, this);
    }
}

