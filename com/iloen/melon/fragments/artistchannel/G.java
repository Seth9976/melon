package com.iloen.melon.fragments.artistchannel;

import android.view.View.OnClickListener;
import android.view.View;

public final class g implements View.OnClickListener {
    public final int a;
    public final ArtistDetailContentsSongFragment b;

    public g(ArtistDetailContentsSongFragment artistDetailContentsSongFragment0, int v) {
        this.a = v;
        this.b = artistDetailContentsSongFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            ArtistDetailContentsSongFragment.makeShuffleAllPlayButtons$lambda$4(this.b, view0);
            return;
        }
        ArtistDetailContentsSongFragment.makeShuffleAllPlayButtons$lambda$3(this.b, view0);
    }
}

