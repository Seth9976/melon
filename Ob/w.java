package ob;

import ac.d;
import oe.c;

public final class w extends c {
    public final z B;
    public int D;
    public d r;
    public Object w;

    public w(z z0, c c0) {
        this.B = z0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.G(this);
    }
}

