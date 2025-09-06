package kc;

import Ac.E2;
import kotlin.coroutines.Continuation;
import oe.c;

public final class a2 extends c {
    public final E2 B;
    public Object r;
    public int w;

    public a2(E2 e20, Continuation continuation0) {
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

