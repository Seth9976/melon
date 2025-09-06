package com.melon.ui;

import com.iloen.melon.playback.playlist.add.AddAction.AddPlay;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlayOpenPlayer;
import com.iloen.melon.playback.playlist.add.AddResult;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.melon.ui.interfaces.StringProviderImpl;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.NonCancellable;
import ne.a;
import oe.i;
import pc.P0;
import pc.w1;
import we.k;
import we.n;

public final class v extends i implements n {
    public final Q B;
    public final q D;
    public int r;
    public final kotlin.jvm.internal.n w;

    public v(q q0, Q q1, Continuation continuation0, k k0) {
        this.w = (kotlin.jvm.internal.n)k0;
        this.B = q1;
        this.D = q0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new v(this.D, this.B, continuation0, ((k)this.w));
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((v)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Q q0 = this.B;
        StringProviderImpl stringProviderImpl0 = q0.e;
        a a0 = a.a;
        kotlin.jvm.internal.n n0 = this.w;
        H h0 = H.a;
        q q1 = this.D;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                if(!NetUtils.isConnected()) {
                    ((k)n0).invoke(new q4(28, stringProviderImpl0.a(0x7F1300D0), stringProviderImpl0.a(0x7F1303D9), null, null));  // string:alert_dlg_title_info "안내"
                    return h0;
                }
                if(((com.melon.ui.i)q1).a.length() == 0) {
                    LogU.warn$default(q0.f, "playMixUp() invalid menuId", null, false, 6, null);
                    return h0;
                }
                w1 w10 = ((com.melon.ui.i)q1).b;
                AddPlay addAction$AddPlay0 = !(w10 instanceof P0) || !((P0)w10).c ? new AddPlay(false) : new AddPlayOpenPlayer(false);
                u u0 = new u(q1, q0, addAction$AddPlay0, null);
                this.r = 1;
                object0 = BuildersKt.withContext(NonCancellable.INSTANCE, u0, this);
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
        ((k)n0).invoke(new b(((AddResult)object0), q1));
        return h0;
    }
}

