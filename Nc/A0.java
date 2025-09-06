package nc;

import E9.w;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.iloen.melon.premium.PremiumPlaylistEntity;
import ie.H;
import k9.g;
import k9.h;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import m9.l;
import o9.b;
import oe.i;
import we.n;

public final class a0 extends i implements n {
    public final boolean r;
    public final DrawerPlaylistInfo w;

    public a0(boolean z, DrawerPlaylistInfo drawerPlaylistInfo0, Continuation continuation0) {
        this.r = z;
        this.w = drawerPlaylistInfo0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new a0(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((a0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        g g0 = this.w.getResponseType();
        PremiumPlaylistEntity premiumPlaylistEntity0 = h.i(g0, h.a(g0, new String[]{this.w.getContsId(), this.w.getSeedContsId(), this.w.getSeedContsTypeCode()}));
        if(premiumPlaylistEntity0 != null) {
            premiumPlaylistEntity0.f = this.r;
            b b0 = k9.i.a.i();
            b0.getClass();
            w.N(((androidx.room.H)b0.a), false, true, new l(2, b0, premiumPlaylistEntity0));
        }
        return H.a;
    }
}

