package com.iloen.melon.fragments.artistchannel;

import android.view.View.OnClickListener;
import android.view.View;

public final class t implements View.OnClickListener {
    public final int a;
    public final ArtistDetailFanListFragment b;

    public t(ArtistDetailFanListFragment artistDetailFanListFragment0, int v) {
        this.a = v;
        this.b = artistDetailFanListFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            FanListAdapter.onBindViewImpl$lambda$5(this.b, view0);
            return;
        }
        FanListAdapter.onBindViewImpl$lambda$3(this.b, view0);
    }
}

