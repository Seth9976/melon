package Wa;

import Ua.h;
import oe.c;

public final class q extends c {
    public int B;
    public Object r;
    public final h w;

    public q(h h0, c c0) {
        this.w = h0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.l(null, this);
    }
}

