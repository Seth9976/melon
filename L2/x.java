package l2;

import Ac.N;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.i;
import we.n;

public final class x extends i implements n {
    public int r;
    public final M w;

    public x(M m0, Continuation continuation0) {
        this.w = m0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new x(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((x)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        H h0 = H.a;
        M m0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                H h1 = ((CompletableDeferred)m0.i.b).await(this);
                if(h1 != a0) {
                    h1 = h0;
                }
                if(h1 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            case 2: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Flow flow0 = FlowKt.conflate(m0.g().c);
        N n0 = new N(m0, 24);
        this.r = 2;
        return flow0.collect(n0, this) == a0 ? a0 : h0;
    }
}

