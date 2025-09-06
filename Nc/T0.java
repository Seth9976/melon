package nc;

import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import k9.h;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import oe.i;
import we.n;

public final class t0 extends i implements n {
    public final DrawerPlaylistInfo B;
    public final u0 r;
    public final String w;

    public t0(u0 u00, String s, DrawerPlaylistInfo drawerPlaylistInfo0, Continuation continuation0) {
        this.r = u00;
        this.w = s;
        this.B = drawerPlaylistInfo0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new t0(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((t0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        u0 u00 = this.r;
        LogU.debug$default(u00.f, "updateStateOnlyOfflineState() fromCall: " + this.w, null, false, 6, null);
        H h0 = H.a;
        DrawerPlaylistInfo drawerPlaylistInfo0 = this.B;
        if(drawerPlaylistInfo0 == null) {
            LogU.debug$default(u00.f, "updateStateOnlyOfflineState fail to drawerPlaylistInfo null", null, false, 6, null);
            return h0;
        }
        MutableStateFlow mutableStateFlow0 = u00.h;
        do {
            Object object1 = mutableStateFlow0.getValue();
        }
        while(!mutableStateFlow0.compareAndSet(object1, C0.f(((C0)object1), null, 0, null, null, false, h.d(drawerPlaylistInfo0), null, false, null, 0x1DF)));
        return h0;
    }
}

