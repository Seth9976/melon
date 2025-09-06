package pc;

import oe.c;

public final class j0 extends c {
    public int B;
    public Object r;
    public final y0 w;

    public j0(y0 y00, c c0) {
        this.w = y00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.b(this);
    }
}

