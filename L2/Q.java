package l2;

import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class q extends i implements n {
    public Object r;
    public final j0 w;

    public q(j0 j00, Continuation continuation0) {
        this.w = j00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new q(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((q)this.create(((j0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        j0 j00 = (j0)this.r;
        return !(j00 instanceof d) || j00.a > this.w.a ? false : true;
    }
}

