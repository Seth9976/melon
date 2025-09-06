package com.iloen.melon.fragments.melonchart;

import E8.g;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.iloen.melon.custom.J;
import com.iloen.melon.custom.S;

public final class m implements g, ErrorListener, J {
    public final MelonChartGenreFragment a;

    public m(MelonChartGenreFragment melonChartGenreFragment0) {
        this.a = melonChartGenreFragment0;
        super();
    }

    @Override  // com.iloen.melon.custom.J
    public void a(S s0, boolean z) {
        MelonChartGenreFragment.setAllCheckButtonVisibility$lambda$5(this.a, s0, z);
    }

    @Override  // E8.g
    public void b(int v) {
        MelonChartGenreFragment.setFilterLayout$lambda$19(this.a, v);
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        MelonChartGenreFragment.responseErrorListener$lambda$22(this.a, volleyError0);
    }
}

