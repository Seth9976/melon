package z9;

import oe.c;

public final class u extends c {
    public int B;
    public Object r;
    public final F w;

    public u(F f0, c c0) {
        this.w = f0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.k(this);
    }
}

