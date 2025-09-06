package lc;

import oe.c;

public final class d extends c {
    public Object B;
    public final g D;
    public int E;
    public g r;
    public int w;

    public d(g g0, c c0) {
        this.D = g0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return g.b(this.D, this);
    }
}

