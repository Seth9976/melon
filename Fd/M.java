package Fd;

import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class m extends i implements n {
    public boolean r;
    public final D w;

    public m(D d0, Continuation continuation0) {
        this.w = d0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new m(this.w, continuation0);
        continuation1.r = ((Boolean)object0).booleanValue();
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Boolean)object0).booleanValue();
        ((m)this.create(((Boolean)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z = this.r;
        d5.n.D(object0);
        ((Y)this.w.getViewModel()).n.setValue(Boolean.valueOf(z));
        return H.a;
    }
}

