package androidx.lifecycle;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel.DefaultImpls;
import kotlinx.coroutines.flow.Flow;
import ne.a;
import oe.i;
import we.n;

public final class l extends i implements n {
    public final t B;
    public final Flow D;
    public int r;
    public Object w;

    public l(t t0, Flow flow0, Continuation continuation0) {
        this.B = t0;
        this.D = flow0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new l(this.B, this.D, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((l)this.create(((ProducerScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ProducerScope producerScope1;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                ProducerScope producerScope0 = (ProducerScope)this.w;
                k k0 = new k(this.D, producerScope0, null);
                this.w = producerScope0;
                this.r = 1;
                if(f0.i(this.B, s.d, k0, this) == a0) {
                    return a0;
                }
                producerScope1 = producerScope0;
                break;
            }
            case 1: {
                producerScope1 = (ProducerScope)this.w;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        DefaultImpls.close$default(producerScope1, null, 1, null);
        return H.a;
    }
}

