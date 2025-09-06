package sc;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oc.M;
import oe.i;
import we.n;

public final class i0 extends i implements n {
    public final M B;
    public int r;
    public final P0 w;

    public i0(P0 p00, M m0, Continuation continuation0) {
        this.w = p00;
        this.B = m0;
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
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                h0 h00 = new h0(this.w, this.B, null);
                this.r = 1;
                Object object1 = this.w.e0(h00, this);
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

