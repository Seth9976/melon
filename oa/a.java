package oa;

import oe.c;

public final class a extends c {
    public int B;
    public Object r;
    public final oa.c w;

    public a(oa.c c0, c c1) {
        this.w = c0;
        super(c1);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.a(null, this);
    }
}

