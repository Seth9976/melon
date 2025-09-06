package androidx.compose.foundation;

import X.k;
import androidx.compose.runtime.w;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.i;
import we.n;

public final class u0 extends i implements n {
    public int r;
    public final v0 w;

    public u0(v0 v00, Continuation continuation0) {
        this.w = v00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new u0(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((u0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Flow flow0 = w.y(new k(this.w, 8));
                t0 t00 = new t0(this.w, null);
                this.r = 1;
                return FlowKt.collectLatest(flow0, t00, this) == a0 ? a0 : H.a;
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

