package com.melon.ui;

import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.s;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class z0 extends i implements n {
    public int r;
    public final C0 w;

    public z0(C0 c00, Continuation continuation0) {
        this.w = c00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new z0(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((z0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                D d0 = this.w.getViewLifecycleOwner();
                q.f(d0, "getViewLifecycleOwner(...)");
                y0 y00 = new y0(this.w, null);
                this.r = 1;
                return f0.j(d0, s.d, y00, this) == a0 ? a0 : H.a;
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

