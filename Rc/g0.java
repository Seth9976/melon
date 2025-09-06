package Rc;

import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class g0 extends i implements n {
    public boolean r;
    public final t0 w;

    public g0(t0 t00, Continuation continuation0) {
        this.w = t00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new g0(this.w, continuation0);
        continuation1.r = ((Boolean)object0).booleanValue();
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Boolean)object0).booleanValue();
        ((g0)this.create(((Boolean)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z = this.r;
        d5.n.D(object0);
        this.w.n = z;
        t0.c(this.w, "isPlaying_collectLatest");
        return H.a;
    }
}

