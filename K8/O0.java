package k8;

import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.Navigator;
import ie.H;
import kc.d3;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.F;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.i;
import we.n;

public final class o0 extends i implements n {
    public final F B;
    public int r;
    public final MusicBrowserActivity w;

    public o0(MusicBrowserActivity musicBrowserActivity0, F f0, Continuation continuation0) {
        this.w = musicBrowserActivity0;
        this.B = f0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new o0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((o0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Flow flow0 = ((d3)this.w.getPlaylistManager()).i();
                this.r = 1;
                object0 = FlowKt.first(flow0, this);
                if(object0 == a0) {
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
        if(((PlaylistId)object0).isAudioType()) {
            int v = this.B.a;
            if(v == 1) {
                Navigator.INSTANCE.openNowPlayList();
                return H.a;
            }
            Navigator.INSTANCE.openNowPlayer(v);
        }
        return H.a;
    }
}

