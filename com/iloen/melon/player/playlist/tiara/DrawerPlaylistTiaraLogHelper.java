package com.iloen.melon.player.playlist.tiara;

import Pc.d;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.interfaces.StringProviderImpl;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.g;
import p8.s;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u001D\u0010\u000F\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u000F\u0010\u0010J%\u0010\u0014\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0011\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0016\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0011\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/player/playlist/tiara/DrawerPlaylistTiaraLogHelper;", "", "LPc/d;", "stringProvider", "<init>", "(LPc/d;)V", "Lp8/s;", "tiaraProperty", "Lie/H;", "updateTiaraPropertyToLogHelper", "(Lp8/s;)V", "", "fromBottomSheet", "", "clickCopy", "sendSubMenuClickLog", "(ZLjava/lang/String;)V", "isNeedEventMeta", "Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;", "drawerPlaylistInfo", "sendPlaylistClickLog", "(ZZLcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;)V", "sendPlayClickLog", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerPlaylistTiaraLogHelper {
    public static final int $stable = 8;
    public final d a;
    public s b;

    public DrawerPlaylistTiaraLogHelper(@NotNull d d0) {
        q.g(d0, "stringProvider");
        super();
        this.a = d0;
    }

    public final String a(int v) {
        return ((StringProviderImpl)this.a).a(v);
    }

    public final g b() {
        s s0 = this.b;
        if(s0 != null) {
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.b = s0.a;
            g0.c = s0.b;
            g0.I = s0.c;
            return g0;
        }
        return null;
    }

    public final void sendPlayClickLog(boolean z, boolean z1, @NotNull DrawerPlaylistInfo drawerPlaylistInfo0) {
        q.g(drawerPlaylistInfo0, "drawerPlaylistInfo");
        g g0 = this.b();
        if(g0 != null) {
            g0.d = ActionKind.PlayMusic;
            g0.a = this.a(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
            g0.y = this.a((z ? 0x7F130FF6 : 0x7F130FF5));  // string:tiara_smartplaylist_layer1_playlist_popup "플레이리스트목록팝업"
            if(z1) {
                g0.e = drawerPlaylistInfo0.getContsId();
                g0.f = Y.i(ContsTypeCode.PLAYLIST, "code(...)");
                g0.g = drawerPlaylistInfo0.getTitle();
            }
            g0.a().track();
        }
    }

    public final void sendPlaylistClickLog(boolean z, boolean z1, @NotNull DrawerPlaylistInfo drawerPlaylistInfo0) {
        q.g(drawerPlaylistInfo0, "drawerPlaylistInfo");
        g g0 = this.b();
        if(g0 != null) {
            g0.d = ActionKind.ClickContent;
            g0.a = this.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            g0.y = this.a((z ? 0x7F130FF6 : 0x7F130FF5));  // string:tiara_smartplaylist_layer1_playlist_popup "플레이리스트목록팝업"
            if(z1) {
                String s = drawerPlaylistInfo0.isDj() ? Y.i(ContsTypeCode.DJ_PLAYLIST, "code(...)") : Y.i(ContsTypeCode.PLAYLIST, "code(...)");
                g0.e = drawerPlaylistInfo0.getContsId();
                g0.f = s;
                g0.g = drawerPlaylistInfo0.getTitle();
            }
            g0.a().track();
        }
    }

    public final void sendSubMenuClickLog(boolean z, @NotNull String s) {
        q.g(s, "clickCopy");
        g g0 = this.b();
        if(g0 != null) {
            g0.a = this.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            g0.y = this.a((z ? 0x7F130FF6 : 0x7F130FF7));  // string:tiara_smartplaylist_layer1_playlist_popup "플레이리스트목록팝업"
            g0.F = s;
            g0.a().track();
        }
    }

    public final void updateTiaraPropertyToLogHelper(@Nullable s s0) {
        if(s0 != null) {
            this.b = s0;
        }
    }
}

