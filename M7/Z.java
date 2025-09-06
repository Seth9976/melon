package M7;

import oe.c;

public final class z extends c {
    public final A B;
    public int D;
    public Object r;
    public Object w;

    public z(A a0, c c0) {
        this.B = a0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.a(null, this);
    }
}

