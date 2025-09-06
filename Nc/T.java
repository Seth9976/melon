package nc;

import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import df.v;
import ie.H;
import java.util.List;
import je.w;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.n;

public final class t extends i implements n {
    public Object B;
    public final u0 D;
    public final List E;
    public final DrawerPlaylistInfo G;
    public final boolean I;
    public C0 r;
    public int w;

    public t(u0 u00, List list0, DrawerPlaylistInfo drawerPlaylistInfo0, boolean z, Continuation continuation0) {
        this.D = u00;
        this.E = list0;
        this.G = drawerPlaylistInfo0;
        this.I = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new t(this.D, this.E, this.G, this.I, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((t)this.create(((C0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        C0 c00 = (C0)this.B;
        a a0 = a.a;
        List list0 = this.E;
        u0 u00 = this.D;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                u00.j.clear();
                u00.j.addAll(list0);
                this.B = c00;
                this.w = 1;
                if(u00.p.d(u00.j, this) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            case 2: {
                c00 = this.r;
                d5.n.D(object0);
                return list0.isEmpty() ? C0.f(c00, ((List)object0), -1, null, w.a, false, false, this.G, this.I, null, 308) : C0.f(c00, ((List)object0), 0, null, w.a, false, false, this.G, this.I, null, 308);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        this.B = null;
        this.r = c00;
        this.w = 2;
        Object object1 = v.k(list0, u00.q, this);
        if(object1 == a0) {
            return a0;
        }
        return list0.isEmpty() ? C0.f(c00, ((List)object1), -1, null, w.a, false, false, this.G, this.I, null, 308) : C0.f(c00, ((List)object1), 0, null, w.a, false, false, this.G, this.I, null, 308);
    }
}

