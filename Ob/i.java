package ob;

import ie.H;
import kc.d3;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import we.n;

public final class i extends oe.i implements n {
    public final z B;
    public int r;
    public Object w;

    public i(z z0, Continuation continuation0) {
        this.B = z0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new i(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((i)this.create(((ProducerScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ProducerScope producerScope0 = (ProducerScope)this.w;
        a a0 = a.a;
        z z0 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                fc.a a1 = z0.d(z0.c.a());
                this.w = producerScope0;
                this.r = 1;
                if(producerScope0.send(a1, this) == a0) {
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
        Flow flow0 = ((d3)z0.d).i();
        h h0 = new h(producerScope0, z0, null);
        this.w = null;
        this.r = 2;
        return FlowKt.collectLatest(flow0, h0, this) == a0 ? a0 : H.a;
    }
}

