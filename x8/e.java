package X8;

import com.iloen.melon.friend.FriendAddTaskController;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.i;
import va.e0;
import va.o;
import we.n;

public final class e extends i implements n {
    public int r;
    public final FriendAddTaskController w;

    public e(FriendAddTaskController friendAddTaskController0, Continuation continuation0) {
        this.w = friendAddTaskController0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new e(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Flow flow0 = FlowKt.drop(FlowKt.distinctUntilChanged(((e0)o.a()).n()), 1);
                d d0 = new d(this.w, null);
                this.r = 1;
                return FlowKt.collectLatest(flow0, d0, this) == a0 ? a0 : H.a;
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

