package com.iloen.melon.fragments.melonchart;

import E8.g;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.iloen.melon.custom.J;
import com.iloen.melon.custom.S;

public final class c implements g, ErrorListener, J {
    public final MelonChartAgeFragment a;

    public c(MelonChartAgeFragment melonChartAgeFragment0) {
        this.a = melonChartAgeFragment0;
        super();
    }

    @Override  // com.iloen.melon.custom.J
    public void a(S s0, boolean z) {
        MelonChartAgeFragment.setAllCheckButtonVisibility$lambda$12(this.a, s0, z);
    }

    @Override  // E8.g
    public void b(int v) {
        MelonChartAgeFragment.onViewCreated$lambda$3$lambda$2(this.a, v);
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        MelonChartAgeFragment.onFetchStart$lambda$17(this.a, volleyError0);
    }
}

