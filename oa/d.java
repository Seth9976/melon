package oa;

import oe.c;

public final class d extends c {
    public int B;
    public Object r;
    public final e w;

    public d(e e0, c c0) {
        this.w = e0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.a(this);
    }
}

