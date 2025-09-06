package n4;

import kotlin.coroutines.Continuation;

public final class c extends oe.c {
    public final d B;
    public int D;
    public d r;
    public Object w;

    public c(d d0, Continuation continuation0) {
        this.B = d0;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return d.b(this.B, this);
    }
}

