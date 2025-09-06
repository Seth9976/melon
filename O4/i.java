package o4;

import kotlin.coroutines.Continuation;
import oe.c;

public final class i extends c {
    public int B;
    public Object r;
    public final j w;

    public i(j j0, Continuation continuation0) {
        this.w = j0;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return j.k(this.w, null, this);
    }
}

