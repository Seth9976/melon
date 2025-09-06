package kc;

import Vb.d0;
import com.melon.playlist.b;
import d5.n;
import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import oc.Q;
import oe.i;
import we.k;

public final class o extends i implements k {
    public final Q B;
    public final long D;
    public int r;
    public final b w;

    public o(b b0, Q q0, long v, Continuation continuation0) {
        this.w = b0;
        this.B = q0;
        this.D = v;
        super(1, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Continuation continuation0) {
        return new o(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return ((o)this.create(((Continuation)object0))).invokeSuspend(H.a);
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
                    return ((d0)e0).b(this.B, this.D, true, this) == a0 ? a0 : H.a;
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

