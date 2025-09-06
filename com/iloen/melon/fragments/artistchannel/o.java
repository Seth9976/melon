package com.iloen.melon.fragments.artistchannel;

import android.view.View.OnClickListener;
import android.view.View;

public final class o implements View.OnClickListener {
    public final DetailInfoAdapter a;
    public final ArtistDetailDetailInfoFragment b;
    public final int c;
    public final boolean d;
    public final int e;

    public o(DetailInfoAdapter artistDetailDetailInfoFragment$DetailInfoAdapter0, ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment0, int v, boolean z, int v1) {
        this.a = artistDetailDetailInfoFragment$DetailInfoAdapter0;
        this.b = artistDetailDetailInfoFragment0;
        this.c = v;
        this.d = z;
        this.e = v1;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        ExpandableButtonViewHolder.bind$lambda$2(this.a, this.b, this.c, this.d, this.e, view0);
    }
}

