package qc;

import A3.g;
import e1.b;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class b0 extends i implements n {
    public final n0 B;
    public Object r;
    public final boolean w;

    public b0(Continuation continuation0, n0 n00, boolean z) {
        this.w = z;
        this.B = n00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new b0(continuation0, this.B, this.w);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((b0)this.create(((D0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        D0 d00 = (D0)this.r;
        d5.n.D(object0);
        n0 n00 = this.B;
        if(this.w) {
            n00.k = new g(b.B(d00).size(), d00.b);
            return D0.f(d00, null, 0, null, this.w, null, null, false, 0x77);
        }
        n00.k = null;
        return D0.f(d00, null, 0, null, this.w, null, null, false, 0x77);
    }
}

