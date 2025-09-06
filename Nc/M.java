package nc;

import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository;
import ie.H;
import je.w;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class m extends i implements n {
    public final u0 B;
    public final PlaylistId D;
    public final boolean E;
    public Object r;
    public int w;

    public m(u0 u00, PlaylistId playlistId0, boolean z, Continuation continuation0) {
        this.B = u00;
        this.D = playlistId0;
        this.E = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new m(this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((m)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        u0 u00 = this.B;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                l l0 = new l(u00, this.D, null);
                this.w = 1;
                object0 = u00.U("clearInternal", l0, this);
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
                Object object1 = this.r;
                d5.n.D(object0);
                return object1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        C0 c00 = (C0)object0;
        if(this.E) {
            u00.b.d("", "clear");
            u00.b.e(u00.i, "clear");
            u00.b.f(w.a);
            this.r = object0;
            this.w = 2;
            if(DrawerPlaylistPreferencesRepository.INSTANCE.updateDrawerPlytInfo(null, this) == a0) {
                return a0;
            }
        }
        return object0;
    }
}

