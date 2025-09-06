package k8;

import M6.B;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.playback.playlist.PlaylistId;
import ie.H;
import kc.d3;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oe.i;
import we.n;

public final class h1 extends i implements n {
    public final MusicBrowserActivity B;
    public MusicBrowserActivity r;
    public int w;

    public h1(MusicBrowserActivity musicBrowserActivity0, Continuation continuation0) {
        this.B = musicBrowserActivity0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new h1(this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        MusicBrowserActivity musicBrowserActivity1;
        a a0 = a.a;
        MusicBrowserActivity musicBrowserActivity0 = this.B;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                B b0 = ((d3)musicBrowserActivity0.getPlaylistManager()).h();
                this.r = musicBrowserActivity0;
                this.w = 1;
                object0 = ListenableFutureKt.await(b0, this);
                if(object0 == a0) {
                    return a0;
                }
                musicBrowserActivity1 = musicBrowserActivity0;
                break;
            }
            case 1: {
                musicBrowserActivity1 = this.r;
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
        musicBrowserActivity1.setVideoUIAndMiniPlayerUI(((PlaylistId)object0));
        Flow flow0 = ((d3)musicBrowserActivity0.getPlaylistManager()).i();
        g1 g10 = new g1(musicBrowserActivity0, null);
        this.r = null;
        this.w = 2;
        return FlowKt.collectLatest(flow0, g10, this) == a0 ? a0 : H.a;
    }
}

