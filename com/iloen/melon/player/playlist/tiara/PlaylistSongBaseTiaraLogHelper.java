package com.iloen.melon.player.playlist.tiara;

import A7.d;
import U4.x;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.playback.Playable;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.interfaces.StringProviderImpl;
import je.n;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import p8.g;
import p8.s;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001E\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\'\u0018\u00002\u00020\u0001:\u0001GB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0004\u00A2\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001A\u00020\t\u00A2\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH&\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0015\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\u000F\u00A2\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001A\u00020\t\u00A2\u0006\u0004\b\u0013\u0010\u000BJ\u001F\u0010\u0018\u001A\u00020\t2\u0006\u0010\u0015\u001A\u00020\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u001F\u0010\u001A\u001A\u00020\t2\u0006\u0010\u0015\u001A\u00020\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016\u00A2\u0006\u0004\b\u001A\u0010\u0019J\u001F\u0010\u001B\u001A\u00020\t2\u0006\u0010\u0015\u001A\u00020\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016\u00A2\u0006\u0004\b\u001B\u0010\u0019J\u0015\u0010\u001C\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u001F\u0010\u001F\u001A\u00020\t2\u0006\u0010\u001E\u001A\u00020\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016\u00A2\u0006\u0004\b\u001F\u0010\u0019J\r\u0010 \u001A\u00020\t\u00A2\u0006\u0004\b \u0010\u000BJ\u0015\u0010\"\u001A\u00020\t2\u0006\u0010!\u001A\u00020\f\u00A2\u0006\u0004\b\"\u0010#J\u001D\u0010%\u001A\u00020\t2\u0006\u0010$\u001A\u00020\u000F2\u0006\u0010\u0017\u001A\u00020\u0016\u00A2\u0006\u0004\b%\u0010&J\u0015\u0010\'\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u0016\u00A2\u0006\u0004\b\'\u0010\u001DJ\u0015\u0010(\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u0016\u00A2\u0006\u0004\b(\u0010\u001DJ\u0015\u0010)\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u0016\u00A2\u0006\u0004\b)\u0010\u001DJ\u0015\u0010*\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u0016\u00A2\u0006\u0004\b*\u0010\u001DJ\u0015\u0010+\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u0016\u00A2\u0006\u0004\b+\u0010\u001DJ\u0015\u0010,\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u0016\u00A2\u0006\u0004\b,\u0010\u001DJ\u0015\u0010-\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u0016\u00A2\u0006\u0004\b-\u0010\u001DJ\u0015\u0010.\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u0016\u00A2\u0006\u0004\b.\u0010\u001DJ\u0015\u0010/\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u0016\u00A2\u0006\u0004\b/\u0010\u001DJ\u0015\u00100\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u0016\u00A2\u0006\u0004\b0\u0010\u001DJ\u0015\u00101\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u0016\u00A2\u0006\u0004\b1\u0010\u001DJ\u0015\u00102\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u0016\u00A2\u0006\u0004\b2\u0010\u001DJ\u0015\u00103\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u0016\u00A2\u0006\u0004\b3\u0010\u001DJ!\u00107\u001A\u00020\t2\u0006\u00104\u001A\u00020\u00142\n\b\u0002\u00106\u001A\u0004\u0018\u000105\u00A2\u0006\u0004\b7\u00108J\r\u00109\u001A\u00020\t\u00A2\u0006\u0004\b9\u0010\u000BJ\r\u0010:\u001A\u00020\t\u00A2\u0006\u0004\b:\u0010\u000BJ\r\u0010;\u001A\u00020\t\u00A2\u0006\u0004\b;\u0010\u000BJ\u0017\u0010=\u001A\u00020\f2\u0006\u0010<\u001A\u00020\u0014H\u0004\u00A2\u0006\u0004\b=\u0010>R$\u0010F\u001A\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b@\u0010A\u001A\u0004\bB\u0010C\"\u0004\bD\u0010E\u00A8\u0006H"}, d2 = {"Lcom/iloen/melon/player/playlist/tiara/PlaylistSongBaseTiaraLogHelper;", "", "LPc/d;", "stringProvider", "<init>", "(LPc/d;)V", "Lp8/f;", "getTiaraEventBuilder", "()Lp8/f;", "Lie/H;", "sendAllSelectFilterClickLog", "()V", "", "getFilterClickLayer1", "()Ljava/lang/String;", "", "isOn", "sendOfflinePlayClickLog", "(Z)V", "sendOrderClickLog", "", "position", "Lcom/iloen/melon/playback/Playable;", "playable", "sendCheckBoxClickLog", "(ILcom/iloen/melon/playback/Playable;)V", "sendAlbumImgClickLog", "sendPlayClickLog", "sendMoreClickLog", "(Lcom/iloen/melon/playback/Playable;)V", "fromPosition", "sendMoveClickLog", "sendSectionSelectClickLog", "copy", "sendOrderPopupClickLog", "(Ljava/lang/String;)V", "isLike", "sendInfoLikeClickLog", "(ZLcom/iloen/melon/playback/Playable;)V", "sendInfoShareClickLog", "sendSongInfoClickLog", "sendAlbumInfoClickLog", "sendArtistChannelClickLog", "sendMusicVideoClickLog", "sendPlayMixUpClickLog", "sendKakaoProfileClickLog", "sendPutClickLog", "sendDownloadClickLog", "sendDeleteClickLog", "sendSimilarSongClickLog", "sendTikTokClickLog", "sendLyricDownloadClickLog", "itemId", "Lcom/iloen/melon/player/playlist/tiara/PlaylistSongBaseTiaraLogHelper$TiaraMixUpEventMeta;", "mixUpEventMeta", "sendToolbarClickEvent", "(ILcom/iloen/melon/player/playlist/tiara/PlaylistSongBaseTiaraLogHelper$TiaraMixUpEventMeta;)V", "sendOpenMelonChartClickLog", "sendTakeNPClickLog", "sendMelonTotalSearchClickLog", "resId", "getString", "(I)Ljava/lang/String;", "Lp8/s;", "b", "Lp8/s;", "getTiaraProperty", "()Lp8/s;", "setTiaraProperty", "(Lp8/s;)V", "tiaraProperty", "TiaraMixUpEventMeta", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class PlaylistSongBaseTiaraLogHelper {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0010\u0010\u000B\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000B\u0010\tJ.\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000E\u0010\tJ\u0010\u0010\u0010\u001A\u00020\u000FHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001A\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\tR\u0017\u0010\u0004\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001A\u0004\b\u001A\u0010\tR\u0017\u0010\u0005\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001B\u0010\u0017\u001A\u0004\b\u001C\u0010\t¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/player/playlist/tiara/PlaylistSongBaseTiaraLogHelper$TiaraMixUpEventMeta;", "", "", "metaId", "metaType", "metaName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/iloen/melon/player/playlist/tiara/PlaylistSongBaseTiaraLogHelper$TiaraMixUpEventMeta;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getMetaId", "b", "getMetaType", "c", "getMetaName", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class TiaraMixUpEventMeta {
        public static final int $stable;
        public final String a;
        public final String b;
        public final String c;

        public TiaraMixUpEventMeta(@NotNull String s, @NotNull String s1, @NotNull String s2) {
            q.g(s, "metaId");
            q.g(s1, "metaType");
            q.g(s2, "metaName");
            super();
            this.a = s;
            this.b = s1;
            this.c = s2;
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final String component3() {
            return this.c;
        }

        @NotNull
        public final TiaraMixUpEventMeta copy(@NotNull String s, @NotNull String s1, @NotNull String s2) {
            q.g(s, "metaId");
            q.g(s1, "metaType");
            q.g(s2, "metaName");
            return new TiaraMixUpEventMeta(s, s1, s2);
        }

        public static TiaraMixUpEventMeta copy$default(TiaraMixUpEventMeta playlistSongBaseTiaraLogHelper$TiaraMixUpEventMeta0, String s, String s1, String s2, int v, Object object0) {
            if((v & 1) != 0) {
                s = playlistSongBaseTiaraLogHelper$TiaraMixUpEventMeta0.a;
            }
            if((v & 2) != 0) {
                s1 = playlistSongBaseTiaraLogHelper$TiaraMixUpEventMeta0.b;
            }
            if((v & 4) != 0) {
                s2 = playlistSongBaseTiaraLogHelper$TiaraMixUpEventMeta0.c;
            }
            return playlistSongBaseTiaraLogHelper$TiaraMixUpEventMeta0.copy(s, s1, s2);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof TiaraMixUpEventMeta)) {
                return false;
            }
            if(!q.b(this.a, ((TiaraMixUpEventMeta)object0).a)) {
                return false;
            }
            return q.b(this.b, ((TiaraMixUpEventMeta)object0).b) ? q.b(this.c, ((TiaraMixUpEventMeta)object0).c) : false;
        }

        @NotNull
        public final String getMetaId() {
            return this.a;
        }

        @NotNull
        public final String getMetaName() {
            return this.c;
        }

        @NotNull
        public final String getMetaType() {
            return this.b;
        }

        @Override
        public int hashCode() {
            return this.c.hashCode() + x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
        }

        @Override
        @NotNull
        public String toString() {
            return x.m(d.o("TiaraMixUpEventMeta(metaId=", this.a, ", metaType=", this.b, ", metaName="), this.c, ")");
        }
    }

    public static final int $stable = 8;
    public final Pc.d a;
    public s b;

    public PlaylistSongBaseTiaraLogHelper(@NotNull Pc.d d0) {
        q.g(d0, "stringProvider");
        super();
        this.a = d0;
    }

    @NotNull
    public abstract String getFilterClickLayer1();

    @NotNull
    public final String getString(int v) {
        return ((StringProviderImpl)this.a).a(v);
    }

    @Nullable
    public final f getTiaraEventBuilder() {
        s s0 = this.b;
        if(s0 != null) {
            f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
            f0.b = s0.a;
            f0.c = s0.b;
            f0.I = s0.c;
            return f0;
        }
        return null;
    }

    @Nullable
    public final s getTiaraProperty() {
        return this.b;
    }

    public final void sendAlbumImgClickLog(int v, @Nullable Playable playable0) {
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.d = ActionKind.ClickContent;
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getFilterClickLayer1();
            f0.c(v + 1);
            String s = null;
            f0.e = playable0 == null ? null : "";
            f0.f = this.getString(0x7F130EF0);  // string:tiara_meta_type_album "앨범"
            if(playable0 != null) {
                s = "";
            }
            f0.g = s;
            f0.a().track();
        }
    }

    public final void sendAlbumInfoClickLog(@NotNull Playable playable0) {
        q.g(playable0, "playable");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.d = ActionKind.ClickContent;
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getString(0x7F130FA2);  // string:tiara_playlist_more_info_popup "더보기 팝업"
            f0.o = "";
            f0.p = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            f0.q = "";
            f0.e = "";
            f0.f = this.getString(0x7F130EF0);  // string:tiara_meta_type_album "앨범"
            f0.g = "";
            f0.F = this.getString(0x7F130CF7);  // string:tiara_click_copy_album_info "앨범정보"
            f0.a().track();
        }
    }

    public final void sendAllSelectFilterClickLog() {
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getFilterClickLayer1();
            f0.F = this.getString(0x7F130D93);  // string:tiara_click_copy_select_all "전체선택"
            f0.a().track();
        }
    }

    public final void sendArtistChannelClickLog(@NotNull Playable playable0) {
        q.g(playable0, "playable");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.d = ActionKind.ClickContent;
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getString(0x7F130FA2);  // string:tiara_playlist_more_info_popup "더보기 팝업"
            f0.o = "";
            f0.p = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            f0.q = "";
            f0.e = playable0.getArtistid();
            f0.f = this.getString(0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
            f0.g = "";
            f0.F = this.getString(0x7F130F9E);  // string:tiara_playlist_artist_channel "아티스트 채널"
            f0.a().track();
        }
    }

    public final void sendCheckBoxClickLog(int v, @Nullable Playable playable0) {
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.d = ActionKind.ClickContent;
            f0.a = this.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
            f0.y = this.getFilterClickLayer1();
            f0.c(v + 1);
            String s = null;
            f0.e = playable0 == null ? null : "";
            f0.f = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            if(playable0 != null) {
                s = "";
            }
            f0.g = s;
            f0.a().track();
        }
    }

    public final void sendDeleteClickLog(@NotNull Playable playable0) {
        q.g(playable0, "playable");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.d = ActionKind.ClickContent;
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getString(0x7F130FA2);  // string:tiara_playlist_more_info_popup "더보기 팝업"
            f0.o = "";
            f0.p = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            f0.q = "";
            f0.F = this.getString(0x7F130E5B);  // string:tiara_delete "삭제"
            f0.e = "";
            f0.f = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            f0.g = "";
            f0.a().track();
        }
    }

    public final void sendDownloadClickLog(@NotNull Playable playable0) {
        q.g(playable0, "playable");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.d = ActionKind.ClickContent;
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getString(0x7F130FA2);  // string:tiara_playlist_more_info_popup "더보기 팝업"
            f0.o = "";
            f0.p = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            f0.q = "";
            f0.F = this.getString(0x7F130DC5);  // string:tiara_common_action_name_download "다운로드"
            f0.e = "";
            f0.f = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            f0.g = "";
            f0.a().track();
        }
    }

    public final void sendInfoLikeClickLog(boolean z, @NotNull Playable playable0) {
        q.g(playable0, "playable");
        String s = z ? this.getString(0x7F130FCD) : this.getString(0x7F130FCC);  // string:tiara_props_like "like"
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.d = ActionKind.Like;
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getString(0x7F130FA2);  // string:tiara_playlist_more_info_popup "더보기 팝업"
            f0.U = s;
            f0.o = "";
            f0.p = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            f0.q = "";
            f0.e = "";
            f0.f = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            f0.g = "";
            f0.a().track();
        }
    }

    public final void sendInfoShareClickLog(@NotNull Playable playable0) {
        q.g(playable0, "playable");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.d = ActionKind.Share;
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getString(0x7F130FA2);  // string:tiara_playlist_more_info_popup "더보기 팝업"
            f0.o = "";
            f0.p = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            f0.q = "";
            f0.e = "";
            f0.f = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            f0.g = "";
            f0.a().track();
        }
    }

    public final void sendKakaoProfileClickLog(@NotNull Playable playable0) {
        q.g(playable0, "playable");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.d = ActionKind.ClickContent;
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getString(0x7F130FA2);  // string:tiara_playlist_more_info_popup "더보기 팝업"
            f0.o = "";
            f0.p = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            f0.q = "";
            f0.F = this.getString(0x7F130D97);  // string:tiara_click_copy_set_kakao_talk_profile_music "카카오톡 프로필 뮤직 설정"
            f0.a().track();
        }
    }

    public final void sendLyricDownloadClickLog(@NotNull Playable playable0) {
        q.g(playable0, "playable");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.d = ActionKind.ClickContent;
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getString(0x7F130FA2);  // string:tiara_playlist_more_info_popup "더보기 팝업"
            f0.o = "";
            f0.p = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            f0.q = "";
            f0.F = this.getString(0x7F130ED1);  // string:tiara_lyric_download "가사 다운로드"
            f0.a().track();
        }
    }

    public final void sendMelonTotalSearchClickLog() {
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getFilterClickLayer1();
            f0.F = this.getString(0x7F130FAD);  // string:tiara_playlist_total_search_copy "멜론 통합 검색"
            f0.W = "1000003099";
            f0.a().track();
        }
    }

    public final void sendMoreClickLog(@NotNull Playable playable0) {
        q.g(playable0, "playable");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.d = ActionKind.ClickContent;
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getFilterClickLayer1();
            f0.e = "";
            f0.f = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            f0.g = "";
            f0.F = this.getString(0x7F130D73);  // string:tiara_click_copy_player_more "더보기"
            f0.a().track();
        }
    }

    public final void sendMoveClickLog(int v, @Nullable Playable playable0) {
        if(playable0 != null) {
            f f0 = this.getTiaraEventBuilder();
            if(f0 != null) {
                f0.d = ActionKind.ClickContent;
                f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                f0.y = this.getFilterClickLayer1();
                f0.c(v + 1);
                f0.e = "";
                f0.f = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
                f0.g = "";
                f0.F = this.getString(0x7F130FA3);  // string:tiara_playlist_move_my_order "순서변경"
                f0.a().track();
            }
        }
    }

    public final void sendMusicVideoClickLog(@NotNull Playable playable0) {
        q.g(playable0, "playable");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.d = ActionKind.PlayVideo;
            f0.a = this.getString(0x7F130DCC);  // string:tiara_common_action_name_play_video "영상재생"
            f0.y = this.getString(0x7F130FA2);  // string:tiara_playlist_more_info_popup "더보기 팝업"
            f0.o = "";
            f0.p = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            f0.q = "";
            f0.F = this.getString(0x7F130F04);  // string:tiara_meta_type_video "뮤직비디오"
            f0.a().track();
        }
    }

    public final void sendOfflinePlayClickLog(boolean z) {
        String s = z ? this.getString(0x7F130FCF) : this.getString(0x7F130FCE);  // string:tiara_props_on "on"
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getFilterClickLayer1();
            f0.F = this.getString(0x7F130D63);  // string:tiara_click_copy_offline_on_off "오프라인재생 on/off"
            f0.V = s;
            f0.a().track();
        }
    }

    public final void sendOpenMelonChartClickLog() {
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getString(0x7F130FA0);  // string:tiara_playlist_empty_layer1 "빈재생목록"
            f0.F = this.getString(0x7F130FA4);  // string:tiara_playlist_open_chart "멜론차트 바로가기"
            f0.a().track();
        }
    }

    public final void sendOrderClickLog() {
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getFilterClickLayer1();
            f0.F = this.getString(0x7F130A23);  // string:smart_playlist_orderby "정렬방식"
            f0.a().track();
        }
    }

    public final void sendOrderPopupClickLog(@NotNull String s) {
        q.g(s, "copy");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getString(0x7F130FA5);  // string:tiara_playlist_order_select "정렬방식선택"
            f0.F = s;
            f0.a().track();
        }
    }

    public final void sendPlayClickLog(int v, @Nullable Playable playable0) {
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.d = ActionKind.PlayMusic;
            String s = this.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
            String s1 = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            f0.a = s;
            f0.y = this.getFilterClickLayer1();
            f0.c(v + 1);
            String s2 = null;
            f0.e = playable0 == null ? null : "";
            f0.f = s1;
            if(playable0 != null) {
                s2 = "";
            }
            f0.g = s2;
            f0.a().track();
        }
    }

    public final void sendPlayMixUpClickLog(@NotNull Playable playable0) {
        q.g(playable0, "playable");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.d = ActionKind.PlayMusic;
            f0.a = this.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
            f0.y = this.getString(0x7F130FA2);  // string:tiara_playlist_more_info_popup "더보기 팝업"
            f0.o = "";
            f0.p = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            f0.q = "";
            f0.e = "";
            f0.f = Y.i(ContsTypeCode.SONG_MIXUP, "code(...)");
            f0.g = "";
            f0.F = this.getString(0x7F130FA6);  // string:tiara_playlist_play_mix_up "이 곡으로 믹스업"
            f0.W = "1000003099";
            f0.a().track();
        }
    }

    public final void sendPutClickLog(@NotNull Playable playable0) {
        q.g(playable0, "playable");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.d = ActionKind.ClickContent;
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getString(0x7F130FA2);  // string:tiara_playlist_more_info_popup "더보기 팝업"
            f0.o = "";
            f0.p = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            f0.q = "";
            f0.F = this.getString(0x7F130DCE);  // string:tiara_common_action_name_put "담기"
            f0.e = "";
            f0.f = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            f0.g = "";
            f0.a().track();
        }
    }

    public final void sendSectionSelectClickLog() {
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.d = ActionKind.ClickContent;
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getFilterClickLayer1();
            f0.F = this.getString(0x7F130D94);  // string:tiara_click_copy_select_position "구간선택"
            f0.a().track();
        }
    }

    public final void sendSimilarSongClickLog(@NotNull Playable playable0) {
        q.g(playable0, "playable");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.d = ActionKind.ClickContent;
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getString(0x7F130FA2);  // string:tiara_playlist_more_info_popup "더보기 팝업"
            f0.o = "";
            f0.p = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            f0.q = "";
            f0.F = this.getString(0x7F130D9D);  // string:tiara_click_copy_similar_songs "이 곡과 유사한 곡 보기"
            f0.a().track();
        }
    }

    public final void sendSongInfoClickLog(@NotNull Playable playable0) {
        q.g(playable0, "playable");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.d = ActionKind.ClickContent;
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getString(0x7F130FA2);  // string:tiara_playlist_more_info_popup "더보기 팝업"
            f0.o = "";
            f0.p = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            f0.q = "";
            f0.e = "";
            f0.f = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            f0.g = "";
            f0.F = this.getString(0x7F130E13);  // string:tiara_common_layer1_song_info "곡정보"
            f0.a().track();
        }
    }

    public final void sendTakeNPClickLog() {
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getString(0x7F130FA0);  // string:tiara_playlist_empty_layer1 "빈재생목록"
            f0.F = this.getString(0x7F130FAB);  // string:tiara_playlist_take_np_copy "기존재생목록가져오기"
            f0.a().track();
        }
    }

    public final void sendTikTokClickLog(@NotNull Playable playable0) {
        q.g(playable0, "playable");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.d = ActionKind.ClickContent;
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getString(0x7F130FA2);  // string:tiara_playlist_more_info_popup "더보기 팝업"
            f0.o = "";
            f0.p = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            f0.q = "";
            f0.F = this.getString(0x7F130DA8);  // string:tiara_click_copy_tiktok "이 곡으로 제작된 TikTok"
            f0.a().track();
        }
    }

    public final void sendToolbarClickEvent(int v, @Nullable TiaraMixUpEventMeta playlistSongBaseTiaraLogHelper$TiaraMixUpEventMeta0) {
        String s;
        switch(v) {
            case 1: {
                s = this.getString(0x7F130D1A);  // string:tiara_click_copy_context_download "다운"
                break;
            }
            case 2: {
                s = this.getString(0x7F130CF4);  // string:tiara_chart_select_popup_put "담기"
                break;
            }
            case 4: {
                s = this.getString(0x7F130E5B);  // string:tiara_delete "삭제"
                break;
            }
            case 19: {
                s = this.getString(0x7F130D8D);  // string:tiara_click_copy_repeat_play "반복재생"
                break;
            }
            case 0x1F: {
                s = this.getString(0x7F130D53);  // string:tiara_click_copy_mixup "믹스업"
                break;
            }
            default: {
                s = "";
            }
        }
        boolean z = n.A0(new Integer[]{19, 0x1F}).contains(v);
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString((z ? 0x7F130DCB : 0x7F130DC9));  // string:tiara_common_action_name_play_music "음악재생"
            f0.y = this.getString(0x7F130FAC);  // string:tiara_playlist_toolbar_layer1 "선택기능버튼"
            f0.F = s;
            if(z) {
                f0.d = ActionKind.PlayMusic;
            }
            if(playlistSongBaseTiaraLogHelper$TiaraMixUpEventMeta0 != null) {
                f0.f = playlistSongBaseTiaraLogHelper$TiaraMixUpEventMeta0.getMetaType();
                f0.e = playlistSongBaseTiaraLogHelper$TiaraMixUpEventMeta0.getMetaId();
                f0.g = playlistSongBaseTiaraLogHelper$TiaraMixUpEventMeta0.getMetaName();
                f0.W = "1000003099";
                f0.a().track();
            }
        }
    }

    public static void sendToolbarClickEvent$default(PlaylistSongBaseTiaraLogHelper playlistSongBaseTiaraLogHelper0, int v, TiaraMixUpEventMeta playlistSongBaseTiaraLogHelper$TiaraMixUpEventMeta0, int v1, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendToolbarClickEvent");
        }
        if((v1 & 2) != 0) {
            playlistSongBaseTiaraLogHelper$TiaraMixUpEventMeta0 = null;
        }
        playlistSongBaseTiaraLogHelper0.sendToolbarClickEvent(v, playlistSongBaseTiaraLogHelper$TiaraMixUpEventMeta0);
    }

    public final void setTiaraProperty(@Nullable s s0) {
        this.b = s0;
    }
}

