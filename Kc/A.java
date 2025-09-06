package kc;

import ie.p;
import oe.c;

public final class a extends c {
    public int B;
    public Object r;
    public final kc.c w;

    public a(kc.c c0, c c1) {
        this.w = c0;
        super(c1);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        Object object1 = this.w.a(null, this);
        return object1 == ne.a.a ? object1 : new p(object1);
    }
}

