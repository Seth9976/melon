package kb;

import oe.c;

public final class v extends c {
    public int B;
    public Object r;
    public final A w;

    public v(A a0, c c0) {
        this.w = a0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.c(null, null, null, this);
    }
}

