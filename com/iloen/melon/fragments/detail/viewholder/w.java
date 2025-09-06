package com.iloen.melon.fragments.detail.viewholder;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PLAYLIST;

public final class w implements View.OnClickListener {
    public final int a;
    public final PlaylistHolder b;
    public final PLAYLIST c;
    public final int d;

    public w(PlaylistHolder playlistHolder0, PLAYLIST detailBaseRes$PLAYLIST0, int v) {
        this.a = 1;
        super();
        this.b = playlistHolder0;
        this.c = detailBaseRes$PLAYLIST0;
        this.d = v;
    }

    public w(PLAYLIST detailBaseRes$PLAYLIST0, PlaylistHolder playlistHolder0, int v) {
        this.a = 0;
        super();
        this.c = detailBaseRes$PLAYLIST0;
        this.b = playlistHolder0;
        this.d = v;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            PlaylistHolder.bindItem$lambda$3(this.b, this.c, this.d, view0);
            return;
        }
        PlaylistHolder.b(this.b, this.c, this.d, view0);
    }
}

