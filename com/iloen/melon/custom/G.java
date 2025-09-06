package com.iloen.melon.custom;

import android.animation.AnimatorSet;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import ne.a;
import oe.i;
import we.n;

public final class g extends i implements n {
    public int r;
    public final ArtistCardRelayRollingView w;

    public g(ArtistCardRelayRollingView artistCardRelayRollingView0, Continuation continuation0) {
        this.w = artistCardRelayRollingView0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new g(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((g)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return a.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                goto label_9;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        do {
            AnimatorSet animatorSet0 = this.w.getRollingAnim();
            animatorSet0.start();
            this.w.d = animatorSet0;
        label_9:
            this.r = 1;
        }
        while(DelayKt.delay(0x10FEL, this) != a0);
        return a0;
    }
}

