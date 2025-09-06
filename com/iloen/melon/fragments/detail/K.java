package com.iloen.melon.fragments.detail;

import android.view.View.OnClickListener;
import android.view.View;

public final class k implements View.OnClickListener {
    public final int a;
    public final DjPlaylistDetailFragment b;

    public k(DjPlaylistDetailFragment djPlaylistDetailFragment0, int v) {
        this.a = v;
        this.b = djPlaylistDetailFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                DjPlaylistDetailFragment.drawHeaderView$lambda$25$lambda$24(this.b, view0);
                return;
            }
            case 1: {
                DjPlaylistDetailFragment.drawHeaderView$lambda$25$lambda$19(this.b, view0);
                return;
            }
            default: {
                DjPlaylistDetailFragment.drawHeaderView$lambda$25$lambda$20(this.b, view0);
            }
        }
    }
}

