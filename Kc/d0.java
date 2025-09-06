package kc;

import com.melon.playlist.b;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.i;
import we.n;

public final class d0 extends i implements n {
    public Object B;
    public final b D;
    public ProducerScope r;
    public int w;

    public d0(b b0, Continuation continuation0) {
        this.D = b0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new d0(this.D, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((d0)this.create(((ProducerScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ProducerScope producerScope1;
        ProducerScope producerScope0 = (ProducerScope)this.B;
        a a0 = a.a;
        b b0 = this.D;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                this.B = producerScope0;
                this.r = producerScope0;
                this.w = 1;
                object0 = b0.s(this);
                if(object0 == a0) {
                    return a0;
                }
                producerScope1 = producerScope0;
                goto label_17;
            }
            case 1: {
                producerScope1 = this.r;
                d5.n.D(object0);
            label_17:
                this.B = producerScope0;
                this.r = null;
                this.w = 2;
                if(producerScope1.send(object0, this) == a0) {
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
        b0.Y("getCurrentPlaylistIdFlow");
        Flow flow0 = FlowKt.filterNotNull(b0.p);
        c0 c00 = new c0(producerScope0, null);
        this.B = null;
        this.w = 3;
        return FlowKt.collectLatest(flow0, c00, this) == a0 ? a0 : H.a;
    }
}

