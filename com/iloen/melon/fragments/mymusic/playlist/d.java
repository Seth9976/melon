package com.iloen.melon.fragments.mymusic.playlist;

import c.f;
import we.a;

public final class d implements a {
    public final int a;
    public final Object b;

    public d(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a != 0 ? ImageToPlaylistViewModel.toolBarEventHelper_delegate$lambda$2(((ImageToPlaylistViewModel)this.b)) : ImageToPlaylistFragment.renderUi$lambda$19$lambda$5$lambda$4(((f)this.b));
    }
}

