package com.iloen.melon.fragments.newmusic;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v4x.response.NewAlbumListRes.RESPONSE.ALBUMLIST;

public final class g implements View.OnClickListener {
    public final ALBUMLIST a;
    public final NewAlbumAdapter b;
    public final NewAlbumFragment c;
    public final int d;

    public g(ALBUMLIST newAlbumListRes$RESPONSE$ALBUMLIST0, NewAlbumAdapter newAlbumFragment$NewAlbumAdapter0, NewAlbumFragment newAlbumFragment0, int v) {
        this.a = newAlbumListRes$RESPONSE$ALBUMLIST0;
        this.b = newAlbumFragment$NewAlbumAdapter0;
        this.c = newAlbumFragment0;
        this.d = v;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        NewAlbumAdapter.onBindViewImpl$lambda$9(this.a, this.b, this.c, this.d, view0);
    }
}

