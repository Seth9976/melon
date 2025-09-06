package ta;

import oe.c;

public final class w extends c {
    public int B;
    public Object r;
    public final L w;

    public w(L l0, c c0) {
        this.w = l0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.k(null, null, this);
    }
}

