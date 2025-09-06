package rd;

import M6.B;
import ie.H;
import kc.d3;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oe.i;
import pc.Z;
import pc.d;
import we.n;

public final class h1 extends i implements n {
    public final ProducerScope B;
    public int r;
    public final K1 w;

    public h1(K1 k10, ProducerScope producerScope0, Continuation continuation0) {
        this.w = k10;
        this.B = producerScope0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new h1(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        K1 k10 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                B b0 = ((d3)k10.c).n();
                this.r = 1;
                object0 = ListenableFutureKt.await(b0, this);
                if(object0 == a0) {
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
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        g1 g10 = new g1(k10, this.B, null);
        this.r = 2;
        return FlowKt.collectLatest(((Z)(((d)object0))).f, g10, this) == a0 ? a0 : H.a;
    }
}

