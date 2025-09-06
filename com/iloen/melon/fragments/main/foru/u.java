package com.iloen.melon.fragments.main.foru;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;

public final class u implements ErrorListener {
    @Override  // com.android.volley.Response$ErrorListener
    public final void onErrorResponse(VolleyError volleyError0) {
        ForUTasteArtistAdapter.fetchSimilarArtist$lambda$8(volleyError0);
    }
}

