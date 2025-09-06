package uc;

import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import oe.i;

public final class n extends i implements we.n {
    public final int B;
    public Object r;
    public final List w;

    public n(List list0, int v, Continuation continuation0) {
        this.w = list0;
        this.B = v;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new n(this.w, this.B, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((n)this.create(((B)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        B b0 = (B)this.r;
        d5.n.D(object0);
        b0.getClass();
        q.g(this.w, "playableDataList");
        return new B(this.w, this.B);
    }
}

