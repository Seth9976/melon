package Y;

import H0.e;
import J0.L;
import J0.o;
import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.h;
import we.k;
import we.n;

public final class t extends h implements n {
    public final k B;
    public int r;
    public Object w;

    public t(k k0, Continuation continuation0) {
        this.B = k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new t(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((t)this.create(((L)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return a.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        L l0;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                l0 = (L)this.w;
                goto label_10;
            }
            case 1: {
                l0 = (L)this.w;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        do {
            Boolean boolean0 = Boolean.valueOf(!e.M(((J0.n)object0)));
            this.B.invoke(boolean0);
        label_10:
            this.w = l0;
            this.r = 1;
            object0 = l0.a(o.a, this);
        }
        while(object0 != a0);
        return a0;
    }
}

