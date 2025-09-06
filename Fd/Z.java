package Fd;

import H0.b;
import J8.N2;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import ne.a;
import oe.i;
import we.n;

public final class z extends i implements n {
    public final D B;
    public final N2 D;
    public final H E;
    public final H G;
    public int r;
    public Object w;

    public z(D d0, N2 n20, H h0, H h1, Continuation continuation0) {
        this.B = d0;
        this.D = n20;
        this.E = h0;
        this.G = h1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new z(this.B, this.D, this.E, this.G, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((z)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(ie.H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                H h0 = b.p(object0);
                StateFlow stateFlow0 = ((Y)this.B.getViewModel()).i;
                y y0 = new y(this.D, this.B, this.E, this.G, h0, coroutineScope0, null);
                this.w = null;
                this.r = 1;
                return FlowKt.collectLatest(stateFlow0, y0, this) == a0 ? a0 : ie.H.a;
            }
            case 1: {
                d5.n.D(object0);
                return ie.H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

