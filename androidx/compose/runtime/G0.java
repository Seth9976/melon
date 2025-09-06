package androidx.compose.runtime;

import Q0.b0;
import kotlin.coroutines.Continuation;
import oe.c;
import we.k;

public final class g0 extends c {
    public Object B;
    public final b0 D;
    public int E;
    public b0 r;
    public k w;

    public g0(b0 b00, Continuation continuation0) {
        this.D = b00;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.c(null, this);
    }
}

