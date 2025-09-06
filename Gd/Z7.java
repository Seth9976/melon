package gd;

import oe.c;

public final class z7 extends c {
    public final O7 B;
    public int D;
    public String r;
    public Object w;

    public z7(O7 o70, c c0) {
        this.B = o70;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.f(null, this);
    }
}

