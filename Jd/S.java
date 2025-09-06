package jd;

import oe.c;

public final class s extends c {
    public int B;
    public Object r;
    public final t w;

    public s(t t0, c c0) {
        this.w = t0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.a(null, this);
    }
}

