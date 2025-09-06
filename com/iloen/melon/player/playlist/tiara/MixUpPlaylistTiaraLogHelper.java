package com.iloen.melon.player.playlist.tiara;

import Bd.F;
import Bd.w;
import Cc.a3;
import Nb.i;
import Pc.d;
import com.iloen.melon.playback.Playable;
import com.kakao.tiara.track.Event;
import com.melon.ui.interfaces.StringProviderImpl;
import e1.m;
import java.util.LinkedHashMap;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import m9.b;
import m9.e;
import m9.f;
import m9.g;
import m9.h;
import m9.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.s;
import q8.c;
import we.a;
import we.k;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u00A5\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u000E\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u000E\u0010\n\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004\u0012\u000E\u0010\f\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\u0004\u0012\u0016\u0010\u000E\u001A\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\r\u0012\u0016\u0010\u000F\u001A\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\r\u0012\u000E\u0010\u0010\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u0016\u0010\u0011\u001A\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\r\u00A2\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001A\u00020\u0014\u00A2\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001A\u00020\u0014\u00A2\u0006\u0004\b\u0017\u0010\u0016J\r\u0010\u0018\u001A\u00020\u0014\u00A2\u0006\u0004\b\u0018\u0010\u0016J\'\u0010\u001D\u001A\u00020\u00142\u0006\u0010\u0019\u001A\u00020\u00072\u0006\u0010\u001A\u001A\u00020\u00052\b\u0010\u001C\u001A\u0004\u0018\u00010\u001B\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\'\u0010\u001F\u001A\u00020\u00142\u0006\u0010\u0019\u001A\u00020\u00072\u0006\u0010\u001A\u001A\u00020\u00052\b\u0010\u001C\u001A\u0004\u0018\u00010\u001B\u00A2\u0006\u0004\b\u001F\u0010\u001EJ\'\u0010 \u001A\u00020\u00142\u0006\u0010\u0019\u001A\u00020\u00072\u0006\u0010\u001A\u001A\u00020\u00052\b\u0010\u001C\u001A\u0004\u0018\u00010\u001B\u00A2\u0006\u0004\b \u0010\u001EJ\'\u0010!\u001A\u00020\u00142\u0006\u0010\u0019\u001A\u00020\u00072\u0006\u0010\u001A\u001A\u00020\u00052\b\u0010\u001C\u001A\u0004\u0018\u00010\u001B\u00A2\u0006\u0004\b!\u0010\u001EJ;\u0010\'\u001A\u00020\u00142\u0006\u0010\"\u001A\u00020\u00072\u0006\u0010#\u001A\u00020\u00072\b\u0010$\u001A\u0004\u0018\u00010\u00052\b\u0010%\u001A\u0004\u0018\u00010\u001B2\b\u0010&\u001A\u0004\u0018\u00010\u001B\u00A2\u0006\u0004\b\'\u0010(J\'\u0010)\u001A\u00020\u00142\u0006\u0010\u0019\u001A\u00020\u00072\u0006\u0010\u001A\u001A\u00020\u00052\b\u0010\u001C\u001A\u0004\u0018\u00010\u001B\u00A2\u0006\u0004\b)\u0010\u001EJ\r\u0010*\u001A\u00020\u0014\u00A2\u0006\u0004\b*\u0010\u0016J\r\u0010+\u001A\u00020\u0014\u00A2\u0006\u0004\b+\u0010\u0016J\u001F\u0010/\u001A\u00020\u00142\u0006\u0010-\u001A\u00020,2\b\u0010.\u001A\u0004\u0018\u00010\u0005\u00A2\u0006\u0004\b/\u00100J\u0017\u00101\u001A\u00020\u00142\b\u0010.\u001A\u0004\u0018\u00010\u0005\u00A2\u0006\u0004\b1\u00102J\u0017\u00103\u001A\u00020\u00142\b\u0010.\u001A\u0004\u0018\u00010\u0005\u00A2\u0006\u0004\b3\u00102J\u0017\u00104\u001A\u00020\u00142\b\u0010.\u001A\u0004\u0018\u00010\u0005\u00A2\u0006\u0004\b4\u00102J/\u00107\u001A\u00020\u00142\b\u0010.\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u00105\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u00106\u001A\u0004\u0018\u00010\u0007\u00A2\u0006\u0004\b7\u00108J\u0017\u00109\u001A\u00020\u00142\b\u0010.\u001A\u0004\u0018\u00010\u0005\u00A2\u0006\u0004\b9\u00102J\u0017\u0010:\u001A\u00020\u00142\b\u0010.\u001A\u0004\u0018\u00010\u0005\u00A2\u0006\u0004\b:\u00102J\u0017\u0010;\u001A\u00020\u00142\b\u0010.\u001A\u0004\u0018\u00010\u0005\u00A2\u0006\u0004\b;\u00102J\u0017\u0010<\u001A\u00020\u00142\b\u0010.\u001A\u0004\u0018\u00010\u0005\u00A2\u0006\u0004\b<\u00102J\u0017\u0010=\u001A\u00020\u00142\b\u0010.\u001A\u0004\u0018\u00010\u0005\u00A2\u0006\u0004\b=\u00102J\u0017\u0010>\u001A\u00020\u00142\b\u0010.\u001A\u0004\u0018\u00010\u0005\u00A2\u0006\u0004\b>\u00102J\u0017\u0010?\u001A\u00020\u00142\b\u0010.\u001A\u0004\u0018\u00010\u0005\u00A2\u0006\u0004\b?\u00102J\u0017\u0010@\u001A\u00020\u00142\b\u0010.\u001A\u0004\u0018\u00010\u0005\u00A2\u0006\u0004\b@\u00102J\u0017\u0010A\u001A\u00020\u00142\b\u0010.\u001A\u0004\u0018\u00010\u0005\u00A2\u0006\u0004\bA\u00102J\u001B\u0010D\u001A\u00020\u00142\f\u0010C\u001A\b\u0012\u0004\u0012\u00020\u00050B\u00A2\u0006\u0004\bD\u0010EJ\u001B\u0010F\u001A\u00020\u00142\f\u0010C\u001A\b\u0012\u0004\u0012\u00020\u00050B\u00A2\u0006\u0004\bF\u0010EJ\u001B\u0010G\u001A\u00020\u00142\f\u0010C\u001A\b\u0012\u0004\u0012\u00020\u00050B\u00A2\u0006\u0004\bG\u0010EJ\u001B\u0010H\u001A\u00020\u00142\f\u0010C\u001A\b\u0012\u0004\u0012\u00020\u00050B\u00A2\u0006\u0004\bH\u0010EJ\r\u0010I\u001A\u00020\u0014\u00A2\u0006\u0004\bI\u0010\u0016\u00A8\u0006J"}, d2 = {"Lcom/iloen/melon/player/playlist/tiara/MixUpPlaylistTiaraLogHelper;", "", "LPc/d;", "stringProvider", "Lkotlin/Function0;", "Lcom/iloen/melon/playback/Playable;", "getMixUpCurrentPlayable", "", "getMixUpCurrentOrdNum", "Lp8/s;", "getTiaraProperty", "Lpc/c;", "getMixUpInfo", "Lkotlin/Function1;", "getImpressionId", "getImpressionProvider", "getRecmdKey", "getRecmdOfferTimestamp", "<init>", "(LPc/d;Lwe/a;Lwe/a;Lwe/a;Lwe/a;Lwe/k;Lwe/k;Lwe/a;Lwe/k;)V", "Lie/H;", "logClickPlayOtherRecommendDjMalrang", "()V", "logClickOpenOtherRecommendDjMalrang", "logClickPutFromSourceTitle", "selectOrdNum", "selectPlayable", "Lod/a;", "area", "logCheckSong", "(Ljava/lang/String;Lcom/iloen/melon/playback/Playable;Lod/a;)V", "logUncheckSong", "logClickAlbumImg", "logClickSong", "fromOrdNum", "toOrdNum", "movePlayable", "fromArea", "toArea", "logMoveSongOrder", "(Ljava/lang/String;Ljava/lang/String;Lcom/iloen/melon/playback/Playable;Lod/a;Lod/a;)V", "logClickMore", "logClickSelectAll", "logClickUnselectAll", "", "isLike", "playable", "logClickLikeFromMorePopup", "(ZLcom/iloen/melon/playback/Playable;)V", "logClickShareFromMorePopup", "(Lcom/iloen/melon/playback/Playable;)V", "logClickSongInfoFromMorePopup", "logClickAlbumInfoFromMorePopup", "artistId", "artistName", "logClickArtistChannelFromMorePopup", "(Lcom/iloen/melon/playback/Playable;Ljava/lang/String;Ljava/lang/String;)V", "logClickMusicVideoFromMorePopup", "logClickMixUpFromMorePopup", "logClickKakaoProfileFromMorePopup", "logClickPutFromMorePopup", "logClickDownloadFromMorePopup", "logClickDeleteFromMorePopup", "logClickSimilarSongFromMorePopup", "logClickTikTokFromMorePopup", "logClickLyricDownloadFromMorePopup", "", "selectPlayables", "logClickPutFromToolbar", "(Ljava/util/List;)V", "logClickDownloadFromToolbar", "logClickRemoveFromToolbar", "logClickMixUpFromToolbar", "logClickPopularPlay", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MixUpPlaylistTiaraLogHelper {
    public static final int $stable = 8;
    public final d a;
    public final a b;
    public final a c;
    public final a d;
    public final a e;
    public final k f;
    public final k g;
    public final a h;
    public final k i;

    public MixUpPlaylistTiaraLogHelper(@NotNull d d0, @NotNull a a0, @NotNull a a1, @NotNull a a2, @NotNull a a3, @NotNull k k0, @NotNull k k1, @NotNull a a4, @NotNull k k2) {
        q.g(d0, "stringProvider");
        q.g(a0, "getMixUpCurrentPlayable");
        q.g(a1, "getMixUpCurrentOrdNum");
        q.g(a2, "getTiaraProperty");
        q.g(a3, "getMixUpInfo");
        q.g(k0, "getImpressionId");
        q.g(k1, "getImpressionProvider");
        q.g(a4, "getRecmdKey");
        q.g(k2, "getRecmdOfferTimestamp");
        super();
        this.a = d0;
        this.b = a0;
        this.c = a1;
        this.d = a2;
        this.e = a3;
        this.f = k0;
        this.g = k1;
        this.h = a4;
        this.i = k2;
    }

    public final String a(int v) {
        return ((StringProviderImpl)this.a).a(v);
    }

    public final void b(q8.d d0, Playable playable0) {
        String s1;
        s s0 = (s)this.d.invoke();
        d0.c(new w(s0, 11));
        LinkedHashMap linkedHashMap0 = (LinkedHashMap)d0.g;
        c c0 = new c();
        if(s0 == null) {
            s1 = "";
        }
        else {
            s1 = s0.c;
            if(s1 == null) {
                s1 = "";
            }
        }
        c0.a.put("menuid", s1);
        linkedHashMap0.putAll(c0.a);
        d0.k(new m9.c(1, playable0));
        this.e(d0, playable0);
        this.f(d0, playable0);
    }

    public final void c(q8.d d0) {
        s s0 = (s)this.d.invoke();
        d0.c(new w(s0, 12));
        d0.d(new w(s0, 13));
    }

    public final void d(q8.d d0, Playable playable0) {
        d0.d(new com.iloen.melon.player.playlist.mixup.composables.c(playable0, ((String)this.i.invoke(playable0)), this, 23));
    }

    public final void e(q8.d d0, Playable playable0) {
        d0.b(new m9.a(this, playable0, 3));
    }

    public final void f(q8.d d0, Playable playable0) {
        d0.d(new i(((String)this.h.invoke()), ((String)this.i.invoke(playable0)), 3));
    }

    public final void logCheckSong(@NotNull String s, @NotNull Playable playable0, @Nullable od.a a0) {
        q.g(s, "selectOrdNum");
        q.g(playable0, "selectPlayable");
        m.F(new h(this, playable0, ((pc.c)this.e.invoke()), s, a0, 1)).track();
    }

    public final void logClickAlbumImg(@NotNull String s, @NotNull Playable playable0, @Nullable od.a a0) {
        q.g(s, "selectOrdNum");
        q.g(playable0, "selectPlayable");
        m.F(new h(this, playable0, ((pc.c)this.e.invoke()), s, a0, 2)).track();
    }

    public final void logClickAlbumInfoFromMorePopup(@Nullable Playable playable0) {
        m.F(new m9.a(this, playable0, 9)).track();
    }

    public final void logClickArtistChannelFromMorePopup(@Nullable Playable playable0, @Nullable String s, @Nullable String s1) {
        m.F(new F(this, playable0, s, s1, 18)).track();
    }

    public static void logClickArtistChannelFromMorePopup$default(MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper0, Playable playable0, String s, String s1, int v, Object object0) {
        if((v & 2) != 0) {
            s = playable0 == null ? null : playable0.getArtistid();
        }
        if((v & 4) != 0) {
            s1 = playable0 == null ? null : "";
        }
        mixUpPlaylistTiaraLogHelper0.logClickArtistChannelFromMorePopup(playable0, s, s1);
    }

    public final void logClickDeleteFromMorePopup(@Nullable Playable playable0) {
        m.F(new m9.a(this, playable0, 11)).track();
    }

    public final void logClickDownloadFromMorePopup(@Nullable Playable playable0) {
        m.F(new m9.a(this, playable0, 6)).track();
    }

    public final void logClickDownloadFromToolbar(@NotNull List list0) {
        q.g(list0, "selectPlayables");
        Object object0 = this.e.invoke();
        m.F(new e(this, ((Playable)p.m0(list0)), ((pc.c)object0), list0, ((Playable)this.b.invoke()), 0)).track();
    }

    public final void logClickKakaoProfileFromMorePopup(@Nullable Playable playable0) {
        m.F(new m9.a(this, playable0, 7)).track();
    }

    public final void logClickLikeFromMorePopup(boolean z, @Nullable Playable playable0) {
        m.F(new Gd.F(this, playable0, z, 16)).track();
    }

    public final void logClickLyricDownloadFromMorePopup(@Nullable Playable playable0) {
        m.F(new m9.a(this, playable0, 4)).track();
    }

    public final void logClickMixUpFromMorePopup(@Nullable Playable playable0) {
        m.F(new m9.a(this, playable0, 10)).track();
    }

    public final void logClickMixUpFromToolbar(@NotNull List list0) {
        q.g(list0, "selectPlayables");
        m.F(new f(this, ((Playable)p.m0(list0)), ((Playable)this.b.invoke()), 0)).track();
    }

    public final void logClickMore(@NotNull String s, @NotNull Playable playable0, @Nullable od.a a0) {
        q.g(s, "selectOrdNum");
        q.g(playable0, "selectPlayable");
        Object object0 = this.b.invoke();
        m.F(new a3(this, playable0, ((pc.c)this.e.invoke()), ((Playable)object0), s, a0, 8)).track();
    }

    public final void logClickMusicVideoFromMorePopup(@Nullable Playable playable0) {
        m.F(new m9.a(this, playable0, 8)).track();
    }

    public final void logClickOpenOtherRecommendDjMalrang() {
        m.F(new m9.a(this, ((Playable)this.b.invoke()), 5)).track();
    }

    public final void logClickPlayOtherRecommendDjMalrang() {
        m.F(new m9.a(this, ((Playable)this.b.invoke()), 14)).track();
    }

    public final void logClickPopularPlay() {
        q8.d d0 = new q8.d();  // 初始化器: LQb/h;-><init>()V
        this.c(d0);
        d0.b(new b(this, 15));
        ((q8.h)d0.b).a = this.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        c c0 = new c();
        c0.b(new m9.d(6));
        ((LinkedHashMap)d0.g).putAll(c0.a);
        ((Event)d0.p()).track();
    }

    public final void logClickPutFromMorePopup(@Nullable Playable playable0) {
        m.F(new m9.a(this, playable0, 13)).track();
    }

    public final void logClickPutFromSourceTitle() {
        m.F(new l(0, this, ((pc.c)this.e.invoke()))).track();
    }

    public final void logClickPutFromToolbar(@NotNull List list0) {
        q.g(list0, "selectPlayables");
        Object object0 = this.e.invoke();
        m.F(new e(this, ((Playable)p.m0(list0)), ((pc.c)object0), list0, ((Playable)this.b.invoke()), 2)).track();
    }

    public final void logClickRemoveFromToolbar(@NotNull List list0) {
        q.g(list0, "selectPlayables");
        m.F(new e(this, ((pc.c)this.e.invoke()), ((Playable)p.m0(list0)), list0, ((Playable)this.b.invoke()))).track();
    }

    public final void logClickSelectAll() {
        pc.c c0 = (pc.c)this.e.invoke();
        m.F(new g(this, ((Playable)this.b.invoke()), c0, 0)).track();
    }

    public final void logClickShareFromMorePopup(@Nullable Playable playable0) {
        m.F(new m9.a(this, playable0, 1)).track();
    }

    public final void logClickSimilarSongFromMorePopup(@Nullable Playable playable0) {
        m.F(new m9.a(this, playable0, 12)).track();
    }

    public final void logClickSong(@NotNull String s, @NotNull Playable playable0, @Nullable od.a a0) {
        q.g(s, "selectOrdNum");
        q.g(playable0, "selectPlayable");
        m.F(new h(this, playable0, ((pc.c)this.e.invoke()), s, a0, 0)).track();
    }

    public final void logClickSongInfoFromMorePopup(@Nullable Playable playable0) {
        m.F(new m9.a(this, playable0, 2)).track();
    }

    public final void logClickTikTokFromMorePopup(@Nullable Playable playable0) {
        m.F(new m9.a(this, playable0, 0)).track();
    }

    public final void logClickUnselectAll() {
        pc.c c0 = (pc.c)this.e.invoke();
        m.F(new g(this, ((Playable)this.b.invoke()), c0, 1)).track();
    }

    public final void logMoveSongOrder(@NotNull String s, @NotNull String s1, @Nullable Playable playable0, @Nullable od.a a0, @Nullable od.a a1) {
        q.g(s, "fromOrdNum");
        q.g(s1, "toOrdNum");
        m.F(new m9.i(this, playable0, ((pc.c)this.e.invoke()), ((Playable)this.b.invoke()), s, s1, a1, a0)).track();
    }

    public final void logUncheckSong(@NotNull String s, @NotNull Playable playable0, @Nullable od.a a0) {
        q.g(s, "selectOrdNum");
        q.g(playable0, "selectPlayable");
        m.F(new h(this, playable0, ((pc.c)this.e.invoke()), s, a0, 3)).track();
    }
}

