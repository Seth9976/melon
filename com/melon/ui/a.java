package com.melon.ui;

import E9.h;
import com.iloen.melon.playback.playlist.add.AddAction.Add;
import com.iloen.melon.playback.playlist.add.AddPlayableList;
import com.iloen.melon.playback.playlist.add.AddResult;
import ie.H;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class A extends i implements n {
    public final q B;
    public int r;
    public final Add w;

    public A(Add addAction$Add0, q q0, Continuation continuation0) {
        this.w = addAction$Add0;
        this.B = q0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new A(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((A)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                boolean z = ((g)this.B).c;
                ((g)this.B).getClass();
                ArrayList arrayList0 = h.W(((g)this.B).a);
                AddPlayableList addPlayableList0 = new AddPlayableList(null, this.w, z, false, false, null, arrayList0, 0x20, null);
                this.r = 1;
                object0 = addPlayableList0.execute(this);
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
        ((AddResult)object0).handleToast(this.w);
        return object0;
    }
}

