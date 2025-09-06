package kc;

import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.preference.MelonPrefs;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class c2 extends i implements n {
    public final PlaylistId r;

    public c2(PlaylistId playlistId0, Continuation continuation0) {
        this.r = playlistId0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new c2(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((c2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        MelonPrefs.getInstance().setInt("PLAYLIST_ID", this.r.getSeq());
        return H.a;
    }
}

