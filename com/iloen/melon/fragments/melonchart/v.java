package com.iloen.melon.fragments.melonchart;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v5x.response.HotTrackRes.RESPONSE.HOTTRACKS.CHARTLIST;

public final class v implements View.OnClickListener {
    public final int a;
    public final MelonChartHotTrackListFragment b;
    public final CHARTLIST c;
    public final HotTracksSongAdapter d;
    public final int e;

    public v(MelonChartHotTrackListFragment melonChartHotTrackListFragment0, CHARTLIST hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0, HotTracksSongAdapter melonChartHotTrackListFragment$HotTracksSongAdapter0, int v, int v1) {
        this.a = v1;
        this.b = melonChartHotTrackListFragment0;
        this.c = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0;
        this.d = melonChartHotTrackListFragment$HotTracksSongAdapter0;
        this.e = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            HotTracksSongAdapter.onBindViewImpl$lambda$4(this.b, this.c, this.d, this.e, view0);
            return;
        }
        HotTracksSongAdapter.onBindViewImpl$lambda$3(this.b, this.c, this.d, this.e, view0);
    }
}

