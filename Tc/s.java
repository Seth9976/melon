package tc;

import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.station.CastData;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import oe.i;
import we.n;

public final class s extends i implements n {
    public final x B;
    public Object r;
    public final CastData w;

    public s(CastData castData0, Continuation continuation0, x x0) {
        this.w = castData0;
        this.B = x0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new s(this.w, continuation0, this.B);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((s)this.create(((F)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        F f0 = (F)this.r;
        d5.n.D(object0);
        CastData castData0 = this.w;
        if(q.b((f0.c == null ? null : f0.c.a), castData0.a)) {
            return F.f(f0, null, 0, castData0, 3);
        }
        LogU.error$default(this.B.b, "updateCastData() invalid castSeq", null, false, 6, null);
        return f0;
    }
}

