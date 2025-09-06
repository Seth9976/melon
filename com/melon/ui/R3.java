package com.melon.ui;

import Cc.W2;
import Vc.B;
import com.iloen.melon.custom.L0;
import ea.a;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import oe.i;
import we.k;
import we.n;

public final class r3 extends i implements n {
    public final t3 B;
    public final q3 D;
    public final kotlin.jvm.internal.n E;
    public int r;
    public final L0 w;

    public r3(L0 l00, t3 t30, q3 q30, k k0, Continuation continuation0) {
        this.w = l00;
        this.B = t30;
        this.D = q30;
        this.E = (kotlin.jvm.internal.n)k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new r3(this.w, this.B, this.D, ((k)this.E), continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((r3)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Flow flow0;
        a a0 = this.B.a;
        ne.a a1 = ne.a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                q3 q30 = this.D;
                L0 l00 = this.w;
                if(l00 == null) {
                    q.g(q30.a, "playlistTypeCode");
                    flow0 = FlowKt.catch(FlowKt.flow(new tb.a(a0, q30.a, null)), new W2(a0, null, 3));
                }
                else {
                    l00.a("PutPopupUserEventHelper true", true);
                    try {
                        q.g(q30.a, "playlistTypeCode");
                        flow0 = FlowKt.catch(FlowKt.flow(new tb.a(a0, q30.a, null)), new W2(a0, null, 3));
                    }
                    finally {
                        l00.a("PutPopupUserEventHelper false", false);
                    }
                }
                B b0 = new B(((k)this.E));
                this.r = 1;
                H h1 = flow0.collect(new s3(b0, q30.a, q30.b, q30.c), this);
                if(h1 != a1) {
                    h1 = h0;
                }
                return h1 == a1 ? a1 : h0;
            }
            case 1: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

