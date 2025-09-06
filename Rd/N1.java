package rd;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ProducerScope;
import ne.a;
import oe.i;
import pc.d;
import pc.z0;
import we.n;

public final class n1 extends i implements n {
    public final ProducerScope B;
    public final K1 D;
    public final d E;
    public int r;
    public Object w;

    public n1(ProducerScope producerScope0, K1 k10, d d0, Continuation continuation0) {
        this.B = producerScope0;
        this.D = k10;
        this.E = d0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new n1(this.B, this.D, this.E, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((n1)this.create(((z0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        z0 z00 = (z0)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                N1 n10 = K1.e(this.E, z00);
                this.w = null;
                this.r = 1;
                return this.B.send(n10, this) == a0 ? a0 : H.a;
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

