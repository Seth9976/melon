package Zc;

import e1.u;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import va.e0;
import we.n;

public final class l0 extends i implements n {
    public final String B;
    public int r;
    public final t0 w;

    public l0(t0 t00, String s, Continuation continuation0) {
        this.w = t00;
        this.B = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new l0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((l0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        t0 t00 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                String s = u.v(((e0)t00.i).j());
                this.r = 1;
                if(t00.h.p(this.B, s, this) == a0) {
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
        this.r = 2;
        return t0.d(t00, this) == a0 ? a0 : H.a;
    }
}

