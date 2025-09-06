package com.iloen.melon.player.playlist.mixup;

import Jd.g;
import ie.H;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel$handleToolBarEvent$1", f = "MixUpPlaylistComposeViewModel.kt", l = {678}, m = "invokeSuspend")
final class MixUpPlaylistComposeViewModel.handleToolBarEvent.1 extends i implements n {
    public final MixUpPlaylistComposeViewModel B;
    public int r;
    public final g w;

    public MixUpPlaylistComposeViewModel.handleToolBarEvent.1(g g0, MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0, Continuation continuation0) {
        this.w = g0;
        this.B = mixUpPlaylistComposeViewModel0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new MixUpPlaylistComposeViewModel.handleToolBarEvent.1(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((MixUpPlaylistComposeViewModel.handleToolBarEvent.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                String s = this.B.getMenuId();
                this.w.b(s);
                this.w.b = MixUpPlaylistComposeViewModel.access$getStatsElements(this.B);
                Jd.a a1 = MixUpPlaylistComposeViewModel.access$getToolBarEventHelper(this.B);
                List list0 = this.B.getSelectedPlayableList();
                this.r = 1;
                Jd.a.b(a1, this.w, list0);
                return h0 == a0 ? a0 : h0;
            }
            case 1: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

