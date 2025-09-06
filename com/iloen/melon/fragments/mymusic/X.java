package com.iloen.melon.fragments.mymusic;

import com.android.volley.Response.Listener;
import com.iloen.melon.net.v4x.response.MyMusicLikeListAlbumRes;
import com.iloen.melon.net.v4x.response.MyMusicLikeListSameAlbumRes;
import v9.i;

public final class x implements Listener {
    public final int a;
    public final MyMusicLikedAlbumFragment b;
    public final i c;

    public x(MyMusicLikedAlbumFragment myMusicLikedAlbumFragment0, i i0, int v) {
        this.a = v;
        this.b = myMusicLikedAlbumFragment0;
        this.c = i0;
        super();
    }

    @Override  // com.android.volley.Response$Listener
    public final void onResponse(Object object0) {
        if(this.a != 0) {
            MyMusicLikedAlbumFragment.onFetchStart$lambda$3(this.b, this.c, ((MyMusicLikeListAlbumRes)object0));
            return;
        }
        MyMusicLikedAlbumFragment.onFetchStart$lambda$1(this.b, this.c, ((MyMusicLikeListSameAlbumRes)object0));
    }
}

