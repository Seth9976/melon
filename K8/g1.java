package k8;

import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.playback.playlist.PlaylistId;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class g1 extends i implements n {
    public Object r;
    public final MusicBrowserActivity w;

    public g1(MusicBrowserActivity musicBrowserActivity0, Continuation continuation0) {
        this.w = musicBrowserActivity0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new g1(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((g1)this.create(((PlaylistId)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        PlaylistId playlistId0 = (PlaylistId)this.r;
        d5.n.D(object0);
        this.w.setVideoUIAndMiniPlayerUI(playlistId0);
        return H.a;
    }
}

