package kc;

import com.iloen.melon.playback.Playable;
import e.k;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class h1 extends i implements n {
    public final boolean B;
    public final Playable r;
    public final int w;

    public h1(int v, Playable playable0, Continuation continuation0, boolean z) {
        this.r = playable0;
        this.w = v;
        this.B = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new h1(this.w, this.r, continuation0, this.B);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h1)this.create(((List)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        this.r.setLikeCount(this.w);
        this.r.setLiked(this.B);
        return k.z(this.r);
    }
}

