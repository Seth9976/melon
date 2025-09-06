package pb;

import com.iloen.melon.playback.Playable;
import e.k;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class e extends i implements n {
    public final int B;
    public final Playable r;
    public final boolean w;

    public e(int v, Playable playable0, Continuation continuation0, boolean z) {
        this.r = playable0;
        this.w = z;
        this.B = v;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new e(this.B, this.r, continuation0, this.w);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e)this.create(((List)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        this.r.setLiked(this.w);
        this.r.setLikeCount(this.B);
        return k.z(this.r);
    }
}

