package fb;

import ea.d;
import oe.c;

public final class b extends c {
    public int B;
    public Object r;
    public final d w;

    public b(d d0, c c0) {
        this.w = d0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.k(this);
    }
}

