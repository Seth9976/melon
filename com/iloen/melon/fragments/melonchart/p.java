package com.iloen.melon.fragments.melonchart;

import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.iloen.melon.net.v4x.response.UserActionsRes;
import com.iloen.melon.net.v5x.response.DailyAlbumChartListRes;
import com.iloen.melon.net.v5x.response.DailySongChartListRes;
import com.iloen.melon.net.v5x.response.HotTrackListRes;
import java.io.Serializable;
import java.util.ArrayList;
import v9.i;

public final class p implements Listener {
    public final int a;
    public final MelonChartBaseFragment b;
    public final Serializable c;
    public final Object d;

    public p(MelonChartBaseFragment melonChartBaseFragment0, Serializable serializable0, j0 j00, int v) {
        this.a = v;
        this.b = melonChartBaseFragment0;
        this.c = serializable0;
        this.d = j00;
        super();
    }

    public p(MelonChartBaseFragment melonChartBaseFragment0, i i0, String s, int v) {
        this.a = v;
        this.b = melonChartBaseFragment0;
        this.d = i0;
        this.c = s;
        super();
    }

    @Override  // com.android.volley.Response$Listener
    public final void onResponse(Object object0) {
        switch(this.a) {
            case 0: {
                MelonChartGenreFragment.requestDaySong$lambda$8(((MelonChartGenreFragment)this.b), ((String)this.c), ((GenreAdapter)this.d), ((DailySongChartListRes)object0));
                return;
            }
            case 1: {
                MelonChartArtistFragment.onReadyToFetchPartially$lambda$7(((MelonChartArtistFragment)this.b), ((ArrayList)this.c), ((j0)this.d), ((UserActionsRes)object0));
                return;
            }
            case 2: {
                MelonChartGenreFragment.requestDayAlbum$lambda$11(((MelonChartGenreFragment)this.b), ((i)this.d), ((String)this.c), ((DailyAlbumChartListRes)object0));
                return;
            }
            default: {
                MelonChartHotTrackListFragment.onFetchStart$lambda$18(((MelonChartHotTrackListFragment)this.b), ((i)this.d), ((String)this.c), ((HotTrackListRes)object0));
            }
        }
    }
}

