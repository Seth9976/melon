package z4;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import me.i;
import oe.c;

public final class d extends c {
    public n B;
    public H D;
    public i E;
    public H G;
    public boolean I;
    public Object M;
    public final g N;
    public int S;
    public Object r;
    public Object w;

    public d(g g0, Continuation continuation0) {
        this.N = g0;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.M = object0;
        this.S |= 0x80000000;
        return this.N.d(false, null, this);
    }
}

