package nc;

import oe.c;

public final class x0 extends c {
    public int B;
    public Object r;
    public final B0 w;

    public x0(B0 b00, c c0) {
        this.w = b00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.c(this);
    }
}

