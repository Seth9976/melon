package Ya;

import oe.c;

public final class d extends c {
    public int B;
    public Object r;
    public final g w;

    public d(g g0, c c0) {
        this.w = g0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.d(null, null, this);
    }
}

