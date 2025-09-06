package sc;

import kotlin.jvm.internal.C;
import oe.c;

public final class k0 extends c {
    public final P0 B;
    public int D;
    public C r;
    public Object w;

    public k0(P0 p00, c c0) {
        this.B = p00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.Y(null, false, this);
    }
}

