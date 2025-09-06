package va;

import oe.c;

public final class j0 extends c {
    public int B;
    public Object r;
    public final I0 w;

    public j0(I0 i00, c c0) {
        this.w = i00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.a(this);
    }
}

