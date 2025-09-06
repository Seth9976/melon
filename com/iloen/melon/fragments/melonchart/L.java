package com.iloen.melon.fragments.melonchart;

import E8.g;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.iloen.melon.fragments.MetaContentBaseFragment;

public final class l implements g, ErrorListener {
    public final int a;
    public final MetaContentBaseFragment b;

    public l(MetaContentBaseFragment metaContentBaseFragment0, int v) {
        this.a = v;
        this.b = metaContentBaseFragment0;
        super();
    }

    @Override  // E8.g
    public void b(int v) {
        ArtistAdapter.onCreateViewHolderImpl$lambda$0(((MelonChartArtistFragment)this.b), v);
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        if(this.a != 1) {
            MelonChartThemeFragment.onFetchStart$lambda$4(((MelonChartThemeFragment)this.b), volleyError0);
            return;
        }
        MelonChartArtistFragment.onFetchStart$lambda$4(((MelonChartArtistFragment)this.b), volleyError0);
    }
}

