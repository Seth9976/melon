package com.iloen.melon.fragments.melonchart;

import E8.g;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.iloen.melon.custom.J;
import com.iloen.melon.custom.S;

public final class s implements g, ErrorListener, J {
    public final MelonChartHotTrackListFragment a;

    public s(MelonChartHotTrackListFragment melonChartHotTrackListFragment0) {
        this.a = melonChartHotTrackListFragment0;
        super();
    }

    @Override  // com.iloen.melon.custom.J
    public void a(S s0, boolean z) {
        MelonChartHotTrackListFragment.setAllCheckButtonVisibility$lambda$20(this.a, s0, z);
    }

    @Override  // E8.g
    public void b(int v) {
        MelonChartHotTrackListFragment.initAlyac$lambda$23(this.a, v);
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        MelonChartHotTrackListFragment.onFetchStart$lambda$19(this.a, volleyError0);
    }
}

