package com.iloen.melon.player.playlist.common;

import com.iloen.melon.playback.playlist.PlaylistId;
import ie.H;
import we.a;

public final class k implements a {
    public final int a;
    public final we.k b;
    public final DeletePlaylist c;

    public k(we.k k0, DeletePlaylist deletePlaylist0, int v) {
        this.a = v;
        this.b = k0;
        this.c = deletePlaylist0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                SelectRepeatInterruptUiEvent playlistDeleteUiEvent$SelectRepeatInterruptUiEvent0 = new SelectRepeatInterruptUiEvent(this.c);
                this.b.invoke(playlistDeleteUiEvent$SelectRepeatInterruptUiEvent0);
                return H.a;
            }
            case 1: {
                DeleteConfirmAlertUiEvent playlistDeleteUiEvent$DeleteConfirmAlertUiEvent1 = new DeleteConfirmAlertUiEvent(((DeletePlaylistByIndices)this.c).getPlaylistId(), ((DeletePlaylistByIndices)this.c).getIndices().size(), this.c);
                this.b.invoke(playlistDeleteUiEvent$DeleteConfirmAlertUiEvent1);
                return H.a;
            }
            case 2: {
                SelectRepeatInterruptUiEvent playlistDeleteUiEvent$SelectRepeatInterruptUiEvent1 = new SelectRepeatInterruptUiEvent(this.c);
                this.b.invoke(playlistDeleteUiEvent$SelectRepeatInterruptUiEvent1);
                return H.a;
            }
            case 3: {
                DeleteConfirmAlertUiEvent playlistDeleteUiEvent$DeleteConfirmAlertUiEvent2 = new DeleteConfirmAlertUiEvent(((DeletePlaylistByPlayables)this.c).getPlaylistId(), ((DeletePlaylistByPlayables)this.c).getPlayables().size(), this.c);
                this.b.invoke(playlistDeleteUiEvent$DeleteConfirmAlertUiEvent2);
                return H.a;
            }
            case 4: {
                SelectRepeatInterruptUiEvent playlistDeleteUiEvent$SelectRepeatInterruptUiEvent2 = new SelectRepeatInterruptUiEvent(this.c);
                this.b.invoke(playlistDeleteUiEvent$SelectRepeatInterruptUiEvent2);
                return H.a;
            }
            case 5: {
                int v1 = ((DeleteDrawerPlaylist)this.c).getIndices().size();
                DeleteConfirmAlertUiEvent playlistDeleteUiEvent$DeleteConfirmAlertUiEvent3 = new DeleteConfirmAlertUiEvent(PlaylistId.DRAWER, v1, this.c);
                this.b.invoke(playlistDeleteUiEvent$DeleteConfirmAlertUiEvent3);
                return H.a;
            }
            default: {
                int v = ((DeleteViewModeDrawerPlaylist)this.c).getIndices().size();
                DeleteConfirmAlertUiEvent playlistDeleteUiEvent$DeleteConfirmAlertUiEvent0 = new DeleteConfirmAlertUiEvent(PlaylistId.DRAWER, v, this.c);
                this.b.invoke(playlistDeleteUiEvent$DeleteConfirmAlertUiEvent0);
                return H.a;
            }
        }
    }
}

