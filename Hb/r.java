package hb;

import oe.c;
import x9.b;

public final class r extends c {
    public int B;
    public Object r;
    public final b w;

    public r(b b0, c c0) {
        this.w = b0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.t(null, null, this);
    }
}

