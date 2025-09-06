package ja;

import oe.c;

public final class e extends c {
    public int B;
    public Object r;
    public final g w;

    public e(g g0, c c0) {
        this.w = g0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.e(null, this);
    }
}

