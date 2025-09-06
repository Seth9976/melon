package I;

import oe.c;

public final class r0 extends c {
    public final t0 B;
    public int D;
    public t0 r;
    public Object w;

    public r0(t0 t00, c c0) {
        this.B = t00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.l(null, null, this);
    }
}

