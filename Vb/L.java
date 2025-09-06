package vb;

import Q0.a;
import kotlin.coroutines.Continuation;
import oe.c;

public final class l extends c {
    public final o B;
    public int D;
    public a r;
    public Object w;

    public l(o o0, Continuation continuation0) {
        this.B = o0;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.c(null, this);
    }
}

