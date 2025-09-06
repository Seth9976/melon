package com.iloen.melon.player.playlist.drawernew;

import Pc.d;
import com.iloen.melon.player.playlist.tiara.PlaylistSongBaseTiaraLogHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import p8.f;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongTiaraLogHelper;", "Lcom/iloen/melon/player/playlist/tiara/PlaylistSongBaseTiaraLogHelper;", "LPc/d;", "stringProvider", "<init>", "(LPc/d;)V", "", "getFilterClickLayer1", "()Ljava/lang/String;", "Lie/H;", "sendHeaderClickLog", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerSongTiaraLogHelper extends PlaylistSongBaseTiaraLogHelper {
    public static final int $stable = 8;

    public DrawerSongTiaraLogHelper(@NotNull d d0) {
        q.g(d0, "stringProvider");
        super(d0);
    }

    @Override  // com.iloen.melon.player.playlist.tiara.PlaylistSongBaseTiaraLogHelper
    @NotNull
    public String getFilterClickLayer1() {
        return this.getString(0x7F130794);  // string:normal_playlist_filter_layer1 "곡리스트"
    }

    public final void sendHeaderClickLog() {
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getString(0x7F130FF7);  // string:tiara_smartplaylist_layer1_submenu "서브메뉴"
            f0.a().track();
        }
    }
}

