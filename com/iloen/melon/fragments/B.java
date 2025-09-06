package com.iloen.melon.fragments;

import we.a;

public final class b implements a {
    public final int a;
    public final DetailSongMetaContentBaseFragment b;

    public b(DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment0, int v) {
        this.a = v;
        this.b = detailSongMetaContentBaseFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a != 0 ? DetailSongMetaContentBaseFragment.commentActionImpl_delegate$lambda$1(this.b) : DetailSongMetaContentBaseFragment.commentViewModel_delegate$lambda$0(this.b);
    }
}

