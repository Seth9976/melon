package z9;

import oe.c;

public final class n extends c {
    public final F B;
    public int D;
    public String r;
    public Object w;

    public n(F f0, c c0) {
        this.B = f0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.c(null, this);
    }
}

