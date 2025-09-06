package rb;

import oe.c;

public final class g extends c {
    public int B;
    public Object r;
    public final i w;

    public g(i i0, c c0) {
        this.w = i0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.g(null, this);
    }
}

