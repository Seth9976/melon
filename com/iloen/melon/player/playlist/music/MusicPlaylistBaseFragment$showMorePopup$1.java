package com.iloen.melon.player.playlist.music;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableExtensionsKt;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.popup.context.more.b;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.e;
import oe.i;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment$showMorePopup$1", f = "MusicPlaylistBaseFragment.kt", l = {}, m = "invokeSuspend")
final class MusicPlaylistBaseFragment.showMorePopup.1 extends i implements n {
    public final MusicPlaylistBaseFragment r;
    public final int w;

    public MusicPlaylistBaseFragment.showMorePopup.1(MusicPlaylistBaseFragment musicPlaylistBaseFragment0, int v, Continuation continuation0) {
        this.r = musicPlaylistBaseFragment0;
        this.w = v;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new MusicPlaylistBaseFragment.showMorePopup.1(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((MusicPlaylistBaseFragment.showMorePopup.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        MusicPlaylistBaseFragment musicPlaylistBaseFragment0 = this.r;
        SongUiState songUiState0 = MusicPlaylistBaseFragment.access$getViewModel(musicPlaylistBaseFragment0).getSongUiState(this.w);
        Playable playable0 = songUiState0 == null ? null : songUiState0.getPlayable();
        H h0 = H.a;
        if(playable0 == null) {
            LogU.error$default(musicPlaylistBaseFragment0.getLog(), "clickable(), More - playable is null", null, false, 6, null);
            return h0;
        }
        Playable playable1 = PlayableExtensionsKt.copyAndUpdatedWhenLocal(playable0);
        boolean z = MusicPlaylistBaseFragment.access$getViewModel(musicPlaylistBaseFragment0).isDj();
        b b0 = new b(PlaylistId.MUSIC, playable1, true, z, songUiState0.getThumbnailUri());
        if(!H0.e.N(musicPlaylistBaseFragment0)) {
            return h0;
        }
        musicPlaylistBaseFragment0.showContextMorePopup(musicPlaylistBaseFragment0, b0, new f(musicPlaylistBaseFragment0, playable1, playable0, b0));
        musicPlaylistBaseFragment0.getTiaraLogHelper().sendMoreClickLog(playable0);
        return h0;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment.showMorePopup.1.1.1 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                ((MusicPlaylistBaseFragment)this.receiver).sendUserEvent(e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment.showMorePopup.1.1.2 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                ((MusicPlaylistBaseFragment)this.receiver).sendUserEvent(e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment.showMorePopup.1.1.3 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                ((MusicPlaylistBaseFragment)this.receiver).sendUserEvent(e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment.showMorePopup.1.1.4 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                ((MusicPlaylistBaseFragment)this.receiver).sendUserEvent(e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment.showMorePopup.1.1.5 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                ((MusicPlaylistBaseFragment)this.receiver).sendUserEvent(e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment.showMorePopup.1.1.6 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                ((MusicPlaylistBaseFragment)this.receiver).sendUserEvent(e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment.showMorePopup.1.1.7 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                ((MusicPlaylistBaseFragment)this.receiver).sendUserEvent(e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment.showMorePopup.1.1.8 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                ((MusicPlaylistBaseFragment)this.receiver).sendUserEvent(e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment.showMorePopup.1.1.9 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                ((MusicPlaylistBaseFragment)this.receiver).sendUserEvent(e0);
            }
        }

    }
}

