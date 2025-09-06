package eb;

import com.iloen.melon.net.v4x.response.PvLogDummyRes;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import we.a;
import we.k;
import we.n;

public final class i extends oe.i implements n {
    public final PvLogDummyRes B;
    public final eb.n D;
    public final a E;
    public int r;
    public final k w;

    public i(k k0, PvLogDummyRes pvLogDummyRes0, eb.n n0, a a0, Continuation continuation0) {
        this.w = k0;
        this.B = pvLogDummyRes0;
        this.D = n0;
        this.E = a0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new i(this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((i)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ne.a a0 = ne.a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.w.invoke(this.B);
                this.r = 1;
                return this.D.c(this.B, this.E, this) == a0 ? a0 : H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

