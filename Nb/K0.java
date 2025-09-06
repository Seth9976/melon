package Nb;

import com.melon.playback.PlaybackLibraryService;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class k0 extends i implements n {
    public final PlaybackLibraryService r;

    public k0(PlaybackLibraryService playbackLibraryService0, Continuation continuation0) {
        this.r = playbackLibraryService0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new k0(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((k0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        PlaybackLibraryService.k(this.r);
        return H.a;
    }
}

