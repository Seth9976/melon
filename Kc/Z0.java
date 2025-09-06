package kc;

import Vb.d0;
import Vb.o0;
import com.melon.playlist.b;
import d5.n;
import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import oc.T;
import oc.U;
import oe.i;
import we.k;

public final class z0 extends i implements k {
    public final U B;
    public int r;
    public final b w;

    public z0(b b0, U u0, Continuation continuation0) {
        this.w = b0;
        this.B = u0;
        super(1, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Continuation continuation0) {
        return new z0(this.w, this.B, continuation0);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return ((z0)this.create(((Continuation)object0))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                n.D(object0);
                e e0 = this.w.t;
                if(e0 != null) {
                    this.r = 1;
                    H h1 = o0.T0(((d0)e0).a, ((T)this.B), this);
                    if(h1 != a0) {
                        h1 = h0;
                    }
                    return h1 == a0 ? a0 : h0;
                }
                return null;
            }
            case 1: {
                n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

