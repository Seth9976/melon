package com.iloen.melon.fragments.radio;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v5x.response.StationHomeRes.RESPONSE.TOPOFFERLIST;

public final class c implements View.OnClickListener {
    public final int a;
    public final TOPOFFERLIST b;
    public final HeaderPagerAdapter c;
    public final int d;
    public final Object e;

    public c(StationFragment stationFragment0, TOPOFFERLIST stationHomeRes$RESPONSE$TOPOFFERLIST0, HeaderPagerAdapter stationFragment$StationAdapter$HeaderViewHolder$HeaderPagerAdapter0, int v) {
        this.a = 1;
        super();
        this.e = stationFragment0;
        this.b = stationHomeRes$RESPONSE$TOPOFFERLIST0;
        this.c = stationFragment$StationAdapter$HeaderViewHolder$HeaderPagerAdapter0;
        this.d = v;
    }

    public c(TOPOFFERLIST stationHomeRes$RESPONSE$TOPOFFERLIST0, StationAdapter stationFragment$StationAdapter0, HeaderPagerAdapter stationFragment$StationAdapter$HeaderViewHolder$HeaderPagerAdapter0, int v) {
        this.a = 0;
        super();
        this.b = stationHomeRes$RESPONSE$TOPOFFERLIST0;
        this.e = stationFragment$StationAdapter0;
        this.c = stationFragment$StationAdapter$HeaderViewHolder$HeaderPagerAdapter0;
        this.d = v;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            HeaderPagerAdapter.b(((StationFragment)this.e), this.b, this.c, this.d, view0);
            return;
        }
        HeaderPagerAdapter.a(this.b, ((StationAdapter)this.e), this.c, this.d, view0);
    }
}

