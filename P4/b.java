package p4;

import kotlin.coroutines.Continuation;
import oe.c;

public final class b extends c {
    public final p4.c B;
    public int D;
    public p4.c r;
    public Object w;

    public b(p4.c c0, Continuation continuation0) {
        this.B = c0;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return p4.c.b(this.B, this);
    }
}

