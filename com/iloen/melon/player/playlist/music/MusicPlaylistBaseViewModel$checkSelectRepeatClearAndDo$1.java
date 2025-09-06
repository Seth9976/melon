package com.iloen.melon.player.playlist.music;

import d5.n;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.e;
import oe.i;
import we.k;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000B\u0010\u0000\u001A\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel$checkSelectRepeatClearAndDo$1", f = "MusicPlaylistBaseViewModel.kt", l = {634}, m = "invokeSuspend")
final class MusicPlaylistBaseViewModel.checkSelectRepeatClearAndDo.1 extends i implements k {
    public int r;
    public final MusicPlaylistBaseViewModel w;

    public MusicPlaylistBaseViewModel.checkSelectRepeatClearAndDo.1(MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0, Continuation continuation0) {
        this.w = musicPlaylistBaseViewModel0;
        super(1, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Continuation continuation0) {
        return new MusicPlaylistBaseViewModel.checkSelectRepeatClearAndDo.1(this.w, continuation0);
    }

    @Override  // we.k
    public Object invoke(Object object0) {
        return this.invoke(((Continuation)object0));
    }

    public final Object invoke(Continuation continuation0) {
        return ((MusicPlaylistBaseViewModel.checkSelectRepeatClearAndDo.1)this.create(continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                n.D(object0);
                this.r = 1;
                Object object1 = this.w.getPlayerUseCase().o(this);
                return object1 == a0 ? a0 : object1;
            }
            case 1: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

