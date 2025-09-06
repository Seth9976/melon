package o4;

import kotlin.coroutines.Continuation;
import oe.c;

public final class e extends c {
    public final f B;
    public int D;
    public Object r;
    public Object w;

    public e(f f0, Continuation continuation0) {
        this.B = f0;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.c(null, null, this);
    }
}

