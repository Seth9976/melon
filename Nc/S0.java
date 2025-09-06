package nc;

import kotlin.coroutines.Continuation;
import oe.c;

public final class s0 extends c {
    public int B;
    public Object r;
    public final u0 w;

    public s0(u0 u00, Continuation continuation0) {
        this.w = u00;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.U(null, null, this);
    }
}

