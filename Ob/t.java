package ob;

import oe.c;

public final class t extends c {
    public final z B;
    public int D;
    public boolean r;
    public Object w;

    public t(z z0, c c0) {
        this.B = z0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.x(false, this);
    }
}

