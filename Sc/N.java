package sc;

import oe.c;

public final class n extends c {
    public int B;
    public Object r;
    public final P0 w;

    public n(P0 p00, c c0) {
        this.w = p00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.N(false, this);
    }
}

