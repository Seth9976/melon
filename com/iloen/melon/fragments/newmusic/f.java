package com.iloen.melon.fragments.newmusic;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v4x.response.NewAlbumListRes.RESPONSE.ALBUMLIST;

public final class f implements View.OnClickListener {
    public final boolean a;
    public final NewAlbumAdapter b;
    public final ALBUMLIST c;
    public final NewAlbumFragment d;
    public final int e;

    public f(boolean z, NewAlbumAdapter newAlbumFragment$NewAlbumAdapter0, ALBUMLIST newAlbumListRes$RESPONSE$ALBUMLIST0, NewAlbumFragment newAlbumFragment0, int v) {
        this.a = z;
        this.b = newAlbumFragment$NewAlbumAdapter0;
        this.c = newAlbumListRes$RESPONSE$ALBUMLIST0;
        this.d = newAlbumFragment0;
        this.e = v;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        NewAlbumAdapter.onBindViewImpl$lambda$8(this.a, this.b, this.c, this.d, this.e, view0);
    }
}

