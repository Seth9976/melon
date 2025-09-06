package ga;

import E9.g;
import oe.c;

public final class l extends c {
    public int B;
    public Object r;
    public final g w;

    public l(g g0, c c0) {
        this.w = g0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.k(null, this);
    }
}

