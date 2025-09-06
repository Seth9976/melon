package rd;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ProducerScope;
import ne.a;
import oe.i;
import pc.d;
import pc.z0;
import we.n;

public final class p1 extends i implements n {
    public Object B;
    public final ProducerScope D;
    public final K1 E;
    public final d G;
    public ProducerScope r;
    public int w;

    public p1(ProducerScope producerScope0, K1 k10, d d0, Continuation continuation0) {
        this.D = producerScope0;
        this.E = k10;
        this.G = d0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new p1(this.D, this.E, this.G, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((p1)this.create(((z0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ProducerScope producerScope1;
        z0 z00 = (z0)this.B;
        a a0 = a.a;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                this.B = null;
                ProducerScope producerScope0 = this.D;
                this.r = producerScope0;
                this.w = 1;
                Object object1 = K1.b(this.E, this.G, z00, this);
                if(object1 == a0) {
                    return a0;
                }
                producerScope1 = producerScope0;
                object0 = object1;
                break;
            }
            case 1: {
                producerScope1 = this.r;
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
        this.B = null;
        this.r = null;
        this.w = 2;
        return producerScope1.send(object0, this) == a0 ? a0 : H.a;
    }
}

