package com.iloen.melon.fragments.detail;

import android.view.View.OnClickListener;
import android.view.View;

public final class v implements View.OnClickListener {
    public final int a;
    public final MixPlaylistDetailFragment b;

    public v(MixPlaylistDetailFragment mixPlaylistDetailFragment0, int v) {
        this.a = v;
        this.b = mixPlaylistDetailFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                MixPlaylistDetailFragment.initLayout$lambda$4$lambda$3(this.b, view0);
                return;
            }
            case 1: {
                MixPlaylistDetailFragment.updateSingleImageCoverUi$lambda$33$lambda$32$lambda$31(this.b, view0);
                return;
            }
            case 2: {
                MixPlaylistDetailFragment.drawHeaderView$lambda$13(this.b, view0);
                return;
            }
            default: {
                MixPlaylistDetailFragment.drawHeaderView$lambda$14(this.b, view0);
            }
        }
    }
}

