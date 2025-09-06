package kc;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.log.LogConstantsKt;
import e.k;
import ie.H;
import java.util.List;
import je.w;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class w1 extends i implements n {
    public final String B;
    public final long D;
    public Object r;
    public final A1 w;

    public w1(A1 a10, String s, long v, Continuation continuation0) {
        this.w = a10;
        this.B = s;
        this.D = v;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new w1(this.w, this.B, this.D, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((w1)this.create(((List)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        List list0 = (List)this.r;
        d5.n.D(object0);
        A1 a10 = this.w;
        a10.getClass();
        Playable playable0 = A1.a(this.B, list0);
        if(playable0 != null) {
            playable0.setDurationLimit(this.D);
            return k.z(playable0);
        }
        LogConstantsKt.errorOnlyDebugMode(a10.c, "updateDurationLimit() failed.");
        return w.a;
    }
}

