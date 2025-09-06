package Nb;

import Ac.E2;
import kotlin.coroutines.Continuation;
import oe.c;

public final class r0 extends c {
    public final E2 B;
    public Object r;
    public int w;

    public r0(E2 e20, Continuation continuation0) {
        this.B = e20;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.w |= 0x80000000;
        return this.B.emit(null, this);
    }
}

