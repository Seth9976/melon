package sc;

import ie.H;
import je.w;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class o extends i implements n {
    public Object r;
    public final P0 w;

    public o(P0 p00, Continuation continuation0) {
        this.w = p00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new o(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((o)this.create(((g1)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        g1 g10 = (g1)this.r;
        d5.n.D(object0);
        return g1.f(g10, null, 0, null, false, null, w.a, false, 0x5F);
    }
}

