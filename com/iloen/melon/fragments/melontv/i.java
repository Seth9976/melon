package com.iloen.melon.fragments.melontv;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.net.v5x.response.MelonTvTodayPersonalContsRes;
import com.iloen.melon.net.v5x.response.MelonTvTodayRes;

public final class i implements ErrorListener, Listener {
    public final int a;
    public final MelonTvTodayFragment b;
    public final v9.i c;

    public i(MelonTvTodayFragment melonTvTodayFragment0, v9.i i0, int v) {
        this.a = v;
        this.b = melonTvTodayFragment0;
        this.c = i0;
        super();
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        MelonTvTodayFragment.fetchPersonalConts$lambda$3(this.b, this.c, volleyError0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        if(this.a != 0) {
            MelonTvTodayFragment.fetchToday$lambda$5(this.b, this.c, ((MelonTvTodayRes)object0));
            return;
        }
        MelonTvTodayFragment.fetchPersonalConts$lambda$2(this.b, this.c, ((MelonTvTodayPersonalContsRes)object0));
    }
}

