package Nb;

import oe.c;

public final class z extends c {
    public int B;
    public Object r;
    public final h0 w;

    public z(h0 h00, c c0) {
        this.w = h00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.e(this);
    }
}

