package sb;

import pc.t;

public final class c extends oe.c {
    public int B;
    public Object r;
    public final t w;

    public c(t t0, oe.c c0) {
        this.w = t0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.z(null, this);
    }
}

