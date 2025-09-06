package va;

import oe.c;

public final class r1 extends c {
    public int B;
    public Object r;
    public final t1 w;

    public r1(t1 t10, c c0) {
        this.w = t10;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.d(null, this);
    }
}

