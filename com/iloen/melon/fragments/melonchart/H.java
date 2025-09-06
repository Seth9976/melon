package com.iloen.melon.fragments.melonchart;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.net.v4x.common.ChartSongInfoBase;
import com.iloen.melon.net.v4x.response.AgeSongChartListRes.RESPONSE.CHARTLIST;
import com.melon.net.res.common.SongInfoBase;

public final class h implements View.OnClickListener {
    public final int a;
    public final MelonChartBaseFragment b;
    public final SongInfoBase c;
    public final p d;
    public final int e;

    public h(MelonChartBaseFragment melonChartBaseFragment0, SongInfoBase songInfoBase0, p p0, int v, int v1) {
        this.a = v1;
        this.b = melonChartBaseFragment0;
        this.c = songInfoBase0;
        this.d = p0;
        this.e = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                AgeAdapter.onBindViewImpl$lambda$2(((MelonChartAgeFragment)this.b), ((CHARTLIST)this.c), ((AgeAdapter)this.d), this.e, view0);
                return;
            }
            case 1: {
                AgeAdapter.onBindViewImpl$lambda$3(((MelonChartAgeFragment)this.b), ((CHARTLIST)this.c), ((AgeAdapter)this.d), this.e, view0);
                return;
            }
            default: {
                Top100Adapter.d(((MelonChartPeriodFragment)this.b), ((ChartSongInfoBase)this.c), ((Top100Adapter)this.d), this.e, view0);
            }
        }
    }
}

