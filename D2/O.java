package D2;

import oe.c;

public final class o extends c {
    public final p B;
    public int D;
    public j r;
    public Object w;

    public o(p p0, c c0) {
        this.B = p0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.f(this);
    }
}

