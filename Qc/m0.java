package qc;

import kotlin.coroutines.Continuation;
import oe.c;

public final class m0 extends c {
    public int B;
    public Object r;
    public final n0 w;

    public m0(n0 n00, Continuation continuation0) {
        this.w = n00;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.Q(null, this);
    }
}

