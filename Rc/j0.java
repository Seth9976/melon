package Rc;

import M6.B;
import com.iloen.melon.playback.playlist.PlaylistId;
import ie.H;
import kc.d3;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import ob.z;
import oe.i;
import we.n;

public final class j0 extends i implements n {
    public final t0 B;
    public int r;
    public Object w;

    public j0(t0 t00, Continuation continuation0) {
        this.B = t00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new j0(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((j0)this.create(((PlaylistId)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        PlaylistId playlistId0 = (PlaylistId)this.w;
        a a0 = a.a;
        t0 t00 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                B b0 = ((d3)t00.c).p(playlistId0);
                this.w = playlistId0;
                this.r = 1;
                object0 = ListenableFutureKt.await(b0, this);
                if(object0 == a0) {
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
        MutableStateFlow mutableStateFlow0 = ((oc.H)object0).d();
        t00.d.getClass();
        t00.l = z.a(playlistId0);
        i0 i00 = new i0(t00, null);
        this.w = null;
        this.r = 2;
        return FlowKt.collectLatest(mutableStateFlow0, i00, this) == a0 ? a0 : H.a;
    }
}

