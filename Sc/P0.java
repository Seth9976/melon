package sc;

import A3.g;
import e1.b;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class p0 extends i implements n {
    public final P0 B;
    public Object r;
    public final boolean w;

    public p0(Continuation continuation0, P0 p00, boolean z) {
        this.w = z;
        this.B = p00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new p0(continuation0, this.B, this.w);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((p0)this.create(((g1)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        g1 g10 = (g1)this.r;
        d5.n.D(object0);
        P0 p00 = this.B;
        if(this.w) {
            p00.p = new g(b.B(g10).size(), g10.b);
            return g1.f(g10, null, 0, null, this.w, null, null, false, 0x77);
        }
        p00.p = null;
        return g1.f(g10, null, 0, null, this.w, null, null, false, 0x77);
    }
}

