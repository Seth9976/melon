package androidx.room;

import oe.c;
import y4.a;

public final class e0 extends c {
    public final h0 B;
    public int D;
    public a r;
    public Object w;

    public e0(h0 h00, c c0) {
        this.B = h00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.f(this);
    }
}

