package kc;

import d5.n;
import ie.H;
import kotlin.coroutines.Continuation;
import oc.f0;
import oe.i;
import we.k;

public final class b0 extends i implements k {
    public final f0 r;

    public b0(f0 f00, Continuation continuation0) {
        this.r = f00;
        super(1, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Continuation continuation0) {
        return new b0(this.r, continuation0);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return ((b0)this.create(((Continuation)object0))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        n.D(object0);
        return this.r;
    }
}

