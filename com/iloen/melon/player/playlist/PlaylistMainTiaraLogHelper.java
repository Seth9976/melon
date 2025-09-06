package com.iloen.melon.player.playlist;

import Ac.m2;
import Vb.p0;
import android.content.Context;
import com.iloen.melon.playback.Playable;
import com.kakao.tiara.track.Event;
import d5.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import oc.H;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.s;
import q8.d;
import q8.h;
import we.a;
import we.k;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0007\u0018\u00002\u00020\u0001B½\u0001\u0012\u000E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\u000E\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u0012\u0016\u0010\t\u001A\u0012\u0012\u000E\u0012\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u00070\u0002\u0012\u000E\u0010\u000B\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0002\u0012\u0014\u0010\u000E\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\n0\f\u0012\u0016\u0010\u0010\u001A\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000F0\f\u0012\u0016\u0010\u0011\u001A\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000F0\f\u0012\u000E\u0010\u0012\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000F0\u0002\u0012\u0016\u0010\u0013\u001A\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000F0\f¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0019\u001A\u00020\u00182\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\r2\u0006\u0010\u0017\u001A\u00020\u000F¢\u0006\u0004\b\u0019\u0010\u001AJ\r\u0010\u001B\u001A\u00020\u0018¢\u0006\u0004\b\u001B\u0010\u001CJ\r\u0010\u001D\u001A\u00020\u0018¢\u0006\u0004\b\u001D\u0010\u001CJ\r\u0010\u001E\u001A\u00020\u0018¢\u0006\u0004\b\u001E\u0010\u001CJ\r\u0010\u001F\u001A\u00020\u0018¢\u0006\u0004\b\u001F\u0010\u001CJ\r\u0010 \u001A\u00020\u0018¢\u0006\u0004\b \u0010\u001CJ\r\u0010!\u001A\u00020\u0018¢\u0006\u0004\b!\u0010\u001CJ\r\u0010\"\u001A\u00020\u0018¢\u0006\u0004\b\"\u0010\u001CJ\r\u0010#\u001A\u00020\u0018¢\u0006\u0004\b#\u0010\u001CJ\r\u0010$\u001A\u00020\u0018¢\u0006\u0004\b$\u0010\u001CJ\r\u0010%\u001A\u00020\u0018¢\u0006\u0004\b%\u0010\u001C¨\u0006&"}, d2 = {"Lcom/iloen/melon/player/playlist/PlaylistMainTiaraLogHelper;", "", "Lkotlin/Function0;", "Landroid/content/Context;", "getContext", "Lcom/iloen/melon/playback/Playable;", "getCurrentPlayable", "Loc/H;", "Loc/Q;", "getCurrentPlaylist", "Lp8/s;", "getFocusTabTiaraProperty", "Lkotlin/Function1;", "Lcom/iloen/melon/player/playlist/PlaylistTab;", "getTabTiaraProperty", "", "getImpressionId", "getImpressionProvider", "getRecmdKey", "getRecmdOfferTimestamp", "<init>", "(Lwe/a;Lwe/a;Lwe/a;Lwe/a;Lwe/k;Lwe/k;Lwe/k;Lwe/a;Lwe/k;)V", "beforePage", "copy", "Lie/H;", "logClickTab", "(Lcom/iloen/melon/player/playlist/PlaylistTab;Ljava/lang/String;)V", "logClickSearch", "()V", "logClickAddPlaylist", "logClickSetting", "logClickPrev", "logLongClickPrev", "logClickPlay", "logClickPause", "logClickNext", "logLongClickNext", "logClickGoToPlayer", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistMainTiaraLogHelper {
    public static final int $stable;
    public final a a;
    public final a b;
    public final a c;
    public final a d;
    public final k e;
    public final k f;
    public final k g;
    public final a h;
    public final k i;

    public PlaylistMainTiaraLogHelper(@NotNull a a0, @NotNull a a1, @NotNull a a2, @NotNull a a3, @NotNull k k0, @NotNull k k1, @NotNull k k2, @NotNull a a4, @NotNull k k3) {
        q.g(a0, "getContext");
        q.g(a1, "getCurrentPlayable");
        q.g(a2, "getCurrentPlaylist");
        q.g(a3, "getFocusTabTiaraProperty");
        q.g(k0, "getTabTiaraProperty");
        q.g(k1, "getImpressionId");
        q.g(k2, "getImpressionProvider");
        q.g(a4, "getRecmdKey");
        q.g(k3, "getRecmdOfferTimestamp");
        super();
        this.a = a0;
        this.b = a1;
        this.c = a2;
        this.d = a3;
        this.e = k0;
        this.f = k1;
        this.g = k2;
        this.h = a4;
        this.i = k3;
    }

    public final String a(int v) {
        Context context0 = (Context)this.a.invoke();
        if(context0 != null) {
            String s = context0.getString(v);
            return s == null ? "" : s;
        }
        return "";
    }

    public static void b(PlaylistMainTiaraLogHelper playlistMainTiaraLogHelper0, d d0) {
        Playable playable0 = (Playable)playlistMainTiaraLogHelper0.b.invoke();
        H h0 = (H)playlistMainTiaraLogHelper0.c.invoke();
        playlistMainTiaraLogHelper0.getClass();
        if(h0 instanceof pc.d && t.k(((pc.d)h0))) {
            d0.c(new l(playlistMainTiaraLogHelper0, 1));
            d0.b(new p0(11, playlistMainTiaraLogHelper0, playable0));
            new l(playlistMainTiaraLogHelper0, 2).invoke(((h)d0.b));
            d0.k(new m(1, playable0));
            d0.e(new m(2, playable0));
            d0.d(new m2(playlistMainTiaraLogHelper0, playable0, ((pc.d)h0), 27));
            return;
        }
        d0.c(new l(playlistMainTiaraLogHelper0, 3));
        d0.b(new l(playlistMainTiaraLogHelper0, 4));
        new l(playlistMainTiaraLogHelper0, 5).invoke(((h)d0.b));
        d0.k(new m(3, playable0));
        d0.e(new m(0, playable0));
        d0.d(new com.iloen.melon.player.playlist.a(h0, 2));
    }

    public final void logClickAddPlaylist() {
        String s1;
        s s0 = (s)this.d.invoke();
        d d0 = new d();  // 初始化器: LQb/h;-><init>()V
        if(s0 == null) {
            s1 = "";
        }
        else {
            s1 = s0.c;
            if(s1 == null) {
                s1 = "";
            }
        }
        d0.a = s1;
        d0.c(new n(s0, 3));
        new l(this, 9).invoke(((h)d0.b));
        d0.b(new l(this, 0));
        ((Event)d0.p()).track();
    }

    public final void logClickGoToPlayer() {
        d d0 = new d();  // 初始化器: LQb/h;-><init>()V
        PlaylistMainTiaraLogHelper.b(this, d0);
        q8.a a0 = (q8.a)d0.d;
        if(a0 == null) {
            q8.a a1 = new q8.a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
            a1.g = this.a(0x7F130DA1);  // string:tiara_click_copy_song_player "곡플레이어"
            d0.d = a1;
        }
        else {
            a0.g = this.a(0x7F130DA1);  // string:tiara_click_copy_song_player "곡플레이어"
        }
        ((Event)d0.p()).track();
    }

    public final void logClickNext() {
        d d0 = new d();  // 初始化器: LQb/h;-><init>()V
        PlaylistMainTiaraLogHelper.b(this, d0);
        q8.a a0 = (q8.a)d0.d;
        if(a0 == null) {
            q8.a a1 = new q8.a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
            a1.g = this.a(0x7F130D74);  // string:tiara_click_copy_player_next "다음"
            d0.d = a1;
        }
        else {
            a0.g = this.a(0x7F130D74);  // string:tiara_click_copy_player_next "다음"
        }
        ((Event)d0.p()).track();
    }

    public final void logClickPause() {
        d d0 = new d();  // 初始化器: LQb/h;-><init>()V
        PlaylistMainTiaraLogHelper.b(this, d0);
        q8.a a0 = (q8.a)d0.d;
        if(a0 == null) {
            q8.a a1 = new q8.a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
            a1.g = this.a(0x7F130D76);  // string:tiara_click_copy_player_pause "멈춤"
            d0.d = a1;
        }
        else {
            a0.g = this.a(0x7F130D76);  // string:tiara_click_copy_player_pause "멈춤"
        }
        ((Event)d0.p()).track();
    }

    public final void logClickPlay() {
        d d0 = new d();  // 初始化器: LQb/h;-><init>()V
        PlaylistMainTiaraLogHelper.b(this, d0);
        q8.a a0 = (q8.a)d0.d;
        if(a0 == null) {
            q8.a a1 = new q8.a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
            a1.g = this.a(0x7F130D77);  // string:tiara_click_copy_player_play "재생"
            d0.d = a1;
        }
        else {
            a0.g = this.a(0x7F130D77);  // string:tiara_click_copy_player_play "재생"
        }
        ((Event)d0.p()).track();
    }

    public final void logClickPrev() {
        d d0 = new d();  // 初始化器: LQb/h;-><init>()V
        PlaylistMainTiaraLogHelper.b(this, d0);
        q8.a a0 = (q8.a)d0.d;
        if(a0 == null) {
            q8.a a1 = new q8.a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
            a1.g = this.a(0x7F130D78);  // string:tiara_click_copy_player_prev "이전"
            d0.d = a1;
        }
        else {
            a0.g = this.a(0x7F130D78);  // string:tiara_click_copy_player_prev "이전"
        }
        ((Event)d0.p()).track();
    }

    public final void logClickSearch() {
        String s1;
        s s0 = (s)this.d.invoke();
        d d0 = new d();  // 初始化器: LQb/h;-><init>()V
        if(s0 == null) {
            s1 = "";
        }
        else {
            s1 = s0.c;
            if(s1 == null) {
                s1 = "";
            }
        }
        d0.a = s1;
        d0.c(new n(s0, 0));
        new l(this, 6).invoke(((h)d0.b));
        d0.b(new l(this, 7));
        ((Event)d0.p()).track();
    }

    public final void logClickSetting() {
        d d0 = new d();  // 初始化器: LQb/h;-><init>()V
        PlaylistMainTiaraLogHelper.b(this, d0);
        q8.a a0 = (q8.a)d0.d;
        if(a0 == null) {
            q8.a a1 = new q8.a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
            a1.g = this.a(0x7F130E57);  // string:tiara_common_section_setting "설정"
            d0.d = a1;
        }
        else {
            a0.g = this.a(0x7F130E57);  // string:tiara_common_section_setting "설정"
        }
        ((Event)d0.p()).track();
    }

    public final void logClickTab(@Nullable PlaylistTab playlistTab0, @NotNull String s) {
        q.g(s, "copy");
        e1.m.F(new m2((playlistTab0 == null ? ((s)this.d.invoke()) : ((s)this.e.invoke(playlistTab0))), this, s, 26)).track();
    }

    public static void logClickTab$default(PlaylistMainTiaraLogHelper playlistMainTiaraLogHelper0, PlaylistTab playlistTab0, String s, int v, Object object0) {
        if((v & 1) != 0) {
            playlistTab0 = null;
        }
        playlistMainTiaraLogHelper0.logClickTab(playlistTab0, s);
    }

    public final void logLongClickNext() {
        d d0 = new d();  // 初始化器: LQb/h;-><init>()V
        PlaylistMainTiaraLogHelper.b(this, d0);
        q8.a a0 = (q8.a)d0.d;
        if(a0 == null) {
            q8.a a1 = new q8.a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
            a1.g = this.a(0x7F130D2B);  // string:tiara_click_copy_fast_forward "빨리감기"
            d0.d = a1;
        }
        else {
            a0.g = this.a(0x7F130D2B);  // string:tiara_click_copy_fast_forward "빨리감기"
        }
        ((Event)d0.p()).track();
    }

    public final void logLongClickPrev() {
        d d0 = new d();  // 初始化器: LQb/h;-><init>()V
        PlaylistMainTiaraLogHelper.b(this, d0);
        q8.a a0 = (q8.a)d0.d;
        if(a0 == null) {
            q8.a a1 = new q8.a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
            a1.g = this.a(0x7F130D8F);  // string:tiara_click_copy_rewind "빠른되감기"
            d0.d = a1;
        }
        else {
            a0.g = this.a(0x7F130D8F);  // string:tiara_click_copy_rewind "빠른되감기"
        }
        ((Event)d0.p()).track();
    }
}

