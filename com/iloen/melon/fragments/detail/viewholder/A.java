package com.iloen.melon.fragments.detail.viewholder;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v5x.response.DetailBaseRes.ALBUM;

public final class a implements View.OnClickListener {
    public final int a;
    public final AlbumHolder b;
    public final ALBUM c;
    public final int d;

    public a(AlbumHolder albumHolder0, ALBUM detailBaseRes$ALBUM0, int v) {
        this.a = 1;
        super();
        this.b = albumHolder0;
        this.c = detailBaseRes$ALBUM0;
        this.d = v;
    }

    public a(ALBUM detailBaseRes$ALBUM0, AlbumHolder albumHolder0, int v) {
        this.a = 0;
        super();
        this.c = detailBaseRes$ALBUM0;
        this.b = albumHolder0;
        this.d = v;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            AlbumHolder.bindItem$lambda$3(this.b, this.c, this.d, view0);
            return;
        }
        AlbumHolder.a(this.b, this.c, this.d, view0);
    }
}

