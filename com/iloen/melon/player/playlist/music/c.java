package com.iloen.melon.player.playlist.music;

import androidx.lifecycle.f0;
import ie.H;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import we.k;

public final class c implements k {
    public final int a;
    public final MusicPlaylistBaseFragment b;

    public c(MusicPlaylistBaseFragment musicPlaylistBaseFragment0, int v) {
        this.a = v;
        this.b = musicPlaylistBaseFragment0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        MusicPlaylistBaseFragment musicPlaylistBaseFragment0 = this.b;
        int v = (int)(((Integer)object0));
        switch(this.a) {
            case 0: {
                BuildersKt__Builders_commonKt.launch$default(f0.f(musicPlaylistBaseFragment0), null, null, new MusicPlaylistBaseFragment.showMorePopup.1(musicPlaylistBaseFragment0, v, null), 3, null);
                return h0;
            }
            case 1: {
                ((MusicPlaylistBaseViewModel)musicPlaylistBaseFragment0.getViewModel()).unSelectAll();
                BuildersKt__Builders_commonKt.launch$default(f0.f(musicPlaylistBaseFragment0), null, null, new MusicPlaylistBaseFragment.showMorePopup.1(musicPlaylistBaseFragment0, v, null), 3, null);
                return h0;
            }
            case 2: {
                musicPlaylistBaseFragment0.sendUserEvent(new ClickCheckBoxSongItem(v));
                return h0;
            }
            case 3: {
                musicPlaylistBaseFragment0.sendUserEvent(new ClickSongItem(v));
                return h0;
            }
            default: {
                musicPlaylistBaseFragment0.sendUserEvent(new ClickAlbumThumbnail(v));
                return h0;
            }
        }
    }
}

