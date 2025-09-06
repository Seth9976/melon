package U;

import I.Z0;
import J0.y;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class i0 extends i implements n {
    public final t0 B;
    public int r;
    public final y w;

    public i0(y y0, t0 t00, Continuation continuation0) {
        this.w = y0;
        this.B = t00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new i0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((i0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                n0 n00 = new n0(this.B, null);
                H h1 = Z0.c(this.w, n00, this);
                if(h1 != a0) {
                    h1 = h0;
                }
                return h1 == a0 ? a0 : h0;
            }
            case 1: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

