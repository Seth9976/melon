package com.iloen.melon.fragments.artistchannel;

import android.view.View.OnClickListener;
import android.view.View;

public final class m implements View.OnClickListener {
    public final int a;
    public final DetailInfoHolder b;
    public final ArtistDetailDetailInfoFragment c;

    public m(DetailInfoHolder artistDetailDetailInfoFragment$DetailInfoAdapter$DetailInfoHolder0, ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment0, int v) {
        this.a = v;
        this.b = artistDetailDetailInfoFragment$DetailInfoAdapter$DetailInfoHolder0;
        this.c = artistDetailDetailInfoFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                DetailInfoHolder.bind$lambda$4(this.b, this.c, view0);
                return;
            }
            case 1: {
                DetailInfoHolder.bind$lambda$5(this.b, this.c, view0);
                return;
            }
            case 2: {
                DetailInfoHolder.bind$lambda$6(this.b, this.c, view0);
                return;
            }
            default: {
                DetailInfoHolder.bind$lambda$7(this.b, this.c, view0);
            }
        }
    }
}

