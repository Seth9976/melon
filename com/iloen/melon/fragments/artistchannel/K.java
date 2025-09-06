package com.iloen.melon.fragments.artistchannel;

import we.a;

public final class k implements a {
    public final int a;
    public final ArtistDetailContentsVideoFragment b;

    public k(ArtistDetailContentsVideoFragment artistDetailContentsVideoFragment0, int v) {
        this.a = v;
        this.b = artistDetailContentsVideoFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a == 0 ? ArtistDetailContentsVideoFragment.filterLevel1List_delegate$lambda$2(this.b) : ArtistDetailContentsVideoFragment.filterLevel2List_delegate$lambda$3(this.b);
    }
}

