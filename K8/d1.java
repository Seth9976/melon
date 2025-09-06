package k8;

import androidx.lifecycle.l;
import androidx.lifecycle.t;
import com.iloen.melon.MusicBrowserActivity;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.i;
import va.e0;
import we.n;

public final class d1 extends i implements n {
    public int r;
    public final MusicBrowserActivity w;

    public d1(MusicBrowserActivity musicBrowserActivity0, Continuation continuation0) {
        this.w = musicBrowserActivity0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new d1(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((d1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Flow flow0 = ((e0)this.w.getLoginUseCase()).n();
                t t0 = this.w.getLifecycle();
                q.g(flow0, "<this>");
                q.g(t0, "lifecycle");
                Flow flow1 = FlowKt.drop(FlowKt.distinctUntilChanged(FlowKt.callbackFlow(new l(t0, flow0, null))), 1);
                c1 c10 = new c1(this.w, null);
                this.r = 1;
                return FlowKt.collectLatest(flow1, c10, this) == a0 ? a0 : H.a;
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

