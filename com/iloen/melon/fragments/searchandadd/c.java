package com.iloen.melon.fragments.searchandadd;

import we.a;

public final class c implements a {
    public final int a;
    public final PlaylistSearchAndAddLikeFragment b;

    public c(PlaylistSearchAndAddLikeFragment playlistSearchAndAddLikeFragment0, int v) {
        this.a = v;
        this.b = playlistSearchAndAddLikeFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a != 0 ? PlaylistSearchAndAddLikeFragment.playlistSearchViewModel_delegate$lambda$1(this.b) : PlaylistSearchAndAddLikeFragment.filterNameList_delegate$lambda$0(this.b);
    }
}

