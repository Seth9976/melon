package com.iloen.melon.player.playlist.search;

import android.net.Uri;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableExtensionsKt;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.e;
import oe.i;
import we.k;
import we.n;
import zd.Q;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.search.PlaylistSearchFragment$performShowMoreContextPopup$1", f = "PlaylistSearchFragment.kt", l = {}, m = "invokeSuspend")
final class PlaylistSearchFragment.performShowMoreContextPopup.1 extends i implements n {
    public final Uri B;
    public final Playable r;
    public final PlaylistSearchFragment w;

    public PlaylistSearchFragment.performShowMoreContextPopup.1(Playable playable0, PlaylistSearchFragment playlistSearchFragment0, Uri uri0, Continuation continuation0) {
        this.r = playable0;
        this.w = playlistSearchFragment0;
        this.B = uri0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new PlaylistSearchFragment.performShowMoreContextPopup.1(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((PlaylistSearchFragment.performShowMoreContextPopup.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        Playable playable0 = this.r;
        Playable playable1 = PlayableExtensionsKt.copyAndUpdatedWhenLocal(playable0);
        PlaylistSearchFragment playlistSearchFragment0 = this.w;
        Q q0 = PlaylistSearchFragment.access$getViewModel(playlistSearchFragment0).getMorePopUpType(playable1, this.B);
        if(q0 == null) {
            q0 = null;
        }
        boolean z = H0.e.N(playlistSearchFragment0);
        H h0 = H.a;
        if(z && q0 != null) {
            playlistSearchFragment0.showContextMorePopup(playlistSearchFragment0, q0, new d(playlistSearchFragment0, playable1, q0, playable0));
        }
        return h0;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.search.PlaylistSearchFragment.performShowMoreContextPopup.1.1.10 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                PlaylistSearchFragment.access$sendUserEvent(((PlaylistSearchFragment)this.receiver), e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.search.PlaylistSearchFragment.performShowMoreContextPopup.1.1.1 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                PlaylistSearchFragment.access$sendUserEvent(((PlaylistSearchFragment)this.receiver), e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.search.PlaylistSearchFragment.performShowMoreContextPopup.1.1.2 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                PlaylistSearchFragment.access$sendUserEvent(((PlaylistSearchFragment)this.receiver), e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.search.PlaylistSearchFragment.performShowMoreContextPopup.1.1.3 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                PlaylistSearchFragment.access$sendUserEvent(((PlaylistSearchFragment)this.receiver), e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.search.PlaylistSearchFragment.performShowMoreContextPopup.1.1.4 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                PlaylistSearchFragment.access$sendUserEvent(((PlaylistSearchFragment)this.receiver), e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.search.PlaylistSearchFragment.performShowMoreContextPopup.1.1.5 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                PlaylistSearchFragment.access$sendUserEvent(((PlaylistSearchFragment)this.receiver), e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.search.PlaylistSearchFragment.performShowMoreContextPopup.1.1.6 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                PlaylistSearchFragment.access$sendUserEvent(((PlaylistSearchFragment)this.receiver), e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.search.PlaylistSearchFragment.performShowMoreContextPopup.1.1.7 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                PlaylistSearchFragment.access$sendUserEvent(((PlaylistSearchFragment)this.receiver), e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.search.PlaylistSearchFragment.performShowMoreContextPopup.1.1.8 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                PlaylistSearchFragment.access$sendUserEvent(((PlaylistSearchFragment)this.receiver), e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.search.PlaylistSearchFragment.performShowMoreContextPopup.1.1.9 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                PlaylistSearchFragment.access$sendUserEvent(((PlaylistSearchFragment)this.receiver), e0);
            }
        }

    }
}

