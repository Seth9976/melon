package vc;

import I.P0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import ne.a;
import oe.i;
import we.n;

public final class b extends i implements n {
    public int r;

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new b(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((b)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                StateFlow stateFlow0 = (StateFlow)c.c.c;
                P0 p00 = new P0(2, c.a, c.class, "setPreference", "setPreference(Lcom/melon/remoteconfig/RemoteConfigState;)V", 4, 3);
                this.r = 1;
                return FlowKt.collectLatest(stateFlow0, p00, this) == a0 ? a0 : H.a;
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

