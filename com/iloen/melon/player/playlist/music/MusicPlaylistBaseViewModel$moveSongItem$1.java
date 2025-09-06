package com.iloen.melon.player.playlist.music;

import M6.B;
import com.iloen.melon.playback.playlist.PlaylistId;
import ie.H;
import kc.P2;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel$moveSongItem$1", f = "MusicPlaylistBaseViewModel.kt", l = {820}, m = "invokeSuspend")
final class MusicPlaylistBaseViewModel.moveSongItem.1 extends i implements n {
    public final int B;
    public final int D;
    public int r;
    public final MusicPlaylistBaseViewModel w;

    public MusicPlaylistBaseViewModel.moveSongItem.1(MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0, int v, int v1, Continuation continuation0) {
        this.w = musicPlaylistBaseViewModel0;
        this.B = v;
        this.D = v1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new MusicPlaylistBaseViewModel.moveSongItem.1(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((MusicPlaylistBaseViewModel.moveSongItem.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                s2 s20 = this.w.getPlaylistManager();
                PlaylistId playlistId0 = this.w.getPlaylistId();
                ((d3)s20).getClass();
                q.g(playlistId0, "playlistId");
                P2 p20 = new P2(((d3)s20), playlistId0, this.B, this.D, null);
                B b0 = ListenableFutureKt.future$default(((d3)s20).b, null, null, p20, 3, null);
                this.r = 1;
                return ListenableFutureKt.await(b0, this) == a0 ? a0 : H.a;
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

