package com.iloen.melon.player.playlist;

import H0.e;
import androidx.fragment.app.l0;
import com.android.volley.Response.Listener;
import com.iloen.melon.fragments.detail.PlaylistMakeFragment;
import com.iloen.melon.net.v4x.response.MyMusicDjPlaylistInformCntCheckRes.RESPONSE;
import com.iloen.melon.net.v4x.response.MyMusicDjPlaylistInformCntCheckRes;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistInformCntCheckRes;
import com.iloen.melon.utils.Navigator;
import com.melon.ui.popup.b;

public final class f implements Listener {
    public final int a;
    public final PlaylistMainFragment b;

    public f(PlaylistMainFragment playlistMainFragment0, int v) {
        this.a = v;
        this.b = playlistMainFragment0;
        super();
    }

    @Override  // com.android.volley.Response$Listener
    public final void onResponse(Object object0) {
        String s = null;
        PlaylistMainFragment playlistMainFragment0 = this.b;
        if(this.a != 0) {
            if(e.N(playlistMainFragment0) && ((MyMusicDjPlaylistInformCntCheckRes)object0).isSuccessful()) {
                RESPONSE myMusicDjPlaylistInformCntCheckRes$RESPONSE0 = ((MyMusicDjPlaylistInformCntCheckRes)object0).response;
                if(myMusicDjPlaylistInformCntCheckRes$RESPONSE0 != null) {
                    s = myMusicDjPlaylistInformCntCheckRes$RESPONSE0.cntoverYn;
                }
                if("N".equals(s)) {
                    Navigator.open(PlaylistMakeFragment.newInstance("", "M20002", "melondjMakeDjplaylist"));
                    return;
                }
                l0 l00 = playlistMainFragment0.getChildFragmentManager();
                b.d(b.a, l00, "안내", "플레이리스트는 최대 500개까지 만들 수 있습니다. 기존 플레이리스트를 삭제하신 후 다시 시도해주세요.", false, false, false, null, null, null, null, null, 2040);
            }
            return;
        }
        if(e.N(playlistMainFragment0) && ((MyMusicPlaylistInformCntCheckRes)object0).isSuccessful()) {
            com.iloen.melon.net.v4x.response.MyMusicPlaylistInformCntCheckRes.RESPONSE myMusicPlaylistInformCntCheckRes$RESPONSE0 = ((MyMusicPlaylistInformCntCheckRes)object0).response;
            if(myMusicPlaylistInformCntCheckRes$RESPONSE0 != null) {
                s = myMusicPlaylistInformCntCheckRes$RESPONSE0.cntoverYn;
            }
            if("N".equals(s)) {
                Navigator.open(PlaylistMakeFragment.newInstance("", "M20001", "mymusicPlaylistNewMake"));
                return;
            }
            l0 l01 = playlistMainFragment0.getChildFragmentManager();
            b.d(b.a, l01, "안내", "플레이리스트는 최대 500개까지 만들 수 있습니다. 기존 플레이리스트를 삭제하신 후 다시 시도해주세요.", false, false, false, null, null, null, null, null, 2040);
        }
    }
}

