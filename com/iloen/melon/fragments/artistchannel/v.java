package com.iloen.melon.fragments.artistchannel;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ArtistFanFanListRes.RESPONSE.RECENTLYLIKEFANLIST;

public final class v implements View.OnClickListener {
    public final int a;
    public final ArtistDetailFanListFragment b;
    public final RECENTLYLIKEFANLIST c;
    public final RecentlyLikeFanListAdapter d;
    public final FanListAdapter e;
    public final FanItemViewHolder f;

    public v(ArtistDetailFanListFragment artistDetailFanListFragment0, RECENTLYLIKEFANLIST artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0, RecentlyLikeFanListAdapter artistDetailFanListFragment$FanListAdapter$RecentlyLikeFanListAdapter0, FanListAdapter artistDetailFanListFragment$FanListAdapter0, FanItemViewHolder artistDetailFanListFragment$FanListAdapter$RecentlyLikeFanListAdapter$FanItemViewHolder0, int v) {
        this.a = v;
        this.b = artistDetailFanListFragment0;
        this.c = artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0;
        this.d = artistDetailFanListFragment$FanListAdapter$RecentlyLikeFanListAdapter0;
        this.e = artistDetailFanListFragment$FanListAdapter0;
        this.f = artistDetailFanListFragment$FanListAdapter$RecentlyLikeFanListAdapter$FanItemViewHolder0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            RecentlyLikeFanListAdapter.onBindViewImpl$lambda$4$lambda$3(this.b, this.c, this.d, this.e, this.f, view0);
            return;
        }
        RecentlyLikeFanListAdapter.onBindViewImpl$lambda$4$lambda$2(this.b, this.c, this.d, this.e, this.f, view0);
    }
}

