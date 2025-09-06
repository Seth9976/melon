package com.melon.ui;

import ie.H;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class j0 extends i implements n {
    public final String B;
    public final Map D;
    public int r;
    public final n0 w;

    public j0(n0 n00, String s, Map map0, Continuation continuation0) {
        this.w = n00;
        this.B = s;
        this.D = map0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new j0(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((j0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                eb.n n0 = this.w.getPvUseCase();
                Q0.n n1 = new Q0.n(0, 3, n0.class, this.w, "isFragmentVisible", "isFragmentVisible()Z");
                h0 h00 = new h0(this.w, 1);
                this.r = 1;
                return n0.d(this.B, this.D, n1, h00, this) == a0 ? a0 : H.a;
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

