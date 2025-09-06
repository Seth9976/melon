package Q0;

import ne.a;
import oe.c;

public final class t extends c {
    public int B;
    public Object r;
    public final u w;

    public t(u u0, c c0) {
        this.w = u0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        this.w.K(null, this);
        return a.a;
    }
}

