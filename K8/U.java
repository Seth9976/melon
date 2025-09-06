package k8;

import Dc.s;
import com.iloen.melon.MelonAppBase;
import com.melon.utils.lifecycle.AppVisibilityManagerImpl;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import ne.a;
import oe.i;
import we.n;

public final class u extends i implements n {
    public int r;
    public final MelonAppBase w;

    public u(MelonAppBase melonAppBase0, Continuation continuation0) {
        this.w = melonAppBase0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new u(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((u)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                SharedFlow sharedFlow0 = ((AppVisibilityManagerImpl)this.w.getAppVisibilityManager()).d;
                s s0 = new s(2, this.w, MelonAppBase.class, "handleLifecycleEvent", "handleLifecycleEvent(Lcom/melon/utils/lifecycle/ActivityLifecycleEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0, 5);
                this.r = 1;
                return FlowKt.collectLatest(sharedFlow0, s0, this) == a0 ? a0 : H.a;
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

