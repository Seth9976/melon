package com.iloen.melon.fragments.searchandadd;

import we.a;

public final class e implements a {
    public final int a;
    public final SearchAndAddBaseFragment b;

    public e(SearchAndAddBaseFragment searchAndAddBaseFragment0, int v) {
        this.a = v;
        this.b = searchAndAddBaseFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return PlaylistSearchAndAddPlaylistFragment.playlistSearchViewModel_delegate$lambda$0(((PlaylistSearchAndAddPlaylistFragment)this.b));
            }
            case 1: {
                return PlaylistSearchAndAddRecentFragment.playlistSearchViewModel_delegate$lambda$0(((PlaylistSearchAndAddRecentFragment)this.b));
            }
            default: {
                return PlaylistSearchAndAddSongListFragment.playlistSearchViewModel_delegate$lambda$0(((PlaylistSearchAndAddSongListFragment)this.b));
            }
        }
    }
}

