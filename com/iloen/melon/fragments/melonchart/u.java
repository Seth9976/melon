package com.iloen.melon.fragments.melonchart;

import android.view.View.OnClickListener;
import android.view.View;

public final class u implements View.OnClickListener {
    public final int a;
    public final MelonChartHotTrackListFragment b;

    public u(MelonChartHotTrackListFragment melonChartHotTrackListFragment0, int v) {
        this.a = v;
        this.b = melonChartHotTrackListFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            MelonChartHotTrackListFragment.onViewCreated$lambda$1(this.b, view0);
            return;
        }
        MelonChartHotTrackListFragment.onViewCreated$lambda$0(this.b, view0);
    }
}

