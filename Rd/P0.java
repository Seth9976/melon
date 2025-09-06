package rd;

import oe.c;

public final class p0 extends c {
    public Object r;
    public int w;

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.w |= 0x80000000;
        return a.v(null, this);
    }
}

