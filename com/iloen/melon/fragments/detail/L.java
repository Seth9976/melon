package com.iloen.melon.fragments.detail;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PLAYLIST;

public final class l implements DialogInterface.OnClickListener {
    public final DjPlaylistDetailFragment a;
    public final PLAYLIST b;

    public l(DjPlaylistDetailFragment djPlaylistDetailFragment0, PLAYLIST detailBaseRes$PLAYLIST0) {
        this.a = djPlaylistDetailFragment0;
        this.b = detailBaseRes$PLAYLIST0;
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface0, int v) {
        DjPlaylistDetailFragment.drawHeaderView$lambda$25$lambda$4$lambda$3(this.a, this.b, dialogInterface0, v);
    }
}

