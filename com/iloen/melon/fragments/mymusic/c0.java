package com.iloen.melon.fragments.mymusic;

import java.util.List;
import we.k;

public final class c0 implements k {
    public final int a;
    public final OtherMusicLikedSongFragment b;

    public c0(OtherMusicLikedSongFragment otherMusicLikedSongFragment0, int v) {
        this.a = v;
        this.b = otherMusicLikedSongFragment0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return this.a == 0 ? OtherMusicLikedSongFragment.playAllLikedSong$lambda$3(this.b, ((List)object0)) : OtherMusicLikedSongFragment.shufflePlayAllLikedSong$lambda$4(this.b, ((List)object0));
    }
}

