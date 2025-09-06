package bb;

import H8.q;

public final class c extends oe.c {
    public int B;
    public Object r;
    public final q w;

    public c(q q0, oe.c c0) {
        this.w = q0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.h(null, null, null, this);
    }
}

