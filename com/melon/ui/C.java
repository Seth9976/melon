package com.melon.ui;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.k;
import we.n;

public final class c extends i implements n {
    public final b r;
    public final k w;

    public c(b b0, k k0, Continuation continuation0) {
        this.r = b0;
        this.w = k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new c(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((c)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        q q0 = this.r.b;
        if(q0 != null) {
            K0 k00 = new K0(q0);
            this.w.invoke(k00);
        }
        return H.a;
    }
}

