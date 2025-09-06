package ob;

import oe.c;

public final class n extends c {
    public int B;
    public Object r;
    public final z w;

    public n(z z0, c c0) {
        this.w = z0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.l(this);
    }
}

