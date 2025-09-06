package kc;

import d5.n;
import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import oc.b;
import oe.i;
import we.k;

public final class u extends i implements k {
    public final b B;
    public int r;
    public final com.melon.playlist.b w;

    public u(com.melon.playlist.b b0, b b1, Continuation continuation0) {
        this.w = b0;
        this.B = b1;
        super(1, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Continuation continuation0) {
        return new u(this.w, this.B, continuation0);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return ((u)this.create(((Continuation)object0))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                n.D(object0);
                e e0 = this.w.t;
                if(e0 != null) {
                    this.r = 1;
                    return e.a(e0, this.B.a, true, this) == a0 ? a0 : H.a;
                }
                return null;
            }
            case 1: {
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

