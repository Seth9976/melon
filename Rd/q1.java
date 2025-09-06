package rd;

import M6.B;
import ie.H;
import kc.d3;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oe.i;
import pc.Z;
import pc.d;
import we.n;

public final class q1 extends i implements n {
    public final K1 B;
    public int r;
    public Object w;

    public q1(K1 k10, Continuation continuation0) {
        this.B = k10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new q1(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((q1)this.create(((ProducerScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ProducerScope producerScope0 = (ProducerScope)this.w;
        a a0 = a.a;
        K1 k10 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                B b0 = ((d3)k10.c).n();
                this.w = producerScope0;
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
        p1 p10 = new p1(producerScope0, k10, ((d)object0), null);
        this.w = null;
        this.r = 2;
        return FlowKt.collectLatest(((Z)(((d)object0))).f, p10, this) == a0 ? a0 : H.a;
    }
}

