package w8;

import ne.a;
import oe.c;

public final class t0 extends c {
    public int B;
    public Object r;
    public final w0 w;

    public t0(w0 w00, c c0) {
        this.w = w00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        w0.v(this.w, null, null, this);
        return a.a;
    }
}

