package l2;

import d5.n;
import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.k;

public final class u extends i implements k {
    public int r;
    public final E w;

    public u(E e0, Continuation continuation0) {
        this.w = e0;
        super(1, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Continuation continuation0) {
        return new u(this.w, continuation0);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return ((u)this.create(((Continuation)object0))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                n.D(object0);
                this.r = 1;
                Object object1 = this.w.invoke(this);
                return object1 == a0 ? a0 : object1;
            }
            case 1: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

