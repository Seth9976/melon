package ha;

import oe.c;

public final class v extends c {
    public int B;
    public Object r;
    public final d5.v w;

    public v(d5.v v0, c c0) {
        this.w = v0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.G(null, null, 0, null, this);
    }
}

