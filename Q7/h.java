package Q7;

import oe.c;

public final class h extends c {
    public final i B;
    public int D;
    public i r;
    public Object w;

    public h(i i0, c c0) {
        this.B = i0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.b(this);
    }
}

