package pd;

import com.melon.ui.playback.VideoControllerHelper;
import ie.H;
import kc.d3;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.i;

public final class n extends i implements we.n {
    public final CoroutineScope B;
    public int r;
    public final VideoControllerHelper w;

    public n(VideoControllerHelper videoControllerHelper0, CoroutineScope coroutineScope0, Continuation continuation0) {
        this.w = videoControllerHelper0;
        this.B = coroutineScope0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new n(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((n)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Flow flow0 = ((d3)this.w.c).i();
                m m0 = new m(this.w, this.B, null);
                this.r = 1;
                return FlowKt.collectLatest(flow0, m0, this) == a0 ? a0 : H.a;
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

