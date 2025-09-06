package ec;

import P0.d0;
import R6.c;
import R8.l;
import d5.n;
import ie.H;
import ie.o;
import ie.p;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.k;

public final class e extends i implements k {
    public final long B;
    public int r;
    public final d0 w;

    public e(d0 d00, long v, Continuation continuation0) {
        this.w = d00;
        this.B = v;
        super(1, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Continuation continuation0) {
        return new e(this.w, this.B, continuation0);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return ((e)this.create(((Continuation)object0))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        o o0;
        a a0 = a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                n.D(object0);
                try {
                    l l0 = c.g();
                    this.r = 1;
                    if(l0.h(this.w, this.B, this) == a0) {
                        return a0;
                    label_9:
                        n.D(object0);
                    }
                    break;
                }
                catch(Throwable throwable0) {
                    o0 = n.t(throwable0);
                    goto label_15;
                }
            }
            case 1: {
                goto label_9;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        o0 = h0;
    label_15:
        boolean z = p.a(o0) == null;
        return h0;
    }
}

