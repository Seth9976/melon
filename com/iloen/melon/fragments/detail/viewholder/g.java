package com.iloen.melon.fragments.detail.viewholder;

import android.view.View.OnClickListener;
import android.view.View;
import com.melon.net.res.common.AlbumInfoBase;

public final class g implements View.OnClickListener {
    public final int a;
    public final DetailContentsAlbumItemHolder b;
    public final AlbumInfoBase c;
    public final int d;

    public g(DetailContentsAlbumItemHolder detailContentsAlbumItemHolder0, AlbumInfoBase albumInfoBase0, int v, int v1) {
        this.a = v1;
        this.b = detailContentsAlbumItemHolder0;
        this.c = albumInfoBase0;
        this.d = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            DetailContentsAlbumItemHolder.bind$lambda$4(this.b, this.c, this.d, view0);
            return;
        }
        DetailContentsAlbumItemHolder.bind$lambda$2(this.b, this.c, this.d, view0);
    }
}

