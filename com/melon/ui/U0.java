package com.melon.ui;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import ne.a;
import oe.i;
import we.n;

public final class u0 extends i implements n {
    public int r;
    public final w0 w;

    public u0(w0 w00, Continuation continuation0) {
        this.w = w00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new u0(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((u0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Flow flow0 = this.w.getViewModel().getUiEvent();
                r0 r00 = new r0(this.w, 1);
                this.r = 1;
                return flow0.collect(r00, this) == a0 ? a0 : H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

