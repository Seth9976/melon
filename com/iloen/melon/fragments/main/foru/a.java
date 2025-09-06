package com.iloen.melon.fragments.main.foru;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.fragments.MelonAdapterViewBaseFragment;

public final class a implements ErrorListener, Listener {
    public final MelonAdapterViewBaseFragment a;

    public a(MelonAdapterViewBaseFragment melonAdapterViewBaseFragment0) {
        this.a = melonAdapterViewBaseFragment0;
        super();
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        ForUTasteArtistFragment.onFetchStart$lambda$4(((ForUTasteArtistFragment)this.a), volleyError0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        ForUMixMakerKeywordPredictiveFragment.requestAutoComplete$lambda$2(((ForUMixMakerKeywordPredictiveFragment)this.a), object0);
    }
}

