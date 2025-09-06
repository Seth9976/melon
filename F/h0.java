package F;

import G.e;
import G.m;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import r1.l;
import we.n;

public final class h0 extends i implements n {
    public final long B;
    public final j0 D;
    public int r;
    public final g0 w;

    public h0(g0 g00, long v, j0 j00, Continuation continuation0) {
        this.w = g00;
        this.B = v;
        this.D = j00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new h0(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                l l0 = new l(this.B);
                this.r = 1;
                object0 = e.c(this.w.a, l0, this.D.a, null, this, 12);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        m m0 = (m)object0;
        return H.a;
    }
}

