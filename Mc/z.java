package Mc;

import Ac.P;
import kotlin.coroutines.Continuation;
import oe.c;

public final class z extends c {
    public final P B;
    public Object r;
    public int w;

    public z(P p0, Continuation continuation0) {
        this.B = p0;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.w |= 0x80000000;
        return this.B.emit(null, this);
    }
}

