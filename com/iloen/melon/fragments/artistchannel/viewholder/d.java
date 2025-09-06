package com.iloen.melon.fragments.artistchannel.viewholder;

import android.view.View.OnClickListener;
import android.view.View;

public final class d implements View.OnClickListener {
    public final ArtistFanCmtShareHolder a;

    public d(ArtistFanCmtShareHolder artistFanCmtShareHolder0) {
        this.a = artistFanCmtShareHolder0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        ArtistFanCmtShareHolder.onBindView$lambda$10(this.a, view0);
    }
}

