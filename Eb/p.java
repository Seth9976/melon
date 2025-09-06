package eb;

import oe.c;

public final class p extends c {
    public final d5.c B;
    public int D;
    public q r;
    public Object w;

    public p(d5.c c0, c c1) {
        this.B = c0;
        super(c1);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.h(null, this);
    }
}

