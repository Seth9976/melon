package ud;

import O.F;
import d9.h;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import ne.a;
import oe.i;
import we.n;

public final class g extends i implements n {
    public final h B;
    public int r;
    public final F w;

    public g(F f0, h h0, Continuation continuation0) {
        this.w = f0;
        this.B = h0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new g(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((g)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int v;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                if(DelayKt.delay(200L, this) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            case 2: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Integer integer0 = (Integer)this.B.h.getValue();
        if(integer0 == null) {
            v = 0;
        }
        else {
            v = (int)integer0;
            if(v < 0) {
                v = 0;
            }
        }
        this.r = 2;
        return this.w.f(v, 0, this) == a0 ? a0 : H.a;
    }
}

