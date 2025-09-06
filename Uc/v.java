package uc;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import oe.i;
import we.n;

public final class v extends i implements n {
    public Object r;
    public final int w;

    public v(int v, Continuation continuation0) {
        this.w = v;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new v(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((v)this.create(((B)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        B b0 = (B)this.r;
        d5.n.D(object0);
        b0.getClass();
        q.g(b0.a, "playableDataList");
        return new B(b0.a, this.w);
    }
}

