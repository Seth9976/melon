package kc;

import oe.c;
import x9.b;

public final class f2 extends c {
    public final b B;
    public int D;
    public boolean r;
    public Object w;

    public f2(b b0, c c0) {
        this.B = b0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.w(false, this);
    }
}

