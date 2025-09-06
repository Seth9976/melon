package pb;

import e1.F;

public final class c extends oe.c {
    public int B;
    public Object r;
    public final F w;

    public c(F f0, oe.c c0) {
        this.w = f0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.t(false, false, null, this);
    }
}

