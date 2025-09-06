package com.iloen.melon.player.playlist.mixup;

import com.melon.ui.n0;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment$onForegroundEvent$1", f = "MixUpPlaylistComposeFragment.kt", l = {305}, m = "invokeSuspend")
final class MixUpPlaylistComposeFragment.onForegroundEvent.1 extends i implements n {
    public int r;
    public final MixUpPlaylistComposeFragment w;

    public MixUpPlaylistComposeFragment.onForegroundEvent.1(MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0, Continuation continuation0) {
        this.w = mixUpPlaylistComposeFragment0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new MixUpPlaylistComposeFragment.onForegroundEvent.1(this.w, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((MixUpPlaylistComposeFragment.onForegroundEvent.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                object0 = MixUpPlaylistComposeFragment.access$getPvDummyAction(mixUpPlaylistComposeFragment0, this);
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
        if(q.b(((String)object0), MixUpPlaylistComposeFragment.access$getLastPvDummyAction$p(mixUpPlaylistComposeFragment0))) {
            n0.performPvLoggingOnForeground$default(MixUpPlaylistComposeFragment.access$getViewModel(mixUpPlaylistComposeFragment0), ((String)object0), null, 2, null);
        }
        else {
            MixUpPlaylistComposeFragment.access$getViewModel(mixUpPlaylistComposeFragment0).clearTiaraPropertyAndPerformPvDummyLogging(((String)object0));
        }
        MixUpPlaylistComposeFragment.access$setLastPvDummyAction$p(mixUpPlaylistComposeFragment0, ((String)object0));
        return H.a;
    }
}

