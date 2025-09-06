package ob;

import oc.H;
import oe.c;
import oe.i;

public final class y extends c {
    public int B;
    public Object D;
    public final z E;
    public int G;
    public i r;
    public H w;

    public y(z z0, c c0) {
        this.E = z0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.I(null, this);
    }
}

