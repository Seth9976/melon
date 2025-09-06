package nc;

import kotlin.jvm.internal.C;
import oe.c;

public final class h0 extends c {
    public final u0 B;
    public int D;
    public C r;
    public Object w;

    public h0(u0 u00, c c0) {
        this.B = u00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.R(null, false, this);
    }
}

