package com.iloen.melon.fragments.artistchannel;

import android.view.View.OnClickListener;
import android.view.View;

public final class y implements View.OnClickListener {
    public final int a;
    public final ArtistDetailHomeFragment b;

    public y(ArtistDetailHomeFragment artistDetailHomeFragment0, int v) {
        this.a = v;
        this.b = artistDetailHomeFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                ArtistDetailAdapter.onBindViewImpl$lambda$20(this.b, view0);
                return;
            }
            case 1: {
                ArtistDetailAdapter.onBindViewImpl$lambda$21(this.b, view0);
                return;
            }
            case 2: {
                ArtistDetailAdapter.onBindViewImpl$lambda$22(this.b, view0);
                return;
            }
            case 3: {
                ArtistDetailHomeFragment.onViewCreated$lambda$2(this.b, view0);
                return;
            }
            case 4: {
                ArtistDetailHomeFragment.onViewCreated$lambda$3(this.b, view0);
                return;
            }
            case 5: {
                ArtistDetailHomeFragment.onViewCreated$lambda$4(this.b, view0);
                return;
            }
            case 6: {
                ArtistDetailHomeFragment.onViewCreated$lambda$5(this.b, view0);
                return;
            }
            case 7: {
                ArtistDetailHomeFragment.drawCreditLayout$lambda$22(this.b, view0);
                return;
            }
            default: {
                ArtistDetailHomeFragment.drawHeaderView$lambda$14(this.b, view0);
            }
        }
    }
}

