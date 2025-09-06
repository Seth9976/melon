package com.iloen.melon.player.playlist.common;

import Ac.Z1;
import Bc.h;
import Pc.d;
import androidx.fragment.app.l0;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.popup.b;
import i.n.i.b.a.s.e.M3;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u0010\u001A\u00020\u000E2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0012\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E0\f¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUiEventHelper;", "", "<init>", "()V", "Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUiEvent;", "event", "LPc/d;", "stringProvider", "Landroidx/fragment/app/l0;", "fragmentManager", "LBc/h;", "playerUiHelper", "Lkotlin/Function1;", "LPc/e;", "Lie/H;", "sendUserEvent", "handleUiEvent", "(Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUiEvent;LPc/d;Landroidx/fragment/app/l0;LBc/h;Lwe/k;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistDeleteUiEventHelper {
    public static final int $stable;

    public static DeletePlaylist a(PlaylistDeleteUserEvent playlistDeleteUserEvent0) {
        if(playlistDeleteUserEvent0 instanceof DeletePlaylistByIndices) {
            return DeletePlaylistByIndices.copy$default(((DeletePlaylistByIndices)playlistDeleteUserEvent0), null, null, false, false, null, null, 55, null);
        }
        if(playlistDeleteUserEvent0 instanceof DeletePlaylistByPlayables) {
            return DeletePlaylistByPlayables.copy$default(((DeletePlaylistByPlayables)playlistDeleteUserEvent0), null, null, false, false, null, null, 55, null);
        }
        if(playlistDeleteUserEvent0 instanceof DeleteDrawerPlaylist) {
            return DeleteDrawerPlaylist.copy$default(((DeleteDrawerPlaylist)playlistDeleteUserEvent0), null, false, false, null, null, 27, null);
        }
        if(!(playlistDeleteUserEvent0 instanceof DeleteViewModeDrawerPlaylist)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return DeleteViewModeDrawerPlaylist.copy$default(((DeleteViewModeDrawerPlaylist)playlistDeleteUserEvent0), null, null, false, false, null, null, 55, null);
    }

    public final void handleUiEvent(@NotNull PlaylistDeleteUiEvent playlistDeleteUiEvent0, @NotNull d d0, @NotNull l0 l00, @NotNull h h0, @NotNull k k0) {
        q.g(playlistDeleteUiEvent0, "event");
        q.g(d0, "stringProvider");
        q.g(l00, "fragmentManager");
        q.g(h0, "playerUiHelper");
        q.g(k0, "sendUserEvent");
        if(playlistDeleteUiEvent0 instanceof CannotEditServerPlaylistUiEvent) {
            String s = ((StringProviderImpl)d0).a(0x7F1300D0);  // string:alert_dlg_title_info "안내"
            String s1 = ((StringProviderImpl)d0).a(0x7F1307AF);  // string:nowplaylist_playlist_no_network "네트워크 차단 상태에서는 플레이리스트 편집을 할 수 없습니다.\n네트워크 
                                                                 // 연결 상태를 확인해주세요."
            b.d(b.a, l00, s, s1, false, false, false, null, null, null, null, null, 2040);
            return;
        }
        if(playlistDeleteUiEvent0 instanceof SelectRepeatInterruptUiEvent) {
            h0.e(l00, new Z1(k0, this, playlistDeleteUiEvent0, 18));
            return;
        }
        if(!(playlistDeleteUiEvent0 instanceof DeleteConfirmAlertUiEvent)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        String s2 = ((StringProviderImpl)d0).a(0x7F130094) + " " + ((DeleteConfirmAlertUiEvent)playlistDeleteUiEvent0).getSongCount() + ((StringProviderImpl)d0).a(0x7F130092);  // string:alert_dlg_body_delete_sel_download_content_1 "선택한"
        q.f(s2, "toString(...)");
        b.x(l00, ((StringProviderImpl)d0).a(0x7F1300CD), s2, false, false, null, null, new l(k0, this, playlistDeleteUiEvent0, 1), null, null, null, 0xEF8);  // string:alert_dlg_title_delete_confirm "안내"
    }
}

