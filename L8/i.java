package l8;

import com.iloen.melon.activity.BaseActivity;
import hd.h0;
import ie.H;
import k8.b;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import we.n;

public final class i extends oe.i implements n {
    public int r;
    public final BaseActivity w;

    public i(BaseActivity baseActivity0, Continuation continuation0) {
        this.w = baseActivity0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new i(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((i)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Flow flow0 = FlowKt.debounce(((b)this.w.getBlockingProgressDialogManage()).d, new h0(28));
                h h0 = new h(this.w, null);
                this.r = 1;
                return FlowKt.collectLatest(flow0, h0, this) == a0 ? a0 : H.a;
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

