package td;

import H0.b;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import ne.a;
import oe.i;
import we.n;

public final class a1 extends i implements n {
    public final t1 B;
    public int r;
    public final StateFlow w;

    public a1(StateFlow stateFlow0, t1 t10, Continuation continuation0) {
        this.w = stateFlow0;
        this.B = t10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new a1(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((a1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                kotlin.jvm.internal.H h0 = b.p(object0);
                Z0 z00 = new Z0(this.B, h0, null);
                this.r = 1;
                return FlowKt.collectLatest(this.w, z00, this) == a0 ? a0 : H.a;
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

