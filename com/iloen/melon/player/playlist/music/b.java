package com.iloen.melon.player.playlist.music;

import Lb.d;
import com.iloen.melon.player.playlist.common.SectionSelectUserEvent.ClickSectionSelectButton;
import com.iloen.melon.player.playlist.common.SectionSelectUserEvent.ClickSectionSelectCancelButton;
import ie.H;
import we.a;

public final class b implements a {
    public final int a;
    public final MusicPlaylistBaseFragment b;

    public b(MusicPlaylistBaseFragment musicPlaylistBaseFragment0, int v) {
        this.a = v;
        this.b = musicPlaylistBaseFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        H h0 = H.a;
        MusicPlaylistBaseFragment musicPlaylistBaseFragment0 = this.b;
        switch(this.a) {
            case 0: {
                musicPlaylistBaseFragment0.sendUserEvent(OnTouchDownMoveIconWhenSelectRepeatOn.INSTANCE);
                return h0;
            }
            case 1: {
                musicPlaylistBaseFragment0.sendUserEvent(ClickSortOrderUserEvent.INSTANCE);
                return h0;
            }
            case 2: {
                musicPlaylistBaseFragment0.sendUserEvent(d.a);
                return h0;
            }
            case 3: {
                musicPlaylistBaseFragment0.sendUserEvent(ClickSectionSelectButton.INSTANCE);
                return h0;
            }
            case 4: {
                musicPlaylistBaseFragment0.sendUserEvent(ClickSectionSelectCancelButton.INSTANCE);
                return h0;
            }
            case 5: {
                return musicPlaylistBaseFragment0.getResources().getStringArray(0x7F030010);  // array:filter_sp_music_playlist_nonorder
            }
            case 6: {
                return musicPlaylistBaseFragment0.getResources().getStringArray(0x7F03000F);  // array:filter_sp_music_playlist
            }
            case 7: {
                musicPlaylistBaseFragment0.sendUserEvent(ClickAllSelectUserEvent.INSTANCE);
                return h0;
            }
            default: {
                ((MusicPlaylistBaseViewModel)musicPlaylistBaseFragment0.getViewModel()).unSelectAll();
                ((MusicPlaylistBaseViewModel)musicPlaylistBaseFragment0.getViewModel()).setIsDragging(true);
                return h0;
            }
        }
    }
}

