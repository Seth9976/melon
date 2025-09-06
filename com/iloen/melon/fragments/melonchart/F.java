package com.iloen.melon.fragments.melonchart;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.net.v4x.common.ChartSongInfoBase;
import com.iloen.melon.net.v4x.response.AgeSongChartListRes.RESPONSE.CHARTLIST;
import com.melon.net.res.common.SongInfoBase;

public final class f implements View.OnClickListener {
    public final int a;
    public final int b;
    public final int c;
    public final MelonChartBaseFragment d;
    public final p e;
    public final SongInfoBase f;

    public f(MelonChartBaseFragment melonChartBaseFragment0, int v, p p0, int v1, SongInfoBase songInfoBase0, int v2) {
        this.a = v2;
        this.d = melonChartBaseFragment0;
        this.b = v;
        this.e = p0;
        this.c = v1;
        this.f = songInfoBase0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                AgeAdapter.onBindViewImpl$lambda$0(((MelonChartAgeFragment)this.d), this.b, ((AgeAdapter)this.e), this.c, ((CHARTLIST)this.f), view0);
                return;
            }
            case 1: {
                GenreAdapter.onBindViewImpl$lambda$1(((MelonChartGenreFragment)this.d), this.b, ((GenreAdapter)this.e), this.c, ((ChartSongInfoBase)this.f), view0);
                return;
            }
            default: {
                HotTracksSongAdapter.onBindViewImpl$lambda$1(((MelonChartHotTrackListFragment)this.d), this.b, ((HotTracksSongAdapter)this.e), this.c, ((com.iloen.melon.net.v5x.response.HotTrackRes.RESPONSE.HOTTRACKS.CHARTLIST)this.f), view0);
            }
        }
    }
}

