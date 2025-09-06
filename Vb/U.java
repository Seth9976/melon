package Vb;

import ac.b;
import ac.c;
import ac.d;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class u extends i implements n {
    public long r;
    public final o0 w;

    public u(o0 o00, Continuation continuation0) {
        this.w = o00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new u(this.w, continuation0);
        continuation1.r = ((Number)object0).longValue();
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((u)this.create(((Number)object0).longValue(), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        long v = this.r;
        d5.n.D(object0);
        o0 o00 = this.w;
        d d0 = o00.O;
        if(d0 instanceof b) {
            long v1 = ((b)d0).a;
            if(v < v1) {
                o00.i0(5, v1);
                return H.a;
            }
        }
        else if(d0 instanceof c) {
            long v2 = ((c)d0).a;
            if(v > ((c)d0).b || v2 > v) {
                o00.i0(5, v2);
            }
        }
        return H.a;
    }
}

