package com.iloen.melon.player.playlist;

import J8.i1;
import androidx.compose.ui.platform.ComposeView;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.PlaylistMainFragment$showController$1", f = "PlaylistMainFragment.kt", l = {}, m = "invokeSuspend")
final class PlaylistMainFragment.showController.1 extends i implements n {
    public final PlaylistMainFragment r;
    public final boolean w;

    public PlaylistMainFragment.showController.1(PlaylistMainFragment playlistMainFragment0, boolean z, Continuation continuation0) {
        this.r = playlistMainFragment0;
        this.w = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new PlaylistMainFragment.showController.1(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((PlaylistMainFragment.showController.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        i1 i10 = PlaylistMainFragment.access$getBinding(this.r);
        if(i10 != null) {
            ComposeView composeView0 = i10.e;
            if(composeView0 != null) {
                composeView0.setVisibility((this.w ? 0 : 8));
            }
        }
        return H.a;
    }
}

