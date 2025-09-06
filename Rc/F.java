package rc;

import oe.c;

public final class f extends c {
    public int B;
    public Object r;
    public final m w;

    public f(m m0, c c0) {
        this.w = m0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.f(null, this);
    }
}

