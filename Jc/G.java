package jc;

import d5.n;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.k;

public final class g extends i implements k {
    public final d r;

    public g(d d0, Continuation continuation0) {
        this.r = d0;
        super(1, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Continuation continuation0) {
        return new g(this.r, continuation0);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        ((g)this.create(((Continuation)object0))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        n.D(object0);
        j.b(e.k.z(this.r));
        return H.a;
    }
}

