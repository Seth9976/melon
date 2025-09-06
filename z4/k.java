package z4;

import oe.c;

public final class k extends c {
    public final n B;
    public int D;
    public n r;
    public Object w;

    public k(n n0, c c0) {
        this.B = n0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.a(this);
    }
}

