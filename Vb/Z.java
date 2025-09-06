package Vb;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class z extends i implements n {
    public final o0 r;

    public z(o0 o00, Continuation continuation0) {
        this.r = o00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new z(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((z)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        this.r.Y0();
        return H.a;
    }
}

