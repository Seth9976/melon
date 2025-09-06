package Qa;

import oe.c;

public final class e extends c {
    public int B;
    public Object r;
    public final I7.c w;

    public e(I7.c c0, c c1) {
        this.w = c0;
        super(c1);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.G(null, null, this);
    }
}

