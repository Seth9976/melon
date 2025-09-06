package D4;

import A4.c;
import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.k;
import we.n;

public final class g extends i implements n {
    public final k B;
    public int r;
    public Object w;

    public g(k k0, Continuation continuation0) {
        this.B = k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new g(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((g)this.create(((c)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                c c0 = (c)this.w;
                this.r = 1;
                Object object1 = this.B.invoke(this);
                return object1 == a0 ? a0 : object1;
            }
            case 1: {
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

