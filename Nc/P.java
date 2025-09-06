package nc;

import ie.H;
import je.w;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class p extends i implements n {
    public Object r;
    public final u0 w;

    public p(u0 u00, Continuation continuation0) {
        this.w = u00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new p(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((p)this.create(((C0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        C0 c00 = (C0)this.r;
        d5.n.D(object0);
        return C0.f(c00, null, 0, null, w.a, false, false, null, false, null, 503);
    }
}

