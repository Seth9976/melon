package nc;

import A3.g;
import com.iloen.melon.playback.playlist.add.DrawerAddRequestPlayableListInfo;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import d8.d;
import df.v;
import ie.H;
import java.util.LinkedList;
import java.util.List;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.n;

public final class h extends i implements n {
    public C0 B;
    public int D;
    public int E;
    public Object G;
    public final DrawerAddRequestPlayableListInfo I;
    public final u0 M;
    public List r;
    public DrawerPlaylistInfo w;

    public h(DrawerAddRequestPlayableListInfo drawerAddRequestPlayableListInfo0, Continuation continuation0, u0 u00) {
        this.I = drawerAddRequestPlayableListInfo0;
        this.M = u00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new h(this.I, continuation0, this.M);
        continuation1.G = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h)this.create(((C0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        DrawerPlaylistInfo drawerPlaylistInfo0;
        List list0;
        u0 u00 = this.M;
        LinkedList linkedList0 = u00.j;
        C0 c00 = (C0)this.G;
        a a0 = a.a;
        switch(this.E) {
            case 0: {
                d5.n.D(object0);
                list0 = this.I.getUserRequestedPlaylist();
                DrawerPlaylistInfo drawerPlaylistInfo1 = this.I.getPlaylistInfo();
                d.E(System.currentTimeMillis(), list0);
                linkedList0.clear();
                linkedList0.addAll(list0);
                this.G = c00;
                this.r = list0;
                this.w = drawerPlaylistInfo1;
                this.E = 1;
                if(u00.p.a(linkedList0, "DrawerPlaylistImpl, addInNewPlaylist", this) == a0) {
                    return a0;
                }
                drawerPlaylistInfo0 = drawerPlaylistInfo1;
                break;
            }
            case 1: {
                drawerPlaylistInfo0 = this.w;
                list0 = this.r;
                d5.n.D(object0);
                break;
            }
            case 2: {
                int v = this.D;
                C0 c01 = this.B;
                drawerPlaylistInfo0 = this.w;
                d5.n.D(object0);
                return C0.f(c01, ((List)object0), v, null, null, false, false, drawerPlaylistInfo0, false, null, 316);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        int v1 = list0.isEmpty() ? -1 : 0;
        if(c00.e) {
            u00.n = new g(list0.size(), v1);
        }
        u00.i = -1L;
        this.G = null;
        this.r = null;
        this.w = drawerPlaylistInfo0;
        this.B = c00;
        this.D = v1;
        this.E = 2;
        Object object1 = v.k(list0, u00.q, this);
        return object1 == a0 ? a0 : C0.f(c00, ((List)object1), v1, null, null, false, false, drawerPlaylistInfo0, false, null, 316);
    }
}

