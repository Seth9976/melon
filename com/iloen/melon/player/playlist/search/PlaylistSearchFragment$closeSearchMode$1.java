package com.iloen.melon.player.playlist.search;

import com.iloen.melon.player.playlist.PlaylistSharedViewModel;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.search.PlaylistSearchFragment$closeSearchMode$1", f = "PlaylistSearchFragment.kt", l = {340}, m = "invokeSuspend")
final class PlaylistSearchFragment.closeSearchMode.1 extends i implements n {
    public int r;
    public final PlaylistSearchFragment w;

    public PlaylistSearchFragment.closeSearchMode.1(PlaylistSearchFragment playlistSearchFragment0, Continuation continuation0) {
        this.w = playlistSearchFragment0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new PlaylistSearchFragment.closeSearchMode.1(this.w, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((PlaylistSearchFragment.closeSearchMode.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                PlaylistSharedViewModel playlistSharedViewModel0 = PlaylistSearchFragment.access$getSharedViewModel(this.w);
                this.r = 1;
                return playlistSharedViewModel0.updateFocusingTabContentToSong(this) == a0 ? a0 : H.a;
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

