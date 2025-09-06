package com.iloen.melon.fragments.artistchannel;

import android.view.View.OnClickListener;
import android.view.View;

public final class h implements View.OnClickListener {
    public final int a;
    public final ArtistDetailContentsTopicFragment b;

    public h(ArtistDetailContentsTopicFragment artistDetailContentsTopicFragment0, int v) {
        this.a = v;
        this.b = artistDetailContentsTopicFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            ArtistDetailContentsTopicFragment.onViewCreated$lambda$3$lambda$2(this.b, view0);
            return;
        }
        ArtistDetailContentsTopicFragment.onViewCreated$lambda$3$lambda$1(this.b, view0);
    }
}

