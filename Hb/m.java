package hb;

import ea.d;
import oe.c;

public final class m extends c {
    public int B;
    public Object r;
    public final d w;

    public m(d d0, c c0) {
        this.w = d0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.h(0, 0, null, this);
    }
}

