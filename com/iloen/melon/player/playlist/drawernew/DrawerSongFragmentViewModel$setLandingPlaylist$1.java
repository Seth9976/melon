package com.iloen.melon.player.playlist.drawernew;

import com.iloen.melon.playback.playlist.PlaylistId;
import ie.H;
import kc.d3;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.e;
import oe.i;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel$setLandingPlaylist$1", f = "DrawerSongFragmentViewModel.kt", l = {868}, m = "invokeSuspend")
final class DrawerSongFragmentViewModel.setLandingPlaylist.1 extends i implements n {
    public final PlaylistId B;
    public int r;
    public final DrawerSongFragmentViewModel w;

    public DrawerSongFragmentViewModel.setLandingPlaylist.1(DrawerSongFragmentViewModel drawerSongFragmentViewModel0, PlaylistId playlistId0, Continuation continuation0) {
        this.w = drawerSongFragmentViewModel0;
        this.B = playlistId0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new DrawerSongFragmentViewModel.setLandingPlaylist.1(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((DrawerSongFragmentViewModel.setLandingPlaylist.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.setLandingPlaylist.1.1 drawerSongFragmentViewModel$setLandingPlaylist$1$10 = new k(this.B, null) {
                    public final DrawerSongFragmentViewModel r;
                    public final PlaylistId w;

                    {
                        this.r = drawerSongFragmentViewModel0;
                        this.w = playlistId0;
                        super(1, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.setLandingPlaylist.1.1(this.r, this.w, continuation0);
                    }

                    @Override  // we.k
                    public Object invoke(Object object0) {
                        return this.invoke(((Continuation)object0));
                    }

                    public final Object invoke(Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.setLandingPlaylist.1.1)this.create(continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        d5.n.D(object0);
                        OnChangeLandingPlaylist drawerSongUiEvent$OnChangeLandingPlaylist0 = new OnChangeLandingPlaylist(this.w);
                        DrawerSongFragmentViewModel.access$sendUiEvent(this.r, drawerSongUiEvent$OnChangeLandingPlaylist0);
                        return H.a;
                    }
                };
                com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.setLandingPlaylist.1.2 drawerSongFragmentViewModel$setLandingPlaylist$1$20 = new k(this.B, null) {
                    public final DrawerSongFragmentViewModel r;
                    public final PlaylistId w;

                    {
                        this.r = drawerSongFragmentViewModel0;
                        this.w = playlistId0;
                        super(1, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.setLandingPlaylist.1.2(this.r, this.w, continuation0);
                    }

                    @Override  // we.k
                    public Object invoke(Object object0) {
                        return this.invoke(((Continuation)object0));
                    }

                    public final Object invoke(Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.setLandingPlaylist.1.2)this.create(continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        d5.n.D(object0);
                        ((d3)DrawerSongFragmentViewModel.access$getPlaylistManager$p(this.r)).b();
                        OnChangeLandingPlaylist drawerSongUiEvent$OnChangeLandingPlaylist0 = new OnChangeLandingPlaylist(this.w);
                        DrawerSongFragmentViewModel.access$sendUiEvent(this.r, drawerSongUiEvent$OnChangeLandingPlaylist0);
                        return H.a;
                    }
                };
                this.r = 1;
                return DrawerSongFragmentViewModel.access$checkViewModeAndRunAction(this.w, drawerSongFragmentViewModel$setLandingPlaylist$1$10, drawerSongFragmentViewModel$setLandingPlaylist$1$20, this) == a0 ? a0 : H.a;
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

