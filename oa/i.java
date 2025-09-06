package oa;

import oe.c;

public final class i extends c {
    public int B;
    public Object r;
    public final k w;

    public i(k k0, c c0) {
        this.w = k0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.e(null, this);
    }
}

