package hb;

import E9.g;
import oe.c;

public final class w extends c {
    public final g B;
    public int D;
    public Object r;
    public Object w;

    public w(g g0, c c0) {
        this.B = g0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.b(null, null, this);
    }
}

