package Mb;

import oe.c;

public final class u extends c {
    public int B;
    public Object r;
    public final v w;

    public u(v v0, c c0) {
        this.w = v0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.j(this);
    }
}

