package com.iloen.melon.fragments.main.foru;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.net.v6x.response.ForuMixMakerMainRes;

public final class k implements ErrorListener, Listener {
    public final ForUMixMakerMainFragment a;

    public k(ForUMixMakerMainFragment forUMixMakerMainFragment0) {
        this.a = forUMixMakerMainFragment0;
        super();
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        ForUMixMakerMainFragment.onFetchStart$lambda$3(this.a, volleyError0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        ForUMixMakerMainFragment.onFetchStart$lambda$2(this.a, ((ForuMixMakerMainRes)object0));
    }
}

