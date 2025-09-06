package rd;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.ProducerScope;
import ne.a;
import oe.i;
import we.n;

public final class j1 extends i implements n {
    public final K1 B;
    public int r;
    public Object w;

    public j1(K1 k10, Continuation continuation0) {
        this.B = k10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new j1(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((j1)this.create(((ProducerScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ProducerScope producerScope0 = (ProducerScope)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                i1 i10 = new i1(this.B, producerScope0, null);
                this.w = null;
                this.r = 1;
                return CoroutineScopeKt.coroutineScope(i10, this) == a0 ? a0 : H.a;
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

