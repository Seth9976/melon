package rd;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ProducerScope;
import ne.a;
import oe.i;
import pc.z0;
import we.n;

public final class g1 extends i implements n {
    public final K1 B;
    public final ProducerScope D;
    public int r;
    public Object w;

    public g1(K1 k10, ProducerScope producerScope0, Continuation continuation0) {
        this.B = k10;
        this.D = producerScope0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new g1(this.B, this.D, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((g1)this.create(((z0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        z0 z00 = (z0)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                if(!this.B.j(z00)) {
                    u0 u00 = new u0(z00);
                    this.w = null;
                    this.r = 1;
                    if(this.D.send(u00, this) == a0) {
                        return a0;
                    }
                }
                return H.a;
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

