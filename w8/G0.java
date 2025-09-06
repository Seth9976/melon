package w8;

import kotlin.coroutines.Continuation;
import oe.c;
import pc.h0;

public final class g0 extends c {
    public final h0 B;
    public Object r;
    public int w;

    public g0(h0 h00, Continuation continuation0) {
        this.B = h00;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.w |= 0x80000000;
        return this.B.emit(null, this);
    }
}

