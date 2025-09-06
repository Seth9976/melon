package cc;

import b3.E;
import oe.c;

public final class b extends c {
    public final cc.c B;
    public int D;
    public E r;
    public Object w;

    public b(cc.c c0, c c1) {
        this.B = c0;
        super(c1);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.b(null, this);
    }
}

