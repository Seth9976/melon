package com.iloen.melon.player.playlist;

public final class i implements Runnable {
    public final PlaylistMainFragment a;

    public i(PlaylistMainFragment playlistMainFragment0) {
        this.a = playlistMainFragment0;
    }

    @Override
    public final void run() {
        this.a.o().updateFocusingTabToCurrentPlaylist();
    }
}

