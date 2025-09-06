package com.iloen.melon.player.playlist.mixup;

import com.iloen.melon.playback.Playable;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel$playInternal$2$1", f = "MixUpPlaylistComposeViewModel.kt", l = {594, 595}, m = "invokeSuspend")
final class MixUpPlaylistComposeViewModel.playInternal.2.1 extends i implements n {
    public final Integer B;
    public final Playable D;
    public int r;
    public final MixUpPlaylistComposeViewModel w;

    public MixUpPlaylistComposeViewModel.playInternal.2.1(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0, Integer integer0, Playable playable0, Continuation continuation0) {
        this.w = mixUpPlaylistComposeViewModel0;
        this.B = integer0;
        this.D = playable0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new MixUpPlaylistComposeViewModel.playInternal.2.1(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((MixUpPlaylistComposeViewModel.playInternal.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                if(MixUpPlaylistComposeViewModel.access$releaseSelectionRepeat(mixUpPlaylistComposeViewModel0, true, this) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            case 2: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        this.r = 2;
        return MixUpPlaylistComposeViewModel.access$playInternal(mixUpPlaylistComposeViewModel0, this.B, this.D, this) == a0 ? a0 : H.a;
    }
}

