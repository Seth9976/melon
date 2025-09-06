package com.iloen.melon.fragments.mymusic;

import android.view.View.OnClickListener;
import android.view.View;
import com.melon.net.res.common.AlbumInfoBase;

public final class y implements View.OnClickListener {
    public final boolean a;
    public final MyMusicLikedAlbumFragment b;
    public final int c;
    public final AlbumInfoBase d;
    public final LikedAlbumAdapter e;

    public y(boolean z, MyMusicLikedAlbumFragment myMusicLikedAlbumFragment0, int v, AlbumInfoBase albumInfoBase0, LikedAlbumAdapter myMusicLikedAlbumFragment$LikedAlbumAdapter0) {
        this.a = z;
        this.b = myMusicLikedAlbumFragment0;
        this.c = v;
        this.d = albumInfoBase0;
        this.e = myMusicLikedAlbumFragment$LikedAlbumAdapter0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        LikedAlbumAdapter.onBindViewImpl$lambda$5$lambda$2(this.a, this.b, this.c, this.d, this.e, view0);
    }
}

