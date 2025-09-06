package eb;

import kotlin.coroutines.Continuation;
import oe.c;

public final class x extends c {
    public int B;
    public Object r;
    public final y w;

    public x(y y0, Continuation continuation0) {
        this.w = y0;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.a(null, null, this);
    }
}

