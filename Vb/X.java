package Vb;

import b3.E;
import oe.c;

public final class x extends c {
    public final o0 B;
    public int D;
    public E r;
    public Object w;

    public x(o0 o00, c c0) {
        this.B = o00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.b1(null, null, 0, this);
    }
}

