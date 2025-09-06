package com.iloen.melon.player.playlist.music;

import com.iloen.melon.player.playlist.common.PlaylistCommonUiEvent.ShowSelectionRepeatInterruptPopup;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.e;
import oe.i;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel$checkSelectRepeatClearAndDo$2", f = "MusicPlaylistBaseViewModel.kt", l = {0x27F, 651}, m = "invokeSuspend")
final class MusicPlaylistBaseViewModel.checkSelectRepeatClearAndDo.2 extends i implements n {
    public final MusicPlaylistBaseViewModel B;
    public final i D;
    public int r;
    public final i w;

    public MusicPlaylistBaseViewModel.checkSelectRepeatClearAndDo.2(k k0, MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0, k k1, Continuation continuation0) {
        this.w = (i)k0;
        this.B = musicPlaylistBaseViewModel0;
        this.D = (i)k1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new MusicPlaylistBaseViewModel.checkSelectRepeatClearAndDo.2(((k)this.w), this.B, ((k)this.D), continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((MusicPlaylistBaseViewModel.checkSelectRepeatClearAndDo.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                object0 = ((k)this.w).invoke(this);
                if(object0 == a0) {
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
        i i0 = this.D;
        if(((Boolean)object0).booleanValue()) {
            ShowSelectionRepeatInterruptPopup playlistCommonUiEvent$ShowSelectionRepeatInterruptPopup0 = new ShowSelectionRepeatInterruptPopup(new o(this.B, ((k)i0)));
            MusicPlaylistBaseViewModel.access$sendUiEvent(this.B, playlistCommonUiEvent$ShowSelectionRepeatInterruptPopup0);
            return H.a;
        }
        this.r = 2;
        return ((k)i0).invoke(this) == a0 ? a0 : H.a;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel$checkSelectRepeatClearAndDo$2$1$1", f = "MusicPlaylistBaseViewModel.kt", l = {644, 645}, m = "invokeSuspend")
        final class com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.checkSelectRepeatClearAndDo.2.1.1 extends i implements n {
            public final i B;
            public int r;
            public final MusicPlaylistBaseViewModel w;

            public com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.checkSelectRepeatClearAndDo.2.1.1(MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0, k k0, Continuation continuation0) {
                this.w = musicPlaylistBaseViewModel0;
                this.B = (i)k0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.checkSelectRepeatClearAndDo.2.1.1(this.w, ((k)this.B), continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.checkSelectRepeatClearAndDo.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        this.r = 1;
                        if(this.w.getPlayerUseCase().b(0x7F13090F, this) == a0) {  // string:section_repeat_mode_release_toast "반복재생이 해제되었습니다.\n반복재생은 재생 목록에서 재설정 가능합니다."
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
                return ((k)this.B).invoke(this) == a0 ? a0 : H.a;
            }
        }

    }
}

