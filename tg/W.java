package tg;

import ne.a;
import oe.c;

public final class w extends c {
    public Object r;
    public int w;

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.w |= 0x80000000;
        b0.q(this, null);
        return a.a;
    }
}

