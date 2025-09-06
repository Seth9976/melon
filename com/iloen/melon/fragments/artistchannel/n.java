package com.iloen.melon.fragments.artistchannel;

import android.view.View.OnClickListener;
import android.view.View;

public final class n implements View.OnClickListener {
    public final int a;
    public final DetailInfoAdapter b;
    public final boolean c;
    public final ArtistDetailDetailInfoFragment d;

    public n(DetailInfoAdapter artistDetailDetailInfoFragment$DetailInfoAdapter0, boolean z, ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment0, int v) {
        this.a = v;
        this.b = artistDetailDetailInfoFragment$DetailInfoAdapter0;
        this.c = z;
        this.d = artistDetailDetailInfoFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            ExpandableButtonViewHolder.bind$lambda$1(this.b, this.c, this.d, view0);
            return;
        }
        ExpandableButtonViewHolder.bind$lambda$0(this.b, this.c, this.d, view0);
    }
}

