package ad;

import O.F;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import oe.i;
import we.n;

public final class g extends i implements n {
    public final F B;
    public int r;
    public final a w;

    public g(a j$a0, F f0, Continuation continuation0) {
        this.w = j$a0;
        this.B = f0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new g(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((g)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ne.a a0 = ne.a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                MutableSharedFlow mutableSharedFlow0 = ((q0)this.w.getViewModel()).a;
                f f0 = new f(this.B, null);
                this.r = 1;
                return FlowKt.collectLatest(mutableSharedFlow0, f0, this) == a0 ? a0 : H.a;
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

