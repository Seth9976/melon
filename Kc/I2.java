package kc;

import com.iloen.melon.playback.Playable;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class i2 extends i implements n {
    public final r2 r;
    public final Playable w;

    public i2(r2 r20, Playable playable0, Continuation continuation0) {
        this.r = r20;
        this.w = playable0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new i2(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((i2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        return r2.c(this.w);
    }
}

