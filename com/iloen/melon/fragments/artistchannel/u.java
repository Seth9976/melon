package com.iloen.melon.fragments.artistchannel;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ArtistFanFanListRes.RESPONSE.RECENTLYLIKEFANLIST;

public final class u implements View.OnClickListener {
    public final int a;
    public final RECENTLYLIKEFANLIST b;
    public final FanListAdapter c;

    public u(RECENTLYLIKEFANLIST artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0, FanListAdapter artistDetailFanListFragment$FanListAdapter0, int v) {
        this.a = v;
        this.b = artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0;
        this.c = artistDetailFanListFragment$FanListAdapter0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            RecentlyLikeFanListAdapter.onBindViewImpl$lambda$4$lambda$1(this.b, this.c, view0);
            return;
        }
        RecentlyLikeFanListAdapter.onBindViewImpl$lambda$4$lambda$0(this.b, this.c, view0);
    }
}

