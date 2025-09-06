package qc;

import d5.n;
import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.k;

public final class c extends i implements k {
    public int r;
    public final n0 w;

    public c(n0 n00, Continuation continuation0) {
        this.w = n00;
        super(1, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Continuation continuation0) {
        return new c(this.w, continuation0);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return ((c)this.create(((Continuation)object0))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                n.D(object0);
                this.r = 1;
                return n0.f(this.w, this) == a0 ? a0 : H.a;
            }
            case 1: {
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

