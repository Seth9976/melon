package nc;

import com.iloen.melon.playback.playlist.add.DrawerAddRequestPlayableListInfo;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository;
import e1.b;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.F;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class f extends i implements n {
    public final u0 B;
    public final DrawerAddRequestPlayableListInfo D;
    public final F E;
    public final C G;
    public final DrawerPlaylistInfo I;
    public Object r;
    public int w;

    public f(DrawerAddRequestPlayableListInfo drawerAddRequestPlayableListInfo0, DrawerPlaylistInfo drawerPlaylistInfo0, Continuation continuation0, C c0, F f0, u0 u00) {
        this.B = u00;
        this.D = drawerAddRequestPlayableListInfo0;
        this.E = f0;
        this.G = c0;
        this.I = drawerPlaylistInfo0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new f(this.D, this.I, continuation0, this.G, this.E, this.B);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((f)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        u0 u00 = this.B;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                e e0 = new e(this.D, this.I, null, this.G, this.E, u00);
                this.w = 1;
                object0 = u00.U("addInCurrentPlaylist", e0, this);
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
        B0 b00 = u00.b;
        String s = b.y(((C0)object0)) == null ? null : "";
        if(s == null) {
            s = "";
        }
        b00.d(s, "addInCurrentPlaylist");
        b00.e(u00.i, "addInCurrentPlaylist");
        this.r = object0;
        this.w = 2;
        return DrawerPlaylistPreferencesRepository.INSTANCE.updateDrawerPlytInfo(((C0)object0).g, this) == a0 ? a0 : object0;
    }
}

