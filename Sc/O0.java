package sc;

import oe.c;

public final class o0 extends c {
    public final P0 B;
    public int D;
    public boolean r;
    public Object w;

    public o0(P0 p00, c c0) {
        this.B = p00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.Z(false, this);
    }
}

