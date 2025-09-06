package com.iloen.melon.player.playlist.mixup;

import H0.e;
import O.F;
import androidx.lifecycle.f0;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableExtensionsKt;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.player.playlist.common.PlaylistUiExtensionsKt;
import com.iloen.melon.player.playlist.mixup.composables.SongListClickListener;
import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.interfaces.PlayableData;
import com.melon.ui.popup.context.more.b;
import e1.m;
import ie.H;
import je.p;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import od.a;
import we.n;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\n\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\u000B\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\r\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\fJ!\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001F\u0010\u0012\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\fJ\u001F\u0010\u0013\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\f¨\u0006\u0014"}, d2 = {"com/iloen/melon/player/playlist/mixup/MixUpPlaylistComposeFragment$getClickListener$1", "Lcom/iloen/melon/player/playlist/mixup/composables/SongListClickListener;", "", "itemId", "", "isSelected", "Lie/H;", "onSelect", "(Ljava/lang/String;Z)V", "Lcom/iloen/melon/playback/Playable;", "playable", "onClickSongLayer", "(Ljava/lang/String;Lcom/iloen/melon/playback/Playable;)V", "onShowAlbumInfo", "Lcom/melon/playlist/interfaces/PlayableData;", "playableData", "onMore", "(Ljava/lang/String;Lcom/melon/playlist/interfaces/PlayableData;)V", "onClickMoveUp", "onClickMoveDown", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MixUpPlaylistComposeFragment.getClickListener.1 implements SongListClickListener {
    public final F a;
    public final MixUpPlaylistComposeFragment b;

    public MixUpPlaylistComposeFragment.getClickListener.1(F f0, MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0) {
        this.a = f0;
        this.b = mixUpPlaylistComposeFragment0;
    }

    @Override  // com.iloen.melon.player.playlist.mixup.composables.SongListClickListener
    public void onClickMoveDown(String s, Playable playable0) {
        q.g(s, "itemId");
        q.g(playable0, "playable");
        Integer integer0 = PlaylistUiExtensionsKt.getPositionFromKey(this.a, s);
        if(integer0 != null) {
            MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0 = this.b;
            if(((int)integer0) < MixUpPlaylistComposeFragment.access$getViewModel(mixUpPlaylistComposeFragment0).getUiList().size() - 1) {
                int v = (int)integer0;
                MixUpPlaylistComposeFragment.access$getViewModel(mixUpPlaylistComposeFragment0).releaseSelectedAll();
                MixUpPlaylistComposeFragment.access$getViewModel(mixUpPlaylistComposeFragment0).moveFromDragging(((int)integer0), v + 1);
                MixUpPlaylistComposeFragment.access$getViewModel(mixUpPlaylistComposeFragment0).moveFromDragEnd(((int)integer0), v + 1);
            }
        }
    }

    @Override  // com.iloen.melon.player.playlist.mixup.composables.SongListClickListener
    public void onClickMoveUp(String s, Playable playable0) {
        q.g(s, "itemId");
        q.g(playable0, "playable");
        Integer integer0 = PlaylistUiExtensionsKt.getPositionFromKey(this.a, s);
        if(integer0 != null && ((int)integer0) > 0) {
            int v = (int)integer0;
            MixUpPlaylistComposeFragment.access$getViewModel(this.b).releaseSelectedAll();
            MixUpPlaylistComposeFragment.access$getViewModel(this.b).moveFromDragging(((int)integer0), v - 1);
            MixUpPlaylistComposeFragment.access$getViewModel(this.b).moveFromDragEnd(((int)integer0), v - 1);
        }
    }

    @Override  // com.iloen.melon.player.playlist.mixup.composables.SongListClickListener
    public void onClickSongLayer(String s, Playable playable0) {
        q.g(s, "itemId");
        q.g(playable0, "playable");
        Integer integer0 = PlaylistUiExtensionsKt.getPositionFromKey(this.a, s);
        MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0 = this.b;
        if(integer0 == null) {
            LogU.error$default(MixUpPlaylistComposeFragment.access$getLog$p(mixUpPlaylistComposeFragment0), "clickable(), Select - position is null", null, false, 6, null);
            return;
        }
        MixUpPlaylistComposeFragment.access$sendUserEvent(mixUpPlaylistComposeFragment0, new ClickSongItem(((int)integer0), playable0));
        a a0 = MixUpPlaylistComposeFragment.access$getViewModel(mixUpPlaylistComposeFragment0).getMixUpAreaOrNull(((int)integer0));
        MixUpPlaylistComposeFragment.access$getTiaraLogHelper(mixUpPlaylistComposeFragment0).logClickSong(m.s(((int)integer0)), playable0, a0);
    }

    @Override  // com.iloen.melon.player.playlist.mixup.composables.SongListClickListener
    public void onMore(String s, PlayableData playableData0) {
        q.g(s, "itemId");
        Integer integer0 = PlaylistUiExtensionsKt.getPositionFromKey(this.a, s);
        MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0 = this.b;
        if(integer0 == null) {
            LogU.error$default(MixUpPlaylistComposeFragment.access$getLog$p(mixUpPlaylistComposeFragment0), "onMore - position is null", null, false, 6, null);
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(f0.f(mixUpPlaylistComposeFragment0), null, null, new n(mixUpPlaylistComposeFragment0, integer0, null) {
            public final Integer B;
            public final PlayableData r;
            public final MixUpPlaylistComposeFragment w;

            {
                this.r = playableData0;
                this.w = mixUpPlaylistComposeFragment0;
                this.B = integer0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.getClickListener.1.onMore.1(this.r, this.w, this.B, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.getClickListener.1.onMore.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                d5.n.D(object0);
                PlayableData playableData0 = this.r;
                Playable playable0 = playableData0 == null ? null : playableData0.a;
                H h0 = H.a;
                MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0 = this.w;
                if(playable0 == null) {
                    LogU.error$default(MixUpPlaylistComposeFragment.access$getLog$p(mixUpPlaylistComposeFragment0), "clickable(), More - playable is null", null, false, 6, null);
                    return h0;
                }
                MixUpPlaylistComposeFragment.access$getViewModel(mixUpPlaylistComposeFragment0).releaseSelectedAll();
                Playable playable1 = PlayableExtensionsKt.copyAndUpdatedWhenLocal(playable0);
                playable1.setMenuid(MixUpPlaylistComposeFragment.access$getViewModel(mixUpPlaylistComposeFragment0).getMenuId());
                boolean z = MixUpPlaylistComposeFragment.access$getViewModel(mixUpPlaylistComposeFragment0).isDj();
                b b0 = new b(PlaylistId.MIX_UP, playable1, true, z, playableData0.m);
                if(!e.N(mixUpPlaylistComposeFragment0)) {
                    return h0;
                }
                mixUpPlaylistComposeFragment0.showContextMorePopup(mixUpPlaylistComposeFragment0, b0, new k(mixUpPlaylistComposeFragment0, playable1, b0, playable0));
                a a0 = MixUpPlaylistComposeFragment.access$getViewModel(mixUpPlaylistComposeFragment0).getMixUpAreaOrNull(((int)this.B));
                MixUpPlaylistComposeFragment.access$getTiaraLogHelper(mixUpPlaylistComposeFragment0).logClickMore(m.s(((int)this.B)), playable1, a0);
                return h0;

                @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
                final class com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.getClickListener.1.onMore.1.1.10 extends kotlin.jvm.internal.n implements we.k {
                    @Override  // we.k
                    public Object invoke(Object object0) {
                        this.invoke(((Pc.e)object0));
                        return H.a;
                    }

                    public final void invoke(Pc.e e0) {
                        q.g(e0, "p0");
                        MixUpPlaylistComposeFragment.access$sendUserEvent(((MixUpPlaylistComposeFragment)this.receiver), e0);
                    }
                }


                @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
                final class com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.getClickListener.1.onMore.1.1.1 extends kotlin.jvm.internal.n implements we.k {
                    @Override  // we.k
                    public Object invoke(Object object0) {
                        this.invoke(((Pc.e)object0));
                        return H.a;
                    }

                    public final void invoke(Pc.e e0) {
                        q.g(e0, "p0");
                        MixUpPlaylistComposeFragment.access$sendUserEvent(((MixUpPlaylistComposeFragment)this.receiver), e0);
                    }
                }


                @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
                final class com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.getClickListener.1.onMore.1.1.2 extends kotlin.jvm.internal.n implements we.k {
                    @Override  // we.k
                    public Object invoke(Object object0) {
                        this.invoke(((Pc.e)object0));
                        return H.a;
                    }

                    public final void invoke(Pc.e e0) {
                        q.g(e0, "p0");
                        MixUpPlaylistComposeFragment.access$sendUserEvent(((MixUpPlaylistComposeFragment)this.receiver), e0);
                    }
                }


                @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
                final class com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.getClickListener.1.onMore.1.1.3 extends kotlin.jvm.internal.n implements we.k {
                    @Override  // we.k
                    public Object invoke(Object object0) {
                        this.invoke(((Pc.e)object0));
                        return H.a;
                    }

                    public final void invoke(Pc.e e0) {
                        q.g(e0, "p0");
                        MixUpPlaylistComposeFragment.access$sendUserEvent(((MixUpPlaylistComposeFragment)this.receiver), e0);
                    }
                }


                @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
                final class com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.getClickListener.1.onMore.1.1.4 extends kotlin.jvm.internal.n implements we.k {
                    @Override  // we.k
                    public Object invoke(Object object0) {
                        this.invoke(((Pc.e)object0));
                        return H.a;
                    }

                    public final void invoke(Pc.e e0) {
                        q.g(e0, "p0");
                        MixUpPlaylistComposeFragment.access$sendUserEvent(((MixUpPlaylistComposeFragment)this.receiver), e0);
                    }
                }


                @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
                final class com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.getClickListener.1.onMore.1.1.5 extends kotlin.jvm.internal.n implements we.k {
                    @Override  // we.k
                    public Object invoke(Object object0) {
                        this.invoke(((Pc.e)object0));
                        return H.a;
                    }

                    public final void invoke(Pc.e e0) {
                        q.g(e0, "p0");
                        MixUpPlaylistComposeFragment.access$sendUserEvent(((MixUpPlaylistComposeFragment)this.receiver), e0);
                    }
                }


                @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
                final class com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.getClickListener.1.onMore.1.1.6 extends kotlin.jvm.internal.n implements we.k {
                    @Override  // we.k
                    public Object invoke(Object object0) {
                        this.invoke(((Pc.e)object0));
                        return H.a;
                    }

                    public final void invoke(Pc.e e0) {
                        q.g(e0, "p0");
                        MixUpPlaylistComposeFragment.access$sendUserEvent(((MixUpPlaylistComposeFragment)this.receiver), e0);
                    }
                }


                @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
                final class com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.getClickListener.1.onMore.1.1.7 extends kotlin.jvm.internal.n implements we.k {
                    @Override  // we.k
                    public Object invoke(Object object0) {
                        this.invoke(((Pc.e)object0));
                        return H.a;
                    }

                    public final void invoke(Pc.e e0) {
                        q.g(e0, "p0");
                        MixUpPlaylistComposeFragment.access$sendUserEvent(((MixUpPlaylistComposeFragment)this.receiver), e0);
                    }
                }


                @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
                final class com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.getClickListener.1.onMore.1.1.8 extends kotlin.jvm.internal.n implements we.k {
                    @Override  // we.k
                    public Object invoke(Object object0) {
                        this.invoke(((Pc.e)object0));
                        return H.a;
                    }

                    public final void invoke(Pc.e e0) {
                        q.g(e0, "p0");
                        MixUpPlaylistComposeFragment.access$sendUserEvent(((MixUpPlaylistComposeFragment)this.receiver), e0);
                    }
                }


                @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
                final class com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.getClickListener.1.onMore.1.1.9 extends kotlin.jvm.internal.n implements we.k {
                    @Override  // we.k
                    public Object invoke(Object object0) {
                        this.invoke(((Pc.e)object0));
                        return H.a;
                    }

                    public final void invoke(Pc.e e0) {
                        q.g(e0, "p0");
                        MixUpPlaylistComposeFragment.access$sendUserEvent(((MixUpPlaylistComposeFragment)this.receiver), e0);
                    }
                }

            }
        }, 3, null);
    }

    @Override  // com.iloen.melon.player.playlist.mixup.composables.SongListClickListener
    public void onSelect(String s, boolean z) {
        q.g(s, "itemId");
        Integer integer0 = PlaylistUiExtensionsKt.getPositionFromKey(this.a, s);
        MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0 = this.b;
        if(integer0 == null) {
            LogU.error$default(MixUpPlaylistComposeFragment.access$getLog$p(mixUpPlaylistComposeFragment0), "clickable(), Select - position is null", null, false, 6, null);
            return;
        }
        MixUpPlaylistComposeFragment.access$getViewModel(mixUpPlaylistComposeFragment0).updateSelectedIndex(((int)integer0));
        MixUpUIItemData mixUpUIItemData0 = (MixUpUIItemData)p.n0(((int)integer0), MixUpPlaylistComposeFragment.access$getViewModel(mixUpPlaylistComposeFragment0).getUiList());
        if(mixUpUIItemData0 != null && mixUpUIItemData0 instanceof PlayableItem) {
            Playable playable0 = ((PlayableItem)mixUpUIItemData0).getPlayableData().a;
            String s1 = m.s(((int)integer0));
            a a0 = MixUpPlaylistComposeFragment.access$getViewModel(mixUpPlaylistComposeFragment0).getMixUpAreaOrNull(((int)integer0));
            if(z) {
                MixUpPlaylistComposeFragment.access$getTiaraLogHelper(mixUpPlaylistComposeFragment0).logCheckSong(s1, playable0, a0);
                return;
            }
            MixUpPlaylistComposeFragment.access$getTiaraLogHelper(mixUpPlaylistComposeFragment0).logUncheckSong(s1, playable0, a0);
        }
    }

    @Override  // com.iloen.melon.player.playlist.mixup.composables.SongListClickListener
    public void onShowAlbumInfo(String s, Playable playable0) {
        q.g(s, "itemId");
        q.g(playable0, "playable");
        Integer integer0 = PlaylistUiExtensionsKt.getPositionFromKey(this.a, s);
        MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0 = this.b;
        if(integer0 == null) {
            LogU.error$default(MixUpPlaylistComposeFragment.access$getLog$p(mixUpPlaylistComposeFragment0), "clickable(), Select - position is null", null, false, 6, null);
            return;
        }
        MixUpPlaylistComposeFragment.access$sendUserEvent(mixUpPlaylistComposeFragment0, new ClickAlbumThumbnail(((int)integer0), playable0));
        a a0 = MixUpPlaylistComposeFragment.access$getViewModel(mixUpPlaylistComposeFragment0).getMixUpAreaOrNull(((int)integer0));
        MixUpPlaylistComposeFragment.access$getTiaraLogHelper(mixUpPlaylistComposeFragment0).logClickAlbumImg(m.s(((int)integer0)), playable0, a0);
    }
}

