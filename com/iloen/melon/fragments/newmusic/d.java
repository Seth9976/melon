package com.iloen.melon.fragments.newmusic;

import androidx.compose.runtime.l;
import we.n;

public final class d implements n {
    public final NewAlbumFragment a;

    public d(NewAlbumFragment newAlbumFragment0) {
        this.a = newAlbumFragment0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return NewAlbumAdapter.b(this.a, ((l)object0), ((int)(((Integer)object1))));
    }
}

