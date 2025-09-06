package com.iloen.melon.fragments.detail;

import android.view.View.OnClickListener;
import android.view.View;

public final class u implements View.OnClickListener {
    public final int a;
    public final MixMakerPlaylistDetailFragment b;

    public u(MixMakerPlaylistDetailFragment mixMakerPlaylistDetailFragment0, int v) {
        this.a = v;
        this.b = mixMakerPlaylistDetailFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                MixMakerPlaylistDetailFragment.setSongListHeader$lambda$20$lambda$19(this.b, view0);
                return;
            }
            case 1: {
                MixMakerPlaylistDetailFragment.drawHeaderView$lambda$15$lambda$14(this.b, view0);
                return;
            }
            default: {
                MixMakerPlaylistDetailFragment.onViewCreated$lambda$3$lambda$2(this.b, view0);
            }
        }
    }
}

