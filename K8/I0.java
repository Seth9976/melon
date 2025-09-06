package k8;

import M6.B;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import ie.H;
import java.util.List;
import kc.d3;
import kc.w2;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.guava.ListenableFutureKt;
import nc.a;
import nc.u0;
import oe.i;
import we.n;

public final class i0 extends i implements n {
    public int B;
    public final MusicBrowserActivity D;
    public final String E;
    public final List G;
    public a r;
    public int w;

    public i0(MusicBrowserActivity musicBrowserActivity0, String s, List list0, Continuation continuation0) {
        this.D = musicBrowserActivity0;
        this.E = s;
        this.G = list0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new i0(this.D, this.E, this.G, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((i0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int v1;
        a a1;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        int v = 1;
        MusicBrowserActivity musicBrowserActivity0 = this.D;
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                B b0 = ((d3)musicBrowserActivity0.getPlaylistManager()).l();
                this.B = 1;
                object0 = ListenableFutureKt.await(b0, this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_13;
            }
            case 1: {
                d5.n.D(object0);
            label_13:
                a1 = (a)object0;
                B b1 = ((d3)musicBrowserActivity0.getPlaylistManager()).h();
                this.r = a1;
                this.B = 2;
                object0 = ListenableFutureKt.await(b1, this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_22;
            }
            case 2: {
                a1 = this.r;
                d5.n.D(object0);
            label_22:
                if(object0 != PlaylistId.DRAWER) {
                    v = 0;
                }
                DrawerPlaylistInfo drawerPlaylistInfo0 = ((u0)a1).I().g;
                String s = drawerPlaylistInfo0 == null ? null : drawerPlaylistInfo0.getContsId();
                if(s != null && s.length() != 0 && s.equals(this.E) && (this.G == null || this.G.isEmpty())) {
                    musicBrowserActivity0.handler.postDelayed(new Q(musicBrowserActivity0, 1), 500L);
                    d3 d30 = (d3)musicBrowserActivity0.getPlaylistManager();
                    w2 w20 = new w2(d30, null);
                    B b2 = ListenableFutureKt.future$default(d30.b, null, null, w20, 3, null);
                    this.r = null;
                    this.w = v;
                    this.B = 3;
                    if(ListenableFutureKt.await(b2, this) == a0) {
                        return a0;
                    }
                    v1 = v;
                    goto label_40;
                }
                return h0;
            }
            case 3: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        v1 = this.w;
        d5.n.D(object0);
    label_40:
        if(v1 != 0) {
            ((d3)musicBrowserActivity0.getPlaylistManager()).b();
        }
        return h0;
    }
}

