package ud;

import H0.e;
import com.iloen.melon.playback.playlist.PlaylistId;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class z extends i implements n {
    public Object r;
    public final C w;

    public z(C c0, Continuation continuation0) {
        this.w = c0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new z(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((z)this.create(((PlaylistId)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        PlaylistId playlistId0 = (PlaylistId)this.r;
        d5.n.D(object0);
        if(playlistId0 != PlaylistId.STATION) {
            e.w(this.w);
        }
        return H.a;
    }
}

