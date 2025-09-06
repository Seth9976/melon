package com.melon.ui;

import androidx.compose.runtime.b0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import ne.a;
import oe.i;
import we.n;

public final class t1 extends i implements n {
    public final b0 B;
    public int r;
    public final u1 w;

    public t1(u1 u10, b0 b00, Continuation continuation0) {
        this.w = u10;
        this.B = b00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new t1(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((t1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        b0 b00 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                b00.setValue(Boolean.TRUE);
                this.r = 1;
                if(DelayKt.delay(1000L, this) == a0) {
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
        b00.setValue(Boolean.FALSE);
        this.w.forceRefresh();
        return H.a;
    }
}

