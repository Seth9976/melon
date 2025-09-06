package ub;

import oe.c;

public final class a extends c {
    public int B;
    public Object D;
    public final f E;
    public int G;
    public f r;
    public int w;

    public a(f f0, c c0) {
        this.E = f0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.a(this);
    }
}

