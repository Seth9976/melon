package com.iloen.melon.player.playlist.drawernew;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableExtensionsKt;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.interfaces.PlayableData;
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
@e(c = "com.iloen.melon.player.playlist.drawernew.DrawerSongFragment$showMorePopup$1", f = "DrawerSongFragment.kt", l = {}, m = "invokeSuspend")
final class DrawerSongFragment.showMorePopup.1 extends i implements n {
    public final boolean B;
    public final DrawerSongFragment r;
    public final int w;

    public DrawerSongFragment.showMorePopup.1(DrawerSongFragment drawerSongFragment0, int v, boolean z, Continuation continuation0) {
        this.r = drawerSongFragment0;
        this.w = v;
        this.B = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new DrawerSongFragment.showMorePopup.1(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((DrawerSongFragment.showMorePopup.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        DrawerSongFragment drawerSongFragment0 = this.r;
        PlayableData playableData0 = DrawerSongFragment.access$getViewModel(drawerSongFragment0).getPlayableDataForMorePopup(this.w);
        Playable playable0 = playableData0 == null ? null : playableData0.a;
        H h0 = H.a;
        if(playable0 == null) {
            LogU.error$default(DrawerSongFragment.access$getLog$p(drawerSongFragment0), "clickable(), More - playable is null", null, false, 6, null);
            return h0;
        }
        Playable playable1 = PlayableExtensionsKt.copyAndUpdatedWhenLocal(playable0);
        boolean z = DrawerSongFragment.access$getViewModel(drawerSongFragment0).isDj();
        b b0 = new b(PlaylistId.DRAWER, playable1, this.B, z, playableData0.m);
        if(!H0.e.N(drawerSongFragment0)) {
            return h0;
        }
        drawerSongFragment0.showContextMorePopup(drawerSongFragment0, b0, new m(drawerSongFragment0, playable1, this.w, b0, playable0));
        DrawerSongFragment.access$getTiaraLogHelper(drawerSongFragment0).sendMoreClickLog(playable0);
        return h0;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.showMorePopup.1.1.1 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                DrawerSongFragment.access$sendUserEvent(((DrawerSongFragment)this.receiver), e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.showMorePopup.1.1.2 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                DrawerSongFragment.access$sendUserEvent(((DrawerSongFragment)this.receiver), e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.showMorePopup.1.1.3 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                DrawerSongFragment.access$sendUserEvent(((DrawerSongFragment)this.receiver), e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.showMorePopup.1.1.4 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                DrawerSongFragment.access$sendUserEvent(((DrawerSongFragment)this.receiver), e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.showMorePopup.1.1.5 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                DrawerSongFragment.access$sendUserEvent(((DrawerSongFragment)this.receiver), e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.showMorePopup.1.1.6 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                DrawerSongFragment.access$sendUserEvent(((DrawerSongFragment)this.receiver), e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.showMorePopup.1.1.7 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                DrawerSongFragment.access$sendUserEvent(((DrawerSongFragment)this.receiver), e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.showMorePopup.1.1.8 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                DrawerSongFragment.access$sendUserEvent(((DrawerSongFragment)this.receiver), e0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.showMorePopup.1.1.9 extends kotlin.jvm.internal.n implements k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                DrawerSongFragment.access$sendUserEvent(((DrawerSongFragment)this.receiver), e0);
            }
        }

    }
}

