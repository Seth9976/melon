package j9;

import ed.w0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import ne.a;
import oe.i;
import we.n;

public final class b extends i implements n {
    public final d B;
    public int r;
    public Object w;

    public b(d d0, Continuation continuation0) {
        this.B = d0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new b(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((b)this.create(((ProducerScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ProducerScope producerScope0 = (ProducerScope)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                producerScope0.trySend-JP2dKIU(Boolean.valueOf(this.B.b()));
                j9.a a1 = new j9.a(producerScope0, 0);
                this.B.a().registerDefaultNetworkCallback(a1);
                w0 w00 = new w0(15, this.B, a1);
                this.w = null;
                this.r = 1;
                return ProduceKt.awaitClose(producerScope0, w00, this) == a0 ? a0 : H.a;
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

