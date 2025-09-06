package com.iloen.melon.fragments.mymusic.playlist;

import com.melon.ui.K4;
import java.util.List;
import we.k;

public final class g implements k {
    public final int a;
    public final Object b;

    public g(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return this.a != 0 ? ImageToPlaylistFragment.renderUi$lambda$19$lambda$3$lambda$2(((ImageToPlaylistFragment)this.b), ((List)object0)) : com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel.uploadImages.2.f(((K4)this.b), ((K4)object0));
    }
}

