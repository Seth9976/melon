package com.melon.ui;

import E9.h;
import com.iloen.melon.playback.playlist.add.AddAction;
import com.iloen.melon.playback.playlist.add.AddPlayableList;
import com.iloen.melon.playback.playlist.add.AddResult;
import ie.H;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class r extends i implements n {
    public final AddAction B;
    public int r;
    public final q w;

    public r(q q0, AddAction addAction0, Continuation continuation0) {
        this.w = q0;
        this.B = addAction0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new r(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((r)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        AddAction addAction0 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                ArrayList arrayList0 = h.W(((com.melon.ui.n)this.w).a);
                AddPlayableList addPlayableList0 = new AddPlayableList(null, addAction0, ((com.melon.ui.n)this.w).g, ((com.melon.ui.n)this.w).c, false, null, arrayList0, 0x20, null);
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
        ((AddResult)object0).handleToast(addAction0);
        return object0;
    }
}

