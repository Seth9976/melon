package com.iloen.melon.fragments.artistchannel;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.net.v6x.response.ArtistMusicAlbumFilterListRes;

public final class b implements ErrorListener, Listener {
    public final ArtistDetailContentsAlbumFragment a;

    public b(ArtistDetailContentsAlbumFragment artistDetailContentsAlbumFragment0) {
        this.a = artistDetailContentsAlbumFragment0;
        super();
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        ArtistDetailContentsAlbumFragment.fetchFilterLevel1DataArray$lambda$9(this.a, volleyError0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        ArtistDetailContentsAlbumFragment.fetchFilterLevel1DataArray$lambda$8(this.a, ((ArtistMusicAlbumFilterListRes)object0));
    }
}

