package l2;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;
import oe.i;
import we.n;

public final class o extends i implements n {
    public int r;
    public final M w;

    public o(M m0, Continuation continuation0) {
        this.w = m0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new o(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((o)this.create(((FlowCollector)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                return M.d(this.w, this) == a0 ? a0 : H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

