package ha;

import d5.v;
import oe.c;

public final class h extends c {
    public int B;
    public Object r;
    public final v w;

    public h(v v0, c c0) {
        this.w = v0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.q(0, 0, null, null, this);
    }
}

