package D2;

import ne.a;
import oe.c;

public final class r extends c {
    public int B;
    public Object r;
    public final s w;

    public r(s s0, c c0) {
        this.w = s0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        this.w.a(null, this);
        return a.a;
    }
}

