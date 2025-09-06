package ob;

import Cb.g;
import com.iloen.melon.playback.playlist.PlaylistId;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.i;
import we.n;

public final class l extends i implements n {
    public final z B;
    public int r;
    public final ProducerScope w;

    public l(ProducerScope producerScope0, z z0, Continuation continuation0) {
        this.w = producerScope0;
        this.B = z0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new l(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((l)this.create(((PlaylistId)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        ProducerScope producerScope0 = this.w;
        z z0 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                A a1 = z0.e(z0.c.a());
                this.r = 1;
                if(producerScope0.send(a1, this) == a0) {
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
        Flow flow0 = FlowKt.distinctUntilChanged(new g(FlowKt.asStateFlow(z0.c.b), z0, 3));
        j j0 = new j(producerScope0, null);
        this.r = 2;
        return FlowKt.collectLatest(flow0, j0, this) == a0 ? a0 : H.a;
    }
}

