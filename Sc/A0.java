package sc;

import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class a0 extends i implements n {
    public final P0 B;
    public final int D;
    public final long E;
    public Object r;
    public final boolean w;

    public a0(boolean z, P0 p00, int v, long v1, Continuation continuation0) {
        this.w = z;
        this.B = p00;
        this.D = v;
        this.E = v1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new a0(this.w, this.B, this.D, this.E, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((a0)this.create(((g1)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        g1 g10 = (g1)this.r;
        d5.n.D(object0);
        P0 p00 = this.B;
        if(this.w) {
            p00.p = p00.p == null ? null : p00.p.b(this.D);
        }
        p00.m = this.E;
        return g1.f(g10, null, this.D, null, false, null, null, false, 0x7D);
    }
}

