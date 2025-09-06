package com.iloen.melon.fragments.mymusic;

import we.a;

public final class f0 implements a {
    public final int a;
    public final PlaylistFragment b;

    public f0(PlaylistFragment playlistFragment0, int v) {
        this.a = v;
        this.b = playlistFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a != 0 ? PlaylistFragment.filterTexts_delegate$lambda$0(this.b) : PlaylistAdapter.onBindViewImpl$lambda$2$lambda$1(this.b);
    }
}

