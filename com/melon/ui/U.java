package com.melon.ui;

import com.iloen.melon.playback.playlist.add.AddAction;
import com.iloen.melon.playback.playlist.add.AddResult;
import com.iloen.melon.playback.playlist.add.AddServerContent;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MixUp;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class u extends i implements n {
    public final Q B;
    public final AddAction D;
    public int r;
    public final q w;

    public u(q q0, Q q1, AddAction addAction0, Continuation continuation0) {
        this.w = q0;
        this.B = q1;
        this.D = addAction0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new u(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((u)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        AddAction addAction0 = this.D;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                MixUp playDataForSeverContent$MixUp0 = new MixUp(((com.melon.ui.i)this.w).b, ((com.melon.ui.i)this.w).a, null);
                AddServerContent addServerContent0 = new AddServerContent(addAction0, ((com.melon.ui.i)this.w).c, false, this.B.a, playDataForSeverContent$MixUp0, 4, null);
                this.r = 1;
                object0 = addServerContent0.execute(this);
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
        ((AddResult)object0).handleToast(addAction0);
        return object0;
    }
}

