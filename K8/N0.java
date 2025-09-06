package k8;

import M6.B;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.Navigator;
import ie.H;
import kc.K2;
import kc.d3;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.F;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oe.i;
import we.n;

public final class n0 extends i implements n {
    public final F B;
    public int r;
    public final MusicBrowserActivity w;

    public n0(MusicBrowserActivity musicBrowserActivity0, F f0, Continuation continuation0) {
        this.w = musicBrowserActivity0;
        this.B = f0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new n0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((n0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
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
                object0 = FlowKt.first(flow0, this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_11;
            }
            case 1: {
                d5.n.D(object0);
            label_11:
                if(!((PlaylistId)object0).isAudioType()) {
                    musicBrowserActivity0.getPlayerUseCase().s();
                    d3 d30 = (d3)musicBrowserActivity0.getPlaylistManager();
                    K2 k20 = new K2(d30, null);
                    B b0 = ListenableFutureKt.future$default(d30.b, null, null, k20, 3, null);
                    this.r = 2;
                    object0 = ListenableFutureKt.await(b0, this);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_21;
                }
                break;
            }
            case 2: {
                d5.n.D(object0);
            label_21:
                B b1 = ((d3)musicBrowserActivity0.getPlaylistManager()).a(((PlaylistId)object0));
                this.r = 3;
                if(ListenableFutureKt.await(b1, this) == a0) {
                    return a0;
                }
                break;
            }
            case 3: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        int v = this.B.a;
        if(v == 1) {
            Navigator.INSTANCE.openNowPlayList();
            return H.a;
        }
        Navigator.INSTANCE.openNowPlayer(v);
        return H.a;
    }
}

