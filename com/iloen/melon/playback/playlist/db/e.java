package com.iloen.melon.playback.playlist.db;

import G4.a;
import com.iloen.melon.playback.playlist.db.entity.EduEntity;
import we.k;

public final class e implements k {
    public final int a;
    public final PlaylistDao_Impl b;
    public final EduEntity c;

    public e(PlaylistDao_Impl playlistDao_Impl0, EduEntity eduEntity0, int v) {
        this.a = v;
        this.b = playlistDao_Impl0;
        this.c = eduEntity0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return this.a == 0 ? PlaylistDao_Impl.W(this.b, this.c, ((a)object0)) : PlaylistDao_Impl.j(this.b, this.c, ((a)object0));
    }
}

