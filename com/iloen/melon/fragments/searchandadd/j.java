package com.iloen.melon.fragments.searchandadd;

import we.a;

public final class j implements a {
    public final int a;
    public final PlaylistSearchAndAddTabFragment b;

    public j(PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment0, int v) {
        this.a = v;
        this.b = playlistSearchAndAddTabFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a != 0 ? PlaylistSearchAndAddTabFragment.playlistSearchViewModel_delegate$lambda$1(this.b) : PlaylistSearchAndAddTabFragment.filterNameList_delegate$lambda$0(this.b);
    }
}

