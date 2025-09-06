package va;

import oe.c;

public final class g1 extends c {
    public int B;
    public Object r;
    public final j1 w;

    public g1(j1 j10, c c0) {
        this.w = j10;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.o(this);
    }
}

