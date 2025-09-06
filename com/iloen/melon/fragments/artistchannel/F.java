package com.iloen.melon.fragments.artistchannel;

import E8.g;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.custom.J;
import com.iloen.melon.custom.S;
import com.iloen.melon.net.v6x.response.ArtistMusicSongFilterListRes;

public final class f implements g, ErrorListener, Listener, J {
    public final int a;
    public final ArtistDetailContentsSongFragment b;

    public f(ArtistDetailContentsSongFragment artistDetailContentsSongFragment0, int v) {
        this.a = v;
        this.b = artistDetailContentsSongFragment0;
        super();
    }

    @Override  // com.iloen.melon.custom.J
    public void a(S s0, boolean z) {
        ArtistDetailContentsSongFragment.makeAllSelectAndOrderButton$lambda$5(this.b, s0, z);
    }

    @Override  // E8.g
    public void b(int v) {
        ArtistDetailContentsSongFragment.setScrollableAlyacView$lambda$2$lambda$1(this.b, v);
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        if(this.a != 1) {
            ArtistDetailContentsSongFragment.fetchFilterLevel1DataArray$lambda$17(this.b, volleyError0);
            return;
        }
        ArtistDetailContentsSongFragment.fetchSongList$lambda$20(this.b, volleyError0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        ArtistDetailContentsSongFragment.fetchFilterLevel1DataArray$lambda$16(this.b, ((ArtistMusicSongFilterListRes)object0));
    }
}

