package com.iloen.melon.fragments.melonchart;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v4x.common.ChartAlbumInfoBase;
import com.iloen.melon.net.v4x.common.ChartSongInfoBase;
import com.iloen.melon.net.v4x.response.AgeSongChartListRes.RESPONSE.CHARTLIST;

public final class i implements View.OnClickListener {
    public final int a;
    public final int b;
    public final Object c;
    public final Object d;

    public i(Object object0, Object object1, int v, int v1) {
        this.a = v1;
        this.c = object0;
        this.d = object1;
        this.b = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                AgeAdapter.onBindViewImpl$lambda$4(((MelonChartAgeFragment)this.c), ((CHARTLIST)this.d), this.b, view0);
                return;
            }
            case 1: {
                ArtistAdapter.onBindViewImpl$lambda$1(((MelonChartArtistFragment)this.c), ((com.iloen.melon.net.v4x.response.ArtistChartListRes.RESPONSE.CHARTLIST)this.d), this.b, view0);
                return;
            }
            case 2: {
                GenreAdapter.onBindViewImpl$lambda$5(((MelonChartGenreFragment)this.c), ((ChartSongInfoBase)this.d), this.b, view0);
                return;
            }
            case 3: {
                GenreAdapter.onBindViewImpl$lambda$7(((ChartAlbumInfoBase)this.c), ((MelonChartGenreFragment)this.d), this.b, view0);
                return;
            }
            case 4: {
                HotTracksSongAdapter.onBindViewImpl$lambda$5(((MelonChartHotTrackListFragment)this.c), ((com.iloen.melon.net.v5x.response.HotTrackRes.RESPONSE.HOTTRACKS.CHARTLIST)this.d), this.b, view0);
                return;
            }
            default: {
                Top100Adapter.e(((ChartSongInfoBase)this.c), ((MelonChartPeriodFragment)this.d), this.b, view0);
            }
        }
    }
}

