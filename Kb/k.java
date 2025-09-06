package kb;

import oe.c;

public final class k extends c {
    public final s B;
    public int D;
    public String r;
    public Object w;

    public k(s s0, c c0) {
        this.B = s0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.l(null, this);
    }
}

