package com.melon.ui;

import com.iloen.melon.playback.playlist.add.AddAction.AddPlay;
import com.iloen.melon.playback.playlist.add.AddResult;
import com.iloen.melon.playback.playlist.add.AddServerContent;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MusicWave;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class w extends i implements n {
    public final AddPlay B;
    public int r;
    public final q w;

    public w(q q0, AddPlay addAction$AddPlay0, Continuation continuation0) {
        this.w = q0;
        this.B = addAction$AddPlay0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new w(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((w)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        AddPlay addAction$AddPlay0 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                MusicWave playDataForSeverContent$MusicWave0 = new MusicWave(((j)this.w).a, ((j)this.w).b, null);
                AddServerContent addServerContent0 = new AddServerContent(addAction$AddPlay0, ((j)this.w).d, false, null, playDataForSeverContent$MusicWave0, 12, null);
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
        ((AddResult)object0).handleToast(addAction$AddPlay0);
        return object0;
    }
}

