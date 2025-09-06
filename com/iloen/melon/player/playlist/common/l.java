package com.iloen.melon.player.playlist.common;

import ie.H;
import we.a;
import we.k;

public final class l implements a {
    public final int a;
    public final k b;
    public final PlaylistDeleteUiEvent c;

    public l(k k0, PlaylistDeleteUiEventHelper playlistDeleteUiEventHelper0, PlaylistDeleteUiEvent playlistDeleteUiEvent0, int v) {
        this.a = v;
        this.b = k0;
        this.c = playlistDeleteUiEvent0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            DeletePlaylist deletePlaylist0 = PlaylistDeleteUiEventHelper.a(((DeleteConfirmAlertUiEvent)this.c).getUserEvent());
            this.b.invoke(deletePlaylist0);
            return H.a;
        }
        DeletePlaylist deletePlaylist1 = PlaylistDeleteUiEventHelper.a(((DeleteConfirmAlertUiEvent)this.c).getUserEvent());
        this.b.invoke(deletePlaylist1);
        return H.a;
    }
}

