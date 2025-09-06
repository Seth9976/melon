package q2;

import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.n;

public final class j extends i implements n {
    public final i B;
    public int r;
    public Object w;

    public j(n n0, Continuation continuation0) {
        this.B = (i)n0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new j(((n)this.B), continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((j)this.create(((h)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                b b0 = ((h)this.w).c();
                this.w = b0;
                this.r = 1;
                return ((n)this.B).invoke(b0, this) == a0 ? a0 : b0;
            }
            case 1: {
                b b1 = (b)this.w;
                d5.n.D(object0);
                return b1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

