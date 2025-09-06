package com.iloen.melon.fragments.genre;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.net.v5x.response.GenreMenuDtlGnrsRes;

public final class r implements ErrorListener, Listener {
    public final GenreDetailPagerFragment a;

    public r(GenreDetailPagerFragment genreDetailPagerFragment0) {
        this.a = genreDetailPagerFragment0;
        super();
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        GenreDetailPagerFragment.fetchTabMenuInfo$lambda$4(this.a, volleyError0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        GenreDetailPagerFragment.fetchTabMenuInfo$lambda$3(this.a, ((GenreMenuDtlGnrsRes)object0));
    }
}

