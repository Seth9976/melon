package com.melon.ui;

import com.iloen.melon.playback.playlist.add.AddFailType.MusicWaveOpen;
import com.iloen.melon.playback.playlist.add.AddResult.Failure;
import com.iloen.melon.playback.playlist.add.AddResult;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class d extends i implements n {
    public int r;
    public final AddResult w;

    public d(AddResult addResult0, Continuation continuation0) {
        this.w = addResult0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new d(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((d)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                MusicWaveOpen addFailType$MusicWaveOpen0 = (MusicWaveOpen)((Failure)this.w).getType();
                this.r = 1;
                return addFailType$MusicWaveOpen0.navigate(this) == a0 ? a0 : H.a;
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

