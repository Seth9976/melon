package com.iloen.melon.player.playlist.music;

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
@e(c = "com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel$setSelectRepeatAndPlay$1", f = "MusicPlaylistBaseViewModel.kt", l = {790}, m = "invokeSuspend")
final class MusicPlaylistBaseViewModel.setSelectRepeatAndPlay.1 extends i implements n {
    public final Object B;
    public int r;
    public final MusicPlaylistBaseViewModel w;

    public MusicPlaylistBaseViewModel.setSelectRepeatAndPlay.1(MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0, List list0, Continuation continuation0) {
        this.w = musicPlaylistBaseViewModel0;
        this.B = list0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new MusicPlaylistBaseViewModel.setSelectRepeatAndPlay.1(this.w, ((List)this.B), continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((MusicPlaylistBaseViewModel.setSelectRepeatAndPlay.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                return this.w.getPlayerUseCase().H(this.w.getPlaylistId(), ((List)this.B), this) == a0 ? a0 : H.a;
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

