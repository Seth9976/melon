package Vb;

import oe.c;

public final class k0 extends c {
    public int B;
    public Object r;
    public final o0 w;

    public k0(o0 o00, c c0) {
        this.w = o00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.v1(null, this);
    }
}

