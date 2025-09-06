package k8;

import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.melon.playlist.b;
import ie.H;
import java.util.List;
import k9.h;
import k9.j;
import kc.d3;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.i;
import we.n;

public final class g0 extends i implements n {
    public final List B;
    public int r;
    public final MusicBrowserActivity w;

    public g0(MusicBrowserActivity musicBrowserActivity0, List list0, Continuation continuation0) {
        this.w = musicBrowserActivity0;
        this.B = list0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new g0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((g0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Flow flow0 = FlowKt.filterNotNull(((b)((d3)this.w.getPlaylistManager()).a).r);
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
        H h0 = H.a;
        if(((Boolean)object0).booleanValue()) {
            if(!h.c(PlaylistId.SMART, new String[0])) {
                return h0;
            }
        }
        else if(!h.c(PlaylistId.MUSIC, new String[0])) {
            return h0;
        }
        j.f(this.B);
        return h0;
    }
}

