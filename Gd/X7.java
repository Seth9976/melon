package gd;

import oe.c;

public final class x7 extends c {
    public int B;
    public Object r;
    public final O7 w;

    public x7(O7 o70, c c0) {
        this.w = o70;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.e(this);
    }
}

