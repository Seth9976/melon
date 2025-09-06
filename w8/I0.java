package w8;

import ne.a;
import oe.c;

public final class i0 extends c {
    public int B;
    public Object r;
    public final k0 w;

    public i0(k0 k00, c c0) {
        this.w = k00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        this.w.f(null, null, this);
        return a.a;
    }
}

