package rd;

import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ProducerScope;
import ne.a;
import oe.i;
import we.n;

public final class e1 extends i implements n {
    public final K1 B;
    public final ProducerScope D;
    public int r;
    public Object w;

    public e1(K1 k10, ProducerScope producerScope0, Continuation continuation0) {
        this.B = k10;
        this.D = producerScope0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new e1(this.B, this.D, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e1)this.create(((PlaylistId)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        PlaylistId playlistId0 = (PlaylistId)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                K1 k10 = this.B;
                boolean z = playlistId0 == k10.p;
                if(!z) {
                    LogU.debug$default(k10.o, "invalid playlistId: " + playlistId0, null, false, 6, null);
                }
                if(!z) {
                    t0 t00 = new t0(playlistId0);
                    this.w = null;
                    this.r = 1;
                    if(this.D.send(t00, this) == a0) {
                        return a0;
                    }
                }
                return H.a;
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

