package com.iloen.melon.fragments.newmusic;

import androidx.compose.runtime.l;
import we.n;

public final class e implements n {
    public final NewAlbumFragment a;
    public final NewAlbumAdapter b;

    public e(NewAlbumFragment newAlbumFragment0, NewAlbumAdapter newAlbumFragment$NewAlbumAdapter0) {
        this.a = newAlbumFragment0;
        this.b = newAlbumFragment$NewAlbumAdapter0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return NewAlbumAdapter.d(this.a, this.b, ((l)object0), ((int)(((Integer)object1))));
    }
}

