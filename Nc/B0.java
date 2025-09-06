package nc;

import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class b0 extends i implements n {
    public final boolean B;
    public final DrawerPlaylistInfo D;
    public int r;
    public final u0 w;

    public b0(u0 u00, boolean z, DrawerPlaylistInfo drawerPlaylistInfo0, Continuation continuation0) {
        this.w = u00;
        this.B = z;
        this.D = drawerPlaylistInfo0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new b0(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((b0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        H h0 = H.a;
        DrawerPlaylistInfo drawerPlaylistInfo0 = this.D;
        u0 u00 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                a0 a00 = new a0(this.B, drawerPlaylistInfo0, null);
                this.r = 1;
                if(BuildersKt.withContext(u00.a, a00, this) == a0) {
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
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        this.r = 2;
        return u00.V(drawerPlaylistInfo0, "setOfflineMode", this) == a0 ? a0 : h0;
    }
}

