package va;

import oe.c;

public final class w0 extends c {
    public final I0 B;
    public int D;
    public boolean r;
    public Object w;

    public w0(I0 i00, c c0) {
        this.B = i00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.e(false, this);
    }
}

