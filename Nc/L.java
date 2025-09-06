package nc;

import A3.g;
import com.iloen.melon.playback.playlist.PlaylistId;
import ie.H;
import je.w;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class l extends i implements n {
    public final PlaylistId B;
    public Object r;
    public final u0 w;

    public l(u0 u00, PlaylistId playlistId0, Continuation continuation0) {
        this.w = u00;
        this.B = playlistId0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new l(this.w, this.B, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((l)this.create(((C0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        C0 c00 = (C0)this.r;
        d5.n.D(object0);
        this.w.j.clear();
        this.w.n = this.w.n == null ? null : new g(0, 0);
        this.w.i = -1L;
        return C0.f(c00, w.a, -1, null, w.a, false, false, null, true, this.B, 52);
    }
}

