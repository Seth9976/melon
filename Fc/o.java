package Fc;

import M6.B;
import ie.H;
import kc.d3;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oe.i;
import we.n;

public final class o extends i implements n {
    public int r;
    public final p w;

    public o(p p0, Continuation continuation0) {
        this.w = p0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new o(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((o)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        p p0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                B b0 = ((d3)p0.a).r();
                this.r = 1;
                object0 = ListenableFutureKt.await(b0, this);
                if(object0 == a0) {
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
        MutableStateFlow mutableStateFlow0 = ((oc.H)object0).d();
        Fc.n n0 = new Fc.n(p0, null);
        this.r = 2;
        return FlowKt.collectLatest(mutableStateFlow0, n0, this) == a0 ? a0 : H.a;
    }
}

