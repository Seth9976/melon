package qc;

import ie.H;
import je.w;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class l extends i implements n {
    public Object r;
    public final n0 w;

    public l(n0 n00, Continuation continuation0) {
        this.w = n00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new l(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((l)this.create(((D0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        D0 d00 = (D0)this.r;
        d5.n.D(object0);
        return D0.f(d00, null, 0, null, false, null, w.a, false, 0x5F);
    }
}

