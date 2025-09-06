package ob;

import M6.B;
import Ub.q;
import com.iloen.melon.playback.playlist.PlaylistId;
import ie.H;
import kc.d3;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oe.i;
import we.n;

public final class h extends i implements n {
    public final ProducerScope B;
    public final z D;
    public int r;
    public Object w;

    public h(ProducerScope producerScope0, z z0, Continuation continuation0) {
        this.B = producerScope0;
        this.D = z0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new h(this.B, this.D, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h)this.create(((PlaylistId)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        z z0 = this.D;
        q q0 = z0.c;
        PlaylistId playlistId0 = (PlaylistId)this.w;
        a a0 = a.a;
        ProducerScope producerScope0 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                fc.a a1 = z0.d(q0.a());
                this.w = playlistId0;
                this.r = 1;
                if(producerScope0.send(a1, this) == a0) {
                    return a0;
                }
                goto label_16;
            }
            case 1: {
                d5.n.D(object0);
            label_16:
                B b0 = ((d3)z0.d).p(playlistId0);
                this.w = null;
                this.r = 2;
                object0 = ListenableFutureKt.await(b0, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 2: {
                d5.n.D(object0);
                break;
            }
            case 3: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Flow flow0 = FlowKt.distinctUntilChanged(FlowKt.combine(FlowKt.asStateFlow(q0.b), ((oc.H)object0).d(), new f(z0, null)));
        g g0 = new g(producerScope0, null);
        this.w = null;
        this.r = 3;
        return FlowKt.collectLatest(flow0, g0, this) == a0 ? a0 : H.a;
    }
}

