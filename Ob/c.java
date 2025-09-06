package ob;

import kotlin.coroutines.Continuation;

public final class c extends oe.c {
    public final z B;
    public int D;
    public int r;
    public Object w;

    public c(z z0, Continuation continuation0) {
        this.B = z0;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.b(0, this);
    }
}

