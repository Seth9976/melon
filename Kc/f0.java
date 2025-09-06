package kc;

import Ac.F2;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.melon.playlist.b;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.i;
import pc.Z;
import pc.d;
import we.n;

public final class f0 extends i implements n {
    public final b B;
    public final ProducerScope D;
    public int r;
    public Object w;

    public f0(b b0, ProducerScope producerScope0, Continuation continuation0) {
        this.B = b0;
        this.D = producerScope0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new f0(this.B, this.D, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((f0)this.create(((PlaylistId)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        PlaylistId playlistId0 = (PlaylistId)this.w;
        a a0 = a.a;
        ProducerScope producerScope0 = this.D;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                if(playlistId0 == PlaylistId.MIX_UP) {
                    this.w = null;
                    this.r = 1;
                    object0 = this.B.A(this);
                    if(object0 == a0) {
                        return a0;
                    }
                    break;
                }
                ChannelResult.box-impl(producerScope0.trySend-JP2dKIU(Boolean.FALSE));
                return H.a;
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
        q.g(((d)object0), "<this>");
        F2 f20 = new F2(((Z)(((d)object0))).f, 27);
        e0 e00 = new e0(producerScope0, null);
        this.w = null;
        this.r = 2;
        return FlowKt.collectLatest(f20, e00, this) == a0 ? a0 : H.a;
    }
}

