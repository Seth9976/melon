package com.iloen.melon.fragments.newmusic;

import android.view.View.OnLongClickListener;
import android.view.View;
import com.iloen.melon.net.v4x.response.NewAlbumListRes.RESPONSE.ALBUMLIST;

public final class h implements View.OnLongClickListener {
    public final NewAlbumFragment a;
    public final ALBUMLIST b;
    public final NewAlbumAdapter c;

    public h(NewAlbumFragment newAlbumFragment0, ALBUMLIST newAlbumListRes$RESPONSE$ALBUMLIST0, NewAlbumAdapter newAlbumFragment$NewAlbumAdapter0) {
        this.a = newAlbumFragment0;
        this.b = newAlbumListRes$RESPONSE$ALBUMLIST0;
        this.c = newAlbumFragment$NewAlbumAdapter0;
    }

    @Override  // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view0) {
        return NewAlbumAdapter.onBindViewImpl$lambda$10(this.a, this.b, this.c, view0);
    }
}

