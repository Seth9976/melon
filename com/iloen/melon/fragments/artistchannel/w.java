package com.iloen.melon.fragments.artistchannel;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE;

public final class w implements View.OnClickListener {
    public final int a;
    public final ArtistDetailHomeFragment b;
    public final RESPONSE c;

    public w(ArtistDetailHomeFragment artistDetailHomeFragment0, RESPONSE artistHomeBasicInfoRes$RESPONSE0) {
        this.a = 1;
        super();
        this.b = artistDetailHomeFragment0;
        this.c = artistHomeBasicInfoRes$RESPONSE0;
    }

    public w(RESPONSE artistHomeBasicInfoRes$RESPONSE0, ArtistDetailHomeFragment artistDetailHomeFragment0) {
        this.a = 0;
        super();
        this.c = artistHomeBasicInfoRes$RESPONSE0;
        this.b = artistDetailHomeFragment0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            ArtistDetailHomeFragment.drawHeaderView$lambda$13$lambda$12(this.b, this.c, view0);
            return;
        }
        ArtistDetailHomeFragment.v0(this.b, this.c, view0);
    }
}

