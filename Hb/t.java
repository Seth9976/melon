package hb;

import oe.c;

public final class t extends c {
    public int B;
    public Object r;
    public final x9.c w;

    public t(x9.c c0, c c1) {
        this.w = c0;
        super(c1);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.e(this);
    }
}

