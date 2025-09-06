package com.iloen.melon.fragments.melontv.program;

import E8.g;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;

public final class s implements g, ErrorListener {
    public final TvProgramMoreVideoFragment a;

    public s(TvProgramMoreVideoFragment tvProgramMoreVideoFragment0) {
        this.a = tvProgramMoreVideoFragment0;
        super();
    }

    @Override  // E8.g
    public void b(int v) {
        TvProgramMoreVideoFragment.initScrollableAlyacFilter$lambda$9$lambda$8(this.a, v);
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        TvProgramMoreVideoFragment.request$lambda$12$lambda$11(this.a, volleyError0);
    }
}

