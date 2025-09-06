package fb;

import oe.c;
import x9.a;

public final class n extends c {
    public int B;
    public Object r;
    public final a w;

    public n(a a0, c c0) {
        this.w = a0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.A(null, this);
    }
}

