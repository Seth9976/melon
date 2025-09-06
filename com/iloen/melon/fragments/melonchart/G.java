package com.iloen.melon.fragments.melonchart;

import android.view.View.OnLongClickListener;
import android.view.View;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.net.v4x.common.ChartAlbumInfoBase;
import com.iloen.melon.net.v4x.common.ChartSongInfoBase;
import com.iloen.melon.net.v4x.response.AgeSongChartListRes.RESPONSE.CHARTLIST;
import com.melon.net.res.common.AlbumInfoBase;

public final class g implements View.OnLongClickListener {
    public final int a;
    public final int b;
    public final MelonChartBaseFragment c;
    public final AlbumInfoBase d;
    public final p e;

    public g(MelonChartBaseFragment melonChartBaseFragment0, AlbumInfoBase albumInfoBase0, p p0, int v, int v1) {
        this.a = v1;
        this.c = melonChartBaseFragment0;
        this.d = albumInfoBase0;
        this.e = p0;
        this.b = v;
        super();
    }

    @Override  // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view0) {
        switch(this.a) {
            case 0: {
                return AgeAdapter.onBindViewImpl$lambda$1(((MelonChartAgeFragment)this.c), ((CHARTLIST)this.d), ((AgeAdapter)this.e), this.b, view0);
            }
            case 1: {
                return GenreAdapter.onBindViewImpl$lambda$2(((MelonChartGenreFragment)this.c), ((ChartSongInfoBase)this.d), ((GenreAdapter)this.e), this.b, view0);
            }
            case 2: {
                return GenreAdapter.onBindViewImpl$lambda$8(((MelonChartGenreFragment)this.c), ((ChartAlbumInfoBase)this.d), ((GenreAdapter)this.e), this.b, view0);
            }
            default: {
                return HotTracksSongAdapter.onBindViewImpl$lambda$2(((MelonChartHotTrackListFragment)this.c), ((com.iloen.melon.net.v5x.response.HotTrackRes.RESPONSE.HOTTRACKS.CHARTLIST)this.d), ((HotTracksSongAdapter)this.e), this.b, view0);
            }
        }
    }
}

