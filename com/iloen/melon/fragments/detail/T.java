package com.iloen.melon.fragments.detail;

import android.view.View.OnClickListener;
import android.view.View;

public final class t implements View.OnClickListener {
    public final int a;
    public final MixMakerPlaylistBySongIdsDetailFragment b;

    public t(MixMakerPlaylistBySongIdsDetailFragment mixMakerPlaylistBySongIdsDetailFragment0, int v) {
        this.a = v;
        this.b = mixMakerPlaylistBySongIdsDetailFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            MixMakerPlaylistBySongIdsDetailFragment.onViewCreated$lambda$3$lambda$2(this.b, view0);
            return;
        }
        MixMakerPlaylistBySongIdsDetailFragment.setSongListHeader$lambda$19$lambda$18(this.b, view0);
    }
}

