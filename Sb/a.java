package sb;

import oe.c;
import pc.t;

public final class a extends c {
    public int B;
    public Object r;
    public final t w;

    public a(t t0, c c0) {
        this.w = t0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.p(null, null, null, null, null, this);
    }
}

