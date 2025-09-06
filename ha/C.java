package ha;

import d5.v;

public final class c extends oe.c {
    public int B;
    public Object r;
    public final v w;

    public c(v v0, oe.c c0) {
        this.w = v0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.i(null, null, null, null, null, this);
    }
}

