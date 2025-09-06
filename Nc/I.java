package nc;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.add.DrawerAddRequestPlayableListInfo;
import com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository;
import e1.b;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import we.n;

public final class i extends oe.i implements n {
    public final u0 B;
    public final DrawerAddRequestPlayableListInfo D;
    public Object r;
    public int w;

    public i(DrawerAddRequestPlayableListInfo drawerAddRequestPlayableListInfo0, Continuation continuation0, u0 u00) {
        this.B = u00;
        this.D = drawerAddRequestPlayableListInfo0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new i(this.D, continuation0, this.B);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((i)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        u0 u00 = this.B;
        B0 b00 = u00.b;
        a a0 = a.a;
        DrawerAddRequestPlayableListInfo drawerAddRequestPlayableListInfo0 = this.D;
        String s = null;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                this.w = 1;
                if(u00.V(drawerAddRequestPlayableListInfo0.getPlaylistInfo(), "addInNewPlaylist", this) == a0) {
                    return a0;
                }
                goto label_15;
            }
            case 1: {
                d5.n.D(object0);
            label_15:
                h h0 = new h(drawerAddRequestPlayableListInfo0, null, u00);
                this.w = 2;
                object0 = u00.U("addInNewPlaylist", h0, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 2: {
                d5.n.D(object0);
                break;
            }
            case 3: {
                Object object1 = this.r;
                d5.n.D(object0);
                return object1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Playable playable0 = b.y(((C0)object0));
        if(playable0 != null) {
            s = playable0.getContentId();
        }
        if(s == null) {
            s = "";
        }
        b00.d(s, "add");
        b00.e(u00.i, "add");
        this.r = object0;
        this.w = 3;
        return DrawerPlaylistPreferencesRepository.INSTANCE.updateDrawerPlytInfo(((C0)object0).g, this) == a0 ? a0 : object0;
    }
}

