package kc;

import com.iloen.melon.playback.Playable;
import e.k;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class t0 extends i implements n {
    public final Playable r;

    public t0(Playable playable0, Continuation continuation0) {
        this.r = playable0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new t0(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((t0)this.create(((List)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        this.r.setLyricType("0");
        return k.z(this.r);
    }
}

