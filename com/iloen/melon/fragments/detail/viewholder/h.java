package com.iloen.melon.fragments.detail.viewholder;

import android.view.View.OnLongClickListener;
import android.view.View;
import com.melon.net.res.common.AlbumInfoBase;

public final class h implements View.OnLongClickListener {
    public final DetailContentsAlbumItemHolder a;
    public final AlbumInfoBase b;
    public final int c;

    public h(DetailContentsAlbumItemHolder detailContentsAlbumItemHolder0, AlbumInfoBase albumInfoBase0, int v) {
        this.a = detailContentsAlbumItemHolder0;
        this.b = albumInfoBase0;
        this.c = v;
    }

    @Override  // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view0) {
        return DetailContentsAlbumItemHolder.bind$lambda$3(this.a, this.b, this.c, view0);
    }
}

