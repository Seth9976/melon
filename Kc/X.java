package kc;

import com.melon.playlist.b;
import d5.n;
import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import oc.d;
import oc.e;
import oe.i;
import we.k;

public final class x extends i implements k {
    public final e B;
    public int r;
    public final b w;

    public x(b b0, e e0, Continuation continuation0) {
        this.w = b0;
        this.B = e0;
        super(1, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Continuation continuation0) {
        return new x(this.w, this.B, continuation0);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return ((x)this.create(((Continuation)object0))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                n.D(object0);
                if(this.w.t != null) {
                    d d0 = (d)this.B;
                    this.r = 1;
                    return h0 == a0 ? a0 : h0;
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

