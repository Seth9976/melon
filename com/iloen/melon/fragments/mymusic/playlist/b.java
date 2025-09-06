package com.iloen.melon.fragments.mymusic.playlist;

import we.a;

public final class b implements a {
    public final int a;
    public final ImageToPlaylistFragment b;

    public b(ImageToPlaylistFragment imageToPlaylistFragment0, int v) {
        this.a = v;
        this.b = imageToPlaylistFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a == 0 ? ImageToPlaylistFragment.MainContent$lambda$32$lambda$31$lambda$30(this.b) : ImageToPlaylistFragment.onUiEvent$lambda$48(this.b);
    }
}

