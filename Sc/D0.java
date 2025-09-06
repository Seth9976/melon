package sc;

import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class d0 extends i implements n {
    public Object r;
    public final boolean w;

    public d0(boolean z, Continuation continuation0) {
        this.w = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new d0(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((d0)this.create(((g1)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        g1 g10 = (g1)this.r;
        d5.n.D(object0);
        return g1.f(g10, null, 0, null, false, null, null, this.w, 0x3F);
    }
}

