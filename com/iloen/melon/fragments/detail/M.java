package com.iloen.melon.fragments.detail;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PLAYLIST;

public final class m implements View.OnClickListener {
    public final int a;
    public final DjPlaylistDetailFragment b;
    public final PLAYLIST c;

    public m(DjPlaylistDetailFragment djPlaylistDetailFragment0, PLAYLIST detailBaseRes$PLAYLIST0, int v) {
        this.a = v;
        this.b = djPlaylistDetailFragment0;
        this.c = detailBaseRes$PLAYLIST0;
        super();
    }

    public m(PLAYLIST detailBaseRes$PLAYLIST0, DjPlaylistDetailFragment djPlaylistDetailFragment0, int v) {
        this.a = v;
        this.c = detailBaseRes$PLAYLIST0;
        this.b = djPlaylistDetailFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                DjPlaylistDetailFragment.L0(this.b, this.c, view0);
                return;
            }
            case 1: {
                DjPlaylistDetailFragment.drawHeaderView$lambda$25$lambda$6(this.b, this.c, view0);
                return;
            }
            case 2: {
                DjPlaylistDetailFragment.drawHeaderView$lambda$25$lambda$8(this.b, this.c, view0);
                return;
            }
            case 3: {
                DjPlaylistDetailFragment.D0(this.b, this.c, view0);
                return;
            }
            default: {
                DjPlaylistDetailFragment.J0(this.b, this.c, view0);
            }
        }
    }
}

