package tc;

import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class p extends i implements n {
    public final long B;
    public final int D;
    public Object r;
    public final x w;

    public p(x x0, long v, int v1, Continuation continuation0) {
        this.w = x0;
        this.B = v;
        this.D = v1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new p(this.w, this.B, this.D, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((p)this.create(((F)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        F f0 = (F)this.r;
        d5.n.D(object0);
        this.w.e = this.B;
        return F.f(f0, null, this.D, null, 5);
    }
}

