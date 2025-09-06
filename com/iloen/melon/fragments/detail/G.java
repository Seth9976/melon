package com.iloen.melon.fragments.detail;

import android.view.View.OnClickListener;
import android.view.View;

public final class g implements View.OnClickListener {
    public final int a;
    public final ArtistPlaylistDetailFragment b;

    public g(ArtistPlaylistDetailFragment artistPlaylistDetailFragment0, int v) {
        this.a = v;
        this.b = artistPlaylistDetailFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                ArtistPlaylistDetailFragment.onViewCreated$lambda$2(this.b, view0);
                return;
            }
            case 1: {
                ArtistPlaylistDetailFragment.drawHeaderView$lambda$11$lambda$9(this.b, view0);
                return;
            }
            default: {
                ArtistPlaylistDetailFragment.drawHeaderView$lambda$11$lambda$10(this.b, view0);
            }
        }
    }
}

