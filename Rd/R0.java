package rd;

import oe.c;

public final class r0 extends c {
    public Object r;
    public int w;

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.w |= 0x80000000;
        return a.w(null, null, this);
    }
}

