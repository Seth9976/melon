package kd;

import ie.H;
import jd.W;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.k;
import we.n;

public final class a0 extends i implements n {
    public final boolean r;
    public final k w;

    public a0(boolean z, k k0, Continuation continuation0) {
        this.r = z;
        this.w = k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new a0(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((a0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        if(this.r) {
            this.w.invoke(W.a);
        }
        return H.a;
    }
}

