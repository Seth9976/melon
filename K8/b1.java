package k8;

import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import kc.d3;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.i;
import we.n;

public final class b1 extends i implements n {
    public final boolean B;
    public final boolean D;
    public int r;
    public final MusicBrowserActivity w;

    public b1(MusicBrowserActivity musicBrowserActivity0, boolean z, boolean z1, Continuation continuation0) {
        this.w = musicBrowserActivity0;
        this.B = z;
        this.D = z1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new b1(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((b1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        MusicBrowserActivity musicBrowserActivity0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Flow flow0 = ((d3)musicBrowserActivity0.getPlaylistManager()).i();
                this.r = 1;
                if(FlowKt.first(flow0, this) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogU.warn$default(musicBrowserActivity0.log, "openVideoPlayer() skipped because current playlist is not video type.", null, false, 6, null);
        return H.a;
    }
}

