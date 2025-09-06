package I;

import oe.c;

public final class y0 extends c {
    public final z0 B;
    public int D;
    public z0 r;
    public Object w;

    public y0(z0 z00, c c0) {
        this.B = z00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.g(this);
    }
}

