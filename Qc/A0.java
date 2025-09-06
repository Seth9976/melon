package qc;

import oe.c;

public final class a0 extends c {
    public final n0 B;
    public int D;
    public boolean r;
    public Object w;

    public a0(n0 n00, c c0) {
        this.B = n00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.O(false, this);
    }
}

