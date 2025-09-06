package tc;

import com.melon.playlist.station.CastData;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class t extends i implements n {
    public final CastData B;
    public int r;
    public final x w;

    public t(CastData castData0, Continuation continuation0, x x0) {
        this.w = x0;
        this.B = castData0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new t(this.B, continuation0, this.w);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((t)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                s s0 = new s(this.B, null, this.w);
                this.r = 1;
                Object object1 = this.w.m(s0, this);
                return object1 == a0 ? a0 : object1;
            }
            case 1: {
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

