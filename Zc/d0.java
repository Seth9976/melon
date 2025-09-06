package Zc;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class d0 extends i implements n {
    public final H B;
    public int r;
    public final t0 w;

    public d0(t0 t00, H h0, Continuation continuation0) {
        this.w = t00;
        this.B = h0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new d0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((d0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(ie.H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                Object object1 = this.w.h.w(((String)this.B.a), this);
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

