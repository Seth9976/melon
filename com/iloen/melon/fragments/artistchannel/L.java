package com.iloen.melon.fragments.artistchannel;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ArtistDetailInfoRes.RESPONSE.MEMBERLIST;

public final class l implements View.OnClickListener {
    public final ArtistDetailDetailInfoFragment a;
    public final MEMBERLIST b;
    public final int c;

    public l(ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment0, MEMBERLIST artistDetailInfoRes$RESPONSE$MEMBERLIST0, int v) {
        this.a = artistDetailDetailInfoFragment0;
        this.b = artistDetailInfoRes$RESPONSE$MEMBERLIST0;
        this.c = v;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        DetailInfoHolder.bind$lambda$3(this.a, this.b, this.c, view0);
    }
}

