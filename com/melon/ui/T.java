package com.melon.ui;

import android.text.TextUtils;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlay;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlayOpenPlayer;
import com.iloen.melon.playback.playlist.add.AddResult;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.NonCancellable;
import ne.a;
import oe.i;
import we.k;
import we.n;

public final class t extends i implements n {
    public final Q B;
    public final kotlin.jvm.internal.n D;
    public int r;
    public final q w;

    public t(q q0, Q q1, Continuation continuation0, k k0) {
        this.w = q0;
        this.B = q1;
        this.D = (kotlin.jvm.internal.n)k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new t(this.w, this.B, continuation0, ((k)this.D));
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((t)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        H h0 = H.a;
        q q0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                boolean z = TextUtils.isEmpty(((m)q0).a);
                Q q1 = this.B;
                if(z) {
                    LogU.warn$default(q1.f, "playSong() invalid songId", null, false, 6, null);
                    return h0;
                }
                if(TextUtils.isEmpty(((m)q0).b)) {
                    LogU.warn$default(q1.f, "playSong() invalid menuId", null, false, 6, null);
                    return h0;
                }
                we.a a1 = ((m)q0).e;
                if(a1 != null) {
                    a1.invoke();
                }
                AddPlayOpenPlayer addAction$AddPlayOpenPlayer0 = ((m)q0).c ? new AddPlayOpenPlayer(false) : new AddPlay(false);
                s s0 = new s(q0, q1, addAction$AddPlayOpenPlayer0, null);
                this.r = 1;
                object0 = BuildersKt.withContext(NonCancellable.INSTANCE, s0, this);
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
        b b0 = new b(((AddResult)object0), q0);
        ((k)this.D).invoke(b0);
        return h0;
    }
}

