package R8;

import kotlin.coroutines.Continuation;
import oe.c;

public final class z extends c {
    public int B;
    public Object r;
    public final A w;

    public z(A a0, Continuation continuation0) {
        this.w = a0;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.backgroundWork(null, this);
    }
}

