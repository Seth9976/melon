package com.iloen.melon.player.playlist.music;

import com.iloen.melon.utils.Navigator;
import ie.H;
import we.a;

public final class r implements a {
    public final int a;
    public final SmartPlaylistFragment b;

    public r(SmartPlaylistFragment smartPlaylistFragment0, int v) {
        this.a = v;
        this.b = smartPlaylistFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        H h0 = H.a;
        SmartPlaylistFragment smartPlaylistFragment0 = this.b;
        if(this.a != 0) {
            smartPlaylistFragment0.sendUserEvent(ClickGetFromNormalPlaylist.INSTANCE);
            smartPlaylistFragment0.getTiaraLogHelper().sendTakeNPClickLog();
            return h0;
        }
        Navigator.openChartMain();
        smartPlaylistFragment0.getTiaraLogHelper().sendOpenMelonChartClickLog();
        return h0;
    }
}

