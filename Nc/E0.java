package nc;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import oc.M;
import oe.i;
import we.n;

public final class e0 extends i implements n {
    public final M B;
    public Object r;
    public final u0 w;

    public e0(u0 u00, M m0, Continuation continuation0) {
        this.w = u00;
        this.B = m0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new e0(this.w, this.B, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e0)this.create(((C0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        C0 c00 = (C0)this.r;
        d5.n.D(object0);
        this.w.l.getClass();
        q.g(this.B, "repeatMode");
        q.g(c00, "curState");
        return C0.f(c00, null, 0, this.B, null, false, false, null, false, null, 507);
    }
}

