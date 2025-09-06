package com.melon.ui;

import com.iloen.melon.sns.model.Sharable;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.i;
import we.k;
import we.n;

public final class h4 extends i implements n {
    public final kotlin.jvm.internal.n B;
    public final n4 D;
    public final N3 E;
    public int r;
    public Object w;

    public h4(N3 n30, n4 n40, Continuation continuation0, k k0) {
        this.B = (kotlin.jvm.internal.n)k0;
        this.D = n40;
        this.E = n30;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new h4(this.E, this.D, continuation0, ((k)this.B));
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h4)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(coroutineScope0, Dispatchers.getIO(), null, new g4(this.D, this.E, null), 2, null);
                this.w = null;
                this.r = 1;
                object0 = deferred0.await(this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        w3 w30 = new w3(((Sharable)object0));
        ((k)this.B).invoke(w30);
        return H.a;
    }
}

