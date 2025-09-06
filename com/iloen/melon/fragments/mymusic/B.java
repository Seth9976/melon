package com.iloen.melon.fragments.mymusic;

import we.a;

public final class b implements a {
    public final int a;
    public final DjPlaylistFragment b;

    public b(DjPlaylistFragment djPlaylistFragment0, int v) {
        this.a = v;
        this.b = djPlaylistFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a != 0 ? DjPlaylistFragment.sortingTexts_delegate$lambda$2(this.b) : PlaylistAdapter.onBindViewImpl$lambda$5$lambda$4(this.b);
    }
}

