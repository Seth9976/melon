package sc;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import oc.M;
import oe.i;
import we.n;

public final class h0 extends i implements n {
    public final M B;
    public Object r;
    public final P0 w;

    public h0(P0 p00, M m0, Continuation continuation0) {
        this.w = p00;
        this.B = m0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new h0(this.w, this.B, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h0)this.create(((g1)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        g1 g10 = (g1)this.r;
        d5.n.D(object0);
        this.w.r.getClass();
        q.g(this.B, "repeatMode");
        q.g(g10, "curState");
        return g1.f(g10, null, 0, this.B, false, null, null, false, 0x7B);
    }
}

