package com.melon.ui;

import T2.a;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.k;
import we.n;

public final class y extends i implements n {
    public final q B;
    public final a D;
    public final kotlin.jvm.internal.n E;
    public int r;
    public final Q w;

    public y(Q q0, q q1, a a0, k k0, Continuation continuation0) {
        this.w = q0;
        this.B = q1;
        this.D = a0;
        this.E = (kotlin.jvm.internal.n)k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new y(this.w, this.B, this.D, ((k)this.E), continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((y)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ne.a a0 = ne.a.a;
        Q q0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                if(q0.c.b(0x7F13090F, this) == a0) {  // string:section_repeat_mode_release_toast "반복재생이 해제되었습니다.\n반복재생은 재생 목록에서 재설정 가능합니다."
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
        q0.d(((K0)this.B).a, this.D, ((k)this.E));
        return H.a;
    }
}

