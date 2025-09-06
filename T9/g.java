package t9;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Deferred;
import oe.c;

public final class g extends c {
    public int B;
    public Object D;
    public final j E;
    public int G;
    public Deferred r;
    public String w;

    public g(j j0, Continuation continuation0) {
        this.E = j0;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.a(null, this);
    }
}

