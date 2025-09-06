package ob;

import kotlin.coroutines.Continuation;
import oe.c;

public final class p extends c {
    public int B;
    public Object r;
    public final z w;

    public p(z z0, Continuation continuation0) {
        this.w = z0;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.o(this);
    }
}

