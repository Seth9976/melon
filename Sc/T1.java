package sc;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class t1 extends c {
    public S2 B;
    public Object D;
    public Object E;
    public String G;
    public int I;
    public int M;
    public int N;
    public int S;
    public long T;
    public Object V;
    public final q1 W;
    public int X;
    public Mutex r;
    public String w;

    public t1(q1 q10, Continuation continuation0) {
        this.W = q10;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.V = object0;
        this.X |= 0x80000000;
        return this.W.execute(this);
    }
}

