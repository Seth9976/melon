package nc;

import oc.M;
import oe.c;

public final class d0 extends c {
    public final u0 B;
    public int D;
    public M r;
    public Object w;

    public d0(u0 u00, c c0) {
        this.B = u00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.Q(null, this);
    }
}

