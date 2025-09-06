package va;

import oe.c;

public final class e1 extends c {
    public int B;
    public Object D;
    public final j1 E;
    public int G;
    public long r;
    public long w;

    public e1(j1 j10, c c0) {
        this.E = j10;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.m(0L, this);
    }
}

